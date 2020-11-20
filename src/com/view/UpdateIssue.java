package com.view;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.controller.ServiceController;
import com.github.lgooddatepicker.components.DatePicker;
import com.services.DocumentSizeFilter;

import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.FlowLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JRadioButton;


public class UpdateIssue extends JInternalFrame implements ActionListener{
	private JLabel header_lbl;
	private JPanel home_panel;
	private JLabel issueID_lbl;
	private JButton updateBtn;
	private JComboBox issueType_comboBox;
	private JButton searchBtn;
	private JLabel service_lbl;
	private JButton clearBtn;
	private JLabel issueDetails_lbl;
	private JPanel issueDetails_panel;
	private JTextArea issueDetails_textArea;
	private DatePicker updateDatePicker;
	private JTextField issueID_textField;
	private JComboBox service_combobox;
	private JTable viewUpdate_table;
	private JDesktopPane workSpaceDesktop;
	private JPanel option_panel;
	private JLabel issueRem_lbl;
	private DefaultStyledDocument issueAreaDoc;
	private JPanel return_pnl;
	private JButton returnBtn;
	private JPanel paramType_panel;
	private JRadioButton paraTypeIn_rdbtn;
	private JRadioButton paraTypeEx_rdbtn;
	private JPanel paramService_panel;
	private JRadioButton paraServiceIn_rdbtn;
	private JRadioButton paraSeriveEx_rdbtn;
	private final ButtonGroup type_buttonGroup = new ButtonGroup();
	private final ButtonGroup service_buttonGroup = new ButtonGroup();
	
	/**
	 * Create the frame.
	 */
	public UpdateIssue(JDesktopPane workSpaceDesktop) {
		super("Update Issue",
				false, 	//resizeable
				true, 	//closable
				false, 	//maximizable
				true);	//iconifiable
		initializeComponents();
		registerListeners();
		this.workSpaceDesktop =  workSpaceDesktop;
	}
	
	private void initializeComponents() {
		//Removes top bar from internal frame
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		
		setBounds(100, 100, 840, 570);
		getContentPane().setBackground(new Color(0,204, 225));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {700, 0, 0};
		gridBagLayout.rowHeights = new int[] {0, 120, 110, 100, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		
		getContentPane().setLayout(gridBagLayout);
		
		header_lbl = new JLabel("UPDATE ISSUE");
		header_lbl.setIcon(new ImageIcon(UpdateIssue.class.getResource("/img/dash/update.png")));
		header_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		header_lbl.setPreferredSize(new Dimension(200, 40));
		header_lbl.setForeground(new Color(0, 0, 51));
		header_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
		
		GridBagConstraints gbc_header_lbl = new GridBagConstraints();
		gbc_header_lbl.insets = new Insets(10, 0, 0, 5);
		gbc_header_lbl.gridx = 0;
		gbc_header_lbl.gridy = 0;
		
		getContentPane().add(header_lbl, gbc_header_lbl);
		
		home_panel = new JPanel();
		home_panel.setBackground(new Color(0, 0, 51));
		
		GridBagConstraints gbc_home_panel = new GridBagConstraints();
		gbc_home_panel.insets = new Insets(0, 20, 0, 20);
		gbc_home_panel.fill = GridBagConstraints.BOTH;
		gbc_home_panel.gridx = 0;
		gbc_home_panel.gridy = 1;
		
		getContentPane().add(home_panel, gbc_home_panel);
		
		GridBagLayout gbl_home_panel = new GridBagLayout();
		gbl_home_panel.columnWidths = new int[] {0, 0, 30};
		gbl_home_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_home_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_home_panel.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		
		home_panel.setLayout(gbl_home_panel);
		
		issueID_lbl = new JLabel("Issue ID:");
		issueID_lbl.setForeground(new Color(255, 255, 255));
		issueID_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		GridBagConstraints gbc_issueID_lbl = new GridBagConstraints();
		gbc_issueID_lbl.anchor = GridBagConstraints.WEST;
		gbc_issueID_lbl.insets = new Insets(15, 20, 5, 5);
		gbc_issueID_lbl.gridx = 0;
		gbc_issueID_lbl.gridy = 0;
		
		home_panel.add(issueID_lbl, gbc_issueID_lbl);
		
		issueID_textField = new JTextField();
		issueID_textField.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		issueID_textField.setEnabled(true);
		issueID_textField.setDisabledTextColor(new Color(0, 0, 51));
		
		GridBagConstraints gbc_issueID_textField = new GridBagConstraints();
		gbc_issueID_textField.anchor = GridBagConstraints.WEST;
		gbc_issueID_textField.insets = new Insets(5, 20, 15, 5);
		gbc_issueID_textField.gridx = 0;
		gbc_issueID_textField.gridy = 1;
		
		home_panel.add(issueID_textField, gbc_issueID_textField);
		issueID_textField.setColumns(14);
		
		issueType_comboBox = new JComboBox(new String[] {"Complaint", "Query"});
		issueType_comboBox.setPreferredSize(new Dimension(125, 25));
		issueType_comboBox.setForeground(new Color(0, 0, 51));
		issueType_comboBox.setBackground(new Color(255, 255, 0));
		issueType_comboBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		GridBagConstraints gbc_issueType_comboBox = new GridBagConstraints();
		gbc_issueType_comboBox.anchor = GridBagConstraints.WEST;
		gbc_issueType_comboBox.insets = new Insets(10, 20, 15, 5);
		gbc_issueType_comboBox.gridx = 0;
		gbc_issueType_comboBox.gridy = 2;
		
		home_panel.add(issueType_comboBox, gbc_issueType_comboBox);
		
		paramType_panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) paramType_panel.getLayout();
		flowLayout.setHgap(10);
		paramType_panel.setPreferredSize(new Dimension(170, 25));
		paramType_panel.setBackground(new Color(0, 0, 51));
		GridBagConstraints gbc_paramType_panel = new GridBagConstraints();
		gbc_paramType_panel.insets = new Insets(0, 0, 5, 0);
		gbc_paramType_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_paramType_panel.gridx = 1;
		gbc_paramType_panel.gridy = 2;
		home_panel.add(paramType_panel, gbc_paramType_panel);
		
		paraTypeIn_rdbtn = new JRadioButton("Include");
		paraTypeIn_rdbtn.setBorder(null);
		paraTypeIn_rdbtn.setHorizontalAlignment(SwingConstants.LEFT);
		paraTypeIn_rdbtn.setHorizontalTextPosition(SwingConstants.RIGHT);
		paraTypeIn_rdbtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		paraTypeIn_rdbtn.setForeground(new Color(255, 255, 255));
		paraTypeIn_rdbtn.setBackground(new Color(0, 0, 51));
		type_buttonGroup.add(paraTypeIn_rdbtn);
		paramType_panel.add(paraTypeIn_rdbtn);
		
		paraTypeEx_rdbtn = new JRadioButton("Exclude");
		paraTypeEx_rdbtn.setBorder(null);
		paraTypeEx_rdbtn.setHorizontalAlignment(SwingConstants.LEFT);
		paraTypeEx_rdbtn.setHorizontalTextPosition(SwingConstants.RIGHT);
		paraTypeEx_rdbtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		paraTypeEx_rdbtn.setForeground(new Color(255, 255, 255));
		paraTypeEx_rdbtn.setBackground(new Color(0, 0, 51));
		type_buttonGroup.add(paraTypeEx_rdbtn);
		paramType_panel.add(paraTypeEx_rdbtn);
		
		updateDatePicker = new DatePicker();
		updateDatePicker.getComponentToggleCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		updateDatePicker.getComponentDateTextField().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		updateDatePicker.setBackground(new Color(0, 0, 51));
		
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.anchor = GridBagConstraints.WEST;
		gbc_textField_1.insets = new Insets(10, 20, 15, 5);
		gbc_textField_1.gridx = 0;
		gbc_textField_1.gridy = 3;
		
		home_panel.add(updateDatePicker, gbc_textField_1);
		
		service_lbl = new JLabel("Service");
		service_lbl.setForeground(new Color(255, 255, 255));
		service_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));

		GridBagConstraints gbc_service_lbl = new GridBagConstraints();
		gbc_service_lbl.anchor = GridBagConstraints.WEST;
		gbc_service_lbl.insets = new Insets(0, 20, 5, 5);
		gbc_service_lbl.gridx = 0;
		gbc_service_lbl.gridy = 4;
		
		home_panel.add(service_lbl, gbc_service_lbl);
		
		
		ArrayList<String> serviceTypes = ServiceController.getAllServies();

		service_combobox = new JComboBox(serviceTypes.toArray());
		service_combobox.setForeground(new Color(0, 0, 51));
		service_combobox.setBackground(new Color(255, 255, 0));
		service_combobox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		service_combobox.setPreferredSize(new Dimension(200, 25));
		
		GridBagConstraints gbc_service_combobox = new GridBagConstraints();
		gbc_service_combobox.anchor = GridBagConstraints.WEST;
		gbc_service_combobox.insets = new Insets(0, 20, 5, 5);
		gbc_service_combobox.gridx = 0;
		gbc_service_combobox.gridy = 5;
		
		home_panel.add(service_combobox, gbc_service_combobox);
		
		paramService_panel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) paramService_panel.getLayout();
		flowLayout_1.setHgap(10);
		paramService_panel.setBackground(new Color(0, 0, 51));
		GridBagConstraints gbc_paramService_panel = new GridBagConstraints();
		gbc_paramService_panel.insets = new Insets(0, 0, 5, 0);
		gbc_paramService_panel.fill = GridBagConstraints.BOTH;
		gbc_paramService_panel.gridx = 1;
		gbc_paramService_panel.gridy = 5;
		home_panel.add(paramService_panel, gbc_paramService_panel);
		
		paraServiceIn_rdbtn = new JRadioButton("Include");
		paraServiceIn_rdbtn.setBorder(null);
		paraServiceIn_rdbtn.setHorizontalTextPosition(SwingConstants.RIGHT);
		paraServiceIn_rdbtn.setForeground(new Color(255, 255, 255));
		paraServiceIn_rdbtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		paraServiceIn_rdbtn.setBackground(new Color(0, 0, 51));
		service_buttonGroup.add(paraServiceIn_rdbtn);
		paramService_panel.add(paraServiceIn_rdbtn);
		
		paraSeriveEx_rdbtn = new JRadioButton("Exclude");
		paraSeriveEx_rdbtn.setBorder(null);
		paraSeriveEx_rdbtn.setForeground(new Color(255, 255, 255));
		paraSeriveEx_rdbtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		paraSeriveEx_rdbtn.setBackground(new Color(0, 0, 51));
		service_buttonGroup.add(paraSeriveEx_rdbtn);
		paramService_panel.add(paraSeriveEx_rdbtn);
		
		issueDetails_lbl = new JLabel("Issue Made:");
		issueDetails_lbl.setForeground(new Color(255, 255, 255));
		issueDetails_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		GridBagConstraints gbc_issueDetails_lbl = new GridBagConstraints();
		gbc_issueDetails_lbl.anchor = GridBagConstraints.WEST;
		gbc_issueDetails_lbl.insets = new Insets(5, 20, 0, 5);
		gbc_issueDetails_lbl.gridx = 0;
		gbc_issueDetails_lbl.gridy = 6;
		
		home_panel.add(issueDetails_lbl, gbc_issueDetails_lbl);
		
		issueRem_lbl = new JLabel("");
		issueRem_lbl.setForeground(new Color(255, 0, 0));
		issueRem_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		GridBagConstraints gbc_issueRem_lbl = new GridBagConstraints();
		gbc_issueRem_lbl.gridx = 1;
		gbc_issueRem_lbl.gridy = 6;
		home_panel.add(issueRem_lbl, gbc_issueRem_lbl);
		
		option_panel = new JPanel();
		option_panel.setBackground(new Color(0, 204, 225));
		GridBagConstraints gbc_option_panel = new GridBagConstraints();
		gbc_option_panel.insets = new Insets(0, 0, 5, 0);
		gbc_option_panel.fill = GridBagConstraints.BOTH;
		gbc_option_panel.gridx = 1;
		gbc_option_panel.gridy = 1;
		getContentPane().add(option_panel, gbc_option_panel);
		option_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));
		
		updateBtn = new JButton("UPDATE");
		updateBtn.setBorder(null);
		updateBtn.setPreferredSize(new Dimension(100, 35));
		updateBtn.setBackground(new Color(51, 153, 255));
		updateBtn.setMargin(new Insets(20, 14, 20, 14));
		updateBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		updateBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		updateBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		searchBtn = new JButton("SEARCH");
		searchBtn.setBorder(null);
		searchBtn.setPreferredSize(new Dimension(100, 35));
		searchBtn.setBackground(new Color(51, 255, 51));
		searchBtn.setMargin(new Insets(20, 14, 20, 14));
		searchBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		searchBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		searchBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		
		clearBtn = new JButton("CLEAR");
		clearBtn.setBorder(null);
		clearBtn.setPreferredSize(new Dimension(100, 35));
		clearBtn.setBackground(new Color(204, 0, 0));
		clearBtn.setMargin(new Insets(20, 14, 20, 14));
		clearBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		clearBtn.setIcon(new ImageIcon(UpdateIssue.class.getResource("/img/clear.png")));
		clearBtn.setForeground(new Color(255, 255, 255));
		clearBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		clearBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		
		
		option_panel.add(updateBtn);		
		option_panel.add(searchBtn);
		option_panel.add(clearBtn);
		
		
		issueDetails_panel = new JPanel();
		FlowLayout fl_issueDetails_panel = (FlowLayout) issueDetails_panel.getLayout();
		fl_issueDetails_panel.setHgap(20);
		fl_issueDetails_panel.setAlignment(FlowLayout.LEFT);
		issueDetails_panel.setBackground(new Color(0, 0, 51));
		
		GridBagConstraints gbc_issueDetails_panel = new GridBagConstraints();
		gbc_issueDetails_panel.insets = new Insets(0, 20, 5, 20);
		gbc_issueDetails_panel.fill = GridBagConstraints.BOTH;
		gbc_issueDetails_panel.gridx = 0;
		gbc_issueDetails_panel.gridy = 2;
		
		getContentPane().add(issueDetails_panel, gbc_issueDetails_panel);
		
		issueDetails_textArea = new JTextArea();
		issueDetails_textArea.setTabSize(4);
		issueDetails_textArea.setLineWrap(true);
		issueDetails_textArea.setPreferredSize(new Dimension(500, 100));
		issueDetails_textArea.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		issueDetails_panel.add(issueDetails_textArea);
		
		
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
		
		issueDetails_textArea.setDocument(issueAreaDoc);
		
		viewUpdate_table = new JTable();
		viewUpdate_table.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		viewUpdate_table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Issue ID", "Type", "Date Made", "Service", "Details"
			}
		));
		viewUpdate_table.getColumnModel().getColumn(0).setResizable(false);
		viewUpdate_table.getColumnModel().getColumn(0).setPreferredWidth(100);
		viewUpdate_table.getColumnModel().getColumn(1).setResizable(false);
		viewUpdate_table.getColumnModel().getColumn(1).setPreferredWidth(100);
		viewUpdate_table.getColumnModel().getColumn(2).setResizable(false);
		viewUpdate_table.getColumnModel().getColumn(2).setPreferredWidth(98);
		viewUpdate_table.getColumnModel().getColumn(3).setPreferredWidth(100);
		viewUpdate_table.getColumnModel().getColumn(4).setPreferredWidth(186);
		
		GridBagConstraints gbc_viewUpdate = new GridBagConstraints();
		gbc_viewUpdate.insets = new Insets(0, 20, 10, 20);
		gbc_viewUpdate.fill = GridBagConstraints.BOTH;
		gbc_viewUpdate.gridx = 0;
		gbc_viewUpdate.gridy = 3;
		
		getContentPane().add(new JScrollPane(viewUpdate_table), gbc_viewUpdate);
		
		return_pnl = new JPanel();
		return_pnl.setToolTipText("Return home");
		FlowLayout fl_return_pnl = (FlowLayout) return_pnl.getLayout();
		fl_return_pnl.setVgap(30);
		return_pnl.setBackground(new Color(0,204, 225));
		GridBagConstraints gbc_return_pnl = new GridBagConstraints();
		gbc_return_pnl.fill = GridBagConstraints.BOTH;
		gbc_return_pnl.gridx = 1;
		gbc_return_pnl.gridy = 3;
		getContentPane().add(return_pnl, gbc_return_pnl);
		
		returnBtn = new JButton("RETURN");
		returnBtn.setBorder(null);
		returnBtn.setBackground(new Color(204, 0, 0));
		returnBtn.setPreferredSize(new Dimension(100, 35));
		returnBtn.setIcon(new ImageIcon(UpdateIssue.class.getResource("/img/return.png")));
		returnBtn.setHorizontalTextPosition(SwingConstants.RIGHT);
		returnBtn.setForeground(Color.WHITE);
		returnBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		return_pnl.add(returnBtn);
		
		setVisible(true);
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
			    (desktopSize.height- jInternalFrameSize.height)/50);
		}
	}
	
	private void registerListeners() {
		searchBtn.addActionListener(this);
		updateBtn.addActionListener(this);
		clearBtn.addActionListener(this);
		returnBtn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(searchBtn)) {
			
		}
		if(e.getSource().equals(updateBtn)) {}
		if(e.getSource().equals(returnBtn)) {}
		
		
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
	
    private void updateCount(){
    	issueRem_lbl.setText((150 -issueAreaDoc.getLength()) + " characters remaining");
    }
	


}
