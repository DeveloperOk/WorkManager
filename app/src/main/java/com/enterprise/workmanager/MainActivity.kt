package com.enterprise.workmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.enterprise.workmanager.ui.theme.WorkManagerTheme
import java.util.concurrent.TimeUnit

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val constraints = Constraints.Builder()
            //.setRequiredNetworkType(NetworkType.CONNECTED)
            //.setRequiresBatteryNotLow(true)
            //.setRequiresStorageNotLow(true)
            //.setRequiresCharging(true)
            //.setRequiresDeviceIdle(true)
            .build()

        val appFeatureWorker = PeriodicWorkRequest.Builder(
            AppFeatureWorker::class.java, 15, TimeUnit.MINUTES)
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(this).enqueue(appFeatureWorker)

        setContent {
            WorkManagerTheme {

                //Medium post
                //https://medium.com/@appdevinsights/work-manager-android-6ea8daad56ee

                CountDownLatchApp()

            }
        }
    }
}

@Composable
fun CountDownLatchApp() {

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxSize().background(color = Color.Green)){

        Scaffold(modifier = Modifier.systemBarsPadding().fillMaxSize()) { innerPadding ->

            Column(horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(innerPadding).fillMaxSize()
                    .background(color = Color.White)){

                Text(text = stringResource(id = R.string.main_acitivity_work_manager_message))

            }

        }

    }

}