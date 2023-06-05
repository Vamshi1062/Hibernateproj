package cgg.hibernate.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import cgginterns.hibernate.Student;

public class HQLDemo {

	public static void main(String[] args) {
		 SessionFactory fact=new Configuration().configure().buildSessionFactory();
		 Session ses=fact.openSession();
		 
		 //HQL Syntax
		 
		 //String query="from Student where city='hyd'";
		 String query="from Student as s where s.city=:x and s.name=:n";//dynamic supply x value
		 
		 Query q=ses.createQuery(query);
		 q.setParameter("x","hyd");
		 q.setParameter("n","abc");//if you supply dynamic value
		 //single result -(unique)
		 //multiple result-list
		 List<Student> list=q.list();
		 for (Student student : list) {
			System.out.println(student.getName()+":"+student.getCerti().getCourse());
		}
		 
		 ses.close();
		 fact.close();

	}

}
