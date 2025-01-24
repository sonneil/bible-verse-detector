package com.bibledetector.utils;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import org.jboss.resteasy.plugins.providers.jackson.ResteasyJackson2Provider;

public class RestClient {
    private static final Client client = createClient();

    private static Client createClient() {
        ResteasyJackson2Provider jacksonProvider = new ResteasyJackson2Provider();
        return ClientBuilder.newBuilder().register(jacksonProvider).build();
    }

    public static Client getClient() {
        return client;
    }
}