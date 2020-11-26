package com.view.staff;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.border.LineBorder;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.Cursor;
import javax.swing.BoxLayout;

public class StaffIssueResponse extends JInternalFrame {
	
	public StaffIssueResponse(JDesktopPane workSpaceDesktop) {
		super("Issue-Response", 
				false, 	//resizable
				true, 	//closable
				false, 	//maximizable
				true);	//iconifiable
		initializeComponents();
		registerListeners();
	}
	
	/**
	 * Create the frame.
	 */
	private void initializeComponents() {
		//Removes top bar from internal frame
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		
		getContentPane().setBackground(new Color(0, 0, 51));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {540, 0, 0};
		gridBagLayout.rowHeights = new int[] {0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel titile_lbl = new JLabel("Issue - Response");
		titile_lbl.setHorizontalTextPosition(SwingConstants.LEADING);
		titile_lbl.setPreferredSize(new Dimension(250, 50));
		titile_lbl.setForeground(new Color(255, 255, 255));
		titile_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		GridBagConstraints gbc_titile_lbl = new GridBagConstraints();
		gbc_titile_lbl.anchor = GridBagConstraints.WEST;
		gbc_titile_lbl.insets = new Insets(10, 5, 10, 5);
		gbc_titile_lbl.gridx = 0;
		gbc_titile_lbl.gridy = 0;
		getContentPane().add(titile_lbl, gbc_titile_lbl);
		
		JLabel help_label = new JLabel("");
		help_label.setIcon(new ImageIcon(StaffIssueResponse.class.getResource("/img/help.png")));
		GridBagConstraints gbc_help_label = new GridBagConstraints();
		gbc_help_label.insets = new Insets(5, 0, 5, 0);
		gbc_help_label.gridx = 1;
		gbc_help_label.gridy = 0;
		getContentPane().add(help_label, gbc_help_label);
		
		JPanel main_panel = new JPanel();
		main_panel.setBackground(new Color(204, 0, 0));
		GridBagConstraints gbc_main_panel = new GridBagConstraints();
		gbc_main_panel.insets = new Insets(0, 0, 0, 5);
		gbc_main_panel.fill = GridBagConstraints.BOTH;
		gbc_main_panel.gridx = 0;
		gbc_main_panel.gridy = 1;
		getContentPane().add(main_panel, gbc_main_panel);
		GridBagLayout gbl_main_panel = new GridBagLayout();
		gbl_main_panel.columnWidths = new int[] {440, 200};
		gbl_main_panel.rowHeights = new int[] {30, 80, 30, 30, 360};
		gbl_main_panel.columnWeights = new double[]{1.0, 1.0};
		gbl_main_panel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0};
		main_panel.setLayout(gbl_main_panel);
		
		JTextArea issueMessage_txtArea = new JTextArea();
		issueMessage_txtArea.setBackground(new Color(255, 255, 255));
		issueMessage_txtArea.setEnabled(false);
		issueMessage_txtArea.setForeground(new Color(255, 255, 255));
		issueMessage_txtArea.setMargin(new Insets(2, 4, 2, 4));
		issueMessage_txtArea.setLineWrap(true);
		issueMessage_txtArea.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		issueMessage_txtArea.setTabSize(4);
		GridBagConstraints gbc_issueMessage_txtArea = new GridBagConstraints();
		gbc_issueMessage_txtArea.gridheight = 3;
		gbc_issueMessage_txtArea.insets = new Insets(15, 15, 5, 10);
		gbc_issueMessage_txtArea.fill = GridBagConstraints.BOTH;
		gbc_issueMessage_txtArea.gridx = 0;
		gbc_issueMessage_txtArea.gridy = 0;
		main_panel.add(issueMessage_txtArea, gbc_issueMessage_txtArea);
		
		JLabel services_lbl = new JLabel("");
		services_lbl.setForeground(new Color(255, 255, 255));
		services_lbl.setBackground(new Color(255, 255, 255));
		services_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		services_lbl.setFont(new Font("Times New Roman", Font.BOLD, 13));
		GridBagConstraints gbc_services_lbl = new GridBagConstraints();
		gbc_services_lbl.gridheight = 2;
		gbc_services_lbl.insets = new Insets(15, 0, 5, 0);
		gbc_services_lbl.gridx = 1;
		gbc_services_lbl.gridy = 0;
		main_panel.add(services_lbl, gbc_services_lbl);
		
		JLabel type_label = new JLabel("");
		type_label.setForeground(new Color(255, 255, 255));
		type_label.setBackground(new Color(255, 255, 255));
		type_label.setHorizontalAlignment(SwingConstants.CENTER);
		type_label.setFont(new Font("Times New Roman", Font.BOLD, 13));
		GridBagConstraints gbc_type_label = new GridBagConstraints();
		gbc_type_label.insets = new Insets(0, 0, 5, 0);
		gbc_type_label.gridx = 1;
		gbc_type_label.gridy = 2;
		main_panel.add(type_label, gbc_type_label);
		
		JLabel reponsesTitle_lbl = new JLabel("Responses");
		reponsesTitle_lbl.setForeground(new Color(255, 255, 255));
		reponsesTitle_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		GridBagConstraints gbc_reponsesTitle_lbl = new GridBagConstraints();
		gbc_reponsesTitle_lbl.anchor = GridBagConstraints.WEST;
		gbc_reponsesTitle_lbl.insets = new Insets(0, 15, 5, 5);
		gbc_reponsesTitle_lbl.gridx = 0;
		gbc_reponsesTitle_lbl.gridy = 3;
		main_panel.add(reponsesTitle_lbl, gbc_reponsesTitle_lbl);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setMaximumSize(new Dimension(360, 320));
		
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.insets = new Insets(0, 50, 30, 10);
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 4;
		main_panel.add(tabbedPane, gbc_tabbedPane);
		
		ResponseSlot response = new ResponseSlot();
		tabbedPane.addTab(" 1 ", response);
		
		JPanel reponseOption_panel = new JPanel();
		reponseOption_panel.setBackground(new Color(204, 0, 0));
		FlowLayout fl_reponseOption_panel = (FlowLayout) reponseOption_panel.getLayout();
		fl_reponseOption_panel.setVgap(20);
		GridBagConstraints gbc_reponseOption_panel = new GridBagConstraints();
		gbc_reponseOption_panel.insets = new Insets(90, 0, 30, 0);
		gbc_reponseOption_panel.fill = GridBagConstraints.BOTH;
		gbc_reponseOption_panel.gridx = 1;
		gbc_reponseOption_panel.gridy = 4;
		main_panel.add(reponseOption_panel, gbc_reponseOption_panel);
		
		JButton newRepsonseBtn = new JButton("New");
		newRepsonseBtn.setPreferredSize(new Dimension(120, 30));
		newRepsonseBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		newRepsonseBtn.setBackground(new Color(0, 204, 0));
		newRepsonseBtn.setBorder(null);
		reponseOption_panel.add(newRepsonseBtn);
		
		JButton postResponseBtn = new JButton("Respond");
		postResponseBtn.setPreferredSize(new Dimension(120, 30));
		postResponseBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		postResponseBtn.setBackground(new Color(0, 204, 0));
		postResponseBtn.setBorder(null);
		reponseOption_panel.add(postResponseBtn);

		
		JPanel side_panel = new JPanel();
		side_panel.setBackground(new Color(204, 0, 0));
		GridBagConstraints gbc_side_panel = new GridBagConstraints();
		gbc_side_panel.fill = GridBagConstraints.BOTH;
		gbc_side_panel.gridx = 1;
		gbc_side_panel.gridy = 1;
		getContentPane().add(side_panel, gbc_side_panel);
		side_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
		
		JLabel issueID_lbl = new JLabel("");
		issueID_lbl.setForeground(new Color(255, 255, 255));
		issueID_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		issueID_lbl.setPreferredSize(new Dimension(130, 25));
		issueID_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		side_panel.add(issueID_lbl);
		
		JLabel issuedAt_lbl = new JLabel("");
		issuedAt_lbl.setForeground(new Color(255, 255, 255));
		side_panel.add(issuedAt_lbl);
		issuedAt_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		issuedAt_lbl.setPreferredSize(new Dimension(130, 25));
		issuedAt_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		
		JSeparator separator = new JSeparator();
		separator.setPreferredSize(new Dimension(110, 10));
		side_panel.add(separator);
		
		JLabel student_lbl = new JLabel("Student");
		student_lbl.setForeground(new Color(255, 255, 255));
		student_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		student_lbl.setPreferredSize(new Dimension(130, 25));
		student_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		side_panel.add(student_lbl);
		
		JLabel studentID_lbl = new JLabel("");
		studentID_lbl.setForeground(new Color(255, 255, 255));
		studentID_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		studentID_lbl.setPreferredSize(new Dimension(130, 25));
		studentID_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		side_panel.add(studentID_lbl);
		
		JLabel studentName_lbl = new JLabel("");
		studentName_lbl.setForeground(new Color(255, 255, 255));
		studentName_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		studentName_lbl.setPreferredSize(new Dimension(130, 25));
		studentName_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		side_panel.add(studentName_lbl);
		
		JLabel email_lbl = new JLabel("");
		email_lbl.setForeground(new Color(255, 255, 255));
		email_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		email_lbl.setPreferredSize(new Dimension(130, 25));
		email_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		side_panel.add(email_lbl);
		
		JLabel contactNo_lbl = new JLabel("");
		contactNo_lbl.setForeground(new Color(255, 255, 255));
		contactNo_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		contactNo_lbl.setPreferredSize(new Dimension(130, 25));
		contactNo_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		side_panel.add(contactNo_lbl);
		
		JSeparator separator1 = new JSeparator();
		separator1.setPreferredSize(new Dimension(110, 10));
		side_panel.add(separator1);
		
		JLabel representative_lbl = new JLabel("Representative");
		representative_lbl.setForeground(new Color(255, 255, 255));
		representative_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		representative_lbl.setPreferredSize(new Dimension(130, 25));
		representative_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		side_panel.add(representative_lbl);
		
		JLabel representativeName_lbl = new JLabel("");
		representativeName_lbl.setForeground(new Color(255, 255, 255));
		representativeName_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		representativeName_lbl.setPreferredSize(new Dimension(130, 25));
		representativeName_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		side_panel.add(representativeName_lbl);
		
		JSeparator separator2 = new JSeparator();
		separator2.setPreferredSize(new Dimension(110, 30));
		side_panel.add(separator2);
		
		JButton returnBtn = new JButton("Return");
		returnBtn.setPreferredSize(new Dimension(100, 35));
		returnBtn.setIcon(new ImageIcon(StaffIssueResponse.class.getResource("/img/return.png")));
		returnBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		returnBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		returnBtn.setBorder(null);
		returnBtn.setBackground(new Color(0, 255, 0));
		side_panel.add(returnBtn);
		setBorder(new LineBorder(new Color(0, 0, 51), 10));
		setBounds(100, 100, 820, 570);
		
		setVisible(true);
	}
	
	private void registerListeners(){}

}
