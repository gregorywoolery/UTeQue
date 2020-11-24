package com.view.staff;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class ViewIssue extends JInternalFrame implements ActionListener{

	private JDesktopPane workSpaceDesktop;
	
	public ViewIssue() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @throws ParseException 
	 * @wbp.parser.constructor
	 */
	public ViewIssue(JDesktopPane workSpaceDesktop) throws ParseException {
		super("View Issue", 
				false, 	//resizable
				true, 	//closable
				false, 	//maximizable
				true);	//iconifiable
		initializeComponents();
		registerListeners();
		this.workSpaceDesktop =  workSpaceDesktop;
	}
	
	public void initializeComponents() {
		
	}
	
	public void registerListeners() {
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
