
package com.fsad;

public class Student {
int id;
String name;
String course;
int year;

public Student(int id,String name,String course,int year){
this.id=id; this.name=name; this.course=course; this.year=year;
}

public void setCourse(String course){this.course=course;}
public void setYear(int year){this.year=year;}

public void display(){
System.out.println(id+" "+name+" "+course+" "+year);
}
}
