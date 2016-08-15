package com.mickyli.rest.bean;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 注解“@XmlRootElement”，在将该类转化成XML时，说明这个是XML的根节点
 * @author liqian
 *
 */
@XmlRootElement
public class User {
	private String userId;
	private String userName;
	private String age;
	public User(){}
	public User(String userId, String userName, String age) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.age = age;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
}
