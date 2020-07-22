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
public class PropertiesController {

    @Autowired
    PropertiesService service;

    @GetMapping("/property")
    public List<Properties> getAllProperties()
    {
        return service.findAll();
    }

    @GetMapping("/propertyItem")
    public List<Properties> getPropertiesByLocation(@RequestParam (value = "address") String request)
    {
       return service.findByLocation(request);
    }

}