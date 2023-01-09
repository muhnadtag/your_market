package com.your_market;

// الكلاس المسؤول عن فئات منتجات السووق
public class ItemCategories {

    // رقم الفئة
    String id ;
    // إسم الفئة
    String name;
    // صورة الفئة

    // constructor
    public ItemCategories(String id, String name) {
        this.id = id;
        this.name = name;
    }

    //set and get method

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
