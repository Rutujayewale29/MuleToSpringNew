package com.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadJson 
{
	public void readFile() throws StreamReadException, DatabindException, IOException
	{
		ObjectMapper mapper = new ObjectMapper();
	     Map<?, ?> map = mapper.readValue(Paths.get("D:\\STS\\MuleToSpring\\MuleToSpring\\src\\main\\resources\\Output\\Result.json").toFile(), Map.class);		 
			for(Map.Entry<?, ?>entry:map.entrySet())
			{
				
				System.out.println(entry.getKey()+"="+entry.getValue());
			}
		
	}
	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		// TODO Auto-generated method stub
		//JSONParser jsonp=new JSONParser();
		
		try(FileReader reader=new FileReader("D:\\STS\\MuleToSpring\\MuleToSpring\\src\\main\\resources\\Output\\Result.json"))
		{
		JSONParser jsonp=new JSONParser();
		//read json file
			Object obj=jsonp.parse(reader);
			//JSONArray data=(JSONArray) obj;
			JSONObject jsonobj=(JSONObject) obj;
			
			System.out.println(jsonobj);
			
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(ParseException e)
		{
			e.printStackTrace();
		}
		ReadJson obj=new ReadJson();
		obj.readFile();
	}
	}	
		
//		JSONObject jsonObj=new JSONObject();
//		ObjectMapper mapper = new ObjectMapper();
//	     Map<?, ?> map = mapper.readValue(Paths.get("D:\\STS\\MuleToSpring\\MuleToSpring\\src\\main\\resources\\Output\\default.json").toFile(), Map.class);		 
//		for(Map.Entry<?, ?>entry:map.entrySet())
//		{
//			System.out.println(entry.getKey()+"="+entry.getValue());
//		}
//	
		
