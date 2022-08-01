package eu.overnetwork.cmd.roles

import eu.overnetwork.core.Main
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.entities.Guild
import net.dv8tion.jda.api.entities.Member
import net.dv8tion.jda.api.entities.Role
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.interactions.DiscordLocale
import net.dv8tion.jda.internal.requests.Route.Roles

class Verify : ListenerAdapter() {
    var jda : JDA = Main().jda

    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        if (event.name == "verify") {
            val member : Member? = event.member
            var memberRole : Role? = jda.getRoleById("989851509686693908")
            var memberPB : String? = event.member?.avatarUrl
            var botPB : String? = jda.selfUser.avatarUrl
            val guild : Guild? = jda.getGuildById("863530982460489739")

            if (member != null) {
                if (member.roles.contains(memberRole)) {
                    return
                } else {
                    if (memberRole != null) {

                        val germanEmbed : EmbedBuilder = EmbedBuilder()
                        val englishUkEmbed : EmbedBuilder = EmbedBuilder()
                        val englishUsEmbed : EmbedBuilder = EmbedBuilder()
                        val frenchEmbed : EmbedBuilder = EmbedBuilder()
                        val spanishEmbed : EmbedBuilder = EmbedBuilder()
                        val unknownEmbed : EmbedBuilder = englishUsEmbed
                        val embedTitle : String = "Over-Network"
                        val embedTitleUrl : String = "https://over-network.eu"
                        val embedVerify : String = "Verify System"

                        germanEmbed.setTitle("$embedTitle", "$embedTitleUrl")
                        englishUkEmbed.setTitle("$embedTitle", "$embedTitleUrl")
                        englishUsEmbed.setTitle("$embedTitle", "$embedTitleUrl")
                        frenchEmbed.setTitle("$embedTitle", "$embedTitleUrl")
                        spanishEmbed.setTitle("$embedTitle", "$embedTitleUrl")
                        unknownEmbed.setTitle("$embedTitle", "$embedTitleUrl")

                        germanEmbed.setDescription("$embedVerify")
                        englishUkEmbed.setDescription("$embedVerify")
                        englishUsEmbed.setDescription("$embedVerify")
                        frenchEmbed.setDescription("$embedVerify")
                        spanishEmbed.setDescription("$embedVerify")
                        unknownEmbed.setDescription("$embedVerify")

                        germanEmbed.setThumbnail(memberPB)
                        englishUkEmbed.setThumbnail(memberPB)
                        englishUsEmbed.setThumbnail(memberPB)
                        frenchEmbed.setThumbnail(memberPB)
                        spanishEmbed.setThumbnail(memberPB)
                        unknownEmbed.setThumbnail(memberPB)

                        germanEmbed.addBlankField(true)
                        englishUkEmbed.addBlankField(true)
                        englishUsEmbed.addBlankField(true)
                        frenchEmbed.addBlankField(true)
                        spanishEmbed.addBlankField(true)
                        unknownEmbed.addBlankField(true)

                        germanEmbed.addField("Sie wurden erfolgreich verifiziert", "Bei fragen steht es ihnen offen den Support zu kontaktieren", true)
                        englishUkEmbed.addField("You have been successfully verified", "If you have any questions, please feel free to contact the support team.", true)
                        englishUsEmbed.addField("You have been successfully verified", "If you have any questions, please feel free to contact the support team.", true)
                        frenchEmbed.addField("Vous avez été vérifié avec succès", "Si vous avez des questions, n'hésitez pas à contacter le support.", true)
                        spanishEmbed.addField("Ha sido verificado con éxito", "Si tiene alguna pregunta, no dude en ponerse en contacto con el servicio de asistencia.", true)
                        unknownEmbed.addField("You have been successfully verified", "If you have any questions, please feel free to contact the support team.", true)

                        germanEmbed.setFooter("Mit freundlichen Grüßen Ihr Over-Network Team", botPB)
                        englishUkEmbed.setFooter("Sincerely yours Over-Network Team", botPB)
                        englishUsEmbed.setFooter("Sincerely yours Over-Network Team", botPB)
                        frenchEmbed.setFooter("Sincères salutations Votre équipe Over-Network", botPB)
                        spanishEmbed.setFooter("Atentamente, el equipo de Over-Network", botPB)
                        unknownEmbed.setFooter("Sincerely yours Over-Network Team", botPB)



                        when (event.userLocale) {
                            DiscordLocale.GERMAN -> event.replyEmbeds(germanEmbed.build())
                            DiscordLocale.ENGLISH_UK -> event.replyEmbeds(englishUkEmbed.build())
                            DiscordLocale.ENGLISH_US -> event.replyEmbeds(englishUsEmbed.build())
                            DiscordLocale.FRENCH -> event.replyEmbeds(frenchEmbed.build())
                            DiscordLocale.SPANISH -> event.replyEmbeds(spanishEmbed.build())
                            else -> {
                                event.replyEmbeds(unknownEmbed.build())
                            }
                        }

                        event.guild?.addRoleToMember(member, memberRole)
                    }
                }
            }
        }
    }
}
