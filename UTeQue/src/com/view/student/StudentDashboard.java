package com.view.student;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;

import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.controller.UserController;
import com.model.User;
import com.view.Dashboard;
import com.view.UserLogin;
import com.view.staff.StaffDashboard;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class StudentDashboard extends Dashboard implements ActionListener{
	private static final Logger logger = LogManager.getLogger(StudentDashboard.class);
	private static final long serialVersionUID = -1418595725623251209L;

	private JMenuItem exit_menuItem;
	
	private JMenuItem livechat_menuItem;
	private JMenuItem addIssue_menuItem;
	
	private JMenuItem help_menuItem;
	private JMenuItem about_menuItem;

	private ImageIcon helpIcon;
	private JLabel aboutInfo;
	private JLabel issuesBtn_lbl;
	private JButton viewBtnDash;
	private JButton removeBtnDash;
	private JButton addBtnDash;
	private JInternalFrame currFrame;
	private User student;
	private UserLogin userlogin;
	
	/**
	 * Create the frame.
	 */
	public StudentDashboard(UserLogin userlogin) {
		this.userlogin = userlogin;
		initializeComponents();
		registerListeners();
	}
	
	public void initializeComponents(){
		student =  UserController.getCurrentUser();
		username_lbl.setText(student.getFirstname() + " " + student.getLastname());
	
		//For resource variables
		String gender = student.getGender();
		if(gender.equals("M"))
			gender = "male";
		else
			gender = "female";
		
		//Adding menu items for Menu Bar
		exit_menuItem = new JMenuItem("Exit");  
		exit_menuItem.setToolTipText("Exit UteQue");
		exit_menuItem.setMnemonic(KeyEvent.VK_E);
		
		livechat_menuItem = new JMenuItem("Live Chat", KeyEvent.VK_L);
		livechat_menuItem.setToolTipText("Start Live Chat");
		
		addIssue_menuItem = new JMenuItem("Join", KeyEvent.VK_A);
		addIssue_menuItem.setToolTipText("Join Meeting");
		
		
		help_menuItem=new JMenuItem("Help", KeyEvent.VK_H);
		
		help_menuItem.setToolTipText("Ask for help");
		help_menuItem.setIcon(new ImageIcon(StudentDashboard.class.getResource("/img/help.png")));
		
		about_menuItem=new JMenuItem("About", KeyEvent.VK_A);
		about_menuItem.setToolTipText("About UTeQue");
		
		fileMenu.add(exit_menuItem);
		
		optionMenu.add(livechat_menuItem);
		optionMenu.add(addIssue_menuItem);
		
		helpMenu.add(help_menuItem);
		helpMenu.add(about_menuItem);
		
		setTitle("UTeQue - Student Issue System");
		userAvatar_lbl.setIcon(new ImageIcon(Dashboard.class.getResource("/img/"+ gender +"/student.png")));
		
		issuesBtn_lbl = new JLabel("Issues");
		issuesBtn_lbl.setIcon(new ImageIcon(Dashboard.class.getResource("/img/dash/search-paper.png")));
		issuesBtn_lbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		issuesBtn_lbl.setAlignmentY(Component.TOP_ALIGNMENT);
		issuesBtn_lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		issuesBtn_lbl.setHorizontalTextPosition(SwingConstants.RIGHT);
		issuesBtn_lbl.setHorizontalAlignment(SwingConstants.LEFT);
		issuesBtn_lbl.setPreferredSize(new Dimension(99, 30));
		issuesBtn_lbl.setForeground(new Color(255, 255, 255));
		issuesBtn_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		menu_panel.add(issuesBtn_lbl);
		
		viewBtnDash = new JButton("View");
		viewBtnDash.setToolTipText("View your issues.");
		viewBtnDash.setBackground(new Color(0, 0, 51));
		viewBtnDash.setAlignmentX(0.2f);
		viewBtnDash.setIcon(new ImageIcon(Dashboard.class.getResource("/img/dash/view.png")));
		viewBtnDash.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		viewBtnDash.setAlignmentY(Component.TOP_ALIGNMENT);
		viewBtnDash.setBorder(null);
		viewBtnDash.setHorizontalTextPosition(SwingConstants.RIGHT);
		viewBtnDash.setHorizontalAlignment(SwingConstants.LEFT);
		viewBtnDash.setMaximumSize(new Dimension(140, 40));
		viewBtnDash.setForeground(new Color(255, 255, 255));
		viewBtnDash.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		menu_panel.add(viewBtnDash);
		
		addBtnDash = new JButton("Add");

		addBtnDash.setToolTipText("Add your issues.");
		addBtnDash.setBackground(new Color(0, 0, 51));
		addBtnDash.setAlignmentX(0.2f);
		addBtnDash.setIcon(new ImageIcon(Dashboard.class.getResource("/img/dash/add.png")));
		addBtnDash.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addBtnDash.setAlignmentY(Component.TOP_ALIGNMENT);
		addBtnDash.setBorder(null);
		addBtnDash.setHorizontalTextPosition(SwingConstants.RIGHT);
		addBtnDash.setHorizontalAlignment(SwingConstants.LEFT);
		addBtnDash.setMaximumSize(new Dimension(140, 40));
		addBtnDash.setForeground(new Color(255, 255, 255));
		addBtnDash.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		menu_panel.add(addBtnDash);
		
		removeBtnDash = new JButton("Remove");
		removeBtnDash.setToolTipText("Remove a previous issue.");
		removeBtnDash.setBackground(new Color(0, 0, 51));
		removeBtnDash.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		removeBtnDash.setAlignmentX(0.2f);
		removeBtnDash.setIcon(new ImageIcon(Dashboard.class.getResource("/img/dash/delete.png")));
		removeBtnDash.setMaximumSize(new Dimension(140, 40));
		removeBtnDash.setHorizontalTextPosition(SwingConstants.RIGHT);
		removeBtnDash.setHorizontalAlignment(SwingConstants.LEFT);
		removeBtnDash.setForeground(Color.WHITE);
		removeBtnDash.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		removeBtnDash.setBorder(null);
		removeBtnDash.setAlignmentY(0.0f);
		menu_panel.add(removeBtnDash);
		
		JButton notificationBtnDash = new JButton("Notification");
		notificationBtnDash.setToolTipText("View notifications on your inquiries.");
		notificationBtnDash.setBorder(null);
		notificationBtnDash.setBackground(new Color(0, 0, 51));
		notificationBtnDash.setIcon(new ImageIcon(Dashboard.class.getResource("/img/dash/notif.png")));
		notificationBtnDash.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		notificationBtnDash.setAlignmentY(Component.TOP_ALIGNMENT);
		notificationBtnDash.setAlignmentX(Component.CENTER_ALIGNMENT);
		notificationBtnDash.setHorizontalTextPosition(SwingConstants.RIGHT);
		notificationBtnDash.setHorizontalAlignment(SwingConstants.LEFT);
		notificationBtnDash.setMaximumSize(new Dimension(140, 55));
		notificationBtnDash.setForeground(new Color(255, 255, 255));
		notificationBtnDash.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		menu_panel.add(notificationBtnDash);
		

		
        helpIcon = new ImageIcon(StudentIssueResponse.class.getResource("/img/help.png"));

        aboutInfo = new JLabel("<html>Welcome to UTeQue where students and staff<br>can communitcate on the basis of enquieres."
        		+"<br>Students make enquires and employees are assigned to answer.</html>");
        
        aboutInfo.setVerticalAlignment(SwingConstants.BOTTOM);
        aboutInfo.setBounds(0, 0, 250, 100);
        aboutInfo.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        aboutInfo.setHorizontalAlignment(SwingConstants.CENTER);
		
		addMainInternalFrame();
		
		setVisible(true);
	}
	
	public void addMainInternalFrame() {
		//Check if frame to remove is there(not null)
		if(currFrame !=null) {
			workspace_desktopPane.removeAll();
			workspace_desktopPane.updateUI();
		}
		
		currFrame = new StudentMain(workspace_desktopPane);
		workspace_desktopPane.add(currFrame);
		
		//Opens JinternalFrame centered in the JDesktopPane
		Dimension desktopSize = workspace_desktopPane.getSize();
		Dimension jInternalFrameSize = currFrame.getSize();
		
		//Test if current internal frame is of class Student main and renders the frame with that
		if(currFrame.getClass() == StudentMain.class){
			currFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/500,
			    (desktopSize.height- jInternalFrameSize.height)/90);
		}
		
	}
	
	
	public void registerListeners() {
		viewBtnDash.addActionListener(this);
		addBtnDash.addActionListener(this);
		logoutBtn.addActionListener(this);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(viewBtnDash)) {
        	int opt = JOptionPane.showConfirmDialog(workspace_desktopPane, 
					"Are you sure u want to return home? ", 
					"HOME",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
        	if(opt == 0)
    			//Call METHOD to RETURN to STUDENT MAIN
				addMainInternalFrame();
			
		}
		
		
		if(e.getSource().equals(addBtnDash) || e.getSource().equals(addIssue_menuItem)) {
			//Check if frame to remove is there(not null)
			if(currFrame !=null) {
				workspace_desktopPane.removeAll();
				workspace_desktopPane.updateUI();

				try {
					currFrame = new AddIssue(workspace_desktopPane);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				workspace_desktopPane.add(currFrame);
		
				//Opens JinternalFrame centered in the JDesktopPane
				Dimension desktopSize = workspace_desktopPane.getSize();
				Dimension jInternalFrameSize = currFrame.getSize();
				
				//Test if current internal frame is of class AddIssue and renders the frame with that
				if(currFrame.getClass() == AddIssue.class){
					currFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/500,
					    (desktopSize.height- jInternalFrameSize.height)/70);
				}
			}
		}
		
		if(e.getSource().equals(logoutBtn)) {
        	int opt = JOptionPane.showConfirmDialog(workspace_desktopPane, 
					"Are you sure u want to Log off? ", 
					"LOG OFF",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
        	if(opt == 0) {
				dispose();
				UserController.setCurrentUserNull();
				UserLogin.client.disconnect();
				userlogin.setVisible(true);
        	}
		}
		
		if(e.getSource().equals(help_menuItem)) {
			JOptionPane.showMessageDialog(workspace_desktopPane, 
					"<html>Cantact Tier1Support at <br>tier1support@utech.edu.jm</html>", 
					"HELP",
					JOptionPane.INFORMATION_MESSAGE, helpIcon);
		}
		
		if(e.getSource().equals(about_menuItem)) {
			JOptionPane.showMessageDialog(workspace_desktopPane, 
					aboutInfo, 
					"About",
					JOptionPane.INFORMATION_MESSAGE);
		}
		
	}

}
