package com.view;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.client.Client;
import com.controller.LoginController;
import com.controller.UserController;
import com.model.User;
import com.view.staff.StaffDashboard;
import com.view.student.StudentDashboard;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.Insets;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.BoxLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class UserLogin extends JFrame implements ActionListener{
	private static final Logger logger = LogManager.getLogger(UserLogin.class);
	private static final long serialVersionUID = 7031615204478770810L;

	private JPanel mainPanel;
	private JPanel bannerPanel;
	private JLabel bannerIcon;
	private JPanel systemInfo_Panel;
	private JLabel systemTitle_Label;
	private JLabel sysSchool_Label;
	private JLabel sysType_Label;
	private JPanel auth_panel;
	private JLabel username_Label;
	private JLabel password_Label;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JPanel userSelect_Panel;
	private JRadioButton student_rdbtn;
	private JRadioButton agent_rdbtn;
	private JRadioButton rep_rdbtn;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel login_Panel;
	private JButton login_btn;
	private JLabel auth_message;
	
	public static Client client;
	public static User currentUser;
	String userType = "";
	
	/**
	 * Create the frame.
	 */
	public UserLogin(Client client) {
		logger.info("Starting Login Interface");
		initializeComponents();
		registerListeners();
		
		UserLogin.client = client;
		logger.info("Finished initailizing Login interface");
	}
	
	/**
	 * Initializes frame and its components to provide 
	 * user login view.
	 */
	private void initializeComponents(){
		setTitle("UTeQue - Student Enquiry Environment");
		setName("frame");
		setSize(new Dimension(400, 590));
		setResizable(false);
		setPreferredSize(new Dimension(400, 590));
		
		//Changes frame icon
		ImageIcon frameIcon = new ImageIcon("./Resources/img/Utech_logo.jpg");
		setIconImage(frameIcon.getImage());
		
		//Uses a main panel that every other component will lay
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(0, 0, 51));
		
		//Places main panel on frame content pane
		getContentPane().add(mainPanel, BorderLayout.EAST);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		/**
		 * Sets the top panel on top of the main panel for user 
		 * login icon to be displayed.
		 */
		bannerPanel = new JPanel();
		bannerPanel.setBackground(new Color(0, 0, 51));
		
		mainPanel.add(bannerPanel);
		
		bannerIcon = new JLabel(new ImageIcon(UserLogin.class.getResource("/img/usericon.png")));
		bannerIcon.setPreferredSize(new Dimension(130, 150));
		bannerIcon.setSize(new Dimension(20, 20));
		
		bannerPanel.add(bannerIcon);
		
		systemInfo_Panel = new JPanel();
		systemInfo_Panel.setBackground(new Color(0, 0, 51));
		systemInfo_Panel.setPreferredSize(new Dimension(400, 20));
		systemInfo_Panel.setSize(new Dimension(400, 50)); //CHECK
		
		mainPanel.add(systemInfo_Panel);
		
		//Uses a grid back layout to display system information such as title
		GridBagLayout gbl_systemInfo_Panel = new GridBagLayout();
		
		/**
		 * For the GridBag layout it will have 5 columns and 3 rows, 
		 * the final zero represents a place holder just in case another 
		 * row/column is needed.
		 */
		gbl_systemInfo_Panel.columnWidths = new int[] {70, 46, 0, 46, 70, 0};
		gbl_systemInfo_Panel.rowHeights = new int[]{14, 0, 0, 0};
		gbl_systemInfo_Panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_systemInfo_Panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		systemInfo_Panel.setLayout(gbl_systemInfo_Panel);
		
		systemTitle_Label = new JLabel("UTeQue");
		systemTitle_Label.setAlignmentX(Component.CENTER_ALIGNMENT);
		systemTitle_Label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		systemTitle_Label.setForeground(new Color(255, 255, 255));
		
		/**
		 * Places the systemTitle_Label in the 3rd row, 1st column of the 
		 * GridBag layout.
		 */
		GridBagConstraints gbc_systemTitle_Label = new GridBagConstraints();
		gbc_systemTitle_Label.anchor = GridBagConstraints.NORTH;
		gbc_systemTitle_Label.insets = new Insets(0, 0, 5, 5);
		gbc_systemTitle_Label.gridx = 2;
		gbc_systemTitle_Label.gridy = 0;
		systemInfo_Panel.add(systemTitle_Label, gbc_systemTitle_Label);
		
		sysSchool_Label = new JLabel("University of Technology");
		sysSchool_Label.setFont(new Font("Times New Roman", Font.BOLD, 15));
		sysSchool_Label.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_sysSchool_Label = new GridBagConstraints();
		gbc_sysSchool_Label.anchor = GridBagConstraints.NORTHEAST;
		gbc_sysSchool_Label.insets = new Insets(0, 0, 5, 5);
		gbc_sysSchool_Label.gridx = 2;
		gbc_sysSchool_Label.gridy = 1;
		systemInfo_Panel.add(sysSchool_Label, gbc_sysSchool_Label);
		
		sysType_Label = new JLabel("Query Portal");
		sysType_Label.setAlignmentX(Component.CENTER_ALIGNMENT);
		sysType_Label.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		sysType_Label.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_sysType_Label = new GridBagConstraints();
		gbc_sysType_Label.insets = new Insets(0, 0, 0, 5);
		gbc_sysType_Label.gridx = 2;
		gbc_sysType_Label.gridy = 2;
		systemInfo_Panel.add(sysType_Label, gbc_sysType_Label);

		
		auth_panel = new JPanel();
		auth_panel.setMinimumSize(new Dimension(10, 7));
		auth_panel.setBackground(new Color(0, 0, 51));
		mainPanel.add(auth_panel);
		GridBagLayout gbl_auth_panel = new GridBagLayout();
		gbl_auth_panel.columnWidths = new int[]{63, 0, 267, 0};	//3 columns
		gbl_auth_panel.rowHeights = new int[] {40, 40, 0, 0};	//3 rows
		gbl_auth_panel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_auth_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		auth_panel.setLayout(gbl_auth_panel);
		
		// Resize icon to fit on label 
		ImageIcon userimageIcon = new ImageIcon(new ImageIcon(UserLogin.class.getResource(
				"/img/username.png")).getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT));
		

		// Resize icon to fit on label 
		ImageIcon passwordimageIcon = new ImageIcon(new ImageIcon(UserLogin.class.getResource(
				"/img/lock-closed.png")).getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT));
		
		username_Label = new JLabel(userimageIcon);
		username_Label.setAlignmentX(Component.CENTER_ALIGNMENT);
		username_Label.setSize(new Dimension(15, 15));
		username_Label.setPreferredSize(new Dimension(15, 15));
		
				
		GridBagConstraints gbc_username_Label = new GridBagConstraints();
		gbc_username_Label.anchor = GridBagConstraints.EAST;
		gbc_username_Label.insets = new Insets(0, 0, 5, 5);
		gbc_username_Label.gridx = 1;
		gbc_username_Label.gridy = 0;
		auth_panel.add(username_Label, gbc_username_Label);
		
		//Holds USERNAME to be authenticated
		txtUsername = new JTextField();
		txtUsername.setCaretColor(Color.WHITE);
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
		
		password_Label = new JLabel();
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
		
		//Holds password to be authenticated
		txtPassword = new JPasswordField();
		txtPassword.setCaretColor(Color.WHITE);
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
		
		//Authentication message to set to display if login fails
		auth_message = new JLabel("Invalid username or password.");
		auth_message.setVisible(false);
		auth_message.setForeground(new Color(255, 0, 0));
		auth_message.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GridBagConstraints gbc_auth_message = new GridBagConstraints();
		gbc_auth_message.gridx = 2;
		gbc_auth_message.gridy = 3;
		auth_panel.add(auth_message, gbc_auth_message);
		
		userSelect_Panel = new JPanel();
		userSelect_Panel.setBackground(new Color(0, 0, 51));
		mainPanel.add(userSelect_Panel);
		
		/**
		 * Radio buttons to select user to be logged in.
		 * Adds both to a buttonGroup for ease of selection
		 */
		student_rdbtn = new JRadioButton("Student");
		student_rdbtn.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		student_rdbtn.setForeground(new Color(255, 255, 255));
		student_rdbtn.setBackground(new Color(0, 0, 51));
		student_rdbtn.setSelected(true);
		buttonGroup.add(student_rdbtn);
		userSelect_Panel.add(student_rdbtn);
		
		agent_rdbtn = new JRadioButton("Agent");
		agent_rdbtn.setForeground(new Color(255, 255, 255));
		agent_rdbtn.setBackground(new Color(0, 0, 51));
		agent_rdbtn.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		
		buttonGroup.add(agent_rdbtn);
		userSelect_Panel.add(agent_rdbtn);
		
		rep_rdbtn = new JRadioButton("Rep");
		rep_rdbtn.setForeground(Color.WHITE);
		rep_rdbtn.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		rep_rdbtn.setBackground(new Color(0, 0, 51));
		buttonGroup.add(rep_rdbtn);
		userSelect_Panel.add(rep_rdbtn);
		
		login_Panel = new JPanel();
		login_Panel.setPreferredSize(new Dimension(10, 100));
		login_Panel.setBackground(new Color(0, 0, 51));
		mainPanel.add(login_Panel);
		
		login_btn = new JButton("LOGIN");
		login_btn.setBorder(new LineBorder(null, 7, true));
		login_btn.setBackground(new Color(255, 51, 204));
		login_btn.setPreferredSize(new Dimension(70, 30));
		login_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		login_btn.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		login_btn.setBorderPainted(false);
		login_btn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		login_btn.setForeground(new Color(255, 255, 255));
		login_btn.setBounds(new Rectangle(0, 40, 50, 50));
				
		login_Panel.add(login_btn);
		
		//Centers frame on screen
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	
		setVisible(true);
	}	
	
	private void registerListeners() {
		logger.info("Registering Listeners");
		
		agent_rdbtn.addActionListener(this);
		student_rdbtn.addActionListener(this);
		rep_rdbtn.addActionListener(this);
		login_btn.addActionListener(this);
	}
	
	//Removes frame from display after use
	public void disposeFrame() {
		this.setVisible(false);
	}
	
	//Displays error message with login validation has failed.
	private void loginErrorMessage(){
		auth_message.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		login_btn.addMouseListener(new MouseAdapter() {
			//Changes button color when hovered over
			@Override
			public void mouseEntered(MouseEvent e) {
				login_btn.setBackground(new Color(250, 120, 217));
			}
			
			//Changes button color when exited from hover over
			@Override
			public void mouseExited(MouseEvent e) {
				login_btn.setBackground(new Color(255, 51, 204));		
			}
		});
		
		
		/**
		 * If the login button was used and either the staff or student radio 
		 * button is selected then execute authentication method.
		 */
		if(e.getSource() == login_btn && 
				(agent_rdbtn.isSelected() || student_rdbtn.isSelected()|| rep_rdbtn.isSelected() )
		) {
			userType = "";
			
			if(agent_rdbtn.isSelected())
				userType = "AGENT";
				
			else if (student_rdbtn.isSelected())
				userType = "STUDENT";
				
			else if (rep_rdbtn.isSelected())
				userType = "REP";
			
			if(client.startConnection()) {
				
				if(LoginController.authenticate(
						txtUsername.getText(), txtPassword.getPassword(), userType)
				){
					currentUser = new User(txtUsername.getText(), userType);
					UserController.setCurrentUser(txtUsername.getText(), userType);
					 
					chooseDashboard(userType);
					disposeFrame();
				}
				else {
					loginErrorMessage();
					client.disconnect();
				}
			}else { 
				JOptionPane.showMessageDialog(this, 
						"SEEMS THERE IS A CONNECTION ERROR", 
						"CONNECTION ERROR",
						JOptionPane.ERROR_MESSAGE);
				client.disconnect();
				dispose();
			}
			
		}
		
	}
	
	private void chooseDashboard(String userType) {
		switch(userType) {
		case "STUDENT":
			StudentDashboard studentDash = new StudentDashboard(this);
			studentDash.setVisible(true);
			break;
			
		case "REP":
		case "AGENT":
			StaffDashboard staffDash = new StaffDashboard(this);
			staffDash.setVisible(true);
			break;
		}
	}
}
