package comm.gui;

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
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import comm.dao.UserDao;
import comm.entity.User;

public class ManageFormManag extends JFrame {
    private ButtonGroup buttonGroup = new ButtonGroup();
    //    private JTextField unameTextField;
//    private JTextField emailTextField;
//    private final JTextField regDate_textField;
    private JComboBox comboBox;
    //    private JTextField phoneTextField;
//    private JTextField ageField;
    private JTextField uidTextField;
    //    private JRadioButton manRadioButton;
//    private JRadioButton nvRadioButton;
    private JButton button_mod;
    //    private JTextField uQQTextField;
    private JTextField uUsernameTextField;
    private JTextField uPasswordTextField;
    private JTextField uRightField;
    private UserDao dao = new UserDao();//数据库访问类

    public ManageFormManag() {
        super();
        getContentPane().setLayout(null);
        setTitle("用户信息管理");
        setBounds(300, 260, 500, 257);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JPanel panel_1 = new JPanel();
        panel_1.setBorder(new LineBorder(Color.black, 1, false));
        panel_1.setBounds(10, 160, 473, 40);
        getContentPane().add(panel_1);

        final JButton button_4 = new JButton();
        button_4.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                AddFormUser afu = new AddFormUser();
                afu.setVisible(true);
            }
        });
        button_4.setText("注册");
        panel_1.add(button_4);

        final JButton button_2 = new JButton();
        button_2.setInheritsPopupMenu(true);
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                ///////////////////////查询事件////////////////////////////////
                String uid = uidTextField.getText();
                String uname = uUsernameTextField.getText();
                User user = new User();
                if ((uid == null || uid.trim().equals("")) && (uname != null || !uname.trim().equals(""))) {
                    user = dao.queryUserByUsername(uname);
                } else if ((uid != null || !uid.trim().equals("")) && (uname == null || uname.trim().equals(""))) {
                    user = dao.queryUserById(uid);
                } else {
                    JOptionPane.showMessageDialog(ManageFormManag.this, "请输入编号或用户名！");
                    return;
                }

                if (user == null) {
                    JOptionPane.showMessageDialog(ManageFormManag.this, "查无此人！！");
                    return;
                }
                //数据存在 显示到界面
//                unameTextField.setText(student.getSname());
//                ageField.setText(student.getSage()+"");
//                emailTextField.setText(student.getEmail());
//                phoneTextField.setText(student.getPhone());
//                uQQTextField.setText(student.getQQNumber());
                uPasswordTextField.setText(user.getPassword());
                uUsernameTextField.setText(user.getUsername());
                uRightField.setText(user.getUsername());

//                if(student.isSex()){
//                    manRadioButton.setSelected(true);
//                }else{
//                    nvRadioButton.setSelected(true);
//                }


                //修改按钮可用
                button_mod.setEnabled(true);
            }
        });
        button_2.setText("编号查询");
        panel_1.add(button_2);

        button_mod = new JButton();
        button_mod.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                //修改学员信息

                //1.获取数据 封装到实体类对象
                User user = new User();
                user.setSid(uidTextField.getText());
//                student.setEmail(emailTextField.getText());
//                student.setSage(Integer.parseInt(ageField.getText()));
//                student.setPhone(phoneTextField.getText());
//                student.setSname(unameTextField.getText());
//                student.setQQNumber(uQQTextField.getText());
                user.setUsername(uUsernameTextField.getText());
                user.setPassword(uPasswordTextField.getText());
                user.setRight(uRightField.getText());


//                if(manRadioButton.isSelected()){
//                    user.setSex(true);
//                }else {
//                    user.setSex(false);
//                }

                boolean is = dao.update(user);
                if (is) {
                    JOptionPane.showMessageDialog(ManageFormManag.this, "修改成功！");
                } else {
                    JOptionPane.showMessageDialog(ManageFormManag.this, "修改失败！");
                }
            }
        });
        button_mod.setText("修改");
        button_mod.setEnabled(false);
        panel_1.add(button_mod);

        final JButton button = new JButton();
        button.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {

                int flag = JOptionPane.showConfirmDialog(ManageFormManag.this, "您确定删除此用户信息么？");
                if (flag != JOptionPane.OK_OPTION) {
                    return;
                }

                String sid = uidTextField.getText();
                if (sid == null || sid.trim().equals("")) {
                    JOptionPane.showMessageDialog(ManageFormManag.this, "请输入用户编号！");
                    return;
                }

                boolean is = dao.delUser(sid);
                if (is) {
                    uidTextField.setText("");
//                    unameTextField.setText("");
//                    ageField.setText("");
//                    emailTextField.setText("");
//                    phoneTextField.setText("");
                    uUsernameTextField.setText("");
                    uPasswordTextField.setText("");
                    uRightField.setText("");
//                    uQQTextField.setText("");
//                    manRadioButton.setSelected(false);
//                    nvRadioButton.setSelected(false);
                    comboBox.setSelectedIndex(0);

                    JOptionPane.showMessageDialog(ManageFormManag.this, "删除成功！");
                } else {
                    JOptionPane.showMessageDialog(ManageFormManag.this, "删除失败！");
                }
            }
        });
        button.setText("删除");
        panel_1.add(button);

        final JButton button_3 = new JButton();
        button_3.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                int sel = JOptionPane.showConfirmDialog(ManageFormManag.this, "您确定退出系统么？");
                if (sel == JOptionPane.OK_OPTION) {
                    System.exit(0);
                }
            }
        });
        button_3.setText("退出");
        panel_1.add(button_3);

//        final JButton button_5 = new JButton();
//        button_5.addActionListener(new ActionListener() {
//            public void actionPerformed(final ActionEvent e) {
//                new SearchFrame().setVisible(true);
//            }
//        });
//        button_5.setText("条件查询");
//        panel_1.add(button_5);

        final JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(Color.black, 1, false));
        panel.setLayout(null);
        panel.setBounds(11, 10, 472, 185);
        getContentPane().add(panel);

        final JLabel label = new JLabel();
        label.setText("编号：");
        label.setBounds(125, 12, 66, 18);
        panel.add(label);

        uidTextField = new JTextField();
        uidTextField.setBounds(197, 10, 153, 22);
        panel.add(uidTextField);

//        final JLabel label_1 = new JLabel();
//        label_1.setText("年龄：");
//        label_1.setBounds(128, 81, 66, 18);
//        panel.add(label_1);

//        ageField = new JTextField();
//        ageField.setBounds(200, 79, 150, 22);
//        panel.add(ageField);

//        final JLabel label_2 = new JLabel();
//        label_2.setText("电话：");
//        label_2.setBounds(127, 222, 66, 18);
//        panel.add(label_2);

//        phoneTextField = new JTextField();
//        phoneTextField.setBounds(199, 220, 151, 22);
//        panel.add(phoneTextField);

        final JLabel label_3 = new JLabel();
        label_3.setText("用户名");
        label_3.setBounds(127, 44, 66, 18);
        panel.add(label_3);
        uUsernameTextField = new JTextField();
        uUsernameTextField.setBounds(199, 44, 151, 22);
        panel.add(uUsernameTextField);

        final JLabel label_4 = new JLabel();
        label_4.setText("密码");
        label_4.setBounds(127, 81, 66, 18);
        panel.add(label_4);
        uPasswordTextField = new JTextField();
        uPasswordTextField.setBounds(199, 81, 151, 22);
        panel.add(uPasswordTextField);

        final JLabel label_5 = new JLabel();
        label_5.setText("身份");
        label_5.setBounds(127, 112, 66, 18);
        panel.add(label_5);
        uRightField = new JTextField();
        uRightField.setBounds(199, 112, 151, 22);
        panel.add(uRightField);

//        final JLabel label_8 =new JLabel();
//        label_8.setText("QQ");
//        label_8.setBounds(127,245,66,18);
//        panel.add(label_8);
//        uQQTextField =new JTextField();
//        uQQTextField.setBounds(199,245,151,22);
//        panel.add(uQQTextField);

//		final JLabel label_9 =new JLabel();
//		label_9.setText("班级");
//		label_9.setBounds(127,270,66,18);
//		panel.add(label_9);
//		uClassTextField =new JTextField();
//		uClassTextField.setBounds(199,270,151,22);
//		panel.add(uClassTextField);


//        regDate_textField = new JTextField();
//        regDate_textField.setEditable(false);
//        regDate_textField.setBounds(199, 250, 151, 22);
//        panel.add(regDate_textField);
//
//        final JLabel label_2_2 = new JLabel();
//        label_2_2.setText("E-mail：");
//        label_2_2.setBounds(128, 195, 66, 18);
//        panel.add(label_2_2);

//        emailTextField = new JTextField();
//        emailTextField.setBounds(200, 195, 150, 22);
//        panel.add(emailTextField);

//        unameTextField = new JTextField();
//        unameTextField.setBounds(198, 42, 152, 22);
//        panel.add(unameTextField);

//        final JLabel label_5 = new JLabel();
//        label_5.setText("姓名：");
//        label_5.setBounds(126, 44, 66, 18);
//        panel.add(label_5);

//        manRadioButton = new JRadioButton();
//        buttonGroup.add(manRadioButton);
//        manRadioButton.setText("男");
//        manRadioButton.setBounds(197, 110, 38, 24);
//        panel.add(manRadioButton);

//        nvRadioButton = new JRadioButton();
//        nvRadioButton.addActionListener(new ActionListener() {
//            public void actionPerformed(final ActionEvent e) {
//            }
//        });
//        nvRadioButton.setText("女");
//        buttonGroup.add(nvRadioButton);
//        nvRadioButton.setBounds(255, 110, 48, 24);
//        panel.add(nvRadioButton);

//        final JLabel label_6 = new JLabel();
//        label_6.setText("性别：");
//        label_6.setBounds(127, 112, 66, 18);
//        panel.add(label_6);


    }

}
