package cgg.hibernate.firstlevelcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import cgginterns.hibernate.Student;

public class FirstLevelCacheDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		 
		 Session session = factory.openSession();
		 
		 Student s=null;
		 System.out.println(session.contains(s));
		 
		 Student  s1 = session.get(Student.class,101);
		 
		 System.out.println(s1);
		 
		 System.out.println("Working something");
		 
         Student  s2 = session.get(Student.class,101);
		 
		 System.out.println(s2);
		 
		 System.out.println(session.contains(s1));
		 
 		 
		 session.close();
		 factory.close();


	}

}
