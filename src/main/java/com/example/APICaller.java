package com.example;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class APICaller {

    //public static int HoursAway = 4;


    public static String main_api(int HoursAway) {

        try {
            // Create a URL object with the API endpoint
            URL url = new URL("https://api.weather.gov/gridpoints/SLC/103,150/forecast/hourly");

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set request method
            connection.setRequestMethod("GET");
            connection.connect();

            // Get the response code
            int responseCode = connection.getResponseCode();

            if (responseCode != 200) {
                throw new RuntimeException("HttpResponceCode: " + responseCode);
            } else {

                String inline = "";
                Scanner scanner = new Scanner(url.openStream());
            
                //Write all the JSON data into a string using a scanner
                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }
                
                //Close the scanner
                scanner.close();

                //Using the JSON simple library parse the string into a json object
                JSONParser parse = new JSONParser();
                JSONObject data_obj = (JSONObject) parse.parse(inline);

                //Get the required object from the above created object
                JSONObject obj = (JSONObject) data_obj.get("properties");

                //Get the required data using its key
                //System.out.println("printing" + obj.get("periods"));

                JSONArray arr = (JSONArray) obj.get("periods");
                JSONObject new_ob = (JSONObject) arr.get(HoursAway);
                Long returnString = (Long) new_ob.get("temperature");
                String temp = returnString.toString();
                String forecast = (String) new_ob.get("shortForecast");
                //System.out.println(new_ob.get("temperature"));
                String returnString2 = " it will be " + temp + " Degrees Fahrenheit. Your forecast is " + forecast + "!";
                
                return returnString2;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}