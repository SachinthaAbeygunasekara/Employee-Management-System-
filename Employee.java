import java.time.LocalDate;

public class Employee {
    
    private int id;
    private String name;
    private LocalDate dob;
    private Gender gender;
    private String nic;
    private String mobile;
    private String email;
    private Designation designation;
    private EmployeeStatus statusemployee;


    Employee() {}

    public void setId(int id) {this.id = id;}
    public int getId() {return id;}

    public void setName(String name) {this.name = name;}
    public String getName() {return name;}

    public void setDob(LocalDate dob) {this.dob = dob;}
    public LocalDate getDob() {return dob;}

    public void setGender(Gender gender) {this.gender = gender;}
    public Gender getGender() {return gender;}

    public void setNic(String nic) {this.nic = nic;}
    public String getNic() {return nic;}

    public void setMobile(String mobile) {this.mobile = mobile;}
    public String getMobile() {return mobile;}

    public void setEmail(String email) {this.email = email;}
    public String getEmail() {return email;}

    public void setDesignation(Designation designation) {this.designation = designation;}
    public Designation getDesignation() {return designation;}

    public void setEmployeeStatus(EmployeeStatus statusemployee) {this.statusemployee = statusemployee;}
    public EmployeeStatus getEmployeeStatus() {return statusemployee;}

}
