package com.theapphideaway.jsonparsingtest.networking

import com.theapphideaway.jsonparsingtest.model.Items
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface WebInterface {

    @GET("/todos")
    fun getToDoItems(): Deferred<List<Items>>
}