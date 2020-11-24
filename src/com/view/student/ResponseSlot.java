package com.view.student;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Dimension;

import java.awt.Color;

public class ResponseSlot extends JPanel {

	/**
	 * Create the panel.
	 */
	public ResponseSlot() {
		initializeComponent();
	}
	
	private void initializeComponent() {
		this.setBackground(new Color(0, 0, 51));
		

		GridBagLayout gbl_response = new GridBagLayout();
		gbl_response.columnWidths = new int[] {170, 205, 0};
		gbl_response.rowHeights = new int[] {45, 85, 50, 40, 0};
		gbl_response.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_response.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0};
		this.setLayout(gbl_response);
		
		JLabel responseID_lbl = new JLabel("New label");
		responseID_lbl.setPreferredSize(new Dimension(100, 20));
		responseID_lbl.setForeground(new Color(255, 255, 255));
		responseID_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		GridBagConstraints gbc_responseID_lbl = new GridBagConstraints();
		gbc_responseID_lbl.gridwidth = 2;
		gbc_responseID_lbl.insets = new Insets(0, 0, 5, 0);
		gbc_responseID_lbl.gridx = 0;
		gbc_responseID_lbl.gridy = 0;
		this.add(responseID_lbl, gbc_responseID_lbl);
		
		JTextArea responseMessage_txtArea = new JTextArea();
		responseMessage_txtArea.setEnabled(false);
		responseMessage_txtArea.setLineWrap(true);
		responseMessage_txtArea.setTabSize(4);
		responseMessage_txtArea.setPreferredSize(new Dimension(330, 80));
		responseMessage_txtArea.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		GridBagConstraints gbc_responseMessage_txtArea = new GridBagConstraints();
		gbc_responseMessage_txtArea.anchor = GridBagConstraints.WEST;
		gbc_responseMessage_txtArea.gridwidth = 2;
		gbc_responseMessage_txtArea.insets = new Insets(0, 20, 5, 0);
		gbc_responseMessage_txtArea.gridx = 0;
		gbc_responseMessage_txtArea.gridy = 1;
		this.add(responseMessage_txtArea, gbc_responseMessage_txtArea);
		
		JLabel repName_lbl = new JLabel("New label");
		repName_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		repName_lbl.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_repName_lbl = new GridBagConstraints();
		gbc_repName_lbl.anchor = GridBagConstraints.WEST;
		gbc_repName_lbl.insets = new Insets(0, 20, 5, 5);
		gbc_repName_lbl.gridx = 0;
		gbc_repName_lbl.gridy = 2;
		this.add(repName_lbl, gbc_repName_lbl);
		
		JLabel respondDate_lbl = new JLabel("New label");
		respondDate_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		respondDate_lbl.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_respondDate_lbl = new GridBagConstraints();
		gbc_respondDate_lbl.anchor = GridBagConstraints.EAST;
		gbc_respondDate_lbl.insets = new Insets(0, 0, 5, 50);
		gbc_respondDate_lbl.gridx = 1;
		gbc_respondDate_lbl.gridy = 2;
		this.add(respondDate_lbl, gbc_respondDate_lbl);
		
		JCheckBox isAnswer_chckbx = new JCheckBox("is Answer ?");
		isAnswer_chckbx.setBackground(new Color(0, 0, 51));
		isAnswer_chckbx.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_isAnswer_chckbx = new GridBagConstraints();
		gbc_isAnswer_chckbx.anchor = GridBagConstraints.WEST;
		gbc_isAnswer_chckbx.insets = new Insets(0, 17, 5, 5);
		gbc_isAnswer_chckbx.gridx = 0;
		gbc_isAnswer_chckbx.gridy = 3;
		this.add(isAnswer_chckbx, gbc_isAnswer_chckbx);
		
		JLabel comment_lbl = new JLabel("Comment:");
		comment_lbl.setIconTextGap(25);
		comment_lbl.setHorizontalTextPosition(SwingConstants.LEFT);
		comment_lbl.setIcon(new ImageIcon(StudentIssueResponse.class.getResource("/img/add-comment.png")));
		comment_lbl.setForeground(new Color(255, 255, 255));
		comment_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		GridBagConstraints gbc_comment_lbl = new GridBagConstraints();
		gbc_comment_lbl.anchor = GridBagConstraints.WEST;
		gbc_comment_lbl.insets = new Insets(0, 20, 5, 0);
		gbc_comment_lbl.gridx = 1;
		gbc_comment_lbl.gridy = 3;
		this.add(comment_lbl, gbc_comment_lbl);
		
		JTextArea commentMessage_textArea = new JTextArea();
		commentMessage_textArea.setTabSize(4);
		commentMessage_textArea.setPreferredSize(new Dimension(250, 22));
		GridBagConstraints gbc_commentMessage_textArea = new GridBagConstraints();
		gbc_commentMessage_textArea.insets = new Insets(0, 0, 0, 20);
		gbc_commentMessage_textArea.anchor = GridBagConstraints.NORTHEAST;
		gbc_commentMessage_textArea.gridwidth = 2;
		gbc_commentMessage_textArea.gridx = 0;
		gbc_commentMessage_textArea.gridy = 4;
		this.add(commentMessage_textArea, gbc_commentMessage_textArea);
	}

}
