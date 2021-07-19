package com.example.ec2_aws.service.product;

import com.example.ec2_aws.facade.product.ProductDTO;

import java.util.ArrayList;

public interface ProductService {

    ProductDTO create(ProductDTO dto);

    ProductDTO getById(Long id);

    ArrayList<ProductDTO> findAll();

    ArrayList<ProductDTO> findAllByName(String name);

    ProductDTO updateById(ProductDTO dto);

    void deleteById(Long id);

}
