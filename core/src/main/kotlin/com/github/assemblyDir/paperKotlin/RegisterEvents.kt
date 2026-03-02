package com.github.assemblyDir.paperKotlin

import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

/**
 * Registers one or more event listeners for this plugin.
 *
 * @param listeners the [Listener] instances to register
 */
fun JavaPlugin.registerEvents(
    vararg listeners: Listener
) = listeners.forEach { listener ->
    server.pluginManager.registerEvents(listener, this)
}
