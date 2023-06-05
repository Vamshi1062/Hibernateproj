package cgg.hibernate.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import cgginterns.hibernate.Certificate;
import cgginterns.hibernate.Student;

public class StateDemo {

	public static void main(String[] args) {
		     SessionFactory fact=new Configuration().configure().buildSessionFactory();   
		     //creating student objects
		     Student s=new Student();
             s.setId(1414);
             s.setName( "pqr");
             s.setCity("Hyd");
             s.setCerti(new Certificate("Android","3 months"));
             //1.Student :Transient
             //not in session and not in database
             Session ses = fact.openSession();
             Transaction  tx = ses.beginTransaction();
             ses.save(s);
             //2.student -> persistent: in session and database
             //as long as you made changes they will be reflected in database
             s.setName("lmn");
//             
//             ses.delete(s);
             Student st=ses.get(Student.class,1414);
             ses.delete(st);
             //its happening because still associated with session
             //4 student:removed state....in session but not in database
             
             
             tx.commit();
             ses.close();
             s.setName("str");
             System.out.println(s.getName());
             System.out.println(st.getName()+":"+st.getCity());
             //3.student will go into detached
             //out of session but in database ......if you made any changes not reflected in database 
             fact.close();
	}

}
