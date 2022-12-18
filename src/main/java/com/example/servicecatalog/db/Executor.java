package com.example.servicecatalog.db;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "executor_t")
public class Executor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false, length = 200)
    private String typeOfBusiness;

    public Set<Recall> getRecalls() {
        return recalls;
    }

    public void setRecalls(Set<Recall> recalls) {
        this.recalls = recalls;
    }

    @Column(nullable = false, length = 200)
    private String businessDescription;

    @OneToMany(mappedBy = "executor", cascade = CascadeType.ALL)
    private Set<Recall> recalls;

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

    public String getTypeOfBusiness() {
        return typeOfBusiness;
    }

    public void setTypeOfBusiness(String typeOfBusiness) {
        this.typeOfBusiness = typeOfBusiness;
    }

    public String getBusinessDescription() {
        return businessDescription;
    }

    public void setBusinessDescription(String businessDescription) {
        this.businessDescription = businessDescription;
    }

    @Override
    public String toString() {
        return "Executor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", typeOfBusiness='" + typeOfBusiness + '\'' +
                ", businessDescription='" + businessDescription + '\'' +
                '}';
    }
}
