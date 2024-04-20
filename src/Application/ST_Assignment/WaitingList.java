package ST_Assignment;

import java.util.*;

public class WaitingList {
	ArrayList<String> VIP = new ArrayList<String>();
	ArrayList<String> member = new ArrayList<String>();
	ArrayList<String> normal = new ArrayList<String>();
	
	String memberType;
	//Booking booking = new Booking();
	User user = new User();
	int userID;
	
	
	public void addWaiting() {
		
	}
	
	public void getWaiting() {
		userID = user.getUserID(memberType);
		
	}
	
	public void removeWaiting() {
		
	}
	

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	
	
	
}