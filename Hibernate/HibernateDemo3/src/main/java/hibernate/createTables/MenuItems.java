package hibernate.createTables;

import javax.persistence.*;

enum Spicy{
    VERY_SPICY,MEDIUM_SPICY,MILD;
}

@Entity
@Table(name = "menu_items")
public class MenuItems {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "spicyness")
    private Spicy howSpicy;

    MenuItems(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Spicy getHowSpicy() {
        return howSpicy;
    }

    public void setHowSpicy(Spicy howSpicy) {
        this.howSpicy = howSpicy;
    }
}
