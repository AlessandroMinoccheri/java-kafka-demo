package com.minompi.java_kafka_example;

import com.minompi.java_kafka_example.model.Customer;
import com.minompi.java_kafka_example.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class Main {
    private final CustomerRepository customerRepository;

    public Main(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @GetMapping
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @PostMapping
    public void addCustomer(@RequestBody NewCustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.name);
        customer.setEmail(request.email);
        customer.setAge(request.age);

        customerRepository.save(customer);
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id) {
        customerRepository.deleteById(id);
    }

    record NewCustomerRequest (
         String name,
         String email,
         Integer age
    ) {

    }

    @GetMapping("/greet")
    public GreetResponse greet() {
        return new GreetResponse(
                "Hello",
                List.of("Java, Rust, PHP"),
                new Person("Alessandro", 35, 1000.00)
        );
    }

    record Person(String name, int age, double cash) {

    }
    record GreetResponse(
            String greet,
            List<String> favProgrammingLanguages,
            Person person
    ){}
    //record GreetResponse(String greet){}

   /* class GreetResponse {
        private final String greet;

        GreetResponse(String greet) {
            this.greet = greet;
        }

        public String getGreet() {
            return greet;
        }
    } */
}
