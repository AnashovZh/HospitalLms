package hospitalProject.service;

import hospitalProject.model.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartmentByHospital(Long id);
    Department findDepartmentByName(String name);
}
