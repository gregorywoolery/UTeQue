package com.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;

import java.awt.Font;
import java.awt.GridBagConstraints;

import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;


public class StudentDashboard extends Dashboard implements ActionListener{
	private JLabel issuesBtn_lbl;
	private JButton viewBtnDash;
	private JButton removeBtnDash;
	private JButton updateBtnDash;
	private JButton addBtnDash;
	private JInternalFrame currFrame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentDashboard frame = new StudentDashboard();
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
	public StudentDashboard() {
		initializeComponents();
		registerListeners();
	}
	
	public void initializeComponents(){
		
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
		
		updateBtnDash = new JButton("Update");
		updateBtnDash.setToolTipText("Update a previous issue.");
		updateBtnDash.setBackground(new Color(0, 0, 51));
		updateBtnDash.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		updateBtnDash.setAlignmentX(0.2f);
		updateBtnDash.setIcon(new ImageIcon(Dashboard.class.getResource("/img/dash/update.png")));
		updateBtnDash.setMaximumSize(new Dimension(140, 40));
		updateBtnDash.setHorizontalTextPosition(SwingConstants.RIGHT);
		updateBtnDash.setHorizontalAlignment(SwingConstants.LEFT);
		updateBtnDash.setForeground(Color.WHITE);
		updateBtnDash.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		updateBtnDash.setBorder(null);
		updateBtnDash.setAlignmentY(0.0f);
		menu_panel.add(updateBtnDash);
		
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
		
		logoutButton_panel = new JPanel();
		logoutButton_panel.setBackground(new Color(0, 0, 51));
		GridBagConstraints gbc_logoutButton_panel = new GridBagConstraints();
		gbc_logoutButton_panel.insets = new Insets(30, 0, 5, 0);
		gbc_logoutButton_panel.fill = GridBagConstraints.BOTH;
		gbc_logoutButton_panel.gridx = 0;
		gbc_logoutButton_panel.gridy = 2;
		sidebar_panel.add(logoutButton_panel, gbc_logoutButton_panel);

		logoutBtn = new JButton("Log Out");
		logoutBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logoutBtn.setFocusPainted(false);
		logoutBtn.setPreferredSize(new Dimension(95, 35));
		logoutBtn.setForeground(new Color(51, 153, 255));
		logoutBtn.setBorder(null);
		logoutBtn.setBackground(new Color(51, 255, 0));
		logoutBtn.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		
		// Resize icon to fit on button
		// Resize icon to fit on label 
		ImageIcon buttonImageIcon = new ImageIcon(new ImageIcon(Dashboard.class.getResource(
				"/img/logout.png")).getImage().getScaledInstance(23, 23, Image.SCALE_DEFAULT));
		
		logoutBtn.setIcon(buttonImageIcon);
		logoutButton_panel.add(logoutBtn);
		
		workspace_desktopPane = new JDesktopPane();
		
		addMainInternalFrame();
		
		workspace_desktopPane.setBorder(new LineBorder(new Color(0, 0, 51), 5));
		workspace_desktopPane.setBackground(new Color(0, 0, 51));
		
		GridBagConstraints gbc_workspace_desktopPane = new GridBagConstraints();
		gbc_workspace_desktopPane.insets = new Insets(0, 0, 5, 10);
		gbc_workspace_desktopPane.fill = GridBagConstraints.BOTH;
		gbc_workspace_desktopPane.gridx = 0;
		gbc_workspace_desktopPane.gridy = 1;
		home_panel.add(workspace_desktopPane, gbc_workspace_desktopPane);
	}
	
	public void addMainInternalFrame() {
		//Check if frame to remove is there(not null)
		if(currFrame !=null) {
			currFrame.dispose();
		}
		
		currFrame = new StudentMain(workspace_desktopPane);
		workspace_desktopPane.add(currFrame);
		
		//Opens JinternalFrame centered in the JDesktopPane
		Dimension desktopSize = workspace_desktopPane.getSize();
		Dimension jInternalFrameSize = currFrame.getSize();
		
		//Test if current internal frame is of class Student main and renders the frame with that
		if(currFrame.getClass() == StudentMain.class){
			currFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/50,
			    (desktopSize.height- jInternalFrameSize.height)/50);
		}
		
	}
	
	
	public void registerListeners() {
		addBtnDash.addActionListener(this);
		updateBtnDash.addActionListener(this);
		logoutBtn.addActionListener(this);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(addBtnDash)) {
			//Check if frame to remove is there(not null)
			if(currFrame !=null) {
				workspace_desktopPane.removeAll();
				workspace_desktopPane.updateUI();

				currFrame = new AddIssue(workspace_desktopPane);
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
		
		if(e.getSource().equals(updateBtnDash)) {
			//Check if frame to remove is there(not null)
			if(currFrame !=null) {
				workspace_desktopPane.removeAll();
				workspace_desktopPane.updateUI();
				
				currFrame = new UpdateIssue(workspace_desktopPane);
				workspace_desktopPane.add(currFrame);
				
				//Opens JinternalFrame centered in the JDesktopPane
				Dimension desktopSize = workspace_desktopPane.getSize();
				Dimension jInternalFrameSize = currFrame.getSize();
				
				//Test if current internal frame is of class AddIssue and renders the frame with that
				if(currFrame.getClass() == UpdateIssue.class){
					currFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
					    (desktopSize.height- jInternalFrameSize.height)/2);
				}
			}

		}
		
		
		if(e.getSource().equals(logoutBtn)) {
			dispose();
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						UserLogin userLoginFrame = new UserLogin();
						userLoginFrame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}

}
