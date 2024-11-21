package data;

import java.sql.*;

/**
 * @Author HLH
 * @description: 数据库操作基类
 * @Date 2024/11/20 22:05
 */
public class BaseDao {

  private static final String driver = "com.mysql.cj.jdbc.Driver";
  private static final String url = "jdbc:mysql://localhost:3306/tsgl";
  private static final String user = "root";
  private static final String password = "000000";

  private static volatile Connection conn = null;

  // 完成数据库的加载与连接
  private static Connection getConnection() {
    try {
      Class.forName(driver); // 加载数据库驱动
      conn = DriverManager.getConnection(url, user, password); // 获取数据库连接
    } catch (ClassNotFoundException e) {
      e.printStackTrace(); // 打印驱动未找到的异常
      // 可以在这里做一些处理，如重新抛出异常或记录日志
    } catch (SQLException e) {
      e.printStackTrace(); // 打印 SQL 异常
      // 处理数据库连接相关的异常
    } catch (Exception e) {
      e.printStackTrace(); // 捕获其他任何异常
      // 处理其他异常情况
    }
    return conn;
  }

  public static ResultSet executeQuery(String sql) {
    if(sql == null) {
      throw new IllegalArgumentException("查询语句不能为空");
    }
    try {
      conn = BaseDao.getConnection();
      return conn.createStatement().executeQuery(sql);
    } catch (SQLException e) {
      // 抛出异常，让调用者处理
      throw new RuntimeException("查询失败", e);
    }
  }

  public static int executeUpdate(String sql) {
    if(sql == null) {
      throw new IllegalArgumentException("查询语句不能为空");
    }
    try {
      conn = BaseDao.getConnection();
      return conn.createStatement().executeUpdate(sql);
    } catch (SQLException e) {
      // 抛出异常，让调用者处理
      throw new RuntimeException("更新失败", e);
    }
  }

  public static void closeConnection() {
    if (conn != null) {
      try {
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace(); // 记录日志
      }
    }
  }
}