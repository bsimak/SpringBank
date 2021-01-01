package org.example;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;
import org.example.web.MyBankServlet;

public class ApplicationLauncher {

    static final int defPort = 8080;


    public static void main(String[] args) throws LifecycleException {
        /** use this with java -Dport80xx -jar target/xy
         if Port not provided as Parameter -> use default Port */

       // System.setProperty("server.port", "8090");

        int port;
        String sPort = (System.getProperty("server.port"));

        if ((sPort == null) || (sPort.isEmpty())) {
            port = defPort;
        } else {
            port = Integer.parseInt(sPort);
        }
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(port);

        tomcat.getConnector();

        Context ctx = tomcat.addContext("", null);
        Wrapper servlet = Tomcat.addServlet(ctx, "org.example.web.MyBankServlet", new MyBankServlet());
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/*");

        tomcat.start();
        System.out.println("Tomcat started.....");
        System.out.println("Listen at Port: " + port);
    }
}
