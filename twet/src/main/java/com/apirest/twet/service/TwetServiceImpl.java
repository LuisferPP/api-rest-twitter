package com.apirest.twet.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.twet.dao.TwetDAO;
import com.apirest.twet.entity.Tweet;

@Service
public class TwetServiceImpl implements TwetService {

    @Autowired
    private TwetDAO twetDAO;

    @Override
    public List<Tweet> findAll() {
        List<Tweet> listTwets= twetDAO.findAll();
        return listTwets;
    }

    @Override
    public Tweet findById(int id) {
        Tweet twet = twetDAO.findById(id);
        return twet;
    }

    @Override
    public void save(Tweet twet) {
        twetDAO.save(twet);

    }

    @Override
    public void deleteById(int id) {
        twetDAO.deleteById(id);
    }

    @Override
	public List<Tweet> findByUsuario(String nombre) {
		return twetDAO.findByUsuario(nombre);
		
	}

}