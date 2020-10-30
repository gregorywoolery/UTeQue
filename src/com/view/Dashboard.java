package com.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Image;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.border.LineBorder;
import javax.swing.JDesktopPane;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Dashboard extends JFrame {
	private JPanel contentPane;
	private JPanel sidebar_panel;
	private JPanel headers_panel;
	private JLabel dashboardTitle_lbl;
	private JLabel mainMenuTitle_lbl;
	private JPanel menu_panel;
	private JPanel logoutButton_panel;
	private JButton logout_btn;
	private JPanel home_panel;
	private JPanel banner_panel;
	private JPanel username_panel;
	private JLabel username_lbl;
	private JPanel userAccessories_panel;
	private JLabel notification_lbl;
	private JLabel lblNewLabel;
	private JDesktopPane workspace_desktopPane;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
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
	public Dashboard() {
		setTitle("UTeQue - Student Issue System");
		setName("dashboard_frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 705);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//Centers frame on screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		//Changes frame icon
		ImageIcon frameIcon = new ImageIcon("./Resources/img/Utech_logo.jpg");
		setIconImage(frameIcon.getImage());
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {200, 770};
		gbl_contentPane.rowHeights = new int[] {263};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{1.0};
		contentPane.setLayout(gbl_contentPane);
		
		sidebar_panel = new JPanel();
		sidebar_panel.setBorder(new LineBorder(new Color(0, 0, 51), 5, true));
		sidebar_panel.setBounds(new Rectangle(10, 10, 10, 10));
		sidebar_panel.setBackground(new Color(0, 0, 51));
		GridBagConstraints gbc_sidebar_panel = new GridBagConstraints();
		gbc_sidebar_panel.insets = new Insets(0, 5, 5, 10);
		gbc_sidebar_panel.gridy = 0;
		gbc_sidebar_panel.fill = GridBagConstraints.BOTH;
		gbc_sidebar_panel.gridx = 0;
		contentPane.add(sidebar_panel, gbc_sidebar_panel);
		GridBagLayout gbl_sidebar_panel = new GridBagLayout();
		gbl_sidebar_panel.columnWidths = new int[] {130};
		gbl_sidebar_panel.rowHeights = new int[] {18, 450, 70, 0};
		gbl_sidebar_panel.columnWeights = new double[]{1.0};
		gbl_sidebar_panel.rowWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		sidebar_panel.setLayout(gbl_sidebar_panel);
		
		headers_panel = new JPanel();
		headers_panel.setBackground(new Color(0, 0, 51));
		GridBagConstraints gbc_headers_panel = new GridBagConstraints();
		gbc_headers_panel.insets = new Insets(0, 0, 5, 5);
		gbc_headers_panel.fill = GridBagConstraints.BOTH;
		gbc_headers_panel.gridx = 0;
		gbc_headers_panel.gridy = 0;
		sidebar_panel.add(headers_panel, gbc_headers_panel);
		headers_panel.setLayout(new BorderLayout(0, 24));
		
		dashboardTitle_lbl = new JLabel("DASHBOARD");
		dashboardTitle_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		dashboardTitle_lbl.setPreferredSize(new Dimension(52, 16));
		dashboardTitle_lbl.setBackground(new Color(255, 255, 255));
		dashboardTitle_lbl.setIcon(new ImageIcon(Dashboard.class.getResource("/img/dashboard-1.png")));
		dashboardTitle_lbl.setFont(new Font("Times New Roman", Font.BOLD, 15));
		dashboardTitle_lbl.setForeground(new Color(0, 204, 255));
		headers_panel.add(dashboardTitle_lbl, BorderLayout.CENTER);
		
		mainMenuTitle_lbl = new JLabel("Main Menu");
		mainMenuTitle_lbl.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		mainMenuTitle_lbl.setForeground(Color.WHITE);
		headers_panel.add(mainMenuTitle_lbl, BorderLayout.SOUTH);
		
		menu_panel = new JPanel();
		menu_panel.setBackground(new Color(0, 0, 51));
		GridBagConstraints gbc_menu_panel = new GridBagConstraints();
		gbc_menu_panel.insets = new Insets(0, 0, 5, 5);
		gbc_menu_panel.fill = GridBagConstraints.BOTH;
		gbc_menu_panel.gridx = 0;
		gbc_menu_panel.gridy = 1;
		sidebar_panel.add(menu_panel, gbc_menu_panel);
		
		logoutButton_panel = new JPanel();
		logoutButton_panel.setBackground(new Color(0, 0, 51));
		GridBagConstraints gbc_logoutButton_panel = new GridBagConstraints();
		gbc_logoutButton_panel.insets = new Insets(30, 0, 0, 5);
		gbc_logoutButton_panel.fill = GridBagConstraints.BOTH;
		gbc_logoutButton_panel.gridx = 0;
		gbc_logoutButton_panel.gridy = 2;
		sidebar_panel.add(logoutButton_panel, gbc_logoutButton_panel);
		
		logout_btn = new JButton("Log Out");
		logout_btn.setPreferredSize(new Dimension(95, 35));
		logout_btn.setForeground(new Color(51, 153, 255));
		logout_btn.setBorder(null);
		logout_btn.setBackground(new Color(51, 255, 0));
		logout_btn.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		
		// Resize icon to fit on button
		// Resize icon to fit on label 
		ImageIcon buttonImageIcon = new ImageIcon(new ImageIcon(Dashboard.class.getResource(
				"/img/logout.png")).getImage().getScaledInstance(23, 23, Image.SCALE_DEFAULT));
		
		logout_btn.setIcon(buttonImageIcon);
		logoutButton_panel.add(logout_btn);
		
		home_panel = new JPanel();
		home_panel.setBounds(new Rectangle(10, 10, 10, 10));
		GridBagConstraints gbc_home_panel = new GridBagConstraints();
		gbc_home_panel.insets = new Insets(0, 0, 5, 0);
		gbc_home_panel.fill = GridBagConstraints.BOTH;
		gbc_home_panel.gridx = 1;
		gbc_home_panel.gridy = 0;
		contentPane.add(home_panel, gbc_home_panel);
		GridBagLayout gbl_home_panel = new GridBagLayout();
		gbl_home_panel.columnWidths = new int[] {0};
		gbl_home_panel.rowHeights = new int[] {0, 560};
		gbl_home_panel.columnWeights = new double[]{1.0};
		gbl_home_panel.rowWeights = new double[]{1.0, 1.0};
		home_panel.setLayout(gbl_home_panel);
		
		banner_panel = new JPanel();
		banner_panel.setBorder(null);
		banner_panel.setBackground(new Color(0, 0, 51));
		GridBagConstraints gbc_banner_panel = new GridBagConstraints();
		gbc_banner_panel.insets = new Insets(0, 0, 10, 10);
		gbc_banner_panel.fill = GridBagConstraints.BOTH;
		gbc_banner_panel.gridx = 0;
		gbc_banner_panel.gridy = 0;
		home_panel.add(banner_panel, gbc_banner_panel);
		GridBagLayout gbl_banner_panel = new GridBagLayout();
		gbl_banner_panel.rowHeights = new int[] {0};
		gbl_banner_panel.columnWidths = new int[] {200, 360};
		gbl_banner_panel.columnWeights = new double[]{1.0, 0.0};
		gbl_banner_panel.rowWeights = new double[]{1.0};
		banner_panel.setLayout(gbl_banner_panel);
		
		username_panel = new JPanel();
		username_panel.setForeground(new Color(255, 255, 255));
		username_panel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		username_panel.setBackground(new Color(0, 0, 51));
		GridBagConstraints gbc_username_panel = new GridBagConstraints();
		gbc_username_panel.insets = new Insets(0, 0, 0, 5);
		gbc_username_panel.fill = GridBagConstraints.BOTH;
		gbc_username_panel.gridx = 0;
		gbc_username_panel.gridy = 0;
		banner_panel.add(username_panel, gbc_username_panel);
		GridBagLayout gbl_username_panel = new GridBagLayout();
		gbl_username_panel.columnWeights = new double[]{0.0};
		gbl_username_panel.rowWeights = new double[]{0.0};
		username_panel.setLayout(gbl_username_panel);
		
		username_lbl = new JLabel("Ariana Lenoxx");
		username_lbl.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		username_lbl.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_username_lbl = new GridBagConstraints();
		gbc_username_lbl.gridx = 0;
		gbc_username_lbl.gridy = 0;
		username_panel.add(username_lbl, gbc_username_lbl);
		
		userAccessories_panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) userAccessories_panel.getLayout();
		flowLayout.setHgap(15);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		userAccessories_panel.setBackground(new Color(0, 0, 51));
		GridBagConstraints gbc_userAccessories_panel = new GridBagConstraints();
		gbc_userAccessories_panel.insets = new Insets(0, 0, 0, 5);
		gbc_userAccessories_panel.fill = GridBagConstraints.BOTH;
		gbc_userAccessories_panel.gridx = 1;
		gbc_userAccessories_panel.gridy = 0;
		banner_panel.add(userAccessories_panel, gbc_userAccessories_panel);
		
		notification_lbl = new JLabel("");
		notification_lbl.setIcon(new ImageIcon(Dashboard.class.getResource("/img/notification-false.png")));
		userAccessories_panel.add(notification_lbl);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/img/"+ "female" +"/student.png")));
		userAccessories_panel.add(lblNewLabel);
		
		workspace_desktopPane = new JDesktopPane();
		workspace_desktopPane.setBorder(new LineBorder(new Color(0, 0, 51), 5));
		workspace_desktopPane.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_workspace_desktopPane = new GridBagConstraints();
		gbc_workspace_desktopPane.insets = new Insets(0, 0, 5, 10);
		gbc_workspace_desktopPane.fill = GridBagConstraints.BOTH;
		gbc_workspace_desktopPane.gridx = 0;
		gbc_workspace_desktopPane.gridy = 1;
		home_panel.add(workspace_desktopPane, gbc_workspace_desktopPane);
		

	}
}
