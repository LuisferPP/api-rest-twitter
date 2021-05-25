package com.apirest.twet.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.twet.entity.Tweet;


public interface TwetDAO {

	public List<Tweet> findAll();
	
	public Tweet findById(int id);
	
	public void save(Tweet twet);
	
	public void deleteById(int id);
	
	public List<Tweet> findByUsuario(String nombre);
	
	
}
