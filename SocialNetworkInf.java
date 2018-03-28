package socialNetwork;


/**
 * SocialNetworkInf is the interface that is implemented by SocialNetwork
 */

/**====
 * 
 * @author Md Shakil Khan
 *
 */
public interface SocialNetworkInf {
	/**
	 * return a string that contains all profiles
	 * @return all profiles
	 */
	public String listEveryone();
	/**
	 * return a string that contains parent of profile
	 * @param child
	 * @return parent
	 */
	public String listParent(Profile child);
	
	/**
	 * get profile by name
	 * @param name profile name
	 * @return profile with name or null if not found
	 */
	public Profile getProfile(String name);

	/**
	 * add profile
	 * @param profile profile
	 */
	public void addProfile(Profile profile);

	/**
	 * delete profile
	 * @param profile
	 */
	public void deleteProfile(Profile profile);
	
	/**
	 * return a string that contains all children
	 * @param profile profile
	 * @return all children
	 */
	public String listChildren(Profile profile);
	
	/**
	 * add friend
	 * @param profile profile
	 * @param friend friend
	 */
	public void addFriend(Profile profile, Profile friend);
	
	/**
	 * check if friend
	 * @param profile profile
	 * @param friend friend
	 * @return true or false
	 */
	public boolean hasFriend(Profile profile, Profile friend);
	
	
	/**
	 * check if has a specific child
	 * @param profile profile
	 * @param child child
	 * @return true or false
	 */
	public boolean hasChild(Profile profile, Profile child);
	
	/**
	 * delete friend
	 * @param profile profile
	 * @param friend friend
	 */
	public void deleteFriend(Profile profile, Profile friend);
	
	/**
	 * delete children
	 */
	public void deleteChildren(Profile profile);
	
	/**
	 * add child
	 * @param profile profile
	 * @param child child
	 */
	public void addChild(Profile profile, Profile child);
}
