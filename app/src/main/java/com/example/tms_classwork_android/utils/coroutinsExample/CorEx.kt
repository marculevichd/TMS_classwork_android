package com.example.tms_classwork_android.utils.coroutinsExample

import android.util.Log
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*

class CorEx {

    fun testCorExample() {
        // пример работы не по порядку и по порядку
        CoroutineScope( CoroutineName ("tmslesson28") + Dispatchers.IO).launch {
            val job = launch {
                for (i in 1..5) {
                    Log.w("called", "$i")
                    delay(400)
                }
            }
            Log.w("Start", "started")
            job.join() // а тут по порядку т.к. ждет выполнения
            Log.w("End", "${coroutineContext[CoroutineName.Key]}")

        }
    }


    fun testCorExampleCansel() {
        CoroutineScope(Dispatchers.IO).launch {
            val job = launch {
                for (i in 1..5) {
                    Log.w("called", "$i")
                    delay(400)
                }
            }
            Log.w("Start", "started")
            job.cancel()
            Log.w("End", "finished")

        }
    }





}