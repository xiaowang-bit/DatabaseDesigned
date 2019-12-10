package com.wax.JavaBeen;

public class Team_info {
	private String team_name;
	private String team_report_status;
	private String team_id;
	public Team_info(String team_name, String team_report_status, String team_id) {
		super();
		this.team_name = team_name;
		this.team_report_status = team_report_status;
		this.team_id = team_id;
	}
	public Team_info() {
		super();
	}
	@Override
	public String toString() {
		return "Team_info [team_name=" + team_name + ", team_report_status=" + team_report_status + ", team_id="
				+ team_id + "]";
	}
	public String getTeam_id() {
		return team_id;
	}
	public void setTeam_id(String team_id) {
		this.team_id = team_id;
	}
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public String getTeam_report_status() {
		return team_report_status;
	}
	public void setTeam_report_status(String team_report_status) {
		this.team_report_status = team_report_status;
	}
	
}
