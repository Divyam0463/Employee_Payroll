package com.example.employee_payroll;

import org.springframework.data.jpa.repository.JpaRepository;

public interface  UserRepo extends JpaRepository<User, Long>{
  
}
