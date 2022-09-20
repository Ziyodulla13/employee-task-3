package uz.pdp.employeetask3.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    public final EmployeeDao employeeDao;

    @GetMapping
    public String getAllEmployee(Model model){
        model.addAttribute("employee",employeeDao.getAllEmployees());
        return "/view-employee";
    }

@GetMapping("/get-form")
    public String addForm(){
return "/add-form";
}
@GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id,Model model){
        model.addAttribute("employee",employeeDao.getEmployeeById(id));
        return "/edit-form";
}
@PostMapping()
    public String addEmployee(Employee employee){
employeeDao.addNewEmployee(employee);
        return "redirect:/employee";
}
@PostMapping("/edit")
    public String editEmployee(Employee employee){
        employeeDao.updateEmployee(employee);
        return "redirect:/employee";
}
@GetMapping("delete/{id}")
    public String deleteEmployee(@PathVariable Integer id){
        employeeDao.deleteEmployee(id);
        return "redirect:/employee";
}
}
