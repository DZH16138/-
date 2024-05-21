package com.gui;

import com.dao.StudentDao;
import com.entity.Student;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

public class GradeModifyForm extends JFrame {
    private final JTextField textFieldStudent;
    private final JTextField textFieldCurriName;
    private final JTextField textFieldId;
    private final JTextField textFieldTeacher;
    private final JTextField textFieldGrade;
    private int No;

    public GradeModifyForm() {
        super();
        getContentPane().setLayout(null);
        setTitle("成绩修改页面");
        setBounds(300, 260, 500, 240);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JPanel panel_1 = new JPanel();
        panel_1.setBorder(new LineBorder(Color.black, 1, false));
        panel_1.setBounds(11, 150, 473, 40);
        getContentPane().add(panel_1);

        final JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(Color.black, 1, false));
        panel.setLayout(null);
        panel.setBounds(11, 10, 472, 150);
        getContentPane().add(panel);

        final JLabel label = new JLabel();
        label.setText("学生姓名：");
        label.setBounds(125, 12, 66, 18);
        panel.add(label);
        textFieldStudent = new JTextField();
        textFieldStudent.setBounds(195, 12, 150, 22);
        panel.add(textFieldStudent);

        final JLabel label_1 = new JLabel();
        label_1.setText("课程名：");
        label_1.setBounds(125, 35, 66, 18);
        panel.add(label_1);
        textFieldCurriName = new JTextField();
        textFieldCurriName.setBounds(195, 35, 150, 22);
        panel.add(textFieldCurriName);

        final JLabel label_2 = new JLabel();
        label_2.setText("课程号：");
        label_2.setBounds(125, 110, 66, 18);
        panel.add(label_2);
        textFieldId = new JTextField();
        textFieldId.setBounds(195, 110, 150, 22);
        panel.add(textFieldId);

        final JLabel label_3 = new JLabel();
        label_3.setText("任课教师");
        label_3.setBounds(125, 60, 66, 18);
        panel.add(label_3);
        textFieldTeacher = new JTextField();
        textFieldTeacher.setBounds(195, 60, 150, 22);
        panel.add(textFieldTeacher);

        final JLabel label_4 = new JLabel();
        label_4.setText("课程分数");
        label_4.setBounds(125, 85, 66, 18);
        panel.add(label_4);
        textFieldGrade = new JTextField();
        textFieldGrade.setBounds(195, 85, 150, 22);
        panel.add(textFieldGrade);

        JButton button_1 = new JButton();
        button_1.setText("查询");
        button_1.addActionListener((ActionEvent e) -> queryCurri(textFieldStudent.getText(), textFieldCurriName.getText()));
        panel_1.add(button_1);

        JButton button_2 = new JButton();
        button_2.setText("修改");
        button_2.addActionListener((ActionEvent e) -> modifyCurri());
        panel_1.add(button_2);

        JButton button_3 = new JButton();
        button_3.setText("返回");
        button_3.addActionListener((ActionEvent e) -> onExit());
        panel_1.add(button_3);
    }

    private void onExit(){
        this.setDefaultCloseOperation(GradeModifyForm.DISPOSE_ON_CLOSE);
        this.setVisible(false);

    }

    private void modifyCurri() {
        Student stu=new Student();
        stu.setSname(textFieldStudent.getText());
        stu.setCurriName(textFieldCurriName.getText());
        stu.setCurriId(textFieldId.getText());
        stu.setCteacher(textFieldTeacher.getText());
        stu.setCgrade(Integer.parseInt(textFieldGrade.getText()));
        stu.setNo(this.No);

        StudentDao dao=new StudentDao();
        boolean is=dao.updateCurri(stu);
        if(is)
            JOptionPane.showMessageDialog(GradeModifyForm.this, "修改成功！");
        else
            JOptionPane.showMessageDialog(GradeModifyForm.this, "修改失败！");
    }

    private void queryCurri(String stuName, String CurriName) {
        StudentDao dao = new StudentDao();
        if (stuName.equals("") & !CurriName.equals("")) {
            Student stu = dao.queryCurriByCurriName(CurriName);
            initialize(stu);
        } else if (!stuName.equals("") & CurriName.equals("")) {
            Student stu = dao.queryCurriByName(stuName);
            initialize(stu);
        } else if (stuName.equals("") & stuName.equals("")) {
            JOptionPane.showMessageDialog(GradeModifyForm.this, "姓名课程名请至少输入一个！");
        } else {
            Student stu = dao.queryStudentByBoth(stuName, CurriName);
            initialize(stu);
        }
    }
private void initialize(Student stu){
        this.textFieldStudent.setText(stu.getSname());
        this.textFieldCurriName.setText(stu.getCurriName());
        this.textFieldId.setText(stu.getCurriId());
        this.textFieldTeacher.setText(stu.getCteacher());
        this.textFieldGrade.setText(stu.getCgrade()+"");
        this.No=stu.getNo();
        }
}
