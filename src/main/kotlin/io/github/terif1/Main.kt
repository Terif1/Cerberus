package io.github.terif1

import com.google.inject.Inject
import com.velocitypowered.api.event.Subscribe
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent
import com.velocitypowered.api.event.proxy.ProxyShutdownEvent
import com.velocitypowered.api.plugin.Plugin
import com.velocitypowered.api.proxy.ProxyServer
import org.slf4j.Logger

@Plugin(
    id = "Cerberus",
    name = "Cerberus",
    version = "1.0",
    description = "Velocity utils for Sigma Draconis MC",
    authors = ["Terif"]
)
class Main @Inject constructor(private val server: ProxyServer, private val logger: Logger) {
    init {
        logger.info("Cerberus is watching...ALWAYS WATCHING")
    }
    @Subscribe
    fun proxyOn(event : ProxyInitializeEvent ){
        logger.info("Cerberus plugin enabled")
    }
    fun proxyOff(event:ProxyShutdownEvent){
        logger.info("Cerberus offline")
    }
}