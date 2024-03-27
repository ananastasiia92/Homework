package Patterns.Homework.View;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogFile implements Logging{

    private final String pathFile;

    public LogFile(String pathFile) {
        this.pathFile = pathFile;
    }

    @Override
    public void writeMessage(String message) {
        File logFile = new File(pathFile);
        if (!logFile.exists()){
            try {
                logFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            FileWriter logFileWrite = new FileWriter(pathFile,true);
            logFileWrite.write(message+'\n');
            logFileWrite.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
