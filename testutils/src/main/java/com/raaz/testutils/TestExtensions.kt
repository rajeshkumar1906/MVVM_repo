package com.raaz.testutils

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import io.mockk.clearMocks
import io.mockk.mockk
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.observers.TestObserver

fun <T> LiveData<T>.observeWithMock(): Observer<T> {
    val observer: Observer<T> = mockk(relaxed = true)
    this.observeForever(observer)
    return observer
}

fun <T> LiveData<T>.observeValues(): List<T> {
    val data: MutableList<T> = mutableListOf()
    observeForever { data.add(it) }
    return data
}

fun Any.clearInvocations() {
    clearMocks(this, answers = false, recordedCalls = true, childMocks = false, verificationMarks = true, exclusionRules = false)
}

fun <T> neverWithObserver(testObserver: TestObserver<Single<T>>): Single<T> =
    Single.never<T>().doOnSubscribe {
        testObserver.onSubscribe(it)
    }

fun neverWithObserver(testObserver: TestObserver<Completable>): Completable =
    Completable.never().doOnSubscribe {
        testObserver.onSubscribe(it)
    }

fun completeWithObserver(testObserver: TestObserver<Completable>): Completable =
    Completable.complete().doOnSubscribe {
        testObserver.onSubscribe(it)
    }
