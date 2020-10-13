package model;

public class Student {
    public String name;
    public String phone;
    public String email;
    public int rank;

    public Student(String name, String phone, String email, int rank){
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.rank = rank;
    }

    @Override
    public String toString(){
        return "Student : Name = " + name + ", Phone = " + phone + " , email = " + email + " , rank = " + rank;
    }
}
