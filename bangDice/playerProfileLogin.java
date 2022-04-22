package bangDice;

import java.io.File;
import java.util.Scanner;

public class playerProfileLogin 
{
	 private static Scanner verify;
	 private String username;
	 private String password;
	 
	 public void setUsername(String username)
	   {
	      this.username = username;       
	   }
	 
	 
	 public void setPassword(String password)
	   {
	      this.password = password;       
	   }

		public void Validate()
		   {
		      boolean registered = false;
		      String inUsername;
		      String inPassword;
		      
		      try
		      {
		         verify = new Scanner(new File("res/playerProfiles.txt"));
		         verify.useDelimiter("[, \n]");
		         
		         while (verify.hasNext() && !registered)
		         {
		            inUsername = verify.next();
		            inPassword = verify.next();
		            
		            if (inUsername.trim().equals(this.username.trim()) &&
		            		inPassword.trim().equals(this.password.trim()))
		            {
		               registered = true;
		            }         
		                        
		         }
		         verify.close();
		      }
		      catch(Exception e)
		      {
		         System.out.println("User not found!");
		      }
		      
		      if (registered)
		      {
		         System.out.println("Welcome " + this.username);
		      }
		      else
		      {
		         System.out.println("Wrong username or password.");
		      }
	}

}
