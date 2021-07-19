package com.example.ec2_aws.service.address;

import com.example.ec2_aws.facade.address.AddressDTO;

import java.util.ArrayList;

public interface AddressService {

    AddressDTO getById(Long id);

    ArrayList<AddressDTO> getAll();

}
