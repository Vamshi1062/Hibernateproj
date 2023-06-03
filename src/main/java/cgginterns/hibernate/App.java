package cgginterns.hibernate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Program Created..." );
        SessionFactory factory=new Configuration().configure().buildSessionFactory();
//        System.out.println(factory);
//        System.out.println(factory.isClosed());
        
        //creating student objects
        
        
       Student st=new Student();
       st.setId(2);
       st.setCity("vizag");
       st.setName("abc");
       
       //creating address object
       Address add=new Address();
       add.setStreet("Street1");
       add.setCity("hyd");
       add.setOpen(true);
       add.setX(13.23);
       add.setAddedDate( new Date());
       //Reading image
       try
    	  (FileInputStream fis= new FileInputStream("src/main/java/IMG_7068.JPG")){
    	  byte [] data=new byte[fis.available()];
    	  fis.read(data);
    	  add.setImage(data);
       }
       catch(FileNotFoundException e) {
    	   e.printStackTrace();
       }
       catch(IOException e) {
    	   e.printStackTrace();
       }
       System.out.println(st);
       System.out.println(add);
       Session session=factory.openSession();
        session.beginTransaction();
        session.save(st);
        session.save(add);
        session.getTransaction().commit();
      
        session.close();
        factory.close();
        System.out.println("Done...");
    }
}
