package br.com.caelum.vraptor.producers;

import br.com.caelum.vraptor.util.JPAUtil;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;

/**
 * @author ARCE - Davi Mustafa
 * @date 19/09/16
 */
public class EntityManagerProducer {

    @Produces
    @RequestScoped
    public EntityManager criaEntityManager(){
        return JPAUtil.criaEntityManager();
    }
}
