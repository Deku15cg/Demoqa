package UtilityPackage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonFile {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		JsonFile js=new JsonFile();
		js.Cread("Cread.json", "User2");
		

	}
	
	 Object ob;
	 JSONObject obj;
	
	public Object Cread(String file,String User_Id) throws FileNotFoundException, IOException, ParseException {
		
		 ob=new JSONParser().parse(new FileReader("src\\test\\resources\\Jsonfiles\\"+file));
		  obj=(JSONObject)ob;
		  Map User1=((Map)obj.get(User_Id));
		  Iterator<Map.Entry> itr2 = User1.entrySet().iterator();
		    while (itr2.hasNext()) {
		        Map.Entry pair = itr2.next();
		        System.out.println(pair.getKey() + " : " + pair.getValue());
			}
		return User1;
		  
		  
	}

}
