package com.tingcream.t31_student.view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.tingcream.t31_student.model.Student;
import com.tingcream.t31_student.model.StudentDao;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

/**
 * 学生-新增 弹出框
 * @author jelly
 *
 */
public class StuAddDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	  JPanel contentPane;
	  JTextField textField_stuNo;
	  JTextField textField_name;
	  final ButtonGroup buttonGroup = new ButtonGroup();
	
	  StudentFrame studentFrame ;
	  JTextField textField_birthday;
	  JTextField textField_familyAddr;
	  JTextField textField_contactTel;
	  StudentDao dao =new StudentDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StuAddDialog frame = new StuAddDialog();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public   StuAddDialog(StudentFrame studentFrame ) {
		 this();
		 this.studentFrame=studentFrame;
	 
	}

	/**
	 * Create the frame.
	 */
	public StuAddDialog() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(StuAddDialog.class.getResource("/com/tingcream/t31_student/img/add_24px.png")));
		setFont(new Font("微软雅黑", Font.PLAIN, 18));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("学生-新增");
		setBounds(100, 100, 568, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("学号:");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		textField_stuNo = new JTextField();
		textField_stuNo.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		textField_stuNo.setColumns(10);
		
		JLabel label = new JLabel("姓名:");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		textField_name = new JTextField();
		textField_name.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		textField_name.setColumns(10);
		
		JLabel label_1 = new JLabel("性别:");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		JRadioButton radioButton_1 = new JRadioButton("男");
		buttonGroup.add(radioButton_1);
		radioButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		JRadioButton radioButton_2 = new JRadioButton("女");
		buttonGroup.add(radioButton_2);
		radioButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		JLabel label_2 = new JLabel("生日:");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		textField_birthday = new JTextField();
		textField_birthday.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		textField_birthday.setColumns(10);
		
		JLabel label_3 = new JLabel("家庭地址:");
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		textField_familyAddr = new JTextField();
		textField_familyAddr.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		textField_familyAddr.setColumns(10);
		
		JLabel label_4 = new JLabel("联系电话:");
		label_4.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		textField_contactTel = new JTextField();
		textField_contactTel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		textField_contactTel.setColumns(10);
		
		JButton btnNewButton = new JButton("取消");
		btnNewButton.setIcon(new ImageIcon(StuAddDialog.class.getResource("/com/tingcream/t31_student/img/cancel_24px.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				 doClose();
				
			}

			
		});
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		
		JButton button = new JButton("确定");
		button.setIcon(new ImageIcon(StuAddDialog.class.getResource("/com/tingcream/t31_student/img/check_24px.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doSave();
			}
		});
		button.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_familyAddr))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_contactTel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_stuNo, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(radioButton_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(radioButton_2)))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_birthday, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_name, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(71, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(169, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addGap(163))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField_stuNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_name, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(radioButton_1)
						.addComponent(radioButton_2)
						.addComponent(label_2)
						.addComponent(textField_birthday, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_familyAddr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_contactTel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addContainerGap(53, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		this.setModal(true);
		this.setLocationRelativeTo(null);
	}
	
	/**
	 * 关闭  窗体
	 */
	private void doClose() {
		this.dispose();//销毁窗体
	}
	/**
	 * 执行保存 (插入)
	 */
	private void  doSave() {
		 String studentNo =this.textField_stuNo.getText().trim();
		 String name =this.textField_name.getText().trim();
		 String birthday =this.textField_birthday.getText().trim();
		 String familyAddr =this.textField_familyAddr.getText().trim();
		 String contactTel =this.textField_contactTel.getText().trim();
		 Integer sex=1;
		 
		 
		 //性别 单选框 
		 Enumeration<AbstractButton>   en= this.buttonGroup.getElements();
		 while (en.hasMoreElements()) {
			AbstractButton radioButton = (AbstractButton) en.nextElement();
			if(radioButton.isSelected()) {
				if(radioButton.getText().equals("男")) {
					sex=1;
				}else {
					sex=2;
				}
				break;
			}
		 }
		
		 Student student =new Student();
		 student.setBirthday(birthday);
		 student.setContactTel(contactTel);
		 student.setFamilyAddr(familyAddr);
		 student.setName(name);
		 student.setStudentNo(studentNo);
		 student.setSex(sex);
		 
		 try {
			int id = dao.save(student);
			 if(id>0) {
				 student.setId(id);
			     this.studentFrame.tableModel.addRow(new Object[] {student.getId(),student.getStudentNo(),student.getName(),
						 student.getSexName(),student.getBirthday(),student.getFamilyAddr(),student.getContactTel()});
				 //  this.studentFrame.doSearch(null);
				   this.dispose();
			 }
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "数据添加失败", "错误", JOptionPane.ERROR_MESSAGE);
		}
		 
 
	}
}
