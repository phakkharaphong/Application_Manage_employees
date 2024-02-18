package org.openjfx.Pro_002;

public class user {
	private String id;
	private String Fname;
	private String Lname;
	private int Salary;
	private String Email;
	public user(String newId , String newFname , String newLname,int newSalary , String newemail) {
		this.id= newId;
		this.Fname = newFname;
		this.Lname = newLname;
		this.Email = newemail;
		this.Salary = newSalary;
	}
	public String getId() {
		  return id;
	  }
	public String getFname() {
		return Fname;
	}
	public String getLname() {
		return Lname;
	}
	public String getEmail() {
		return Email;
	}
	public int getSalary() {
		return Salary;
	}
	public void setId(String newid) {
		  this.id=newid;
	  }
	public void setFname(String newFname) {
		this.Fname = newFname;
	}
	public void setLname(String newLname) {
		this.Lname = newLname;
	}
	public void setEmail(String newemail) {
		this.Email = newemail;
	}
	public void setSalary(int newSalary) {
		this.Salary = newSalary;
	}

	public String toString() {
		  return "Id:"+id+"Fname : "+Fname + " Lname: "+ Lname + " Email : " + Email + " Salary : "  + Salary;
	  }

}
