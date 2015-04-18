/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.LibrosDAO;
import java.sql.Date;
import java.util.List;
import javafx.event.ActionEvent;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import orm.Libros;

/**
 *
 * @author ander
 */
@ManagedBean
@SessionScoped
@Named("libC")
public class LibrosController {

    //Objetos necesarios:
    private Libros libro;
    private List<Libros> listaLibros;
    
    @EJB
    LibrosDAO libDao;
    
    /**
     * Creates a new instance of LibrosController
     */
    public LibrosController() {
    }
    
    @PostConstruct
    public void inicializar(){
        setListaLibros(libDao.selectLibros());
    }

    public Libros getLibro() {
        return libro;
    }

    public void setLibro(Libros libro) {
        this.libro = libro;
    }

    public List<Libros> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(List<Libros> listaLibros) {
        this.listaLibros = listaLibros;
    }
    
    /*
    * METODOS QUE REDIRECCIONAN ACCIONES DE LA UI
    */
        
    public void doPrepararNuevoLibro(ActionEvent actionEvent){
        libro = new Libros();
        //return "frmNuevo";
    }
    
    public void doGuardarLibro(){

        libDao.insertLibro(libro);
        
        listaLibros = libDao.selectLibros();
    }
    
    public void doBorrarLibro(int isbn){
        libro = libDao.selectLibroPorISBN(isbn);
        libDao.deleteLibro(libro);
        listaLibros = libDao.selectLibros();
    }
    
}
