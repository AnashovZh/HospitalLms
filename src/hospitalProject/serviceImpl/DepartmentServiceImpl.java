package hospitalProject.serviceImpl;

import hospitalProject.db.DataBase;
import hospitalProject.model.Department;
import hospitalProject.model.Hospital;
import hospitalProject.service.DepartmentService;
import hospitalProject.service.GenericService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService, GenericService<Department> {
    private DataBase dataBase;

    public DepartmentServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        for (Hospital h :dataBase.getHospitals()) {
            if (h.getId().equals(id)){
                System.out.println("Hospital name: "+h.getHospitalName());
                return h.getDepartments();
            }
        }return null;
    }

    @Override
    public Department findDepartmentByName(String name) {
        for (Hospital h : dataBase.getHospitals()) {
            List<Department> list = h.getDepartments().stream().filter(department -> department.getDepartmentName().equalsIgnoreCase(name)).toList();
            System.out.println("Hospital name: "+h.getHospitalName());
            return list.get(0);
        }
        return null;
    }

    @Override
    public String add(Long hospitalId, Department department) {
        for (Hospital h:dataBase.getHospitals()) {
            if (h.getId().equals(hospitalId)){
                h.getDepartments().add(department);
                return "Successfully saved department in Hospital";
            }
        }
        return "Successfully saved department in Hospital";
    }

    @Override
    public void removeById(Long id) {
        for (Hospital h : dataBase.getHospitals()) {
            for (int i = 0; i < h.getDepartments().size(); i++) {
                if (h.getDepartments().get(i).getId().equals(id)) {
                    h.getDepartments().remove(h.getDepartments().get(i));
                    System.out.println("Successfully deleted department");
                }
            }
        }
    }

    @Override
    public String updateById(Long id, Department department) {
        for (int i = 0; i < dataBase.getHospitals().size(); i++) {
            if (dataBase.getHospitals().get(i).getDepartments().get(i).getId().equals(id)) {
                dataBase.getHospitals().get(i).getDepartments().get(i).setDepartmentName(department.getDepartmentName());
                dataBase.getHospitals().get(i).getDepartments().get(i).setDoctors(department.getDoctors());
            }
        }
        return "Successfully update department";
    }
}
