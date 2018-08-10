package danilo.laks.Bot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.ReadyEvent;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.handle.obj.IVoiceChannel;
import sx.blah.discord.util.audio.AudioPlayer;


import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ChUd0 on 24.06.2018.
 */


public class EventsMapper {

    private Map<String , Command>  commandMapping;

    private EboBOT bot;

    public EboBOT getBot()
    {
        return  bot;
    }



    public EventsMapper()
    {
        System.out.println("made MAPPER");
        bot = new EboBOT();

        commandMapping = new HashMap<>();

        //check test
        commandMapping.put("у нас труп", (event) -> {
            EboBOT.sendMessage(event.getChannel(), "По коням " );
        });


        commandMapping.put("поставь музяку", (event) -> {
            IVoiceChannel botVoiceChannel = event.getClient().getOurUser().getVoiceStateForGuild(event.getGuild()).getChannel();
            if (botVoiceChannel == null) {
                EboBOT.sendMessage(event.getChannel(), "Музыка не играла и фраер не танцевал (позови меня на канал сука)");
                return;
            }
            if(bot.getPlayer() == null)
                bot.setPlayer(AudioPlayer.getAudioPlayerForGuild(event.getGuild()));
            else
                bot.getPlayer().clear();

            File newSong = bot.getRandSong();
            if (newSong == null) {
                EboBOT.sendMessage(event.getChannel(), "У меня пока нету музла для братвы");
                return;
            }
            try {
                bot.getPlayer().queue(newSong);
            }
            catch (IOException e) {
                e.printStackTrace();
                EboBOT.sendMessage(event.getChannel(), "Я наебнулся =) (IO) ");
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
                EboBOT.sendMessage(event.getChannel(), "Я всё равно наебнулся =) (unsupported file) ");
            }
        });

        commandMapping.put("залезай сюда", (event) -> {
            IVoiceChannel userVoiceChannel = event.getAuthor().getVoiceStateForGuild(event.getGuild()).getChannel();

            if(userVoiceChannel == null) {
                EboBOT.sendMessage(event.getChannel(), "прежде чем приглашать в хату, сам в неё зайди, фраер");
                return;
            }
            userVoiceChannel.join();
        });

        commandMapping.put("съеби с канала", (event) -> {
            IVoiceChannel botVoiceChannel = event.getClient().getOurUser().getVoiceStateForGuild(event.getGuild()).getChannel();
            if(botVoiceChannel == null) {
                EboBOT.sendMessage(event.getChannel(), "прежде чем выгонять с хаты, сам в неё зайди, фраер");
                return;
            }
            botVoiceChannel.leave();
        });

        commandMapping.put("ухади", (event) -> {
            System.exit(0);
        });


    }


    @EventSubscriber
    public void onReadyEvent(ReadyEvent event) {
        System.out.println("Bot correctly connected to channel");
    }



    //checks if message contains in commandlist
    @EventSubscriber
    public void onMessageReceivedEvent(MessageReceivedEvent MRevent) {
        IMessage message =  MRevent.getMessage();
        String content = message.getContent();
        if(content.startsWith(EboBOT.botPrefix)) {
            String command = content.substring(EboBOT.botPrefix.length()).trim();
            if(commandMapping.containsKey(command))
            {
                commandMapping.get(command).runCommand(MRevent);
            }
        }

    }

}