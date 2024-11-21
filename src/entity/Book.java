package entity;

/**
 * 类功能：用于设置、获取图书对象的属性信息
 *
 * @author Administrator
 */
public class Book {
  /* 成员变量*/
  private String id;    // 表示图书的编号
  private String name;// 表示图书的名称
  private String type;// 表示图书的类型
  private String author;// 表示图书的作者
  private String translator;// 表示图书的译者
  private String publisher;// 表示图书的出版社
  private String publish_time;// 表示图书的出版时间
  private int stock;// 表示图书的库存量
  private double price;// 表示图书的价格

  /**
   * 成员方法的功能:获取图书编号
   */

  public String getId() {// 获取图书的编号
    return id;
  }

  /**
   * 成员方法的功能:设置图书编号
   */
  public void setId(String id) {// 设置图书的编号
    this.id = id;
  }

  /**
   * 成员方法的功能:获取图书名称
   */
  public String getName() {// 获取图书的名称
    return name;
  }

  /**
   * 成员方法的功能:设置图书名称
   */
  public void setName(String name) {// 设置图书的名称
    this.name = name;
  }

  /**
   * 成员方法的功能:获取图书类型
   */
  public String getType() {// 获取图书的类型
    return type;
  }

  /**
   * 成员方法的功能:设置图书类型
   */
  public void setType(String type) {// 设置图书的类型
    this.type = type;
  }

  /**
   * 成员方法的功能:获取图书作者
   */
  public String getAuthor() {// 获取图书的作者
    return author;
  }

  /**
   * 成员方法的功能:设置图书作者
   */
  public void setAuthor(String author) {// 设置图书的作者
    this.author = author;
  }

  /**
   * 成员方法的功能:获取图书的译者
   */
  public String getTranslator() {// 获取图书的译者
    return translator;
  }

  /**
   * 成员方法的功能:设置图书的译者
   */
  public void setTranslator(String translator) {// 设置图书的译者
    this.translator = translator;
  }

  /**
   * 成员方法的功能:获取图书的出版社
   */
  public String getPublisher() {// 获取图书的出版社
    return publisher;
  }

  /**
   * 成员方法的功能:设置图书的出版社
   */
  public void setPublisher(String publisher) {// 设置图书的出版社
    this.publisher = publisher;
  }

  /**
   * 成员方法的功能:获取图书的出版时间
   */
  public String getPublish_time() {// 获取图书的出版时间
    return publish_time;
  }

  /**
   * 成员方法的功能:设置图书的出版时间
   */
  public void setPublish_time(String publish_time) {// 设置图书的出版时间
    this.publish_time = publish_time;
  }

  /**
   * 成员方法的功能:获取图书的库存量
   */
  public int getStock() {// 获取图书的库存量
    return stock;
  }

  /**
   * 成员方法的功能:设置图书的库存量
   */
  public void setStock(int stock) {// 设置图书的库存量
    this.stock = stock;
  }

  /**
   * 成员方法的功能:获取图书的价格
   */
  public double getPrice() {// 获取图书的价格
    return price;
  }

  /**
   * 成员方法的功能:设置图书的价格
   */
  public void setPrice(double price) {// 设置图书的价格
    this.price = price;
  }
}
