package com.example.PropertiesData;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertiesRepository extends JpaRepository<Properties, Long> {

    @Query(value = "select * from properties", nativeQuery = true)
	List<Properties> ListAllProperties();

    @Query(value = "select * from properties where address like %?1%", nativeQuery = true)
    List<Properties> findByLocation(String request);


}