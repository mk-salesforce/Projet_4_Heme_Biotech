package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
/**
 * Classe permettant d'écrire les resultats dans un fichier .txt
 * @author missipssa
 *
 */
public class WriteSymptomDataFile {
	/**
	 * Constructor
	 */
	public WriteSymptomDataFile() {}
	
	public void write(Map<String,Integer> res, String path )  {
		FileWriter writer = null;
		try {
			writer = new FileWriter (path);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (String key : res.keySet()) {
			try {
				writer.write(key + " = " + res.get(key) + "\n") ;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				writer.write("------------------- \n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}        
	    try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


