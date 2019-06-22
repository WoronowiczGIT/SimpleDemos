import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class Main3 {
    public static void main(String[] args) {
        final SessionFactory factory = HibernateUtils.getSessionFactory();
        final EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();


        manager.getTransaction().commit();
        HibernateUtils.shutdown();
    }

    public static Employee employeeGenerator(){
        Employee emp = new Employee();
        emp.setBirthdate(LocalDate.now());
        emp.setName("myName");
        emp.setLastname("lastname");
        emp.setEmail("myMail");
        return emp;
    }
}

