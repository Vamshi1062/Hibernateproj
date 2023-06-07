package cgg.hibernate.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HQLDemo {

	public static void main(String[] args) {
		 SessionFactory fact=new Configuration().configure().buildSessionFactory();
		 Session ses=fact.openSession();
		 
		 //HQL Syntax
		 
		 //String query="from Student where city='hyd'";
//		 String query="from Student as s where s.city=:x and s.name=:n";//dynamic supply x value
//		 
//		 Query q=ses.createQuery(query);
//		 q.setParameter("x","hyd");
//		 q.setParameter("n","abc");//if you supply dynamic value
//		 //single result -(unique)
//		 //multiple result-list
//		 List<Student> list=q.list();
//		 for (Student student : list) {
//			System.out.println(student.getName()+":"+student.getCerti().getCourse());
//		}
//		 System.out.println("-------------------------------------------------");
		 
		 //Transaction transaction = ses.beginTransaction();
		 
		 //delete query
		 
//		 Query q1=ses.createQuery("delete from Student s where s.city=:x");
//		 q1.setParameter("x","hyd");
//		 int r=q1.executeUpdate();
//		 System.out.println("deleted:"+r);
		 
		 //update query
		 
//		 Query query2 = ses.createQuery( "update Student set city=:c where name=:n");
//		 
//		 query2.setParameter( "c", "bengalor");
//		 query2.setParameter("n","abc");
//		 int r1=query2.executeUpdate();
//		 System.out.println("updated: "+r1);
//		 transaction.commit();
		 
		 //How to execute join
		 Query q3=ses.createQuery("select b.brandId,b.brandName,p.productName from Brand as b INNER JOIN b.products as p");
		 List<Object []> list = q3.getResultList();
		 for  (Object[] objects : list) {
			System.out.println(Arrays.toString(objects));
		}
		 ses.close();
		 fact.close();

	}

}
