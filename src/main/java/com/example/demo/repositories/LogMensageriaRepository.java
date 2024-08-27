package com.example.demo.repositories;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.collections.LogMensageria;

@Repository
public interface LogMensageriaRepository extends MongoRepository<LogMensageria, UUID> {

}
