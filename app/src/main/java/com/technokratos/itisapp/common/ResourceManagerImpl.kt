package com.technokratos.itisapp.common

import android.content.Context

class ResourceManagerImpl(
    val context: Context
): ResourceManager {

    override fun getString(id: Int): String {
        return context.getString(id)
    }
}