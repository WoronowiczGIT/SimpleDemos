package SDA.dataStructure.hashCodeEquals.students;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {
    public static void main(String[] args) {

        Student s1 = new Student(1,"s");
        Student s2 = new Student(1,"s");
        Student s3 = new Student(2,"a");

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());

        System.out.println(s1.equals(s2));
        System.out.println(s2.equals(s3));

        System.out.println("-----------");
        Student alex = new Student(1, "Alex");
        List< Student > studentsLst = new ArrayList< Student >();
        studentsLst.add(alex);
        System.out.println("Arraylist size = " + studentsLst.size());
        System.out.println("Arraylist contains Alex = " + studentsLst.contains(new Student(1, "Alex")));
        // contains korzysta z equals!!!
        System.out.println("-----------");
        Student alex1 = new Student(1,"Alex");
        Student alex2 = new Student(1,"Alex");
        Set<Student> students = new HashSet<>();
        students.add(alex1);
        students.add(alex2);
        System.out.println(students.size());
        System.out.println(students.contains(new Student(1,"Alex")));

    }
}
