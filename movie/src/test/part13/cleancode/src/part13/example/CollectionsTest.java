package part13.example;

import java.util.Collections;
import java.util.Hashtable;
import java.util.Map;

public class CollectionsTest {

	public static void main(String[] argv) throws Exception { 
	       
		try { 
			Hashtable<String, String> table = new Hashtable<String, String>(); 
			table.put("key1", "1"); 
			table.put("key2", "2"); 
			table.put("key3", "3"); 
			  
            Map<String, String> m = Collections.unmodifiableMap(table);  // »ç¿ë ¹ý
  
            System.out.println("Initial collection: " + table); 
  
            System.out.println("\nTrying to modify" + " the unmodifiablemap"); 
			m.put("key4", "4"); 
		
		} catch (UnsupportedOperationException e) { 
			System.out.println("Exception thrown : " + e); 
		} 
	} 
}
