package com.padma.Advartise.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.padma.Advartise.Repo.AdvertisesRepository;
import com.padma.Advartise.entity.Advertises;
import com.padma.Advartise.entity.AdvertisesApiResponcse;

@Service
public class OlxAdvertisesServiceImpl implements OlxAdvertisesService{

	
	@Autowired
	AdvertisesRepository advrepo;
// To add new advertises
	@Override
	public Advertises newAdvertise(Advertises ad) {
	ad.setCreatedate(LocalDate.now());
	ad.setModifydate(LocalDate.now());
	Advertises adv = advrepo.save(ad);
	return adv;
	}
// To update existing advertise
	@Override
	public Advertises updateAdvertise(Advertises ad, Integer id) {
	ad.setModifydate(LocalDate.now());
	Optional<Advertises> advertise = advrepo.findById(id);
	if (advertise != null) {
	return advrepo.save(ad);
	}
	return null;
	}
// To read all the advertise posted by logged in user
	@Override
	public List<Advertises> getAllAdvertises() {
	return advrepo.findAll();
	}
// Deletes specific advertisement posted by logged in user
	@Override
	public boolean deleteAdvertiseById(Integer id) {
advrepo.deleteById(id);
	if (advrepo.findById(id) != null) {
	return false;
	}
	return true;
	}
// Matches advertisements using the provided 'searchText' within all fields
	// of an advertise.
	@Override
	public Advertises getAdvertiseByText(String text) {
	Advertises advertise = ((OlxAdvertisesServiceImpl) advrepo).getAdvertiseByText(text);
	return advertise;
	}
// Get Advertise by id
	@Override
	public AdvertisesApiResponcse getAdvertisesById(Integer id) {

    Advertises adv = null;
	Optional<Advertises> advertise = advrepo.findById(id);

	if (advertise.isPresent()) {
	adv= advertise.get();
	}

	Map<String, String> params = new HashMap<String, String>();
params.put("id", String.valueOf(adv.getStatus()));

RestTemplate restTemplate= new RestTemplate();
String status= restTemplate.getForObject("http://localhost:8088/advertise/status/{id}", String.class, params);
params.put("id", String.valueOf(adv.getCategory()));
String catag= restTemplate.getForObject("http://localhost:8088/advertise/category/{id}", String.class, params);
return getAdvertisesApiResponse(adv,catag,status);
}


	private AdvertisesApiResponcse getAdvertisesApiResponse(Advertises ad,String catag,String status) {

		AdvertisesApiResponcse advertisesApiResponse = new AdvertisesApiResponcse();
		advertisesApiResponse.setId(ad.getId());
		advertisesApiResponse.setCategory(catag);
		advertisesApiResponse.setDescription(ad.getDescription());
		advertisesApiResponse.setModifeddate(ad.getModifydate());
		advertisesApiResponse.setPrice(ad.getPrice());
		advertisesApiResponse.setStatus(status);
		advertisesApiResponse.setTitle(ad.getTitle());
		advertisesApiResponse.setUsername(ad.getUsername());
		return advertisesApiResponse;


	}
@Override
	public Advertises getAdvertisesById1(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}



	




