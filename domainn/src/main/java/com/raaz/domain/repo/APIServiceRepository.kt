package com.raaz.domain.repo

import android.content.Context
import android.util.Log
import com.raaz.data.Resource
import com.raaz.data.local.db.DataBase
import com.raaz.data.local.entity.UserEntity
import com.raaz.data.Root
import com.raaz.domain.repository.APIService
import javax.inject.Inject

class APIServiceRepository @Inject constructor(
    private val apiService: APIService,
    val context: Context,
    private val dataBase: DataBase
) {
    private var apiData:ArrayList<Root> = ArrayList()

    suspend fun getApiData(): Resource<List<Root>> =
        try {
             val response = checkDataState()
            Resource.Success(response)
        } catch (exception: Exception){
             Resource.Error(exception)
        }

    private suspend fun checkDataState(): ArrayList<Root> {
        val dao = dataBase.userDao()
        val data = dao.getAll()
        val dataBaseItems:ArrayList<UserEntity> = ArrayList()
        when(data.isEmpty()) {
            true -> {
                Log.e("Repo","calling API")
                apiData = apiService.getDetails() as ArrayList
                apiData.forEach {
                    dataBaseItems.add(UserEntity(it.id,it.name,it.email))
                }
                dao.insertAll(dataBaseItems)
            }
            false -> {
                Log.e("Repo","calling Database")
                data.forEach {
                    apiData.add(Root(it.userId,it.name,it.email))
                }
            }
        }
        return apiData
    }


    suspend fun getDataFromDB(): DataBase {
       return dataBase
    }
}