package hospitalProject.serviceImpl;

import hospitalProject.db.DataBase;
import hospitalProject.model.Department;
import hospitalProject.model.Doctor;
import hospitalProject.model.Hospital;
import hospitalProject.service.DoctorService;
import hospitalProject.service.GenericService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DoctorServiceImpl implements GenericService<Doctor>, DoctorService {
    private DataBase dataBase;

    public DoctorServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public Doctor findDoctorById(Long id) {
        for (Hospital h : dataBase.getHospitals()) {
            for (Department d : h.getDepartments()) {
                for (Doctor doc : d.getDoctors()) {
                    if (doc.getId().equals(id)) {
                        return doc;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        for (Hospital h : dataBase.getHospitals()) {
            for (Department d : h.getDepartments()) {
                for (Doctor doctor : d.getDoctors()) {
                    if (d.getId().equals(departmentId)) {
                        doctorsId.add(doctor.getId());
                        return "Successfully saved doctors to department ";
                    }
                }
            }
        }
        return null;
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        for (Hospital h : dataBase.getHospitals()) {
            if (h.getId().equals(id)) {
                return h.getDoctors();
            }
        }
        return null;
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        for (Hospital h : dataBase.getHospitals()) {
            for (Department department : h.getDepartments()) {
                if (department.getId().equals(id)) {
                    System.out.println("Department name: " + department.getDepartmentName() + " ");
                    return department.getDoctors();
                }
            }
        }
        return null;
    }

    @Override
    public String add(Long hospitalId, Doctor doctor) {
        for (int i = 0; i < dataBase.getHospitals().size(); i++) {
            if (dataBase.getHospitals().get(i).getId().equals(hospitalId)) {
                dataBase.getHospitals().get(i).getDoctors().add(doctor);
                return "Successfully saved doctor to hospital";
            }
        }
        return null;
    }

    @Override
    public void removeById(Long id) {
        for (Hospital h : dataBase.getHospitals()) {
            for (int i = 0; i < h.getDoctors().size(); i++) {
                if (h.getDoctors().get(i).getId().equals(id)) {
                    h.getDoctors().remove(h.getDoctors().get(i));
                    System.out.println("Successfully deleted doctor");
                }
            }
        }
    }

    @Override
    public String updateById(Long id, Doctor doctor) {
        for (Hospital h : dataBase.getHospitals()) {
            for (Doctor d : h.getDoctors()) {
                if (d.getId().equals(id)) {
                    d.setFirstName(doctor.getFirstName());
                    d.setLastName(doctor.getLastName());
                    d.setGender(doctor.getGender());
                    d.setExperienceYear(doctor.getExperienceYear());
                }
            }
        }
        return "Successfully update doctor";
    }
}
