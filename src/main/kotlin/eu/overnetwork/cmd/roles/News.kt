package eu.overnetwork.cmd.roles

import eu.overnetwork.core.Main
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.entities.Member
import net.dv8tion.jda.api.entities.Role
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.interactions.DiscordLocale

class News : ListenerAdapter() {
    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        if(event.name == "news") {
            val jda : JDA = Main().jda
            val newsRole : Role? = jda.getRoleById("987690787074633738")
            val member : Member? = event.member

            if (member?.roles?.contains(newsRole) == false) {
                val hasRoleEmbedGerman: EmbedBuilder = EmbedBuilder()
                val hasRoleEmbedEnglishUK: EmbedBuilder = EmbedBuilder()
                val hasRoleEmbedEnglishUS: EmbedBuilder = EmbedBuilder()
                val hasRoleEmbedFrench: EmbedBuilder = EmbedBuilder()
                val hasRoleEmbedSpanish: EmbedBuilder = EmbedBuilder()
                val hasRoleEmbedUnknown: EmbedBuilder = EmbedBuilder()



                when (event.userLocale) {
                    DiscordLocale.GERMAN -> event.replyEmbeds(hasRoleEmbedGerman.build())
                    DiscordLocale.ENGLISH_UK -> event.replyEmbeds(hasRoleEmbedEnglishUK.build())
                    DiscordLocale.ENGLISH_US -> event.replyEmbeds(hasRoleEmbedEnglishUS.build())
                    DiscordLocale.FRENCH -> event.replyEmbeds(hasRoleEmbedFrench.build())
                    DiscordLocale.SPANISH -> event.replyEmbeds(hasRoleEmbedSpanish.build())
                    else -> {
                        event.replyEmbeds(hasRoleEmbedUnknown.build())
                    }
                }
            } else {
                val roleEmbedGerman: EmbedBuilder = EmbedBuilder()
                val roleEmbedEnglishUK: EmbedBuilder = EmbedBuilder()
                val roleEmbedEnglishUS: EmbedBuilder = EmbedBuilder()
                val roleEmbedFrench: EmbedBuilder = EmbedBuilder()
                val roleEmbedSpanish: EmbedBuilder = EmbedBuilder()
                val roleEmbedUnknown: EmbedBuilder = EmbedBuilder()
                val embedTitle: String = "Over-Network"
                val embedTitleUrl: String = "https://over-network.eu"

                when (event.userLocale) {
                    DiscordLocale.GERMAN -> event.replyEmbeds(roleEmbedGerman.build())
                    DiscordLocale.ENGLISH_UK -> event.replyEmbeds(roleEmbedEnglishUK.build())
                    DiscordLocale.ENGLISH_US -> event.replyEmbeds(roleEmbedEnglishUS.build())
                    DiscordLocale.FRENCH -> event.replyEmbeds(roleEmbedFrench.build())
                    DiscordLocale.SPANISH -> event.replyEmbeds(roleEmbedSpanish.build())
                    else -> {
                        event.replyEmbeds(roleEmbedUnknown.build())
                    }
                }
            }
        }
    }
}