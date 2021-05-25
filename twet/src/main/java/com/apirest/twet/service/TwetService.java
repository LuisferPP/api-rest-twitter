package com.apirest.twet.service;
import com.apirest.twet.entity.Tweet;
import java.util.List;

public interface TwetService {
	
	public List<Tweet> findAll();

    public Tweet findById(int id);

    public void save(Tweet user);

    public void deleteById(int id);
    
	public List<Tweet> findByUsuario(String nombre);

}
