


import com.ggtcs.Data.User;
import com.ggtcs.Data.Exam;
import com.ggtcs.Data.Term;
import com.ggtcs.Data.Appointment;
import com.ggtcs.Data.Course;
import com.ggtcs.Data.Permission;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class JPATest {
    private static final String PERSISTENCE_UNIT_NAME = "JPATest";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        
        em.getTransaction().begin();
        
        
        List <Permission> sPerm = new ArrayList<Permission>();
        List <Permission> iPerm = new ArrayList<Permission>();
        sPerm.add(Permission.STUDENT);
        sPerm.add(Permission.ADMINISTRATOR);
        iPerm.add(Permission.INSTRUCTOR);
        
        // Create new users
        User garret = new User("Garret", "Leotta", "garret.leotta@stonybrook.edu", "107405405", sPerm);
        em.persist(garret);
        
        User scott = new User("Scott", "Stoller", "scott.stoller@stonybrook.edu", "100", iPerm);
        em.persist(scott);
        
        // Create new Exam
        Date date = new Date();
        
        Exam exam = new Exam();
       // Exam exam = new Exam("1", date, date, 50, "Pending", false, false);
        em.persist(exam);
        
        // Create new Term
        Term term = new Term("123", date, date, Collections.<Appointment>emptyList());
        em.persist(term);
        
        // Create new Course
        Course course = new Course("CSE308", scott, term);
        course.addStudent(garret);
        em.persist(course);
        
        // Create new Appointment
        Appointment appt = new Appointment(garret, exam, term);
        em.persist(appt);
        
        
        em.getTransaction().commit();
        em.close();
     }
};