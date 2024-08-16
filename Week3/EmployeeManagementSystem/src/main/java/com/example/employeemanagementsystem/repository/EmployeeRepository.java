package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
	Page<Employee> findAll(Pageable pageable);
    List<Employee> findByDepartmentName(String departmentName);
    List<Employee> findAll(Sort sort);
   
    List<Employee> findByName(String name);

   
    List<Employee> findBySalaryGreaterThan(Double salary);
    
    @Query("SELECT e FROM Employee e WHERE e.department.name = :deptName")
    List<Employee> findEmployeesByDepartmentName(@Param("deptName") String deptName);

    @Query("SELECT e FROM Employee e WHERE e.name LIKE %:name%")
    List<Employee> findEmployeesByNameContaining(@Param("name") String name);
}
