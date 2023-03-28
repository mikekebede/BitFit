package com.example.bitfitapplication

import android.app.Application

class bitfitApplication : Application() {
    val db by lazy { AppDatabase.getInstance(this) }
}