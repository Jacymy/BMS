package windows;

import data.BaseDao;
import entity.Reader;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 类作用：所有界面的基础框架，用来统一系统图标、背景颜色等
 *
 * @author zzl
 */
public class PublicJFrame extends JFrame {
  /**
   * 构造方法：用于初始化基础框架，设置统一系统图标、背景颜色、可见性
   *
   * @author zzl
   */
  PublicJFrame() {
    // 设置默认字符编码
    System.setProperty("file.encoding", "UTF-8");
    // 创建、设置界面框架的图标
    Image icon = new JFrame().getToolkit().getImage("E:\\Java 综合项目设计\\BMS\\src\\images\\icon.png");
    this.setIconImage(icon);
    // 设置框架内容面板的背景颜色
    this.getContentPane().setBackground(new Color(210, 242, 243));
    this.setVisible(true);// 设置框架可见
  }

  public static class ReaderDao {
    /** 成员方法1：通过读者编号，获取一个读者对象 */
    public static Reader getReaderById(String id) {
      Reader reader = null;
      if (id != null) {
        // 构造按照读者编号查询读者的sql查询语句
        String sql = "select * from reader where id='" + id + "'";
        ResultSet rs = BaseDao.executeQuery(sql);// 执行查询语句，并返回结果集
        try {
          if (rs.next()) {// 下移结果集指针，判断记录是否存在？
            reader = new Reader();// 创建读者对象，并保存读者信息
            reader.setId(rs.getString("id"));
            reader.setName(rs.getString("name"));
            reader.setType(rs.getString("type"));
            reader.setSex(rs.getString("sex"));
            reader.setMax_num(rs.getInt("max_num"));
            reader.setDays_num(rs.getInt("days_num"));
          }
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
      return reader;// 返回读者对象
    }

    /** 成员方法2：通过sql查询语句，获取读者对象列表 */
    public static java.util.List<Reader> selectReaderList(String sql) {
      java.util.List<Reader> list = new ArrayList<>(); // 创建一个保存读者对象的列表
      if (sql != null) {
        Reader reader;
        ResultSet rs = BaseDao.executeQuery(sql);// 执行查询语句，并返回结果集
        try {
          while (rs.next()) {// 下移结果集指针，判断记录是否存在？
            reader = new Reader(); // 创建读者对象，保存读者信息
            reader.setId(rs.getString("id"));
            reader.setName(rs.getString("name"));
            reader.setType(rs.getString("type"));
            reader.setSex(rs.getString("sex"));
            reader.setMax_num(rs.getInt("max_num"));
            reader.setDays_num(rs.getInt("days_num"));
            list.add(reader);// 向读者列表添加读者对象
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
      return list;// 返回读者列表
    }

    /** 成员方法3：获取所有读者对象列表 */
    public static java.util.List<Reader> selectReaderList() {
      // 构造查询所有读者的sql查询语句
      String sql = "select * from reader";
      return selectReaderList(sql);// 执行查询语句，返回读者列表
    }

    /** 成员方法4：按照字符串类型属性值查询条件，获取读者对象列表 */
    public static java.util.List<Reader> selectReaderList(String field, String value) {
      String sql = "select * from reader";// 构造默认的sql查询语句
      assert value != null;
      if (!value.isEmpty() && field != null) {
        // 构造按照字符串读者属性值来查询的sql查询语句，采用模糊查询
        sql = "select * from reader where " + field + " like '%" + value + "%'";
      }
      return selectReaderList(sql);// 执行查询语句， 返回读者列表
    }

    /** 成员方法5：按照整型数据查询条件，获取读者对象列表 */
    public static List<Reader> selectReaderList(String field, int value) {
      String sql = "select * from reader";// 构建默认的sql查询语句
      if (field != null && value != 0) {
        // 构造按照整型属性值来查询的sql查询语句
        sql = "select * from reader where " + field + "=" + value;
      }
      return selectReaderList(sql);// 执行查询语句，返回读者列表
    }

    /** 成员方法6：添加新读者 */
    public static int insertReader(Reader reader) {
      if (reader != null) {
        // 获取读者信息
        String id = reader.getId();
        String name = reader.getName();
        String type = reader.getType();
        String sex = reader.getSex();
        int max_num = reader.getMax_num();
        int days_num = reader.getDays_num();
        // 构造添加读者的SQL更新语句
        String sql = "insert into reader values('" + id + "','" + name + "','" + type
          + "','" + sex + "'," + max_num + "," + days_num + ")";
        return BaseDao.executeUpdate(sql); // 执行更新语句
      } else {
        return -1;
      }
    }

    /** 成员方法7：修改指定读者信息 */
    public static int updateReader(Reader reader) {
      if (reader != null) {
        // 获取读者信息
        String id = reader.getId();
        String name = reader.getName();
        String type = reader.getType();
        String sex = reader.getSex();
        int max_num = reader.getMax_num();
        int days_num = reader.getDays_num();
        // 构造修改读者的SQL更新语句
        String sql = "update reader set name='" + name + "',type='" + type + "',sex='"
          + sex + "', max_num=" + max_num + ",days_num=" + days_num
          + " where id='" + id + "'";
        return BaseDao.executeUpdate(sql);// 执行更新语句
      } else {
        return -1;
      }
    }

    /** 成员方法8：删除指定读者 */
    public static int deleteReader(String id) {
      // 构造按读者编号删除读者的SQL更新语句
      String sql = "delete from reader  where id='" + id + "'";
      return BaseDao.executeUpdate(sql);// 执行更新语句
    }

    /** 成员方法9：清空所有读者信息 */
    public static void emptyReader() {
      // 构造删除读者的SQL更新语句
      String sql = "delete from reader";
      BaseDao.executeUpdate(sql);// 执行更新语句
    }
  }
}
