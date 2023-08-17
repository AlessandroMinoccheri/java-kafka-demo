package com.minompi.java_kafka_example.repositories;

import com.minompi.java_kafka_example.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
