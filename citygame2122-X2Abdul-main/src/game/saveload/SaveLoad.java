package game.saveload;

import game.Gamelevel.Game;
import game.Gamelevel.*;

import java.io.*;

public class SaveLoad {
    public SaveLoad() {

    }

    //Saves the game to the file
    public static void save(Gamelevel Gamelevel, String filename) throws IOException {

        boolean append = false;
        FileWriter writer = null;
        // writes the level name to the file
        try {
            writer = new FileWriter(filename, append);
            writer.write(Gamelevel.Getlevel() + "\n");
        }
        finally {
            if (writer != null) {
                writer.close();
            }
    }
}


        // Loads the saved level
        public static Gamelevel load(String file, Game g) throws IOException {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String level = "";
            //reads level name and loads that level
            try {
                String line = bufferedReader.readLine();
                System.out.println(line);
            } catch (IOException e) {
                System.out.println(e);
            }

            if (level.equals("level1")) {
                return new Level1(g);
            } else if (level.equals("level2")) {
                return new Level2(g);
            } else if (level.equals("level3")) {
                return new Level3(g);
            } else {
                return new Level4(g);
            }
        }


}

