package com.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import com.dao.StudentDao;


public class CurriFormStu extends JFrame {
    //    private final JTextField textFieldStuName;
    private final JTextField textFieldCurriName;
    private final JTable table;
    private final Vector<String> header;

    private final StudentDao dao = new StudentDao();

    public CurriFormStu(String stuName) {
        super();
        setTitle("学生课程查询");
        getContentPane().setLayout(null);
        setBounds(100, 100, 600, 400);


        final JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 550, 250);
        getContentPane().add(scrollPane);

        header = new Vector<>();
        String[] sarry = {"学生姓名", "课程名", "成绩", "课程代码", "任课教师"};
        int i = 0;
        while (i != sarry.length) {
            header.add(sarry[i]);
            i++;
        }


        Vector<Vector<Object>> data0 = new Vector<>();
        table = new JTable(data0, header);
        scrollPane.setViewportView(table);

        final JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(Color.black, 1, false));
        panel.setLayout(null);
        panel.setBounds(10, 260, 550, 90);
        getContentPane().add(panel);

//        final JLabel label = new JLabel();
//        label.setBounds(30, 15, 66, 18);
//        panel.add(label);
//        label.setText("学生姓名");
//        textFieldStuName = new JTextField();
//        textFieldStuName.setBounds(95, 15, 105, 22);
//        panel.add(textFieldStuName);

        final JLabel label_2 = new JLabel();
        label_2.setText("课程名");
        label_2.setBounds(165, 15, 53, 18);
        panel.add(label_2);
        textFieldCurriName = new JTextField();
        textFieldCurriName.setBounds(220, 15, 106, 22);
        panel.add(textFieldCurriName);

        Vector<Vector<Object>> data = dao.queryCurri(stuName, "");
        DefaultTableModel mode = (DefaultTableModel) table.getModel();
        mode.setDataVector(data, header);

        final JButton button = new JButton();
        button.setBounds(165, 45, 105, 25);
        button.setText("查询");
        panel.add(button);

        JButton button_3 = new JButton();
        button_3.setBounds(285, 45, 105, 25);
        button_3.setText("返回");
        button_3.addActionListener((ActionEvent e) -> onExit());
        panel.add(button_3);


        button.addActionListener(e -> {
            if (textFieldCurriName.getText().equals("")) {
                JOptionPane.showMessageDialog(CurriFormStu.this, "请输入要查找的课程名!查找全部请输入%");
            } else if (textFieldCurriName.getText().equals("%")) {
                Vector<Vector<Object>> data1 = dao.queryCurri(stuName, "");
                DefaultTableModel mode1 = (DefaultTableModel) table.getModel();
                mode1.setDataVector(data1, header);
            } else {
                Vector<Vector<Object>> data1 = dao.queryCurri(stuName, textFieldCurriName.getText());
                DefaultTableModel mode1 = (DefaultTableModel) table.getModel();
                mode1.setDataVector(data1, header);
            }
        });
    }
    private void onExit(){
        this.setDefaultCloseOperation(GradeModifyForm.DISPOSE_ON_CLOSE);
        this.setVisible(false);

    }
}
