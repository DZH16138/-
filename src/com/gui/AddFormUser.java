package com.gui;


import java.awt.Rectangle;


import javax.swing.*;


import com.dao.UserDao;
import com.entity.User;

public class AddFormUser extends JFrame {

    //    private ButtonGroup buttonGroup = new ButtonGroup();
//    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    //    private JLabel jLabel = null;
    //    private JTextField jNameTextField = null;
    private JButton jButton = null;
//    private JLabel jUAgeLabel1 = null;
//    private JTextField jAgeTextfield = null;
//    private JLabel jEmailLabel1 = null;
//    private JTextField jEmailTextField1 = null;
//    private JLabel jPhoneLabel1 = null;
//    private JTextField jPhoneTextField1 = null;
//
//    private JLabel jQQTextLabel = null;
//    private JTextField jQQTextField = null;

//    private JLabel jStuIdTextLabel = null;
//    private JTextField jStuIdTextField = null;

    private JLabel jUserNameTextLabel = null;
    private JTextField jUserNameTextField = null;

    private JLabel jPassWordTextLabel = null;
    private JTextField jPassWordTextField = null;
    private JLabel jSurePWlabel = null;
    private JTextField jSurePwTextField = null;

    private JLabel jRightTextLabel = null;
    private JTextField jRightTextField = null;

    private JButton jButton1 = null;
//    private JRadioButton manRadioButton;
//    private JRadioButton womanRadioButton;

    /**
     * This method initializes jTextField
     *
     * @return javax.swing.JTextField
     */
//    private JTextField getJNameTextField() {
//        if (jNameTextField == null) {
//            jNameTextField = new JTextField();
//            jNameTextField.setBounds(new Rectangle(131, 7, 101, 26));
//        }
//        return jNameTextField;
//    }

    /**
     * This method initializes jButton
     *
     * @return javax.swing.JButton
     */
    public AddFormUser() {
        super();
        initialize();
    }


    private JButton getJButton() {
        if (jButton == null) {
            jButton = new JButton();
            jButton.setBounds(new Rectangle(41, 157, 81, 28));
            jButton.setText("注册");
            jButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    //封装数据到实体类
                    User user = new User();
//                    student.setEmail(jEmailTextField1.getText());
//                    student.setPhone(jPhoneTextField1.getText());
//                    student.setSage(Integer.parseInt(jAgeTextfield.getText()));
//                    user.setSname(jNameTextField.getText());
//                    user.setUsername(jUserNameTextField.getText());
//                    student.setQQNumber(jQQTextField.getText());
//                    student.setSid(jStuIdTextField.getText());
////                    if (manRadioButton.isSelected()) {
//                        student.setSex(true);
//                    } else {
//                        student.setSex(false);
//                    }
                    boolean uNNull = jUserNameTextField.getText().equals("");
                    boolean pWNull = jPassWordTextField.getText().equals("");
                    boolean surePWNull = getjPassWordTextField().getText().equals(getjSurePwTextField().getText());
                    boolean rightNull = getjRightTextField().getText().equals("老师") || getjRightTextField().getText().equals("管理员") || getjRightTextField().getText().equals("学生");


                    if (uNNull) {
                        JOptionPane.showMessageDialog(AddFormUser.this, "请输入用户名！");
                    } else if (pWNull) {
                        JOptionPane.showMessageDialog(AddFormUser.this, "请输入密码！");

                    } else if (surePWNull) {
                        JOptionPane.showMessageDialog(AddFormUser.this, "两次密码不一致！");

                    } else if (!rightNull) {
                        JOptionPane.showMessageDialog(AddFormUser.this, "身份设置错误！应为老师或管理员或学生！");

                    }else {
                        if (jRightTextField.getText().equals("老师"))
                            user.setRight("teacher");
                        else if (jRightTextField.getText().equals("管理员"))
                            user.setRight("manager");
                        else if (jRightTextField.getText().equals("学生"))
                            user.setRight("student");
                        user.setUsername(getjUserNameTextField().getText());
                        user.setPassword(getjPassWordTextField().getText());
                        UserDao dao = new UserDao();
                        boolean is = dao.addUser(user);
                        if (is) {
                            AddFormUser.this.setVisible(false);
                            JOptionPane.showMessageDialog(AddFormUser.this, "注册成功！");
                        } else {
                            JOptionPane.showMessageDialog(AddFormUser.this, "注册失败！");
                        }
                    }





//                    boolean nameNull = true;
//                    nameNull = !jNameTextField.getText().equals("");

//                    boolean mailNull = true;
//                    mailNull = !jEmailTextField1.getText().equals("");

                    //实例dao  执行保存

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
//    private JTextField getJAgeTextField() {
//        if (jAgeTextfield == null) {
//            jAgeTextfield = new JTextField();
//            jAgeTextfield.setBounds(new Rectangle(131, 37, 100, 22));
//        }
//        return jAgeTextfield;
//    }

    /**
     * This method initializes jEmailTextField1
     *
     * @return javax.swing.JTextField
     */
//    private JTextField getJEmailTextField1() {
//        if (jEmailTextField1 == null) {
//            jEmailTextField1 = new JTextField();
//            jEmailTextField1.setBounds(new Rectangle(131, 67, 101, 20));
//        }
//        return jEmailTextField1;
//    }

    /**
     * This method initializes jPhoneTextField1
     *
     * @return javax.swing.JTextField
     */
//    private JTextField getJPhoneTextField1() {
//        if (jPhoneTextField1 == null) {
//            jPhoneTextField1 = new JTextField();
//            jPhoneTextField1.setBounds(new Rectangle(131, 97, 101, 26));
//        }
//        return jPhoneTextField1;
//    }

//    private JTextField getJStuClassTextField() {
//        if (jStuIdTextField == null) {
//            jStuIdTextField = new JTextField();
//            jStuIdTextField.setBounds(new Rectangle(131, 127, 97, 21));
//        }
//        return jStuIdTextField;
//    }

//    private JTextField getjQQTextField() {
//        if (jQQTextField == null) {
//            jQQTextField = new JTextField();
//            jQQTextField.setBounds(new Rectangle(131, 157, 97, 21));
//        }
//        return jQQTextField;
//    }
    private JTextField getjUserNameTextField() {
        if (jUserNameTextField == null) {
            jUserNameTextField = new JTextField();
            jUserNameTextField.setBounds(new Rectangle(131, 7, 97, 21));
        }
        return jUserNameTextField;
    }

    private JTextField getjPassWordTextField() {
        if (jPassWordTextField == null) {
            jPassWordTextField = new JTextField();
            jPassWordTextField.setBounds(new Rectangle(131, 37, 97, 21));
        }
        return jPassWordTextField;
    }

    private JTextField getjSurePwTextField() {
        if (jSurePwTextField == null) {
            jSurePwTextField = new JTextField();
            jSurePwTextField.setBounds(new Rectangle(131, 67, 97, 21));
        }
        return jSurePwTextField;
    }

    private JTextField getjRightTextField() {
        if (jRightTextField == null) {
            jRightTextField = new JTextField();
            jRightTextField.setBounds(new Rectangle(131, 97, 97, 21));
        }
        return jRightTextField;
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
            jButton1.setBounds(new Rectangle(160, 157, 89, 29));
            jButton1.setText("取　消");
            jButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {

                    AddFormUser.this.dispose();

                    System.out.println("取消"); // TODO Auto-generated Event
                    // stub actionPerformed()
                }
            });
        }
        return jButton1;
    }


    /**
     * This method initializes this
     *
     * @return void
     */
    private void initialize() {
        this.setBounds(400, 300, 327, 250);
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
//            jStuIdTextLabel = new JLabel();
//            jStuIdTextLabel.setBounds(new Rectangle(41, 127, 60, 25));
//            jStuIdTextLabel.setText("学号");
//            jPhoneLabel1 = new JLabel();
//            jPhoneLabel1.setBounds(new Rectangle(41, 97, 60, 25));
//            jPhoneLabel1.setText("电话");
//            jEmailLabel1 = new JLabel();
//            jEmailLabel1.setBounds(new Rectangle(41, 67, 60, 25));
//            jEmailLabel1.setText("E-mail");
//            jUAgeLabel1 = new JLabel();
//            jUAgeLabel1.setBounds(new Rectangle(41, 37, 60, 25));
//            jUAgeLabel1.setText("年龄");
//            jLabel = new JLabel();
//            jLabel.setBounds(new Rectangle(41, 7, 60, 26));
//            jLabel.setText("姓名");
//            jQQTextLabel = new JLabel();
//            jQQTextLabel.setBounds(new Rectangle(41, 157, 60, 26));
//            jQQTextLabel.setText("QQ");
            jUserNameTextLabel = new JLabel();
            jUserNameTextLabel.setBounds(new Rectangle(41, 7, 60, 26));
            jUserNameTextLabel.setText("用户名");
            jPassWordTextLabel = new JLabel();
            jPassWordTextLabel.setBounds(new Rectangle(41, 37, 60, 26));
            jPassWordTextLabel.setText("密码");
            jSurePWlabel = new JLabel();
            jSurePWlabel.setBounds(new Rectangle(41, 67, 67, 26));
            jSurePWlabel.setText("确认密码");
            jRightTextLabel = new JLabel();
            jRightTextLabel.setBounds(new Rectangle(41, 97, 67, 26));
            jRightTextLabel.setText("身份");


            jContentPane = new JPanel();
            jContentPane.setLayout(null);
//            jContentPane.add(jLabel, null);
//            jContentPane.add(getJNameTextField(), null);
            jContentPane.add(getJButton(), null);
//            jContentPane.add(jUAgeLabel1, null);
//            jContentPane.add(getJAgeTextField(), null);
//            jContentPane.add(jEmailLabel1, null);
//            jContentPane.add(getJEmailTextField1(), null);
//            jContentPane.add(jPhoneLabel1, null);
//            jContentPane.add(getJPhoneTextField1(), null);
//            jContentPane.add(jStuIdTextLabel, null);
//            jContentPane.add(getJStuClassTextField(), null);
//            jContentPane.add(jQQTextLabel, null);
//            jContentPane.add(getjQQTextField(), null);
            jContentPane.add(jUserNameTextLabel, null);
            jContentPane.add(getjUserNameTextField(), null);
            jContentPane.add(jPassWordTextLabel, null);
            jContentPane.add(getjPassWordTextField(), null);
            jContentPane.add(jSurePWlabel, null);
            jContentPane.add(getjSurePwTextField(), null);
            jContentPane.add(jRightTextLabel, null);
            jContentPane.add(getjRightTextField(), null);


            jContentPane.add(getJButton1(), null);

//            final JLabel label = new JLabel();
//            label.setText("性   别");
//            label.setBounds(41, 277, 49, 18);
//            jContentPane.add(label);

//            manRadioButton = new JRadioButton();
//            buttonGroup.add(manRadioButton);
//            manRadioButton.addActionListener(new ActionListener() {
//                public void actionPerformed(final ActionEvent e) {
//                }
//            });
//            manRadioButton.setText("男");
//            manRadioButton.setBounds(99, 277, 49, 26);
//            jContentPane.add(manRadioButton);
//
//            womanRadioButton = new JRadioButton();
//            womanRadioButton.setText("女");
//            buttonGroup.add(womanRadioButton);
//            womanRadioButton.setBounds(154, 277, 62, 26);
//            jContentPane.add(womanRadioButton);
        }
        return jContentPane;
    }
}