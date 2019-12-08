package com.wax.model;

public class SelectSubject {
	private String st_semater;
	private String st_topic_id;
	private String st_topic_name;
	private String st_tea_id;
	private String st_tea_name;
	private String st_stu_id;
	private String st_stu_name;
	private String st_stu_check;
	private String st_checked;
	public String getSt_semater() {
		return st_semater;
	}
	public void setSt_semater(String st_semater) {
		this.st_semater = st_semater;
	}
	public String getSt_topic_id() {
		return st_topic_id;
	}
	public void setSt_topic_id(String st_topic_id) {
		this.st_topic_id = st_topic_id;
	}
	public String getSt_topic_name() {
		return st_topic_name;
	}
	public void setSt_topic_name(String st_topic_name) {
		this.st_topic_name = st_topic_name;
	}
	public String getSt_tea_id() {
		return st_tea_id;
	}
	public void setSt_tea_id(String st_tea_id) {
		this.st_tea_id = st_tea_id;
	}
	public String getSt_tea_name() {
		return st_tea_name;
	}
	public void setSt_tea_name(String st_tea_name) {
		this.st_tea_name = st_tea_name;
	}
	public String getSt_stu_id() {
		return st_stu_id;
	}
	public void setSt_stu_id(String st_stu_id) {
		this.st_stu_id = st_stu_id;
	}
	public String getSt_stu_name() {
		return st_stu_name;
	}
	public void setSt_stu_name(String st_stu_name) {
		this.st_stu_name = st_stu_name;
	}
	public String getSt_stu_check() {
		return st_stu_check;
	}
	public void setSt_stu_check(String st_stu_check) {
		this.st_stu_check = st_stu_check;
	}
	public String getSt_checked() {
		return st_checked;
	}
	public void setSt_checked(String st_checked) {
		this.st_checked = st_checked;
	}
	public SelectSubject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SelectSubject(String st_semater, String st_topic_id, String st_topic_name, String st_tea_id,
			String st_tea_name, String st_stu_id, String st_stu_name, String st_stu_check, String st_checked) {
		super();
		this.st_semater = st_semater;
		this.st_topic_id = st_topic_id;
		this.st_topic_name = st_topic_name;
		this.st_tea_id = st_tea_id;
		this.st_tea_name = st_tea_name;
		this.st_stu_id = st_stu_id;
		this.st_stu_name = st_stu_name;
		this.st_stu_check = st_stu_check;
		this.st_checked = st_checked;
	}
	@Override
	public String toString() {
		return "SelectSubject [st_semater=" + st_semater + ", st_topic_id=" + st_topic_id + ", st_topic_name="
				+ st_topic_name + ", st_tea_id=" + st_tea_id + ", st_tea_name=" + st_tea_name + ", st_stu_id="
				+ st_stu_id + ", st_stu_name=" + st_stu_name + ", st_stu_check=" + st_stu_check + ", st_checked="
				+ st_checked + "]";
	}
	
}
