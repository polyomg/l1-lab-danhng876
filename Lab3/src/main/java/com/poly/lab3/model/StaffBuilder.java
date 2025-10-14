package com.poly.lab3.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StaffBuilder {
    private Staff s = new Staff();

    public StaffBuilder id(String id) { s.setId(id); return this; }
    public StaffBuilder fullname(String name) { s.setFullname(name); return this; }
    public StaffBuilder photo(String photo) { s.setPhoto(photo); return this; }
    public StaffBuilder gender(Boolean gender) { s.setGender(gender); return this; }
    public StaffBuilder birthday(Date d) { s.setBirthday(d); return this; }
    public StaffBuilder salary(Double val) { s.setSalary(val); return this; }
    public StaffBuilder level(Integer lv) { s.setLevel(lv); return this; }
    public Staff build() { return s; }

    // helper to parse date from yyyy-MM-dd
    public static Date parse(String ymd){
        try { return new SimpleDateFormat("yyyy-MM-dd").parse(ymd); }
        catch(Exception e){ return new Date(); }
    }
}
