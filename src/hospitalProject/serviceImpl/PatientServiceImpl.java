package hospitalProject.serviceImpl;

import hospitalProject.db.DataBase;
import hospitalProject.model.Hospital;
import hospitalProject.model.Patient;
import hospitalProject.service.GenericService;
import hospitalProject.service.PatientService;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PatientServiceImpl implements GenericService<Patient>, PatientService {
    private DataBase dataBase;

    public PatientServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String add(Long hospitalId, Patient patient) {
//        List<Hospital> list = dataBase.getHospitals().stream().filter(hospital -> hospital.getId().equals(hospitalId)).toList();
//        list.get(0).getPatients().add(patient);
//        return "Successfully saved patient to hospital";
        for (Hospital h : dataBase.getHospitals()) {
            h.getPatients().add(patient);
            return "Successfully saved";
        }
        return null;
    }

    @Override
    public void removeById(Long id) {
        for (Hospital h : dataBase.getHospitals()) {
            for (Patient p : h.getPatients()) {
                if (p.getId().equals(id)) {
                    System.out.println("Hospital name: "+h.getHospitalName()+" Hospital id: "+h.getId());
                   h.getPatients().remove(p);
                    System.out.println("Successfully deleted patient");
                }
            }
        }
    }

    @Override
    public String updateById(Long id, Patient patient) {
        for (Hospital h : dataBase.getHospitals()) {
            for (Patient p : h.getPatients()) {
                if (p.getId().equals(id)) {
                    p.setFirstName(patient.getFirstName());
                    p.setLastName(patient.getLastName());
                    p.setAge(patient.getAge());
                    p.setGender(patient.getGender());
                }
            }
        }

        return "Successfully update patient";
    }

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        List<Hospital> list = dataBase.getHospitals().stream().filter(hospital -> hospital.getId().equals(id)).toList();
        list.get(0).getPatients().addAll(patients);
        return "Successfully saved patients to hospital";
    }

    @Override
    public Patient getPatientById(Long id) {
//        for (Hospital h :dataBase.getHospitals()) {
//            List<Patient> list = h.getPatients().stream().filter(patient -> patient.getId().equals(id)).toList();
//            return list.get(0);
//        }
        for (Hospital h :
                dataBase.getHospitals()) {
            List<Patient> list = h.getPatients().stream().filter(patient -> patient.getId().equals(id)).toList();
            return list.get(0);
        }
        return null;
    }

    @Override
    public Map<Integer, Patient> getPatientByAge(Integer integer) {
        for (Hospital k : dataBase.getHospitals()) {
            Map<Integer, Patient> collect = k.getPatients().stream().filter(patient -> patient.getAge() == integer).collect(Collectors.toMap(Patient::getAge, Function.identity()));
            return collect;
        }
        return null;
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        if (ascOrDesc.equalsIgnoreCase("18>")) {
            for (Hospital h : dataBase.getHospitals()) {
                List<Patient> list = h.getPatients().stream().sorted(Comparator.comparing(Patient::getAge)).toList();
                System.out.println(list);
            }
        } else if (ascOrDesc.equalsIgnoreCase("18<")) {
            for (Hospital h : dataBase.getHospitals()) {
                List<Patient> list = h.getPatients().stream().sorted(Comparator.comparing(Patient::getAge).reversed()).toList();
                System.out.println(list);
            }
        }
        return null;
    }
}
