package com.contact.form.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "orderdb")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "instructions")
    private String instructions;
    @Column(name = "deadline")
    private String deadline;
    @Column(name = "amount")
    private String amount;
    @Column(name = "plantype")
    private String plantype;
    @Column(name="status")
    private String status;

    public String getPlantype() {
        return plantype;
    }

    public void setPlantype(String plantype) {
        this.plantype = plantype;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", instructions='" + instructions + '\'' +
                ", deadline='" + deadline + '\'' +
                ", amount='" + amount + '\'' +
                ", plantype='" + plantype + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
