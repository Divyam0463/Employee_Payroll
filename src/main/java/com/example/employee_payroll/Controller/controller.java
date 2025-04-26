package com.example.employee_payroll.Controller;

import java.util.List;

import com.example.employee_payroll.Exception.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee_payroll.Model.User;
import com.example.employee_payroll.Repo.UserRepo;
import com.example.employee_payroll.Service.UserService;


@RestController
@RequestMapping("/service")
public class controller {
  //UC
  @Autowired
  public UserService service ; 

   @GetMapping
   public Object getData(){
    return service.getData();
   }

   @GetMapping("/{id}")
   public User getUserByid(@PathVariable Long id) throws UserNotFoundException {
       return service.getUserByid(id) ;
   }

   @PostMapping
   public String addData(@RequestBody @Valid User user){
    return service.addData(user) ;
   }


   @PutMapping("/{id}")
   public String putData(@PathVariable Long id, @RequestBody @Valid User updated_user) throws UserNotFoundException {
    return service.updateData(id, updated_user); 
   }

   @DeleteMapping("/{id}")
   public boolean deleteDate(@PathVariable Long id) throws UserNotFoundException {
       return service.deleteData(id);
   }
}
