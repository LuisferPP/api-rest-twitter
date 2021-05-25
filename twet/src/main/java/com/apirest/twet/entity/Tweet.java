package com.apirest.twet.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tweet")
public class Tweet {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="usuario")
    private String usuario;

    @Column(name="texto")
    private String texto;

    @Column(name="localizacion")
    private String localizacion;

    @Column(name="validacion")
    private boolean validacion;
    
    @Column(name="idioma")
    private String idioma;

    public Tweet() {}

    public Tweet(int id, String usuario, String texto, String localizacion, boolean validacion, String idioma) {
        this.id = id;
        this.usuario = usuario;
        this.texto = texto;
        this.localizacion = localizacion;
        this.validacion = validacion;
        this.idioma = idioma;
    }

    public String getIdioma() {
    	return idioma;
    }
    
    public int getId() {
        return id;
    }

    public void setValidacion(boolean validacion) {
    	this.validacion = validacion;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }


    public String getTexto() {
        return texto;
    }

   
    public String getLocalizacion() {
        return localizacion;
    }


    public boolean getValidacion() {
        return validacion;
    }

    @Override
    public String toString() {
        return "Twet [id=" + id + ", usuario=" + usuario + ", password=" + texto + ", localizacion=" + localizacion
                + ", validacion=" + validacion + "]";
    }
}
