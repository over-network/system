package eu.overnetwork.events

import eu.overnetwork.core.Main
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.entities.Channel
import net.dv8tion.jda.api.entities.Member
import net.dv8tion.jda.api.entities.TextChannel
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class MemberJoin() : ListenerAdapter() {
    var jda : JDA = Main().jda

    override fun onGuildMemberJoin(event: GuildMemberJoinEvent) {
        val nickname : String? = event.member.nickname
        val channel : TextChannel? = jda.getTextChannelById("987700321155448872")
        val verify : String = "<#989851509686693908>"
        val userPB : String? = event.member.avatarUrl
        val botPB : String ? = jda.selfUser.avatarUrl
        var embed : EmbedBuilder = EmbedBuilder()

        embed.setTitle("Over-Network", "https://over-network.eu")
        embed.setDescription("Solltest du noch keinen Account haben kannst du dich unter https://panel.over-network.eu/register registrieren.")
        embed.setAuthor("")
        embed.addBlankField(true)
        embed.setThumbnail(userPB)
        embed.addField("Herzlich Willkommen $nickname", "Du bist nun dem Over-Network Discord Server beigreten, bitte verifizier dich unter $verify", false)
        embed.setFooter("Over-Network", botPB)
    }
}