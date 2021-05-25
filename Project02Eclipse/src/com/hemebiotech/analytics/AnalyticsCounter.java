package com.hemebiotech.analytics;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


/** classe  calculant le nombre d'occurence de chaque symptome
 * 
 * @author missipssa
 *
 */
public class AnalyticsCounter {

	
	Map<String, Integer> Symptom = new HashMap<>();
	
	/**
	 * Constructeur de la classe
	 */
	public AnalyticsCounter() {}
	
	/**
	 * @param path a full or partial path to file with symptom strings in it, one per line
	 * Calcul de nombre d'occurence de chaque symptome
	 * @return a sorted map with occurrence of each symptom
	 * 
	 */
	public Map<String,Integer> Count(String path) {		
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile(path);
		List<String> result = new ArrayList<String>(reader.GetSymptoms());
		
		for(int i = 0; i< result.size();i++) {		
			String tmp = result.get(i) ;
			if ( Symptom.containsKey(tmp)){
				Symptom.replace(tmp, Symptom.get(tmp),Symptom.get(tmp) +1 );				
			}else{
				Symptom.put(tmp, 1);
			}		
		}	
		Map<String,Integer> sortedMap = new TreeMap<String, Integer>(Symptom);
		
		for (String key : sortedMap.keySet()) {
            System.out.println(key + " = " + sortedMap.get(key));
        System.out.println();
		} 		
		return sortedMap;		
	}	
}
