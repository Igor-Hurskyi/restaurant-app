package com.epam.client;

import com.epam.restaurant.Order;

public interface Client extends Human {
    Order makeOrder();

    void pay(Order order);

    void leave();
}
