package hospitalProject.db;

import hospitalProject.model.Hospital;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private List<Hospital> hospitals=new ArrayList<Hospital>() ;

    public List<Hospital> getHospitals() {
        return hospitals;
    }

    public void setHospitals(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }
}
