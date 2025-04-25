package com.example.employee_payroll.Service;

import java.util.List;
import java.util.Optional;

import com.example.employee_payroll.Repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee_payroll.Model.User;

@Service
@Slf4j
public class UserService {

  @Autowired
  public UserRepo userRepo;

  // Get all users
  public List<User> getData() {
    log.info("Fetching all users from the database");
    List<User> users = userRepo.findAll();
    log.debug("Total users found: {}", users.size());
    return users;
  }

  // Add a new user
  public String addData(User user) {
    log.info("Adding new user: {}", user.getFirstname());
    try {
      userRepo.save(user);
      log.debug("User saved successfully: {}", user);
      return "added";
    } catch (Exception e) {
      log.error("Error occurred while saving user: {}", user, e);
      return "error";
    }
  }

  // Get user by ID
  public User getUserByid(Long id) {
    log.info("Fetching user by ID: {}", id);
    Optional<User> userOpt = userRepo.findById(id);
    if (userOpt.isPresent()) {
      log.debug("User found: {}", userOpt.get());
      return userOpt.get();
    } else {
      log.warn("User with ID {} not found", id);
      return null;
    }
  }

  // Update user
  public String updateData(Long id, User updated_user) {
    log.info("Updating user with ID: {}", id);
    User user = getUserByid(id);
    if (user != null) {
      user.setFirstname(updated_user.getFirstname());
      user.setSalary(updated_user.getSalary());
      userRepo.save(user);
      log.debug("User updated: {}", user);
      return "updated";
    } else {
      log.warn("Update failed. No user found with ID: {}", id);
      return null;
    }
  }

  // Delete user
  public boolean deleteData(Long id) {
    log.info("Attempting to delete user with ID: {}", id);
    Optional<User> userOpt = userRepo.findById(id);
    if (userOpt.isPresent()) {
      userRepo.delete(userOpt.get());
      log.debug("User deleted successfully: {}", userOpt.get());
      return true;
    } else {
      log.warn("Delete failed. No user found with ID: {}", id);
      return false;
    }
  }
}