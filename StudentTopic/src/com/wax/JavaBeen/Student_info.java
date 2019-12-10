package com.wax.JavaBeen;

public class Student_info {
	private String stu_id   ;
	private String stu_name   ;
	private String stu_class_id   ;
	private String stu_sex   ;
	private String stu_phone   ;
	private String stu_email   ;
	private String stu_pwd ;
	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public Student_info() {
		super();
	}
	@Override
	public String toString() {
		return "Student_info [stu_id=" + stu_id + ", stu_name=" + stu_name + ", stu_class_id=" + stu_class_id
				+ ", stu_sex=" + stu_sex + ", stu_phone=" + stu_phone + ", stu_email=" + stu_email + ", stu_pwd="
				+ stu_pwd + "]";
	}
	public Student_info(String stu_id, String stu_name, String stu_class_id, String stu_sex, String stu_phone,
			String stu_email, String stu_pwd) {
		super();
		this.stu_id = stu_id;
		this.stu_name = stu_name;
		this.stu_class_id = stu_class_id;
		this.stu_sex = stu_sex;
		this.stu_phone = stu_phone;
		this.stu_email = stu_email;
		this.stu_pwd = stu_pwd;
	}
	public String getStu_sex() {
		return stu_sex;
	}
	public void setStu_sex(String stu_sex) {
		this.stu_sex = stu_sex;
	}

	public String getStu_phone() {
		return stu_phone;
	}
	public void setStu_phone(String stu_phone) {
		this.stu_phone = stu_phone;
	}
	public String getStu_email() {
		return stu_email;
	}
	public void setStu_email(String stu_email) {
		this.stu_email = stu_email;
	}
	public String getStu_pwd() {
		return stu_pwd;
	}
	public void setStu_pwd(String stu_pwd) {
		this.stu_pwd = stu_pwd;
	}
	public String getStu_class_id() {
		return stu_class_id;
	}
	public void setStu_class_id(String stu_class_id) {
		this.stu_class_id = stu_class_id;
	}

}
