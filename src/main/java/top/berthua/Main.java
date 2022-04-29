package top.berthua;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void makeButton(String title, JFrame frame, GridBagLayout gridBagLayout, GridBagConstraints constraints, JTextField textField) {
        JButton button = new CustomButton(title, textField);
        gridBagLayout.setConstraints(button, constraints);
        frame.add(button);
    }

    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("Calculator4j");
        GridBagLayout gbaglayout = new GridBagLayout();    //创建GridBagLayout布局管理器
        GridBagConstraints constraints = new GridBagConstraints();
        frame.setLayout(gbaglayout);    //使用GridBagLayout布局管理器
        constraints.fill = GridBagConstraints.BOTH;    //组件填充显示区域
        constraints.weightx = 0.0;    //恢复默认值
        constraints.gridwidth = GridBagConstraints.REMAINDER;    //结束行
        JTextField tf = new JTextField("114514+1919810");
        tf.setFont(Font.createFont(Font.TRUETYPE_FONT, Main.class.getResourceAsStream("/JetBrainsMono-Medium.ttf")).deriveFont(Font.PLAIN, 22f));
        tf.setBackground(Color.darkGray);
        tf.setForeground(Color.WHITE);
        tf.setEnabled(false);
        frame.add(tf);
        gbaglayout.setConstraints(tf, constraints);
        constraints.fill = GridBagConstraints.BOTH;    //组件填充显示区域
        constraints.weightx = 0.0;    //恢复默认值
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        JTextField tf1 = new JTextField();
        tf1.setFont(Font.createFont(Font.TRUETYPE_FONT, Main.class.getResourceAsStream("/JetBrainsMono-Medium.ttf")).deriveFont(Font.PLAIN, 22f));
        tf1.setForeground(Color.WHITE);
        tf1.setBackground(Color.darkGray);
        tf1.setEnabled(false);
        frame.add(tf1);
        gbaglayout.setConstraints(tf1, constraints);
        constraints.weightx = 0.5;    // 指定组件的分配区域
        constraints.weighty = 0.2;
        constraints.gridwidth = 1;
        makeButton("C", frame, gbaglayout, constraints, tf);
        makeButton("←", frame, gbaglayout, constraints, tf);
        makeButton("%", frame, gbaglayout, constraints, tf);
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        makeButton("/", frame, gbaglayout, constraints, tf);
        constraints.gridwidth = 1;
        makeButton("7", frame, gbaglayout, constraints, tf);    //调用方法，添加按钮组件
        makeButton("8", frame, gbaglayout, constraints, tf);
        makeButton("9", frame, gbaglayout, constraints, tf);
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        makeButton("*", frame, gbaglayout, constraints, tf);
        constraints.gridwidth = 1;    //重新设置gridwidth的值

        makeButton("4", frame, gbaglayout, constraints, tf);
        makeButton("5", frame, gbaglayout, constraints, tf);
        makeButton("6", frame, gbaglayout, constraints, tf);
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        makeButton("-", frame, gbaglayout, constraints, tf);
        constraints.gridwidth = 1;

        makeButton("1", frame, gbaglayout, constraints, tf);
        makeButton("2", frame, gbaglayout, constraints, tf);
        makeButton("3", frame, gbaglayout, constraints, tf);
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        makeButton("+", frame, gbaglayout, constraints, tf);
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        JButton zero = new Zero("0", tf);
        gbaglayout.setConstraints(zero, constraints);
        frame.add(zero);
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        JButton calculation = new CalculationButton("计算", tf, tf1, frame);
        gbaglayout.setConstraints(calculation, constraints);
        frame.add(calculation);
        constraints.gridwidth = 1;
        frame.setBounds(400, 400, 251, 441);    //设置容器大小
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
