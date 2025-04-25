package com.example.employee_payroll.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Id
  private Long id ; 

  @Column
  private String firstname ; 

  @Column
  private Long salary ;
}
