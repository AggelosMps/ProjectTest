package com.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ApiRequest {
    
    public static String getApothema() {
        String systemMessage = "You are a manager in a supermarket. I will give you a product name, quantity of the product now, quantity of the product yesterday, and quantity of the product the day before yesterday. How much product should I buy. Calculate the product using the supply and demand product and display it in the exact form using 2 tokens. Name of the product, quantity I should buy.";
        String userMessage = Data.getApothemata();
        String response =  chatGptConnection(systemMessage, userMessage);
        return response;
    }

    public static String getPrice() {
        String systemMessage = "You are a manager in a supermarket. I will give you a product name, selling price, purchase cost, quantity of the product now, quantity of the product yesterday, and quantity of the product the day before yesterday. Give me a new selling price. Calculate the price using the supply and demand, the  category of the product, the difference between the selling price and the purchase costand display it in the exact form using 2 tokens. Name of the product, new price.";
        String userMessage = Data.getPrice();
        String response =  chatGptConnection(systemMessage, userMessage);
        return response;
    }


    //Κόβει το String της απάντησης του Chat Gpt, (χρειάζαι και dependency στο maven)
        public static String extractContent(String jsonString) {
        JSONObject jsonObject = new JSONObject(jsonString);
        String content = jsonObject.getJSONArray("choices")
                                   .getJSONObject(0)
                                   .getJSONObject("message")
                                   .getString("content");
        return content;
    }

    //To request στο chatgpt 
    public static String chatGptConnection(String systemMessage, String userMessage) {
        String apiKey = ApiKey.getApiKey();
        // Replace the URL with the correct OpenAI API endpoint
        String apiUrl = "https://api.openai.com/v1/chat/completions";
        // Replace with your model name
        String modelName = "gpt-4";
        // Construct the JSON payload
        String jsonPayload = String.format("{\"model\": \"%s\", \"messages\": [{\"role\": \"system\", \"content\": \"%s\"}, {\"role\": \"user\", \"content\": \"%s\"}]}", modelName, systemMessage, userMessage);

        // Set up the HttpClient
        HttpClient httpClient = HttpClient.newHttpClient();

        // Build the HTTP request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + apiKey)
                .POST(HttpRequest.BodyPublishers.ofString(jsonPayload))
                .build();
        
        try {
            // Send the HTTP request and retrieve the response
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // Return response body
            return response.body();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Διαβάζει το api key από εξωτερικό αρχείο
    public static String readFile(String filePath) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                contentBuilder.append(currentLine).append("\n");
            }
        }
        return contentBuilder.toString();
    }

    public static String getApi() {
        try {
            String content = readFile("filepath");
            return content;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
