package com.view.student;

import javax.swing.JInternalFrame;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.DefaultStyledDocument;

import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

import com.controller.IssueController;
import com.controller.ServiceController;
import com.controller.UserController;
import com.model.Issue;
import com.model.User;
import com.services.DocumentSizeFilter;
import com.services.Identification;
import com.view.UserLogin;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;

@SuppressWarnings("rawtypes")
public class AddIssue extends JInternalFrame implements ActionListener{

	private static final long serialVersionUID = -7136979101087277758L;

	private JTable issueTable;
	private JTextArea issueTextArea;
	private DefaultStyledDocument issueAreaDoc;
	private JLabel addIssue_lbl;
	private JPanel infoPanel;
	private JPanel issueID_panel;
	private JComboBox<String> addIssue_comboBox;
	private JLabel issueListOfServices_lbl;
	private JPanel main_Panel;
	private JLabel promptIssue;
	private JLabel remainingChar_lbl;
	private JButton addBtn;
	private JButton clearBtn;
	private JPanel footer_panel;
	private JPanel spaceHolder;
	private JButton returnBtn;
	private JLabel issueIDTitle_lbl;
	private JLabel issueID_lbl;
	private JDesktopPane workSpaceDesktop;
	private String currDate;
	private int issueTypeSelect = 0;
	private JLabel issueDate_lbl;
	private Date currentDate = new Date();
	private JComboBox addListOfServices_comboBox;
	
	User student;
	
	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public AddIssue(JDesktopPane workSpaceDesktop, int issueTypeSelect) throws ParseException {
		super("Add Issue", 
				false, 	//resizable
				true, 	//closable
				false, 	//maximizable
				true);	//iconifiable
		initializeComponents();
		registerListeners();
		this.workSpaceDesktop =  workSpaceDesktop;
		this.issueTypeSelect = issueTypeSelect;
	}
	
	
	/**
	 * @throws ParseException 
	 * @wbp.parser.constructor
	 */
	public AddIssue(JDesktopPane workSpaceDesktop) throws ParseException {
		super("Add Issue", 
				false, 	//resizable
				true, 	//closable
				false, 	//maximizable
				true);	//iconifiable
		initializeComponents();
		registerListeners();
		this.workSpaceDesktop =  workSpaceDesktop;
	}
	
	@SuppressWarnings("unchecked")
	private void initializeComponents() throws ParseException {
		student =  UserController.getCurrentUser();
		
		//Removes top bar from internal frame
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		
		getContentPane().setBackground(new Color(0, 0, 51));
		setBorder(new LineBorder(new Color(0, 0, 51), 20));
		setBounds(100, 100, 820, 570);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[] {50, 0, 180, 100, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0};
		getContentPane().setLayout(gridBagLayout);
		
		addIssue_lbl = new JLabel("ADD ISSUE");
		addIssue_lbl.setIcon(new ImageIcon(AddIssue.class.getResource("/img/dash/add.png")));
		addIssue_lbl.setForeground(new Color(255, 255, 255));
		addIssue_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		GridBagConstraints gbc_addIssue_lbl = new GridBagConstraints();
		gbc_addIssue_lbl.gridx = 0;
		gbc_addIssue_lbl.gridy = 0;
		getContentPane().add(addIssue_lbl, gbc_addIssue_lbl);
		
		infoPanel = new JPanel();
		infoPanel.setForeground(new Color(0, 0, 51));
		infoPanel.setBorder(new LineBorder(new Color(255, 255, 0), 5));
		infoPanel.setBackground(new Color(0, 0, 51));
		GridBagConstraints gbc_infoPanel = new GridBagConstraints();
		gbc_infoPanel.insets = new Insets(0, 0, 5, 0);
		gbc_infoPanel.fill = GridBagConstraints.BOTH;
		gbc_infoPanel.gridx = 0;
		gbc_infoPanel.gridy = 1;
		getContentPane().add(infoPanel, gbc_infoPanel);
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.X_AXIS));
		
		issueID_panel = new JPanel();
		issueID_panel.setBackground(new Color(0, 0, 51));
		issueID_panel.setMaximumSize(new Dimension(170, 32767));
		infoPanel.add(issueID_panel);
		
		issueIDTitle_lbl = new JLabel("Issue ID");
		issueIDTitle_lbl.setForeground(new Color(255, 255, 255));
		issueIDTitle_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		issueID_panel.add(issueIDTitle_lbl);
		
		issueID_lbl = new JLabel();
		issueID_lbl.setText(Identification.getIssueId());
		issueID_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		issueID_lbl.setPreferredSize(new Dimension(115, 20));
		issueID_lbl.setForeground(new Color(255, 255, 255));
		issueID_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		issueID_panel.add(issueID_lbl);
		
		String issueType []={"Complaint", "Query"};  
		addIssue_comboBox = new JComboBox(issueType);
		addIssue_comboBox.setBorder(null);
		addIssue_comboBox.setMaximumSize(new Dimension(125, 30));
		addIssue_comboBox.setForeground(new Color(0, 0, 51));
		addIssue_comboBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		addIssue_comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addIssue_comboBox.setBackground(new Color(255, 255, 0));
		addIssue_comboBox.setSelectedIndex(issueTypeSelect);
		infoPanel.add(addIssue_comboBox);
		
		issueListOfServices_lbl = new JLabel("Services:");
		issueListOfServices_lbl.setForeground(new Color(255, 255, 255));
		issueListOfServices_lbl.setBorder(new LineBorder(new Color(0, 0, 51), 11));
		issueListOfServices_lbl.setHorizontalAlignment(SwingConstants.RIGHT);
		issueListOfServices_lbl.setMaximumSize(new Dimension(120, 40));
		issueListOfServices_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		infoPanel.add(issueListOfServices_lbl);
		
		//List of Services JComboBox
		ArrayList<String> serviceTypes = ServiceController.getAllServies();

		addListOfServices_comboBox = new JComboBox(serviceTypes.toArray());
		addListOfServices_comboBox.setForeground(new Color(0, 0, 51));
		addListOfServices_comboBox.setMaximumSize(new Dimension(190, 35));
		addListOfServices_comboBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		addListOfServices_comboBox.setBackground(new Color(255, 255, 0));
		infoPanel.add(addListOfServices_comboBox);
		
		main_Panel = new JPanel();
		main_Panel.setBackground(new Color(0, 0, 51));
		GridBagConstraints gbc_main_Panel = new GridBagConstraints();
		gbc_main_Panel.insets = new Insets(0, 0, 15, 0);
		gbc_main_Panel.fill = GridBagConstraints.BOTH;
		gbc_main_Panel.gridx = 0;
		gbc_main_Panel.gridy = 2;
		getContentPane().add(main_Panel, gbc_main_Panel);
		GridBagLayout gbl_main_Panel = new GridBagLayout();
		gbl_main_Panel.columnWidths = new int[] {0, 350, 0};
		gbl_main_Panel.rowHeights = new int[] {0, 0, 0, 0, 0, 0};
		gbl_main_Panel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_main_Panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		main_Panel.setLayout(gbl_main_Panel);
		
		promptIssue = new JLabel("Please state your issue...");
		promptIssue.setForeground(new Color(255, 255, 255));
		promptIssue.setIcon(new ImageIcon(AddIssue.class.getResource("/img/write.png")));
		promptIssue.setPreferredSize(new Dimension(300, 40));
		promptIssue.setHorizontalTextPosition(SwingConstants.RIGHT);
		promptIssue.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		GridBagConstraints gbc_promptIssue = new GridBagConstraints();
		gbc_promptIssue.anchor = GridBagConstraints.WEST;
		gbc_promptIssue.insets = new Insets(0, 15, 5, 5);
		gbc_promptIssue.gridx = 0;
		gbc_promptIssue.gridy = 0;
		main_Panel.add(promptIssue, gbc_promptIssue);
		
		
		
		issueTextArea = new JTextArea();
		issueTextArea.setMargin(new Insets(3, 3, 2, 2));
		issueTextArea.setTabSize(6);
		issueTextArea.setLineWrap(true);
		issueTextArea.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		issueTextArea.setPreferredSize(new Dimension(7, 100));
		
		
		
		/*
		 * Sets a limit of 150 characters to the JTextArea by using the 
		 * DocumentSizeFilter in the services package that rejects 
		 * insertion of addition content.
		 */
		issueAreaDoc = new DefaultStyledDocument();
		issueAreaDoc.setDocumentFilter(new DocumentSizeFilter(150));
		issueAreaDoc.addDocumentListener(new DocumentListener(){
            @Override
            public void changedUpdate(DocumentEvent e) { updateCount();}
            @Override
            public void insertUpdate(DocumentEvent e) { updateCount();}
            @Override
            public void removeUpdate(DocumentEvent e) { updateCount();}
        });
		
		issueTextArea.setDocument(issueAreaDoc);
		
		LocalDate date = LocalDate.now(); // Gets the current date
		DateTimeFormatter currentDateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		currDate = date.format(currentDateFormat);
		 
		
		
		issueDate_lbl = new JLabel(currDate);
		issueDate_lbl.setForeground(new Color(255, 255, 255));
		issueDate_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		GridBagConstraints gbc_issueDate_lbl = new GridBagConstraints();
		gbc_issueDate_lbl.insets = new Insets(0, 0, 5, 0);
		gbc_issueDate_lbl.gridx = 1;
		gbc_issueDate_lbl.gridy = 0;
		main_Panel.add(issueDate_lbl, gbc_issueDate_lbl);
		
		
		
		GridBagConstraints gbc_issueTextArea = new GridBagConstraints();
		gbc_issueTextArea.gridwidth = 2;
		gbc_issueTextArea.insets = new Insets(0, 15, 5, 15);
		gbc_issueTextArea.fill = GridBagConstraints.HORIZONTAL;
		gbc_issueTextArea.gridx = 0;
		gbc_issueTextArea.gridy = 1;
		main_Panel.add(issueTextArea, gbc_issueTextArea);
		
		remainingChar_lbl = new JLabel();
		remainingChar_lbl.setForeground(new Color(255, 0, 0));
		remainingChar_lbl.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_remainingChar_lbl = new GridBagConstraints();
		gbc_remainingChar_lbl.anchor = GridBagConstraints.WEST;
		gbc_remainingChar_lbl.insets = new Insets(0, 0, 25, 0);
		gbc_remainingChar_lbl.gridx = 1;
		gbc_remainingChar_lbl.gridy = 2;
		main_Panel.add(remainingChar_lbl, gbc_remainingChar_lbl);
		
		addBtn = new JButton("ADD");
		addBtn.setIcon(new ImageIcon(AddIssue.class.getResource("/img/add.png")));
		addBtn.setBorder(null);
		addBtn.setPreferredSize(new Dimension(100, 35));
		addBtn.setBackground(new Color(51, 255, 0));
		addBtn.setForeground(new Color(255, 255, 255));
		addBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		
		GridBagConstraints gbc_addBtn = new GridBagConstraints();
		gbc_addBtn.insets = new Insets(0, 0, 5, 5);
		gbc_addBtn.gridx = 0;
		gbc_addBtn.gridy = 3;
		main_Panel.add(addBtn, gbc_addBtn);
		
		clearBtn = new JButton("CLEAR");
		clearBtn.setIcon(new ImageIcon(AddIssue.class.getResource("/img/clear.png")));

		clearBtn.setBorder(null);
		clearBtn.setPreferredSize(new Dimension(100, 35));
		clearBtn.setBackground(new Color(51, 255, 0));
		clearBtn.setForeground(new Color(255, 255, 255));
		clearBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		
		GridBagConstraints gbc_clearBtn = new GridBagConstraints();
		gbc_clearBtn.insets = new Insets(0, 0, 5, 0);
		gbc_clearBtn.gridx = 1;
		gbc_clearBtn.gridy = 3;
		main_Panel.add(clearBtn, gbc_clearBtn);
		
		footer_panel = new JPanel();
		footer_panel.setBackground(new Color(0, 0, 51));
		GridBagConstraints gbc_footer_panel = new GridBagConstraints();
		gbc_footer_panel.fill = GridBagConstraints.BOTH;
		gbc_footer_panel.gridx = 0;
		gbc_footer_panel.gridy = 3;
		getContentPane().add(footer_panel, gbc_footer_panel);
		footer_panel.setLayout(new BoxLayout(footer_panel, BoxLayout.X_AXIS));
		
		issueTable = new JTable();
		issueTable.setPreferredScrollableViewportSize(new Dimension(450, 50));
		issueTable.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		issueTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Issue ID", "TYPE", "DATE ISSUED", "SERVICE", "DETAILS"
			}
		));
		issueTable.getColumnModel().getColumn(0).setResizable(false);
		issueTable.getColumnModel().getColumn(0).setPreferredWidth(75);
		issueTable.getColumnModel().getColumn(1).setPreferredWidth(75);
		issueTable.getColumnModel().getColumn(3).setPreferredWidth(75);
		issueTable.getColumnModel().getColumn(2).setPreferredWidth(112);
		issueTable.getColumnModel().getColumn(4).setPreferredWidth(112);
		
		//Changes table heaver font
		JTableHeader tableHeader = issueTable.getTableHeader();
		tableHeader.setBackground(new Color(0, 0, 51));
		tableHeader.setForeground(Color.white);
		tableHeader.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		issueTable.setGridColor(new Color(0, 0, 51));
		issueTable.setBackground(new Color(0,204, 225));
		
		
		JScrollPane scrollPane = new JScrollPane(issueTable);
		scrollPane.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		scrollPane.setPreferredSize(new Dimension(460, 52));
		footer_panel.add(scrollPane);
		
		spaceHolder = new JPanel();
		FlowLayout flowLayout = (FlowLayout) spaceHolder.getLayout();
		flowLayout.setVgap(30);
		spaceHolder.setBackground(new Color(0, 0, 51));
		spaceHolder.setPreferredSize(new Dimension(40, 90));
		footer_panel.add(spaceHolder);
		
		returnBtn = new JButton("Return");
		returnBtn.setHorizontalAlignment(SwingConstants.LEFT);
		returnBtn.setIcon(new ImageIcon(AddIssue.class.getResource("/img/return.png")));
		returnBtn.setBorder(null);
		returnBtn.setForeground(new Color(255, 255, 255));
		returnBtn.setMaximumSize(new Dimension(65, 35));
		returnBtn.setPreferredSize(new Dimension(95, 35));
		returnBtn.setBackground(new Color(255, 0, 0));
		returnBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		returnBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		spaceHolder.add(returnBtn);
		
		this.setVisible(true);
	}
	
    private void updateCount(){
        remainingChar_lbl.setText((150 -issueAreaDoc.getLength()) + " characters remaining");
    }
    
	public void addMainInternalFrame() {
		dispose();
		JInternalFrame currFrame = new StudentMain(workSpaceDesktop);
		workSpaceDesktop.add(currFrame);
		
		//Opens JinternalFrame centered in the JDesktopPane
		Dimension desktopSize = workSpaceDesktop.getSize();
		Dimension jInternalFrameSize = currFrame.getSize();
		
		//Test if current internal frame is of class Student main and renders the frame with that
		if(currFrame.getClass() == StudentMain.class){
			currFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
			    (desktopSize.height- jInternalFrameSize.height)/2);
		}
	}
    
	private void registerListeners() {
		addBtn.addActionListener(this);
		clearBtn.addActionListener(this);
		returnBtn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == addBtn) {
			if(!issueTextArea.getText().isBlank()) {
				int opt = JOptionPane.showConfirmDialog(workSpaceDesktop, 
						"Are you sure you want to add this Issue?", 
						"Add Issue",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE);

				if (opt == 0) {
					Issue issue = new Issue();
					issue.setIssueID(issueID_lbl.getText());
					issue.setType(addIssue_comboBox.getItemAt(addIssue_comboBox.getSelectedIndex()));
					issue.setStatus("Unresolved");
					issue.setStudentID(student.getID());
					issue.setMessage(issueTextArea.getText());
					issue.setServiceID(addListOfServices_comboBox.getSelectedIndex()+1);
					issue.setIssuedAt(currentDate);
					issue.setScheduledDateTime(null);
					issue.setRepId(null);
					
					boolean issueAdded = IssueController.addIssue(issue);

					issueID_lbl.setText(Identification.getIssueId());
					if(issueAdded) {
						JOptionPane.showMessageDialog(workSpaceDesktop, 
								"ISSUE ADDED SUCCESSFULLY", 
								"SUCCESS",
								JOptionPane.INFORMATION_MESSAGE);
						
						//Adds values to table on ADD ISSUE VIEW
						addToTable(issue.getIssueID());
						
					}else
						JOptionPane.showMessageDialog(workSpaceDesktop, 
								"Oops.. Problem occured adding your issue.", 
								"ERROR",
								JOptionPane.ERROR_MESSAGE);

				}else 
					if(opt == 1) {
						//RETURN
					}
			}else
				JOptionPane.showMessageDialog(workSpaceDesktop, 
						"Message field cannot be empty", 
						"ERROR",
						JOptionPane.ERROR_MESSAGE);
				
				
		}
		
		if(e.getSource() == clearBtn) {
			int opt = JOptionPane.showConfirmDialog(workSpaceDesktop, 
					"Are you sure you want to clear the fields?", 
					"Clear Fields...",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			if (opt == 0)
				issueTextArea.setText("");
			
		}
		
		if(e.getSource() == returnBtn) {
			int opt = JOptionPane.showConfirmDialog(workSpaceDesktop, 
					"You will now be returning to the Dashboard. Are you sure?", 
					"Return Home...",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			
			switch(opt) {
				case 0:
					addMainInternalFrame();
					break;
			}
		}
	}
	/**
	 * When issue is added successfully the JTable on the ADD ISSUE VIEW
	 * needs to be updated. Method will capture current issue details and
	 * add to the JTable issueTable. 
	 * 
	 * @param issueID   The issue ID that was pushed to the database is captures
	 * 					before it updates to display on JTable.
	 */
	private void addToTable(String issueID) {
		//"Issue ID", "TYPE", "DATE ISSUED", "SERVICE", "DETAILS"

		DefaultTableModel model = (DefaultTableModel) issueTable.getModel();
		model.addRow(new Object[]{
				issueID, 
				addIssue_comboBox.getItemAt(addIssue_comboBox.getSelectedIndex()), 
				currentDate,
				addListOfServices_comboBox.getItemAt(addListOfServices_comboBox.getSelectedIndex()),
				issueTextArea.getText()
		});
	}
    
}
