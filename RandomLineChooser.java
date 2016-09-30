// RandomLineChooser

import java.io.RandomAccessFile;
import java.util.Random;

import java.io.IOException;
import java.net.MalformedURLException;
import java.io.FileNotFoundException;

public class RandomLineChooser {
public static String main(){
        String filePath = WordListPath.filePath;
        //Chooses a randome line and returns it as a string.
        //https://stackoverflow.com/questions/2218005/how-to-get-a-random-line-of-a-text-file-in-java
        RandomAccessFile file;
        try {
                file = new RandomAccessFile(filePath, "r"); // instantiate the words file as a RandomAccessFile with read permissions.
                try {
                        int rnd = Math.abs(new Random().nextInt(10000000)); // although this dosent need an upper bound it makes each attempt to find a word more likly and the progam as a whole faster. make the upper bound something larger than file but not so large I only get null returns
                        // Small files take a long time because so often the line is null
                        file.seek(rnd); // seek to the random posistion, nearly always in the middle of a line(word). this also mean the first line can never be choosen
                        file.readLine(); // read that line so the pointer is at the begining of the next line
                        String line = file.readLine(); // read the next line (a complete word this time)
                        if (line != null) {
                                // only return the word if its not a null value (null values happen whenever the random location is past the end of the file)
                                return line;
                        }
                } catch (IOException ioe) {
                        ioe.printStackTrace();
                } finally {
                        try{
                                file.close();
                        } catch (IOException ioe) {
                                ioe.printStackTrace();
                        } finally {

                        }
                }
        } catch (FileNotFoundException fnfe) {
                System.out.println("'" + filePath + "' path for 'RandomAccessFile file' is invalid");
                fnfe.printStackTrace();
        } finally {
        }
        return null;

}
}
