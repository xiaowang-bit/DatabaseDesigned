package com.wax.model;

public class Teacher {
	private String tea_id;
	private String tea_name;
	private String tea_sex;
	private String tea_academy;
	private String tea_title;
	private String tea_phone;
	private String tea_email;
	private String tea_pwd;
	public String getTea_id() {
		return tea_id;
	}
	public void setTea_id(String tea_id) {
		this.tea_id = tea_id;
	}
	public String getTea_name() {
		return tea_name;
	}
	public void setTea_name(String tea_name) {
		this.tea_name = tea_name;
	}
	public String getTea_sex() {
		return tea_sex;
	}
	public void setTea_sex(String tea_sex) {
		this.tea_sex = tea_sex;
	}
	public String getTea_academy() {
		return tea_academy;
	}
	public void setTea_academy(String tea_academy) {
		this.tea_academy = tea_academy;
	}
	public String getTea_title() {
		return tea_title;
	}
	public void setTea_title(String tea_title) {
		this.tea_title = tea_title;
	}
	public String getTea_phone() {
		return tea_phone;
	}
	public void setTea_phone(String tea_phone) {
		this.tea_phone = tea_phone;
	}
	public String getTea_email() {
		return tea_email;
	}
	public void setTea_email(String tea_email) {
		this.tea_email = tea_email;
	}
	public String getTea_pwd() {
		return tea_pwd;
	}
	public void setTea_pwd(String tea_pwd) {
		this.tea_pwd = tea_pwd;
	}
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teacher(String tea_id, String tea_name, String tea_sex, String tea_academy, String tea_title,
			String tea_phone, String tea_email, String tea_pwd) {
		super();
		this.tea_id = tea_id;
		this.tea_name = tea_name;
		this.tea_sex = tea_sex;
		this.tea_academy = tea_academy;
		this.tea_title = tea_title;
		this.tea_phone = tea_phone;
		this.tea_email = tea_email;
		this.tea_pwd = tea_pwd;
	}
	@Override
	public String toString() {
		return "Teacher [tea_id=" + tea_id + ", tea_name=" + tea_name + ", tea_sex=" + tea_sex + ", tea_academy="
				+ tea_academy + ", tea_title=" + tea_title + ", tea_phone=" + tea_phone + ", tea_email=" + tea_email
				+ ", tea_pwd=" + tea_pwd + "]";
	}
	
}
