package com.lee.jscbpm2.member;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Member {

	private String jm_id;
	private String jm_pw;
	private String jm_name;
	private String jm_addr1;
	private String jm_addr2;
	private String jm_addr3;
	private String jm_photo;
	
	private String autoLogin;
	
	public Member() {super();}

	public Member(String jm_id, String jm_pw, String jm_name, String jm_addr1, String jm_addr2,
			String jm_addr3, String jm_photo, String autoLogin) {
		super();
		this.jm_id = jm_id;
		this.jm_pw = jm_pw;
		this.jm_name = jm_name;
		this.jm_addr1 = jm_addr1;
		this.jm_addr2 = jm_addr2;
		this.jm_addr3 = jm_addr3;
		this.jm_photo = jm_photo;
		this.autoLogin = autoLogin;
	}

	public String getJm_id() {
		return jm_id;
	}
	@XmlElement
	public void setJm_id(String jm_id) {
		this.jm_id = jm_id;
	}

	public String getJm_pw() {
		return jm_pw;
	}
	@XmlElement
	public void setJm_pw(String jm_pw) {
		this.jm_pw = jm_pw;
	}

	public String getJm_name() {
		return jm_name;
	}
	@XmlElement
	public void setJm_name(String jm_name) {
		this.jm_name = jm_name;
	}

	public String getJm_addr1() {
		return jm_addr1;
	}
	@XmlElement
	public void setJm_addr1(String jm_addr1) {
		this.jm_addr1 = jm_addr1;
	}

	public String getJm_addr2() {
		return jm_addr2;
	}
	@XmlElement
	public void setJm_addr2(String jm_addr2) {
		this.jm_addr2 = jm_addr2;
	}

	public String getJm_addr3() {
		return jm_addr3;
	}
	@XmlElement
	public void setJm_addr3(String jm_addr3) {
		this.jm_addr3 = jm_addr3;
	}

	public String getJm_photo() {
		return jm_photo;
	}
	@XmlElement
	public void setJm_photo(String jm_photo) {
		this.jm_photo = jm_photo;
	}

	public String getAutoLogin() {
		return autoLogin;
	}
	@XmlElement
	public void setAutoLogin(String autoLogin) {
		this.autoLogin = autoLogin;
	}
	
}
