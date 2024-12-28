package com.raaz.data.local.db

import android.content.Context
import android.util.Log
import com.raaz.data.Resource
import com.raaz.data.Root
import com.raaz.data.local.entity.UserEntity
import kotlinx.coroutines.runBlocking
import javax.inject.Inject


class DataBaseManager @Inject constructor(
    val context: Context,
    val dataBase: DataBase
): IDataBaseManager {

   override fun updateDB(apiData: Resource<List<Root>>, result:(Boolean) -> Unit) {
        runBlocking {
            val database = DataBase.getInstance(context)

            val dao = database.userDao()
            dao.deleteAll()
            Log.e("WorkScheduler","<>dowork ${apiData}")
            val dataBaseItems:ArrayList<UserEntity> = ArrayList()
            when (apiData){
                is Resource.Success -> {
                    val data = apiData.result as ArrayList
                    data.forEach {
                        dataBaseItems.add(UserEntity(it.id,it.name,it.email))
                    }
                    dao.insertAll(dataBaseItems)
                    result(true)
                }
                is Resource.Error -> {
                    result(false)
                }
            }
        }
    }
}