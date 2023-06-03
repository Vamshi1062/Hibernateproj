package cgginterns.hibernate.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		 SessionFactory fact=new Configuration().configure().buildSessionFactory();
		 //creating question object...
		 Question q1=new Question();
		 q1.setQuestion("what is java?");
		 q1.setQuestionId(1212);
		 //creating answer object...
		 Answer a=new Answer();
		 a.setAnswerId(343);
		 a.setAnswer("Java is a programming language");
		 
		 q1.setAnswer(a);
		 a.setQuestion(q1);
		 
		//creating question object...
		 Question q2=new Question();
		 q2.setQuestion("what is python?");
		 q2.setQuestionId(12);
		 //creating answer object...
		 Answer a1=new Answer();
		 a1.setAnswerId(23);
		 a1.setAnswer("Python is a programming language");
		 
		 q2.setAnswer(a1);
		 a1.setQuestion(q2);
		 
		 Session s=fact.openSession();
		 s.beginTransaction();
		 s.save(q1);
		 s.save(q2);
		 s.save(a);
		 s.save(a1);
		 s.getTransaction().commit();
		 
		 //Fetching objects
		 
//		 Question ques=(Question)s.get(Question.class,1212);
//		 System.out.println(ques.getQuestion());
//		 System.out.println(ques.getAnswer().getAnswer());
		 //Fetching based on answer....
		 Answer ans=(Answer)s.get(Answer.class,343);
		 System.out.println(ans.getAnswer());
		 System.out.println(ans.getQuestion().getQuestion());
		 
		 s.close();
		 
       fact.close();
	}

}
