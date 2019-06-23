package hibernate.hqlDemo;

import hibernate.HibernateUtils;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;

public class HQLtester {
    static final SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    static final EntityManager manager = sessionFactory.createEntityManager();

    public static void main(String[] args) {

        manager.getTransaction().begin();



        manager.getTransaction().commit();

        HibernateUtils.shutdown();
    }
}
