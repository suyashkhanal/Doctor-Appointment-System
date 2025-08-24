package org.personal.appointment.model;

public class Clients {

    private int id;

    private String name;

    private int age;

    private String doctor;

    private String date;

    public Clients() {
    }

    public Clients(int id, String name, int age, String doctor, String date) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.doctor = doctor;
        this.date = date;
    }

    public Clients(String name, int age, String doctor, String date) {
        this.name = name;
        this.age = age;
        this.doctor = doctor;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Clients{" + "id=" + id + ", name=" + name + ", age=" + age + ", doctor=" + doctor + ", date=" + date + '}';
    }

}

