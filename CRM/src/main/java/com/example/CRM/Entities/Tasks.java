package com.example.CRM.Entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Getter
@Setter
@Data
@Table(name = "tasks")
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    //@Enumerated(EnumType.STRING)
    /*The @Enumerated(EnumType.STRING) annotation tells Hibernate to store the enum values as strings in the database. The database field status will only accept these three values.

EnumType.STRING saves the string representation of the enum (e.g., COMPLETED, PENDING, or IN_PROGRESS) in the database.
If the enum value is set outside of these three options, Hibernate will throw an exception.*/
    @Column(name = "status")
    private String status;

    @Column(name = "due_date")
    private Date due_date;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contacts contact;

    @Column(name = "created_at")
    private Timestamp created_at;
}
