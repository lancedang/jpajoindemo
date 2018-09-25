package com.dangdang.springboot.entity.single;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@Table(name = "single_person", schema = "jpa")
public class SinglePersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private String gender;

    public SinglePersonEntity() {
    }

    public SinglePersonEntity(String name, String gender) {
        this.name = name;
        this.gender = gender;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "SinglePersonEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
