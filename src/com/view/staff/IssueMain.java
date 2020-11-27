package com.view.staff;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.Insets;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.controller.ServiceController;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.SwingConstants;

@SuppressWarnings("rawtypes")
public class IssueMain extends JInternalFrame implements ActionListener{

	private static final long serialVersionUID = 4829847214829989376L;

	private JTextField studentSearchID_txtField;
	private JTable studentIssues_table;
	private JTextField studentID_txtField;
	private JTextField studentName_textField;
	private JTextField studentEmail_textField;
	private JTextField studentContact_txtField;
	private JPanel titleBanner_panel;
	private JLabel studentIssuesTitle_lbl;
	private JComboBox services_comboBox;
	private JSplitPane main_splitPane; 
	private JSplitPane studentOpitions_splitPane;
	private JPanel studentInfo_panel;
	private JLabel studentID_lbl;
	private JLabel studentName_lbl;
	private JLabel studentEmail_lbl;
	private JLabel studentContact_lbl;
	private JLabel studentGender_lbl;
	private JLabel getStudntGender_lbl;
	private JPanel issueOptions_panel;
	private JPanel assignRep_Panel;
	private JLabel assignRepTitle_lbl;
	private JComboBox selectRep_comboBox;
	private JButton assignRepBtn;
	private JButton respondBtn;
	private JButton moreBtn;
	@SuppressWarnings("unused")
	private JDesktopPane workSpaceDesktop;
	private JButton searchBtn;
	
	
	public IssueMain(JDesktopPane workSpaceDesktop) throws ParseException {
		super("Add Issue", 
				false, 	//resizable
				true, 	//closable
				false, 	//maximizable
				true);	//iconifiable
		initializeComponents();
		registerListeners();
		this.workSpaceDesktop =  workSpaceDesktop;
	}
	
	/**
	 * Create the frame.
	 */
	private void initializeComponents() {
		//Removes top bar from internal frame
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		
		setBorder(new LineBorder(new Color(0, 0, 51), 20));
		setBounds(100, 100, 820, 570);
		getContentPane().setBackground(new Color(0, 0, 51));
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 40, 15));
		
		titleBanner_panel = new JPanel();
		FlowLayout fl_titleBanner_panel = (FlowLayout) titleBanner_panel.getLayout();
		fl_titleBanner_panel.setVgap(10);
		titleBanner_panel.setPreferredSize(new Dimension(550, 50));
		getContentPane().add(titleBanner_panel);
		
		studentIssuesTitle_lbl = new JLabel("Student Issues");
		studentIssuesTitle_lbl.setForeground(new Color(0, 0, 51));
		studentIssuesTitle_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		titleBanner_panel.add(studentIssuesTitle_lbl);
		
		//List of Services JComboBox
		ArrayList<String> serviceTypes = ServiceController.getAllServies();

		services_comboBox = new JComboBox(serviceTypes.toArray());
		services_comboBox.setBackground(new Color(255, 255, 0));
		services_comboBox.setForeground(new Color(0, 0, 102));
		services_comboBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		services_comboBox.setPreferredSize(new Dimension(230, 30));
		getContentPane().add(services_comboBox);
		
		studentSearchID_txtField = new JTextField();
		studentSearchID_txtField.setCaretColor(new Color(255, 255, 255));
		studentSearchID_txtField.setMargin(new Insets(2, 4, 2, 2));
		studentSearchID_txtField.setForeground(new Color(255, 255, 255));
		studentSearchID_txtField.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		studentSearchID_txtField.setBackground(new Color(0, 0, 51));
		studentSearchID_txtField.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255)),
				"Student ID", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		studentSearchID_txtField.setPreferredSize(new Dimension(200, 45));
		getContentPane().add(studentSearchID_txtField);
		studentSearchID_txtField.setColumns(15);
		
		searchBtn = new JButton("SEARCH");
		searchBtn.setPreferredSize(new Dimension(100, 30));
		searchBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		searchBtn.setBorder(null);
		searchBtn.setBackground(new Color(102, 204, 0));
		getContentPane().add(searchBtn);
		
		main_splitPane = new JSplitPane();
		main_splitPane.setDividerSize(2);
		main_splitPane.setPreferredSize(new Dimension(770, 350));
		getContentPane().add(main_splitPane);
		
		studentIssues_table = new JTable();
		studentIssues_table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Issue ID", "Type", "Service", "Issued At", "Rep ID", "Assigned On"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		studentIssues_table.getColumnModel().getColumn(0).setResizable(false);
		studentIssues_table.getColumnModel().getColumn(0).setPreferredWidth(95);
		studentIssues_table.getColumnModel().getColumn(1).setResizable(false);
		studentIssues_table.getColumnModel().getColumn(1).setPreferredWidth(80);
		studentIssues_table.getColumnModel().getColumn(2).setResizable(false);
		studentIssues_table.getColumnModel().getColumn(2).setPreferredWidth(120);
		studentIssues_table.getColumnModel().getColumn(3).setResizable(false);
		studentIssues_table.getColumnModel().getColumn(3).setPreferredWidth(90);
		studentIssues_table.getColumnModel().getColumn(4).setPreferredWidth(95);
		studentIssues_table.getColumnModel().getColumn(5).setPreferredWidth(96);
		
		JScrollPane scrollPane = new JScrollPane(studentIssues_table);
		scrollPane.setPreferredSize(new Dimension(500, 402));
		main_splitPane.setLeftComponent(scrollPane);
		
		studentOpitions_splitPane = new JSplitPane();
		studentOpitions_splitPane.setPreferredSize(new Dimension(179, 200));
		studentOpitions_splitPane.setDividerSize(2);
		studentOpitions_splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		main_splitPane.setRightComponent(studentOpitions_splitPane);
		
		studentInfo_panel = new JPanel();
		studentInfo_panel.setPreferredSize(new Dimension(50, 200));
		studentInfo_panel.setMaximumSize(new Dimension(270, 32767));
		studentOpitions_splitPane.setLeftComponent(studentInfo_panel);
		GridBagLayout gbl_studentInfo_panel = new GridBagLayout();
		gbl_studentInfo_panel.columnWidths = new int[]{70, 186, 0};
		gbl_studentInfo_panel.rowHeights = new int[]{30, 30, 30, 30, 0, 0};
		gbl_studentInfo_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_studentInfo_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		studentInfo_panel.setLayout(gbl_studentInfo_panel);
		
		studentID_lbl = new JLabel("Student ID: ");
		studentID_lbl.setPreferredSize(new Dimension(70, 30));
		studentID_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		GridBagConstraints gbc_studentID_lbl = new GridBagConstraints();
		gbc_studentID_lbl.anchor = GridBagConstraints.NORTHWEST;
		gbc_studentID_lbl.insets = new Insets(7, 0, 5, 5);
		gbc_studentID_lbl.gridx = 0;
		gbc_studentID_lbl.gridy = 0;
		studentInfo_panel.add(studentID_lbl, gbc_studentID_lbl);
		
		studentID_txtField = new JTextField();
		studentID_txtField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		studentID_txtField.setColumns(20);
		GridBagConstraints gbc_studentID_txtField = new GridBagConstraints();
		gbc_studentID_txtField.anchor = GridBagConstraints.WEST;
		gbc_studentID_txtField.insets = new Insets(7, 0, 5, 0);
		gbc_studentID_txtField.gridx = 1;
		gbc_studentID_txtField.gridy = 0;
		studentInfo_panel.add(studentID_txtField, gbc_studentID_txtField);
		
		studentName_lbl = new JLabel("Name: ");
		studentName_lbl.setPreferredSize(new Dimension(70, 30));
		studentName_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		GridBagConstraints gbc_studentName_lbl = new GridBagConstraints();
		gbc_studentName_lbl.anchor = GridBagConstraints.NORTHWEST;
		gbc_studentName_lbl.insets = new Insets(0, 0, 5, 5);
		gbc_studentName_lbl.gridx = 0;
		gbc_studentName_lbl.gridy = 1;
		studentInfo_panel.add(studentName_lbl, gbc_studentName_lbl);
		
		studentName_textField = new JTextField();
		studentName_textField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		studentName_textField.setColumns(20);
		GridBagConstraints gbc_studentName_textField = new GridBagConstraints();
		gbc_studentName_textField.anchor = GridBagConstraints.WEST;
		gbc_studentName_textField.insets = new Insets(0, 0, 5, 0);
		gbc_studentName_textField.gridx = 1;
		gbc_studentName_textField.gridy = 1;
		studentInfo_panel.add(studentName_textField, gbc_studentName_textField);
		
		studentEmail_lbl = new JLabel("Email: ");
		studentEmail_lbl.setPreferredSize(new Dimension(70, 30));
		studentEmail_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		GridBagConstraints gbc_studentEmail_lbl = new GridBagConstraints();
		gbc_studentEmail_lbl.anchor = GridBagConstraints.NORTHWEST;
		gbc_studentEmail_lbl.insets = new Insets(0, 0, 5, 5);
		gbc_studentEmail_lbl.gridx = 0;
		gbc_studentEmail_lbl.gridy = 2;
		studentInfo_panel.add(studentEmail_lbl, gbc_studentEmail_lbl);
		
		studentEmail_textField = new JTextField();
		studentEmail_textField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		studentEmail_textField.setColumns(20);
		GridBagConstraints gbc_studentEmail_textField = new GridBagConstraints();
		gbc_studentEmail_textField.anchor = GridBagConstraints.WEST;
		gbc_studentEmail_textField.insets = new Insets(0, 0, 5, 0);
		gbc_studentEmail_textField.gridx = 1;
		gbc_studentEmail_textField.gridy = 2;
		studentInfo_panel.add(studentEmail_textField, gbc_studentEmail_textField);
		
		studentContact_lbl = new JLabel("Contact");
		studentContact_lbl.setPreferredSize(new Dimension(70, 30));
		studentContact_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		GridBagConstraints gbc_studentContact_lbl = new GridBagConstraints();
		gbc_studentContact_lbl.anchor = GridBagConstraints.NORTHWEST;
		gbc_studentContact_lbl.insets = new Insets(0, 0, 5, 5);
		gbc_studentContact_lbl.gridx = 0;
		gbc_studentContact_lbl.gridy = 3;
		studentInfo_panel.add(studentContact_lbl, gbc_studentContact_lbl);
		
		studentContact_txtField = new JTextField();
		studentContact_txtField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		studentContact_txtField.setColumns(20);
		GridBagConstraints gbc_studentContact_txtField = new GridBagConstraints();
		gbc_studentContact_txtField.insets = new Insets(0, 0, 5, 0);
		gbc_studentContact_txtField.anchor = GridBagConstraints.WEST;
		gbc_studentContact_txtField.gridx = 1;
		gbc_studentContact_txtField.gridy = 3;
		studentInfo_panel.add(studentContact_txtField, gbc_studentContact_txtField);
		
		studentGender_lbl = new JLabel("Gender");
		studentGender_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		GridBagConstraints gbc_studentGender_lbl = new GridBagConstraints();
		gbc_studentGender_lbl.anchor = GridBagConstraints.WEST;
		gbc_studentGender_lbl.insets = new Insets(0, 0, 0, 5);
		gbc_studentGender_lbl.gridx = 0;
		gbc_studentGender_lbl.gridy = 4;
		studentInfo_panel.add(studentGender_lbl, gbc_studentGender_lbl);
		
		getStudntGender_lbl = new JLabel();
		getStudntGender_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		GridBagConstraints gbc_getStudntGender_lbl = new GridBagConstraints();
		gbc_getStudntGender_lbl.anchor = GridBagConstraints.WEST;
		gbc_getStudntGender_lbl.gridx = 1;
		gbc_getStudntGender_lbl.gridy = 4;
		studentInfo_panel.add(getStudntGender_lbl, gbc_getStudntGender_lbl);
		
		issueOptions_panel = new JPanel();
		studentOpitions_splitPane.setRightComponent(issueOptions_panel);
		
		respondBtn = new JButton("Respond");
		respondBtn.setPreferredSize(new Dimension(120, 35));
		respondBtn.setForeground(new Color(0, 0, 51));
		respondBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		respondBtn.setBackground(new Color(0, 204, 0));
		respondBtn.setBorder(null);
		
		
		assignRep_Panel = new JPanel();
		assignRep_Panel.setPreferredSize(new Dimension(250, 100));
		
		
		assignRepTitle_lbl = new JLabel("Assign Rep");
		assignRepTitle_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		assignRepTitle_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		assignRepTitle_lbl.setPreferredSize(new Dimension(100, 15));
		assignRep_Panel.add(assignRepTitle_lbl);
		
		selectRep_comboBox = new JComboBox();
		selectRep_comboBox.setForeground(new Color(255, 255, 255));
		selectRep_comboBox.setBackground(new Color(0, 0, 51));
		selectRep_comboBox.setPreferredSize(new Dimension(200, 30));
		selectRep_comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		assignRep_Panel.add(selectRep_comboBox);
		
		assignRepBtn = new JButton("Assign");
		assignRepBtn.setBackground(new Color(51, 204, 0));
		assignRepBtn.setPreferredSize(new Dimension(100, 25));
		assignRepBtn.setBorder(null);
		assignRepBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		assignRep_Panel.add(assignRepBtn);
		
		moreBtn = new JButton("More+");
		moreBtn.setForeground(new Color(255, 255, 255));
		moreBtn.setBackground(new Color(0, 0, 51));
		moreBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		moreBtn.setPreferredSize(new Dimension(100, 25));
		moreBtn.setBorder(null);
		
		assaignOptionDisplay();
		
		setVisible(true);
	}

	private void registerListeners() {
		searchBtn.addActionListener(this);
		respondBtn.addActionListener(this);
		assignRepBtn.addActionListener(this);
		moreBtn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(searchBtn)) {
			if(studentSearchID_txtField.getText() != "") {
				
			}
		}
		
	}
	
	private void assaignOptionDisplay() {
		String repID = "00";
		String loggedUser = "Current Logged in user";
		if(repID != "Not Assaignd" && loggedUser == "Rep") {
			issueOptions_panel.add(respondBtn);
		}else {
			if(loggedUser == "Agent") {
				issueOptions_panel.add(assignRep_Panel);
			}
			issueOptions_panel.add(moreBtn);
		}
	}

}
