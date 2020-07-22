package com.example.PropertiesData;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class ForRentPropertiesController {

    @Autowired
    ForRentPropertiesService service;

    @GetMapping("/forRentproperty")
    public List<ForRentProperties> getAllForRentProperties()
    {
        return service.findAll();
    }

    @GetMapping("/ForRentpropertyItem")
    public List<ForRentProperties> getForRentPropertiesByLocation(@RequestParam (value = "address") String request)
    {
       return service.findByLocation(request);
    }

}