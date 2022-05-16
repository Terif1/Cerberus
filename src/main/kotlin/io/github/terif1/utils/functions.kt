package io.github.terif1.utils

import java.io.File
import java.nio.file.Path



class Functions {
    fun loadconfig(pluginPath: Path) : File {
        val config = File(pluginPath.toFile(), "CerberusConfig.txt")
        if (config.length() < 5) {
            config.writeText(File("CerbarusConfigDefault.txt").inputStream().readBytes().toString())
        }
        return config

    }
    fun confoption(pluginPath : Path, option: String) : String {
        val config = loadconfig(pluginPath)
        var value = ""
        config.forEachLine() {
            if (it.contains('&')){
                val inde = it.indexOf(':')
                if (it.subSequence(1, (inde-1))==option) {
                    value =  it.substring(inde+1, it.length)
                }
            }
        }
        return value
    }
}