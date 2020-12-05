package com.view.staff;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.border.LineBorder;

import com.controller.ChatController;
import com.controller.UserController;
import com.model.User;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Point;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class NewMeeting extends JInternalFrame {
	private static final long serialVersionUID = -7326864335907473600L;

	private JDesktopPane workSpaceDesktop;
	private JPanel title_panel;
	private JLabel title_lbl;
	private JPanel detials_panel;
	private JLabel message_lbl;
	private JTable onlineStudents_table;
	
	private User staff;
	private String studentID;

	/**
	 * Create the frame.
	 */

	public NewMeeting(JDesktopPane workSpaceDesktop){
		super("View Issue", 
				false, 	//resizable
				true, 	//closable
				false, 	//maximizable
				true);	//iconifiable
		
		this.workSpaceDesktop =  workSpaceDesktop;
		initializeComponents();
	}
	
	
	
	private void initializeComponents() {
		staff =  UserController.getCurrentUser();
		
		//Removes top bar from internal frame
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		
		setBorder(new LineBorder(new Color(0, 0, 51), 20));
		setBounds(100, 100, 820, 570);
		getContentPane().setBackground(new Color(0, 0, 51));
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));
		
		title_panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) title_panel.getLayout();
		flowLayout.setVgap(15);
		title_panel.setPreferredSize(new Dimension(500, 50));
		getContentPane().add(title_panel);
		
		title_lbl = new JLabel("LIVE CHAT AVAILABILITY");
		title_lbl.setFont(new Font("Bradley Hand ITC", Font.BOLD, 17));
		title_panel.add(title_lbl);
		
		detials_panel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) detials_panel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		detials_panel.setPreferredSize(new Dimension(600, 400));
		getContentPane().add(detials_panel);
		
		
		message_lbl = new JLabel("These students are curently online...");
		message_lbl.setPreferredSize(new Dimension(240, 20));
		message_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		detials_panel.add(message_lbl);
		
		onlineStudents_table = new JTable();
		onlineStudents_table.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		onlineStudents_table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "First Name", "Last Name", "Gender"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		onlineStudents_table.getColumnModel().getColumn(0).setResizable(false);
		onlineStudents_table.getColumnModel().getColumn(1).setResizable(false);
		onlineStudents_table.getColumnModel().getColumn(2).setResizable(false);
		onlineStudents_table.getColumnModel().getColumn(3).setResizable(false);
		
		onlineStudents_table.setPreferredScrollableViewportSize(new Dimension(590, 340));
		onlineStudents_table.setRowHeight(20);
		onlineStudents_table.setSelectionBackground(new Color(255, 153, 102));
		
		onlineStudents_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		onlineStudents_table.setRowSelectionAllowed(true);
		onlineStudents_table.setColumnSelectionAllowed(false);
		
		//Changes table heaver font
		JTableHeader tableHeader = onlineStudents_table.getTableHeader();
		tableHeader.setBackground(new Color(0, 0, 51));
		tableHeader.setForeground(Color.white);
		tableHeader.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		updateOnlineStudentsTable();
		
		onlineStudents_table.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent mouseEvent) {
		        JTable table =(JTable) mouseEvent.getSource();
		        Point point = mouseEvent.getPoint();
		        int studentIDRow = 0;
		        String studentName;
		        int row = table.rowAtPoint(point);
		        
		        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
	        		int selRow = table.getSelectedRow();
	        		studentID = table.getModel().getValueAt(selRow, studentIDRow).toString();
	        		studentName = table.getModel().getValueAt(selRow, 1).toString() + " "
	        								+ table.getModel().getValueAt(selRow, 2).toString();
		        	
		        	
		        	int opt = JOptionPane.showConfirmDialog(workSpaceDesktop, 
							"Notify " + studentName + " that you are available for live chat ?", 
							"Notify for Live Chat",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.INFORMATION_MESSAGE);
		        	
		        	if(opt == 0) {
		        		notifyStudentForLiveChat(studentID);
		        	}

		        }
		    }
		});
		
		
		detials_panel.add(new JScrollPane(onlineStudents_table));
		
		setVisible(true);
	}
	
	public void updateOnlineStudentsTable() {
		ArrayList<User> onlineStudents = new ArrayList<>();
		
		onlineStudents = UserController.getOnlineStudents();
		DefaultTableModel model = (DefaultTableModel) onlineStudents_table.getModel();		
		
		model.setRowCount(0);
		if(!onlineStudents.isEmpty()) {
			
			for(User student: onlineStudents) {
				model.addRow(new Object[]{
						student.getID(), 
						student.getFirstname(),
						student.getLastname(),
						student.getGender()
				});
			}			
		}else {
			JOptionPane.showMessageDialog(workSpaceDesktop, 
				"No students have logged on.", 
				"Nobody online",
				JOptionPane.INFORMATION_MESSAGE);
		}
		
		
	}
	
	private void notifyStudentForLiveChat(String studentID) {
		boolean notified = false;
//		notified = ChatController.sendNotificationToStudent(staff.getID(), studentID, "AVAILABLE");
		
		if(notified){
			JOptionPane.showMessageDialog(workSpaceDesktop, 
					"Student has been notifed. Please go to Join meeting", 
					"Notified !",
					JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(workSpaceDesktop, 
					"Oops.. Seems the student has been notifed. Maybe a connection error. We'll get back to you", 
					"Notified !",
					JOptionPane.INFORMATION_MESSAGE);			
		}
	}

}
