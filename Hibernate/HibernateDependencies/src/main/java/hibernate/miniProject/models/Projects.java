package hibernate.miniProject.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "projects")
public class Projects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Integer projectID;

    @Column(name = "project_name")
    private String projectName;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "Project_Employee",
    joinColumns = {
    @JoinColumn(name = "project_id")},
            inverseJoinColumns = {@JoinColumn(name = "employee_id")}
    )
    private Set<Employees> employeeSet= new HashSet<>();

    public Projects(){}

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getProjectID() {
        return projectID;
    }

    public void setProjectID(Integer projectID) {
        this.projectID = projectID;
    }

    public Set<Employees> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employees> employeeSet) {
        this.employeeSet = employeeSet;
    }
}
