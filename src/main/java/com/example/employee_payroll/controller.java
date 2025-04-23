package com.example.employee_payroll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/home")
public class controller {

  @Autowired
  public UserRepo userRepo ; 

  @GetMapping("/listAll")
  public List<User> listall(){
    return userRepo.findAll() ; 
  }

  @PostMapping("/addEntry")
  public String postName(@RequestBody User user) {
    userRepo.save(user) ; 
    return "added";
  }

  @PutMapping("/update/{id}")
  public String update(@PathVariable Long id, @RequestBody User user){
    User targetUser = userRepo.findById(id).get() ; 
    if(targetUser!=null){
      targetUser.setFirstname(user.getFirstname());
      targetUser.setLastname(user.getLastname());

      userRepo.save(targetUser);
      return "updated" ;
    }
    return null;
  }

  @DeleteMapping("delete/{id}")
  public String delete(@PathVariable Long id){
    User targetUser = userRepo.findById(id).get() ; 
    userRepo.delete(targetUser);

    return "deleted" ; 
  }
  
}
