package filehandling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {

    //write to file , file directory, content
    public void writeToFile(String fileDirectory, String content) {
        try {
            File fileObj = new File(fileDirectory);
            FileWriter writerObj = new FileWriter(fileObj);
            if (fileObj.createNewFile()){
                writerObj.write(content);
                System.out.println("File created: " + fileObj.getName() + " and written to newly created file.");
            }
            else{
                System.out.println("File already exists. writing to file.");
                writerObj.write(content);
                writerObj.close();
                System.out.println("Successfully wrote to the file");
            }
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    //read from file , file directory, content to read




}