package bangDice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class playerProfileCreator
{
	private String username;
	private String password;
	private Scanner verify;
	
	
	public void setUsername(String username)
	   {
	      this.username = username;       
	   }
	   

	
	public void setPassword(String password)
	   {
	      this.password = password;       
	   }
	   
	
	public void createProfile()
	   {
	      try(FileWriter newP = new FileWriter("res/playerProfiles.txt", true))
	      {
	         BufferedWriter t = new BufferedWriter(newP);
	         t.write(username + ",");
	         t.write(password);
	         t.newLine();
	         t.close();
	      }
	      catch (IOException e)
	      {
	         System.out.printf("ERROR: %s\n", e);
	      }
	      
	   }

	 public boolean Check()
	   {
	      boolean registered = false;
	      String inUsername;
	      
	      try
	      {
	         verify = new Scanner(new File("res/playerProfiles.txt"));
	         verify.useDelimiter("[, \n]");
	         
	         while (verify.hasNext() && !registered)
	         {
	            inUsername = verify.next();
	            
	            if (inUsername.trim().equals(this.username.trim()))
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
	      
	      return registered;

	   }

}
