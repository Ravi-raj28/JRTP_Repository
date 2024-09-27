package com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.model.Trains;

@Repository
public interface TrainRepository extends JpaRepository<Trains, Integer>{

}
