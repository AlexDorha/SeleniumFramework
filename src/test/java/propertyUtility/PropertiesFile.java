package propertyUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {

    public FileInputStream fileInputStream;
    public Properties properties;

    public PropertiesFile(String fileName){
        //specific in constructor ca fisierul sa fie gata pregatit pentru mine
        LoadFile(fileName);
    }

    //trebuie sa incarc fisierul
    public void LoadFile(String fileName){
        properties = new Properties();
        try {
            fileInputStream = new FileInputStream("src/test/resources/InputData/" + fileName + ".properties");
            properties.load(fileInputStream);
        }catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }

    //returneaza o valoare in functie de cheia specificata
    public String GetValueBasedONKey(String key){
        return properties.getProperty(key);
    }


}
