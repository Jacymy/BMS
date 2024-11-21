package entity;

import java.util.Date;

/**
 * 类功能：用于设置、获取借阅信息
 *
 * @author Administrator
 */
public class Borrow {
  /*成员变量*/
  private int id;// 表示借阅号
  private String book_id;// 表示图书编号
  private String reader_id;// 表示读者编号
  private Date borrow_date;// 表示借阅日期
  private Date back_date;// 表示还书日期
  private boolean is_back;// 表示是否还书

  /**
   * 成员方法的功能:获取借阅号
   */
  public int getId() {// 获取借阅号
    return id;
  }

  /**
   * 成员方法的功能:设置借阅号
   */
  public void setId(int id) {// 设置借阅号
    this.id = id;
  }

  /**
   * 成员方法的功能:获取图书编号
   */
  public String getBook_id() {// 获取图书编号
    return book_id;
  }

  /**
   * 成员方法的功能:设置图书编号
   */
  public void setBook_id(String book_id) {// 设置图书编号
    this.book_id = book_id;
  }

  /**
   * 成员方法的功能:获取读者编号
   */
  public String getReader_id() {// 获取读者编号
    return reader_id;
  }

  /**
   * 成员方法的功能:设置读者编号
   */
  public void setReader_id(String reader_id) {// 设置读者编号
    this.reader_id = reader_id;
  }

  /**
   * 成员方法的功能:获取借阅日期
   */
  public Date getBorrow_date() {// 获取借阅日期
    return borrow_date;
  }

  /**
   * 成员方法的功能:设置借阅日期
   */
  public void setBorrow_date(Date borrow_date) {// 设置借阅日期
    this.borrow_date = borrow_date;
  }

  /**
   * 成员方法的功能:获取还书日期
   */
  public Date getBack_date() {// 获取还书日期
    return back_date;
  }

  /**
   * 成员方法的功能:设置还书日期
   */
  public void setBack_date(Date back_date) {// 设置还书日期
    this.back_date = back_date;
  }

  /**
   * 成员方法的功能:获取是否还书信息
   */
  public boolean isIs_back() {// 判断是否还书
    return is_back;
  }

  /**
   * 成员方法的功能:设置是否还书信息
   */
  public void setIs_back(boolean is_back) {// 设置是否还书
    this.is_back = is_back;
  }
}
