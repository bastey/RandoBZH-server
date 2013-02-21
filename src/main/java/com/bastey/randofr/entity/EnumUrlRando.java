package com.bastey.randofr.entity;

/**
 * Enumeration des URL de randos.
 * 
 * @author bastey
 */
public enum EnumUrlRando {

    /** Liste des randos VTT Bretagne */
    VTT("http://www.nafix.fr/flux_mobile/Mobile-08-Bretagne-vtt.xml", EnumTypeSport.VTT),

    /** Liste des randos Cyclo Bretagne */
    CYCLO("http://www.nafix.fr/flux_mobile/Mobile-08-Bretagne-cyclo.xml", EnumTypeSport.CYCLO),
    /** Liste des randos Marche Bretagne */
    MARCHE("http://www.nafix.fr/flux_mobile/Mobile-08-Bretagne-marche.xml", EnumTypeSport.MARCHE),

    /** Liste des randos VTT Bretagne a venir */
    VTT_A_VENIR("http://www.nafix.fr/flux_mobile/Mobile-08-Bretagne-vtt-a-venir.xml", EnumTypeSport.VTT),

    /** Liste des randos Cyclo Bretagne a venir */
    CYCLO_A_VENIR("http://www.nafix.fr/flux_mobile/Mobile-08-Bretagne-cyclo-a-venir.xml", EnumTypeSport.CYCLO),

    /** Liste des randos Marche Bretagne a venir */
    MARCHE_A_VENIR("http://www.nafix.fr/flux_mobile/Mobile-08-Bretagne-marche-a-venir.xml", EnumTypeSport.MARCHE);

    /**
     * Constucteur.
     */
    private EnumUrlRando(String pUrl, EnumTypeSport pSport) {
        this.url = pUrl;
        this.sport = pSport;
    }

    /** URL listant les randos. */
    private String url;
    /** Type de sport associé a la liste des randos. */
    private EnumTypeSport sport;

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @return the sport
     */
    public EnumTypeSport getSport() {
        return sport;
    }

}
