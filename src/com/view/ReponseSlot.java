package com.view;

import javax.swing.JPanel;
import java.awt.Rectangle;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextArea;
import java.awt.Insets;
import javax.swing.JCheckBox;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Color;

public class ReponseSlot extends JPanel {

	/**
	 * Create the panel.
	 */
	public ReponseSlot() {
		setBounds(new Rectangle(0, 0, 320, 230));
		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setPreferredSize(new Dimension(120, 20));
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setForeground(new Color(255, 255, 255));
		textArea.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		textArea.setPreferredSize(new Dimension(280, 100));
		add(textArea);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setPreferredSize(new Dimension(120, 20));
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setPreferredSize(new Dimension(120, 20));
		lblNewLabel_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		add(lblNewLabel_2);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		chckbxNewCheckBox.setEnabled(false);
		chckbxNewCheckBox.setPreferredSize(new Dimension(140, 40));
		chckbxNewCheckBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		add(chckbxNewCheckBox);

	}

}
