package com.bibledetector.steps.impl.actions;

import com.bibledetector.steps.impl.actions.restclient.RestClient;
import com.bibledetector.steps.types.impl.ActionInput;
import com.bibledetector.steps.types.step.Action;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;

import static com.bibledetector.steps.impl.actions.config.GoLiveOpenLPConfig.*;

public class GoLiveOpenLP implements Action {

    private final WebTarget authorizationTarget;
    private final WebTarget liveTarget;
    private final WebTarget serviceTarget;

    public GoLiveOpenLP() {
        this.authorizationTarget = RestClient.getClient().target(BASE_URL).path(AUTHORIZATION_PATH);
        this.liveTarget = RestClient.getClient().target(BASE_URL).path(LIVE_PATH);
        this.serviceTarget = RestClient.getClient().target(BASE_URL).path(ADD_TO_SERVICE_PATH);
    }

    @Override
    public void execute(ActionInput actionInput) {
        System.out.println("GoLiveOpenLP: " + actionInput.toString());
        try {
            Response authResponse = authorizationTarget.request()
                    .header("Content-Type", "application/json")
                    .post(Entity.json(new AuthenticationRequestBody(OPENLP_USERNAME, OPENLP_PASSWORD)));
            AuthenticationResponse authenticationResponse = authResponse.readEntity(AuthenticationResponse.class);

            liveTarget.request()
                    .header(AUTHORIZATION_HEADER, authenticationResponse.token())
                    .header("Content-Type", "application/json")
                    .post(Entity.json(new LiveRequestBody(formatActionInput(actionInput))));

            serviceTarget.request()
                    .header(AUTHORIZATION_HEADER, authenticationResponse.token())
                    .header("Content-Type", "application/json")
                    .post(Entity.json(new LiveRequestBody(formatActionInput(actionInput))));

        } catch (Exception e) {
            System.out.println("No se pudo ejecutar el paso GoLiveOpenLP");
            System.out.println("    1 - Asegurate que OpenLP esta abierto en este equipo");
            System.out.println("    2 - Asegurate que OpenLP > Preferencias > Interfaz Remota > Puerto número es 4316");
            System.out.println("    3 - Asegurate que OpenLP > Preferencias > Interfaz Remota > Autenticación de Usuario está marcado");
            System.out.println("    4 - Asegurate que OpenLP > Preferencias > Interfaz Remota > Nombre de usuario = ciudadluz y Contraseña = ciudadluzremote");
        }
    }

    private String formatActionInput(ActionInput actionInput) {
        return actionInput.toString();
    }

    private record AuthenticationRequestBody(String username, String password) {}
    private record AuthenticationResponse(String token) {}
    private record LiveRequestBody(String id) {}

}
