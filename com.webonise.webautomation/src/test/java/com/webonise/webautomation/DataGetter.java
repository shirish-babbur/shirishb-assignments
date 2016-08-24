package com.webonise.webautomation;

import java.io.*;
public class DataGetter {
	private String Source="";
	private String Destination="";
	//private String Sourcedate[]=new String [3];
	String SourceDate="";
	//private String DestinationDate[]=new String [3];
	String DestinationDate="";

	public DataGetter(String filename){
		try {
    		BufferedReader br = new BufferedReader(new FileReader(filename)); 
    		String line;
    		Source=br.readLine();
    		Destination=br.readLine();
    		//Sourcedate=(br.readLine().split("-"));
    		SourceDate=br.readLine();
    		//DestinationDate=(br.readLine().split("-"));
    		DestinationDate=br.readLine();
    	}
    	catch(Exception e){
    	    	
    	}
	}
	public String getSource(){
		return Source;
	}
	public String getDestination(){
		return Destination;
	}
	public String GetSourceDay(){
		//return Integer.parseInt(SourceDate[0]);
		return SourceDate;
	}
	/*public int GetSourceMonth(){
		return Integer.parseInt(SourceDate[1]);
	}
	public int GetSourceYear(){
		return Integer.parseInt(SourceDate[2]);
	}*/
	public String GetDestinationDay(){
		//return Integer.parseInt(DestinationDate[0]);
		return DestinationDate;
	}
	/*public int GetDestinationMonth(){
		return Integer.parseInt(DestinationDate[1]);
	}
	public int GetDestinationYear(){
		return Integer.parseInt(DestinationDate[2]);
	}*/
}
