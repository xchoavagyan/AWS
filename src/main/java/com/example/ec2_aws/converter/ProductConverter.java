package com.example.ec2_aws.converter;

import com.example.ec2_aws.annotations.Converter;
import com.example.ec2_aws.controller.product.models.ProductRequestModel;
import com.example.ec2_aws.controller.product.models.ProductResponseModel;
import com.example.ec2_aws.facade.product.ProductDTO;

@Converter
public class ProductConverter {

    public ProductDTO productDataObjFromRequest(ProductRequestModel requestModel) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductName(requestModel.getProductName());
        return productDTO;
    }

    public ProductResponseModel responseFromDataObj(ProductDTO dto){
        ProductResponseModel responseModel = new ProductResponseModel();
        responseModel.setId(dto.getId());
        responseModel.setProductName(dto.getProductName());
        return responseModel;
    }
}
