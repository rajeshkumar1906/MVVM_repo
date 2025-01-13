package com.raaz.testutils.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

/**
 * Runs a given code concurrently while this Flow is being collected.
 *
 * @param onError Defines how errors in the concurrent code should be handled. Default: [ErrorHandling.Rethrow]
 */
fun <T> Flow<T>.launchWhenCollected(
    onError: ErrorHandling = ErrorHandling.Rethrow,
    block: suspend () -> Unit,
): Flow<T> {
    lateinit var scope: CoroutineScope

    return this
        .onStart {
            scope = CoroutineScope(Job())

            val rethrow = { error: Throwable -> throw error }
            scope.launch {
                try {
                    block()
                } catch (error: Throwable) {
                    when (onError) {
                        ErrorHandling.None -> ""
                        ErrorHandling.Rethrow -> rethrow(error)
                        is ErrorHandling.Handler -> onError.handle(error, rethrow)
                        else -> error("Unsupported onError value: $onError")
                    }
                }
            }
        }
        .onCompletion {
            println("Scope canceled")
            scope.cancel()
        }
}

sealed class ErrorHandling {
    /**
     * Ignore the error completely.
     */
    object None : ErrorHandling()

    /**
     * Rethrows the error on the original collected flow.
     */
    object Rethrow : ErrorHandling()

    /**
     * Define a custom error handler.
     */
    class Handler(
        val handle: (error: Throwable, rethrow: (Throwable) -> Unit) -> Unit,
    ) : ErrorHandling()
}
