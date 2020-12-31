package com.view.student;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.border.LineBorder;

import com.controller.IssueController;
import com.controller.ResponseController;
import com.controller.ServiceController;
import com.controller.UserController;
import com.model.Issue;
import com.model.Response;
import com.model.Student;
import com.model.StudentServicesRep;
import com.model.User;
import com.view.staff.IssueMain;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.FlowLayout;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.Cursor;
import javax.swing.BoxLayout;

public class StudentIssueResponse extends JInternalFrame  implements ActionListener{
	private static final long serialVersionUID = 9161869361681829518L;
	
	private JLabel titile_lbl;
	private JButton helpBtn;
	private ImageIcon helpIcon;
	private JLabel helpinfo;
	private JPanel main_panel;
	private JTextArea issueMessage_txtArea;
	private JLabel services_lbl;
	private JLabel type_label;
	private JLabel reponsesTitle_lbl;
	private JTabbedPane tabbedPane;
	private ResponseSlot response;
	private JPanel side_panel;
	private JLabel issueID_lbl;
	private JLabel issuedAt_lbl;
	private JSeparator separator;
	private JLabel student_lbl;
	private JLabel studentID_lbl;
	private JLabel studentName_lbl;
	private JLabel email_lbl;
	private JLabel contactNo_lbl;
	private JSeparator separator1;
	private JLabel representative_lbl;
	private JLabel representativeName_lbl;
	private JSeparator separator2;
	private JButton returnBtn;
	private JDesktopPane workSpaceDesktop;
	private User student;
	private ArrayList<String> serviceTypes;
	public String issueID = null;
	public Issue issueDetails = null;
	public Response  issueResponse = null;
	public StudentServicesRep rep = null;
	private int MODE;
	
	public StudentIssueResponse(JDesktopPane workSpaceDesktop, String issueID) {
		super("Issue-Response", 
				false, 	//resizable
				true, 	//closable
				false, 	//maximizable
				true);	//iconifiable
		this.workSpaceDesktop = workSpaceDesktop;
		this.issueID = issueID;
		
		initializeComponents();
		registerListeners();
	}
	
	/**
	 * Create the frame.
	 */
	private void initializeComponents() {
		student =  UserController.getCurrentUser();
		serviceTypes = ServiceController.getAllServies();
		//Removes top bar from internal frame
		((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
		
		getContentPane().setBackground(new Color(0, 0, 51));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {540, 0, 0};
		gridBagLayout.rowHeights = new int[] {0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0};
		getContentPane().setLayout(gridBagLayout);
		
		titile_lbl = new JLabel("Issue - Response");
		titile_lbl.setHorizontalTextPosition(SwingConstants.LEADING);
		titile_lbl.setPreferredSize(new Dimension(250, 50));
		titile_lbl.setForeground(new Color(255, 255, 255));
		titile_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		GridBagConstraints gbc_titile_lbl = new GridBagConstraints();
		gbc_titile_lbl.anchor = GridBagConstraints.WEST;
		gbc_titile_lbl.insets = new Insets(10, 5, 10, 5);
		gbc_titile_lbl.gridx = 0;
		gbc_titile_lbl.gridy = 0;
		getContentPane().add(titile_lbl, gbc_titile_lbl);
		
		helpBtn = new JButton();
		helpBtn.setBackground(new Color(0, 0, 51));
		helpBtn.setBorder(null);
		helpBtn.setIcon(new ImageIcon(StudentIssueResponse.class.getResource("/img/help.png")));
		GridBagConstraints gbc_helpBtn = new GridBagConstraints();
		gbc_helpBtn.insets = new Insets(5, 0, 5, 0);
		gbc_helpBtn.gridx = 1;
		gbc_helpBtn.gridy = 0;
		getContentPane().add(helpBtn, gbc_helpBtn);
		
		
        helpIcon = new ImageIcon(StudentIssueResponse.class.getResource("/img/help.png"));

        helpinfo = new JLabel("<html>Welcome to Your Issue-Response Screen.<br>You can view information about an issue you once made.<br>"
									+"You can post a comment and reply if it is an answer.<br>There is also the option to view "
									+"your representiatives name so you may take up this issue personally.<br>Thank you. <br>For any other enquiries contact " 
									+ "Tier1Support at <br>tier1support@utech.edu.jm </html>");
        helpinfo.setVerticalAlignment(SwingConstants.BOTTOM);
        helpinfo.setBounds(0, 0, 250, 100);
        helpinfo.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        helpinfo.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		main_panel = new JPanel();
		main_panel.setBackground(new Color(204, 0, 0));
		GridBagConstraints gbc_main_panel = new GridBagConstraints();
		gbc_main_panel.insets = new Insets(0, 0, 0, 5);
		gbc_main_panel.fill = GridBagConstraints.BOTH;
		gbc_main_panel.gridx = 0;
		gbc_main_panel.gridy = 1;
		getContentPane().add(main_panel, gbc_main_panel);
		GridBagLayout gbl_main_panel = new GridBagLayout();
		gbl_main_panel.columnWidths = new int[] {440, 200};
		gbl_main_panel.rowHeights = new int[] {30, 80, 30, 30, 360};
		gbl_main_panel.columnWeights = new double[]{1.0, 0.0};
		gbl_main_panel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0};
		main_panel.setLayout(gbl_main_panel);
		
		issueMessage_txtArea = new JTextArea();
		issueMessage_txtArea.setDisabledTextColor(Color.BLACK);
		issueMessage_txtArea.setBackground(new Color(255, 255, 255));
		issueMessage_txtArea.setEnabled(false);
		issueMessage_txtArea.setForeground(new Color(255, 255, 255));
		issueMessage_txtArea.setMargin(new Insets(2, 4, 2, 4));
		issueMessage_txtArea.setLineWrap(true);
		issueMessage_txtArea.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		issueMessage_txtArea.setTabSize(4);
		GridBagConstraints gbc_issueMessage_txtArea = new GridBagConstraints();
		gbc_issueMessage_txtArea.gridheight = 3;
		gbc_issueMessage_txtArea.insets = new Insets(15, 15, 5, 10);
		gbc_issueMessage_txtArea.fill = GridBagConstraints.BOTH;
		gbc_issueMessage_txtArea.gridx = 0;
		gbc_issueMessage_txtArea.gridy = 0;
		main_panel.add(issueMessage_txtArea, gbc_issueMessage_txtArea);
		
		services_lbl = new JLabel("");
		services_lbl.setForeground(new Color(255, 255, 255));
		services_lbl.setBackground(new Color(255, 255, 255));
		services_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		services_lbl.setFont(new Font("Times New Roman", Font.BOLD, 13));
		GridBagConstraints gbc_services_lbl = new GridBagConstraints();
		gbc_services_lbl.gridheight = 2;
		gbc_services_lbl.insets = new Insets(15, 0, 5, 0);
		gbc_services_lbl.gridx = 1;
		gbc_services_lbl.gridy = 0;
		main_panel.add(services_lbl, gbc_services_lbl);
		
		type_label = new JLabel();
		type_label.setForeground(new Color(255, 255, 255));
		type_label.setBackground(new Color(255, 255, 255));
		type_label.setHorizontalAlignment(SwingConstants.CENTER);
		type_label.setFont(new Font("Times New Roman", Font.BOLD, 13));
		GridBagConstraints gbc_type_label = new GridBagConstraints();
		gbc_type_label.insets = new Insets(0, 0, 5, 0);
		gbc_type_label.gridx = 1;
		gbc_type_label.gridy = 2;
		main_panel.add(type_label, gbc_type_label);
		
		reponsesTitle_lbl = new JLabel("Responses");
		reponsesTitle_lbl.setForeground(new Color(255, 255, 255));
		reponsesTitle_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		GridBagConstraints gbc_reponsesTitle_lbl = new GridBagConstraints();
		gbc_reponsesTitle_lbl.anchor = GridBagConstraints.WEST;
		gbc_reponsesTitle_lbl.insets = new Insets(0, 15, 5, 5);
		gbc_reponsesTitle_lbl.gridx = 0;
		gbc_reponsesTitle_lbl.gridy = 3;
		main_panel.add(reponsesTitle_lbl, gbc_reponsesTitle_lbl);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setMaximumSize(new Dimension(360, 320));
		
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.insets = new Insets(0, 50, 30, 10);
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 4;
		main_panel.add(tabbedPane, gbc_tabbedPane);

		side_panel = new JPanel();
		side_panel.setBackground(new Color(204, 0, 0));
		GridBagConstraints gbc_side_panel = new GridBagConstraints();
		gbc_side_panel.fill = GridBagConstraints.BOTH;
		gbc_side_panel.gridx = 1;
		gbc_side_panel.gridy = 1;
		getContentPane().add(side_panel, gbc_side_panel);
		side_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
		
		issueID_lbl = new JLabel();
		issueID_lbl.setForeground(new Color(255, 255, 255));
		issueID_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		issueID_lbl.setPreferredSize(new Dimension(130, 25));
		issueID_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		side_panel.add(issueID_lbl);
		
		issuedAt_lbl = new JLabel();
		issuedAt_lbl.setForeground(new Color(255, 255, 255));
		side_panel.add(issuedAt_lbl);
		issuedAt_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		issuedAt_lbl.setPreferredSize(new Dimension(130, 25));
		issuedAt_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		
		separator = new JSeparator();
		separator.setPreferredSize(new Dimension(110, 10));
		side_panel.add(separator);
		
		student_lbl = new JLabel("Student");
		student_lbl.setForeground(new Color(255, 255, 255));
		student_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		student_lbl.setPreferredSize(new Dimension(130, 25));
		student_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		side_panel.add(student_lbl);
		
		studentID_lbl = new JLabel();
		studentID_lbl.setForeground(new Color(255, 255, 255));
		studentID_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		studentID_lbl.setPreferredSize(new Dimension(130, 25));
		studentID_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		side_panel.add(studentID_lbl);
		
		studentName_lbl = new JLabel();
		studentName_lbl.setForeground(new Color(255, 255, 255));
		studentName_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		studentName_lbl.setPreferredSize(new Dimension(130, 25));
		studentName_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		side_panel.add(studentName_lbl);
		
		email_lbl = new JLabel();
		email_lbl.setForeground(new Color(255, 255, 255));
		email_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		email_lbl.setPreferredSize(new Dimension(130, 25));
		email_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		side_panel.add(email_lbl);
		
		contactNo_lbl = new JLabel();
		contactNo_lbl.setForeground(new Color(255, 255, 255));
		contactNo_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		contactNo_lbl.setPreferredSize(new Dimension(130, 25));
		contactNo_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		side_panel.add(contactNo_lbl);
		
		separator1 = new JSeparator();
		separator1.setPreferredSize(new Dimension(110, 10));
		side_panel.add(separator1);
		
		representative_lbl = new JLabel("Representative");
		representative_lbl.setForeground(new Color(255, 255, 255));
		representative_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		representative_lbl.setPreferredSize(new Dimension(130, 25));
		representative_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		side_panel.add(representative_lbl);
		
		representativeName_lbl = new JLabel("");
		representativeName_lbl.setForeground(new Color(255, 255, 255));
		representativeName_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		representativeName_lbl.setPreferredSize(new Dimension(130, 25));
		representativeName_lbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		side_panel.add(representativeName_lbl);
		
		separator2 = new JSeparator();
		separator2.setPreferredSize(new Dimension(110, 30));
		side_panel.add(separator2);
		
		returnBtn = new JButton("Return");
		returnBtn.setPreferredSize(new Dimension(100, 35));
		returnBtn.setIcon(new ImageIcon(StudentIssueResponse.class.getResource("/img/return.png")));
		returnBtn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		returnBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		returnBtn.setBorder(null);
		returnBtn.setBackground(new Color(0, 255, 0));
		side_panel.add(returnBtn);
		setBorder(new LineBorder(new Color(0, 0, 51), 10));
		setBounds(100, 100, 820, 570);
		
		response = new ResponseSlot();
		response.isAnswer_chckbx.setEnabled(true);
		response.commentMessage_textArea.setEnabled(true);

		getInformation();
		setVisible(true);
	}
	
	private void registerListeners(){
		helpBtn.addActionListener(this);
		response.commentBtn.addActionListener(this);
		returnBtn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == returnBtn) {
			int opt = JOptionPane.showConfirmDialog(workSpaceDesktop, 
					"You will now be returning to the Dashboard. Are you sure?", 
					"Return Home...",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			
			if (opt == 0)
				openStudentMain();
		}
		
		if(e.getSource().equals(response.commentBtn)) {
			int opt = JOptionPane.showConfirmDialog(workSpaceDesktop, 
					"Are you sure you want to post this comment?", 
					"POST RESPONSE",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE);			
			
			if(opt == 0)
				if(isPostComment()) {
					JOptionPane.showMessageDialog(workSpaceDesktop, 
							"COMMENT POSTED", 
							"SUCCESS",
							JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(workSpaceDesktop, 
							"Oops.. Problem occured posting your comment. "
									+ "We'll get back to you shortly.", 
							"ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
		}
		if(e.getSource().equals(helpBtn)) {
	        JOptionPane.showMessageDialog(workSpaceDesktop, helpinfo, "HELP",
	                JOptionPane.INFORMATION_MESSAGE, helpIcon);
		}
		
	}
	
	private void openStudentMain() {
		workSpaceDesktop.removeAll();
		workSpaceDesktop.updateUI();
		
		JInternalFrame currFrame = null;
		currFrame = new StudentMain(workSpaceDesktop);
		workSpaceDesktop.add(currFrame);

		//Opens JinternalFrame centered in the JDesktopPane
		Dimension desktopSize = workSpaceDesktop.getSize();
		Dimension jInternalFrameSize = currFrame.getSize();
		
		//Test if current internal frame is of class AddIssue and renders the frame with that
		if(currFrame.getClass() == 	StudentMain.class){
			currFrame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
			    (desktopSize.height- jInternalFrameSize.height)/2);
		}
	}
	
	public void getInformation() {
		issueID_lbl.setText(issueID);
		studentID_lbl.setText(student.getID());
		studentName_lbl.setText(student.getFirstname() + " " + student.getLastname());
		email_lbl.setText(student.getEmail());
		contactNo_lbl.setText(student.getPhone());
		
		issueDetails = IssueController.viewSpecific(issueID);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String issuedAt = sdf.format(issueDetails.getIssuedAt());
		
		StudentServicesRep rep = UserController.getRep(issueDetails.getRepID());
		representativeName_lbl.setText(rep.getFirstname() + " " + rep.getLastname());
		
		if(issueDetails!=null) {
			
			type_label.setText("Type: "+ issueDetails.getType());
			services_lbl.setText("Service: "+ serviceTypes.get(issueDetails.getServiceID()-1) );
			issueMessage_txtArea.setText( issueDetails.getMessage());
			issuedAt_lbl.setText( new SimpleDateFormat("dd-MM-yyyy").format(issueDetails.getIssuedAt()) );
		}
		
		rep = UserController.getRep(issueDetails.getRepID());
		issueResponse = ResponseController.getResponseUsingIssue(issueID);
		
		if(issueResponse != null) {
			//RESPONSE Information
			response.isAnswer_chckbx.setSelected(issueResponse.isAnswer() );
	
			String respondedOn = sdf.format(issueResponse.getResponseAt());
			response.respondDate_lbl.setText(respondedOn);
			response.responseMessage_txtArea.setText(issueResponse.getMessage());
			response.commentMessage_textArea.setText(issueResponse.getComment());
			tabbedPane.addTab(issueResponse.getResponseID(), response);
			response.isAnswer_chckbx.setEnabled(true);
		
		}else{
			JOptionPane.showMessageDialog(workSpaceDesktop, 
					"THERE ARE NO RESPONSE POSTED FOR THIS ISSUE", 
					"NO RECORDS FOUND",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public boolean  isPostComment() {
		boolean updatedResponseSuccess = false;
		
		updatedResponseSuccess = ResponseController.updateComment(issueID, response.commentMessage_textArea.getText()  );
		if(updatedResponseSuccess) 
			return true;
		
		return false;
	}

}