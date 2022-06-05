package com.padma.Advartise.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.padma.Advartise.entity.Advertises;

public interface AdvertisesRepository extends JpaRepository<Advertises, Integer>{
	List<Advertises> findAdvertisesByTitle(String title);
}
