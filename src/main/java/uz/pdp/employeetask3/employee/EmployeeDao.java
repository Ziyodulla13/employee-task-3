package uz.pdp.employeetask3.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EmployeeDao {

    public final JdbcTemplate jdbcTemplate;

    public List<Employee> getAllEmployees() {
        String sql = "select * from employee";
        List<Employee> employeeList = jdbcTemplate.query(sql, (resultSet, row) ->
                Employee.builder()
                        .id(resultSet.getInt(1))
                        .fullName(resultSet.getString(2))
                        .positionName(resultSet.getString(3))
                        .departmentName(resultSet.getString(4))
                        .build()
        );
        return employeeList;
    }

    public void addNewEmployee(Employee employee) {
        String sql = "insert into employee (full_name, position_name, department_name)\n" +
                "values ('" + employee.getFullName() + "','" + employee.getPositionName() + "','" + employee.getDepartmentName() + "');";
        jdbcTemplate.update(sql);
    }

    public void deleteEmployee(Integer id) {
        String sql = "delete from employee where id =" + id;
        jdbcTemplate.update(sql);
    }

    public void updateEmployee(Employee employee) {
        String sql = "update employee set full_name = '" + employee.getFullName() + "', position_name='" + employee.getPositionName()
                + "',department_name='" + employee.getDepartmentName() + "' where id = " + employee.getId();
        jdbcTemplate.update(sql);
    }

    public Employee getEmployeeById(Integer id) {
        String sql = "select * from employee where id =" + id;
        Employee employee = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Employee.class));
        return employee;
    }
}
