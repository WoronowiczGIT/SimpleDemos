package hibernate.miniProject.models;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employees")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employeeID;

    @Column
    private String name;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "phone_id")
    private Phones myPhone;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    @Column(name = "tasks")
    private Set<Tasks> tasksSet = new HashSet<>();

    @ManyToMany(mappedBy = "employeeSet", fetch = FetchType.EAGER)
    private Set<Projects> projectsSet = new HashSet<>();

    public Employees(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public Phones getMyPhone() {
        return myPhone;
    }

    public void setMyPhone(Phones myPhone) {
        this.myPhone = myPhone;
    }

    public Set<Tasks> getTasksSet() {
        return tasksSet;
    }

    public void setTasksSet(Set<Tasks> tasksSet) {
        this.tasksSet = tasksSet;
    }

    public Set<Projects> getProjectsSet() {
        return projectsSet;
    }

    public void setProjectsSet(Set<Projects> projectsSet) {
        this.projectsSet = projectsSet;
    }
}
