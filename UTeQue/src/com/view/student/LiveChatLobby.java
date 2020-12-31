package com.view.student;

import java.awt.Color;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.border.LineBorder;

import com.controller.UserController;
import com.model.User;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class LiveChatLobby extends JInternalFrame{
	
	private JPanel available_panel;
	private JLabel title_lbl;
	private JPanel panel;
	private static JTable staffAvailable_table;
	
	private JDesktopPane workSpaceDesktop;
	private User student;

	
	/**
	 * Create the frame.
	 */
	public LiveChatLobby(JDesktopPane workSpaceDesktop) throws ParseException {
		super("Add Issue", 
				false, 	//resizable
				true, 	//closable
				false, 	//maximizable
				true);	//iconifiable
		initializeComponents();
		this.workSpaceDesktop =  workSpaceDesktop;
	}
	
	private void initializeComponents() throws ParseException {
		student =  UserController.getCurrentUser();
		
		//Removes top bar from internal frame
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		
		getContentPane().setBackground(new Color(0, 0, 51));
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));
		
		panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(15);
		panel.setPreferredSize(new Dimension(500, 50));
		getContentPane().add(panel);
		
		title_lbl = new JLabel("LIVE CHAT LOBBY");
		title_lbl.setFont(new Font("Bradley Hand ITC", Font.BOLD, 16));
		panel.add(title_lbl);
		
		available_panel = new JPanel();
		available_panel.setPreferredSize(new Dimension(600, 300));
		getContentPane().add(available_panel);
		
		staffAvailable_table = new JTable();
		staffAvailable_table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"#", "First Name", "Last Name", "Status"
			}
		));
		
		staffAvailable_table.setPreferredScrollableViewportSize(new Dimension(590, 400));
		staffAvailable_table.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		
		staffAvailable_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		staffAvailable_table.setRowSelectionAllowed(true);
		staffAvailable_table.setColumnSelectionAllowed(false);
		
		
		//Changes table heaver font
		JTableHeader tableHeader = staffAvailable_table.getTableHeader();
		tableHeader.setBackground(new Color(0, 0, 51));
		tableHeader.setForeground(Color.white);
		tableHeader.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		available_panel.add(new JScrollPane(staffAvailable_table));
		
		setBorder(new LineBorder(new Color(0, 0, 51), 20));
		setBounds(100, 100, 820, 570);
		
		setVisible(true);
		
	}
	
	public static void updateAvailableTable(User staff) {
		staffAvailable_table.removeAll();
		staffAvailable_table.updateUI();
		
		DefaultTableModel model = (DefaultTableModel) staffAvailable_table.getModel();
		model.addRow(new Object[]{
				1,
				staff.getFirstname(),
				staff.getLastname(),
				"Available"
		});

	}

}
