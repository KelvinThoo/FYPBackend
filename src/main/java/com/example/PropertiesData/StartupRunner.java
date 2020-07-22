package com.example.PropertiesData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


@Component
public class StartupRunner implements CommandLineRunner {

    @Autowired
    private ForRentPropertiesRepository repo;

    @Override
    public void run(String...args) throws Exception {

    String [] URLs = new String[] {
            "https://www.starproperty.my/negeri-sembilan/seremban/to-rent/by-hari-vs/14581671",           
        };

 
//    for(int i = 0; i < URLs.length; i++) {
//    webScrapingForRent(URLs[i]);
//    }

  scraping();

}

    private void webScraping(String urls) {
    String info = ".property__info";
    String location = ".property__items > p";
    String price = ".property__price";
    String areaName = ".property__name";
    String imgSrc = "img";

    try {
        final Document document = Jsoup.connect(urls).userAgent("Chrome").get();
        Element propertyArea = document.select(areaName).first();
        Elements propertyDetails = document.select(info);
        Element propertyPriceTag = document.select(price).first();
        Element propertyLocation = document.select(location).first();
        Elements propertyImage = document.getElementsByTag(imgSrc);
        ArrayList<String> propertyInfos = new ArrayList<>();
        ArrayList<String> images = new ArrayList<>();

        for (Element e : propertyDetails) { 
            propertyInfos.add(e.text());
        }

        for (Element src : propertyImage) {
            images.add(src.attr("abs:src"));
        }
        
        String area = propertyArea.text();
        String priceTag = propertyPriceTag.text();
        String houseLocation = propertyLocation.text();
        String bathroom = propertyInfos.get(3);
        String bedroom = propertyInfos.get(2);
        String sqrft = propertyInfos.get(4);
        String image = images.get(2);

        System.out.println("Extracting data from the website...");
        System.out.println("Area name is: " + area);
        System.out.println("Price of property: " + priceTag);
        System.out.println("Number of bathroom: " + bathroom);
        System.out.println("Number of bedroom: " + bedroom);
        System.out.println("Square feet of property: " + sqrft);
        String [] locationFilter = houseLocation.split("(?=View)");
        System.out.println("Location of the area: " + locationFilter[0]);
        String address = area + "," + locationFilter[0];
        System.out.println(address);
        System.out.println(image);
        System.out.println("Property link: " + urls);

        Properties property = new Properties();
        property.setAreaName(area);
        property.setBathroomNo(bathroom);
        property.setBedroomNo(bedroom);
        property.setPrice(priceTag);
        property.setSquareFeet(sqrft);
        property.setLocation(locationFilter[0]);
        property.setImgSrc(image);
        property.setPropertyUrl(urls);
        property.setAddress(address);
      
//        repo.save(property);

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void webScrapingForRent(String urls) {
        String info = ".property__info";
        String location = ".property__items > p";
        String price = ".property__price";
        String areaName = ".property__name";
        String imgSrc = "img";
    
        try {
            final Document document = Jsoup.connect(urls).userAgent("Chrome").get();
            Element propertyArea = document.select(areaName).first();
            Elements propertyDetails = document.select(info);
            Element propertyPriceTag = document.select(price).first();
            Element propertyLocation = document.select(location).first();
            Elements propertyImage = document.getElementsByTag(imgSrc);
            ArrayList<String> propertyInfos = new ArrayList<>();
            ArrayList<String> images = new ArrayList<>();
    
            for (Element e : propertyDetails) { 
                propertyInfos.add(e.text());
            }
    
            for (Element src : propertyImage) {
                images.add(src.attr("abs:src"));
            }
            
            String area = propertyArea.text();
            String priceTag = propertyPriceTag.text();
            String houseLocation = propertyLocation.text();
            String bathroom = propertyInfos.get(3);
            String bedroom = propertyInfos.get(2);
            String sqrft = propertyInfos.get(4);
            String image = images.get(2);
    
            System.out.println("Extracting data from the website...");
            System.out.println("Area name is: " + area);
            System.out.println("Price of property: " + priceTag);
            System.out.println("Number of bathroom: " + bathroom);
            System.out.println("Number of bedroom: " + bedroom);
            System.out.println("Square feet of property: " + sqrft);
            String [] locationFilter = houseLocation.split("(?=View)");
            System.out.println("Location of the area: " + locationFilter[0]);
            String address = area + "," + locationFilter[0];
            System.out.println(address);
            System.out.println(image);
            System.out.println("Property link: " + urls);
    
            ForRentProperties property = new ForRentProperties();
            property.setAreaName(area);
            property.setBathroomNo(bathroom);
            property.setBedroomNo(bedroom);
            property.setPrice(priceTag);
            property.setSquareFeet(sqrft);
            property.setLocation(locationFilter[0]);
            property.setImgSrc(image);
            property.setPropertyUrl(urls);
            property.setAddress(address);
          
            repo.save(property);
    
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    private void scraping() {
        final String url = "https://www.iproperty.com.my/property/puchong/sale-9015800/";
        String area = ".PropertySummarystyle__ProjectTitleWrapper-cvJoqY.ifcFYS";
        String bedroom = ".property-features.PropertyFeatures__PropertyFeaturesWrapper-fAoHZZ.WBFTH";
        String price = ".property-price.ListingPrice__Price-cmdnCI.ieWmRM";
        try {
            final Document document = Jsoup.connect(url).userAgent("Chrome").get();
           
            Elements propertyDetails = document.select(bedroom);
            Element propertyArea = document.select(area).first();
            Element propertyPriceTag = document.select(price).first();
    
            String areaName = propertyArea.text();
            String priceTag = propertyPriceTag.text();
            String [] price_details = priceTag.split("(?=RM )");
            String details = propertyDetails.text();
            String [] room_details = details.split("(?= )");
    
            System.out.println("Extracting data from the website...");
            System.out.println("Area name is: " + areaName);
            System.out.println("Price of property: " + price_details[1]);
            System.out.println("Number of bathroom: " + room_details[1]);
            System.out.println("Number of bedroom: " + room_details[0]);
            // System.out.println("Location of the area: " + locationFilter[0]);
            // System.out.println(address);
            // System.out.println(image);
            // System.out.println("Property link: " + urls);
    
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
    }

    private void extractLinks() {
        final String url = "https://www.propertyguru.com.my/property-listing/tropicana-gardens-for-rent-by-gken-wong-30751027";
        String info = "a";
        try {
            final Document document = Jsoup.connect(url).userAgent("Chrome").get();
            for (Element e: document.getElementsByTag(info)) {
                System.out.println(e.attr("abs:href"));   
            }
    
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
    }

 
}