import hospitalProject.db.DataBase;
import hospitalProject.emums.Gender;
import hospitalProject.model.Department;
import hospitalProject.model.Doctor;
import hospitalProject.model.Hospital;
import hospitalProject.model.Patient;
import hospitalProject.serviceImpl.DepartmentServiceImpl;
import hospitalProject.serviceImpl.DoctorServiceImpl;
import hospitalProject.serviceImpl.HospitalServiceImpl;
import hospitalProject.serviceImpl.PatientServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        DataBase dataBase = new DataBase();
        HospitalServiceImpl hospitalService = new HospitalServiceImpl(dataBase);
        DepartmentServiceImpl departmentService = new DepartmentServiceImpl(dataBase);
        DoctorServiceImpl doctorService = new DoctorServiceImpl(dataBase);
        PatientServiceImpl patientService = new PatientServiceImpl(dataBase);
        List<Doctor> doctors = new ArrayList<>(List.of(
                new Doctor("Asan", "Usonov", Gender.MALE, 1),
                new Doctor("Baktulan", "Nazirbek", Gender.MALE, 6)));
        List<Doctor> doctors1 = new ArrayList<>(List.of(
                new Doctor("Daniel", "Gafurov", Gender.MALE, 5),
                new Doctor("Erjigit", "Alisherov", Gender.MALE, 3)));
        List<Doctor> doctors2 = new ArrayList<>(List.of(
                new Doctor("Musa", "Rinatov", Gender.MALE, 3),
                new Doctor("Nurmuhammed", "Alymbaev", Gender.MALE, 6)));
        List<Patient> patients = new ArrayList<>(List.of(
                new Patient("Kairat", "Nurdinov", 25, Gender.MALE),
                new Patient("Erbol", "Bakytov", 26, Gender.MALE)));
        List<Department> departments = new ArrayList<>(List.of(
                new Department("Herurgya", doctors),
                new Department("Tramvatology", doctors1)));
        List<Doctor> doctorList = new ArrayList<>(List.of(
                new Doctor("Narynbek", "Tashmatov", Gender.MALE, 6),
                new Doctor("Dastan", "Bektashov", Gender.MALE, 7)));
        List<Doctor> doctorList1 = new ArrayList<>(List.of(
                new Doctor("Tashtanbek", "Jekshenov", Gender.MALE, 1),
                new Doctor("Piter", "Pen", Gender.MALE, 10)));
        List<Patient> patientsCase = new ArrayList<>(List.of(
                new Patient("Tom", "Hard", 26, Gender.MALE),
                new Patient("Erling ", "Holland", 27, Gender.MALE)));
        List<Long >longsCase=new ArrayList<>(List.of(1L,2L,3L,4L,5L));


        while (true) {
            System.out.println("\n1->Add hospital" +
                    "\n2->Find Hospital by id" +
                    "\n3->Get All Patient From Hospital" +
                    "\n4->Get all hospitals" +
                    "\n5->Delete hospital by id" +
                    "\n6->Get all hospital by address" +
                    "\n7->Add department to hospital" +
                    "\n8->Get all department hospital by id" +
                    "\n9->Find department by name" +
                    "\n10->Delete department by id" +
                    "\n11->Update department by id" +
                    "\n12->Add doctor to hospital" +
                    "\n13->Remove doctor by id" +
                    "\n14->Update by id doctor" +
                    "\n15->Get all doctors by department by id" +
                    "\n16->Get all doctors by hospital by id" +
                    "\n17->Find doctor by id"+
                    "\n18->assignDoctorToDepartment" +
                    "\n19->Add patient to hospital" +
                    "\n20->Update patient by id" +
                    "\n21->Add patients to hospital" +
                    "\n22->Delete patient " +
                    "\n23->Get patient's by id" +
                    "\n24->Sort patient by age" +
                    "\n25->Get patient by age" );
            int number = new Scanner(System.in).nextInt();
            switch (number) {
                case 1 -> {
                    System.out.println("Add hospital ");
                    System.out.println("write hospital name");
                    String hospitalName = new Scanner(System.in).nextLine();
                    System.out.println("write hospital address");
                    String hospitalAddress = new Scanner(System.in).nextLine();
                    hospitalService.addHospital(new Hospital(hospitalName, hospitalAddress, departments, doctors2, patients));
                }
                case 2 -> {
                    System.out.println("Find Hospital by id");
                    System.out.println("write hospital id");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println(hospitalService.findHospitalById(id));
                }
                case 3 -> {
                    System.out.println("getAllPatientFromHospital");
                    System.out.println("write hospital id");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println(hospitalService.getAllPatientFromHospital(id));
                }
                case 4 -> {
                    System.out.println("get all hospitals");
                    System.out.println(hospitalService.getAllHospital());
                }
                case 5 -> {
                    System.out.println("delete hospital by id");
                    System.out.println("write hospital id");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println(hospitalService.deleteHospitalById(id));
                }
                case 6 -> {
                    System.out.println("Get all hospital by address");
                    System.out.println("write hospital address");
                    String address = new Scanner(System.in).nextLine();
                    System.out.println(hospitalService.getAllHospitalByAddress(address));
                }
                case 7 -> {
                    System.out.println("Add department to hospital");
                    System.out.println("write hospital id");
                    Long hospitalId = new Scanner(System.in).nextLong();
                    System.out.println("write department name");
                    String nameDepartment = new Scanner(System.in).nextLine();
                    System.out.println(departmentService.add(hospitalId, new Department(nameDepartment, doctorList)));
                }
                case 8 -> {
                    System.out.println("Get all department hospital by id");
                    System.out.println("write hospital id");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println(departmentService.getAllDepartmentByHospital(id));
                }
                case 9 -> {
                    System.out.println("Find department by name");
                    System.out.println("write department name");
                    String nameDepartment = new Scanner(System.in).nextLine();
                    System.out.println(departmentService.findDepartmentByName(nameDepartment));
                }
                case 10 -> {
                    System.out.println("Delete department by id");
                    System.out.println("write department id");
                    Long id = new Scanner(System.in).nextLong();
                    departmentService.removeById(id);
                }
                case 11 -> {
                    System.out.println("Update department by id");
                    System.out.println("write department id");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println("write department name");
                    String departmentName = new Scanner(System.in).nextLine();
                    System.out.println(departmentService.updateById(id, new Department(departmentName, doctorList1)));
                }
                case 12 -> {
                    System.out.println("Add doctor to hospital");
                    System.out.println("write hospital id");
                    Long idHospital = new Scanner(System.in).nextLong();
                    System.out.println("write first name doctor");
                    String nameDoctor = new Scanner(System.in).nextLine();
                    System.out.println("write last name doctor");
                    String lastName = new Scanner(System.in).nextLine();
                    System.out.println("Write gender doctor");
                    String gender = new Scanner(System.in).nextLine();
                    if (gender.equalsIgnoreCase("Male")) {
                        gender = String.valueOf(Gender.MALE);
                    } else if (gender.equalsIgnoreCase("Female")) {
                        gender = String.valueOf(Gender.FEMALE);
                    }
                    System.out.println("Write the experience year");
                    int numberOf = new Scanner(System.in).nextInt();
                    System.out.println(doctorService.add(idHospital, new Doctor(nameDoctor, lastName, Gender.valueOf(gender), numberOf)));
                }
                case 13 -> {
                    System.out.println("Remove doctor by id");
                    System.out.println("write doctor id");
                    Long id = new Scanner(System.in).nextLong();
                    doctorService.removeById(id);
                }
                case 14 -> {
                    System.out.println("Update by id doctor");
                    System.out.println("write doctor by id");
                    Long doctorId = new Scanner(System.in).nextLong();
                    System.out.println("write doctor first name");
                    String doctorName = new Scanner(System.in).nextLine();
                    System.out.println("write doctor last name");
                    String lastName = new Scanner(System.in).nextLine();
                    System.out.println("write doctor gender");
                    String gender = new Scanner(System.in).nextLine();
                    if (gender.equalsIgnoreCase("male")) {
                        gender = String.valueOf(Gender.MALE);
                    } else if (gender.equalsIgnoreCase("female")) {
                        gender = String.valueOf(Gender.FEMALE);
                    }
                    int experienceYear = new Scanner(System.in).nextInt();
                    System.out.println(doctorService.updateById(doctorId, new Doctor(doctorName, lastName, Gender.valueOf(gender), experienceYear)));
                }
                case 15 -> {
                    System.out.println("Get all doctors by department by id");
                    System.out.println("write department id");
                    Long departmentId = new Scanner(System.in).nextLong();
                    System.out.println(doctorService.getAllDoctorsByDepartmentId(departmentId));
                }
                case 16 -> {
                    System.out.println("Get all doctors by hospital by id ");
                    System.out.println("Write hospital id");
                    Long hospitalId = new Scanner(System.in).nextLong();
                    System.out.println(doctorService.getAllDoctorsByHospitalId(hospitalId));
                }
                case 17 -> {
                    System.out.println("Find doctor by id ");
                    Long doctorId = new Scanner(System.in).nextLong();
                    System.out.println(doctorService.findDoctorById(doctorId));
                }
                case 18 -> {
                    System.out.println("assignDoctorToDepartment");
                    System.out.println("write department id");
                    Long departmentId = new Scanner(System.in).nextLong();
                    System.out.println(doctorService.assignDoctorToDepartment(departmentId,longsCase));
                }
                case 19 -> {
                    System.out.println("Add patient to hospital");
                    System.out.println("write hospital id");
                    Long hospitalId = new Scanner(System.in).nextLong();
                    System.out.println("write patient first name");
                    String firstName = new Scanner(System.in).nextLine();
                    System.out.println("write the  doctor's last name");
                    String lastName = new Scanner(System.in).nextLine();
                    System.out.println("Write the doctor's age ");
                    int age = new Scanner(System.in).nextInt();
                    System.out.println("write the doctor's gender");
                    String gender = new Scanner(System.in).nextLine();
                    if (gender.equalsIgnoreCase("male")) {
                        gender = String.valueOf(Gender.MALE);
                    } else if (gender.equalsIgnoreCase("female")) {
                        gender = String.valueOf(Gender.FEMALE);
                    }
                    patientService.add(hospitalId, new Patient(firstName, lastName, age, Gender.valueOf(gender)));
                }
                case 20 -> {
                    System.out.println("Update patient by id");
                    System.out.println("write the patient id");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println("Write the patient's first name");
                    String firstName = new Scanner(System.in).nextLine();
                    System.out.println("Write the patient's last name");
                    String lastName = new Scanner(System.in).nextLine();
                    System.out.println("Write the patient's age");
                    int age = new Scanner(System.in).nextInt();
                    System.out.println("Write the patient's gender");
                    String gender = new Scanner(System.in).nextLine();
                    if (gender.equalsIgnoreCase("male")) {
                        gender = String.valueOf(Gender.MALE);
                    } else if (gender.equalsIgnoreCase("female")) {
                        gender = String.valueOf(Gender.FEMALE);
                    }
                    System.out.println(patientService.updateById(id, new Patient(firstName, lastName, age, Gender.valueOf(gender))));
                }
                case 21 -> {
                    System.out.println("Add patients to hospital");
                    System.out.println("write the hospital's id");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println(patientService.addPatientsToHospital(id, patientsCase));
                }
                case 22 -> {
                    System.out.println("Delete patient ");
                    System.out.println("Write the patient's id");
                    Long id = new Scanner(System.in).nextLong();
                    patientService.removeById(id);
                }
                case 23 -> {
                    System.out.println("Get patient's by id");
                    System.out.println("Write the patient's id");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println(patientService.getPatientById(id));
                }
                case 24 -> {
                    System.out.println("Sort patient by age ");
                    System.out.println("Write the patient's age 18> or 18 < ");
                    String age = new Scanner(System.in).nextLine();
                    System.out.println(patientService.sortPatientsByAge(age));
                }
                case 25 -> {
                    System.out.println("Get patient by age ");
                    System.out.println("Write the patient's age");
                    Integer integer = new Scanner(System.in).nextInt();
                    System.out.println(patientService.getPatientByAge(integer));
                }
            }
        }
    }
}