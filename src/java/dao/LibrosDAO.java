/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import orm.Libros;

/**
 *
 * @author ander
 */
@Stateless
public class LibrosDAO {
    
    @PersistenceContext
    EntityManager em;
    
    public List<Libros> selectLibros() {
        Query q = em.createQuery("SELECT l FROM Libros l");
        return q.getResultList();
    }
    
    public Libros selectLibroPorISBN(int isbn){
        Query q;
        q = em.createQuery("Select l From Libros l Where l.isbn = :isbn");
        q.setParameter("isbn", isbn);
        return (Libros)q.getSingleResult();
    }
    
    public void insertLibro(Libros l) {
        em.persist(l);
    }
    
    public void updateLibro(Libros l){
        em.merge(l);
    }
    
    public void deleteLibro(Libros l){
        em.remove(em.merge(l));
    }
    
}
