
package com.fsad;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
public static void main(String[] args){
ApplicationContext ctx =
new ClassPathXmlApplicationContext("beans.xml");

Student s = (Student)ctx.getBean("student");
s.display();
}
}
