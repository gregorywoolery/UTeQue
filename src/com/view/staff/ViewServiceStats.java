package com.view.staff;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.ImageIcon;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class ViewServiceStats extends JInternalFrame implements ActionListener{
	private JTable serviceStats_table;

	private JDesktopPane workSpaceDesktop;

	public ViewServiceStats(JDesktopPane workSpaceDesktop) throws ParseException {
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
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(15);
		panel.setPreferredSize(new Dimension(550, 50));
		getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("List of Services X Statistics");
		lblNewLabel.setForeground(new Color(0, 0, 51));
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 51));
		panel_1.setPreferredSize(new Dimension(720, 450));
		getContentPane().add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] {0, 620, 62, 0};
		gbl_panel_1.rowHeights = new int[]{440, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		serviceStats_table = new JTable();
		serviceStats_table.setPreferredSize(new Dimension(610, 430));
		serviceStats_table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"#", "Service", "Resolved Count", "Oustanding Count"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		serviceStats_table.getColumnModel().getColumn(0).setResizable(false);
		serviceStats_table.getColumnModel().getColumn(0).setPreferredWidth(32);
		serviceStats_table.getColumnModel().getColumn(1).setResizable(false);
		serviceStats_table.getColumnModel().getColumn(1).setPreferredWidth(315);
		serviceStats_table.getColumnModel().getColumn(2).setResizable(false);
		serviceStats_table.getColumnModel().getColumn(2).setPreferredWidth(100);
		serviceStats_table.getColumnModel().getColumn(3).setResizable(false);
		serviceStats_table.getColumnModel().getColumn(3).setPreferredWidth(100);
		serviceStats_table.getColumnModel().getColumn(3).setMinWidth(20);
		
		JScrollPane scrollPane = new JScrollPane(serviceStats_table);
		scrollPane.setPreferredSize(new Dimension(620, 440));
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.anchor = GridBagConstraints.NORTHWEST;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 0;
		panel_1.add(scrollPane, gbc_scrollPane);
		
		JButton returnBtn = new JButton("");
		GridBagConstraints gbc_returnBtn = new GridBagConstraints();
		gbc_returnBtn.anchor = GridBagConstraints.SOUTH;
		gbc_returnBtn.gridx = 2;
		gbc_returnBtn.gridy = 0;
		panel_1.add(returnBtn, gbc_returnBtn);
		returnBtn.setPreferredSize(new Dimension(50, 50));
		returnBtn.setIcon(new ImageIcon(ViewServiceStats.class.getResource("/img/return.png")));
		returnBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		returnBtn.setBackground(new Color(0, 255, 0));
		returnBtn.setBorder(null);
		
		setVisible(true);

	}
	
	private void registerListeners() {}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
