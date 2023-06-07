package cgginterns.hibernate.student;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StudentManage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentid;
	private String sname;
	private String sphoneno;
	private String scity;
	public StudentManage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentManage(int studentid, String sname, String sphoneno, String scity) {
		super();
		this.studentid = studentid;
		this.sname = sname;
		this.sphoneno = sphoneno;
		this.scity = scity;
	}
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSphoneno() {
		return sphoneno;
	}
	public void setSphoneno(String sphoneno) {
		this.sphoneno = sphoneno;
	}
	public String getScity() {
		return scity;
	}
	public void setScity(String scity) {
		this.scity = scity;
	}
}
