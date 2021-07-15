package com.example.workflow.jsonMap.results;

import com.example.workflow.jsonMap.results.dob.Dob;
import com.example.workflow.jsonMap.results.id.Id;
import com.example.workflow.jsonMap.results.location.Location;
import com.example.workflow.jsonMap.results.login.Login;
import com.example.workflow.jsonMap.results.picture.Picture;
import com.example.workflow.jsonMap.results.registered.Registered;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Results {
    @JsonProperty
    private Results results;

    @JsonProperty
    private String gender;

    @JsonProperty
    private Name name;

    @JsonProperty
    private Location location;

    @JsonProperty
    private String email;

    @JsonProperty
    private Login login;

    @JsonProperty
    private Dob dob;

    @JsonProperty
    private Registered registered;

    @JsonProperty
    private String phone;

    @JsonProperty
    private String cell;

    @JsonProperty
    private Id id;

    @JsonProperty
    private Picture picture;

    @JsonProperty
    private String nat;

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Dob getDob() {
        return dob;
    }

    public void setDob(Dob dob) {
        this.dob = dob;
    }

    public Registered getRegistered() {
        return registered;
    }

    public void setRegistered(Registered registered) {
        this.registered = registered;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public String getNat() {
        return nat;
    }

    public void setNat(String nat) {
        this.nat = nat;
    }

    @Override
    public String toString() {
        return "Results{" +
                "results=" + results +
                ", gender='" + gender + '\'' +
                ", name=" + name +
                ", location=" + location +
                ", email='" + email + '\'' +
                ", login=" + login +
                ", dob=" + dob +
                ", registered=" + registered +
                ", phone='" + phone + '\'' +
                ", cell='" + cell + '\'' +
                ", id=" + id +
                ", picture=" + picture +
                ", nat='" + nat + '\'' +
                '}';
    }
}
