package ua.goit.offline4.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "order", schema = "pizzeria")
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "order_date")
    private Timestamp orderDate;

    @Column(name = "comment")
    private String comment;

    @Column(name = "status")
    private Integer status;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "pizza_order", schema = "pizzeria",
            joinColumns = @JoinColumn(name = "pizza_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    private List<Pizza> pizzas;

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", orderDate=" + orderDate +
                ", comment='" + comment + '\'' +
                ", status=" + status +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getOrder_date() {
        return orderDate;
    }

    public void setOrder_date(Timestamp order_date) {
        this.orderDate = order_date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
