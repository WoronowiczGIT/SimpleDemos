import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;

public class Main2 {

    public static void main(String[] args) {
        final SessionFactory factory = HibernateUtils.getSessionFactory();
        final EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
        manager.persist(userFactory());

        Users user = manager.find(Users.class,1);
        System.out.println(user.getUname()+" "+user.getPassword());
        manager.getTransaction().commit();
        HibernateUtils.shutdown();
    }

    public static Users userFactory(){
        return new Users(null,"hiberneter","weakpassword");

    }
}
