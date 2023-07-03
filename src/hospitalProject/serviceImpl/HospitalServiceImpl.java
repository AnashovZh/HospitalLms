package hospitalProject.serviceImpl;

import hospitalProject.db.DataBase;
import hospitalProject.model.Hospital;
import hospitalProject.model.Patient;
import hospitalProject.service.GenericService;
import hospitalProject.service.HospitalService;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HospitalServiceImpl implements HospitalService {
    private DataBase dataBase;

    public HospitalServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }


    @Override
    public String addHospital(Hospital hospital) {
        dataBase.getHospitals().add(hospital);
        return "Hospital successfully saved";
    }

    @Override
    public Hospital findHospitalById(Long id) {
        Optional<Hospital> first = dataBase.getHospitals().stream().filter(hospital -> hospital.getId().equals(id)).findFirst();
       return first.get();
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        Optional<Hospital> first = dataBase.getHospitals().stream().filter(hospital -> hospital.getId().equals(id)).findFirst();
        List<Patient> list = first.get().getPatients().stream().toList();
        return list;
    }

    @Override
    public List<Hospital> getAllHospital() {
        return dataBase.getHospitals();
    }

    @Override
    public String deleteHospitalById(Long id) {
        List<Hospital> list = dataBase.getHospitals().stream().filter(hospital -> hospital.getId().equals(id)).toList();
        for (Hospital h:list ) {
            if(h.getId().equals(id)){
                dataBase.getHospitals().remove(h);
            }
        }
        return "Successfully deleted hospital";
    }

    @Override
    public Map<String, Hospital> getAllHospitalByAddress(String address) {
        Map<String,Hospital>hospitalMap=dataBase.getHospitals().stream().filter(hospital -> hospital.getAddress()
                .equalsIgnoreCase(address)).collect(Collectors.toMap(Hospital::getHospitalName, Function.identity()));
        return hospitalMap;
    }
}
