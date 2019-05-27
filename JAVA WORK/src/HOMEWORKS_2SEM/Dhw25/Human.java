package HOMEWORKS_2SEM.Dhw25;

public class Human {


    private String first_name;
    private String last_name;
    private Integer age;

    public Human(String first_name, int age) {
        this(first_name, "NoLastName", age);
    }


    public Human(String first_name, String last_name, int age) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }
}
