package com.example.ec2_aws.persistance.repos;

import com.example.ec2_aws.persistance.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address,Long> {
}
