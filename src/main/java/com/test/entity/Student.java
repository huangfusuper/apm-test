package com.test.entity;

import java.util.Date;

/**
 * @author huangfu
 */
public class Student {
    private Integer id;
    private String name;
    private String clazz;
    private Date date;

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

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Student(Integer id, String name, String clazz, Date date) {
        this.id = id;
        this.name = name;
        this.clazz = clazz;
        this.date = date;
    }

    public Student() {
    }
}
