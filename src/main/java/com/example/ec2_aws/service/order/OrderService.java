package com.example.ec2_aws.service.order;

import com.example.ec2_aws.facade.order.OrderDTO;

import java.util.ArrayList;

public interface OrderService {

    OrderDTO create(OrderDTO dto);

    OrderDTO getById(Long id);

    ArrayList<OrderDTO> getAll();

    void deleteById(Long id);
}
