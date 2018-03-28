package Assignment1;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User [] Input=new User[20];
		Input[0]=new Adult("Shakil", 25, "Male");
		Input[1]=new Adult("Ali", 26, "Male", "AliPicture", "RMIT Student");
		Input[2]=new Dependent("Sami", 13, "Male", "SamiPicture", "Student");
		Input[3]=new Dependent("Lisa", 12, "Female");
		
		for (int i=0;i<Input.length;i++) {
			System.out.println("Users List: "+Input[i]);
		}
	}
	
}

