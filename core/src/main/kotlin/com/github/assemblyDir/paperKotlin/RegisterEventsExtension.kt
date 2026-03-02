package com.github.assemblyDir.paperKotlin

import org.bukkit.event.Listener
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.PluginManager
import org.bukkit.plugin.java.JavaPlugin

/**
 * Registers one or more event listeners.
 *
 * @receiver Your [JavaPlugin] instance
 * @param listeners the [Listener] instances to register
 */
fun JavaPlugin.registerEvents(
    vararg listeners: Listener
) = server.pluginManager.registerEvents(this, *listeners)

/**
 * Registers one or more event listeners.
 *
 * @receiver Your [PluginManager] instance
 * @param listeners the [Listener] instances to register
 */
fun PluginManager.registerEvents(
    plugin: Plugin,
    vararg listeners: Listener
) = listeners.forEach { listener ->
    registerEvents(listener, plugin)
}

/**
 * Registers one or more event listeners for the given plugin.
 *
 * @receiver [PluginManager] instance
 * @param plugin [Plugin] instance
 * @param listeners Iterable of [Listener] instances to register
 */
fun PluginManager.registerEvents(
    plugin: Plugin,
    listeners: Iterable<Listener>
) = listeners.forEach { listener ->
    registerEvents(listener, plugin)
}
