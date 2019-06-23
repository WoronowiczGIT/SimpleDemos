package hibernate.hqlDemo;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "countries")
public class Countries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="country_id")
    private Integer countryID;

    @Column(name = "country_name")
    private String countryName;

    @OneToMany(mappedBy = "country")
    private Set<Cities> myCities;

    Countries(){}

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Integer getCountryID() {
        return countryID;
    }

    public void setCountryID(Integer countryID) {
        this.countryID = countryID;
    }

    public Set<Cities> getMyCities() {
        return myCities;
    }

    public void setMyCities(Set<Cities> myCities) {
        this.myCities = myCities;
    }
}
