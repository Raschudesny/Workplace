package danilo.laks.SpringMapping;

import danilo.laks.Bot.EboBOT;
import danilo.laks.Bot.EventsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.events.Event;
import sx.blah.discord.api.events.EventDispatcher;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.handle.obj.IVoiceChannel;
import sx.blah.discord.util.audio.AudioPlayer;

import javax.annotation.PostConstruct;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class URLcontroller {

    private IDiscordClient client;
    private EventDispatcher dispatcher;

    @Autowired
    private EventsMapper eventsMapper;

    @PostConstruct
    public void botInitialization()
    {
        client = EboBOT.createClient(EboBOT.myToken, false);
        dispatcher = client.getDispatcher();
        dispatcher.registerListener(eventsMapper);
        client.login();

    }

    @RequestMapping(
            path = "csgo",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> csgoStateChange(@RequestBody Map<String, Object> payload)
    {
        LinkedHashMap roundStatus;
        System.out.println("We get = " + payload.toString());
        if(payload.containsKey("round"))
            roundStatus = (LinkedHashMap) payload.get("round");
        else
            return new ResponseEntity<String>( HttpStatus.OK);

        String currentRoundState;
        if(roundStatus.containsKey("phase"))
            currentRoundState = roundStatus.get("phase").toString();
        else
            return new ResponseEntity<String>( HttpStatus.OK);

        if(currentRoundState.equals(new String("over")))
        {
            List<IGuild> guilds = client.getGuilds();
            for (IGuild guild : guilds )
            {
                IVoiceChannel botVoiceChannel = client.getOurUser().getVoiceStateForGuild(guild).getChannel();
                if (botVoiceChannel == null) {
                    continue;
                }
                EboBOT bot = eventsMapper.getBot();

                if(bot.getPlayer() == null)
                    bot.setPlayer(AudioPlayer.getAudioPlayerForGuild(guild));
                else
                    bot.getPlayer().clear();

                File newSong = bot.getRandSong();
                if (newSong == null) {
                    continue;
                }
                try {
                    bot.getPlayer().queue(newSong);
                }
                catch (IOException e) {
                    e.printStackTrace();
                } catch (UnsupportedAudioFileException e) {
                    e.printStackTrace();
                }
            }
        }
        return  new ResponseEntity<String>( HttpStatus.OK);
    }


    @RequestMapping(
            path = "check",
            method = RequestMethod.GET,
            produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public ResponseEntity<String> check()
    {
        String x = "working....";
        ResponseEntity resp = ResponseEntity.ok().body(x);
        return  resp;
    }


}
