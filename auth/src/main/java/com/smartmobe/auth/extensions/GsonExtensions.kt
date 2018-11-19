package com.smartmobe.auth.extensions

import com.google.gson.Gson
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

fun Gson.getType(rawClass: Class<*>, parameterClass: Class<*>): Type {
    return object : ParameterizedType {
        override fun getRawType(): Type {
            return rawClass
        }

        override fun getOwnerType(): Type? {
            return null
        }

        override fun getActualTypeArguments(): Array<Type> {
            return arrayOf(parameterClass)
        }
    }
}