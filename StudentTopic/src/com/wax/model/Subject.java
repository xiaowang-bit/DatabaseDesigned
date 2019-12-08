package com.wax.model;

public class Subject {
	private String topic_id;
	private String topic_name;
	private String topic_content;
	private String topic_tea_id;
	private String topic_tea_name;
	private String topic_course;
	private String topic_academy;
	private String topic_limit_stu;
	private String topic_semater;
	public String getTopic_id() {
		return topic_id;
	}
	public void setTopic_id(String topic_id) {
		this.topic_id = topic_id;
	}
	public String getTopic_name() {
		return topic_name;
	}
	public void setTopic_name(String topic_name) {
		this.topic_name = topic_name;
	}
	public String getTopic_content() {
		return topic_content;
	}
	public void setTopic_content(String topic_content) {
		this.topic_content = topic_content;
	}
	public String getTopic_tea_id() {
		return topic_tea_id;
	}
	public void setTopic_tea_id(String topic_tea_id) {
		this.topic_tea_id = topic_tea_id;
	}
	public String getTopic_tea_name() {
		return topic_tea_name;
	}
	public void setTopic_tea_name(String topic_tea_name) {
		this.topic_tea_name = topic_tea_name;
	}
	public String getTopic_course() {
		return topic_course;
	}
	public void setTopic_course(String topic_course) {
		this.topic_course = topic_course;
	}
	public String getTopic_academy() {
		return topic_academy;
	}
	public void setTopic_academy(String topic_academy) {
		this.topic_academy = topic_academy;
	}
	public String getTopic_limit_stu() {
		return topic_limit_stu;
	}
	public void setTopic_limit_stu(String topic_limit_stu) {
		this.topic_limit_stu = topic_limit_stu;
	}
	public String getTopic_semater() {
		return topic_semater;
	}
	public void setTopic_semater(String topic_semater) {
		this.topic_semater = topic_semater;
	}
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Subject [topic_id=" + topic_id + ", topic_name=" + topic_name + ", topic_content=" + topic_content
				+ ", topic_tea_id=" + topic_tea_id + ", topic_tea_name=" + topic_tea_name + ", topic_course="
				+ topic_course + ", topic_academy=" + topic_academy + ", topic_limit_stu=" + topic_limit_stu
				+ ", topic_semater=" + topic_semater + "]";
	}
	public Subject(String topic_id, String topic_name, String topic_content, String topic_tea_id, String topic_tea_name,
			String topic_course, String topic_academy, String topic_limit_stu, String topic_semater) {
		super();
		this.topic_id = topic_id;
		this.topic_name = topic_name;
		this.topic_content = topic_content;
		this.topic_tea_id = topic_tea_id;
		this.topic_tea_name = topic_tea_name;
		this.topic_course = topic_course;
		this.topic_academy = topic_academy;
		this.topic_limit_stu = topic_limit_stu;
		this.topic_semater = topic_semater;
	}
	
}
