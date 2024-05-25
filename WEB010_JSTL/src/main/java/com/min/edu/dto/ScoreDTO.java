package com.min.edu.dto;

public class ScoreDTO {
	private String name;
	private int kor;
	private int math;
	private int eng;
	private String firstName;
	
	
	public ScoreDTO() {
		super();
	}
	
	@Override
	public String toString() {
		return "ScoreDTO [name=" + name + ", kor=" + kor + ", math=" + math + ", eng=" + eng + ", firstName="
				+ firstName + "]";
	}
	
	public ScoreDTO(String name, int kor, int math, int eng, String firstName) {
		super();
		this.name = name;
		this.kor = kor;
		this.math = math;
		this.eng = eng;
		this.firstName = firstName;
	}

	public String getName() {
		return name;
	}

	public int getKor() {
		return kor;
	}

	public int getMath() {
		return math;
	}

	public int getEng() {
		return eng;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
}
