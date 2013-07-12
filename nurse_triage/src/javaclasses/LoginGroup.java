package javaclasses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ACT_ID_MEMBERSHIP")
public class LoginGroup{

	 @Id
	 @Column(name="USER_ID_")	
	 private String userId;
	 
	 @Column(name="GROUP_ID_")
	private String group;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}
	
		
	
}
