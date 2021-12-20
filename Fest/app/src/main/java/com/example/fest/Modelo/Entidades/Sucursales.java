package com.example.fest.Modelo.Entidades;

public class Sucursales {
    private int id;
    private String location;
    private String place;
    private String phone;
    private byte[] image;

    public Sucursales(int id, String location, String place, String phone, byte[] image) {
        this.id = id;
        this.location = location;
        this.place = place;
        this.phone = phone;
        this.image = image;
    }

    public Sucursales() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
