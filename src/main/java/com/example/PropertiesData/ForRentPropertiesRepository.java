package com.example.PropertiesData;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForRentPropertiesRepository extends JpaRepository<ForRentProperties, Long> {

    @Query(value = "select * from for_rent_properties", nativeQuery = true)
	List<ForRentProperties> ListAllForRentProperties();

    @Query(value = "select * from for_rent_properties where address like %?1%", nativeQuery = true)
    List<ForRentProperties> findForRentByLocation(String request);


}