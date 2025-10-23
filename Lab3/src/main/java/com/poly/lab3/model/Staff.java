package com.poly.lab3.model;

import java.util.Date;

public class Staff {
    private String id;
    private String fullname;
    private String photo;
    private Boolean gender;
    private Date birthday;
    private Double salary;
    private Integer level;

    public Staff() {}

    // getters + setters
    // (generate with IDE; paste minimal below)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getFullname() { return fullname; }
    public void setFullname(String fullname) { this.fullname = fullname; }
    public String getPhoto() { return photo; }
    public void setPhoto(String photo) { this.photo = photo; }
    public Boolean getGender() { return gender; }
    public void setGender(Boolean gender) { this.gender = gender; }
    public Date getBirthday() { return birthday; }
    public void setBirthday(Date birthday) { this.birthday = birthday; }
    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }
    public Integer getLevel() { return level; }
    public void setLevel(Integer level) { this.level = level; }
}
