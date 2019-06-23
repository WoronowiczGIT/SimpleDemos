package hibernate.miniProject.models;

import javax.persistence.*;

@Entity
@Table(name = "phones")
public class Phones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phone_id")
    private Integer phoneID;

    @Column
    private String brand;

    @Column
    private String model;

    @OneToOne(mappedBy = "myPhone", fetch = FetchType.EAGER)
    private Employees employeePhone;

    public Phones(){}

    public Integer getPhoneID() {
        return phoneID;
    }

    public void setPhoneID(Integer phoneID) {
        this.phoneID = phoneID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Employees getEmployee() {
        return employeePhone;
    }

    public void setEmployee(Employees employee) {
        this.employeePhone = employee;
    }
}
