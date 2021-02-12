package com.examples.lesson12.services.setup;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Setup {

  public static final String URL = "jdbc:derby://localhost:1527/QuizDB";
  public static final String USER = "oracle";
  public static final String PASS = "welcome1";
  public static final String DBSCRIPT = "databaseSetup.sql";

  public void setupJDNI() throws Exception {
    Context ctx = new InitialContext();
    DataSource ds = (DataSource) ctx.lookup("jdbc/QuizDB");
    Connection connection = ds.getConnection();
    try {
      setup(connection);
    } finally {
      try {
        connection.close();
      } catch (Exception e) {
      }
    }
  }

  public void setupJDBC() throws Exception {
    Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
    Connection connection = null;
    try {
      connection = DriverManager.getConnection(URL, USER, PASS);
      setup(connection);
    } catch (Exception e) {
      throw e;
    } finally {
      try {
        connection.close();
      } catch (Exception e) {
      }
    }
  }

  private void setup(Connection connection) throws Exception {
    Statement statement = null;
    InputStream inputSql = null;
    InputStreamReader inputStreamReader = null;
    BufferedReader reader = null;
    try {
      statement = connection.createStatement();
      inputSql = getClass().getResourceAsStream(DBSCRIPT);
      inputStreamReader = new InputStreamReader(inputSql, "UTF-8");
      reader = new BufferedReader(inputStreamReader);
      String temporaryStatement = "";
      String line;
      while ((line = reader.readLine()) != null) {
        if (!line.startsWith("#")) {
          temporaryStatement += line + "\n";
          if (line.indexOf(';') >= 0) {
            temporaryStatement = temporaryStatement.substring(0, temporaryStatement.indexOf(';')).trim();
            System.out.println("\n\nExecuting:  " + temporaryStatement);
            try {
              statement.executeUpdate(temporaryStatement);
            } catch (SQLException sqlEx) {
              System.err.println(sqlEx.getMessage());
            }
            temporaryStatement = "";
          }
        }
      }
      connection.commit();
    } catch (Exception e) {
      throw e;
    } finally {
      try {
        reader.close();
      } catch (Exception e) {
      }
      try {
        inputStreamReader.close();
      } catch (Exception e) {
      }
      try {
        inputSql.close();
      } catch (Exception e) {
      }
      try {
        statement.close();
      } catch (Exception e) {
      }
    }
  }
}
