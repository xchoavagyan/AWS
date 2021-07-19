package com.example.ec2_aws.persistance.repos;

import com.example.ec2_aws.persistance.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface ProductRepo extends JpaRepository<Product,Long> {
    ArrayList<Product> findAllByProductName(String productName);
}
