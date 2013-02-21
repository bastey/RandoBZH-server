package com.bastey.randofr.reader;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.htmlparser.visitors.TextExtractingVisitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bastey.randofr.entity.EnumUrlRando;
import com.bastey.randofr.entity.Rando;
import com.bastey.randofr.entity.Randos;

/**
 * Parser permettant de récupérer les informations d'une rando.
 * 
 * @author bastey
 * 
 */
public class ParserDetailRando {
	private static Logger logger = LoggerFactory.getLogger(ParserDetailRando.class);

	/** Parser HTML. */
	private Parser parser = new Parser();

	/** URL permettant de récupérer la liste des randos. */
	private EnumUrlRando URLtoParse;

	/**
	 * Constructeur.
	 * 
	 * @param uRLtoParse
	 */
	public ParserDetailRando(EnumUrlRando pUrltoParse) {
		super();
		URLtoParse = pUrltoParse;
	}

	/**
	 * Permet de parser une page HTML de detail d'une rando
	 * 
	 * @param randos Liste des randos
	 * @param url URL de détail rando
	 * @return rando
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws SecurityException
	 * @throws UnsupportedEncodingException
	 */
	public Rando parserDetailRando(Randos randos, String url) throws SecurityException, InvocationTargetException,
			NoSuchMethodException, UnsupportedEncodingException {

		Rando rando = null;
		try {
			parser.setURL(url);

			// On filtre pour récupérer uniquement le <BODY></BODY>
			TagNameFilter filterBody = new TagNameFilter("body");
			NodeList list = parser.parse(filterBody);

			// sans filtre sur le body
			// NodeList list = parser.parse(null);

			// On extrait toutes les données textes du <BODY>
			TextExtractingVisitor visitor = new TextExtractingVisitor();
			list.visitAllNodesWith(visitor);
			String detailRandoText = visitor.getExtractedText();

			// logger.debug(detailRandoText);

			// Extraction des informations de détail
			rando = extraireDetailRando(detailRandoText, url);
			randos.getListeRandos().add(rando);

			// } catch (UnsupportedEncodingException e) {
			// logger.error("Error de conversion en UTF-8 lors de la conversion de la rando : "
			// + url);
		} catch (ParserException e) {
			logger.error("Erreur lors de la récupération du détail de la rando : " + url);
		}

		return rando;
	}

	/**
	 * Méthode d'extraction des données d'une rando.
	 * 
	 * @param detailRandoText Detail d'une rando
	 * @param url URL de la rando
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	private Rando extraireDetailRando(String detailRandoText, String url) throws UnsupportedEncodingException {

		Rando rando = new Rando();
		rando.setUrlDetailWeb(url);
		rando.setTypeSport(URLtoParse.getSport());

		// Référence
		String textDeb = "R\u00E9f\u00E9rence interne de l'annonce ......:";
		String textFin = "Date......";
		int indexDeb = StringUtils.indexOf(detailRandoText, textDeb) + textDeb.length();
		int indexFin = StringUtils.indexOf(detailRandoText, textFin);
		if (indexDeb >= 0 && indexFin >= 0 && indexFin >= indexDeb) {
			String result = StringUtils.stripToEmpty(StringUtils.substring(detailRandoText, indexDeb, indexFin));
			rando.setId(Integer.valueOf(result));
		}

		// Site Web de la sortie
		textDeb = "Site de la sortie ..:";
		textFin = "Horaires ....";
		indexDeb = StringUtils.indexOf(detailRandoText, textDeb) + textDeb.length();
		indexFin = StringUtils.indexOf(detailRandoText, textFin);
		if (indexDeb >= 0 && indexFin >= 0 && indexFin >= indexDeb) {
			String result = StringUtils.stripToEmpty(StringUtils.substring(detailRandoText, indexDeb, indexFin));
			rando.setSiteWeb(result);
		}

		// - Departement
		textDeb = "D\u00E9partement........:";
		textFin = "Lieu";
		indexDeb = StringUtils.indexOf(detailRandoText, textDeb) + textDeb.length();
		indexFin = StringUtils.indexOf(detailRandoText, textFin);
		if (indexDeb >= 0 && indexFin >= 0 && indexFin >= indexDeb) {
			String result = StringUtils.stripToEmpty(StringUtils.substring(detailRandoText, indexDeb, indexFin));
			rando.setDepartement(Integer.valueOf(result));
		}

		// - Contact
		textDeb = "Contact.............:";
		textFin = "Description.......:";
		indexDeb = StringUtils.indexOf(detailRandoText, textDeb) + textDeb.length();
		indexFin = StringUtils.indexOf(detailRandoText, textFin);
		if (indexDeb >= 0 && indexFin >= 0 && indexFin >= indexDeb) {
			String result = StringUtils.stripToEmpty(StringUtils.substring(detailRandoText, indexDeb, indexFin));
			result = StringUtils.replace(result, "'", "''");
			rando.setContact(result);
		}

		// - Description
		textDeb = "Description.......:";
		textFin = "RETROUVEZ TOUTES LES SORTIES SUR : http://vttrando.free.fr";
		indexDeb = StringUtils.indexOf(detailRandoText, textDeb) + textDeb.length();
		indexFin = StringUtils.indexOf(detailRandoText, textFin);
		if (indexDeb >= 0 && indexFin >= 0 && indexFin >= indexDeb) {
			String result = StringUtils.stripToEmpty(StringUtils.substring(detailRandoText, indexDeb, indexFin));
			result = StringUtils.replace(result, "'", "''");
			rando.setDescription(result);
		}

		// - Nom sortie
		textDeb = "DETAILS DE LA SORTIE :";
		textFin = "Date..................:";
		indexDeb = StringUtils.indexOf(detailRandoText, textDeb) + textDeb.length();
		indexFin = StringUtils.indexOf(detailRandoText, textFin);
		if (indexDeb >= 0 && indexFin >= 0 && indexFin >= indexDeb) {
			String result = StringUtils.stripToEmpty(StringUtils.substring(detailRandoText, indexDeb, indexFin));
			result = StringUtils.replace(result, "'", "''");
			rando.setNom(result);
		}

		// - Date
		textDeb = "Date..................:";
		textFin = "D\u00E9partement......:";
		indexDeb = StringUtils.indexOf(detailRandoText, textDeb) + textDeb.length();
		indexFin = StringUtils.indexOf(detailRandoText, textFin);
		if (indexDeb >= 0 && indexFin >= 0 && indexFin >= indexDeb) {
			String result = StringUtils.stripToEmpty(StringUtils.substring(detailRandoText, indexDeb, indexFin));
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			try {
				rando.setDate(sdf.parse(result));
			} catch (ParseException e) {
				// TODO
				System.out.println(result);
			}
		}

		// - Lieu
		textDeb = "Lieu..................:";
		textFin = "Organisateur......:";
		indexDeb = StringUtils.indexOf(detailRandoText, textDeb) + textDeb.length();
		indexFin = StringUtils.indexOf(detailRandoText, textFin);
		if (indexDeb >= 0 && indexFin >= 0 && indexFin >= indexDeb) {
			String result = StringUtils.stripToEmpty(StringUtils.substring(detailRandoText, indexDeb, indexFin));
			result = StringUtils.replace(result, "'", "''");
			rando.setLieu(result);
		}

		// - Organisateur
		textDeb = "Organisateur......:";
		textFin = "Horaires............:";
		indexDeb = StringUtils.indexOf(detailRandoText, textDeb) + textDeb.length();
		indexFin = StringUtils.indexOf(detailRandoText, textFin);
		if (indexDeb >= 0 && indexFin >= 0 && indexFin >= indexDeb) {
			String result = StringUtils.stripToEmpty(StringUtils.substring(detailRandoText, indexDeb, indexFin));
			result = StringUtils.replace(result, "'", "''");
			rando.setOrganisateur(result);
		}

		// - Horaires
		textDeb = "Horaires............:";
		textFin = "Prix public.........:";
		indexDeb = StringUtils.indexOf(detailRandoText, textDeb) + textDeb.length();
		indexFin = StringUtils.indexOf(detailRandoText, textFin);
		if (indexDeb >= 0 && indexFin >= 0 && indexFin >= indexDeb) {
			String result = StringUtils.stripToEmpty(StringUtils.substring(detailRandoText, indexDeb, indexFin));
			result = StringUtils.replace(result, "'", "''");
			rando.setHoraires(result);
		}

		// - Prix public
		textDeb = "Prix public.........:";
		textFin = "Prix club............:";
		indexDeb = StringUtils.indexOf(detailRandoText, textDeb) + textDeb.length();
		indexFin = StringUtils.indexOf(detailRandoText, textFin);
		if (indexDeb >= 0 && indexFin >= 0 && indexFin >= indexDeb) {
			String result = StringUtils.stripToEmpty(StringUtils.substring(detailRandoText, indexDeb, indexFin));
			// result = StringUtils.replace(result, "?", "\u20AC");
			result = StringUtils.replace(result, "'", "''");
			rando.setPrixPublic(result);
		}

		// - Prix club
		textDeb = "Prix club............:";
		textFin = "Lieu de R-d-V....:";
		indexDeb = StringUtils.indexOf(detailRandoText, textDeb) + textDeb.length();
		indexFin = StringUtils.indexOf(detailRandoText, textFin);
		if (indexDeb >= 0 && indexFin >= 0 && indexFin >= indexDeb) {
			String result = StringUtils.stripToEmpty(StringUtils.substring(detailRandoText, indexDeb, indexFin));
			// result = StringUtils.replace(result, "?", "\u20AC");
			result = StringUtils.replace(result, "'", "''");
			rando.setPrixClub(result);
		}

		// - Lieu de R-d-V
		textDeb = "Lieu de R-d-V....:";
		textFin = "Contact.............:";
		indexDeb = StringUtils.indexOf(detailRandoText, textDeb) + textDeb.length();
		indexFin = StringUtils.indexOf(detailRandoText, textFin);
		if (indexDeb >= 0 && indexFin >= 0 && indexFin >= indexDeb) {
			String result = StringUtils.stripToEmpty(StringUtils.substring(detailRandoText, indexDeb, indexFin));
			result = StringUtils.replace(result, "'", "''");
			rando.setLieuRdv(result);
		}

		// FIXME if all ok, else null
		return rando;
	}

	/**
	 * @return the uRLtoParse
	 */
	public EnumUrlRando getURLtoParse() {
		return URLtoParse;
	}

	/**
	 * @param uRLtoParse the uRLtoParse to set
	 */
	public void setURLtoParse(EnumUrlRando uRLtoParse) {
		URLtoParse = uRLtoParse;
	}
}
