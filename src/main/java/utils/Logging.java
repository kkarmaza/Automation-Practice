package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.LogManager;

public class Logging {
    public static void getLogProperty(){
        try {
            FileInputStream file = new FileInputStream("src/main/resources/log.properties");
            LogManager.getLogManager().readConfiguration(file);
            file.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
