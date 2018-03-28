package socialNetwork;


/**
 * Profile presents a person in network
 */
/**
 * 
 * @author  Ali Abdullah A Alahmari
 *
 */

public class Profile {
	
	/**
	 * maximum number of friends or children
	 */
	private static final int MAX_FRIENDS = 100;
	
	/**
	 * name of a person
	 */
	private String name;
	
	/**
	 * status of profile
	 */
	private String status = "";
	
	/**
	 * status of picture
	 */
	private String picture = "";
	
	/**
	 * F or M
	 */
	private char gender;
	
	/**
	 * age
	 */
	private int age;
	
	/**
	 * array of friends
	 */
	private Profile[] friends = new Profile[MAX_FRIENDS];
	
	/**
	 * number of friends
	 */
	private int numFriends = 0;
	
	/**
	 * wife or husband
	 */
	private Profile spouse;
	
	/**
	 * array of child(ren)
	 */
	private Profile[] children = new Profile[MAX_FRIENDS];
	
	/**
	 * number of children
	 */
	private int numChildren = 0;
	
	/**
	 * constructor
	 * @param name name
	 * @param gender M or F
	 * @param age age
	 */
	public Profile(String name, char gender, int age) {
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	
	/**
	 * set spouse
	 * @param spouse spouse
	 */
	public void setSpouse(Profile spouse){
		this.spouse = spouse;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the gender
	 */
	public char getGender() {
		return gender;
	}

	/**
	 * @return the spouse
	 */
	public Profile getSpouse() {
		return spouse;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
		
	/**
	 * @return the numFriends
	 */
	public int getNumFriends() {
		return numFriends;
	}

	/**
	 * @return the numChildren
	 */
	public int getNumChildren() {
		return numChildren;
	}
	
	

	@Override
	public String toString() {
		String msg = "Name: " + name + "\nStatus: " + status;
		if (gender == 'M'){
			msg += "\nGender: male";
		}else{
			msg += "\nGender: Female";
		}
		msg += "\nAge: "+ age;
		if (spouse != null){
			msg += "\nSpouse: "+ spouse.getName();
		}
		if (numChildren > 0){
			msg += "\nChild(ren): ";
			for (int i = 0; i < numChildren; i++){
				msg += children[i].getName() + " ";
			}			
		}
		if (numFriends > 0){
			msg += "\nDirect friend(s): ";
			for (int i = 0; i < numFriends; i++){
				msg += friends[i].getName() + " ";
			}			
		}
		return msg;
	}

	/**
	 * @return the friends
	 */
	public Profile[] getFriends() {
		return friends;
	}

	/**
	 * @param friends the friends to set
	 */
	public void setFriends(Profile[] friends) {
		this.friends = friends;
	}

	/**
	 * @return the children
	 */
	public Profile[] getChildren() {
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void setChildren(Profile[] children) {
		this.children = children;
	}

	/**
	 * @param numFriends the numFriends to set
	 */
	public void setNumFriends(int numFriends) {
		this.numFriends = numFriends;
	}

	/**
	 * @param numChildren the numChildren to set
	 */
	public void setNumChildren(int numChildren) {
		this.numChildren = numChildren;
	}
	
	
}
