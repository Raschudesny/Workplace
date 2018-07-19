package danilo.laks;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by ChUd0 on 04.07.2018.
 */

public class TryURL {
    public static void main(String[] args) {


       /* try {
            URL tryLoad = new URL("https://cdn.discordapp.com/attachments/461151165216981025/461192600435556363/myzyaka.mp3");
            System.out.println(tryLoad.getFile());
            System.out.println(tryLoad.getPath());
            ReadableByteChannel rbc = Channels.newChannel(tryLoad.openStream());
            FileOutputStream fos = new FileOutputStream("src/main/resources/sth.mp3");
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
