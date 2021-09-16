package com.backbase.training.repository;

import com.backbase.training.domain.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {

    @Override
    List<Address> findAll();
}
