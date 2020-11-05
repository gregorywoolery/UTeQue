package com.controller;

import com.model.Users;
import java.io.*;
import java.util.*;

public class UsersController {
	Users UsersObj = new Users();
	Date DateObj = new Date();
	private static Scanner input = new Scanner(System.in);
	
	@SuppressWarnings("deprecation")
	public void addUser() {
		try {
			System.out.println("Enter Type: ");
			UsersObj.setType(input.next());
			System.out.println("Enter ID: ");
			UsersObj.setID(input.next());
			System.out.println("Enter Password: ");
			UsersObj.setPassword(input.next());
			System.out.println("Enter First Name: ");
			UsersObj.setFname(input.next());
			System.out.println("Enter Last Name: ");
			UsersObj.setLname(input.next());
			System.out.println("Enter Gender: ");
			UsersObj.setGender(input.next());
			System.out.println("Enter Email: ");
			UsersObj.setEmail(input.next());
			System.out.println("Enter Date of Birth: ");
			System.out.println("dd: ");
			DateObj.setDate(input.nextInt());
			System.out.println("mm: ");
			DateObj.setMonth(input.nextInt());
			System.out.println("yyyy: ");
			DateObj.setYear(input.nextInt());
			UsersObj.setDob(DateObj);
			System.out.println("Enter Phone Number: ");
			UsersObj.setPhone(input.next());
		}catch(InputMismatchException e){
			System.err.println("Wrong input type entered");
		}
		
	}
	
	public void modifyUser() {
			
	}
	
	public void removeUser() {
		
	}
	
	public static void writeFunct(ArrayList<Users> UsersList) {
		try {
			//Open File
			FileOutputStream fos = new FileOutputStream("Users.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			//Write to File
			oos.writeObject(UsersList);
			
			//Close File
			oos.close();
			fos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Users> readFunct(){
		ArrayList<Users> UsersList = new ArrayList<Users>();

        try {
        	//Open Files
        	FileInputStream fis = new FileInputStream("Users.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
			
            // Read File
			UsersList = (ArrayList<Users>) ois.readObject();
			
			if(UsersList==null)
				System.out.println("****No Record Found****"+"\n");
			
			for (Users i : UsersList) {
	            System.out.println(i);
	        }
			//Close File
			ois.close();
			fis.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
       return UsersList;
		
	}

	
	

}
