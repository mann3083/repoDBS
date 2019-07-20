package base.common;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SessionManager {
    public Session openSession() {

        /*Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Image.class);



        configuration.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.setFlushMode(FlushMode.MANUAL);
        ManagedSessionContext.bind(session);
        session.beginTransaction();*/

        return null;
    }

    public void commitSession(final Session session){

        session.flush();
        session.getTransaction().commit();
        session.close();
    }
}
