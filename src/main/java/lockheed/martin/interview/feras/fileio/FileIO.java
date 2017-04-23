package lockheed.martin.interview.feras.fileio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class FileIO {

    public static String saveChanges(String fileName, HashMap<String, String> correctedWords) {
        try {

            Path path = Paths.get(fileName);
            Charset charset = StandardCharsets.UTF_8;
            String content = new String(Files.readAllBytes(path), charset);
            for (Entry<String, String> entry : correctedWords.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                content = content.replaceAll(key, value);
            }

            Files.write(path, content.getBytes(charset));

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "SUCCESS";
    }

    public static ArrayList<String> read(File file) {
        ArrayList wordsList = new ArrayList<String>();
        try {
            // BufferedReader in = new BufferedReader(new
            // FileReader("<Filename>"));
            Scanner in = new Scanner(file);
            while (in.hasNext()) {
                wordsList.add(in.next());

            }
            in.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return wordsList;

    }

}
