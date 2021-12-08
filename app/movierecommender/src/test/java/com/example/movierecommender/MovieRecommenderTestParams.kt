package com.example.movierecommender

import junit.framework.Assert.assertEquals
import junitparams.JUnitParamsRunner
import junitparams.Parameters
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.IndexOutOfBoundsException
import java.lang.RuntimeException

@RunWith(JUnitParamsRunner::class)
class MovieRecommenderTestParams {

    fun legalInputs() = arrayOf(
        arrayOf("BATMAN"),
        arrayOf("batman"),
        arrayOf("BaTmAn"),
        arrayOf(" batman"),
        arrayOf("batman "),
        arrayOf(" batman "),

    )

    fun illegalInputs() = arrayOf(
        arrayOf("fakjsdhfk"),
        arrayOf("12312378237412873"),
        arrayOf("!@#$%^&*()-=+_"),
        arrayOf(" ")
    )

    @Test
    @Parameters(method = "legalInputs")
    fun `Send different requests with various inputs expect valid list of movies returned` (input: String) = runBlocking {
        MovieRecommender.run(input)
    }

    @Test(expected = IndexOutOfBoundsException::class)
    @Parameters(method = "illegalInputs")
    fun `Send different requests with various inputs expect exceptions` (input: String) = runBlocking {
        MovieRecommender.run(input)
    }

    fun toBeProcessedInputs() = arrayOf(
        arrayOf("input "),
        arrayOf(" input"),
        arrayOf(" input ")
    )

    @Test
    @Parameters(method = "toBeProcessedInputs")
    fun `Send various inputs to preProcessInput, expect the trimmed & processed input returned` (input : String){
        assertEquals(MovieRecommender.preProcessInput(input),"input")
    }
}