package DAL;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

// Database access layer
public class Database {
  public static final String HOST = "localhost:3306/";
  public static final String DB = "ears";
  public static final String USER = "root";
  public static final String PASS = "12345678";
  private static HikariDataSource dataSource = null;

  static {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      HikariConfig config = new HikariConfig();
      config.setJdbcUrl("jdbc:mysql://" + HOST + DB);
      config.setUsername(USER);
      config.setPassword(PASS);
      config.addDataSourceProperty("minimumIdle", "5");
      config.addDataSourceProperty("maximumPoolSize", "25");

      dataSource = new HikariDataSource(config);
      Runtime.getRuntime().addShutdownHook(new Thread(() -> {
        if (dataSource != null) {
          dataSource.close();
        }
      }));
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public static Connection getConnection() {
    Connection connection = null;
    try {
      connection = dataSource.getConnection();
      System.out.println("Connected to db server");
    } catch (SQLException ex) {
      ex.printStackTrace();
      System.out.println("Cannot connect to db server");
    }

    return connection;
  }

}