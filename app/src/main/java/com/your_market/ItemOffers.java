package com.your_market;

 // الكلاس المسؤول عن عناصر منتجات السوق
public class ItemOffers {

 // أسم المنتج
 String name ;
 // سعر المنتج
 String price ;
 // صورة المنتج
 String image;
 // وصف المنتج
 String description ;
 // موقع العرض
 String location;
 // أسم المعلن
 String marketerName ;
 // رقم المعلن
 String marketerPhone;
 // الفئة
 String Category ;

     // constructor


     public ItemOffers(String name, String price, String image, String description, String location, String marketerName, String marketerPhone, String category) {
         this.name = name;
         this.price = price;
         this.image = image;
         this.description = description;
         this.location = location;
         this.marketerName = marketerName;
         this.marketerPhone = marketerPhone;
         Category = category;
     }


     //set and get method


     public String getCategory() {
         return Category;
     }

     public void setCategory(String category) {
         Category = category;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public String getPrice() {
         return price;
     }

     public void setPrice(String price) {
         this.price = price;
     }

     public String getImage() {
         return image;
     }

     public void setImage(String image) {
         this.image = image;
     }

     public String getDescription() {
         return description;
     }

     public void setDescription(String description) {
         this.description = description;
     }

     public String getLocation() {
         return location;
     }

     public void setLocation(String location) {
         this.location = location;
     }

     public String getMarketerName() {
         return marketerName;
     }

     public void setMarketerName(String marketerName) {
         this.marketerName = marketerName;
     }

     public String getMarketerPhone() {
         return marketerPhone;
     }

     public void setMarketerPhone(String marketerPhone) {
         this.marketerPhone = marketerPhone;
     }
 }
