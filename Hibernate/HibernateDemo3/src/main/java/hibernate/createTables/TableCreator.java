package hibernate.createTables;

import hibernate.HibernateUtils;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;

public class TableCreator {
    static final SessionFactory factory = HibernateUtils.getSessionFactory();
    static final EntityManager manager = factory.createEntityManager();

    public static void main(String[] args) {
        manager.getTransaction().begin();
//          JUST GET THOSE 2 FUCKERS CORRECT !
//                <property name="hibernate.hbm2ddl.auto">create</property>
//                <mapping class = "hibernate.createTables.MenuItems"/>

        manager.getTransaction().commit();
        HibernateUtils.shutdown();

    }
}
