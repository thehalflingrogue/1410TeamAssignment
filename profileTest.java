package bangDice;

import java.util.Scanner;

public class profileTest
{

	public static void main(String[] args)
	{
		String username;
	      String password;
	      Scanner input = new Scanner(System.in);
	      playerProfileCreator newProfile = new playerProfileCreator();
	      playerProfileLogin log = new playerProfileLogin();
	      
	      int selection;
	      do
	      {
	         System.out.println("Type 1 to Log in, 2 to register, and 0 to exit");
	         selection = Integer.parseInt(input.nextLine());
	         
	         switch (selection)
	         {
	            case 1:
	               System.out.println("Enter username:");
	               username = input.nextLine();
	               log.setUsername(username);
	      
	               System.out.println("Enter password:");
	               password = input.nextLine();
	               log.setPassword(password);
	               
	               log.Validate();
	               break;
	               
	            case 2:
	               System.out.println("Enter username: (No commas allowed)" );
	               username = input.nextLine();
	               newProfile.setUsername(username);
	               ;
	               
	               if(!newProfile.Check())
	               {
	                  System.out.println("Enter password: (No commas allowed)");
	                  password = input.nextLine();
	                  newProfile.setPassword(password);
	                  newProfile.createProfile();
	               }
	               else
	               {
	                  System.out.println("The username is already taken.");
	               }

	               break;
	               
	            case 0:
	               System.out.println("Good Bye");
	               break;
	               
	            default:
	               System.out.println("Invalid option, Try again");
	               break;       
	                       
	         }
	      }
	      while(selection != 0);
	   }

}
