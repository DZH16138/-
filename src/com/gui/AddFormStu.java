package com.gui;


import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


import javax.swing.ButtonGroup;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


import com.dao.StudentDao;
import com.entity.Student;

public class AddFormStu extends JFrame {

    private ButtonGroup buttonGroup = new ButtonGroup();
    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private JLabel jLabel = null;
    private JTextField jNameTextField = null;
    private JButton jButton = null;
    private JLabel jUAgeLabel1 = null;
    private JTextField jAgeTextfield = null;
    private JLabel jEmailLabel1 = null;
    private JTextField jEmailTextField1 = null;
    private JLabel jPhoneLabel1 = null;
    private JTextField jPhoneTextField1 = null;

    private JLabel jQQTextLabel = null;
    private JTextField jQQTextField = null;

    private JLabel jStuIdTextLabel = null;
    private JTextField jStuIdTextField = null;

    private JLabel jUserNameTextLabel = null;
    private JTextField jUserNameTextField = null;

    private JLabel jPassWordTextLabel = null;
    private JTextField jPassWordTextField = null;
    private JLabel jSurePWlabel = null;
    private JTextField jSurePwTextField = null;

    private JButton jButton1 = null;
    private JRadioButton manRadioButton;
    private JRadioButton womanRadioButton;

    /**
     * This method initializes jTextField
     *
     * @return javax.swing.JTextField
     */
    private JTextField getJNameTextField() {
        if (jNameTextField == null) {
            jNameTextField = new JTextField();
            jNameTextField.setBounds(new Rectangle(131, 7, 101, 26));
        }
        return jNameTextField;
    }

    /**
     * This method initializes jButton
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton() {
        if (jButton == null) {
            jButton = new JButton();
            jButton.setBounds(new Rectangle(41, 307, 81, 28));
            jButton.setText("注册");
            jButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    //封装数据到实体类
                    Student student = new Student();

                    student.setEmail(jEmailTextField1.getText());
                    student.setPhone(jPhoneTextField1.getText());
                    student.setSage(Integer.parseInt(jAgeTextfield.getText()));

                    student.setSname(jNameTextField.getText());
                    student.setUsername(jUserNameTextField.getText());

                    student.setQQNumber(jQQTextField.getText());
                    student.setSid(jStuIdTextField.getText());


                    if (manRadioButton.isSelected()) {
                        student.setSex(true);
                    } else {
                        student.setSex(false);
                    }


                    boolean uNNull = true;
                    uNNull = !jUserNameTextField.getText().equals("");

                    boolean pWNull = true;
                    pWNull = !jPassWordTextField.getText().equals("");

                    boolean nameNull = true;
                    nameNull = !jNameTextField.getText().equals("");

                    boolean mailNull = true;
                    mailNull = !jEmailTextField1.getText().equals("");

                    //实例dao  执行保存
                    if (uNNull) {
                        if (pWNull) {
                            if (nameNull) {
                                if (mailNull) {
                                    String Name = jNameTextField.getText();
                                    char F = Name.charAt(0);
                                    boolean isName = String.valueOf(F).matches("[\u4e00-\u9fa5]");
                                    if (Name.length() >= 2 & Name.length() <= 10) {
                                    } else isName = false;
                                    if (jPhoneTextField1.getText().length() == 11) {
                                        if (student.getSage() <= 30 & student.getSage() >= 16) {
                                            if (isName) {
                                                boolean isEmail = true;
                                                String Email = jEmailTextField1.getText();
                                                if ((Email.charAt(Email.length() - 4) == '.') &
                                                        (Email.charAt(Email.length() - 3) == 'c') &
                                                        (Email.charAt(Email.length() - 2) == 'o') &
                                                        (Email.charAt(Email.length() - 1) == 'm')) {
                                                } else isEmail = false;
                                                if (isEmail) {
                                                    String username = jUserNameTextField.getText();
                                                    StudentDao dao0 = new StudentDao();
                                                    boolean isExist;
                                                    try {
                                                        isExist = dao0.queryUserName(username);
                                                    } catch (SQLException ex) {
                                                        throw new RuntimeException(ex);
                                                    }
                                                    if (isExist) {
                                                        String SurePassWord = jSurePwTextField.getText();
                                                        if (SurePassWord.equals(getjPassWordTextField().getText())) {
                                                            boolean is0 = student.setPassword(jPassWordTextField.getText());
                                                            if (is0) {
                                                                StudentDao dao = new StudentDao();
                                                                boolean is = dao.addStudent(student);
                                                                if (is) {
                                                                    AddFormStu.this.setVisible(false);
                                                                    JOptionPane.showMessageDialog(AddFormStu.this, "注册成功！");
                                                                } else {
                                                                    JOptionPane.showMessageDialog(AddFormStu.this, "注册失败！");
                                                                }
                                                            } else {
                                                                JOptionPane.showMessageDialog(AddFormStu.this, "密码应为六到十五位！");
                                                            }
                                                        } else {
                                                            JOptionPane.showMessageDialog(AddFormStu.this, "两次密码输入不同！");
                                                        }
                                                    } else {
                                                        JOptionPane.showMessageDialog(AddFormStu.this, "用户名已存在！");
                                                    }
                                                } else {
                                                    JOptionPane.showMessageDialog(AddFormStu.this, "邮箱格式错误！");
                                                }
                                            } else {
                                                JOptionPane.showMessageDialog(AddFormStu.this, "姓名应为中文且应为二到十个汉字！");
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(AddFormStu.this, "年龄有误！");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(AddFormStu.this, "电话号码有误！");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(AddFormStu.this, "请输入邮箱！");
                                }
                            } else {
                                JOptionPane.showMessageDialog(AddFormStu.this, "请输入名字！");
                            }
                        } else {
                            JOptionPane.showMessageDialog(AddFormStu.this, "请输入密码！");
                        }
                    } else {
                        JOptionPane.showMessageDialog(AddFormStu.this, "请输入用户名！");
                    }
                }
            });
        }
        return jButton;
    }

    /**
     * This method initializes jPasswordField
     *
     * @return javax.swing.JPasswordField
     */
    private JTextField getJAgeTextField() {
        if (jAgeTextfield == null) {
            jAgeTextfield = new JTextField();
            jAgeTextfield.setBounds(new Rectangle(131, 37, 100, 22));
        }
        return jAgeTextfield;
    }

    /**
     * This method initializes jEmailTextField1
     *
     * @return javax.swing.JTextField
     */
    private JTextField getJEmailTextField1() {
        if (jEmailTextField1 == null) {
            jEmailTextField1 = new JTextField();
            jEmailTextField1.setBounds(new Rectangle(131, 67, 101, 20));
        }
        return jEmailTextField1;
    }

    /**
     * This method initializes jPhoneTextField1
     *
     * @return javax.swing.JTextField
     */
    private JTextField getJPhoneTextField1() {
        if (jPhoneTextField1 == null) {
            jPhoneTextField1 = new JTextField();
            jPhoneTextField1.setBounds(new Rectangle(131, 97, 101, 26));
        }
        return jPhoneTextField1;
    }

    private JTextField getJStuClassTextField() {
        if (jStuIdTextField == null) {
            jStuIdTextField = new JTextField();
            jStuIdTextField.setBounds(new Rectangle(131, 127, 97, 21));
        }
        return jStuIdTextField;
    }

    private JTextField getjQQTextField() {
        if (jQQTextField == null) {
            jQQTextField = new JTextField();
            jQQTextField.setBounds(new Rectangle(131, 157, 97, 21));
        }
        return jQQTextField;
    }

    private JTextField getjUserNameTextField() {
        if (jUserNameTextField == null) {
            jUserNameTextField = new JTextField();
            jUserNameTextField.setBounds(new Rectangle(131, 187, 97, 21));
        }
        return jUserNameTextField;
    }

    private JTextField getjPassWordTextField() {
        if (jPassWordTextField == null) {
            jPassWordTextField = new JTextField();
            jPassWordTextField.setBounds(new Rectangle(131, 217, 97, 21));
        }
        return jPassWordTextField;
    }

    private JTextField getjSurePwTextField() {
        if (jSurePwTextField == null) {
            jSurePwTextField = new JTextField();
            jSurePwTextField.setBounds(new Rectangle(131, 247, 97, 21));
        }
        return jSurePwTextField;
    }

    /**
     * This method initializes jAddressComboBox
     *
     * @return javax.swing.JComboBox
     */


    /**
     * This method initializes jButton1
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton1() {
        if (jButton1 == null) {
            jButton1 = new JButton();
            jButton1.setBounds(new Rectangle(160, 307, 89, 29));
            jButton1.setText("取　消");
            jButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {

                    AddFormStu.this.dispose();

                    System.out.println("取消"); // TODO Auto-generated Event
                    // stub actionPerformed()
                }
            });
        }
        return jButton1;
    }

    public AddFormStu() {
        super();
        initialize();
    }

    /**
     * This method initializes this
     *
     * @return void
     */
    private void initialize() {
        this.setBounds(400, 300, 327, 400);
        this.setContentPane(getJContentPane());
        this.setTitle("注册学生信息");
    }

    /**
     * This method initializes jContentPane
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJContentPane() {
        if (jContentPane == null) {
            jStuIdTextLabel = new JLabel();
            jStuIdTextLabel.setBounds(new Rectangle(41, 127, 60, 25));
            jStuIdTextLabel.setText("学号");
            jPhoneLabel1 = new JLabel();
            jPhoneLabel1.setBounds(new Rectangle(41, 97, 60, 25));
            jPhoneLabel1.setText("电话");
            jEmailLabel1 = new JLabel();
            jEmailLabel1.setBounds(new Rectangle(41, 67, 60, 25));
            jEmailLabel1.setText("E-mail");
            jUAgeLabel1 = new JLabel();
            jUAgeLabel1.setBounds(new Rectangle(41, 37, 60, 25));
            jUAgeLabel1.setText("年龄");
            jLabel = new JLabel();
            jLabel.setBounds(new Rectangle(41, 7, 60, 26));
            jLabel.setText("姓名");
            jQQTextLabel = new JLabel();
            jQQTextLabel.setBounds(new Rectangle(41, 157, 60, 26));
            jQQTextLabel.setText("QQ");
            jUserNameTextLabel = new JLabel();
            jUserNameTextLabel.setBounds(new Rectangle(41, 187, 60, 26));
            jUserNameTextLabel.setText("用户名");
            jPassWordTextLabel = new JLabel();
            jPassWordTextLabel.setBounds(new Rectangle(41, 217, 60, 26));
            jPassWordTextLabel.setText("密码");
            jSurePWlabel = new JLabel();
            jSurePWlabel.setBounds(new Rectangle(41, 247, 60, 26));
            jSurePWlabel.setText("确认密码");


            jContentPane = new JPanel();
            jContentPane.setLayout(null);
            jContentPane.add(jLabel, null);
            jContentPane.add(getJNameTextField(), null);
            jContentPane.add(getJButton(), null);
            jContentPane.add(jUAgeLabel1, null);
            jContentPane.add(getJAgeTextField(), null);
            jContentPane.add(jEmailLabel1, null);
            jContentPane.add(getJEmailTextField1(), null);
            jContentPane.add(jPhoneLabel1, null);
            jContentPane.add(getJPhoneTextField1(), null);
            jContentPane.add(jStuIdTextLabel, null);
            jContentPane.add(getJStuClassTextField(), null);
            jContentPane.add(jQQTextLabel, null);
            jContentPane.add(getjQQTextField(), null);
            jContentPane.add(jUserNameTextLabel, null);
            jContentPane.add(getjUserNameTextField(), null);
            jContentPane.add(jPassWordTextLabel, null);
            jContentPane.add(getjPassWordTextField(), null);
            jContentPane.add(jSurePWlabel, null);
            jContentPane.add(getjSurePwTextField(), null);


            jContentPane.add(getJButton1(), null);

            final JLabel label = new JLabel();
            label.setText("性   别");
            label.setBounds(41, 277, 49, 18);
            jContentPane.add(label);

            manRadioButton = new JRadioButton();
            buttonGroup.add(manRadioButton);
            manRadioButton.addActionListener(new ActionListener() {
                public void actionPerformed(final ActionEvent e) {
                }
            });
            manRadioButton.setText("男");
            manRadioButton.setBounds(99, 277, 49, 26);
            jContentPane.add(manRadioButton);

            womanRadioButton = new JRadioButton();
            womanRadioButton.setText("女");
            buttonGroup.add(womanRadioButton);
            womanRadioButton.setBounds(154, 277, 62, 26);
            jContentPane.add(womanRadioButton);
        }
        return jContentPane;
    }


}
