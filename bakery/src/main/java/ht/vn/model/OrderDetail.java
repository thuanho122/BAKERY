package ht.vn.model;

import javax.persistence.*;
import java.math.BigDecimal;

public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;


    @ManyToOne
    @JoinColumn(name = "bakery_id")
    private Bakery bakery;


    private BigDecimal priceBakery;


    private int quantity;


    private BigDecimal totalPrice;
}
