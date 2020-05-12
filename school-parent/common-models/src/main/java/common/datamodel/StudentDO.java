package common.datamodel;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Student")
public class StudentDO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
	@Column
	String rollNum;
	@Column
	String firstName;
	@Column
	String middleName;
	@Column
	String lastName;
	@Column
	String standard;
	@Column
	String division;
	@Column
	String imageId;
	@Column
	String status;
	@Column
	String gender;
	
	@Column(columnDefinition="datetime default '0000-00-00 00:00:00'")
	Date dob;
	@Column
	String mobilNum;
	@Column
	String academicYr ;
	@Column
	Date admsnDt;
	String category ;
	@OneToOne(fetch =FetchType.LAZY,cascade =CascadeType.ALL)
	@JoinColumn(name="otherDeailsId")
	StudentOtherDetails otherDetail;
	
	/*
	 * @OneToMany(mappedBy="student",fetch=FetchType.LAZY) Set<StudentPayment>
	 * studentPaymentList;
	 */
	
	@Column
	String lastModifiedUser;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRollNum() {
		return rollNum;
	}

	public void setRollNum(String rollNum) {
		this.rollNum = rollNum;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}
	
	public void setDob(Date dob) {
		/*
		 * if(sDob == null || sDob =="") { this.dob = null; } System.out.println(sDob);
		 * Date dob = Date.valueOf(sDob);
		 */
		System.out.println(dob);
		this.dob = dob;
	}
	public String getMobilNum() {
		return mobilNum;
	}

	public void setMobilNum(String mobilNum) {
		this.mobilNum = mobilNum;
	}

	public String getAcademicYr() {
		return academicYr;
	}

	public void setAcademicYr(String academicYr) {
		this.academicYr = academicYr;
	}

	public Date getAdmsnDt() {
		return admsnDt;
	}

	public void setAdmsnDt(Date sAdmsnDt) {
		this.admsnDt = sAdmsnDt;
	}

	public StudentOtherDetails getOtherDetail() {
		return otherDetail;
	}

	public void setOtherDetail(StudentOtherDetails otherDetail) {
		this.otherDetail = otherDetail;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	/*
	 * public Set<StudentPayment> getStudentPaymentList() { return
	 * studentPaymentList; }
	 * 
	 * public void setStudentPaymentList(Set<StudentPayment> studentPaymentList) {
	 * this.studentPaymentList = studentPaymentList; }
	 */

	public String getLastModifiedUser() {
		return lastModifiedUser;
	}

	public void setLastModifiedUser(String lastModifiedUser) {
		this.lastModifiedUser = lastModifiedUser;
	}

	/*
	 * public StudentPayment getCurrentYearStudentPayment() { for(StudentPayment
	 * studentPayment:this.getStudentPaymentList()) {
	 * if(this.academicYr.equals(studentPayment.getAcademicYr()) ) { return
	 * studentPayment; } }
	 * 
	 * return null; }
	 */
	
	@Override
	public String toString() {
		return "StudentDO [id=" + id + ", rollNum=" + rollNum + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", standard=" + standard + ", division=" + division + ", imageId=" + imageId + ", status=" + status
				+ ", gender=" + gender + ", dob=" + dob + ", mobilNum=" + mobilNum + ", academicYr=" + academicYr
				+ ", admsnDt=" + admsnDt + ", otherDetail=" + otherDetail + "]";
	}
	

}
