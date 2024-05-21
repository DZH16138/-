package com.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.dao.StudentDao;
import com.entity.Student;

public class ManageFormStu extends JFrame {
    private final JTextField unameTextField;
    private final JTextField emailTextField;
    private JComboBox comboBox;
    private final JTextField phoneTextField;
    private final JTextField ageField;
    private final JTextField uidTextField;
    private final JRadioButton manRadioButton;
    private final JRadioButton nvRadioButton;
    private final JTextField uQQTextField;
    private final JTextField uUsernameTextField;
    private final JTextField uPasswordTextField;
    private final StudentDao dao = new StudentDao();//数据库访问类

    /**
     * Create the frame
     */
    public ManageFormStu(String uname) {
        super();

        // --------------------
        //    Initialize GUI

        // Title bar and background
        getContentPane().setLayout(null);
        setTitle("学生信息管理-学生");
        setBounds(300, 260, 500, 407);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JPanel panel_1 = new JPanel();
        panel_1.setBorder(new LineBorder(Color.black, 1, false));
        panel_1.setBounds(10, 310, 473, 40);
        getContentPane().add(panel_1);

        final JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(Color.black, 1, false));
        panel.setLayout(null);
        panel.setBounds(11, 10, 472, 295);
        getContentPane().add(panel);

        // Student data colum
        final JLabel label = new JLabel();
        label.setText("学号：");
        label.setBounds(125, 12, 66, 18);
        panel.add(label);

        uidTextField = new JTextField();
        uidTextField.setBounds(197, 10, 153, 22);
        panel.add(uidTextField);

        final JLabel label_1 = new JLabel();
        label_1.setText("年龄：");
        label_1.setBounds(128, 81, 66, 18);
        panel.add(label_1);

        ageField = new JTextField();
        ageField.setBounds(200, 79, 150, 22);
        panel.add(ageField);

        final JLabel label_2 = new JLabel();
        label_2.setText("电话：");
        label_2.setBounds(127, 222, 66, 18);
        panel.add(label_2);

        phoneTextField = new JTextField();
        phoneTextField.setBounds(199, 220, 151, 22);
        panel.add(phoneTextField);

        final JLabel label_3 = new JLabel();
        label_3.setText("用户名");
        label_3.setBounds(127, 140, 66, 18);
        panel.add(label_3);
        uUsernameTextField = new JTextField();
        uUsernameTextField.setBounds(199, 140, 151, 22);
        panel.add(uUsernameTextField);

        final JLabel label_4 = new JLabel();
        label_4.setText("密码");
        label_4.setBounds(127, 170, 66, 18);
        panel.add(label_4);
        uPasswordTextField = new JTextField();
        uPasswordTextField.setBounds(199, 170, 151, 22);
        panel.add(uPasswordTextField);

        final JLabel label_8 = new JLabel();
        label_8.setText("QQ");
        label_8.setBounds(127, 245, 66, 18);
        panel.add(label_8);
        uQQTextField = new JTextField();
        uQQTextField.setBounds(199, 245, 151, 22);
        panel.add(uQQTextField);

//        final JLabel label_9 =new JLabel();
//        label_9.setText("班级");
//        label_9.setBounds(127,270,66,18);
//        panel.add(label_9);
//        uClassTextField =new JTextField();
//        uClassTextField.setBounds(199,270,151,22);
//        panel.add(uClassTextField);

        JTextField regDate_textField = new JTextField();
        regDate_textField.setEditable(false);
        regDate_textField.setBounds(199, 250, 151, 22);
        panel.add(regDate_textField);

        final JLabel label_2_2 = new JLabel();
        label_2_2.setText("E-mail：");
        label_2_2.setBounds(128, 195, 66, 18);
        panel.add(label_2_2);

        emailTextField = new JTextField();
        emailTextField.setBounds(200, 195, 150, 22);
        panel.add(emailTextField);

        unameTextField = new JTextField();
        unameTextField.setBounds(198, 42, 152, 22);
        panel.add(unameTextField);

        final JLabel label_5 = new JLabel();
        label_5.setText("姓名：");
        label_5.setBounds(126, 44, 66, 18);
        panel.add(label_5);

        manRadioButton = new JRadioButton();
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(manRadioButton);
        manRadioButton.setText("男");
        manRadioButton.setBounds(197, 110, 38, 24);
        panel.add(manRadioButton);

        nvRadioButton = new JRadioButton();
        nvRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
            }
        });
        nvRadioButton.setText("女");
        buttonGroup.add(nvRadioButton);
        nvRadioButton.setBounds(255, 110, 48, 24);
        panel.add(nvRadioButton);

        final JLabel label_6 = new JLabel();
        label_6.setText("性别：");
        label_6.setBounds(127, 112, 66, 18);
        panel.add(label_6);

        // Initialize the modify button
        JButton button_mod = new JButton();
        button_mod.setText("修改");
        button_mod.setEnabled(false);
        button_mod.addActionListener((ActionEvent e) -> onModify());
        panel_1.add(button_mod);

        final JButton button_4=new JButton();
        button_4.setText("课程成绩查询");
        button_4.addActionListener((ActionEvent e)->liftCurriForm());
        panel_1.add(button_4);

        // Initialize the exit button
        final JButton button_3 = new JButton();
        button_3.setText("退出");
        button_3.addActionListener((ActionEvent e) -> onExit());
        panel_1.add(button_3);



        // --------------------
        //  End initialize GUI
        // --------------------

        // Retrieve the student data and show it
        Student student = dao.queryStudentByUsername(uname);
        if (student == null) {
            JOptionPane.showMessageDialog(ManageFormStu.this, "查无此人！！");
            return;
        }
        showData(student);

        //修改按钮可用
        button_mod.setEnabled(true);

//        final JButton button_4 = new JButton();
//        button_4.addActionListener(new ActionListener() {
//            public void actionPerformed(final ActionEvent e) {
//                AddForm af = new AddForm();
//                af.setVisible(true);
//            }
//        });
//        button_4.setText("注册");
//        panel_1.add(button_4);

        //final JButton button_2 = new JButton();
        //button_2.setInheritsPopupMenu(true);
        //button_2.addActionListener(new ActionListener() {
        //    public void actionPerformed(final ActionEvent e) {
                ///////////////////////查询事件////////////////////////////////

        //    }
        //});
        //button_2.setText("查询");
        //panel_1.add(button_2);



//        final JButton button = new JButton();
//        button.addActionListener(new ActionListener() {
//            public void actionPerformed(final ActionEvent e) {
//
//                int flag = JOptionPane.showConfirmDialog(ManageForm.this, "您确定删除此学员信息么？");
//                if(flag!=JOptionPane.OK_OPTION){
//                    return;
//                }
//
//                String sid = uidTextField.getText();
//                if(sid==null || sid.trim().equals("")){
//                    JOptionPane.showMessageDialog(ManageForm.this, "请输入学员编号！");
//                    return;
//                }
//
//                boolean is = dao.delStudent(Integer.parseInt(sid));
//                if(is){
//                    uidTextField.setText("");
//                    unameTextField.setText("");
//                    ageField.setText("");
//                    emailTextField.setText("");
//                    phoneTextField.setText("");
//                    uUsernameTextField.setText("");
//                    uPasswordTextField.setText("");
//                    uQQTextField.setText("");
//                    uClassTextField.setText("");
//                    manRadioButton.setSelected(false);
//                    nvRadioButton.setSelected(false);
//                    comboBox.setSelectedIndex(0);
//
//                    JOptionPane.showMessageDialog(ManageFormStu.this, "删除成功！");
//                }else{
//                    JOptionPane.showMessageDialog(ManageFormStu.this, "删除失败！");
//                }
//            }
//        });
//        button.setText("删除");
//        panel_1.add(button);

//        final JButton button_5 = new JButton();
//        button_5.addActionListener(new ActionListener() {
//            public void actionPerformed(final ActionEvent e) {
//                new SearchFrame().setVisible(true);
//            }
//        });
//        button_5.setText("条件查询");
//        panel_1.add(button_5);
    }

    private void onModify() {
        Student student = new Student();
        student.setSid(uidTextField.getText());
        student.setEmail(emailTextField.getText());
        student.setSage(Integer.parseInt(ageField.getText()));
        student.setPhone(phoneTextField.getText());
        student.setSname(unameTextField.getText());
        student.setQQNumber(uQQTextField.getText());
        student.setUsername(uUsernameTextField.getText());
        student.setPassword(uPasswordTextField.getText());

        student.setSex(manRadioButton.isSelected());

        boolean is = dao.update(student);
        if (is) {
            JOptionPane.showMessageDialog(ManageFormStu.this, "修改成功！");
        } else {
            JOptionPane.showMessageDialog(ManageFormStu.this, "修改失败！");
        }
    }

    private void onExit() {
        int sel = JOptionPane.showConfirmDialog(ManageFormStu.this, "您确定退出系统么？");
        if (sel == JOptionPane.OK_OPTION) {
            System.exit(0);
        }
    }
    private void showData(Student student) {
        uidTextField.setText(student.getSid());
        unameTextField.setText(student.getSname());
        ageField.setText(student.getSage() + "");
        emailTextField.setText(student.getEmail());
        phoneTextField.setText(student.getPhone());
        uQQTextField.setText(student.getQQNumber());
        uPasswordTextField.setText(student.getPassword());
        uUsernameTextField.setText(student.getUsername());

        if (student.isSex()) {
            manRadioButton.setSelected(true);
        } else {
            nvRadioButton.setSelected(true);
        }
    }
    private void liftCurriForm(){
        CurriFormStu cfs = new CurriFormStu(unameTextField.getText());
        cfs.setVisible(true);
    }
}
