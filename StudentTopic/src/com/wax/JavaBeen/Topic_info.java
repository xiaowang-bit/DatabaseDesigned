package com.wax.JavaBeen;

public class Topic_info {
	private String topic_id  ;
	private String topic_name   ;
	private String topic_content   ;
	private String topic_tea_id   ;
	private String topic_course_id   ;
	private String topic_course   ;
	private String topic_limit_stu   ;
	public String getTopic_id() {
		return topic_id;
	}
	public Topic_info() {
		super();
	}
	public Topic_info(String topic_id, String topic_name, String topic_content, String topic_tea_id,
			String topic_course_id, String topic_course, String topic_limit_stu, String topic_semater) {
		super();
		this.topic_id = topic_id;
		this.topic_name = topic_name;
		this.topic_content = topic_content;
		this.topic_tea_id = topic_tea_id;
		this.topic_course_id = topic_course_id;
		this.topic_course = topic_course;
		this.topic_limit_stu = topic_limit_stu;
		this.topic_semater = topic_semater;
	}
	@Override
	public String toString() {
		return "Topic_info [topic_id=" + topic_id + ", topic_name=" + topic_name + ", topic_content=" + topic_content
				+ ", topic_tea_id=" + topic_tea_id + ", topic_course_id=" + topic_course_id + ", topic_course="
				+ topic_course + ", topic_limit_stu=" + topic_limit_stu + ", topic_semater=" + topic_semater + "]";
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
	
	public String getTopic_course() {
		return topic_course;
	}
	public void setTopic_course(String topic_course) {
		this.topic_course = topic_course;
	}
	public String getTopic_semater() {
		return topic_semater;
	}
	public void setTopic_semater(String topic_semater) {
		this.topic_semater = topic_semater;
	}
	public String getTopic_limit_stu() {
		return topic_limit_stu;
	}
	public void setTopic_limit_stu(String topic_limit_stu) {
		this.topic_limit_stu = topic_limit_stu;
	}
	public String getTopic_course_id() {
		return topic_course_id;
	}
	public void setTopic_course_id(String topic_course_id) {
		this.topic_course_id = topic_course_id;
	}
	private String topic_semater   ;

}
