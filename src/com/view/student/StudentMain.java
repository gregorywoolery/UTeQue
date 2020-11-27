package com.view.student;

import java.awt.GridBagConstraints;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Color;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Component;
import java.awt.Image;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;

import com.controller.IssueController;
import com.controller.ServiceController;
import com.controller.UserController;
import com.github.lgooddatepicker.components.DatePicker;
import com.model.Issue;
import com.model.User;
import com.view.Dashboard;
import com.view.UserLogin;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.border.TitledBorder;

@SuppressWarnings("rawtypes")
public class StudentMain extends JInternalFrame implements ActionListener{

	private static final long serialVersionUID = -8375563652031458336L;

	private JPanel addIssue_panel;
	private JPanel updateIssue_panel;
	private JPanel IssueDisplay_panel;
	private JPanel studentIssue_panel;
	private JLabel addIssueTitle_lbl;
	private JComboBox<String> addIssue_comboBox;
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
	private JTextField searchID_txtfield;
	private JComboBox service_combobox;
	private JComboBox searchIssueType_comboBox;
	private JButton searchBtn;
	private JButton removeBtn;
	private JComboBox updateIssue_comboBox;
	private JComboBox updateService_comboBox;
	private JButton updateBtn;
	private JLabel dateMadeUpdate_lbl;
	private JPanel date_panel;
	private DatePicker updateDatePicker;
	private JDesktopPane workspace_desktopPane;
	private String currDate;
	private ArrayList<String> serviceTypes;
	private String issueID=null;
	
	private User student;
	
	/**
	 * Create the frame.
	 */

	public StudentMain(JDesktopPane workspace_desktopPane) {
		super("Main",
				false, 	//resizable
				true, 	//closable
				false, 	//maximizable
				true);	//iconifiable
		initializeComponents();
		registerListeners();
		this.workspace_desktopPane = workspace_desktopPane;
	}
	
	private void initializeComponents() {
		student =  UserController.getCurrentUser();
		
		//Removes top bar from internal frame
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		
		getContentPane().setBackground(new Color(0, 0, 51));
		setBorder(new LineBorder(new Color(0, 0, 51), 10));
		setBounds(100, 100, 820, 570);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {270, 276, 265, 0};
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
		liveChatBtn.setBorder(null);
		studentIssue_panel.add(liveChatBtn);

		
		userIssueStats_panel = new JPanel();
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
		
		getIssueStats();
		
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
		
		String issueType []={"Exclude", "Complaint", "Query"};  
		addIssue_comboBox = new JComboBox(issueType);
		addIssue_comboBox.setToolTipText("Select issue type here");
		addIssue_comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addIssue_comboBox.setForeground(new Color(255, 255, 255));
		addIssue_comboBox.setBorder(null);
		addIssue_comboBox.setBackground(new Color(0, 0, 51));
		addIssue_comboBox.setMaximumSize(new Dimension(100, 25));
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
		addBtn.setBorder(null);
		addBtn.setForeground(new Color(255, 255, 255));
		addBtn.setBackground(new Color(0, 153, 255));
		addBtn.setMaximumSize(new Dimension(100, 30));
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
		
		 
		updateIssue_comboBox  = new JComboBox(issueType);
		updateIssue_comboBox.setToolTipText("Select issue type here");
		updateIssue_comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		updateIssue_comboBox.setMaximumSize(new Dimension(100, 25));
		updateIssue_comboBox.setForeground(Color.WHITE);
		updateIssue_comboBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		updateIssue_comboBox.setBorder(null);
		updateIssue_comboBox.setBackground(new Color(0, 0, 51));
		updateIssue_panel.add(updateIssue_comboBox);
		
		serviceTypes = ServiceController.getAllServies();
		updateService_comboBox = new JComboBox(serviceTypes.toArray());
		
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
		updateBtn.setBorder(null);
		updateBtn.setMaximumSize(new Dimension(100, 30));
		updateBtn.setForeground(Color.WHITE);
		updateBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		updateBtn.setBackground(new Color(0, 153, 255));
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
		gbl_IssueDisplay_panel.rowHeights = new int[] {80, 260, 0};
		gbl_IssueDisplay_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_IssueDisplay_panel.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		IssueDisplay_panel.setLayout(gbl_IssueDisplay_panel);
		
		issue_panel = new JPanel();
		issue_panel.setBackground(new Color(255, 255, 0));
		FlowLayout fl_issue_panel = (FlowLayout) issue_panel.getLayout();
		fl_issue_panel.setVgap(0);
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
		tableTitle_lbl.setPreferredSize(new Dimension(65, 25));
		tableTitle_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		issue_panel.add(tableTitle_lbl);
		
		search_panel = new JPanel();
		search_panel.setBackground(new Color(255, 255, 0));
		FlowLayout fl_search_panel = (FlowLayout) search_panel.getLayout();
		fl_search_panel.setAlignment(FlowLayout.LEFT);
		fl_search_panel.setVgap(0);
		fl_search_panel.setHgap(25);
		search_panel.setPreferredSize(new Dimension(770, 40));
		issue_panel.add(search_panel);
		
		searchID_txtfield = new JTextField("");
		searchID_txtfield.setBorder(new TitledBorder(
				new LineBorder(new Color(0, 0, 51), 2), 
								"Issue ID", 
								TitledBorder.LEADING, 
								TitledBorder.TOP, null, null));
		searchID_txtfield.setPreferredSize(new Dimension(110, 40));
		search_panel.add(searchID_txtfield);
		searchID_txtfield.setForeground(new Color(0, 0, 51));
		searchID_txtfield.setBackground(new Color(255, 255, 0));
		searchID_txtfield.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		
		searchIssueType_comboBox = new JComboBox(issueType);
		searchIssueType_comboBox.setToolTipText("Select issue type here");
		searchIssueType_comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		searchIssueType_comboBox.setPreferredSize(new Dimension(100, 25));
		searchIssueType_comboBox.setForeground(new Color(0, 0, 51));
		searchIssueType_comboBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		searchIssueType_comboBox.setBorder(null);
		searchIssueType_comboBox.setBackground(new Color(255, 255, 0));
		search_panel.add(searchIssueType_comboBox);
		
		
		serviceTypes = ServiceController.getAllServies();
		service_combobox = new JComboBox(serviceTypes.toArray());
		service_combobox.setBackground(new Color(0, 0, 51));
		service_combobox.setBorder(null);
		service_combobox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		service_combobox.setForeground(new Color(255, 255, 255));
		service_combobox.setPreferredSize(new Dimension(160, 30));
		service_combobox.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		search_panel.add(service_combobox);
		
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
		
		searchBtn = new JButton(searchImageIcon);
		searchBtn.setToolTipText("Search for issue");
		searchBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		searchBtn.setBorder(null);
		searchBtn.setBackground(new Color(255, 255, 0));
		search_panel.add(searchBtn);
		
		removeBtn = new JButton(new ImageIcon(Dashboard.class.getResource("/img/delete.png")));
		removeBtn.setToolTipText("Remove selected issue.");
		removeBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		removeBtn.setBackground(new Color(255, 255, 0));
		removeBtn.setBorder(null);
		search_panel.add(removeBtn);
		
		
		issueTable = new JTable();
		issueTable.setForeground(new Color(0, 0, 0));
		issueTable.setRowHeight(25);
		issueTable.setSelectionBackground(new Color(255, 204, 102));
		issueTable.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		issueTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"ISSUE ID", "TYPE", "SERVICE", "LAST RESPONSE", "STATUS", "AGENT"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		issueTable.getColumnModel().getColumn(0).setResizable(false);
		issueTable.getColumnModel().getColumn(0).setPreferredWidth(85);
		issueTable.getColumnModel().getColumn(1).setResizable(false);
		issueTable.getColumnModel().getColumn(1).setPreferredWidth(85);
		issueTable.getColumnModel().getColumn(2).setResizable(false);
		issueTable.getColumnModel().getColumn(2).setPreferredWidth(100);
		issueTable.getColumnModel().getColumn(3).setResizable(false);
		issueTable.getColumnModel().getColumn(3).setPreferredWidth(95);
		issueTable.getColumnModel().getColumn(4).setResizable(false);
		issueTable.getColumnModel().getColumn(4).setPreferredWidth(92);
		issueTable.getColumnModel().getColumn(5).setResizable(false);
		issueTable.getColumnModel().getColumn(5).setPreferredWidth(122);
		
		updateIssueTable();
		
		
		//Changes table heaver font
		JTableHeader tableHeader = issueTable.getTableHeader();
		tableHeader.setBackground(new Color(0, 0, 51));
		tableHeader.setForeground(Color.white);
		tableHeader.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		issueTable.setGridColor(new Color(0, 0, 51));
		issueTable.setBackground(Color.WHITE);
		issueTable.setEnabled(true);
		
		issueTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		issueTable.setRowSelectionAllowed(true);
		issueTable.setColumnSelectionAllowed(false);
		
		issueTable.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent mouseEvent) {
		        JTable table =(JTable) mouseEvent.getSource();
		        Point point = mouseEvent.getPoint();
		        int column= 0;
		        int row = table.rowAtPoint(point);
		        
		        if(mouseEvent.getClickCount() == 1 && table.getSelectedRow() != -1) {
	        		int selRow = table.getSelectedRow();
	        		issueID = table.getModel().getValueAt(selRow, column).toString();
		        }
		        
		        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
		        	int opt = JOptionPane.showConfirmDialog(workspace_desktopPane, 
							"View Responses to this ISSUE ? ", 
							"Responses",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.INFORMATION_MESSAGE);
		        	if(opt == 0) {
		        		int selRow = table.getSelectedRow();
		        		issueID = table.getModel().getValueAt(selRow, column).toString();
		        		addStudentIssueResponse(issueID);
		        	}

		        }
		    }
		});
		
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 1;
		IssueDisplay_panel.add(new JScrollPane(issueTable), gbc_table);
		
		setVisible(true);
	}
		
		
	public void registerListeners() {
		liveChatBtn.addActionListener(this);
		addBtn.addActionListener(this);
		updateBtn.addActionListener(this);
		addIssue_comboBox.addActionListener(this);
		searchBtn.addActionListener(this);
		removeBtn.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(addBtn)) {
			/**
			 * Dispose of current internal frame. Add new internal 
			 * frame to workspace desktop pane.
			 */
			dispose();
			
			JInternalFrame currFrame = null;
			try {
				currFrame = new AddIssue(workspace_desktopPane, addIssue_comboBox.getSelectedIndex());
			
			} catch (ParseException e1) {
		
				e1.printStackTrace();
			}
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
	
		if(e.getSource().equals(updateBtn)) {
			dispose();
			JInternalFrame currFrame = new UpdateIssue(workspace_desktopPane);

			workspace_desktopPane.add(currFrame);
			
			//Opens JinternalFrame centered in the JDesktopPane
			Dimension desktopSize = workspace_desktopPane.getSize();
			Dimension jInternalFrameSize = currFrame.getSize();
			
			//Test if current internal frame is of class AddIssue and renders the frame with that
			if(currFrame.getClass() == UpdateIssue.class){
				currFrame.setLocation((desktopSize.width - jInternalFrameSize.width),
				    (desktopSize.height- jInternalFrameSize.height)/2);
			}
		}
		
		if(e.getSource().equals(removeBtn) ) {
			//To remove Issue record
        	int opt = JOptionPane.showConfirmDialog(workspace_desktopPane, 
					"Are you sure u want to Remove IssueID:"+ issueID + "? ", 
					"REMOVE",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE);
        	if(opt == 0) {
        		removeStudentIssue();
        		
        	}else 
				if(opt == 1) {
					//RETURN
				}
		}
		
		if(e.getSource().equals(searchBtn)) {
			dispose();
			JInternalFrame currFrame = new UpdateIssue(workspace_desktopPane);

			workspace_desktopPane.add(currFrame);
			
			//Opens JinternalFrame centered in the JDesktopPane
			Dimension desktopSize = workspace_desktopPane.getSize();
			Dimension jInternalFrameSize = currFrame.getSize();
			
			//Test if current internal frame is of class AddIssue and renders the frame with that
			if(currFrame.getClass() == UpdateIssue.class){
				currFrame.setLocation((desktopSize.width - jInternalFrameSize.width),
				    (desktopSize.height- jInternalFrameSize.height)/2);
			}
		}
	}
	
	private void updateIssueTable() {
		String studentID = student.getID();
		ArrayList<Issue> studentIssues = IssueController.getAllIssuesForStudent(studentID);
		DefaultTableModel model = (DefaultTableModel) issueTable.getModel();
		
		int serviceInd;
		String repAssigned;
		
		/**
		 * Iterates through List of Issues relating to a specified student and displays
		 * values in the issue table.
		 */
		if(studentIssues != null) {
			for(Issue issue: studentIssues) {
				
				/**
				 * Finds STRING from SERVICETYPES that related specified SERVICEID returned
				 * from the DATABASE.
				 */
				for(serviceInd = 0; serviceInd<serviceTypes.size(); serviceInd++)
					if(serviceInd == issue.getServiceID()-1)
						break;
				
				/**
				 * Finds whether a student services representative was assigned to specified 
				 * issue. If no representative was assigned then the string "Not assigned"
				 * is shown.
				 */
				if(issue.getRepID() == null)
					repAssigned = "NOT Assigned";
				else
					repAssigned = issue.getRepID();
						
					
				/**
				 * Adds row to table with details relating to current student's issue.
				 */
				model.addRow(new Object[]{
						issue.getIssueID(), 
						issue.getType(),
						serviceTypes.get(serviceInd),
						issue.getIssuedAt(),
						issue.getStatus(),
						repAssigned
				});
			}			
		}

	}
	
	private void getIssueStats() {
		String studentID = student.getID();
		int []stats = IssueController.getStudentIssueStats(studentID);
		
		String issueMade = String.valueOf(stats[0]);
		String issueCompleted = String.valueOf(stats[1]); 
		String issuePending = String.valueOf(stats[2]);
		
		issueMade_lbl.setText(issueMade);
		issueCompleted_lbl.setText(issueCompleted);
		issuePending_lbl.setText(issuePending);
	}
	
	private void searchStudentIssue() {
//		serviceTypes
//		searchIssueType_comboBox
//		searchFor_lbl
//		searchDatePicker
		String studentID = UserLogin.currentUser.getID();
		String searchID = searchID_txtfield.getText();
		int serviceType = service_combobox.getSelectedIndex()+1;
		String type = (String)searchIssueType_comboBox.getItemAt(searchIssueType_comboBox.getSelectedIndex());
		
				
		if(true) {}
		
	}
	
	private void removeStudentIssue() {
		DefaultTableModel model = (DefaultTableModel) issueTable.getModel();
		//Remove record from table on ISSUE VIEW
		if(issueID!=null) {
			boolean issueRemoved =IssueController.removeIssue(issueID);
			model.removeRow(issueTable.getSelectedRow());
			if(issueRemoved) {
				JOptionPane.showMessageDialog(workspace_desktopPane, 
						"ISSUE DELETED SUCCESSFULLY", 
						"SUCCESS",
						JOptionPane.INFORMATION_MESSAGE);	
			}
		}else {
			JOptionPane.showMessageDialog(workspace_desktopPane, 
					"Oops.. Problem occured deleting your issue.", 
					"ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
		}
	
	private void addStudentIssueResponse(String issueID) {
		workspace_desktopPane.removeAll();
		workspace_desktopPane.updateUI();
		
		JInternalFrame currFrame = null;
		currFrame = new StudentIssueResponse(workspace_desktopPane, issueID);
		workspace_desktopPane.add(currFrame);
		
		//Opens JinternalFrame centered in the JDesktopPane
		Dimension desktopSize = workspace_desktopPane.getSize();
		Dimension jInternalFrameSize = currFrame.getSize();
		
		//Test if current internal frame is of class AddIssue and renders the frame with that
		if(currFrame.getClass() == StudentIssueResponse.class){
			currFrame.setLocation((desktopSize.width - jInternalFrameSize.width),
			    (desktopSize.height- jInternalFrameSize.height)/2);
		}
	}
}
