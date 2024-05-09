package com.example;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class APICaller {

    public static int HoursAway = 4;

<<<<<<< HEAD
    public static Long main_api(int HoursAway) {
=======
    public String main_api(String[] args, int HoursAway) {
>>>>>>> d8e3ac2f5f899444cc4f008f29954b5f3bb6ea86
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
<<<<<<< HEAD
                Long returnString = (Long) new_ob.get("temperature");
                //System.out.println(new_ob.get("temperature"));
=======
                String returnString = (String) new_ob.get("temperature");
                System.out.println(new_ob.get("temperature"));
>>>>>>> d8e3ac2f5f899444cc4f008f29954b5f3bb6ea86

                return returnString;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}