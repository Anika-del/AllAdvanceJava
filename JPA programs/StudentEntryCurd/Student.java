package mypack;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.*;

@Entity
@Table(name="Student")
//@Table(uniqeContrains=@UniqueContarint(columnName="NAME"))
public class Student implements Serializable
{
	@Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE)
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;
	//@Column(columnDefinition="VERCAHAR(40)",name="firstname",unique=true,nullable=false,length=40)
	//we can map java date type value to timesatap type database table column table column with the following code.
	//@Temporal(TemporalType.TIMESTAMP)
	//@Temporal(TemporalType.DATA)
	//private java.util.Date dob;
	//@Transient private String convertedName;
	@Column(name="firstname")
	private String firstname;
	@Column(name="lastname")
	private String lastname;
	@Column(name="email")
	//@Transient
	private String email;
	
	public Student(long id,String firstname,String lastname,String email)
	{
		this.id=id;
		this.firstname=firstname;
		this.lastname=lastname;
		this.email=email;
	}
	public Student()
	{
		//System.out.println("default");
	}
	public long getId()
	{
		return this.id;
	}
	
	public void setId(long id)
	{
		this.id=id;
	}
	public String getFirstname()
	{
		return this.firstname;
	}
	
	public void setFirstname(String firstname)
	{
		this.firstname=firstname;
	}
	public String getLastname()
	{
		return this.lastname;
	}
	
	public void setLastname(String lastname)
	{
		this.lastname=lastname;
	}
	public String getEmail()
	{
		return this.email;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
}