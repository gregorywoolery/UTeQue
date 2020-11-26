package com.view.staff;

import javax.swing.JInternalFrame;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.DefaultStyledDocument;

import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JTextField; 
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import java.awt.Cursor;
import javax.swing.DefaultComboBoxModel;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

import com.controller.IssueController;
import com.controller.ServiceController;
import com.model.Issue;
import com.model.Student;
import com.services.DocumentSizeFilter;
import com.services.Identification;

import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.ScrollPane;
import javax.swing.border.BevelBorder;

public class ViewStudentDetails extends JInternalFrame implements ActionListener{

	private static final long serialVersionUID = -3530403283450512137L;
	
	private JDesktopPane workSpaceDesktop;
	
	public ViewStudentDetails() {
	}
	
	/**
	 * @throws ParseException 
	 * @wbp.parser.constructor
	 */
	public ViewStudentDetails(JDesktopPane workSpaceDesktop) throws ParseException {
		super("Student Details", 
				false, 	//resizable
				true, 	//closable
				false, 	//maximizable
				true);	//iconifiable
		initializeComponents();
		registerListeners();
		this.workSpaceDesktop =  workSpaceDesktop;
	}
	
	public void initializeComponents() {
		
	}
	
	public void registerListeners() {
		
	}
	
	public void showStudentTable() {
//		DefaultTableModel model = new DefaultTableModel();
//		this.setTitle("Student Details");
//		model.setColumnIdentifiers(columnNames);
//		studentTable = new JTable();
//		studentTable.setModel(model); 
//		studentTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
//		studentTable.setFillsViewportHeight(true);
//		JScrollPane scroll = new JScrollPane(studentTable);
//		scroll.setHorizontalScrollBarPolicy(
//		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//		scroll.setVerticalScrollBarPolicy(
//		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
//		String textvalue =  entryStudentID_tbox.getText();
//		String roll= "";
//		String name= "";
//		String cl = "";
//		String sec = "";
//		try
//		{ 
//			Student student = null;
//			student= UTeQueDBOperations.getStudentDetails(studentID);
//			
//			
//
//			
//			
//		
//		if(student.getID()==null)
//		{
//			JOptionPane.showMessageDialog(null, "No Record Found","Error",
//					JOptionPane.ERROR_MESSAGE);
//		}else 
//		{
//			JOptionPane.showMessageDialog(null, "Record Found");
//			model.addRow(new Object[] {
//					student.getID(),
//					student.getFirstname(),
//					student.getLastname(),
//					student.getGender(),
//					student.getEmail(),
//					student.getPhone(),
//					student.getDOB()
//					});
//		}
//		
//		}
//		
//		catch(Exception ex)
//		{
//			JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
//			JOptionPane.ERROR_MESSAGE);
//		}
//		add(scroll);
//		setVisible(true);
//		setSize(600,500);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
