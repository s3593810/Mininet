package Assignment1;
import java.util.*;

import java.util.Scanner;

public abstract class User {
	
	private String Name;
	private int Age;
	private String Gender;
	private String Picture;
	private String Status;
	Scanner input=new Scanner(System.in);
	public User (String N, int A, String G, String P, String S) {
		this.Name=N;
		this.Age=A;
		this.Gender=G;
		this.Picture=P;
		this.Status=S;
	}
	
	public User (String N, int A, String G, String S) {
		this.Name=N;
		this.Age=A;
		this.Gender=G;
		this.Picture="null";
		this.Status=S;
	}
	
	public User (String N, int A, String G) {
		this.Name=N;
		this.Age=A;
		this.Gender=G;
		this.Picture="null";
		this.Status="null";
	}
	
	public String getName() {
		return Name;
	}
	
	public String setName() {
		
		System.out.println("Insert Your Name Please: ");
		return Name = input.nextLine();
	}
	
	public int setAge() {
		System.out.println("Insert Your Age Please: ");
		return Age = input.nextInt();
	}
	
	public String setGender() {
		System.out.println("Insert Your Gender Please: ");
		return Gender = input.nextLine();
	}
	
	public String setPicture() {
		System.out.println("Insert Your Picture Please: ");
		return Picture = input.nextLine();
	}
	
	public String setStatus() {
		System.out.println("Insert Your Status Please: ");
		return Status = input.nextLine();
	}
	
	public abstract void AddFriend();
	
	
}
