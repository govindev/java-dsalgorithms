package com.challenges.gfg.dream11;

public class Player {
	private String name;
	private float credits;
	private Type type;
	private float points;
	private float selectedBy;
	private int battingPosition;
	private Boolean isCaptain;
	private Boolean isViceCaptain;
	private float captainPercentage;
	private float viceCaptainPercentage;
	private int team;

	public int getTeam() {
		return team;
	}

	public void setTeam(int team) {
		this.team = team;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getCredits() {
		return credits;
	}

	public void setCredits(float credits) {
		this.credits = credits;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public float getPoints() {
		return points;
	}

	public void setPoints(float points) {
		this.points = points;
	}

	public int getBattingPosition() {
		return battingPosition;
	}

	public void setBattingPosition(int battingPosition) {
		this.battingPosition = battingPosition;
	}

	public float getSelectedBy() {
		return selectedBy;
	}

	public void setSelectedBy(float selectedBy) {
		this.selectedBy = selectedBy;
	}

	public Boolean getIsCaptain() {
		return isCaptain;
	}

	public void setIsCaptain(Boolean isCaptain) {
		this.isCaptain = isCaptain;
	}

	public Boolean getIsViceCaptain() {
		return isViceCaptain;
	}

	public void setIsViceCaptain(Boolean isViceCaptain) {
		this.isViceCaptain = isViceCaptain;
	}

	public float getCaptainPercentage() {
		return captainPercentage;
	}

	public void setCaptainPercentage(float captainPercentage) {
		this.captainPercentage = captainPercentage;
	}

	public float getViceCaptainPercentage() {
		return viceCaptainPercentage;
	}

	public void setViceCaptainPercentage(float viceCaptainPercentage) {
		this.viceCaptainPercentage = viceCaptainPercentage;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Name : " + name);
		sb.append(", Credits : " + credits);
		sb.append(", Type : " + type);
		sb.append(", Points : " + points);
		sb.append(", Batting Position : " + battingPosition);
		sb.append(", Selected By : " + selectedBy);
		sb.append(", Is Captain : " + isCaptain);
		sb.append(", Is Vice Captain : " + isViceCaptain);
		sb.append(", Captain Percentage : " + captainPercentage);
		sb.append(", Vice Captain Percentage : " + viceCaptainPercentage);
		return sb.toString();
	}

}
