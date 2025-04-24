package com.example.employee_payroll.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employee_payroll.Model.User;

public interface  UserRepo extends JpaRepository<User, Long>{
  
}
