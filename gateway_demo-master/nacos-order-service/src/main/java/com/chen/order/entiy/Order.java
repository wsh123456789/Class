package com.chen.order.entiy;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
public class Order implements Serializable {
    private int id;
    private Long price;
    private String name;
    private Integer num;
    private int userId;
    private List<User> user;
}
