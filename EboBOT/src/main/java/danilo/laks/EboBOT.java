package danilo.laks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.events.EventDispatcher;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.util.DiscordException;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;


/**
 * Created by ChUd0 on 24.06.2018.
 */
public class EboBOT {
    public static String myToken = "фыв";
    public static String botPrefix = "Андрюха, ";

    //Bot functionality
    public static IDiscordClient createClient(String token, boolean login) {
        ClientBuilder builder = new ClientBuilder();
        builder.withToken(token);
        try {
           if (login)
               return builder.login();
           else
               return builder.build();
           }
        catch(DiscordException de) {
            de.printStackTrace();
            return null;
        }

    }

    public static void sendMessage(IChannel channel, String msg)
    {
        channel.sendMessage(msg);
    }


    //music library
    private HashMap<String, URL> music;
    public EboBOT()
    {
        music = new HashMap<>();
    }
    public void addSong(String songName, URL songURL)
    {
        music.put(songName, songURL);
    }

    public URL getRandSong()
    {
        if(music.isEmpty())
            return null;
        Random generator = new Random();
        Object[] urls = music.values().toArray();
        Object randomValue = urls[generator.nextInt(urls.length)];
        return (URL)randomValue;
    }





    public static void main(String[] args) {
        IDiscordClient client = EboBOT.createClient(EboBOT.myToken, false);
        EventDispatcher dispatcher = client.getDispatcher();
        dispatcher.registerListener(new EventsMapper());
        client.login();


    }

}
