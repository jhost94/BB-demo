package com.backbase.training.repository;

import com.backbase.training.domain.Greeting;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * For no pagination or sorting
 */

@Repository
public interface GreetingsRepository extends CrudRepository<Greeting, String> {

    @Override
    List<Greeting> findAll();
}

/**
 * For pagination or sorting
 */
/*
@Repository
public interface GreetingsRepository extends PagingAndSortingRepository<Greeting, String> {

    @Override
    List<Greeting> findAll(Sort sort);
}
 */