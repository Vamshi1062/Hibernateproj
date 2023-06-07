package cgg.hibernate.sqlquery;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class SQLExample {

	public static void main(String[] args) {
		 SessionFactory factory = new Configuration().configure().buildSessionFactory();
		 
		 Session session = factory.openSession();
		 
		 String q="select * from student";
		 
		 NativeQuery q1 = session.createNativeQuery(q);
		 q1.setFirstResult(0);
		 q1.setMaxResults(5);
		 List<Object []> list = q1.getResultList();
		 
		 for (Object[] o : list) {
			//System.out.println(Arrays.toString(o));
			 System.out.println(o[0]+":"+o[1]+":"+o[2]);
		}		 
		 
		 
		 
		 
		 
		 
		 session.close();
		 factory.close();

	}

}
