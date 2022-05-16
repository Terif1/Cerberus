package io.github.terif1.events

import com.google.inject.Inject
import com.velocitypowered.api.event.Subscribe
import com.velocitypowered.api.event.player.PlayerChatEvent
import com.velocitypowered.api.proxy.ProxyServer
import net.kyori.adventure.text.Component
import org.slf4j.Logger

class chat @Inject constructor(private val proxy: ProxyServer, private val logger: Logger) {
    @Subscribe
    fun chatOnAllServers(event : PlayerChatEvent){
        val player = event.player
        val message = event.message
        val server = player.currentServer
        if (message[0] != '/') {
           for (svr in  proxy.allServers){
               if (svr != server){
                 svr.sendMessage(Component.text(message.toString()))
                 logger.info(message.toString(), player.username)
               }
           }
        }
    }
}