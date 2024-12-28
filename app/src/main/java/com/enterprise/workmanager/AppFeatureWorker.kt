package com.enterprise.workmanager

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.work.Worker
import androidx.work.WorkerParameters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.concurrent.thread


class AppFeatureWorker(val appContext: Context, workerParams: WorkerParameters)
    : Worker(appContext, workerParams) {

    val TAG =  "AppFeatureWorker"

    override fun doWork(): Result {
        try {
            handleLogic()
        } catch (e: Exception) {
            e.printStackTrace()
            return Result.failure()
        }

        // Indicate whether the task done successfully
        return Result.success()
    }


    fun handleLogic(){

        GlobalScope.launch(Dispatchers.IO) {

            Log.d(TAG, "Worker runs")

        }

    }



}