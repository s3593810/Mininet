package socialNetwork;
import java.io.*;
import java.lang.*;
import java.util.*;

public class Read_WriteFile {
	private Formatter file;
	public void openFile()
	{
		try {
		file=new Formatter("Social Network.xls");
		}catch (Exception e) {
			System.out.println("You hava an error");
		}
	}
		public void closeFile()
		{
			file.close();
		}
	
}

	
		


