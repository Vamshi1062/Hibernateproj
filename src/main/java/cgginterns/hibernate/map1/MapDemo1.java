package cgginterns.hibernate.map1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MapDemo1 {

	public static void main(String[] args) {
		 SessionFactory fact=new Configuration().configure().buildSessionFactory();
		 //creating question objects
		 Question q=new Question();
		 q.setQuestion("what is java");
		 q.setQuestionId(121);
		 //creating answer objects..multiple answers
		 Answer a=new Answer();
		 a.setAnswerId(12);
		 a.setAnswer("java is a programming language");
		 a.setQuestion(q);
		 Answer a1=new Answer();
		 a1.setAnswerId(13);
		 a1.setAnswer("java is platform independent");
		 a1.setQuestion(q);
		 Answer a2=new Answer();
		 a2.setAnswerId(14);
		 a2.setAnswer("java is strongly typed language");
		 a2.setQuestion(q);
		 ArrayList<Answer> list = new ArrayList<>();
		 list.add(a);
		 list.add(a1);
		 list.add(a2);
		 q.setAnswers(list);
		 
		 
		 //creating question objects
		 Question q1=new Question();
		 q1.setQuestion("what is python");
		 q1.setQuestionId(123);
		 //creating answer objects..multiple answers
		 Answer a3=new Answer();
		 a3.setAnswerId(15);
		 a3.setAnswer("python is a programming language");
		 a3.setQuestion(q1);
		 Answer a4=new Answer();
		 a4.setAnswerId(16);
		 a4.setAnswer("python is platform independent");
		 a4.setQuestion(q1);
		 Answer a5=new Answer();
		 a5.setAnswerId(17);
		 a5.setAnswer("python is an easy language with normal english syntax");
		 a5.setQuestion(q1);
		 ArrayList<Answer> list1 = new ArrayList<>();
		 list1.add(a3);
		 list1.add(a4);
		 list1.add(a5);
		 q1.setAnswers(list1);
		 Session s=fact.openSession();
		 s.beginTransaction();
		 s.save(q);
		 s.save(a);
		 s.save(a1);
		 s.save(a2);
		 
		 s.save(q1);
		 s.save(a3);
		 s.save(a4);
		 s.save(a5);
		 s.getTransaction().commit();
		 
		 //Fetching
		 Question question=(Question)s.load(Question.class,123);
		 
		 System.out.println(question.getQuestion());
		 
		 List<Answer> answers=question.getAnswers();
		 
		 for(Answer answer:answers) {
			 System.out.println(answer.getAnswer());
		 }
		 
		 s.close();
		 fact.close();

	}

}
