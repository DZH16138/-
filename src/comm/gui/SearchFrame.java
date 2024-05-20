package comm.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import comm.dao.StudentDao;
import comm.entity.Student;


public class SearchFrame extends JFrame {

	private JTextField textFieldEmail;
	private JTextField textFieldQQ;
	private JTextField textFieldPhone;
	private JTextField textFieldStuName;
	private JTable table;
	private Vector<String> header;

	/**
	 * Create the frame
	 */
	public SearchFrame() {
		super();
		setTitle("查询页面");
		getContentPane().setLayout(null);
		setBounds(100, 100, 581, 403);


		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 553, 250);
		getContentPane().add(scrollPane);

		header = new Vector<String>();
		header.add("学号");
		header.add("姓名");
		header.add("性别");
		header.add("年龄");
		header.add("电话");
		header.add("E-mail");
		header.add("QQ");
		header.add("班级");

		Vector<Vector<Object>> data = null;


		table = new JTable(data, header);
		scrollPane.setViewportView(table);

		final JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.black, 1, false));
		panel.setLayout(null);
		panel.setBounds(10, 266, 553, 93);
		getContentPane().add(panel);

		final JLabel label = new JLabel();
		label.setBounds(30, 15, 66, 18);
		panel.add(label);
		label.setText("姓名");

		textFieldStuName = new JTextField();
		textFieldStuName.setBounds(95, 15, 108, 22);
		panel.add(textFieldStuName);



		final JButton button = new JButton();
		button.setBounds(425, 47, 106, 28);
		panel.add(button);
		button.addActionListener(new ActionListener() {
			//查询事件
			public void actionPerformed(final ActionEvent e) {
				String sname = textFieldStuName.getText();


				//把条件封装到实体对象
				Student student = new Student();
				student.setSname(sname);


				//根据条件查询并获取结果
				StudentDao dao = new StudentDao();
				Vector<Vector<Object>> data = dao.search(student);

				//把数据填充到表格
				DefaultTableModel mode = (DefaultTableModel) table.getModel();
				mode.setDataVector(data, header);
			}
		});
		button.setText("查询");

		final JLabel label_2 = new JLabel();
		label_2.setText("电话");
		label_2.setBounds(30, 50, 66, 18);
		panel.add(label_2);

		textFieldPhone = new JTextField();
		textFieldPhone.setBounds(95, 50, 106, 22);
		panel.add(textFieldPhone);


		final JLabel label_3 = new JLabel();
		label_3.setText("QQ");
		label_3.setBounds(215, 50, 53, 18);
		panel.add(label_3);

		textFieldQQ = new JTextField();
		textFieldQQ.setBounds(280, 50, 106, 22);
		panel.add(textFieldQQ);

		final JLabel label_4 = new JLabel();
		label_4.setText("Email");
		label_4.setBounds(215, 15, 53, 18);
		panel.add(label_4);

		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(280, 15, 106, 22);
		panel.add(textFieldEmail);


	}


}
