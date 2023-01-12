package com.example.tms_classwork_android.utils

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController

object NavHelper {

    fun Fragment.navigate(destinationId: Int) {
        findNavController().navigate(destinationId)

    }

    fun Fragment.replaceGraph(graph: Int) {
        findNavController().navigate(graph)
    }

    fun Fragment.navigateWithDeleteBackStack(destinationId: Int, fragmetToRemove: Int){
        val navOptions = NavOptions.Builder().setPopUpTo(fragmetToRemove, true)
        findNavController().navigate(destinationId, null, navOptions.build())
    }

    fun Fragment.navigateWithBundle(destinationId: Int, bundle: Bundle){
        findNavController().navigate(destinationId, bundle)

    }
}

  