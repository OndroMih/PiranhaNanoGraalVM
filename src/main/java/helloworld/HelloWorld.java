package helloworld;

import cloud.piranha.http.impl.DefaultHttpServer;
import cloud.piranha.http.webapp.HttpWebApplicationServerProcessor;
import cloud.piranha.nano.NanoPiranha;
import cloud.piranha.nano.NanoPiranhaBuilder;

/**
 * The main class.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
public class HelloWorld {

    /**
     * Main method.
     * 
     * @param arguments the command-line arguments.
     * @throws Exception when an error occurs.
     */
    public static void main(String[] arguments) throws Exception {
        NanoPiranha piranha = new NanoPiranhaBuilder()
                .servlet("HelloWorld", new HelloWorldServlet())
                .build();
        
        DefaultHttpServer server = new DefaultHttpServer(8080, 
                new HttpWebApplicationServerProcessor(piranha), false);
        
        server.start();
    }
}
