/**
 * 
 */
package com.hemebiotech.analytics;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
/**
 * Classe de démarrage de l'application 
 * @author missipssa
 *@version 1.0.0
 *
 */
public class Launcher {

	public static Properties readPropertiesFile(String fileName) throws IOException {
        FileInputStream fis = null;
        Properties prop = null;
        try {
            fis = new FileInputStream(fileName);
            // create Properties class object
            prop = new Properties();
            // load properties file into it
            prop.load(fis); 
        } catch (FileNotFoundException e) { 
            e.printStackTrace();
        } catch (IOException e) {e.printStackTrace();
        } finally {fis.close();}
 
        return prop;
    }
	
	public static void main(String[] args) throws IOException  {		

		Properties prop = readPropertiesFile("config.properties");
        //get the property value 
        // initialisation de l'objet AnalyticsCounter,
		AnalyticsCounter counter = new AnalyticsCounter();
    		
    	// Récupération des résultats de la méthode Count(String str)
    	Map<String,Integer> sympSorted = counter.Count(prop.getProperty("fileinput.path"));
    		
    	//initialisation de l'objet WriteSymptomDataFile 
    	WriteSymptomDataFile writer = new WriteSymptomDataFile();
    		
    	//Ecriture des résultats dans un fichier resultat.txt
    	writer.write(sympSorted,prop.getProperty("fileoutput.path"));

        } 	
}


