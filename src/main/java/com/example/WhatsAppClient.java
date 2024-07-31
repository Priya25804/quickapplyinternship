package com.example;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class WhatsAppClient {
    private String apiKey;
    private String apiUrl;
    private String phoneNumber;

    public WhatsAppClient(String apiKey, String apiUrl, String phoneNumber) {
        this.apiKey = apiKey;
        this.apiUrl = apiUrl;
        this.phoneNumber = phoneNumber;
    }

    public void sendMessage(String recipient, String message) {
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Authorization", "Bearer " + apiKey);
            conn.setDoOutput(true);

            String jsonInputString = String.format("{\"to\": \"%s\", \"message\": \"%s\"}", recipient, message);

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int code = conn.getResponseCode();
            System.out.println("Response Code: " + code);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
