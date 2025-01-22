package com.bibledetector.steps.impl.actions;

import com.bibledetector.steps.types.impl.ActionInput;
import com.bibledetector.steps.types.step.Action;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;

import static com.bibledetector.steps.impl.actions.config.GoLiveOpenLPConfig.*;

public class GoLiveOpenLP implements Action {

    private final WebTarget authorizationTarget;
    private final WebTarget liveTarget;

    public GoLiveOpenLP() {
        Client client = ClientBuilder.newClient();
        this.authorizationTarget = client.target(BASE_URL).path(AUTHORIZATION_PATH);
        this.liveTarget = client.target(BASE_URL).path(LIVE_PATH);
    }

    @Override
    public void execute(ActionInput actionInput) {
        System.out.println("Executing GoLiveOpenLP for" + actionInput.toString());

        Response authResponse = authorizationTarget.request()
                .header("Content-Type", "application/json")
                .post(Entity.json(new AuthenticationRequestBody(OPENLP_USERNAME, OPENLP_PASSWORD)));
        AuthenticationResponse authenticationResponse = authResponse.readEntity(AuthenticationResponse.class);

        liveTarget.request()
                .header(AUTHORIZATION_HEADER, authenticationResponse.token())
                .header("Content-Type", "application/json")
                .post(Entity.json(new LiveRequestBody(formatActionInput(actionInput))));
    }

    private String formatActionInput(ActionInput actionInput) {
        return actionInput.toString();
    }


    private record AuthenticationRequestBody(String username, String password) {}
    private record AuthenticationResponse(String token) {}
    private record LiveRequestBody(String id) {}



}
