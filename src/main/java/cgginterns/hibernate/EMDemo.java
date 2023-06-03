package cgginterns.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EMDemo {

	public static void main(String[] args) {
		 SessionFactory fact=new Configuration().configure().buildSessionFactory();
		 
		 //create student object
		 Student s=new Student();
		 s.setId(101);
		 s.setCity("secd");
		 s.setName("cvr");
		 
		 //create certificate object
		 Certificate c=new Certificate();
		 c.setCourse("python");
		 c.setDuration("six months");
		 s.setCerti(c);
		 
		 //You can create multiple objects
		 
		 Student s1=new Student();
		 s1.setId(102);
		 s1.setName("abc");
		 s1.setCity("hyd");
		 
		 Certificate c1=new Certificate();
		 c1.setCourse("java");
		 c1.setDuration("seven months");
		 s1.setCerti(c1);
		 
		 
		 Session session=fact.openSession();
		 session.beginTransaction();
		 session.save(s);
		 session.save(s1);
		 session.getTransaction().commit();
		 
		 
		 
		 
		 
		 
		 
		 fact.close();

	}

}
