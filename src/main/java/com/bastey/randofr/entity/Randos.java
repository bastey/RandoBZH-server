package com.bastey.randofr.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Liste de randonnées.
 * 
 * @author bastey
 * @version 1.0
 * 
 */
public class Randos {

    /** Liste des randonnées. */
    private Set<Rando> listeRandos = new HashSet<Rando>();

    /**
     * @return the listeRandos
     */
    public Set<Rando> getListeRandos() {
        return listeRandos;
    }

    /**
     * @param listeRandos the listeRandos to set
     */
    public void setListeRandos(Set<Rando> listeRandos) {
        this.listeRandos = listeRandos;
    }

}
