package game;


import java.io.FileWriter;
import java.io.IOException;

public class HighScoreWriter {
    private String fileName;

    public HighScoreWriter(String fileName) {
        this.fileName = fileName;
    }

    public void writeHighScore(String name, int score)
            throws IOException {// this feature in java helps avoid the whole program crashing
        boolean append = true; //means we are adding to file not overwriting nd forgetting last saved data
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName, append); //file writer object writes data to a file
            writer.write(name + "," + score + "\n");
        } finally { //will always run even if there's an error
            if (writer != null) { //meaning its open or still open then...
                writer.close(); //close writer
            }
        }
    }
}

