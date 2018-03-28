package socialNetwork;
/**
 * social network
 * contains a collection of people
 * with relations
 *
 */
/**========
@author Md Shakil Khan
==========
*/

public class Network implements SocialNetworkInf{
	
	/**
	 * maximum number of people in network
	 */
	private static final int MAX_PEOPLE = 1000;
	
	/**
	 * array of profiles
	 */
	private static Profile[] profiles = new Profile[MAX_PEOPLE];
	
	/**
	 * number of profiles
	 */
	private int numProfiles = 0;
	
	public Network(){
		//add some items
		Profile tom = new Profile("tom", 'M', 25);
		Profile mary = new Profile("mary", 'F', 20);
		
		addProfile(tom);
		addProfile(mary);
		getProfile("tom").setSpouse(getProfile("mary"));
		getProfile("mary").setSpouse(getProfile("tom"));
		
		Profile peter = new Profile("peter", 'F', 2);
		addProfile(peter);

		addChild(getProfile("tom"), peter);
		addChild(getProfile("tom").getSpouse(), peter);
		
		Profile ron = new Profile("ron", 'F', 20);
		addProfile(ron);
		addFriend(ron, mary);
		
		//System.out.println(listParent(peter));
	}
	
	/**
	 * return a string that contains all profiles
	 * @return all profiles
	 */
	public String listEveryone(){
		
		String info = "";
		
		//iterate the array
		for (int i = 0; i < numProfiles; i++){
			info += profiles[i].getName() + "\n";
		}
		
		return info;
	}
	
	/**
	 * return a string that contains parent of profile
	 * @param child
	 * @return parent
	 */
	public String listParent(Profile child){
		
		//iterate the array
		for (int i = 0; i < numProfiles; i++){
			if (hasChild(profiles[i], child)){
				return profiles[i].getName() + " " + profiles[i].getSpouse().getName();
			}
		}
		
		return "";
	}
	
	/**
	 * get profile by name
	 * @param name profile name
	 * @return profile with name or null if not found
	 */
	public Profile getProfile(String name){
		
		//iterate the array
		for (int i = 0; i < numProfiles; i++){
			if (profiles[i].getName().equalsIgnoreCase(name)){
				return profiles[i];
			}
		}
		return null;//not found
	}
	

	/**
	 * add profile
	 * @param profile profile
	 */
	public void addProfile(Profile profile){
		profiles[numProfiles] = profile;
		numProfiles++;
	}

	/**
	 * delete profile
	 * @param profile
	 */
	public void deleteProfile(Profile profile) {
		
		//delete friend
		//iterate the array
		for (int i = 0; i < numProfiles; i++){
			deleteFriend(profiles[i], profile);
		}
		
		//delete spouse
		for (int i = 0; i < numProfiles; i++){
			if (profiles[i].getSpouse() == profile){
				deleteChildren(profiles[i]);
				profiles[i].setSpouse(null);
			}
		}
	}
	
	/**
	 * return a string that contains all children
	 * @param profile profile
	 * @return all children
	 */
	public String listChildren(Profile profile){
		
		String info = "";
		
		//iterate the array
		for (int i = 0; i < profile.getNumChildren(); i++){
			info += profile.getChildren()[i].getName() + "\n";
		}
		
		return info;
	}
	
	/**
	 * add friend
	 * @param profile profile
	 * @param friend friend
	 */
	public void addFriend(Profile profile, Profile friend){
		profile.getFriends()[profile.getNumFriends()] = friend;
		profile.setNumFriends(profile.getNumFriends() + 1);
	}
	
	/**
	 * check if friend
	 * @param profile profile
	 * @param friend friend
	 * @return true or false
	 */
	public boolean hasFriend(Profile profile, Profile friend){
		for (int i = 0; i < profile.getNumFriends(); i++){
			if (profile.getFriends()[i].getName().equalsIgnoreCase(friend.getName())){
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * check if has a specific child
	 * @param profile profile
	 * @param child child
	 * @return true or false
	 */
	public boolean hasChild(Profile profile, Profile child){
		for (int i = 0; i < profile.getNumChildren(); i++){
			if (profile.getChildren()[i]== child){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * delete friend
	 * @param profile profile
	 * @param friend friend
	 */
	public void deleteFriend(Profile profile, Profile friend){
		for (int i = 0; i < profile.getNumChildren(); i++){
			if (profile.getFriends()[i] == friend){

				for (int index = i; index < profile.getNumChildren() - 1; index++){
					profile.getFriends()[index] = profile.getFriends()[index + 1];
				}
				break;
			}
		}
	}
	/**
	 * delete children
	 */
	public void deleteChildren(Profile profile){
		profile.setNumChildren(0);
	}
	
	/**
	 * add child
	 * @param profile profile
	 * @param child child
	 */
	public void addChild(Profile profile, Profile child){
		profile.getChildren()[profile.getNumChildren()] = child;
		profile.setNumChildren(profile.getNumChildren() + 1);
	}
}
