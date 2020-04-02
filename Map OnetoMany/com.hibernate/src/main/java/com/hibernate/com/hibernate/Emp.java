package com.hibernate.com.hibernate;

//import java.util.List;
import java.util.Map;

public class Emp 
{
   private String id;
   private String name;
   //private List<PhoneNumber> phoneno;
   private Map<Integer, PhoneNumber> phoneno;
   public Emp()
   {
	   System.out.println("Employee Object is Created");
   }
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
//public List<PhoneNumber> getPhoneno() {
//	return phoneno;
//}
public Map<Integer, PhoneNumber> getPhoneno() {
return phoneno;
}
//public void setPhoneno(List<PhoneNumber> phoneno) {
//	this.phoneno = phoneno;
//}
public void setPhoneno(Map<Integer, PhoneNumber> phoneno) {
this.phoneno = phoneno;
}
@Override
public String toString() {
	return "Emp [id=" + id + ", name=" + name + ", phoneno=" + phoneno + "]";
}
}
