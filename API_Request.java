import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class OpenAIChatRequest {

    public static void main(String[] args) {
        String apiKey = "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";

        // Replace the URL with the correct OpenAI API endpoint
        String apiUrl = "https://api.openai.com/v1/chat/completions";

        // Replace with your model name
        String modelName = "gpt-4";

        // Replace with your system message and user message content
        String systemMessage = "You are a manager in a supermarket. I will give you a product name, quantity of the product now, quantity of the product yesterday, and quantity of the product the day before yesterday. How much product should I buy. Calculate the product using the supply and demand product and display it in the exact form using 2 tokens. Name of the product, quantity I should buy.";
        String userMessage = "Yogurt,5,12,17";

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

            // Print the response status code and body
            System.out.println("Response Code: " + response.statusCode());
            System.out.println("Response Body: " + response.body());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}






/* Αυτό εκτελείται απο το command line

    curl https://api.openai.com/v1/chat/completions   -H "Content-Type: application/json"   -H "Authorization: Bearer $OPENAI_API_KEY"   -d '{
        "model": "gpt-4",
        "messages": [
        {
        "role": "system",
        "content": "You are a manager in a super market. I will give you a product name,quantity of the product now, quantity of the product yesterday and quantity of the product the day before yesterday.How much product should I buy. Culculate the product using the supply and demand product and display it in the exact form using 2 tockens. Name of the product, quantity I should buy."
        },
        {
        "role": "user",
        "content": " Yogurt,5,12,17"
        }
        ]
        }'
*/
