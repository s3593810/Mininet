
package socialNetwork;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Scanner;

public class Driver {
	
	private String name;
	private int age;
	private String gender;
	private String image;
	public String status;
	private String parent1Name;
	private String parent2Name;
	int count=0;
	Person [] user=new Person [100];
	
	private FileReader fr;
    private BufferedReader br;
    private FileWriter fw;
    private BufferedWriter bw;
    
	//Adult a1=new Adult(name,age,gender,image,status);
	//Children a2=new Children(name,age,gender,image,status,"A","B");
	/*public Driver(String name, int age,String gender, String image, String status)
	{
		this.name=name;
		this.age=age;
		this.gender=gender;
		this.image=image;
		this.status=status;1
	}*/
	
	public void Writer() {
//		try {
//			FileWriter Input=new FileWriter("C:\\CodeRepository\\social network\\src\\socialNetwork\\user.txt");
//			PrintWriter Print= new PrintWriter(Input);
//			
//			System.out.println(user.toString());
//			Print.println(user[count].toString());
//			Print.close();
//		}
//		catch(IOException e) {
//			System.out.println("Error!!");
//			
//		}
		String s;
		 try
	        {
	            fw=new FileWriter("C:\\\\CodeRepository\\\\social network\\\\src\\\\socialNetwork\\\\user.txt", true);
	            bw=new BufferedWriter(fw);

	            try
	            {
	                fr=new FileReader("C:\\\\CodeRepository\\\\social network\\\\src\\\\socialNetwork\\\\user.txt");
	                br=new BufferedReader(fr);

	                while((s=br.readLine())!=null)
	                {
	                    
	                    bw.write(user[count].toString());
	                }
	            }
	            catch(FileNotFoundException e)
	            {
	                System.out.println("File was not found!");
	            }
	            catch(IOException e)    
	            {
	                System.out.println("No file found!");
	            }

	            bw.close();
	        }
	        catch(FileNotFoundException e)
	        {
	            System.out.println("Error1!");
	        }
	        catch(IOException e)    
	        {
	            System.out.println("Error2!");
	        }
	}
	public void Reader() {
		try {
			FileReader Read = new FileReader("C:\\\\CodeRepository\\\\social network\\\\src\\\\socialNetwork\\\\user.txt");
			BufferedReader Reader1=new BufferedReader(Read);
			String S;
			while ((S=Reader1.readLine()) !=null) {
				System.out.println(S+"\n");
			}
			Reader1.close();
		}
		catch(IOException e) {
			System.out.println("File Not Found!!");
		}
	}
	

	public void print()
	{
		for(int i=0;i<user.length;i++)
		{
			if(i!=count)	 
			 System.out.println(user[i].getName());
			else
			break;
		}
		
	}
	
	public  void menu() 
		{
		
		System.out.println( "MiniNet Menu");
		System.out.println("=========================");
		System.out.println("1. list everyone");
		System.out.println("2. Select a person");
		System.out.println("3. Are these two direct friends");
		System.out.println("4. .........");
		System.out.println("5. Exit");
		System.out.println("Please choose one of the above options: " );
		Scanner choice = new Scanner(System.in);
		 int choose =choice.nextInt();
		 while(choose < 1 || choose >5)
		 try
		 {
			System.out.println("Enter your Choice "); 
			choose =choice.nextInt();
		 }catch(NumberFormatException e)
		 {
			 System.out.println("Invalid selection, please try again");
		 }
		 
		
		 switch (choose)
		      {
		 case 1: 
			 int ch;
			 System.out.println("1.1 Adult");
			 System.out.println("1.2 Dependent");
			 ch=choice.nextInt();
			 if(ch==1)
			 {
			user[count]=new Adult(name,age,gender,image,status);
			user[count].addPerson();
			System.out.println(user[count].toString());
			//Writer();
			 count++;
			 }
			 else
			 {
				 user[count]=new Children(name,age,gender,image,status,parent1Name,parent2Name);
				user[count].profile();
				 count++;
			 }
			 menu();
	       break;
		 case 2: Reader(); 
			// print();
		// user[count].addFriend();
		 menu();
		 
	       break;
		 case 3: for (int i = 0; i <count ; i++)
		 { if (user[i] instanceof Children)
				// user[i].addFriend();
		 System.out.println(user[i].getName());
		 		 }
		 menu();
	       break;
	        case 4:System.out.println(user[count].getName());
	        break;
	        case 5 : 
	        System.out.println("You exited from the network, See you soon");
	        System.exit(0);
	        break;
		      }
		 	}
		}
