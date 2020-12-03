package com.view.staff;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;

import com.controller.UserController;
import com.model.User;
import com.view.Dashboard;
import com.view.UserLogin;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.Dimension;
import java.awt.Component;

public class StaffDashboard extends Dashboard implements ActionListener {

	private static final long serialVersionUID = 8747060055776800514L;
	private static final Logger logger = LogManager.getLogger(StaffDashboard.class);
	
	private JLabel livechatTitle_lbl;
	private JLabel Issues_lbl; 
	private JLabel services_lbl;
	private JButton joinMeetingBtn;
	private JButton newMeetingBtn;
	private JButton studentIssuesBtn;
	private JButton serviceAssistBtn;
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
		username_lbl.setText(staff.getFirstname() + " " + staff.getLastname());
	
		//For resource variables
		String gender = staff.getGender();
		if(gender.equals("M"))
			gender = "male";
		else
			gender = "female";
		
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
		joinMeetingBtn.setAlignmentX(0.3f);
		joinMeetingBtn.setMaximumSize(new Dimension(99, 30));
		joinMeetingBtn.setHorizontalTextPosition(SwingConstants.RIGHT);
		joinMeetingBtn.setBorder(null);
		joinMeetingBtn.setBackground(new Color(0, 0, 51));
		joinMeetingBtn.setForeground(new Color(255, 255, 255));
		joinMeetingBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		menu_panel.add(joinMeetingBtn);
		
		newMeetingBtn = new JButton("New");
		newMeetingBtn.setIcon(new ImageIcon(StaffDashboard.class.getResource("/img/dash/schedule-live-chat.png")));
		newMeetingBtn.setAlignmentX(0.3f);
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
		studentIssuesBtn.setAlignmentX(0.2f);
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
		serviceAssistBtn.setAlignmentX(0.2f);
		serviceAssistBtn.setMaximumSize(new Dimension(99, 30));
		serviceAssistBtn.setHorizontalTextPosition(SwingConstants.RIGHT);
		serviceAssistBtn.setBorder(null);
		serviceAssistBtn.setBackground(new Color(0, 0, 51));
		serviceAssistBtn.setForeground(new Color(255, 255, 255));
		serviceAssistBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		menu_panel.add(serviceAssistBtn);
		
		addMainInternalFrame();
		
	}
	
	private void registerListeners(){
		joinMeetingBtn.addActionListener(this);
		newMeetingBtn.addActionListener(this);
		studentIssuesBtn.addActionListener(this);
		serviceAssistBtn.addActionListener(this);
		logoutBtn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(joinMeetingBtn)) {
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
		
		if(e.getSource().equals(newMeetingBtn)) {
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
		
		if(e.getSource().equals(studentIssuesBtn)) {
			if(currFrame.getClass() != IssueMain.class)
				addMainInternalFrame();
		}
		
		if(e.getSource().equals(serviceAssistBtn)) {
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
				
		if(e.getSource().equals(logoutBtn)) {
			dispose();
			UserController.setCurrentUserNull();
			UserLogin.client.disconnect();
	
			dispose();
			userlogin.setVisible(true);
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
