package com.example.ec2_aws.persistance.repos;

import com.example.ec2_aws.persistance.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Long> {
}
