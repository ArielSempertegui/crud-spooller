package net.ausiasmarch.connection;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener{
    
    @Override
    public void contextInitialized(ServletContextEvent event){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent event){
    }
}
