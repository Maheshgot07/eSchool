package common.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="StudentOtherDeatils")
public class StudentOtherDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long otherDeailsId;
	@Column
	String fatherName;
	@Column
	String motherName;
	@Column
	String address;
	@Column
	String fatherQualif;
	@Column
	String motherQualif;
	
	@OneToOne(fetch = FetchType.LAZY,mappedBy="otherDetail")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	StudentDO student;
	
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFatherQualif() {
		return fatherQualif;
	}
	public void setFatherQualif(String fatherQualif) {
		this.fatherQualif = fatherQualif;
	}
	public String getMotherQualif() {
		return motherQualif;
	}
	public void setMotherQualif(String motherQualif) {
		this.motherQualif = motherQualif;
	}
	public long getOtherDeailsId() {
		return otherDeailsId;
	}
	public void setOtherDeailsId(long otherDeailsId) {
		this.otherDeailsId = otherDeailsId;
	}
	@JsonIgnore
	public StudentDO getStudent() {
		return student;
	}
	public void setStudent(StudentDO student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "StudentOtherDetails [otherDeailsId=" + otherDeailsId + ", fatherName=" + fatherName + ", motherName="
				+ motherName + ", address=" + address + ", fatherQualif=" + fatherQualif + ", motherQualif="
				+ motherQualif  + "]";
	}
	
	
}
