package danilo.laks.Bot;

import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

public interface Command {
    void runCommand(MessageReceivedEvent event);
}
