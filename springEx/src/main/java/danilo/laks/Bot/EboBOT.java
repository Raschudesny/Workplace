package danilo.laks.Bot;

import org.springframework.stereotype.Service;
import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.events.EventDispatcher;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.util.DiscordException;

import java.net.URL;
import java.util.HashMap;
import java.util.Random;



public class EboBOT {
    //music library
    private HashMap<String, URL> music;

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


    public static final String myToken = "NDYwNDQwNzM4Njc3OTE1NjU5.DjLnvQ.WtxxLWadBJWDkEsIUD5rD6yAw00";
    public static final String botPrefix = "Андрюха, ";

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



    public EboBOT()
    {
        System.out.println("Init BOT creation");
        music = new HashMap<>();
        System.out.println("Complete bot creation");

    }




}
