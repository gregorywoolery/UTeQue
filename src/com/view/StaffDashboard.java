package com.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Component;

public class StaffDashboard extends Dashboard implements ActionListener {



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffDashboard frame = new StaffDashboard();
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
	public StaffDashboard() {
		username_lbl.setText(UserLogin.currentUser.getFirstname()+" " + UserLogin.currentUser.getLastname());
		String gender = UserLogin.currentUser.getGender();
		if(gender.equals("M"))
			gender = "male";
		else
			gender = "female";
		
		userAvatar_lbl.setIcon(new ImageIcon(Dashboard.class.getResource("/img/"+ gender +"/staff.png")));
		
		JLabel livechatTitle_lbl = new JLabel("Live Chat");
		livechatTitle_lbl.setIcon(new ImageIcon(StaffDashboard.class.getResource("/img/dash/live-chat.png")));
		livechatTitle_lbl.setMaximumSize(new Dimension(99, 30));
		livechatTitle_lbl.setHorizontalTextPosition(SwingConstants.RIGHT);
		livechatTitle_lbl.setAlignmentY(Component.TOP_ALIGNMENT);
		livechatTitle_lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		livechatTitle_lbl.setForeground(new Color(255, 255, 255));
		livechatTitle_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		menu_panel.add(livechatTitle_lbl);
		
		JButton joinMeetingBtn = new JButton("Join Meeting");
		joinMeetingBtn.setAlignmentX(0.2f);
		joinMeetingBtn.setMaximumSize(new Dimension(99, 30));
		joinMeetingBtn.setHorizontalTextPosition(SwingConstants.RIGHT);
		joinMeetingBtn.setBorder(null);
		joinMeetingBtn.setBackground(new Color(0, 0, 51));
		joinMeetingBtn.setForeground(new Color(255, 255, 255));
		joinMeetingBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		menu_panel.add(joinMeetingBtn);
		
		JButton newMeetingBtn = new JButton("New Meeting");
		newMeetingBtn.setAlignmentX(0.2f);
		newMeetingBtn.setMaximumSize(new Dimension(99, 30));
		newMeetingBtn.setHorizontalTextPosition(SwingConstants.RIGHT);
		newMeetingBtn.setBorder(null);
		newMeetingBtn.setBackground(new Color(0, 0, 51));
		newMeetingBtn.setForeground(new Color(255, 255, 255));
		newMeetingBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		menu_panel.add(newMeetingBtn);
		
		JLabel Issues_lbl = new JLabel("Issues");
		Issues_lbl.setMaximumSize(new Dimension(99, 30));
		Issues_lbl.setHorizontalTextPosition(SwingConstants.RIGHT);
		Issues_lbl.setAlignmentY(Component.TOP_ALIGNMENT);
		Issues_lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		Issues_lbl.setForeground(new Color(255, 255, 255));
		Issues_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		menu_panel.add(Issues_lbl);
		
		JButton studentIssuesBtn = new JButton("Student Issues");
		studentIssuesBtn.setAlignmentX(0.2f);
		studentIssuesBtn.setMaximumSize(new Dimension(99, 30));
		studentIssuesBtn.setHorizontalTextPosition(SwingConstants.RIGHT);
		studentIssuesBtn.setBorder(null);
		studentIssuesBtn.setBackground(new Color(0, 0, 51));
		studentIssuesBtn.setForeground(new Color(255, 255, 255));
		studentIssuesBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		menu_panel.add(studentIssuesBtn);
		
		JLabel services_lbl = new JLabel("Services");
		services_lbl.setMaximumSize(new Dimension(99, 30));
		services_lbl.setHorizontalTextPosition(SwingConstants.RIGHT);
		services_lbl.setAlignmentY(Component.TOP_ALIGNMENT);
		services_lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		services_lbl.setForeground(new Color(255, 255, 255));
		services_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		menu_panel.add(services_lbl);
		
		JButton serviceAssistBtn = new JButton("Service Assist");
		serviceAssistBtn.setAlignmentX(0.2f);
		serviceAssistBtn.setMaximumSize(new Dimension(99, 30));
		serviceAssistBtn.setHorizontalTextPosition(SwingConstants.RIGHT);
		serviceAssistBtn.setBorder(null);
		serviceAssistBtn.setBackground(new Color(0, 0, 51));
		serviceAssistBtn.setForeground(new Color(255, 255, 255));
		serviceAssistBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		menu_panel.add(serviceAssistBtn);
		
		JLabel studentDetails_lbl = new JLabel("Student");
		studentDetails_lbl.setMaximumSize(new Dimension(99, 30));
		studentDetails_lbl.setHorizontalTextPosition(SwingConstants.RIGHT);
		studentDetails_lbl.setAlignmentY(Component.TOP_ALIGNMENT);
		studentDetails_lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		studentDetails_lbl.setForeground(new Color(255, 255, 255));
		studentDetails_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		menu_panel.add(studentDetails_lbl);
		
		JButton studentDetails_btn = new JButton("<html>Student<br>Detials</html>");
		studentDetails_btn.setAlignmentX(0.2f);
		studentDetails_btn.setMaximumSize(new Dimension(99, 40));
		studentDetails_btn.setHorizontalTextPosition(SwingConstants.RIGHT);
		studentDetails_btn.setBorder(null);
		studentDetails_btn.setBackground(new Color(0, 0, 51));
		studentDetails_btn.setForeground(new Color(255, 255, 255));
		studentDetails_btn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		menu_panel.add(studentDetails_btn);
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
