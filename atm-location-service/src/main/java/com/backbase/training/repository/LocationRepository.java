package com.backbase.training.repository;

import com.backbase.training.domain.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends CrudRepository<Location, String> {

    @Override
    List<Location> findAll();
}
