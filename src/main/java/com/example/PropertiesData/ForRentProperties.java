package com.example.PropertiesData;

import java.util.Date;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "for_rent_properties")
public class ForRentProperties {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String areaName;
    private String bedroomNo;
    private String bathroomNo;
    private String location;
    private String price;
    private String squareFeet;
    private String imgSrc;
    private String propertyUrl;
    private String address;
    private String status;

    protected ForRentProperties() {}

    public ForRentProperties(String areaName,String bedroomNo, String bathroomNo, String location, String price, String squareFeet, String imgSrc,String propertyUrl, String address, String status) {
        this.areaName = areaName;
        this.bedroomNo = bedroomNo;
        this.bathroomNo = bathroomNo;
        this.location = location;
        this.price = price;
        this.squareFeet = squareFeet;
        this.imgSrc = imgSrc;
        this.propertyUrl = propertyUrl;
        this.address = address;
        this.status = status;
    }

    @Column(name="area_name")
    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    @Column(name = "bedroom_no")
    public String getBedroom() {
        return bedroomNo;
    }

    public void setBedroomNo(String bedroomNo) {
        this.bedroomNo = bedroomNo;
    }

    @Column(name = "bathroom_no")
    public String getBathroom() {
        return bathroomNo;
    }

    public void setBathroomNo(String bathroomNo) {
        this.bathroomNo = bathroomNo;
    }

    @Column(name = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Column(name = "price")
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
    @Column(name = "square_feet")
    public String getSquareFeet() {
        return squareFeet;
    }

    public void setSquareFeet(String squareFeet) {
        this.squareFeet = squareFeet;
    }

    @Column(name = "img_src")
    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    @Column(name = "property_url")
    public void setPropertyUrl(String propertyUrl) {
        this.propertyUrl = propertyUrl;
    }

    public String getPropertyUrl() {
        return propertyUrl;
    }

    @Column(name = "address")
    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    @Column(name = "status")
    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}