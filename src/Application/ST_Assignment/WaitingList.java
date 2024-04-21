package ST_Assignment;

import java.sql.*;
import java.util.*;

public class WaitingList {
	ArrayList<String> VIP = new ArrayList<String>();
	ArrayList<String> member = new ArrayList<String>();
	ArrayList<String> normal = new ArrayList<String>();
	
	String memberType;
	//Booking booking = new Booking();
	User user = new User();
	int userID;
	String fullName;
	
	public void addWaiting() {
		
	}
	
//	public void getWaiting() {
//		userID = user.getUserID();
//		String query = "SELECT fullName FROM user_account WHERE userID = ?";
//		try(PreparedStatement statement = connection.prepareStatement(query)) {
//			statement.setInt(1, userID);
//			
//			ResultSet resultSet = statement.executeQuery();
//			if(resultSet.next()) {
//				fullName = resultSet.getString("fullName");
//			}
//			
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//		
//	}
	
	public void removeWaiting() {
		
	}
	

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	
	
	
}