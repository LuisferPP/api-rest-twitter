package com.apirest.twet.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apirest.twet.entity.Tweet;

@Repository
public class TwetDAOImpl implements TwetDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Tweet> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Tweet> theQuery = currentSession.createQuery("from Tweet", Tweet.class);

        List<Tweet> twets = theQuery.getResultList();

        return twets;

    }

    @Override
    public Tweet findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Tweet twet = currentSession.get(Tweet.class, id);

        return twet;
    }

    @Override
    public void save(Tweet twet) {
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(twet);  

    }

    @Override
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Tweet> theQuery = currentSession.createQuery("delete from Tweet where id=:idTwet");

        theQuery.setParameter("idTwet", id);
        theQuery.executeUpdate();

    }

	@Override
	public List<Tweet> findByUsuario(String nombre) {
		
		Session currentSession = entityManager.unwrap(Session.class);

        Query<Tweet> theQuery = currentSession.createQuery("Select * from Tweet where nombre=:usuario");

       
		return (List<Tweet>) theQuery;
	}


}
