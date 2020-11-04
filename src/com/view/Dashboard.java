package com.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

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
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.BoxLayout;
import java.awt.Cursor;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	private JLabel dashBtn_lbl;
	private JLabel issuesBtn_lbl;
	private JLabel viewBtn_lbl;
	private JPanel addIssue_panel;
	private JPanel updateIssue_panel;
	private JPanel IssueDisplay_panel;
	private JPanel studentIssue_panel;
	private JLabel addIssueTitle_lbl;
	private JComboBox addIssue_comboBox;
	private JLabel addedDate_lbl;
	private JButton addBtn;
	private JLabel addBtnDetials_lbl;
	private JButton btnNewButton_1;
	private JPanel userIssueStats_panel;
	private JLabel updateIssueTitle_lbl;
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenu mnNewMenu_1;
	private JMenu mnNewMenu_2;
	private JLabel issueMadeTitle_lbl;
	private JLabel issueMade_lbl;
	private JLabel issueCmpltTitle_lbl;
	private JLabel issueCompleted_lbl;
	private JSeparator separator;
	private JSeparator separator_1;
	private JLabel issuePendTitle_lbl;
	private JLabel issuePending_lbl;
	private JPanel issue_panel;
	private JTable table;
	private JLabel removeBtn_lbl;
	private JLabel tableTitle_lbl;
	private JPanel search_panel;
	private JLabel searchFor_lbl;
	private JLabel mainTag_lbl;
	private JTextField mainTagSearch_textField;
	private JComboBox searchIssueType_comboBox;
	private JButton searchIcon_lbl;
	private JLabel updateBtn_lbl;
	private JButton removeBtn;
	private JComboBox upadateIssue_comboBox;
	private JButton updateBtn;
	private JLabel dateMadeUpdate_lbl;
	private JPanel date_panel;
	private DatePicker updateDatePicker;


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
		
		dashBtn_lbl = new JLabel("Dash");
		dashBtn_lbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dashBtn_lbl.setAlignmentY(Component.TOP_ALIGNMENT);
		dashBtn_lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		dashBtn_lbl.setHorizontalTextPosition(SwingConstants.LEADING);
		dashBtn_lbl.setHorizontalAlignment(SwingConstants.LEFT);
		dashBtn_lbl.setMaximumSize(new Dimension(140, 40));
		dashBtn_lbl.setPreferredSize(new Dimension(99, 30));
		dashBtn_lbl.setForeground(new Color(255, 255, 255));
		dashBtn_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		menu_panel.add(dashBtn_lbl);
		
		issuesBtn_lbl = new JLabel("Issues");
		issuesBtn_lbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		issuesBtn_lbl.setAlignmentY(Component.TOP_ALIGNMENT);
		issuesBtn_lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		issuesBtn_lbl.setHorizontalTextPosition(SwingConstants.LEADING);
		issuesBtn_lbl.setHorizontalAlignment(SwingConstants.LEFT);
		issuesBtn_lbl.setMaximumSize(new Dimension(140, 40));
		issuesBtn_lbl.setPreferredSize(new Dimension(99, 30));
		issuesBtn_lbl.setForeground(new Color(255, 255, 255));
		issuesBtn_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		menu_panel.add(issuesBtn_lbl);
		
		viewBtn_lbl = new JLabel("View");
		viewBtn_lbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		viewBtn_lbl.setAlignmentY(Component.TOP_ALIGNMENT);
		viewBtn_lbl.setBorder(null);
		viewBtn_lbl.setHorizontalTextPosition(SwingConstants.LEADING);
		viewBtn_lbl.setHorizontalAlignment(SwingConstants.LEFT);
		viewBtn_lbl.setMaximumSize(new Dimension(140, 40));
		viewBtn_lbl.setPreferredSize(new Dimension(99, 30));
		viewBtn_lbl.setForeground(new Color(255, 255, 255));
		viewBtn_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		menu_panel.add(viewBtn_lbl);
		
		JLabel addBtn_lbl = new JLabel("Add");
		addBtn_lbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addBtn_lbl.setAlignmentY(Component.TOP_ALIGNMENT);
		addBtn_lbl.setBorder(null);
		addBtn_lbl.setHorizontalTextPosition(SwingConstants.LEADING);
		addBtn_lbl.setHorizontalAlignment(SwingConstants.LEFT);
		addBtn_lbl.setMaximumSize(new Dimension(140, 40));
		addBtn_lbl.setPreferredSize(new Dimension(99, 30));
		addBtn_lbl.setForeground(new Color(255, 255, 255));
		addBtn_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		menu_panel.add(addBtn_lbl);
		
		JLabel searchBtn_lbl = new JLabel("Search");
		searchBtn_lbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		searchBtn_lbl.setAlignmentY(Component.TOP_ALIGNMENT);
		searchBtn_lbl.setBorder(null);
		searchBtn_lbl.setHorizontalTextPosition(SwingConstants.LEADING);
		searchBtn_lbl.setHorizontalAlignment(SwingConstants.LEFT);
		searchBtn_lbl.setMaximumSize(new Dimension(140, 40));
		searchBtn_lbl.setPreferredSize(new Dimension(99, 30));
		searchBtn_lbl.setForeground(new Color(255, 255, 255));
		searchBtn_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		menu_panel.add(searchBtn_lbl);
		
		updateBtn_lbl = new JLabel("Update");
		updateBtn_lbl.setPreferredSize(new Dimension(99, 30));
		updateBtn_lbl.setMaximumSize(new Dimension(140, 40));
		updateBtn_lbl.setHorizontalTextPosition(SwingConstants.LEADING);
		updateBtn_lbl.setHorizontalAlignment(SwingConstants.LEFT);
		updateBtn_lbl.setForeground(Color.WHITE);
		updateBtn_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		updateBtn_lbl.setBorder(null);
		updateBtn_lbl.setAlignmentY(0.0f);
		menu_panel.add(updateBtn_lbl);
		
		removeBtn_lbl = new JLabel("Remove");
		removeBtn_lbl.setPreferredSize(new Dimension(99, 30));
		removeBtn_lbl.setMaximumSize(new Dimension(140, 40));
		removeBtn_lbl.setHorizontalTextPosition(SwingConstants.LEADING);
		removeBtn_lbl.setHorizontalAlignment(SwingConstants.LEFT);
		removeBtn_lbl.setForeground(Color.WHITE);
		removeBtn_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		removeBtn_lbl.setBorder(null);
		removeBtn_lbl.setAlignmentY(0.0f);
		menu_panel.add(removeBtn_lbl);
		
		JLabel notificationBtn_lbl = new JLabel("Notification");
		notificationBtn_lbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		notificationBtn_lbl.setAlignmentY(Component.TOP_ALIGNMENT);
		notificationBtn_lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		notificationBtn_lbl.setHorizontalTextPosition(SwingConstants.LEADING);
		notificationBtn_lbl.setHorizontalAlignment(SwingConstants.LEFT);
		notificationBtn_lbl.setMaximumSize(new Dimension(140, 55));
		notificationBtn_lbl.setPreferredSize(new Dimension(99, 30));
		notificationBtn_lbl.setForeground(new Color(255, 255, 255));
		notificationBtn_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		menu_panel.add(notificationBtn_lbl);
		
		logoutButton_panel = new JPanel();
		logoutButton_panel.setBackground(new Color(0, 0, 51));
		GridBagConstraints gbc_logoutButton_panel = new GridBagConstraints();
		gbc_logoutButton_panel.insets = new Insets(30, 0, 5, 0);
		gbc_logoutButton_panel.fill = GridBagConstraints.BOTH;
		gbc_logoutButton_panel.gridx = 0;
		gbc_logoutButton_panel.gridy = 2;
		sidebar_panel.add(logoutButton_panel, gbc_logoutButton_panel);
		
		logout_btn = new JButton("Log Out");
		logout_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		logout_btn.setFocusPainted(false);
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
		
		notification_lbl = new JLabel("");
		notification_lbl.setIcon(new ImageIcon(Dashboard.class.getResource("/img/notification-false.png")));
		userAccessories_panel.add(notification_lbl);
		
		userAvatar_lbl = new JLabel("");
		userAvatar_lbl.setIcon(new ImageIcon(Dashboard.class.getResource("/img/"+ "female" +"/student.png")));
		userAccessories_panel.add(userAvatar_lbl);
		
		workspace_desktopPane = new JDesktopPane();
		workspace_desktopPane.setBorder(new LineBorder(new Color(0, 0, 51), 5));
		workspace_desktopPane.setBackground(new Color(0, 0, 51));
		GridBagConstraints gbc_workspace_desktopPane = new GridBagConstraints();
		gbc_workspace_desktopPane.insets = new Insets(0, 0, 5, 10);
		gbc_workspace_desktopPane.fill = GridBagConstraints.BOTH;
		gbc_workspace_desktopPane.gridx = 0;
		gbc_workspace_desktopPane.gridy = 1;
		home_panel.add(workspace_desktopPane, gbc_workspace_desktopPane);
		GridBagLayout gbl_workspace_desktopPane = new GridBagLayout();
		gbl_workspace_desktopPane.columnWidths = new int[]{238, 238, 238, 0};
		gbl_workspace_desktopPane.rowHeights = new int[] {50, 160, 340, 0};
		gbl_workspace_desktopPane.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_workspace_desktopPane.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		workspace_desktopPane.setLayout(gbl_workspace_desktopPane);
		
		studentIssue_panel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) studentIssue_panel.getLayout();
		flowLayout_1.setVgap(0);
		flowLayout_1.setHgap(10);
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		studentIssue_panel.setBackground(new Color(255, 255, 0));
		GridBagConstraints gbc_studentIssue_panel = new GridBagConstraints();
		gbc_studentIssue_panel.gridwidth = 3;
		gbc_studentIssue_panel.insets = new Insets(0, 0, 5, 0);
		gbc_studentIssue_panel.fill = GridBagConstraints.BOTH;
		gbc_studentIssue_panel.gridx = 0;
		gbc_studentIssue_panel.gridy = 0;
		workspace_desktopPane.add(studentIssue_panel, gbc_studentIssue_panel);
		
		btnNewButton_1 = new JButton("LIVE CHAT");
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setBackground(new Color(0, 0, 51));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		btnNewButton_1.setPreferredSize(new Dimension(100, 30));
		btnNewButton_1.setMaximumSize(new Dimension(200, 100));
		studentIssue_panel.add(btnNewButton_1);
		btnNewButton_1.setBorder(null);
		
		userIssueStats_panel = new JPanel();
		FlowLayout fl_userIssueStats_panel = (FlowLayout) userIssueStats_panel.getLayout();
		userIssueStats_panel.setPreferredSize(new Dimension(470, 30));
		userIssueStats_panel.setBackground(new Color(0, 0, 51));
		studentIssue_panel.add(userIssueStats_panel);
		
		issueMadeTitle_lbl = new JLabel("Issues Made:");
		issueMadeTitle_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		issueMadeTitle_lbl.setForeground(new Color(255, 255, 255));
		userIssueStats_panel.add(issueMadeTitle_lbl);
		
		issueMade_lbl = new JLabel("0");
		issueMade_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		issueMade_lbl.setForeground(new Color(255, 255, 255));
		userIssueStats_panel.add(issueMade_lbl);
		
		separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(new Color(0, 153, 255));
		separator.setPreferredSize(new Dimension(5, 20));
		userIssueStats_panel.add(separator);
		
		issueCmpltTitle_lbl = new JLabel("Issues Completed:");
		issueCmpltTitle_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		issueCmpltTitle_lbl.setForeground(new Color(255, 255, 255));
		userIssueStats_panel.add(issueCmpltTitle_lbl);
		
		issueCompleted_lbl = new JLabel("0");
		issueCompleted_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		issueCompleted_lbl.setForeground(new Color(255, 255, 255));
		userIssueStats_panel.add(issueCompleted_lbl);
		
		separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(new Color(0, 153, 255));
		separator_1.setPreferredSize(new Dimension(5, 20));
		userIssueStats_panel.add(separator_1);
		
		issuePendTitle_lbl = new JLabel("Issues Pending:");
		issuePendTitle_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		issuePendTitle_lbl.setForeground(new Color(255, 255, 255));
		userIssueStats_panel.add(issuePendTitle_lbl);
		
		issuePending_lbl = new JLabel("0");
		issuePending_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		issuePending_lbl.setForeground(new Color(255, 255, 255));
		userIssueStats_panel.add(issuePending_lbl);
		
		addIssue_panel = new JPanel();
		addIssue_panel.setBackground(new Color(255, 255, 0));
		addIssue_panel.setName("");
		GridBagConstraints gbc_addIssue_panel = new GridBagConstraints();
		gbc_addIssue_panel.fill = GridBagConstraints.BOTH;
		gbc_addIssue_panel.insets = new Insets(0, 0, 5, 5);
		gbc_addIssue_panel.gridx = 0;
		gbc_addIssue_panel.gridy = 1;
		workspace_desktopPane.add(addIssue_panel, gbc_addIssue_panel);
		addIssue_panel.setLayout(new BoxLayout(addIssue_panel, BoxLayout.Y_AXIS));
		
		addIssueTitle_lbl = new JLabel("ADD ISSUE");
		addIssueTitle_lbl.setBorder(new LineBorder(new Color(255, 255, 0), 10));
		addIssueTitle_lbl.setForeground(new Color(0, 0, 51));
		addIssueTitle_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		addIssueTitle_lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Makes label text underline
		Font font = addIssueTitle_lbl.getFont();
		Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		addIssueTitle_lbl.setFont(font.deriveFont(attributes));
		addIssue_panel.add(addIssueTitle_lbl);
		
		addIssue_comboBox = new JComboBox();
		addIssue_comboBox.setForeground(new Color(255, 255, 255));
		addIssue_comboBox.setBorder(null);
		addIssue_comboBox.setBackground(new Color(0, 0, 51));
		addIssue_comboBox.setMaximumSize(new Dimension(100, 25));
		addIssue_comboBox.setPreferredSize(new Dimension(25, 20));
		addIssue_comboBox.setModel(new DefaultComboBoxModel(new String[] {"Complaint", "Query"}));
		addIssue_comboBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		addIssue_panel.add(addIssue_comboBox);
		
		addedDate_lbl = new JLabel("dd/mm/yyyy");
		addedDate_lbl.setForeground(new Color(0, 0, 0));
		addedDate_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		addedDate_lbl.setMaximumSize(new Dimension(100, 35));
		addedDate_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		addedDate_lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		addIssue_panel.add(addedDate_lbl);
		
		addBtnDetials_lbl = new JLabel("Construct Issue:");
		addBtnDetials_lbl.setForeground(new Color(0, 0, 0));
		addBtnDetials_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		addBtnDetials_lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		addIssue_panel.add(addBtnDetials_lbl);
		
		addBtn = new JButton("ADD");
		addBtn.setForeground(new Color(255, 255, 255));
		addBtn.setBackground(new Color(0, 204, 225));
		addBtn.setMaximumSize(new Dimension(100, 30));
		addBtn.setBorder(null);
		addBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		addBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		addIssue_panel.add(addBtn);
		
		updateIssue_panel = new JPanel();
		updateIssue_panel.setBackground(new Color(255, 255, 0));
		GridBagConstraints gbc_updateIssue_panel = new GridBagConstraints();
		gbc_updateIssue_panel.fill = GridBagConstraints.BOTH;
		gbc_updateIssue_panel.insets = new Insets(0, 0, 5, 0);
		gbc_updateIssue_panel.gridx = 2;
		gbc_updateIssue_panel.gridy = 1;
		workspace_desktopPane.add(updateIssue_panel, gbc_updateIssue_panel);
		
		updateIssueTitle_lbl = new JLabel("UPDATE ISSUE");
		updateIssueTitle_lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		updateIssueTitle_lbl.setBorder(new LineBorder(new Color(255, 255, 0), 10));
		updateIssueTitle_lbl.setForeground(new Color(0, 0, 51));
		updateIssueTitle_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		
		//Makes label text underline
		Font font1 = updateIssueTitle_lbl.getFont();
		Map<TextAttribute, Object> attributes1 = new HashMap<>(font1.getAttributes());
		attributes1.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		updateIssue_panel.setLayout(new BoxLayout(updateIssue_panel, BoxLayout.Y_AXIS));
		updateIssueTitle_lbl.setFont(font1.deriveFont(attributes1));
		
		updateIssue_panel.add(updateIssueTitle_lbl);
		
		upadateIssue_comboBox = new JComboBox();
		upadateIssue_comboBox.setModel(new DefaultComboBoxModel(new String[] {"Complaint", "Query"}));
		upadateIssue_comboBox.setPreferredSize(new Dimension(25, 20));
		upadateIssue_comboBox.setMaximumSize(new Dimension(100, 25));
		upadateIssue_comboBox.setForeground(Color.WHITE);
		upadateIssue_comboBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		upadateIssue_comboBox.setBorder(null);
		upadateIssue_comboBox.setBackground(new Color(0, 0, 51));
		updateIssue_panel.add(upadateIssue_comboBox);
		
		dateMadeUpdate_lbl = new JLabel("Date Made:");
		dateMadeUpdate_lbl.setPreferredSize(new Dimension(70, 14));
		dateMadeUpdate_lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		updateIssue_panel.add(dateMadeUpdate_lbl);
		dateMadeUpdate_lbl.setMaximumSize(new Dimension(75, 22));
		dateMadeUpdate_lbl.setForeground(new Color(0, 0, 51));
		dateMadeUpdate_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		
		date_panel = new JPanel();
		date_panel.setBackground(new Color(255, 255, 0));
		date_panel.setMaximumSize(new Dimension(300, 30));
		updateIssue_panel.add(date_panel);
		
		updateDatePicker = new DatePicker();
		date_panel.add(updateDatePicker);

		
		updateBtn = new JButton("UPDATE");
		updateBtn.setMaximumSize(new Dimension(100, 30));
		updateBtn.setForeground(Color.WHITE);
		updateBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		updateBtn.setBorder(null);
		updateBtn.setBackground(new Color(0, 204, 225));
		updateBtn.setAlignmentX(0.5f);
		updateIssue_panel.add(updateBtn);
		
		IssueDisplay_panel = new JPanel();
		IssueDisplay_panel.setBackground(new Color(0, 0, 51));
		GridBagConstraints gbc_IssueDisplay_panel = new GridBagConstraints();
		gbc_IssueDisplay_panel.gridwidth = 3;
		gbc_IssueDisplay_panel.fill = GridBagConstraints.BOTH;
		gbc_IssueDisplay_panel.gridx = 0;
		gbc_IssueDisplay_panel.gridy = 2;
		workspace_desktopPane.add(IssueDisplay_panel, gbc_IssueDisplay_panel);
		GridBagLayout gbl_IssueDisplay_panel = new GridBagLayout();
		gbl_IssueDisplay_panel.columnWidths = new int[]{0, 0};
		gbl_IssueDisplay_panel.rowHeights = new int[] {50, 290, 0};
		gbl_IssueDisplay_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_IssueDisplay_panel.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		IssueDisplay_panel.setLayout(gbl_IssueDisplay_panel);
		
		issue_panel = new JPanel();
		issue_panel.setBackground(new Color(255, 255, 0));
		FlowLayout fl_issue_panel = (FlowLayout) issue_panel.getLayout();
		fl_issue_panel.setHgap(15);
		fl_issue_panel.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_issue_panel = new GridBagConstraints();
		gbc_issue_panel.fill = GridBagConstraints.BOTH;
		gbc_issue_panel.gridx = 0;
		gbc_issue_panel.gridy = 0;
		IssueDisplay_panel.add(issue_panel, gbc_issue_panel);
		
		tableTitle_lbl = new JLabel("Issues");
		tableTitle_lbl.setForeground(new Color(0, 0, 51));
		tableTitle_lbl.setBackground(new Color(255, 255, 255));
		tableTitle_lbl.setPreferredSize(new Dimension(65, 30));
		tableTitle_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		issue_panel.add(tableTitle_lbl);
		
		searchFor_lbl = new JLabel("Search:");
		searchFor_lbl.setForeground(new Color(0, 0, 51));
		searchFor_lbl.setBackground(new Color(255, 255, 255));
		searchFor_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		issue_panel.add(searchFor_lbl);
		
		search_panel = new JPanel();
		search_panel.setBackground(new Color(255, 255, 0));
		FlowLayout fl_search_panel = (FlowLayout) search_panel.getLayout();
		fl_search_panel.setHgap(10);
		fl_search_panel.setAlignment(FlowLayout.LEFT);
		search_panel.setPreferredSize(new Dimension(550, 35));
		issue_panel.add(search_panel);
		
		searchIssueType_comboBox = new JComboBox();
		searchIssueType_comboBox.setModel(new DefaultComboBoxModel(new String[] {"Complaint", "Query"}));
		searchIssueType_comboBox.setPreferredSize(new Dimension(100, 25));
		searchIssueType_comboBox.setMaximumSize(new Dimension(100, 25));
		searchIssueType_comboBox.setForeground(new Color(0, 0, 51));
		searchIssueType_comboBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		searchIssueType_comboBox.setBorder(null);
		searchIssueType_comboBox.setBackground(new Color(255, 255, 0));
		search_panel.add(searchIssueType_comboBox);
		
		mainTag_lbl = new JLabel("Main Tag:");
		mainTag_lbl.setForeground(new Color(0, 0, 51));
		mainTag_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		search_panel.add(mainTag_lbl);
		
		mainTagSearch_textField = new JTextField();
		mainTagSearch_textField.setForeground(new Color(0, 0, 51));
		mainTagSearch_textField.setMargin(new Insets(2, 0, 2, 0));
		mainTagSearch_textField.setPreferredSize(new Dimension(10, 25));
		mainTagSearch_textField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		search_panel.add(mainTagSearch_textField);
		mainTagSearch_textField.setColumns(15);
		
		/*	Using external LGoodDatePicker
		 *  Create a date picker with some custom settings. 
		 */
	    DatePicker searchDatePicker = new DatePicker();
	    searchDatePicker.setBackground(new Color(255, 255, 0));
		search_panel.add(searchDatePicker);
		
		//Resize Search icon
		ImageIcon searchImageIcon = new ImageIcon(new ImageIcon(Dashboard.class.getResource("/img/search.png"))
				.getImage().getScaledInstance(23, 23, Image.SCALE_DEFAULT));
		
		searchIcon_lbl = new JButton(searchImageIcon);
		searchIcon_lbl.setBorder(null);
		searchIcon_lbl.setBackground(new Color(255, 255, 0));
		search_panel.add(searchIcon_lbl);
		
		removeBtn = new JButton("");
		removeBtn.setBackground(new Color(255, 255, 0));
		removeBtn.setIcon(new ImageIcon(Dashboard.class.getResource("/img/delete.png")));
		removeBtn.setBorder(null);
		search_panel.add(removeBtn);
		
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Type", "Main Detials", "Dates Issued", "Status", "Agent"
			}
		));
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(89);
		table.getColumnModel().getColumn(1).setPreferredWidth(156);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(83);
		table.getColumnModel().getColumn(4).setPreferredWidth(135);
		table.setGridColor(new Color(255, 255, 255));
		table.setBackground(new Color(0, 0, 51));
		table.setEnabled(false);
		
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 1;
		IssueDisplay_panel.add(table, gbc_table);
		
		registerListeners();
	}
	
	public void registerListeners() {
		searchIcon_lbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				searchIcon_lbl.setBorder(new LineBorder(new Color(0, 0, 51)));
			}
		});
	}
}
