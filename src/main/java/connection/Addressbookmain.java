package connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Addressbookmain {

	public static void main(String[] args) throws IOException {
	
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
		
			System.out.println("press 1 to add contact");
			System.out.println("press 2 to delete contact");
			System.out.println("press 3 to display contact");
			System.out.println("press 4 to update contact");
			System.out.println("press 5 to  exit ");
			int c=Integer.parseInt(br.readLine());
			
			if(c==1)
			{
				
				System.out.println("enter user firstname :");
				String fname =br.readLine();
				System.out.println("enter user lastname :");
				String lname =br.readLine();
				System.out.println("enter user address :");
				String addres =br.readLine();
				System.out.println("enter user city :");
				String citys =br.readLine();
				System.out.println("enter user state :");
				String states =br.readLine();
				System.out.println("enter user email :");
				String emails =br.readLine();
				System.out.println("enter user zip :");
				String pin =br.readLine();
				System.out.println("enter user phone_number :");
				String phoneno =br.readLine();
				
				PersonData persondata= new PersonData(fname, lname, addres, citys, states, emails, pin, phoneno);
				boolean answer = Addressbookdatabase.insertstudenttoDB(persondata);
				if(answer) {
					
					System.out.println("contact is added succesfully");
				}
				else {
					
					System.out.println("something went wrong try again...");
				}
				System.out.println(persondata);
				
			} else if (c==2) 
			{
				System.out.println("enter student id to delete :");
				int userID = Integer.parseInt(br.readLine());
				boolean f = Addressbookdatabase.deleteperson(userID);
			if(f) {
					
					System.out.println("contact is deleted succesfully");
				}
				else {
					
					System.out.println("something went wrong try again...");
				}
			
			} else if (c==3) 
			{
				Addressbookdatabase.showcontact();
				
			} else if (c==4)
			{
				
				System.out.println("enter student id to update :");
				int id = Integer.parseInt(br.readLine());
				
				System.out.println("enter user firstname :");
				String fname =br.readLine();
				System.out.println("enter user lastname :");
				String lname =br.readLine();
				System.out.println("enter user address :");
				String addres =br.readLine();
				System.out.println("enter user city :");
				String citys =br.readLine();
				System.out.println("enter user state :");
				String states =br.readLine();
				System.out.println("enter user email :");
				String emails =br.readLine();
				System.out.println("enter user zip :");
				String pin =br.readLine();
				System.out.println("enter user phone_number :");
				String phoneno =br.readLine();
				PersonData persondata= new PersonData(fname, lname, addres, citys, states, emails, pin, phoneno);
				boolean f = Addressbookdatabase.updatedperson(id, persondata);
				if(f) {
					
						System.out.println("contact is updated succesfully");
					}
				else {
					
						System.out.println("something went wrong try again...");
					}
				
				} else if(c==5) {
				
					break;
				} else {
				
						System.out.println("you choose wrong option please choose correct option");
				}
			}
			System.out.println("thank you...!");
	}
}
