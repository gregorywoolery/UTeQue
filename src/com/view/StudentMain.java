package com.view;

import java.awt.GridBagConstraints;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Color;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Component;
import java.awt.Image;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

import com.github.lgooddatepicker.components.DatePicker;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


public class StudentMain extends JInternalFrame implements ActionListener{
	private JPanel addIssue_panel;
	private JPanel updateIssue_panel;
	private JPanel IssueDisplay_panel;
	private JPanel studentIssue_panel;
	private JLabel addIssueTitle_lbl;
	private JComboBox addIssue_comboBox;
	private JLabel addedDate_lbl;
	private JButton addBtn;
	private JButton liveChatBtn;
	private JPanel userIssueStats_panel;
	private JLabel updateIssueTitle_lbl;
	private JLabel issueMadeTitle_lbl;
	private JLabel issueMade_lbl;
	private JLabel issueCmpltTitle_lbl;
	private JLabel issueCompleted_lbl;
	private JSeparator separator;
	private JSeparator separator_1;
	private JLabel issuePendTitle_lbl;
	private JLabel issuePending_lbl;
	private JPanel issue_panel;
	private JTable issueTable;
	private JLabel tableTitle_lbl;
	private JPanel search_panel;
	private JLabel searchFor_lbl;
	private JLabel mainTag_lbl;
	private JTextField mainTagSearch_textField;
	private JComboBox searchIssueType_comboBox;
	private JButton searchIcon_lbl;
	private JButton removeBtn;
	private JComboBox upadateIssue_comboBox;
	private JButton updateBtn;
	private JLabel dateMadeUpdate_lbl;
	private JPanel date_panel;
	private DatePicker updateDatePicker;
	private JDesktopPane workSpaceDesktop;
	private String currDate;
	
	/**
	 * Create the frame.
	 */

	public StudentMain(JDesktopPane workSpaceDesktop) {
		super("Main",
				false, 	//resizable
				true, 	//closable
				false, 	//maximizable
				true);	//iconifiable
		initializeComponents();
		registerListeners();
		this.workSpaceDesktop = workSpaceDesktop;
	}
	
	private void initializeComponents() {
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		
		this.setVisible(true);
		this.setSize(730, 550);
		getContentPane().setBackground(new Color(0, 0, 51));
		setBorder(new LineBorder(new Color(0, 0, 51), 20));
		setBounds(100, 100, 750, 570);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{238, 238, 238, 0};
		gridBagLayout.rowHeights = new int[] {50, 160, 340, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
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
		getContentPane().add(studentIssue_panel, gbc_studentIssue_panel);
		
		liveChatBtn = new JButton("LIVE CHAT");
		liveChatBtn.setToolTipText("Start a Live Chat.");
		liveChatBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		liveChatBtn.setBackground(new Color(0, 0, 51));
		liveChatBtn.setForeground(new Color(255, 255, 255));
		liveChatBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		liveChatBtn.setPreferredSize(new Dimension(100, 30));
		studentIssue_panel.add(liveChatBtn);
		liveChatBtn.setBorder(null);
		
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
		
		getContentPane().add(addIssue_panel, gbc_addIssue_panel);
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
		addIssue_comboBox.setToolTipText("Select issue type here");
		addIssue_comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addIssue_comboBox.setForeground(new Color(255, 255, 255));
		addIssue_comboBox.setBorder(null);
		addIssue_comboBox.setBackground(new Color(0, 0, 51));
		addIssue_comboBox.setMaximumSize(new Dimension(100, 25));
		addIssue_comboBox.setModel(new DefaultComboBoxModel(new String[] {"Complaint", "Query"}));
		addIssue_comboBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		addIssue_panel.add(addIssue_comboBox);
		
		
		LocalDate date = LocalDate.now(); // Gets the current date
		DateTimeFormatter currentDateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		currDate = date.format(currentDateFormat);
		
		addedDate_lbl = new JLabel(currDate);
		addedDate_lbl.setForeground(new Color(0, 0, 0));
		addedDate_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		addedDate_lbl.setMaximumSize(new Dimension(100, 55));
		addedDate_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		addedDate_lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		addIssue_panel.add(addedDate_lbl);
		
		
		addBtn = new JButton("ADD");
		addBtn.setToolTipText("Add your issues.");
		addBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		getContentPane().add(updateIssue_panel, gbc_updateIssue_panel);
		
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
		upadateIssue_comboBox.setToolTipText("Select issue type here");
		upadateIssue_comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		upadateIssue_comboBox.setModel(new DefaultComboBoxModel(new String[] {"Complaint", "Query"}));
		upadateIssue_comboBox.setMaximumSize(new Dimension(100, 25));
		upadateIssue_comboBox.setForeground(Color.WHITE);
		upadateIssue_comboBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		upadateIssue_comboBox.setBorder(null);
		upadateIssue_comboBox.setBackground(new Color(0, 0, 51));
		updateIssue_panel.add(upadateIssue_comboBox);
		
		dateMadeUpdate_lbl = new JLabel("Date Made:");
		dateMadeUpdate_lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		updateIssue_panel.add(dateMadeUpdate_lbl);
		dateMadeUpdate_lbl.setMaximumSize(new Dimension(75, 22));
		dateMadeUpdate_lbl.setForeground(new Color(0, 0, 51));
		dateMadeUpdate_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		
		date_panel = new JPanel();
		date_panel.setBackground(new Color(255, 255, 0));
		date_panel.setMaximumSize(new Dimension(300, 33));
		updateIssue_panel.add(date_panel);
		
		updateDatePicker = new DatePicker();
		updateDatePicker.getComponentToggleCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		updateDatePicker.getComponentDateTextField().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		updateDatePicker.setBackground(new Color(255, 255, 0));
		date_panel.add(updateDatePicker);

		
		updateBtn = new JButton("UPDATE");

		updateBtn.setToolTipText("Update a previous issue");
		updateBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		getContentPane().add(IssueDisplay_panel, gbc_IssueDisplay_panel);
		GridBagLayout gbl_IssueDisplay_panel = new GridBagLayout();
		gbl_IssueDisplay_panel.columnWidths = new int[]{0, 0};
		gbl_IssueDisplay_panel.rowHeights = new int[] {50, 290, 0};
		gbl_IssueDisplay_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_IssueDisplay_panel.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		IssueDisplay_panel.setLayout(gbl_IssueDisplay_panel);
		
		issue_panel = new JPanel();
		issue_panel.setBackground(new Color(255, 255, 0));
		FlowLayout fl_issue_panel = (FlowLayout) issue_panel.getLayout();
		fl_issue_panel.setHgap(13);
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
		searchIssueType_comboBox.setToolTipText("Select issue type here");
		searchIssueType_comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		searchIssueType_comboBox.setModel(new DefaultComboBoxModel(new String[] {"Complaint", "Query"}));
		searchIssueType_comboBox.setPreferredSize(new Dimension(100, 25));
		searchIssueType_comboBox.setForeground(new Color(0, 0, 51));
		searchIssueType_comboBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		searchIssueType_comboBox.setBorder(null);
		searchIssueType_comboBox.setBackground(new Color(255, 255, 0));
		search_panel.add(searchIssueType_comboBox);
		
		mainTag_lbl = new JLabel("Main Tag:");
		mainTag_lbl.setForeground(new Color(0, 0, 51));
		mainTag_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		search_panel.add(mainTag_lbl);
		
		mainTagSearch_textField = new JTextField();
		mainTagSearch_textField.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mainTagSearch_textField.setForeground(new Color(0, 0, 51));
		mainTagSearch_textField.setMargin(new Insets(2, 0, 2, 0));
		mainTagSearch_textField.setPreferredSize(new Dimension(10, 25));
		mainTagSearch_textField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		search_panel.add(mainTagSearch_textField);
		mainTagSearch_textField.setColumns(13);
		
		/*	Using external LGoodDatePicker
		 *  Create a date picker with some custom settings. 
		 */
	    DatePicker searchDatePicker = new DatePicker();
	    searchDatePicker.getComponentToggleCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    searchDatePicker.getComponentDateTextField().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    searchDatePicker.setBackground(new Color(255, 255, 0));
		search_panel.add(searchDatePicker);
		
		//Resize Search icon
		ImageIcon searchImageIcon = new ImageIcon(new ImageIcon(Dashboard.class.getResource("/img/search.png"))
				.getImage().getScaledInstance(23, 23, Image.SCALE_DEFAULT));
		
		searchIcon_lbl = new JButton(searchImageIcon);
		searchIcon_lbl.setToolTipText("Search for issue");
		searchIcon_lbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		searchIcon_lbl.setBorder(null);
		searchIcon_lbl.setBackground(new Color(255, 255, 0));
		search_panel.add(searchIcon_lbl);
		
		removeBtn = new JButton(new ImageIcon(Dashboard.class.getResource("/img/delete.png")));
		removeBtn.setToolTipText("Remove selected issue.");
		removeBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		removeBtn.setBackground(new Color(255, 255, 0));
		removeBtn.setBorder(null);
		search_panel.add(removeBtn);
		
		
		issueTable = new JTable();
		issueTable.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		issueTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"TYPE", "MAIN DETAILS", "DATE ISSUED", "STATUS", "AGENT"
			}
		));
		
		//Changes table heaver font
		JTableHeader tableHeader = issueTable.getTableHeader();
		tableHeader.setBackground(new Color(0, 0, 51));
		tableHeader.setForeground(Color.white);
		tableHeader.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		issueTable.getColumnModel().getColumn(0).setResizable(false);
		issueTable.getColumnModel().getColumn(0).setPreferredWidth(85);
		issueTable.getColumnModel().getColumn(1).setPreferredWidth(156);
		issueTable.getColumnModel().getColumn(2).setPreferredWidth(85);
		issueTable.getColumnModel().getColumn(3).setPreferredWidth(50);
		issueTable.getColumnModel().getColumn(4).setPreferredWidth(135);
		issueTable.setGridColor(new Color(0, 0, 51));
		issueTable.setBackground(new Color(0,204, 225));
		issueTable.setEnabled(false);
		
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 1;
		IssueDisplay_panel.add(new JScrollPane(issueTable), gbc_table);
	}
		
		
	public void registerListeners() {
		addBtn.addActionListener(this);
		updateBtn.addActionListener(this);
		addIssue_comboBox.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addBtn) {
			dispose();
			JInternalFrame currFrame = new AddIssue(workSpaceDesktop, upadateIssue_comboBox.getSelectedIndex());
			workSpaceDesktop.add(currFrame);
			
			//Opens JinternalFrame centered in the JDesktopPane
			Dimension desktopSize = workSpaceDesktop.getSize();
			Dimension jInternalFrameSize = currFrame.getSize();
			
			//Test if current internal frame is of class AddIssue and renders the frame with that
			if(currFrame.getClass() == AddIssue.class){
				currFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/500,
				    (desktopSize.height- jInternalFrameSize.height)/70);
			}
			
		}
	
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}

}
