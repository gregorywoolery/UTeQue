package com.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class ViewService  extends JInternalFrame implements ActionListener{
	private JDesktopPane workSpaceDesktop;
	
	/**
	 * @throws ParseException 
	 * @wbp.parser.constructor
	 */
	public ViewService(JDesktopPane workSpaceDesktop) throws ParseException {
		super("View Service", 
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
