package windows;

import entity.Reader;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class ReaderQuery extends PublicJFrame {
  /**
   * 成员变量
   */
  JLabel lb_query;// 声明查询标签
  JTextField tf_query;// 声明查询条件文本框
  JComboBox<String> cb_query;// 声明查询栏目组合框
  JButton bt_query;// 声明查询按钮

  // 调用方法，获取所有读者列表，并保存
  private List<Reader> list = ReaderDao.selectReaderList();
  // 读者表栏目名称
  private final String[] tb_heads = {"读者编号 ", "读者姓名 ", "读者类型", "性别",
    "可借数量", "可借天数"};
  // 读者表栏目名称对应的表字段
  private final String[] fields = {"id", "name", "type", "sex",
    "max_num", "days_num"};
  // 创建读者表格模型
  private final DefaultTableModel model = new DefaultTableModel(
    new Object[][]{}, tb_heads);
  private String field = "id";// 设置默认当前查询字段
  String valueStr = "";// 设置字符串类型查询字段的字段值
  int valueInt = 0;// 设置整型查询字段的字段值

  /**
   * 构造方法：“读者查询”界面初始化方法
   */
  ReaderQuery() {
    // 设置界面
    this.setTitle("--读者查询-- ");
    this.setVisible(true);
    this.setSize(1000, 500);
    this.setLocationRelativeTo(null);// 设置界面居中
    // 创建、设置“查询面板”
    JPanel queryPanel = createQueryPanel();
    this.add(queryPanel, BorderLayout.NORTH);
    // 创建、设置“表格面板”
    JPanel tablePanel = createTablePanel();
    this.add(tablePanel, BorderLayout.CENTER);

  }

  /**
   * 成员方法1：创建“查询面板”方法
   */
  private JPanel createQueryPanel() {
    JPanel queryPanel = new JPanel();
    queryPanel.setOpaque(false);
    queryPanel.setLayout(new GridBagLayout());
    ((GridBagLayout) queryPanel
      .getLayout()).columnWidths = new int[]{0, 100, 200,
      120, 80, 80, 0};
    ((GridBagLayout) queryPanel
      .getLayout()).columnWeights = new double[]{0.5, 0.0,
      0.0, 0.0, 0.0, 0.0, 0.5};

    lb_query = new JLabel("请输入读者编号");
    queryPanel.add(lb_query,
      new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
        GridBagConstraints.EAST,
        GridBagConstraints.BOTH,
        new Insets(10, 10, 10, 10), 0, 0));

    tf_query = new JTextField();
    tf_query.requestFocus();
    // 为查询条件文本框，添加回车事件监听器
    tf_query.addKeyListener(new KeyAdapter() {
      public void keyTyped(KeyEvent arg0) {
        if (arg0.getKeyChar() == '\n') {
          query_actionPerformed();// 调用“查询”按钮事件响应方法
        }
      }
    });
    queryPanel.add(tf_query,
      new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
        GridBagConstraints.CENTER,
        GridBagConstraints.BOTH,
        new Insets(10, 0, 10, 10), 0, 0));

    cb_query = new JComboBox<>(tb_heads);
    // 为查询栏目组合框，添加栏目事件监听器
    // 调用“查询栏目”组合框栏目状态被改变事件响应方法
    cb_query.addItemListener(this::cb_query_itemStateChanged);
    queryPanel.add(cb_query,
      new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
        GridBagConstraints.CENTER,
        GridBagConstraints.BOTH,
        new Insets(10, 0, 10, 10), 0, 0));

    bt_query = new JButton("查询 ");
    // 为“查询”按钮，添加单击事件监听器
    bt_query.addActionListener(_ -> {
      // 调用“查询”按钮事件响应方法
      query_actionPerformed();
    });
    queryPanel.add(bt_query,
      new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0,
        GridBagConstraints.CENTER,
        GridBagConstraints.BOTH,
        new Insets(10, 0, 10, 10), 0, 0));

    JButton bn_close = new JButton("关闭");
    // 为“关闭”按钮，添加单击事件监听器
    bn_close.addActionListener(_ -> {
      dispose();// 关闭界面
    });
    queryPanel.add(bn_close,
      new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0,
        GridBagConstraints.CENTER,
        GridBagConstraints.BOTH,
        new Insets(10, 0, 10, 10), 0, 0));
    return queryPanel;// 返回“查询面板”
  }

  /**
   * 成员方法2：创建“表格面板”方法
   */
  private JPanel createTablePanel() {
    // 创建表格面板，采用边界布局
    JPanel tablePanel = new JPanel(new BorderLayout(5, 5));
    JScrollPane scrollPane = new JScrollPane();// 创建滚动面板
    tablePanel.add(scrollPane);// 将表格面板添加到滚动面板上
    // 声明表格
    JTable table = new JTable(model);// 创建表格，并采用指定的表格模型
    addRowToModel(list);// 将读者列表，添加到表格模型中
    scrollPane.setViewportView(table);
    return tablePanel;// 返回“表格面板”
  }

  /**
   * 成员方法3：向表格模型，添加读者列表
   */
  private void addRowToModel(List<Reader> list) {
    model.setRowCount(0);// 清除表格模型中的数据
    for (Reader value : list) {
      // 将这个读者对象的属性，添加到读者表格模型中保存数据
      model.addRow(new Object[]{value.getId(),
        value.getName(), value.getType(),
        value.getSex(), value.getMax_num(),
        value.getDays_num()});
    }
  }

  /**
   * 成员方法4：“查询组合框”状态被改变的事件响应方法
   */
  private void cb_query_itemStateChanged(ItemEvent arg0) {
    if (arg0.getStateChange() == ItemEvent.SELECTED) {
      // 根据选择字段，改变标签显示内容
      lb_query.setText("请输入" + arg0.getItem() + ":");
      tf_query.setText("");
      // 获取组合框中选定的栏目名称
      for (int i = 0; i < tb_heads.length; i++) {
        if (arg0.getItem().equals(tb_heads[i])) {
          field = fields[i];// 保存对应的字段，作为当前被选定的字段
        }
      }
      list = ReaderDao.selectReaderList();// 获取所有读者列表
      addRowToModel(list);// 将读者列表，添加到表格模型中
      tf_query.requestFocus();// 设置查询条件文本框，获得焦点
    }
  }

  /**
   * 成员方法5：“查询”按钮单击事件响应方法
   */
  private void query_actionPerformed() {
    // 查询字段数据类型不同，执行的查询语句不同
    switch (field) {
      case "id":
      case "name":
      case "type":
      case "sex":
        valueStr = tf_query.getText();// 获取字符串类型的查询条件
        // 调用按照（字段名、字符串字段值）查询读者列表的方法，查询读者信息
        list = ReaderDao.selectReaderList(field, valueStr);
        break;
      case "max_num":
      case "days_num":
        if (tf_query.getText().isEmpty()) {
          valueInt = 0;
        } else {
          valueInt = new Double(tf_query.getText()).intValue();
        }
        // 调用按照（字段名、整型字段值）查询读者列表的方法，查询读者信息
        list = ReaderDao.selectReaderList(field, valueInt);
        break;
    }
    addRowToModel(list);// 将查询获取的读者列表，添加到表格模型中
  }

  /**
   * 测试方法： 用于“读者查询”模块的测试
   */
  public static void main(String[] args) {
    new ReaderQuery();// 创建“读者查询”界面
  }
}
