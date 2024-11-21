package data;

import entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author HLH
 * @description: TODO
 * @Date 2024/11/20 22:57
 */
public class UserDao {
  public static User getUser(String name, String password) {
    User user = new User();
    if (name != null || password != null) {
      String sql = "select * from user where name='" + name + "'and pass='" + password + "'";

      ResultSet rs = BaseDao.executeQuery(sql);

      try {
        if (rs.next()) {
          user = new User();
          user.setId(rs.getInt("id"));
          user.setName(rs.getString("name"));
          user.setPassword(rs.getString("pass"));
          user.setIs_admin(rs.getByte("is_admin"));
        }
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    }
    return user;
  }

  public static User getUser(int id) {
    User user = null;
    if (id > 0) {
      String sql = "select * from user where id=" + id;
      ResultSet rs = BaseDao.executeQuery(sql);
      try {
        if (rs.next()) {
          user = new User();
          user.setId(rs.getInt("id"));
          user.setName(rs.getString("name"));
          user.setPassword(rs.getString("pass"));
          user.setIs_admin(rs.getByte("is_admin"));
        }
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    }
    return user;
  }

  public static User getUser(String name) {
    User user = new User();
    if (name != null) {
      String sql = "select * from user where name='" + name + "'";

      ResultSet rs = BaseDao.executeQuery(sql);

      try {
        if (rs.next()) {
          user = new User();
          user.setId(rs.getInt("id"));
          user.setName(rs.getString("name"));
          user.setPassword(rs.getString("pass"));
          user.setIs_admin(rs.getByte("is_admin"));
        }
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    }
    return user;
  }

  public static List<User> selectUserList() {
    User user;
    List<User> list = new ArrayList<>();
    String sql = "select * from user";
    ResultSet rs = BaseDao.executeQuery(sql);
    try {
      while (rs.next()) {
        user = new User();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("pass"));
        user.setIs_admin(rs.getByte("is_admin"));
        list.add(user);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return list;
  }

  public static int insertUser(User user) {
    if (user == null || user.getId() == 0 || user.getName() == null || user.getPassword() == null) return -1;
    int id = user.getId();
    String name = user.getName();
    String password = user.getPassword();
    byte is_admin = user.getIs_admin();
    String sql = "insert into user values(" + id + ",'" + name + "','" + password + "'," + is_admin + ")";
    return BaseDao.executeUpdate(sql);
  }

  public static int updateUser(User user) {
    if (user == null || user.getId() == 0 || user.getName() == null || user.getPassword() == null) return -1;
    int id = user.getId();
    String name = user.getName();
    String password = user.getPassword();
    byte is_admin = user.getIs_admin();
    String sql = "update user set name='" + name + "',pass='" + password + "',is_admin=" + is_admin + " where id=" + id;
    return BaseDao.executeUpdate(sql);
  }

  public static int updatePass(String name, String password) {
    if(name != null || password != null) {
      String sql = "update user set pass='" + password + "' where name='" + name + "'";
      return BaseDao.executeUpdate(sql);
    }
    return -1;
  }

  public static int deleteUser(int id) {
    String sql = "delete from user where id = " + id;
    return BaseDao.executeUpdate(sql);
  }

  public static void emptyUser() {
    String sql = "delete from user";
    BaseDao.executeUpdate(sql);
  }
}
