package SDA.dataStructure.hashCodeEquals.developers;

public class Developer {

    private String name;
    private String surname;
    private Language language;
    private int age;

    public Developer(String name, String surname, Language language, int age) {
        this.name = name;
        this.surname = surname;
        this.language = language;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", language=" + language +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Developer)) return false;

        Developer developer = (Developer) o;

        if (age != developer.age) return false;
        if (name != null ? !name.equals(developer.name) : developer.name != null) return false;
        if (surname != null ? !surname.equals(developer.surname) : developer.surname != null) return false;
        return language == developer.language;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }
}
