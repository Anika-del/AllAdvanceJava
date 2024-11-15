package mypack;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Named Queries;
import javax.persistence.Table;

@Entity
@Table(name="Employeenative")
@javax.persistence.NamedQuery(name="empAllRecores", query="SELECT emp FROM Employee emp")
@NamedQueries({
@NamedQuery(name="empGetRecords", query= "SELECT emp FROM Employee emp"),
@NamedQuery(name="empDeleteRecords", query="DELETE FROM Employee emp WHERE emp.id=?1")
})

public class Employee 
{

@Id
@GeneratedValue
@Column(name="id")
private int id;


@Column(name="empName")
private String empName;

@Column(name="empsalary") 
private int empSalary;

public Employee(int id, String empName,int empSalary)
{
this.id=id;
this.empName=empName;
this.empSalary=empSalary;
}

public Employee()
{}

public int getId() {
return id;
}
public void setId(int id) {
this.id = id;
}

public String getEmpName() {
	return empName;
}
public void setEmpName(String empName) {
	this.empName = empName;
}
public int getEmpSalary() {
	return empSalary;
}
public void setEmpSalary(int empSalary) {
this.empSalary = empSalary;
}
}
