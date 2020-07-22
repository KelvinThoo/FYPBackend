package com.example.PropertiesData;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ForRentPropertiesService {
  
    @Autowired
    private ForRentPropertiesRepository repo;

    public List<ForRentProperties> findAll() {
        return repo.findAll();
    }

    public List<ForRentProperties> findByLocation(String request) {
        List<ForRentProperties> templist = repo.findForRentByLocation(request);
        for(int i = 0; i < templist.size(); i++) {
            if(templist.get(i).getBedroom().contains("N/A") && templist.get(i).getBedroom().contains("N/A"))
            {
                String[] newPrice = templist.get(i).getPrice().split("(?>RM |\\.)");
                String removeSpecial = newPrice[1];
                removeSpecial = removeSpecial.replaceAll("[^a-zA-Z0-9]", "");
                templist.get(i).setPrice(removeSpecial);
                templist.get(i).setBedroomNo("0");
                templist.get(i).setBathroomNo("0");
            }
            else {
                    String[] newPrice = templist.get(i).getPrice().split("(?>RM |\\.)");
                    String removeSpecial = newPrice[1];
                    removeSpecial = removeSpecial.replaceAll("[^a-zA-Z0-9]", "");
                    templist.get(i).setPrice(removeSpecial);
                    String removeWord = templist.get(i).getBedroom();
                    removeWord = removeWord.replaceAll("[^\\d.]", "");
                    templist.get(i).setBedroomNo(removeWord);
                    String removeWord2 = templist.get(i).getBathroom();
                    removeWord2 = removeWord2.replaceAll("[^\\d.]", "");
                    templist.get(i).setBathroomNo(removeWord2);
            }
        }
        return templist;
    }



}