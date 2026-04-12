package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HighScoreReader {
    private String fileName;

    public HighScoreReader(String fileName) {
        this.fileName = fileName;
    }

    public int readHighScore() throws IOException {
        int highScore = 0;
        FileReader fr = null;
        BufferedReader reader = null; //reads line of characters altogether rather than character by character
        try {
            System.out.println("Reading " + fileName + " ...");
            fr = new FileReader(fileName);
            reader = new BufferedReader(fr); //common to make a FileReader and then wrap it with a BufferedReader object
            String line = reader.readLine();
            while (line != null) {//while there is content to be read...
                String[] tokens = line.split(",");
                String name = tokens[0];
                int score = Integer.parseInt(tokens[1]); //converted into int for mathematical comparisons
                System.out.println("Name: " + name + ", Score: " + score);
                if (score > highScore) { //performs comparison
                    highScore = score; // keep track of highest
                }
                line = reader.readLine(); //next line
                System.out.println("...done.");
            }
        } finally {
            if (reader != null) reader.close(); //close buffered reader at the end then file reader
            if (fr != null) fr.close();
        }
        return highScore;
    }
}




