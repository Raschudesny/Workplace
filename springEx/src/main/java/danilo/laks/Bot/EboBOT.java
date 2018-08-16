package danilo.laks.Bot;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.events.EventDispatcher;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.audio.AudioPlayer;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


@Service
public class EboBOT {

    private ArrayList<File> playlist;
    private AudioPlayer player;

    public static final String myToken = "";
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
        playlist = listFolderFiles(new File("music"));
        System.out.println("Complete bot creation");
    }

    public File getRandSong()
    {
        if(playlist.isEmpty())
            return null;
        Random generator = new Random();
        int randIndex = generator.nextInt(playlist.size());
        return playlist.get(randIndex);
    }

    public ArrayList<File> listFolderFiles(File folder) {
        ArrayList<File> filesList = new ArrayList<File>();
        for (File file : folder.listFiles()) {
            if (file.isDirectory()) {
                filesList.addAll(listFolderFiles(file));
            } else {
                filesList.add(file);
            }
        }
        return filesList;
    }

    public AudioPlayer getPlayer() {
        return player;
    }

    public void setPlayer(AudioPlayer player) {
        this.player = player;
    }
}
