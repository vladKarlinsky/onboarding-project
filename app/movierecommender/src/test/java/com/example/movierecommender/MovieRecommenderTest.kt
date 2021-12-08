package com.example.movierecommender

import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Test


class MovieRecommenderTest {

    @Test
    fun `Send request to API, expect thread to wait for response`() = runBlocking {
        val randomInput = "batman"
        val response = MovieRecommender.run(randomInput)
        assertNotNull(response)
    }

}