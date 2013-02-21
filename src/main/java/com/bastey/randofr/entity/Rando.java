package com.bastey.randofr.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Objet Randonnée.
 * 
 * @author bastey
 * @version 1.0
 * 
 */
public class Rando {

	/** Reference de la rando. */
	private int id;

	/** Type de sport. */
	private EnumTypeSport typeSport;

	/** DEPARTEMENT. */
	private int departement;

	/** DATE de la rando. */
	private Date date;

	/** LIEU. */
	private String lieu;

	/** NOM DE LA RANDO. */
	private String nom;

	/** ORGANISATEUR. */
	private String organisateur;

	/** LIEU DU RDV. */
	private String lieuRdv;

	/** HORAIRES. */
	private String horaires;

	/** SITE INTERNET DE LA SORTIE. */
	private String siteWeb;

	/** PRIX PUBLIC. */
	private String prixPublic;

	/** PRIX CLUB. */
	private String prixClub;

	/** CONTACT. */
	private String contact;

	/** DESCRIPTION. */
	private String description;

	/** URL FLYER. */
	// http://www.nafix.fr/tracts/flyer-99-les-portes-de-l-arree-2012-15966.html
	// http://www.nafix.fr/tracts/2012/tract_22991.pdf
	private String urlFlyer;

	/** URL PAGE WEB DETAIL DE LA RANDO. */
	private String urlDetailWeb;

	/**
	 * Constructeur par défaut.
	 */
	public Rando() {
		super();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the typeSport
	 */
	public EnumTypeSport getTypeSport() {
		return typeSport;
	}

	/**
	 * @return the departement
	 */
	public int getDepartement() {
		return departement;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @return the date au format yyyy-MM-dd
	 */
	public String getDateStr() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}

	/**
	 * @return the lieu
	 */
	public String getLieu() {
		return lieu;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @return the organisateur
	 */
	public String getOrganisateur() {
		return organisateur;
	}

	/**
	 * @return the lieuRdv
	 */
	public String getLieuRdv() {
		return lieuRdv;
	}

	/**
	 * @return the horaires
	 */
	public String getHoraires() {
		return horaires;
	}

	/**
	 * @return the siteWeb
	 */
	public String getSiteWeb() {
		return siteWeb;
	}

	/**
	 * @return the prixPublic
	 */
	public String getPrixPublic() {
		return prixPublic;
	}

	/**
	 * @return the prixClub
	 */
	public String getPrixClub() {
		return prixClub;
	}

	/**
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the urlFlyer
	 */
	public String getUrlFlyer() {
		return urlFlyer;
	}

	/**
	 * @return the urlDetailWeb
	 */
	public String getUrlDetailWeb() {
		return urlDetailWeb;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int pId) {
		this.id = pId;
	}

	/**
	 * @param typeSport
	 *            the typeSport to set
	 */
	public void setTypeSport(EnumTypeSport typeSport) {
		this.typeSport = typeSport;
	}

	/**
	 * @param departement
	 *            the departement to set
	 */
	public void setDepartement(int departement) {
		this.departement = departement;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @param lieu
	 *            the lieu to set
	 */
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @param organisateur
	 *            the organisateur to set
	 */
	public void setOrganisateur(String organisateur) {
		this.organisateur = organisateur;
	}

	/**
	 * @param lieuRdv
	 *            the lieuRdv to set
	 */
	public void setLieuRdv(String lieuRdv) {
		this.lieuRdv = lieuRdv;
	}

	/**
	 * @param horaires
	 *            the horaires to set
	 */
	public void setHoraires(String horaires) {
		this.horaires = horaires;
	}

	/**
	 * @param siteWeb
	 *            the siteWeb to set
	 */
	public void setSiteWeb(String siteWeb) {
		this.siteWeb = siteWeb;
	}

	/**
	 * @param prixPublic
	 *            the prixPublic to set
	 */
	public void setPrixPublic(String prixPublic) {
		this.prixPublic = prixPublic;
	}

	/**
	 * @param prixClub
	 *            the prixClub to set
	 */
	public void setPrixClub(String prixClub) {
		this.prixClub = prixClub;
	}

	/**
	 * @param contact
	 *            the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param urlFlyer
	 *            the urlFlyer to set
	 */
	public void setUrlFlyer(String urlFlyer) {
		this.urlFlyer = urlFlyer;
	}

	/**
	 * @param urlDetailWeb
	 *            the urlDetailWeb to set
	 */
	public void setUrlDetailWeb(String urlDetailWeb) {
		this.urlDetailWeb = urlDetailWeb;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String TAB = "   ";
		// char LF = CharUtils.LF;
		String LF = "\n";
		StringBuffer sb = new StringBuffer();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sb.append("Rando : '").append(id).append("'");
		sb.append(LF).append(TAB).append("Sport : '").append(typeSport.name()).append("'");
		sb.append(LF).append(TAB).append("Departement : '").append(departement).append("'");
		sb.append(LF).append(TAB).append("Date : '").append(sdf.format(date)).append("'");
		sb.append(LF).append(TAB).append("Nom : '").append(nom).append("'");
		sb.append(LF).append(TAB).append("Site web : '").append(siteWeb).append("'");
		sb.append(LF).append(TAB).append("Lieu : '").append(lieu).append("'");
		sb.append(LF).append(TAB).append("Organisateur : '").append(organisateur).append("'");
		sb.append(LF).append(TAB).append("Contact : '").append(contact).append("'");
		sb.append(LF).append(TAB).append("Horaires : '").append(horaires).append("'");
		sb.append(LF).append(TAB).append("Prix public : '").append(prixPublic).append("'");
		sb.append(LF).append(TAB).append("Prix club : '").append(prixClub).append("'");
		sb.append(LF).append(TAB).append("Lieu RDV : '").append(lieuRdv).append("'");
		sb.append(LF).append(TAB).append("Description : '").append(description).append("'");
		sb.append(LF).append(TAB).append("URL detail : '").append(urlDetailWeb).append("'");
		return sb.toString();
	}
}
