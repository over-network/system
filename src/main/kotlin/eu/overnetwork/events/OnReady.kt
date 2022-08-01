package eu.overnetwork.events

import eu.overnetwork.cmd.roles.News
import eu.overnetwork.cmd.roles.Statusmeldungen
import eu.overnetwork.cmd.roles.Verify
import eu.overnetwork.core.Main
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.OnlineStatus
import net.dv8tion.jda.api.entities.Activity
import net.dv8tion.jda.api.entities.Guild
import net.dv8tion.jda.api.events.ReadyEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.interactions.DiscordLocale
import net.dv8tion.jda.api.interactions.commands.DefaultMemberPermissions
import net.dv8tion.jda.api.interactions.commands.build.Commands

open class OnReady : ListenerAdapter() {


    override fun onReady(event: ReadyEvent) {
        val jda : JDA = Main().jda
        val guild : Guild? = jda.getGuildById("863530982460489739")

        println("Registering Application (/) Commands")

        guild?.updateCommands()?.addCommands(
            Commands.slash("verify", "adds yourself into the Member group")
                .setDescriptionLocalization(DiscordLocale.GERMAN, "fügt dich selbst in die Gruppe Member ein")
                .setDescriptionLocalization(DiscordLocale.ENGLISH_UK, "adds yourself into the Member group")
                .setDescriptionLocalization(DiscordLocale.ENGLISH_US, "adds yourself into the Member group")
                .setDescriptionLocalization(DiscordLocale.FRENCH, "s'ajoute au groupe des membre")
                .setDescriptionLocalization(DiscordLocale.SPANISH, "se añade al grupo de miembro")
                .setDescriptionLocalization(DiscordLocale.UNKNOWN, "adds yourself into the Member group")
                .setDefaultPermissions(DefaultMemberPermissions.ENABLED),
            Commands.slash("news", "adds yourself into the group News")
                .setDescriptionLocalization(DiscordLocale.GERMAN, "fügt dich selbst in die Gruppe News ein")
                .setDescriptionLocalization(DiscordLocale.ENGLISH_UK, "adds yourself into the group News")
                .setDescriptionLocalization(DiscordLocale.ENGLISH_US, "adds yourself into the group News")
                .setDescriptionLocalization(DiscordLocale.FRENCH, "s'ajoute au groupe nouvelles")
                .setDescriptionLocalization(DiscordLocale.SPANISH, "se añade al grupo noticias")
                .setDescriptionLocalization(DiscordLocale.UNKNOWN, "adds yourself into the group News")
                .setDefaultPermissions(DefaultMemberPermissions.ENABLED),
            Commands.slash("statusmeldungen", "")
        )
        println("Completed without complications")

        println("Registering Listeners")

        jda.addEventListener(MemberJoin::class)
        jda.addEventListener(Verify::class)
        jda.addEventListener(News::class)
        jda.addEventListener(Statusmeldungen::class)

        println("Completed without complications")
        println("start oven, and then we can start")

        jda.presence.setPresence(OnlineStatus.DO_NOT_DISTURB, Activity.watching("installation progress"))
    }
}