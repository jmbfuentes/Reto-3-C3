package com.reto.reto3.model;

import java.util.List;

import javax.persistence.CascadeType;

//import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "partyroom")
public class Partyroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String owner;
    private Integer capacity;
    private String description;
    
    //muchos partyroon a una categoria 1
    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("partyrooms")
    private Category category;
    
    //un partyroom tiene muchos mensajes 2
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "partyroom")
    //@JsonIgnoreProperties("partyroom")
    @JsonIgnoreProperties({"partyroom","client"})
    private List<Message> messages;
    
    //un partyroom tiene muchas reservaciones3
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "partyroom")
    @JsonIgnoreProperties("partyroom")
    private List<Reservation> reservations;

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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

   
    
}
