

package com.example.employeemanagementsystem.model;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Cacheable
@DynamicInsert
@DynamicUpdate
@NamedQueries({
    @NamedQuery(name = "Employee.findByDepartmentName", 
                query = "SELECT e FROM Employee e WHERE e.department.name = :deptName"),
    @NamedQuery(name = "Employee.findByName", 
                query = "SELECT e FROM Employee e WHERE e.name = :name")
})
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "salary", nullable = false, unique = true)
    private String salary;
    
    @Column(name = "position", nullable = false, unique = true)
    private String position;
    
    @Column(name = "department_id", nullable=false)
    private Department department;
}
