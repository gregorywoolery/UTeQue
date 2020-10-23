package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.border.LineBorder;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Rectangle;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JPasswordField;

public class UserLogin extends JFrame {
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogin frame = new UserLogin();
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
	public UserLogin() {
		setTitle("UTeQue - Student Query Environment");
		setName("frame");
		setSize(new Dimension(400, 590));
		setResizable(false);
		setPreferredSize(new Dimension(400, 590));
		
		//Changes frame icon
		ImageIcon frameIcon = new ImageIcon("./Resources/img/Utech_logo.jpg");
		setIconImage(frameIcon.getImage());
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(0, 0, 51));
		getContentPane().add(mainPanel, BorderLayout.EAST);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		JPanel bannerPanel = new JPanel();
		bannerPanel.setBackground(new Color(0, 0, 51));
		mainPanel.add(bannerPanel);
		
		JLabel bannerIcon = new JLabel(new ImageIcon(UserLogin.class.getResource("/img/usericon.png")));
		bannerIcon.setPreferredSize(new Dimension(130, 150));
		bannerIcon.setSize(new Dimension(20, 20));
		bannerPanel.add(bannerIcon);
		
		JPanel systemInfo_Panel = new JPanel();
		systemInfo_Panel.setBackground(new Color(0, 0, 51));
		systemInfo_Panel.setPreferredSize(new Dimension(400, 20));
		systemInfo_Panel.setSize(new Dimension(400, 50));
		mainPanel.add(systemInfo_Panel);
		GridBagLayout gbl_systemInfo_Panel = new GridBagLayout();
		gbl_systemInfo_Panel.columnWidths = new int[] {70, 46, 0, 46, 70, 0};
		gbl_systemInfo_Panel.rowHeights = new int[]{14, 0, 0, 0};
		gbl_systemInfo_Panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_systemInfo_Panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		systemInfo_Panel.setLayout(gbl_systemInfo_Panel);
		
		JLabel systemTitle_Label = new JLabel("UTeQue");
		systemTitle_Label.setAlignmentX(Component.CENTER_ALIGNMENT);
		systemTitle_Label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		systemTitle_Label.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_systemTitle_Label = new GridBagConstraints();
		gbc_systemTitle_Label.anchor = GridBagConstraints.NORTH;
		gbc_systemTitle_Label.insets = new Insets(0, 0, 5, 5);
		gbc_systemTitle_Label.gridx = 2;
		gbc_systemTitle_Label.gridy = 0;
		systemInfo_Panel.add(systemTitle_Label, gbc_systemTitle_Label);
		
		JLabel sysSchool_Label = new JLabel("University of Technology");
		sysSchool_Label.setFont(new Font("Times New Roman", Font.BOLD, 15));
		sysSchool_Label.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_sysSchool_Label = new GridBagConstraints();
		gbc_sysSchool_Label.anchor = GridBagConstraints.NORTHEAST;
		gbc_sysSchool_Label.insets = new Insets(0, 0, 5, 5);
		gbc_sysSchool_Label.gridx = 2;
		gbc_sysSchool_Label.gridy = 1;
		systemInfo_Panel.add(sysSchool_Label, gbc_sysSchool_Label);
		
		JLabel sysType_Label = new JLabel("Query Portal");
		sysType_Label.setAlignmentX(Component.CENTER_ALIGNMENT);
		sysType_Label.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		sysType_Label.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_sysType_Label = new GridBagConstraints();
		gbc_sysType_Label.insets = new Insets(0, 0, 0, 5);
		gbc_sysType_Label.gridx = 2;
		gbc_sysType_Label.gridy = 2;
		systemInfo_Panel.add(sysType_Label, gbc_sysType_Label);

		
		JPanel auth_panel = new JPanel();
		auth_panel.setMinimumSize(new Dimension(10, 7));
		auth_panel.setBackground(new Color(0, 0, 51));
		mainPanel.add(auth_panel);
		GridBagLayout gbl_auth_panel = new GridBagLayout();
		gbl_auth_panel.columnWidths = new int[]{63, 0, 267, 0};
		gbl_auth_panel.rowHeights = new int[] {40, 40};
		gbl_auth_panel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_auth_panel.rowWeights = new double[]{0.0, 0.0};
		auth_panel.setLayout(gbl_auth_panel);
		
		// Resize icon to fit on label 
		ImageIcon userimageIcon = new ImageIcon(new ImageIcon(UserLogin.class.getResource(
				"/img/username.png")).getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT));
		

		// Resize icon to fit on label 
		ImageIcon passwordimageIcon = new ImageIcon(new ImageIcon(UserLogin.class.getResource(
				"/img/lock-closed.png")).getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT));
		
		JLabel username_Label = new JLabel("");
		username_Label.setAlignmentX(Component.CENTER_ALIGNMENT);
		username_Label.setSize(new Dimension(15, 15));
		username_Label.setPreferredSize(new Dimension(15, 15));
		username_Label.setIcon(userimageIcon);
		
				
				GridBagConstraints gbc_username_Label = new GridBagConstraints();
				gbc_username_Label.anchor = GridBagConstraints.EAST;
				gbc_username_Label.insets = new Insets(0, 0, 5, 5);
				gbc_username_Label.gridx = 1;
				gbc_username_Label.gridy = 0;
				auth_panel.add(username_Label, gbc_username_Label);
		
		txtUsername = new JTextField();
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsername.setForeground(new Color(255, 255, 255));
		txtUsername.setBackground(new Color(0, 0, 51));
		txtUsername.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtUsername.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255), 2, true),
				"Username", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		txtUsername.setMargin(new Insets(3, 2, 2, 2));
		txtUsername.setPreferredSize(new Dimension(15, 35));
		txtUsername.setSize(new Dimension(25, 50));
		txtUsername.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		txtUsername.setAlignmentX(Component.RIGHT_ALIGNMENT);
		GridBagConstraints gbc_txtUsername = new GridBagConstraints();
		gbc_txtUsername.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtUsername.insets = new Insets(0, 0, 5, 0);
		gbc_txtUsername.gridx = 2;
		gbc_txtUsername.gridy = 0;
		auth_panel.add(txtUsername, gbc_txtUsername);
		txtUsername.setColumns(23);
		
		JLabel password_Label = new JLabel("");
		password_Label.setAlignmentX(Component.RIGHT_ALIGNMENT);
		password_Label.setSize(new Dimension(15, 15));
		password_Label.setPreferredSize(new Dimension(15, 15));
		password_Label.setIcon(passwordimageIcon);		
		
				GridBagConstraints gbc_password_Label = new GridBagConstraints();
				gbc_password_Label.insets = new Insets(0, 0, 5, 5);
				gbc_password_Label.anchor = GridBagConstraints.EAST;
				gbc_password_Label.gridx = 1;
				gbc_password_Label.gridy = 1;
				auth_panel.add(password_Label, gbc_password_Label);
		
		txtPassword = new JPasswordField();
		txtPassword.setForeground(new Color(255, 255, 255));
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setBackground(new Color(0, 0, 51));
		txtPassword.setSize(new Dimension(10, 50));
		txtPassword.setPreferredSize(new Dimension(15, 35));
		txtPassword.setMargin(new Insets(3, 2, 2, 2));
		txtPassword.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtPassword.setColumns(23);
		txtPassword.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255), 2, true),
				"Password", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		txtPassword.setAlignmentY(1.0f);
		txtPassword.setAlignmentX(1.0f);
		GridBagConstraints gbc_txtPassword = new GridBagConstraints();
		gbc_txtPassword.insets = new Insets(0, 0, 5, 0);
		gbc_txtPassword.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtPassword.gridx = 2;
		gbc_txtPassword.gridy = 1;
		auth_panel.add(txtPassword, gbc_txtPassword);
		
		JPanel userSelect_Panel = new JPanel();
		userSelect_Panel.setBackground(new Color(0, 0, 51));
		mainPanel.add(userSelect_Panel);
		
		JRadioButton student_rdbtn = new JRadioButton("Student");
		student_rdbtn.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		student_rdbtn.setForeground(new Color(255, 255, 255));
		student_rdbtn.setBackground(new Color(0, 0, 51));
		buttonGroup.add(student_rdbtn);
		userSelect_Panel.add(student_rdbtn);
		
		JRadioButton staff_rdbtn = new JRadioButton("Staff");
		staff_rdbtn.setForeground(new Color(255, 255, 255));
		staff_rdbtn.setBackground(new Color(0, 0, 51));
		staff_rdbtn.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		buttonGroup.add(staff_rdbtn);
		userSelect_Panel.add(staff_rdbtn);
		
		JPanel login_Panel = new JPanel();
		login_Panel.setPreferredSize(new Dimension(10, 100));
		login_Panel.setBackground(new Color(0, 0, 51));
		mainPanel.add(login_Panel);
		
		JButton login_btn = new JButton("LOGIN");
		login_btn.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		login_btn.setBorderPainted(false);
		login_btn.setPreferredSize(new Dimension(70, 30));
		login_btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		login_btn.setForeground(new Color(255, 255, 255));
		login_btn.setBorder(new LineBorder(null, 7, true));
		login_btn.setBackground(new Color(255, 51, 204));
		login_btn.setBounds(new Rectangle(0, 40, 50, 50));
				
		login_Panel.add(login_btn);
		
		
	}
}
