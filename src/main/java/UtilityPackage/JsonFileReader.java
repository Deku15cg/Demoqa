package UtilityPackage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonFileReader{
	
	 static JSONObject jo;
	  static Object obj;

//public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
//	 System.out.println(JsonReadTC1("Registration.json","TC1").get("firstname"));
//	 //System.out.println(JsonReadTC1().get("firstname").getClass());
//
//
//	 //System.out.println(JsonReadTC2().get("UserName"));
//
//}
	public static  Map JsonReadTC1(String file,String TC_ID) throws FileNotFoundException, IOException, ParseException {
		
		  obj = new JSONParser().parse(new FileReader("src\\test\\resources\\Jsonfiles\\"+file));
		   jo = (JSONObject) obj;
		  Map TC1 = ((Map)jo.get(TC_ID));
		  
		  
//		  Iterator<Map.Entry> itr1 = TC1.entrySet().iterator();
//	        while (itr1.hasNext()) {
//	            Map.Entry pair = itr1.next();
//	            System.out.println(pair.getKey() + " : " + pair.getValue());
//	            }
//		  System.out.println("Return value from json"+TC1.get("firstname"));
	        return TC1;
	}
	public static  Map JsonReadTC2() throws FileNotFoundException, IOException, ParseException  { 
		obj = new JSONParser().parse(new FileReader("src\\test\\resources\\Jsonfiles\\Userlogin.json"));
		   jo = (JSONObject) obj;
	Map TC2 = ((Map)jo.get("Credential"));
//	Iterator<Map.Entry> itr2 = TC2.entrySet().iterator();
//    while (itr2.hasNext()) {
//        Map.Entry pair = itr2.next();
//        System.out.println(pair.getKey() + " : " + pair.getValue());
//	}
    return TC2;

}
	}
	
