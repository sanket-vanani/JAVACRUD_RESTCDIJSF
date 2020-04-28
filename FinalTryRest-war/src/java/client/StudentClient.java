/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:StudentResource [student]<br>
 * USAGE:
 * <pre>
 *        StudentClient client = new StudentClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author root
 */
public class StudentClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/FinalTryRest-war/webresources";

    public StudentClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("student");
    }

    public String deleteStuds(String StudID) throws ClientErrorException {
        WebTarget resource = webTarget;
        if (StudID != null) {
            resource = resource.queryParam("StudID", StudID);
        }
        resource = resource.path("delete");
        return resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
    }

    public void updateStuds(Object requestEntity) throws ClientErrorException {
        webTarget.path("edit").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T getStuds(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getStuds");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addStuds(Object requestEntity) throws ClientErrorException {
        webTarget.path("add").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void close() {
        client.close();
    }

    static class StudentResource_JerseyClient {

        private WebTarget webTarget;
        private Client client;
        private static final String BASE_URI = "http://localhost:8080/FinalTryRest-war/webresources";

        public StudentResource_JerseyClient() {
            client = javax.ws.rs.client.ClientBuilder.newClient();
            webTarget = client.target(BASE_URI).path("student");
        }

        public String deleteStuds() throws ClientErrorException {
            return webTarget.path("delete").request().delete(String.class);
        }

        public void updateStuds(Object requestEntity) throws ClientErrorException {
            webTarget.path("edit").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
        }

        public <T> T getStuds(Class<T> responseType) throws ClientErrorException {
            WebTarget resource = webTarget;
            resource = resource.path("getStuds");
            return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
        }

        public void addStuds(Object requestEntity) throws ClientErrorException {
            webTarget.path("add").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
        }

        public void close() {
            client.close();
        }
    }

}
