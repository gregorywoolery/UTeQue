package com.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.BoxLayout;
import javax.swing.JMenu;



public class Dashboard extends JFrame {
	protected JPanel contentPane;
	protected JPanel sidebar_panel;
	protected JPanel headers_panel;
	protected JLabel dashboardTitle_lbl;
	protected JLabel mainMenuTitle_lbl;
	protected JPanel menu_panel;
	protected JPanel logoutButton_panel;
	protected JButton logout_btn;
	protected JPanel home_panel;
	protected JPanel banner_panel;
	protected JPanel username_panel;
	protected JLabel username_lbl;
	protected JPanel userAccessories_panel;
	protected JLabel notification_lbl;
	protected JLabel userAvatar_lbl;
	protected JDesktopPane workspace_desktopPane;

	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenu mnNewMenu_1;
	private JMenu mnNewMenu_2;



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
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		mnNewMenu_1 = new JMenu("New menu");
		menuBar.add(mnNewMenu_1);
		
		mnNewMenu_2 = new JMenu("New menu");
		menuBar.add(mnNewMenu_2);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0,204, 225));
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
		gbl_sidebar_panel.rowHeights = new int[] {18, 450, 70, 0, 0};
		gbl_sidebar_panel.columnWeights = new double[]{1.0};
		gbl_sidebar_panel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		sidebar_panel.setLayout(gbl_sidebar_panel);
		
		headers_panel = new JPanel();
		headers_panel.setBackground(new Color(0, 0, 51));
		GridBagConstraints gbc_headers_panel = new GridBagConstraints();
		gbc_headers_panel.insets = new Insets(0, 0, 5, 0);
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
		gbc_menu_panel.insets = new Insets(0, 15, 5, 0);
		gbc_menu_panel.fill = GridBagConstraints.BOTH;
		gbc_menu_panel.gridx = 0;
		gbc_menu_panel.gridy = 1;
		sidebar_panel.add(menu_panel, gbc_menu_panel);
		menu_panel.setLayout(new BoxLayout(menu_panel, BoxLayout.Y_AXIS));
		
		
		home_panel = new JPanel();
		home_panel.setBackground(new Color(0, 204, 225));
		home_panel.setBounds(new Rectangle(10, 10, 10, 10));
		GridBagConstraints gbc_home_panel = new GridBagConstraints();
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
		
		notification_lbl = new JLabel();
		notification_lbl.setIcon(new ImageIcon(Dashboard.class.getResource("/img/notification-false.png")));
		userAccessories_panel.add(notification_lbl);
		
		userAvatar_lbl = new JLabel("");
		userAvatar_lbl.setIcon(new ImageIcon(Dashboard.class.getResource("/img/"+ "female" +"/student.png")));
		userAccessories_panel.add(userAvatar_lbl);

	}

}
