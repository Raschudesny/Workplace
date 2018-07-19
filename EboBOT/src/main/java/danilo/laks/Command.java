package danilo.laks;

import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

import java.util.List;

/**
 * Created by ChUd0 on 25.06.2018.
 */
public interface Command
{
    void runCommand(MessageReceivedEvent event);

}
