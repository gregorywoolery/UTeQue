package com.view.staff;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.controller.UserController;
import com.model.User;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import java.awt.Dimension;

public class JoinMeeting extends JInternalFrame{
	private static final Logger logger = LogManager.getLogger(IssueMain.class);

	private JDesktopPane workSpaceDesktop;
	
	/**
	 * @throws ParseException 
	 * @wbp.parser.constructor
	 */
	public JoinMeeting(JDesktopPane workSpaceDesktop) throws ParseException {
		super("View Issue", 
				false, 	//resizable
				true, 	//closable
				false, 	//maximizable
				true);	//iconifiable
		initializeComponents();
		this.workSpaceDesktop =  workSpaceDesktop;
	}
	
	private void initializeComponents() {		
		//Removes top bar from internal frame
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		
		setBorder(new LineBorder(new Color(0, 0, 51), 20));
		setBounds(100, 100, 820, 570);
		getContentPane().setBackground(new Color(0, 0, 51));
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 30));
		
		
		JPanel main_panel = new JPanel();
		main_panel.setBackground(new Color(0, 0, 51));
		main_panel.setPreferredSize(new Dimension(630, 450));
		getContentPane().add(main_panel);

		BufferedImage myPicture;
		try {
			myPicture = ImageIO.read(new File("./Resources/img/under_construction.jpg"));
			JLabel picLabel = new JLabel(new ImageIcon(myPicture));
			main_panel.add(picLabel);
			
		} catch (IOException e) {
			logger.error("Cannot load construction image");
		}
		
		this.setVisible(true);
	}

}
