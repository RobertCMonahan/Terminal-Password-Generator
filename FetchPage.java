// fetchPage

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
public class FetchPage {
public static void main(String urlString, String outFilename, Boolean consolePrint){
        // Takes 3 Args, two strings as and a Boolean,
        // arg1 is the url you want to fetch,
        // arg2 is the filename of the file it creates where the html is stored,
        // arg3 is a Boolean of wether or not everything should be printed to the console.
        try{
                URL url = new URL(urlString);
                BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outFilename));
                String line;
                while ((line = reader.readLine()) != null ) {
                        if (consolePrint == true) {
                                System.out.println(line);
                        }
                        writer.write(line);
                        writer.newLine();
                }
                reader.close();
                writer.close();
                System.out.println(outFilename + " created");
        } catch (MalformedURLException mue) {
                mue.printStackTrace();
        } catch (IOException ioe) {
                ioe.printStackTrace();
        } finally {}
}
}
