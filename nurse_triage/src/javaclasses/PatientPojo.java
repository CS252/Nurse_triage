package javaclasses;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="patient")
public class PatientPojo {

	 @Id
	 @Column(name="patientsno")	
	 @GeneratedValue
	 private String serialno;
	 
	 public String getSerialno() {
		return serialno;
	}
	public String getPatientid() {
		return patientid;
	}
	public void setPatientid(String patientid) {
		this.patientid = patientid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Column(name="patientID")
	private String patientid;
	 @Column(name="firstname")
		private String firstname;
	 @Column(name="lastname")
		private String lastname;
	 @Column(name="dob")
		private String dob;
	 @Column(name="age")
		private String age;
	 @Column(name="email")
		private String email;
	 @Column(name="phoneno")
		private String phoneno;
	 @Column(name="address")
		private String address;
	 @Column(name="category")
		private String category;
	 @Column(name="gender")
		private String gender;
	
	
	
	
}
