import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileUtils {

    static Object loadGame(String fileName){
        Object retObj = null;


        try {
            ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(fileName));

            try {
                retObj = objIn.readObject();

                objIn.close();
            } catch (ClassNotFoundException e) {
                System.out.println("Class not found!");
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return retObj;
    }


    static void saveObject(String fileName, Object objectToSave){
        System.out.println("Saving object to file " + fileName);
        try {
            FileOutputStream outStream = new FileOutputStream(fileName);
            ObjectOutputStream objOutStream = new ObjectOutputStream(outStream);

            objOutStream.writeObject(objectToSave);

            objOutStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
