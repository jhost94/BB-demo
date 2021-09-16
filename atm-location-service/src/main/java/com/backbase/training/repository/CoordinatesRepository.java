package com.backbase.training.repository;

import com.backbase.training.domain.Coordinate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoordinatesRepository extends CrudRepository<Coordinate, Integer> {

    @Override
    List<Coordinate> findAll();
}
