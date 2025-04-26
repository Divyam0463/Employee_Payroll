package com.example.employee_payroll.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Id
  private Long id ; 

  @Pattern(regexp = "^[a-zA-Z]+([ '-][A-Za-z]+)*$",message = "Invalid syntax for Name ")
  @NotBlank(message = "Name can't be left empty")
  @Column
  private String firstname ;

  @Column
  private Double salary ;
}
