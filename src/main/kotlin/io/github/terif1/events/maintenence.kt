package io.github.terif1.events

import com.velocitypowered.api.event.Subscribe
import com.velocitypowered.api.event.player.ServerPreConnectEvent
import com.velocitypowered.api.plugin.annotation.DataDirectory
import io.github.terif1.utils.Functions
import net.kyori.adventure.text.Component
import java.io.File
import java.nio.file.Path

val functions = Functions()

class maintenence (@DataDirectory val direct : Path) {
    @Subscribe
    fun maintconnect(event: ServerPreConnectEvent)  {
        var returned = false
        val plr = event.player
        val svr = event.originalServer
        File("maint.txt").forEachLine(){ i ->
            if (i.contentEquals(svr.serverInfo.name)) {
                File("io.gitgub.terif1.localfiles.maintbypass.txt").forEachLine { pl ->
                    if (pl.contentEquals(plr.uniqueId.toString())) {
                        event.result = ServerPreConnectEvent.ServerResult.allowed(svr)
                        returned = true
                    }

                }
                if (returned == false){
                    event.result = ServerPreConnectEvent.ServerResult.denied()

                    var outmessage : String = functions.confoption(direct, "maintenceMessage")
                    plr.sendMessage(Component.text(outmessage))
                    //add a sound to play here when a player gets refused on the connection due to maintence, not done due to no clue how
                    returned = true
                }

            }
        }
        if (returned == false){
            event.result = ServerPreConnectEvent.ServerResult.allowed(svr)
        }

    }
}
