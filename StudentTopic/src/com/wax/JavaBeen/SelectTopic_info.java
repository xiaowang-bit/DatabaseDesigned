package com.wax.JavaBeen;

public class SelectTopic_info {
	private String st_semater  ;
	private String st_topic_id   ;
	private String st_tea_id   ;
	private String st_stu_id   ;
	private String st_team_id   ;
	private String st_stu_check   ;
	private String st_checked   ;
	public SelectTopic_info() {
		super();
	}
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

	public SelectTopic_info(String st_semater, String st_topic_id, String st_tea_id, String st_stu_id,
			String st_team_id, String st_stu_check, String st_checked) {
		super();
		this.st_semater = st_semater;
		this.st_topic_id = st_topic_id;
		this.st_tea_id = st_tea_id;
		this.st_stu_id = st_stu_id;
		this.st_team_id = st_team_id;
		this.st_stu_check = st_stu_check;
		this.st_checked = st_checked;
	}
	@Override
	public String toString() {
		return "SelectTopic_info [st_semater=" + st_semater + ", st_topic_id=" + st_topic_id + ", st_tea_id="
				+ st_tea_id + ", st_stu_id=" + st_stu_id + ", st_team_id=" + st_team_id + ", st_stu_check="
				+ st_stu_check + ", st_checked=" + st_checked + "]";
	}
	public String getSt_tea_id() {
		return st_tea_id;
	}
	public void setSt_tea_id(String st_tea_id) {
		this.st_tea_id = st_tea_id;
	}

	public String getSt_checked() {
		return st_checked;
	}
	public void setSt_checked(String st_checked) {
		this.st_checked = st_checked;
	}
	public String getSt_stu_check() {
		return st_stu_check;
	}
	public void setSt_stu_check(String st_stu_check) {
		this.st_stu_check = st_stu_check;
	}
	public String getSt_team_id() {
		return st_team_id;
	}
	public void setSt_team_id(String st_team_id) {
		this.st_team_id = st_team_id;
	}
	public String getSt_stu_id() {
		return st_stu_id;
	}
	public void setSt_stu_id(String st_stu_id) {
		this.st_stu_id = st_stu_id;
	}
}
