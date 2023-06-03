package cgginterns.hibernate;

import java.io.FileOutputStream;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) {
		 SessionFactory Factory = new Configuration().configure().buildSessionFactory();
	        Session session = Factory.openSession();
	        
	        //Fetching Student data
	        Student s=(Student)session.load(Student.class,2);
            System.out.println(s);
            //Fetching address data
            Address address = (Address)session.get(Address.class,1);
            //Address add2=(Address)session.get(Address.class,1)
            //System.out.println(add2);
            //System.out.println(add2.getCity()+":"+add2.getStreet());
            //for above add2 it wont get from database it fetch data from cache(i.e select statement wont run)
           // System.out.println(address);
            //by using get if object not present gives null
            //by using load gives ObjectNotfoundexception
           // System.out.println(address.getCity()+":"+address.getStreet());
            //Fetching image
            byte[] image=address.getImage();
            try(FileOutputStream fos=new FileOutputStream("src/main/java/fetchedimage.jpg")){
            	fos.write(image);
            	fos.flush();
            }catch(IOException e) {
            	e.printStackTrace();
            }
            
	        session.close();
	        Factory.close();

}
}
