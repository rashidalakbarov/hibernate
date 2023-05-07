package org.company.entity;


import javax.persistence.*;

@Entity
@Table(name = "gender")
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "description")
    private String description;


    @Override
    public String toString() {
        return "Gender{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
