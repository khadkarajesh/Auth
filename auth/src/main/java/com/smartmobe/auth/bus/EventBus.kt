package com.smartmobe.auth.bus

import android.os.Handler
import android.os.Looper

import com.squareup.otto.Bus

/**
 * A singleton instance of Otto Event bus to act as common Bus for entire application
 */
object EventBus {
    private var eventBus: Bus? = null

    private val bus: Bus
        get() {
            if (eventBus == null) {
                eventBus = MainThreadBus()
            }
            return eventBus!!
        }

    /**
     * Wrapper method to register event
     */
    fun register(event: Any) {
        bus.register(event)
    }

    /**
     * Wrapper method to unregister event
     */
    fun unregister(event: Any) {
        bus.unregister(event)
    }

    /**
     * Wrapper method to post event
     */
    fun post(event: Any) {
        bus.post(event)
    }

    class MainThreadBus : Bus() {
        private val handler = Handler(Looper.getMainLooper())

        override fun post(event: Any) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                super.post(event)
            } else {
                handler.post { super@MainThreadBus.post(event) }
            }
        }
    }
}
