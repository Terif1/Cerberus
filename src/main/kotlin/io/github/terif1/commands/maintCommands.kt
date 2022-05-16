package io.github.terif1.commands

import com.velocitypowered.api.command.SimpleCommand

class maintCommands : SimpleCommand {
    override fun execute(invocation: SimpleCommand.Invocation?) {
        val source = invocation.?source()
    }
}