package com.apirest.twet.controller;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

import com.apirest.twet.entity.Tweet;
import com.apirest.twet.service.TwetService;

import twitter4j.Twitter;

@RestController
@RequestMapping("/twet") 

public class TwetRestController {
	int N = 1500; 
	List<String> idiomas = Arrays.asList("Español", "Frances", "Ingles");
	private Twitter twitter = (Twitter) new TwitterFactory().getInstance(); 
	
			
			//twitter.verifyCredentials(); 
	//int followers = usuario.getFollowersCount();
	//List<Twitter> friends = ((Object) twitter).friendOperations().getFriends();	
	
    @Autowired
    private TwetService twetService;

    @GetMapping("/twets")
    public List<Tweet> findAll(){
    	
        return twetService.findAll();
    }

    @GetMapping("/twets/{twetId}")
    public Tweet getTwet(@PathVariable int twetId){
        Tweet twet = twetService.findById(twetId);

        if(twet == null) {
            throw new RuntimeException("Twet id not found -"+twetId);
        }
        
        return twet;
    }

    @GetMapping("/twets/{nombreUser}")
    public List<Tweet> getTwetsValidados(@RequestBody User user){
    	String nombre = user.getName();
    	List<Tweet> twets = twetService.findByUsuario(nombre);
    	
		return twets;
    	
    }
    
    @PostMapping("/twets")
    public Tweet addTwet(@RequestBody Tweet twet) throws TwitterException {
    	String nombreUsuario = twet.getUsuario();
    	User usuario = twitter.showUser(nombreUsuario);
        if(usuario.getFollowersCount() > N && idiomas.contains(twet.getIdioma()) )
        	
        twetService.save(twet);
        else 
        	System.out.println("Twet no guardado por tener pocos seguidores");
        return twet;

    }
    
    @PostMapping("/twets/{twetId}")
    public void marcarTwet(@PathVariable int twetId){
    	Tweet twet = twetService.findById(twetId);
    	if(!twet.getValidacion())
    		twet.setValidacion(true);
    	System.out.println("Twet validado");
    }
  
    /*@PutMapping("/twets")
    public Tweet updateTwet(@RequestBody Tweet twet) {

        twetService.save(twet);

        //este metodo actualizará al usuario enviado

        return twet;
    }*/

    
    /*@DeleteMapping("twets/{twetId}")
    public String deteteTwet(@PathVariable int twetId) {

        Tweet twet = twetService.findById(twetId);

        if(twet == null) {
            throw new RuntimeException("Twet id not found -"+twetId);
        }

        twetService.deleteById(twetId);

        //Esto método, recibira el id de un twet por URL y se borrará de la bd.
        return "Deleted twet id - "+twetId;
    }*/

}