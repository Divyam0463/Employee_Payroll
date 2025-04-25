package com.example.employee_payroll.Service;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.example.employee_payroll.Model.User;

@Service
@Slf4j
public class UserService {
  List<User> data = new ArrayList<>() ;

  //get
  public List<User> getData(){
    return data ;
  }

  //post
  public String addData(User user){
      data.add(user);
      return "added" ;
  }

  //for updation purposes
  public User getUserByid(Long id){
    return data.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null) ; 
  }

  //update
  public String updateData(Long id,User updated_user){
    User user = getUserByid(id) ; //we get the user here 
    if(user != null){
      user.setFirstname(updated_user.getFirstname());
      user.setSalary(updated_user.getSalary());

      return "updated" ; 
    }return null ;
  }

  //delete
  public boolean deleteData(Long id){
    return data.removeIf((user) -> user.getId().equals(id)) ;
  }
}
