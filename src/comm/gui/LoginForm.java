package comm.gui;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import comm.dao.UserDao;


public class LoginForm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private JButton jButton = null;
    private JTextField juserName = null;
    private JPasswordField jPasswordField = null;
    private JLabel jLabel = null;
    private JLabel jLabel1 = null;
    private JButton jButton1 = null;


    public LoginForm() throws HeadlessException {
        // TODO Auto-generated constructor stub
        super();
        initialize();
    }


    /**
     * This method initializes jButton
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton() {
        if (jButton == null) {
            jButton = new JButton();
            jButton.addKeyListener(new KeyAdapter() {

            });
            jButton.setBounds(new Rectangle(75, 185, 95, 33));
            jButton.setText("确定");
            //匿名类
            jButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    //登录逻辑

                    login();
                }
            });
        }
        return jButton;
    }

    private void login() {
        //登录逻辑

        //先获取界面数据
        String uname = juserName.getText();
        String upass = new String(jPasswordField.getPassword());
        String uright;

        //实例dao 登录
        UserDao dao = new UserDao();
        int is = dao.login(uname, upass);
        if (is == 2) {
            //显示 进入管理界面
            ManageFormStu mfs = new ManageFormStu(uname);
            mfs.setVisible(true);

            LoginForm.this.dispose();//当前界面隐藏 释放资源
        } else if (is == 1) {
            ManageFormManag mf = new ManageFormManag();
            mf.setVisible(true);

            LoginForm.this.dispose();

        } else if (is == 3) {
            ManageFormTeac mft = new ManageFormTeac(uname);
            mft.setVisible(true);

            LoginForm.this.dispose();
        } else {
            JOptionPane.showMessageDialog(LoginForm.this, "对不起，用户名或密码有误！");
        }
    }

    /**
     * This method initializes jTextField
     *
     * @return javax.swing.JTextField
     */
    private JTextField getJuserName() {
        if (juserName == null) {
            juserName = new JTextField();
            juserName.setBounds(new Rectangle(140, 82, 203, 26));
        }
        return juserName;
    }

    /**
     * This method initializes jPasswordField
     *
     * @return javax.swing.JPasswordField
     */
    private JPasswordField getJPasswordField() {
        if (jPasswordField == null) {
            jPasswordField = new JPasswordField();
            jPasswordField.addKeyListener(new KeyAdapter() {
                public void keyPressed(final KeyEvent e) {
//					System.out.println(e.getKeyCode());
                }
            });
            jPasswordField.setBounds(new Rectangle(140, 132, 203, 29));
        }
        return jPasswordField;
    }

    /**
     * This method initializes jButton1
     *
     * @return javax.swing.JButton
     */
    private JButton getJButton1() {
        if (jButton1 == null) {
            jButton1 = new JButton();
            jButton1.setBounds(new Rectangle(185, 185, 99, 33));
            jButton1.setText("退出");
            jButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    System.exit(0);
                }
            });
        }
        return jButton1;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LoginForm thisClass = new LoginForm();
                thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                thisClass.setVisible(true);
            }
        });
    }

    /**
     * This method initializes this
     *
     * @return void
     */
    private void initialize() {
        this.setBounds(400, 300, 430, 278);
        this.setContentPane(getJContentPane());
        this.setTitle("管理员登录");
    }

    /**
     * This method initializes jContentPane
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJContentPane() {
        if (jContentPane == null) {
            jLabel1 = new JLabel();
            jLabel1.setForeground(Color.blue);
            jLabel1.setFont(new Font("", Font.BOLD, 16));
            jLabel1.setBounds(new Rectangle(70, 131, 58, 26));
            jLabel1.setText("密    码:");
            jLabel = new JLabel();
            jLabel.setFont(new Font("", Font.BOLD, 16));
            jLabel.setBounds(new Rectangle(70, 80, 64, 26));
            jLabel.setText("用户名:");
            jLabel.setForeground(Color.blue);
            jContentPane = new JPanel();
            jContentPane.setLayout(null);
            jContentPane.add(getJButton(), null);
            jContentPane.add(getJuserName(), null);
            jContentPane.add(getJPasswordField(), null);
            jContentPane.add(jLabel, null);
            jContentPane.add(jLabel1, null);
            jContentPane.add(getJButton1(), null);
            jContentPane.setBackground(Color.WHITE);

            final JLabel label = new JLabel();
            label.setFont(new Font("", Font.ITALIC | Font.BOLD, 28));
            label.setText("欢迎登录学员信息管理系统");
            label.setForeground(Color.RED);
            label.setBounds(35, 10, 356, 52);
            jContentPane.add(label);
        }
        return jContentPane;
    }

}