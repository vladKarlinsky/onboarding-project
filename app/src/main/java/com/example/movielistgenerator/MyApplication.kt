package com.example.movielistgenerator

import android.app.Application
import sdk.pendo.io.Pendo

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val pendoAppKey =
            "eyJhbGciOiJSUzI1NiIsImtpZCI6IiIsInR5cCI6IkpXVCJ9.eyJkYXRhY2VudGVyIjoidXMiLCJrZXkiOiJiZDJlNTM2Mjc3NDU1NzA0ZmI1N2UyYzBhMmU3N2U0NGQ0MWMxOTE1ZGE3YTJiMjQxMGIxYTJmOWVkMWE0YjNkNjRmYzgzN2FkNzhkMGIwZDQ5NjYwZDQ2YjNlMjExMzEyNDRhMmNiZjMwNDc4YmYxY2NhZTdlNmZiODE3NzI0ZjkwODg2ODRlYmYxMGIwMDI5ZGU3ZDFhOWVkM2MxMzdkLjQ4MjBjOTY1NTRiNDE3ZDBmNjZjNzJmMzQ1MmVlNGU1LmE1NWM4MTc3NDJjYWE3MmM4MjBjZjIwNWQwZjFhNjkwYzdhZDA5ZWU4MjNmOGY3YzBlZTVjYjBmMDM2ODc5N2YifQ.elh0zy4iquqz_PWmOi2Kcld3uBoS9G6dzpYwqtwjgPxDKw36Z_NoaQqsJONgXeGV4nJQ9iRdbrWprP8y9dwlCRnO4HoM2SAoRTHfhJgdk5IIHcVQdeJyLRVtChrf7w7ckdX6JOY0sL2vQo9QnWw1LVjP_gOphk_A_hnIt2PtgD4"

        Pendo.setup(
            this,
            pendoAppKey,
            null,
            null
        )
    }
}