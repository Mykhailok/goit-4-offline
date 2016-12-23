package ua.goit.offline4.dao.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.goit.offline4.dao.OrderDao;
import ua.goit.offline4.entity.Order;

import java.util.List;
import java.util.function.Supplier;

public class OrderDaoHibernate implements OrderDao {

    private SessionFactory factory;

    @Override
    public List<Order> getAll() {
        //factory.getCurrentSession();
        try(Session session = factory.openSession()){
            return session.createQuery("from Order", Order.class).list();
        }
    }

    public OrderDaoHibernate(SessionFactory factory) {
        this.factory = factory;
    }

    /*private Supplier<Session> supplier;    public OrderDaoHibernate(Supplier<Session> supplier) {

        this.supplier = supplier;

    }    public static void main(String[] args) {

        final SessionFactory s = null;

        OrderDaoHibernate dao = new OrderDaoHibernate(s::openSession);

    }*/

}
