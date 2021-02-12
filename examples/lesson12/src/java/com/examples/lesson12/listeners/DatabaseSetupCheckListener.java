package com.examples.lesson12.listeners;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DatabaseSetupCheckListener implements ServletContextListener {

  public static final String URL = "jdbc:derby://localhost:1527/QuizDB";
  public static final String USER = "oracle";
  public static final String PASS = "welcome1";

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    sce.getServletContext().setAttribute("initialized", validateInstallation());
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
  }

  private boolean validateInstallation() {
    Connection connection = null;
    Statement statement = null;
    ResultSet rs = null;
    try {
      Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
      connection = DriverManager.getConnection(URL, USER, PASS);
      statement = connection.createStatement();
      rs = statement.executeQuery("SELECT * FROM QuizCheck");
      return rs.next();
    } catch (Exception e) {
      return false;
    } finally {
      try {
        rs.close();
      } catch (Exception e) {
      }
      try {
        statement.close();
      } catch (Exception e) {
      }
      try {
        connection.close();
      } catch (Exception e) {
      }
    }
  }
}
