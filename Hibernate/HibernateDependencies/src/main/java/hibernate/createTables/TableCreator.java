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

        // add menu item
        MenuItems item = new MenuItems();
        item.setHowSpicy(Spicy.VERY_SPICY);
        item.setName("curry");
        item.setPrice(22.80);
        manager.persist(item);

        manager.getTransaction().commit();
        HibernateUtils.shutdown();

    }
}
