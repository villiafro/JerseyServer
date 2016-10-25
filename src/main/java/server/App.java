package server;

import controller.AccountController;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import controller.HelloWorldEndpoint;

import java.io.Closeable;
import java.io.IOException;
import java.net.URI;
import java.util.concurrent.ExecutionException;
import java.sql.*;


public class App implements Closeable {

    public HttpServer server;

    // Initializing base URL and Port
    public static final URI BASE_URI = URI.create("http://127.0.0.1:8080/");

    public App() throws Exception {

        //Creating a new resource config, this takes care of knowing what endpoints exist.
        ResourceConfig resourceConfig = new ResourceConfig();

        //Load all the endpoint classes to the context.
        registerResourcesToResourceConfig(resourceConfig);

        //Initalize grizzly server with the URL and resource config, dont start it immedietly.
        server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, resourceConfig, false);
    }

    /**
     * This method registers resource classes to the resource config.
     * Required so the server knows about the endpoint classes it has and what paths they have.
     * @param resourceConfig
     */
    private void registerResourcesToResourceConfig(ResourceConfig resourceConfig){
        resourceConfig.register(AccountController.class); // this registers the class helloworld to the server so we can access helloworld endpoint
    }

    /**
     * Method to start the server. simply calls the HttpServer.start() method, but just adding some logging around it.
     *
     * @throws IOException
     */
    public void start() throws IOException {

        System.out.println("Starting server");
        try{
            server.start();
            System.out.println("Server started!");
        } catch (IOException e) {
            System.out.println("Failed to start Grizzly on address: " + BASE_URI.toASCIIString());
        }
    }

    /** Shut downs the server.
     *  try to shutdown gracefully, if that gets interrupted with CTRL C or something simular, call shutdown now.
     */
    public void close() {
        try {
            server.shutdown().get();
        } catch (InterruptedException | ExecutionException e){
            System.out.println("Failed to shutdown gracefully");
            server.shutdownNow();
        }
    }
}
