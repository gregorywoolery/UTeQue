package com.view.staff;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;

import com.controller.UserController;
import com.model.User;
import com.view.Dashboard;
import com.view.UserLogin;
import com.view.student.StudentIssueResponse;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.Dimension;
import java.awt.Component;
import java.awt.event.KeyEvent;

public class StaffDashboard extends Dashboard implements ActionListener {

	private static final long serialVersionUID = 8747060055776800514L;
	private static final Logger logger = LogManager.getLogger(StaffDashboard.class);
	
	private JMenu meeting;
	private JMenuItem exit_menuItem;
	
	private JMenuItem newMeeting_menuItem;
	private JMenuItem joinMeeting_menuItem;
	private JMenuItem studentIssues_menuItem;
	private JMenuItem serviceStats_menuItem;
	
	private JMenuItem help_menuItem;
	private JMenuItem about_menuItem;
	
	private JLabel livechatTitle_lbl;
	private JLabel Issues_lbl; 
	private JLabel services_lbl;
	private JButton joinMeetingBtn;
	private JButton newMeetingBtn;
	private JButton studentIssuesBtn;
	private JButton serviceAssistBtn;
	private ImageIcon helpIcon;
	private JLabel aboutInfo;
	private JInternalFrame currFrame;
	private User staff;
	private UserLogin userlogin;
	
	public StaffDashboard(UserLogin userlogin) {
		this.userlogin = userlogin;
		initializeComponents();
		registerListeners();
	}
	
	/**
	 * Create the frame.
	 */
	private void initializeComponents() {
		staff =  UserController.getCurrentUser();
		username_lbl.setText(staff.getType() + " : " + staff.getFirstname() + " " + staff.getLastname() );
	
		//For resource variables
		String gender = staff.getGender();
		if(gender.equals("M"))
			gender = "male";
		else
			gender = "female";
		
		//Adding menu items for Menu Bar
		exit_menuItem = new JMenuItem("Exit");  
		exit_menuItem.setToolTipText("Exit UteQue");
		exit_menuItem.setMnemonic(KeyEvent.VK_E);
		
		meeting = new JMenu("Meetings");
		meeting.setMnemonic(KeyEvent.VK_M);
		
		newMeeting_menuItem = new JMenuItem("New", KeyEvent.VK_N);
		newMeeting_menuItem.setToolTipText("Schedule Meeting");
		
		joinMeeting_menuItem = new JMenuItem("Join", KeyEvent.VK_J);
		
		joinMeeting_menuItem.setToolTipText("Join Meeting");
		
		studentIssues_menuItem=new JMenuItem("Student Issues", KeyEvent.VK_I);  
		
		serviceStats_menuItem=new JMenuItem("Service Statistics", KeyEvent.VK_S);  
		
		help_menuItem=new JMenuItem("Help", KeyEvent.VK_H);
		
		help_menuItem.setToolTipText("Ask for help");
		help_menuItem.setIcon(new ImageIcon(StaffDashboard.class.getResource("/img/help.png")));
		
		about_menuItem=new JMenuItem("About", KeyEvent.VK_A);
		about_menuItem.setToolTipText("About UTeQue");
		
		fileMenu.add(exit_menuItem);
		
		optionMenu.add(meeting);
		meeting.add(newMeeting_menuItem);
		meeting.add(joinMeeting_menuItem);
		
		optionMenu.add(studentIssues_menuItem);
		optionMenu.add(serviceStats_menuItem);
		
		helpMenu.add(help_menuItem);
		helpMenu.add(about_menuItem);
		
		setTitle("UTeQue - Staff Issue System");
		userAvatar_lbl.setIcon(new ImageIcon(Dashboard.class.getResource("/img/"+ gender +"/staff.png")));
		
		livechatTitle_lbl = new JLabel("Live Chat");
		livechatTitle_lbl.setIcon(new ImageIcon(StaffDashboard.class.getResource("/img/dash/live-chat.png")));
		livechatTitle_lbl.setMaximumSize(new Dimension(99, 30));
		livechatTitle_lbl.setHorizontalTextPosition(SwingConstants.RIGHT);
		livechatTitle_lbl.setAlignmentY(Component.TOP_ALIGNMENT);
		livechatTitle_lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		livechatTitle_lbl.setForeground(new Color(255, 255, 255));
		livechatTitle_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		menu_panel.add(livechatTitle_lbl);
		
		joinMeetingBtn = new JButton("Join");
		joinMeetingBtn.setIcon(new ImageIcon(StaffDashboard.class.getResource("/img/dash/new-live-chat.png")));
		joinMeetingBtn.setAlignmentX(0.5f);
		joinMeetingBtn.setMaximumSize(new Dimension(99, 30));
		joinMeetingBtn.setHorizontalTextPosition(SwingConstants.RIGHT);
		joinMeetingBtn.setBorder(null);
		joinMeetingBtn.setBackground(new Color(0, 0, 51));
		joinMeetingBtn.setForeground(new Color(255, 255, 255));
		joinMeetingBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		menu_panel.add(joinMeetingBtn);
		
		newMeetingBtn = new JButton("New");
		newMeetingBtn.setIcon(new ImageIcon(StaffDashboard.class.getResource("/img/dash/schedule-live-chat.png")));
		newMeetingBtn.setAlignmentX(0.5f);
		newMeetingBtn.setMaximumSize(new Dimension(99, 30));
		newMeetingBtn.setHorizontalTextPosition(SwingConstants.RIGHT);
		newMeetingBtn.setBorder(null);
		newMeetingBtn.setBackground(new Color(0, 0, 51));
		newMeetingBtn.setForeground(new Color(255, 255, 255));
		newMeetingBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		menu_panel.add(newMeetingBtn);
		
		Issues_lbl = new JLabel("Issues");
		Issues_lbl.setIcon(new ImageIcon(StaffDashboard.class.getResource("/img/dash/issue.png")));
		Issues_lbl.setMaximumSize(new Dimension(99, 30));
		Issues_lbl.setHorizontalTextPosition(SwingConstants.RIGHT);
		Issues_lbl.setAlignmentY(Component.TOP_ALIGNMENT);
		Issues_lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		Issues_lbl.setForeground(new Color(255, 255, 255));
		Issues_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		menu_panel.add(Issues_lbl);
		
		studentIssuesBtn = new JButton("<html>Student <br> Issues</html>");
		studentIssuesBtn.setIcon(new ImageIcon(StaffDashboard.class.getResource("/img/dash/student-issues.png")));
		studentIssuesBtn.setAlignmentX(0.4f);
		studentIssuesBtn.setMaximumSize(new Dimension(99, 30));
		studentIssuesBtn.setHorizontalTextPosition(SwingConstants.RIGHT);
		studentIssuesBtn.setBorder(null);
		studentIssuesBtn.setBackground(new Color(0, 0, 51));
		studentIssuesBtn.setForeground(new Color(255, 255, 255));
		studentIssuesBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		menu_panel.add(studentIssuesBtn);
		
		services_lbl = new JLabel("Services");
		services_lbl.setIcon(new ImageIcon(StaffDashboard.class.getResource("/img/dash/service.png")));
		services_lbl.setMaximumSize(new Dimension(99, 30));
		services_lbl.setHorizontalTextPosition(SwingConstants.RIGHT);
		services_lbl.setAlignmentY(Component.TOP_ALIGNMENT);
		services_lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		services_lbl.setForeground(new Color(255, 255, 255));
		services_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		menu_panel.add(services_lbl);
		
		serviceAssistBtn = new JButton("<html>Service<br> Stats</html>");
		serviceAssistBtn.setIcon(new ImageIcon(StaffDashboard.class.getResource("/img/dash/stats.png")));
		serviceAssistBtn.setAlignmentX(0.4f);
		serviceAssistBtn.setMaximumSize(new Dimension(99, 30));
		serviceAssistBtn.setHorizontalTextPosition(SwingConstants.RIGHT);
		serviceAssistBtn.setBorder(null);
		serviceAssistBtn.setBackground(new Color(0, 0, 51));
		serviceAssistBtn.setForeground(new Color(255, 255, 255));
		serviceAssistBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		menu_panel.add(serviceAssistBtn);
		
		
		
        helpIcon = new ImageIcon(StudentIssueResponse.class.getResource("/img/help.png"));

        aboutInfo = new JLabel("<html>Welcome to UTeQue where students and staff<br>can communitcate on the basis of enquieres."
        		+"<br>Students make enquires and employees are assigned to answer.</html>");
        
        aboutInfo.setVerticalAlignment(SwingConstants.BOTTOM);
        aboutInfo.setBounds(0, 0, 250, 100);
        aboutInfo.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        aboutInfo.setHorizontalAlignment(SwingConstants.CENTER);
		
		addMainInternalFrame();
		
	}
	
	private void registerListeners(){
		newMeeting_menuItem.addActionListener(this);
		joinMeeting_menuItem.addActionListener(this);
		studentIssues_menuItem.addActionListener(this);
		serviceStats_menuItem.addActionListener(this);
		help_menuItem.addActionListener(this);
		about_menuItem.addActionListener(this);
		joinMeetingBtn.addActionListener(this);
		newMeetingBtn.addActionListener(this);
		studentIssuesBtn.addActionListener(this);
		serviceAssistBtn.addActionListener(this);
		logoutBtn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(joinMeetingBtn) || e.getSource().equals(joinMeeting_menuItem)) {
			//Check if frame to remove is there(not null)
			if(currFrame !=null) {
				workspace_desktopPane.removeAll();
				workspace_desktopPane.updateUI();
				
				try {
					currFrame = new JoinMeeting(workspace_desktopPane);
				} catch (ParseException e1) {
					logger.error("ERROR IN CREATING JOIN MEETING VIEW");
				}
				workspace_desktopPane.add(currFrame);
				
				//Opens JinternalFrame centered in the JDesktopPane
				Dimension desktopSize = workspace_desktopPane.getSize();
				Dimension jInternalFrameSize = currFrame.getSize();
				
				//Test if current internal frame is of class joinMeeting and renders the frame with that
				if(currFrame.getClass() == JoinMeeting.class){
					currFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
					    (desktopSize.height- jInternalFrameSize.height)/2);
				}
			}
		}
		
		if(e.getSource().equals(newMeetingBtn) || e.getSource().equals(newMeeting_menuItem)) {
			//Check if frame to remove is there(not null)
			if(currFrame !=null) {
				workspace_desktopPane.removeAll();
				workspace_desktopPane.updateUI();
				
				currFrame = new NewMeeting(workspace_desktopPane);

				workspace_desktopPane.add(currFrame);
				
				//Opens JinternalFrame centered in the JDesktopPane
				Dimension desktopSize = workspace_desktopPane.getSize();
				Dimension jInternalFrameSize = currFrame.getSize();
				
				//Test if current internal frame is of class newMeeting and renders the frame with that
				if(currFrame.getClass() == NewMeeting.class){
					currFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
					    (desktopSize.height- jInternalFrameSize.height)/2);
				}
			}
		}
		
		if(e.getSource().equals(studentIssuesBtn) || e.getSource().equals(studentIssues_menuItem)) {
			if(currFrame.getClass() != IssueMain.class)
				addMainInternalFrame();
		}
		
		if(e.getSource().equals(serviceAssistBtn) || e.getSource().equals(serviceStats_menuItem)) {
			//Check if frame to remove is there(not null)
			if(currFrame !=null) {
				workspace_desktopPane.removeAll();
				workspace_desktopPane.updateUI();
				
				try {
					currFrame = new ViewServiceStats(workspace_desktopPane);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				workspace_desktopPane.add(currFrame);
				
				//Opens JinternalFrame centered in the JDesktopPane
				Dimension desktopSize = workspace_desktopPane.getSize();
				Dimension jInternalFrameSize = currFrame.getSize();
				
				//Test if current internal frame is of class ViewService and renders the frame with that
				if(currFrame.getClass() == ViewServiceStats.class){
					currFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
					    (desktopSize.height- jInternalFrameSize.height)/2);
				}
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
	}
	
	public void addMainInternalFrame() {
		//Check if frame to remove is there(not null)
		if(currFrame !=null) {
			workspace_desktopPane.removeAll();
			workspace_desktopPane.updateUI();
		}
		
		try {
			currFrame = new IssueMain(workspace_desktopPane);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		workspace_desktopPane.add(currFrame);
		
		//Opens JinternalFrame centered in the JDesktopPane
		Dimension desktopSize = workspace_desktopPane.getSize();
		Dimension jInternalFrameSize = currFrame.getSize();
		
		//Test if current internal frame is of class Student main and renders the frame with that
		if(currFrame.getClass() == IssueMain.class){
			currFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/500,
			    (desktopSize.height- jInternalFrameSize.height)/90);
		}
		
	}

}
