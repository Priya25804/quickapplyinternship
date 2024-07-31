package com.example;

public class Main {
    public static void main(String[] args) {
        Config config = new Config();
        WhatsAppClient client = new WhatsAppClient(
            config.getProperty("api_key"),
            config.getProperty("api_url"),
            config.getProperty("phone_number")
        );

        String recipient = "RECIPIENT_PHONE_NUMBER";
        String message = "You have applied for the internship with one click!";

        client.sendMessage(recipient, message);
    }
}
