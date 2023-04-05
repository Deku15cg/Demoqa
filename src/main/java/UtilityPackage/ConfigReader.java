package UtilityPackage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public  class ConfigReader {
	
//	public static void main(String args[]) {
//		ConfigReader con=new ConfigReader();
//		System.out.println(con.Envirometvalue("Uat").getProperty("url"));
//		System.out.println(con.getApplicationUrl());
//		System.out.println(System.getenv("env"));
//	}
	
	private BufferedReader reader;
	private Properties properties;
	public ConfigReader config;
 static	String Terminalenv= System.getProperty("env");
	public Properties Envirometvalue(String Terminalenv)  {  
		properties=new Properties();
	    if (Terminalenv==null) {
	    	String propertyFilePath= "./src/main/resources/Config/devEnv.properties";
	    	try {
				reader=new BufferedReader(new FileReader(propertyFilePath));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
	    	try {
				properties.load(reader);
			} catch (IOException e) {
				e.printStackTrace();
			}
	    	try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    	
	    	
	    	
	    	
	    } else {
	    	String propertyFIlePath = "./src/main/resources/Config/"+ Terminalenv+"Env"+".properties";
	    	try {
				reader=new BufferedReader(new FileReader(propertyFIlePath));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	try {
				properties.load(reader);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    }return properties;
	}
	
public String getDriverPath(){
		config= new ConfigReader();
		String driverPath =config.Envirometvalue(Terminalenv).getProperty("driverPath");
		//System.out.println("driver:"+driverPath);
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("driverPath not specified in the Config file.");		
	}
public String getApplicationUrl(){
	config= new ConfigReader();
	String url =config.Envirometvalue(Terminalenv).getProperty("url");
	//System.out.println("driver:"+driverPath);
	if(url!= null) return url;
	else throw new RuntimeException("url not specified in the Config file.");		
}

}
			
			





	
