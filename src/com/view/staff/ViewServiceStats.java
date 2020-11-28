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
	private JPanel serviceStatsTitle_panel;
	private JLabel serviceStatsTitle_lbl;
	private JPanel serviceStats_panel;
	private JTable serviceStats_table;
	private JScrollPane scrollPane;
	private JButton returnBtn;
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
		
		serviceStatsTitle_panel = new JPanel();
		FlowLayout fl_serviceStatsTitle_panel = (FlowLayout) serviceStatsTitle_panel.getLayout();
		fl_serviceStatsTitle_panel.setVgap(15);
		serviceStatsTitle_panel.setPreferredSize(new Dimension(550, 50));
		getContentPane().add(serviceStatsTitle_panel);
		
		serviceStatsTitle_lbl = new JLabel("List of Services X Statistics");
		serviceStatsTitle_lbl.setForeground(new Color(0, 0, 51));
		serviceStatsTitle_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		serviceStatsTitle_panel.add(serviceStatsTitle_lbl);
		
		serviceStats_panel = new JPanel();
		serviceStats_panel.setBackground(new Color(0, 0, 51));
		serviceStats_panel.setPreferredSize(new Dimension(720, 450));
		getContentPane().add(serviceStats_panel);
		GridBagLayout gbl_serviceStats_panel = new GridBagLayout();
		gbl_serviceStats_panel.columnWidths = new int[] {0, 620, 62, 0};
		gbl_serviceStats_panel.rowHeights = new int[]{440, 0};
		gbl_serviceStats_panel.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_serviceStats_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		serviceStats_panel.setLayout(gbl_serviceStats_panel);
		
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
		
		scrollPane = new JScrollPane(serviceStats_table);
		scrollPane.setPreferredSize(new Dimension(620, 440));
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.anchor = GridBagConstraints.NORTHWEST;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 0;
		serviceStats_panel.add(scrollPane, gbc_scrollPane);
		
		returnBtn = new JButton("");
		GridBagConstraints gbc_returnBtn = new GridBagConstraints();
		gbc_returnBtn.anchor = GridBagConstraints.SOUTH;
		gbc_returnBtn.gridx = 2;
		gbc_returnBtn.gridy = 0;
		serviceStats_panel.add(returnBtn, gbc_returnBtn);
		returnBtn.setPreferredSize(new Dimension(50, 50));
		returnBtn.setIcon(new ImageIcon(ViewServiceStats.class.getResource("/img/return.png")));
		returnBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		returnBtn.setBackground(new Color(0, 255, 0));
		returnBtn.setBorder(null);
		
		setVisible(true);

	}
	
	private void registerListeners() {
		returnBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
