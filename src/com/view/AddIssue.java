package com.view;

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
import javax.swing.JTextField; 
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import java.awt.Cursor;
import javax.swing.DefaultComboBoxModel;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

import com.services.DocumentSizeFilter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class AddIssue extends JInternalFrame {
	private JTextField issueSummary_txtfd;
	private JTable issueTable;
	private JTextArea issueTextArea;
	private DefaultStyledDocument issueAreaDoc;
	private DefaultStyledDocument summaryAreaDoc;
	private JLabel addIssue_lbl;
	private JPanel infoPanel;
	private JPanel issueID_panel;
	private JComboBox addIssue_comboBox;
	private JLabel issueSummary_lbl;
	private JPanel main_Panel;
	private JLabel promptIssue;
	private JLabel remainingChar_lbl;
	private JButton addBtn;
	private JButton clearBtn;
	private JPanel footer_panel;
	private JPanel spaceHolder;
	private JButton returnBtn;
	private JLabel remainingSum_lbl;
	private JLabel issueIDTitle_lbl;
	private JLabel issueID_lbl;
	
	/**
	 * Create the frame.
	 */
	public AddIssue() {
		super("Add Issue", false, false, false, true);
		initializeComponents();
	}
	
	private void initializeComponents() {
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		
		this.setVisible(true);
		this.setSize(730, 550);
		getContentPane().setBackground(new Color(0, 0, 51));
		setBorder(new LineBorder(new Color(0, 0, 51), 20));
		setBounds(100, 100, 710, 530); //730 550
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[] {50, 0, 280, 100, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
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
		issueID_panel.setMaximumSize(new Dimension(130, 32767));
		infoPanel.add(issueID_panel);
		
		issueIDTitle_lbl = new JLabel("Issue ID");
		issueIDTitle_lbl.setForeground(new Color(255, 255, 255));
		issueIDTitle_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		issueID_panel.add(issueIDTitle_lbl);
		
		issueID_lbl = new JLabel("");
		issueID_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		issueID_lbl.setPreferredSize(new Dimension(115, 20));
		issueID_lbl.setForeground(new Color(255, 255, 255));
		issueID_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		issueID_panel.add(issueID_lbl);
		
		addIssue_comboBox = new JComboBox();
		addIssue_comboBox.setBorder(null);
		addIssue_comboBox.setMaximumSize(new Dimension(100, 30));
		addIssue_comboBox.setForeground(new Color(0, 0, 51));
		addIssue_comboBox.setModel(new DefaultComboBoxModel(new String[] {"Complaint", "Queries"}));
		addIssue_comboBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		addIssue_comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addIssue_comboBox.setBackground(new Color(255, 255, 0));
		infoPanel.add(addIssue_comboBox);
		
		issueSummary_lbl = new JLabel("Summary:");
		issueSummary_lbl.setForeground(new Color(255, 255, 255));
		issueSummary_lbl.setBorder(new LineBorder(new Color(0, 0, 51), 11));
		issueSummary_lbl.setHorizontalAlignment(SwingConstants.RIGHT);
		issueSummary_lbl.setMaximumSize(new Dimension(150, 40));
		issueSummary_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		infoPanel.add(issueSummary_lbl);
		
		issueSummary_txtfd = new JTextField();
		issueSummary_lbl.setLabelFor(issueSummary_txtfd);
		issueSummary_txtfd.setMaximumSize(new Dimension(200, 25));
		issueSummary_txtfd.setFont(new Font("Times New Roman", Font.PLAIN, 13));

		/*
		 * Sets a limit of 150 characters to the JTextField by using the 
		 * DocumentSizeFilter in the services package that rejects 
		 * insertion of addition content.
		 */
		summaryAreaDoc = new DefaultStyledDocument();
		summaryAreaDoc.setDocumentFilter(new DocumentSizeFilter(40));
		summaryAreaDoc.addDocumentListener(new DocumentListener(){
            @Override
            public void changedUpdate(DocumentEvent e) { updateSumCount();}
            @Override
            public void insertUpdate(DocumentEvent e) { updateSumCount();}
            @Override
            public void removeUpdate(DocumentEvent e) { updateSumCount();}
        });
		
		issueSummary_txtfd.setDocument(summaryAreaDoc);
		
		infoPanel.add(issueSummary_txtfd);
		issueSummary_txtfd.setColumns(10);
		
		remainingSum_lbl = new JLabel("");
		remainingSum_lbl.setHorizontalAlignment(SwingConstants.RIGHT);
		remainingSum_lbl.setMaximumSize(new Dimension(70, 20));
		remainingSum_lbl.setForeground(Color.RED);
		remainingSum_lbl.setFont(new Font("Times New Roman", Font.BOLD, 13));
		infoPanel.add(remainingSum_lbl);
		
		
		main_Panel = new JPanel();
		main_Panel.setBackground(new Color(255, 255, 0));
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
		
		issueTextArea = new JTextArea(4, 20);
		issueTextArea.setTabSize(6);
		issueTextArea.setLineWrap(true);
		issueTextArea.setFont(new Font("Times New Roman", Font.PLAIN, 13));
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
		addBtn.setPreferredSize(new Dimension(100, 35));
		addBtn.setBackground(new Color(51, 255, 0));
		addBtn.setForeground(new Color(255, 255, 255));
		addBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		addBtn.setBorder(null);
		GridBagConstraints gbc_addBtn = new GridBagConstraints();
		gbc_addBtn.insets = new Insets(0, 0, 5, 5);
		gbc_addBtn.gridx = 0;
		gbc_addBtn.gridy = 3;
		main_Panel.add(addBtn, gbc_addBtn);
		
		clearBtn = new JButton("CLEAR");
		clearBtn.setIcon(new ImageIcon(AddIssue.class.getResource("/img/clear.png")));

		clearBtn.setPreferredSize(new Dimension(100, 35));
		clearBtn.setBackground(new Color(51, 255, 0));
		clearBtn.setForeground(new Color(255, 255, 255));
		clearBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		clearBtn.setBorder(null);
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
				"Issue ID", "TYPE", "MAIN DETAILS", "DATE ISSUED", "Details"
			}
		));
		issueTable.getColumnModel().getColumn(0).setResizable(false);
		issueTable.getColumnModel().getColumn(0).setPreferredWidth(90);
		issueTable.getColumnModel().getColumn(1).setPreferredWidth(87);
		issueTable.getColumnModel().getColumn(2).setPreferredWidth(110);
		issueTable.getColumnModel().getColumn(3).setPreferredWidth(83);
		issueTable.getColumnModel().getColumn(4).setPreferredWidth(142);
		
		//Changes table heaver font
		JTableHeader tableHeader = issueTable.getTableHeader();
		tableHeader.setBackground(new Color(0, 0, 51));
		tableHeader.setForeground(Color.white);
		tableHeader.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		issueTable.setGridColor(new Color(0, 0, 51));
		issueTable.setBackground(new Color(0,204, 225));
		
		
		footer_panel.add(new JScrollPane(issueTable));
		
		spaceHolder = new JPanel();
		spaceHolder.setBackground(new Color(0, 0, 51));
		spaceHolder.setPreferredSize(new Dimension(40, 90));
		footer_panel.add(spaceHolder);
		
		returnBtn = new JButton("Return");
		returnBtn.setHorizontalAlignment(SwingConstants.LEFT);
		returnBtn.setIcon(new ImageIcon(AddIssue.class.getResource("/img/return.png")));
		returnBtn.setForeground(new Color(255, 255, 255));
		returnBtn.setMaximumSize(new Dimension(65, 35));
		returnBtn.setPreferredSize(new Dimension(95, 30));
		returnBtn.setBackground(new Color(255, 0, 0));
		returnBtn.setBorder(null);
		returnBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		returnBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		footer_panel.add(returnBtn);
	}
	
    private void updateCount(){
        remainingChar_lbl.setText((150 -issueAreaDoc.getLength()) + " characters remaining");
    }

    private void updateSumCount() {
    	remainingSum_lbl.setText("Rem: " + (40 -issueAreaDoc.getLength()));
    }
    
    private void actionPerformed() {
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opt = JOptionPane.showConfirmDialog(null, 
						"Are you sure you want to add this Issue?", 
						"Add Issue",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE);
				if (opt == 0) {
					//ADD ISSUE
				}else 
					if(opt == 1) {
						//RETURN
					}
			}
		});
		
		
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opt = JOptionPane.showConfirmDialog(null, 
						"Are you sure you want to clear the fields?", 
						"Clear Fields...",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if (opt == 0) {
					issueSummary_txtfd.setText("");
					issueTextArea.setText("");
				}
			}
		});
		
		returnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opt = JOptionPane.showConfirmDialog(null, 
						"You will now be returning to the Dashboard. Are you sure?", 
						"Clear Fields...",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				
				switch(opt) {
					case 0:
					case 1:
					case 2:
				}
			}
		});
	}
    
}
