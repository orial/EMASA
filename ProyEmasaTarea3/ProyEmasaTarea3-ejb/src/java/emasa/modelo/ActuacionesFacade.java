/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emasa.modelo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author malex
 */
@Stateless
public class ActuacionesFacade extends AbstractFacade<Actuaciones> {

    @PersistenceContext(unitName = "ProyEmasaTarea3-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActuacionesFacade() {
        super(Actuaciones.class);
    }
    
}
