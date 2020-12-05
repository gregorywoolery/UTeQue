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
import java.sql.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


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
import com.model.Issue;
import com.model.User;
import com.view.Dashboard;
import com.view.UserLogin;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.border.TitledBorder;

@SuppressWarnings("rawtypes")
public class StudentMain extends JInternalFrame implements ActionListener{
	private static final Logger logger = LogManager.getLogger(StudentMain.class);
	private static final long serialVersionUID = -8375563652031458336L;

	private JPanel addIssue_panel;
	private JPanel IssueDisplay_panel;
	private JPanel studentIssue_panel;
	private JLabel addIssueTitle_lbl;
	private JComboBox<String> addIssue_comboBox;
	private JLabel addedDate_lbl;
	private JButton addBtn;
	private JButton liveChatBtn;
	private JPanel userIssueStats_panel;
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
	private JDesktopPane workspace_desktopPane;
	
	private String currDate;
	private ArrayList<String> serviceTypes;
	private String issueID = null;
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
	
	@SuppressWarnings({ "serial", "unchecked" })
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
		
		getIssueStats();
				
		addIssue_panel = new JPanel();
		addIssue_panel.setBackground(new Color(255, 255, 0));
		addIssue_panel.setName("");
		GridBagConstraints gbc_addIssue_panel = new GridBagConstraints();
		gbc_addIssue_panel.fill = GridBagConstraints.BOTH;
		gbc_addIssue_panel.insets = new Insets(0, 0, 5, 5);
		gbc_addIssue_panel.gridx = 1;
		gbc_addIssue_panel.gridy = 1;
		
		getContentPane().add(addIssue_panel, gbc_addIssue_panel);
		addIssue_panel.setLayout(new BoxLayout(addIssue_panel, BoxLayout.Y_AXIS));
		
		addIssueTitle_lbl = new JLabel("ADD ISSUE");
		addIssueTitle_lbl.setBorder(new LineBorder(new Color(255, 255, 0), 10));
		addIssueTitle_lbl.setForeground(new Color(0, 0, 51));
		addIssueTitle_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		addIssueTitle_lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		addIssue_panel.add(addIssueTitle_lbl);
		addIssue_comboBox = new JComboBox(new DefaultComboBoxModel(new String[] {"Complaint", "Query"}));
		addIssue_comboBox.setToolTipText("Select issue type here");
		addIssue_comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addIssue_comboBox.setForeground(new Color(255, 255, 255));
		addIssue_comboBox.setBorder(null);
		addIssue_comboBox.setBackground(new Color(0, 0, 51));
		addIssue_comboBox.setMaximumSize(new Dimension(100, 25));
		addIssue_comboBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		addIssue_panel.add(addIssue_comboBox);
		
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
		
		
		
		searchIssueType_comboBox = new JComboBox(new DefaultComboBoxModel(new String[] {"Exclude", "Complaint", "Query"}));
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
			
			} catch (ParseException pex) {
				logger.error("ERROR - " + pex.getMessage()
				+ "AT- " + pex.getStackTrace());
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
		
		//To remove Issue record
		if(e.getSource().equals(removeBtn) ) {
        	int opt = JOptionPane.showConfirmDialog(workspace_desktopPane, 
					"Are you sure u want to Remove IssueID:"+ issueID + "? ", 
					"REMOVE",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE);
        	if(opt == 0)
        		removeStudentIssue();		
		}
		
		if(e.getSource().equals(searchBtn)) {
			searchStudentIssue();
		}
		
		if(e.getSource().equals(liveChatBtn)) {
			/**
			 * Dispose of current internal frame. Add new internal 
			 * frame to workspace desktop pane.
			 */
			dispose();
			
			JInternalFrame currFrame = null;
			try {
				currFrame = new LiveChatLobby(workspace_desktopPane);
			
			} catch (ParseException pex) {
				logger.error("ERROR - " + pex.getMessage()
				+ "AT- " + pex.getStackTrace());
			}
			workspace_desktopPane.add(currFrame);
			
			//Opens JinternalFrame centered in the JDesktopPane
			Dimension desktopSize = workspace_desktopPane.getSize();
			Dimension jInternalFrameSize = currFrame.getSize();
			
			//Test if current internal frame is of class AddIssue and renders the frame with that
			if(currFrame.getClass() == LiveChatLobby.class){
				currFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/500,
				    (desktopSize.height- jInternalFrameSize.height)/70);
			}
		}
	}
	
	private void updateIssueTable() {
		String studentID = student.getID();
		ArrayList<Issue> studentIssues = IssueController.getAllIssuesForStudent(studentID);
		DefaultTableModel model = (DefaultTableModel) issueTable.getModel();
		String issuedAt;
		int serviceInd;
		String repAssigned;
		
		getIssueStats();
		
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
						
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				issuedAt = sdf.format(issue.getIssuedAt());
				
				/**
				 * Adds row to table with details relating to current student's issue.
				 */
				model.addRow(new Object[]{
						issue.getIssueID(), 
						issue.getType(),
						serviceTypes.get(serviceInd),
						issuedAt,
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
		String studentID = UserLogin.currentUser.getID();
		int serviceType = service_combobox.getSelectedIndex()+1;
		String type = (String)searchIssueType_comboBox.getItemAt(searchIssueType_comboBox.getSelectedIndex());
		Date issuedAt = null;
		
		Issue searchIssue = new Issue();
		searchIssue.setStudentID(studentID);
		searchIssue.setServiceID(serviceType);
		searchIssue.setIssuedAt(issuedAt);
		searchIssue.setType(type);
		
		//Checks IF type is valid
		if(type!=null) {
			
			//studentIssues stores the retrieved values from the IssueController.getSearchIssuesForStudent Method
			ArrayList<Issue> studentIssues = IssueController.getSearchIssuesForStudent(searchIssue);

			//A new DefaultTableModel is created to Display records
			DefaultTableModel model = (DefaultTableModel) issueTable.getModel();
			
			/**
			 * Iterates through List of Issues relating to a specified student and displays
			 * values in the issue table.
			 */
			if(studentIssues != null) {
				model.setRowCount(0);
				for(Issue issue: studentIssues) {
					/**
					 * Adds row to table with details relating to current student's issue.
					 */
					model.addRow(new Object[]{
							issue.getIssueID(), 
							issue.getType(),
							serviceTypes.get(issue.getServiceID()-1),
							issue.getIssuedAt(),
							issue.getStatus(),
							issue.getRepID()
					});
				}			
			}
		} else {
			JOptionPane.showMessageDialog(workspace_desktopPane, 
					"Oops.. Results WERE NOT FOUND.", 
					"ERROR",
					JOptionPane.ERROR_MESSAGE);
		}	
	}
	
	private void removeStudentIssue() {
		DefaultTableModel model = (DefaultTableModel) issueTable.getModel();
		
		//Remove record from table on ISSUE VIEW
		if(issueID != null) {
			
			boolean issueRemoved =IssueController.removeIssue(issueID);
			
			if(issueRemoved == true) {
				model.removeRow(issueTable.getSelectedRow());
				JOptionPane.showMessageDialog(workspace_desktopPane, 
						"ISSUE DELETED SUCCESSFULLY", 
						"SUCCESS",
						JOptionPane.INFORMATION_MESSAGE);	
			}else{
				JOptionPane.showMessageDialog(workspace_desktopPane, 
						"Issues is already ASSIGNED, Unable to DELETE", 
						"ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
		}else {
			JOptionPane.showMessageDialog(workspace_desktopPane, 
					"Issue Could NOT be DELETED", 
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
