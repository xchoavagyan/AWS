package com.example.ec2_aws.converter;

import com.example.ec2_aws.annotations.Converter;
import com.example.ec2_aws.controller.address.models.AddressRequestModel;
import com.example.ec2_aws.controller.address.models.AddressResponseModel;
import com.example.ec2_aws.facade.address.AddressDTO;

@Converter
public class AddressConverter {

    public AddressDTO addressDataObjFromRequest(AddressRequestModel requestModel) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setCity(requestModel.getCity());
        addressDTO.setStreet(requestModel.getStreet());
        return addressDTO;
    }

    public AddressResponseModel responseFromAddressDataObj(AddressDTO dto) {
        AddressResponseModel responseModel = new AddressResponseModel();
        responseModel.setId(dto.getId());
        responseModel.setCity(dto.getCity());
        responseModel.setStreet(dto.getStreet());
        return responseModel;
    }
}
