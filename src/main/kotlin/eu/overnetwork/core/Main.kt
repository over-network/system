package eu.overnetwork.core

import eu.overnetwork.events.MemberJoin
import eu.overnetwork.events.OnReady
import io.github.cdimascio.dotenv.Dotenv
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder

class Main {

   open val dotenv : Dotenv = Dotenv.load()
    open lateinit var jda : JDA

    fun main(args: Array<String>) {
        jda = JDABuilder.createDefault(dotenv["TOKEN"]).build()
        jda.addEventListener(OnReady::class)
    }
}