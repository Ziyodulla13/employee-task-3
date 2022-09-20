package uz.pdp.employeetask3.employee;

import lombok.*;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Employee {
    private Integer id;
    private String fullName;
    private String positionName;
    private String departmentName;
}
