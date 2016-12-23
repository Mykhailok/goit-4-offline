package ua.goit.offline4.dao;

import ua.goit.offline4.entity.Order;

import java.util.List;

public interface OrderDao {

    List<Order> getAll();
}
