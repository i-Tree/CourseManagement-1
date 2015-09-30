package com.javen.entity;


public class StuEntity {
	

	private String grade;
	private String majar;
    private String majarnum;
    private String coursename;
    private String coursetype;
    private String credit;
    private String classhour;
    private String labhour;
    private String computerhour;
    private String date;
    private String teacher;
    private String notice;
   
	
    public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getMajar() {
		return majar;
	}
	public void setMajar(String majar) {
		this.majar = majar;
	}
	public String getMajarnum() {
		return majarnum;
	}
	public void setMajarnum(String majarnum) {
		this.majarnum = majarnum;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getCoursetype() {
		return coursetype;
	}
	public void setCoursetype(String coursetype) {
		this.coursetype = coursetype;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getClasshour() {
		return classhour;
	}
	public void setClasshour(String classhour) {
		this.classhour = classhour;
	}
	public String getLabhour() {
		return labhour;
	}
	public void setLabhour(String labhour) {
		this.labhour = labhour;
	}
	public String getComputerhour() {
		return computerhour;
	}
	public void setComputerhour(String computerhour) {
		this.computerhour = computerhour;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}

    
    public StuEntity() {
    }
    public StuEntity(String grade,String majar,String majarnum,String coursename,String coursetype,String credit,String classhour,String labhour,String computerhour,String date,String teacher,String notice) 
    {
        this.grade = grade;
        this.majar = majar;
        this.majarnum = majarnum;
        this.coursename = coursename;
        this.coursetype=coursetype;
        this.credit=credit;
        this.classhour=classhour;
        this.labhour=labhour;
        this.computerhour=computerhour;
        this.date=date;
        this.teacher=teacher;
        this.notice=notice;
        
    }
    
    @Override
    public String toString() {
        return "StuEntity [grade=" + grade + ", majar=" + majar + ", majarnum=" + majarnum + ", coursename=" + coursename + ",coursetype=" + coursetype + ",credit=" + credit + ",classhour=" + classhour + ",labhour=" + labhour + ",computerhour=" + computerhour + ",date=" + date + ",teacher=" + teacher + ",notice=" + notice + "]";
    }
 
    
    
}