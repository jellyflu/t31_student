package com.tingcream.t31_student.view;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

/**
 * tableModel 自定义数据模型类，
 *  所有单元格均为不可编辑
 * @author jelly
 *
 */
public class MyTableModel extends DefaultTableModel {

	 
	@Override
	public boolean isCellEditable(int row, int column) {
		//return super.isCellEditable(row, column);
		return false ;
	}

	private static final long serialVersionUID = 1L;

	public MyTableModel() {
		super();
	}

	public MyTableModel(int rowCount, int columnCount) {
		super(rowCount, columnCount);
	}

	public MyTableModel(Object[] columnNames, int rowCount) {
		super(columnNames, rowCount);
	}

	public MyTableModel(Object[][] data, Object[] columnNames) {
		super(data, columnNames);
	}

	@SuppressWarnings("rawtypes")
	public MyTableModel(Vector columnNames, int rowCount) {
		super(columnNames, rowCount);
	}

	@SuppressWarnings("rawtypes")
	public MyTableModel(Vector data, Vector columnNames) {
		super(data, columnNames);
	}
  
}
