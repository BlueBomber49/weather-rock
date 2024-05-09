import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;

public class APICaller {
    public static void main(String[] args) {
        try {
            // Create a URL object with the API endpoint
            URL url = new URL("https://api.weather.gov/gridpoints/SLC/103,150/forecast/hourly");

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set request method
            connection.setRequestMethod("GET");

            // Get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Read the response from the API
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Print the response
            System.out.println("Response Body:");
            System.out.println(response.toString());

            // Close the connection
            connection.disconnect();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
