package com.tingcream.t31_student.view;

 
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import com.tingcream.t31_student.model.Student;
import com.tingcream.t31_student.model.StudentDao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

/**
 * T31班 学生管理主界面
 * @author jelly
 *
 */
public class StudentFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private    StudentDao dao=new StudentDao() ;
	  JPanel contentPane;
	  JTable table;
	
	
	
	  String[]  headers=new String[] {"序号", "学号", "姓名", "性别", "生日", "家庭地址", "联系电话"};
	  MyTableModel  tableModel ;
	  JTextField textField_stuNo;
	  JTextField textField_name ;
	  StuAddDialog  stuAddDialog;
	  StuUpdateDialog  stuUpdateDialog;
	  
	   
	
	 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentFrame frame = new StudentFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StudentFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(StudentFrame.class.getResource("/com/tingcream/t31_student/img/student_24px.png")));
		setFont(new Font("微软雅黑", Font.PLAIN, 18));
		setTitle("T31班 学生管理系统");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 906, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("学号:");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		JLabel label_1 = new JLabel("姓名:");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		JButton button_search = new JButton("查询");
		button_search.setIcon(new ImageIcon(StudentFrame.class.getResource("/com/tingcream/t31_student/img/search_24px.png")));
		button_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doSearch(e);
			}
			
		});
		button_search.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton button = new JButton("新增");
		button.setIcon(new ImageIcon(StudentFrame.class.getResource("/com/tingcream/t31_student/img/add_24px.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showStuAddDialog();
			}
		});
		button.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		JButton button_1 = new JButton("修改");
		button_1.setIcon(new ImageIcon(StudentFrame.class.getResource("/com/tingcream/t31_student/img/edit_24px.png")));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showStuUpdateDialog();
			}
		});
		button_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		JButton button_2 = new JButton("删除");
		button_2.setIcon(new ImageIcon(StudentFrame.class.getResource("/com/tingcream/t31_student/img/remove_24px.png")));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doDelete(e);
			}
		});
		button_2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		textField_stuNo = new JTextField();
		textField_stuNo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				//判断按下的键是否是回车键
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					doSearch(null);
				 }
			}
		});
		textField_stuNo.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_stuNo.setColumns(10);
		
		textField_name = new JTextField();
		textField_name.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField_name.setColumns(10);
		textField_name.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				//判断按下的键是否是回车键
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					doSearch(null);
				 }
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(33)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_stuNo, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_name, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_search)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button)
							.addGap(10)
							.addComponent(button_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(24)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 837, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textField_stuNo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_name, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_search)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(23)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 422, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		table = new JTable();
		
		init();//初始化 xxx
		//int  x =table.getSelectedRow();
		//int  y=table.getSelectedColumn();
		//table.getValueAt(row, column);
	   // Integer value = (Integer) table.getValueAt(0, 0);  
		//JOptionPane.showMessageDialog(null, value);//默认的  提示框 title为“信息” type为  INFORMATION_MESSAGE
		 
		
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);
	}
	
	
	
	
	/**
	 * 显示 学生-新增 窗体
	 */
	private  void showStuAddDialog() {
		stuAddDialog =new StuAddDialog(this);
		stuAddDialog.setVisible(true);
	}
	/**
	 * 显示 学生-修改 窗体
	 */
	private  void showStuUpdateDialog() {
		int  row =table.getSelectedRow();
		if(row==-1) {
			JOptionPane.showMessageDialog(null, "请先选择一行，再进行修改!"); 
			return ;
		}
		 Integer id =(Integer) table.getValueAt(row, 0);
		
		stuUpdateDialog =new StuUpdateDialog(this,id );
		
		stuUpdateDialog.setVisible(true);
	}

	/** 
	 * 查询 功能
	 * @param e
	 */
	public  void doSearch(ActionEvent e) {
		String stuNo=this.textField_stuNo.getText().trim();
		String name=this.textField_name.getText().trim();
		List<Student> list =  dao.findStudent(stuNo, name);
		tableModel = new MyTableModel(
				null,
				headers
				);
		tableLoadData(table,tableModel,list);
		
	}
	/** 
	 * 删除 功能
	 * @param e
	 */
	private void doDelete(ActionEvent e) {
		try {
			int  row =table.getSelectedRow();
			if(row==-1) {
				JOptionPane.showMessageDialog(null, "请先选择一行，再执行删除!"); 
				return ;
			}
			
		     int result =JOptionPane.showConfirmDialog(null, "确定删除吗?", "提示", JOptionPane.YES_NO_OPTION);
			 if(result==JOptionPane.YES_OPTION) { //0是  1否
					Integer id =(Integer) table.getValueAt(row, 0);// 获取学生id
					int count=dao.deleteById(id);
					if(count>0) {
						tableModel.removeRow(row);//删除选择的行
					} 
			   }
		} catch (HeadlessException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "删除数据失败", "错误", JOptionPane.ERROR_MESSAGE);
		}
		
	}
 

	
	
	/**
	 *  初始化数据
	 */
	public void init() {
		tableModel = new MyTableModel(
				null,
				headers
				);
		
		List<Student> list = dao.findAllStudent();
  	     tableLoadData(table,tableModel,list);
	}

	//重新 加载表格，并显示表格数据
	public   void tableLoadData(JTable table, MyTableModel  tableModel,List<Student> list) {
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(60);
		table.getColumnModel().getColumn(1).setPreferredWidth(110);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(60);
		table.getColumnModel().getColumn(4).setPreferredWidth(160);
		table.getColumnModel().getColumn(5).setPreferredWidth(270);
		table.getColumnModel().getColumn(6).setPreferredWidth(180);
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		table.setRowHeight(30);//设置表格 行高度
		
		//头部对象
		JTableHeader head = table.getTableHeader(); // 创建表格标题对象
        head.setFont(new Font("微软雅黑", Font.PLAIN, 18));// 设置表格字体
        
        for(Student  stu :   list ) {
        	tableModel.addRow(new Object[] {stu.getId(),stu.getStudentNo(),stu.getName(),
      			   stu.getSexName(),stu.getBirthday(),stu.getFamilyAddr(),stu.getContactTel()});
      	 
       } 
	}
	 
	 
}
