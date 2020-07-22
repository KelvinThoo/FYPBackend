package com.example.PropertiesData;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

@SpringBootApplication
@ComponentScan(basePackages= {"com.example.PropertiesData"})
public class PropertiesDataApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(PropertiesDataApplication.class);
		application.run(args);

	}
}