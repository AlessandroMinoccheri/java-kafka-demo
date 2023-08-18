package com.minompi.java_kafka_example.repository;

import com.minompi.java_kafka_example.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
