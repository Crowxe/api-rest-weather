package com.crow.clima.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crow.clima.entity.TopCitiesEntity;

public interface TopCitiesRepository extends JpaRepository<TopCitiesEntity, String> {

	TopCitiesEntity findByLocalizedName(String localized_name);

}
