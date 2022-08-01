package eu.overnetwork.cmd.roles

import eu.overnetwork.core.Main
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.entities.Member
import net.dv8tion.jda.api.entities.Role
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.interactions.DiscordLocale

class Statusmeldungen : ListenerAdapter() {

    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        if (event.name == "statusmeldungen") {
            val jda: JDA = Main().jda
            val member: Member? = event.member
            val statusRole: Role? = jda.getRoleById("987690891198234645")

            if (member != null) {
                if (member.roles.contains(statusRole)) {
                    // TODO send Embed if user already contains the role
                } else {
                    if (statusRole != null) {
                        // TODO send Embed if user not has the role
                    }
                }
            }

        }
    }
}