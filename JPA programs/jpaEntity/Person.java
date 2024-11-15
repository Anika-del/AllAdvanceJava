In the armees to aut

1. GenerationlyPE AUTO->
e for a primary key cum
The Generation Type AUTO is the default generation type and lets the persistance provide shows the generation strategy.
2. GenerationType IDENTITY-> B The GenerationType IDENTITY is the easiest to use but not the best one from a pertornisce pass of
relies on an auto-incremented database column and lets the database generate a
new value with
operation. From a database point of view, this is very efficient because the auto-incrementar
optimized, and it doesn't require any additional statements.
3. GenerationType.SEQUENCE->
The GenerationType.SEQUENCE is to generate primary key values and uses a database sequence to generate
unique values.

4.Generation Type.TABLE->

The GenerationType.TABLE gets only rarely used nowadays. It simulates a sequente by sharing and Its current value in a database table which requires the use of pessimistic
 lucks that put all transacti sequential order. This slows down your application, and you should, therefore, prefer the GenerationType.SEQUENCE, if your database supports 
 sequences
 
 Tomanly 2 st Because the first Autu just th Implememolles En Cholise which
strategies it will use. For exampla working with Qras EclipseLink 2.5.0, the "Auto" will result in the strategy "Table" being choosen This behaviors the database and the
 IPA implementation in your project.
 
package mypack;


import javax.persistence.Entity;
Import java.io.*;
import javax.persistence.GeneratedValue:
import javax.persistence.Id; import javax.persistence.":
import javax.persistence.Table;

@Entity
Table(name="Person14"
) public class Person implements Serializable{

//@Id
//@GeneratedValue
//@GeneratedValue(strategy GenerationType.TABLE)
//@GeneratedValue(strategy = Generation Type IDENTITY)
//@GeneratedValue(strategy GenerationType.AUTO) @Id

@SequenceGenerator(name="SEQ_GEN", sequenceName="jpaseq5", allocationSize=1) @GeneratedValue(strategy GenerationTvoe SEQUENCE, generator="SEQ GUN

Sequs Generatorname @GeneratedValue(strategy GenerationType SEQUENCENT
private long id;
private String name;
private String surname;
public Person() {}
public Person(String name, String surname){

this.name = name;
this.surname = surname;
}

public long getId() {
return id;
}

public void setId(long id) {
this.id = id;
}
public String getName() {

public void setld(ving id) {
this.id = id;

public String getName() (

return name;
public void setName(String name) {

this.name name;
 }

public String getSurname() {
return surname;
public void setSurname(String surname) (

this.surname = surname;
}
@Override

public String toString() (
return "Person [id=" + id + ", name="+name+", surname + surname + "
}
