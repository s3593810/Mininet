package socialNetwork;
/**
 * MiniNet class
 * contains main method that display menu,
 * read user selection and process it
 */
/**
 * 
 * @author Md Shakil Khan and Ali Abdullah A Alahmari
 *
 */

public class Driver {
	
	/**
	 * social network
	 */
	private static SocialNetworkInf socialNetwork = new Network();
	
	//selected profile
	private static Profile selectedProfile;
	
	/**
	 * select profile
	 */
	private static void selectPerson(){
		
		//prompt for name
		String name = Relationship.readString("Please enter the name: ");
		
		//retrieve profile
		Profile profile = socialNetwork.getProfile(name);
		if (profile != null){
			selectedProfile = profile;
			System.out.println("The profile has been selected");
		}else{
			System.out.println("The name not found!");
		}
	}
	
	/**
	 * display main menu and return
	 * user selection
	 * @return user selection
	 */
	private static int menu(){
		
		System.out.println("1. List everyone");
		System.out.println("2. Select a person");
		System.out.println("3. Display the profile of the selected person");
		System.out.println("4. Update the profile information of the selected person");
		System.out.println("5. Add a person into the network");
		System.out.println("6. Delete the selected person");
		System.out.println("7. Connect persons in a meaningful way e.g. friend, spouse, parent");
		System.out.println("8. Find out whether a person is a direct friend of another person");
		System.out.println("9. Find out names(s) of a person's child(ren) or then names of the parents");
		System.out.println("0. Exit");
		
		return Relationship.readInt("Enter an options: ", 0, 9);
	}
	
	/**
	 * add person to network
	 */
	private static void addPerson(){
		//prompt for name
		String name = Relationship.readString("Please enter the name: ");
		
		//retrieve profile
		Profile profile = socialNetwork.getProfile(name);
		if (profile == null){
			
			char gender = Relationship.readGender();
			int age = Relationship.readInt("Please enter the age: ", 1, 120);
			
			if (!Relationship.isAdult(age)){
				
				//must choose parent
				String mother = Relationship.readString("Please enter the name of mother or father: ");
				Profile motherPro = socialNetwork.getProfile(mother);
				
				if (motherPro == null){
					System.out.println("The mother/father not found!");
					return;
				}
				
				if (!Relationship.isAdult(motherPro.getAge())){
					System.out.println("The mother/father is not adult");
					return;
				}
				
				if (motherPro.getSpouse() != null){
					System.out.println("The mother/father has no spouse!");
					return;
				}
				
				socialNetwork.addChild(motherPro, profile);
				socialNetwork.addChild(motherPro.getSpouse(), profile);
			}
			
			socialNetwork.addProfile(new Profile(name, gender, age));
			
		}else{
			System.out.println("The name existing!");
		}
	}
	/**
	 * main method to start Java application
	 * @param args
	 */
	public static void Data() {

		//display main menu and get user selection
		int selection = menu();

		//process until user wants to exit
		while (selection != 0){
			
			switch (selection) {
			case 1://List everyone
				
				System.out.println("Everyone in the networks");
				System.out.println(socialNetwork.listEveryone());
				
				break;
				
			case 2://Select a person
				selectPerson();
				break;
				
			case 3://Display the profile of the selected person
				if (selectedProfile == null){
					System.out.println("Please select a person");
				}else{
					System.out.println(selectedProfile);//this calls toString
				}
				break;
			case 4://Update the profile information of the selected person
				if (selectedProfile == null){
					System.out.println("Please select a person");
				}else{
					editProfile();
				}
				break;
			case 5://Add a person into the network
				addPerson();
				
				break;
			case 6://Delete the selected person
				
				deletePerson();
				
				break;
			case 7://Connect persons in a meaningful way e.g. friend, spouse, parent
				
				connectPersons();
				
				break;
			case 8://Find out whether a person is a direct friend of another person
				findoutDirectFriends();
				
				break;
			case 9://Find out names(s) of a person's child(ren) or then names of the parents
				
				if (selectedProfile == null){
					System.out.println("Please select a person");
				}else{
					findoutChildrenAndParent();
				}				
				
				break;
			}
			
			System.out.println();
			
			//display main menu and get user selection
			selection = menu();
		}//end while
		
		System.out.println("\nThank you for using the application");
	}

	/**
	 * Find out whether a person is a direct friend of another person
	 */
	private static void findoutChildrenAndParent() {
		if (selectedProfile.getNumChildren() == 0){
			System.out.println("This person has no children");
		}else{
			System.out.println(socialNetwork.listChildren(selectedProfile));
		}
		
		String parent = socialNetwork.listParent(selectedProfile);
		if (parent.equals("")){
			System.out.println("This person has no parent");
		}else{
			System.out.println(parent);
		}
	}

	/**
	 * Find out names(s) of a person's child(ren) or then names of the parents
	 */
	private static void findoutDirectFriends() {
		//prompt for name1
		String name1 = Relationship.readString("Please enter the name of the first friend: ");
		
		//retrieve profile 1
		Profile profile1 = socialNetwork.getProfile(name1);
		
		if (profile1 == null){
			System.out.println("The name not found!");
			return;
		}
		
		//prompt for name2
		String name2 = Relationship.readString("Please enter the name of the second friend: ");

		if (name1.equalsIgnoreCase(name2)){
			System.out.println("Your entered same names!");
			return;
		}
		
		//retrieve profile 2
		Profile profile2 = socialNetwork.getProfile(name2);
		
		if (profile2 == null){
			System.out.println("The name not found!");
			return;
		}		
		
		if (socialNetwork.hasFriend(profile1, profile2)){
			System.out.println("They are direct friend");
		}else{
			System.out.println("They are NOT direct friends or NOT friends");
		}

	}

	/**
	 * connect friends
	 */
	private static void chooseFriend(){
		//prompt for name1
		String name1 = Relationship.readString("Please enter the name: ");
		
		//retrieve profile 1
		Profile profile1 = socialNetwork.getProfile(name1);
		
		if (profile1 == null){
			System.out.println("The name not found!");
			return;
		}
		
		//prompt for name2
		String name2 = Relationship.readString("Please enter the name: ");

		if (name1.equalsIgnoreCase(name2)){
			System.out.println("Your entered same names!");
			return;
		}
		
		if (profile1.getAge() <= 2){
			System.out.println("The person 2 years old or younger can not have friends");
			return;
		}
		
		//retrieve profile 2
		Profile profile2 = socialNetwork.getProfile(name2);
		
		if (profile2 == null){
			System.out.println("The name not found!");
			return;
		}
		
		if (profile2.getAge() <= 2){
			System.out.println("The person 2 years old or younger can not have friends");
			return;
		}
		
		if (socialNetwork.hasFriend(profile1, profile2)){
			System.out.println("They are friends already!");
			return;
		}
		
		if (!Relationship.isAdult(profile1.getAge()) && !Relationship.isAdult(profile2.getAge())){
			if (Math.abs(profile1.getAge() - profile2.getAge()) > 3){
				System.out.println("Young friends can not be more than 3 years");
				return;
			}
		}
		
		//add friend
		socialNetwork.addFriend(profile1, profile2);
		socialNetwork.addFriend(profile2, profile1);
	}
	
	/**
	 * connect spouse
	 */
	private static void connectSpouse(){
		//prompt for name1
		String name1 = Relationship.readString("Please enter the name of wife or husband: ");
		
		//retrieve profile 1
		Profile profile1 = socialNetwork.getProfile(name1);
		
		if (profile1 == null){
			System.out.println("The name not found!");
			return;
		}
		
		if (!Relationship.isAdult(profile1.getAge()) ){
			System.out.println("The spouse must be adult");
			return;
		}
		
		if (profile1.getSpouse() != null){
			System.out.println("This profile has spouse already");
			return;
		}
		
		//prompt for name2
		String name2 = Relationship.readString("Please enter the name of wife or husband: ");

		if (name1.equalsIgnoreCase(name2)){
			System.out.println("Your entered same names!");
			return;
		}
		
		//retrieve profile 2
		Profile profile2 = socialNetwork.getProfile(name2);
		
		if (profile2 == null){
			System.out.println("The name not found!");
			return;
		}			

		if (!Relationship.isAdult(profile2.getAge()) ){
			System.out.println("The spouse must be adult");
			return;
		}
		
		if (profile2.getSpouse() != null){
			System.out.println("This profile has spouse already");
			return;
		}
		
		if (profile1.getGender() == profile2.getGender()){
			System.out.println("The wife and husband must be diffrent genders");
			return;
		}
		
		//set spouse
		profile1.setSpouse(profile2);
		profile2.setSpouse(profile1);
	}
	
	/**
	 * add parent for profile
	 */
	private static void connectParent(){
		//prompt for name
		String name = Relationship.readString("Please enter the name: ");
		
		//retrieve profile
		Profile profile = socialNetwork.getProfile(name);
		if (profile == null){
			System.out.println("The name not found!");
			return;
		}

		//must choose parent
		String mother = Relationship.readString("Please enter the name of mother or father: ");
		Profile motherPro = socialNetwork.getProfile(mother);
		
		if (motherPro == null){
			System.out.println("The mother/father not found!");
			return;
		}
		if (!Relationship.isAdult(motherPro.getAge())){
			System.out.println("The mother/father is not adult");
			return;
		}
		
		if (motherPro.getSpouse() != null){
			System.out.println("The mother/father has no spouse!");
			return;
		}
		
		socialNetwork.addChild(motherPro, profile);
		socialNetwork.addChild(motherPro.getSpouse(), profile);
	}
	/**
	 * connect persons
	 */
	private static void connectPersons() {
		
		//choose relation
		String relation = Relationship.chooseRelation();
		
		if (relation.equalsIgnoreCase("friend")){
			
			chooseFriend();
			
		}else if (relation.equalsIgnoreCase("spouse")){
			
			connectSpouse();
			
		}else if (relation.equalsIgnoreCase("parent")){//parent
			
			connectParent();
		}
	}

	/**
	 * delete person
	 */
	private static void deletePerson() {
		//prompt for name
		String name = Relationship.readString("Please enter the name: ");
		
		//retrieve profile
		Profile profile = socialNetwork.getProfile(name);
		if (profile != null){
			
			socialNetwork.deleteProfile(profile);
			if (profile == selectedProfile){
				selectedProfile = null;
			}
		}else{
			System.out.println("The name not found!");
		}
	}

	/**
	 * edit profile
	 */
	private static void editProfile() {
		
		String status = Relationship.readString("Please enter status: ");
		selectedProfile.setStatus(status);
		System.out.println("Status has been updated");
	}

}
