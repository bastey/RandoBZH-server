package com.bastey.randofr.reader;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author bastey
 */
public class ParserListeRandosHandler extends DefaultHandler {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(ParserListeRandosHandler.class);

	// Resultat du parsing
	private List<String> listeUrlRandos;

	// flags nous indiquant la position du parseur
	@SuppressWarnings("unused")
	private boolean inRando, inLink;

	// buffer nous permettant de recuperer les donnees
	private StringBuffer buffer;

	public ParserListeRandosHandler() {
		super();
	}

	// detection d'ouverture de balise
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equals("item")) {
			inRando = true;
		}
		if (inRando && qName.equals("link")) {
			buffer = new StringBuffer();
			inLink = true;
		}
	}

	// detection fin de balise
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("item")) {
			inRando = false;
			buffer = null;
		}
		if (inRando && qName.equals("link")) {
			listeUrlRandos.add(buffer.toString());
			inLink = false;
		}
	}

	// /**
	// * @param title
	// * au format = <title>LIEU (departement) ------- nom</title>
	// * @return [lieu,departement,nom]
	// */
	// protected String[] formatTitle(String title) {
	// String[] infosTitle = new String[3];
	// String dep_nom_separator = "-------";
	//
	// String[] titles = StringUtils.splitByWholeSeparator(title,
	// dep_nom_separator);
	// String titleLeft = StringUtils.left(titles[0], titles[0].length() - 1);
	// String titleRight = StringUtils.right(titles[1], titles[1].length() - 1);
	//
	// String titleLeftReversed = StringUtils.reverse(titleLeft);
	// int debutDepartement2 = titleLeft.length() -
	// StringUtils.indexOf(titleLeftReversed, '(');
	// int finDepartement2 = titleLeft.length() -
	// StringUtils.indexOf(titleLeftReversed, ')');
	//
	// infosTitle[0] = StringUtils.left(titleLeft, debutDepartement2 - 2);
	// infosTitle[1] = titleLeft.substring(debutDepartement2, finDepartement2 -
	// 1);
	// infosTitle[2] = titleRight;
	//
	// return infosTitle;
	// }

	// detection de caracteres
	public void characters(char[] ch, int start, int length) throws SAXException {
		String lecture = new String(ch, start, length);
		if (buffer != null)
			buffer.append(lecture);
	}

	// debut du parsing
	public void startDocument() throws SAXException {
	}

	// fin du parsing
	public void endDocument() throws SAXException {
	}

	/**
	 * @param listeUrlRandos
	 *            the listeUrlRandos to set
	 */
	public void setListeUrlRandos(List<String> listeUrlRandos) {
		this.listeUrlRandos = listeUrlRandos;
	}
}
