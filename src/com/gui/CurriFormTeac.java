package com.gui;

import com.dao.StudentDao;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

public class CurriFormTeac extends JFrame {
    private final JTextField textFieldStuName;
    private final JTextField textFieldCurriName;
    private final JTable table;
    private final Vector<String> header;

    private final StudentDao dao = new StudentDao();

    public CurriFormTeac() {
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
        final JLabel label_1 = new JLabel();
        label_1.setText("学生姓名");
        label_1.setBounds(65, 15, 53, 18);
        panel.add(label_1);
        textFieldStuName = new JTextField();
        textFieldStuName.setBounds(120, 15, 106, 22);
        panel.add(textFieldStuName);

        final JLabel label_2 = new JLabel();
        label_2.setText("课程名");
        label_2.setBounds(265, 15, 53, 18);
        panel.add(label_2);
        textFieldCurriName = new JTextField();
        textFieldCurriName.setBounds(320, 15, 106, 22);
        panel.add(textFieldCurriName);

        final JButton button = new JButton();
        button.setBounds(285, 45, 105, 25);
        button.setText("查询");
        panel.add(button);

        final JButton button2 = new JButton();
        button2.setBounds(165, 45, 105, 25);
        button2.setText("修改成绩");
        panel.add(button2);

        JButton button_3 = new JButton();
        button_3.setText("返回");
        button_3.addActionListener((ActionEvent e) -> onExit());
        panel.add(button_3);


//        button.addActionListener((ActionEvent e) -> Vector<Vector<Object>> data = dao.queryCurri(textFieldStuName.getText(), textFieldCurriName.getText()));


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vector<Vector<Object>> data = dao.queryCurri(textFieldStuName.getText(), textFieldCurriName.getText());
                DefaultTableModel mode = (DefaultTableModel) table.getModel();
                mode.setDataVector(data, header);
            }
        });

        button2.addActionListener((ActionEvent e) -> liftGradeModifyForm());
    }
    private void onExit(){
        this.setDefaultCloseOperation(GradeModifyForm.DISPOSE_ON_CLOSE);
        this.setVisible(false);

    }
    private void liftGradeModifyForm () {
        GradeModifyForm mfg = new GradeModifyForm();
        mfg.setVisible(true);
    }
}
