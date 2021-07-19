package com.example.ec2_aws.converter;

import com.example.ec2_aws.annotations.Converter;
import com.example.ec2_aws.controller.order.models.OrderRequestModel;
import com.example.ec2_aws.controller.order.models.OrderResponseModel;
import com.example.ec2_aws.facade.order.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;

@Converter
public class OrderConverter {

    private final PersonConverter personConverter;
    private final ProductConverter productConverter;

    @Autowired
    public OrderConverter(PersonConverter personConverter, ProductConverter productConverter) {
        this.personConverter = personConverter;
        this.productConverter = productConverter;
    }

    public OrderDTO buildDtoFromRequest(OrderRequestModel requestModel) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setUuid();
        orderDTO.setPersonId(requestModel.getPersonId());
        orderDTO.setProductIds(requestModel.getProductId());
        return orderDTO;
    }

    public OrderResponseModel buildResponseFromDto(OrderDTO dto) {
        OrderResponseModel orderResponseModel = new OrderResponseModel();
        orderResponseModel.setOrderId(dto.getOrderId());
        orderResponseModel.setUuid(dto.getUuid());
        orderResponseModel.setPersonId(dto.getPersonId());
        orderResponseModel.setProductIds(dto.getProductIds());
        return orderResponseModel;
    }

}
