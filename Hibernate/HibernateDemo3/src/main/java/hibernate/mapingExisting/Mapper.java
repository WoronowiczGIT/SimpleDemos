package hibernate.mapingExisting;

import hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

public class Mapper {
    final static SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    final static EntityManager entityManager = sessionFactory.createEntityManager();

    public static void main(String[] args) {
        Restaurants myRestaurant = restaurantFactory();
        // open transaction
        entityManager.getTransaction().begin();
        // add new object to table
        entityManager.persist(myRestaurant);
        // get entity id
        int entityID = findIDbyName(myRestaurant.getName());
        //get object by id
        Restaurants restaurantFromDB = entityManager.find(Restaurants.class,entityID);
        //remove object from DB
        entityManager.remove(restaurantFromDB);
        // commit transaction
        entityManager.getTransaction().commit();
        HibernateUtils.shutdown();

        System.out.println("entity id = " + entityID);
        System.out.println("element found = "+ restaurantFromDB.getName());
    }
    public static Integer findIDbyName(String name){
        String hql = " from Restaurants where name = :name";
        Query query = entityManager.createQuery(hql);
        ((org.hibernate.query.Query) query).setParameter("name",name);
        List<Restaurants> resultSet = query.getResultList();
        int id = resultSet.get(0).getId();

        return id;
    }

    public static Restaurants restaurantFactory(){
        Restaurants restaurantRecord = new Restaurants();
        restaurantRecord.setId(null);
        restaurantRecord.setName("hormon");
        restaurantRecord.setNumberOfEmployees(155);
        restaurantRecord.setOpeningDate(LocalDate.of(2000,11,28));

        return restaurantRecord;
    }

}
