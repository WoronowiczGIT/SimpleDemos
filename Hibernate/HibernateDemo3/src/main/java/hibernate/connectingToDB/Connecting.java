package hibernate.connectingToDB;

import hibernate.HibernateUtils;
import org.hibernate.Session;

public class Connecting {


    public static void main(String[] args) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();

        String sql = "select version()";
        String result = (String) session.createNativeQuery(sql).getSingleResult();
        System.out.println(result);

        session.getTransaction().commit();
        session.close();

        HibernateUtils.shutdown();
    }
}
