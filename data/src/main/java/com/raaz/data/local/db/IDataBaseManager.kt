package com.raaz.data.local.db

import com.raaz.data.Resource
import com.raaz.data.Root

interface IDataBaseManager {
    fun updateDB(apiData: Resource<List<Root>>, result:(Boolean) -> Unit)
}