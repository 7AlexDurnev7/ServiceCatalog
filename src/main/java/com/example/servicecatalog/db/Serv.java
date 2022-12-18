package com.example.servicecatalog.db;

import jakarta.persistence.*;

@Entity
@Table(name = "service_t")
public class Serv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 200)
    private String serviceName;

    @Column(nullable = false, length = 200)
    private String description;

    @Column(nullable = false, length = 200)
    private String complexity;

    @Column(nullable = false, length = 200)
    private int periodOfExecution;

    @Column(nullable = false, length = 50)
    private int price;

    @Column(nullable = false, length = 200)
    private String executor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComplexity() {
        return complexity;
    }

    public void setComplexity(String complexity) {
        this.complexity = complexity;
    }

    public int getPeriodOfExecution() {
        return periodOfExecution;
    }

    public void setPeriodOfExecution(int periodOfExecution) {
        this.periodOfExecution = periodOfExecution;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", serviceName='" + serviceName + '\'' +
                ", description='" + description + '\'' +
                ", complexity='" + complexity + '\'' +
                ", periodOfExecution='" + periodOfExecution + '\'' +
                ", price=" + price +
                ", executor='" + executor + '\'' +
                '}';
    }
}
