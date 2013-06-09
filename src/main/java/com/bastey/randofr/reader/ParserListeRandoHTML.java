package com.bastey.randofr.reader;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

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

public class ParserListeRandoHTML {

	private static Logger logger = LoggerFactory
			.getLogger(ParserListeRandoHTML.class);

	private Parser htmlParser = new Parser();

	private String url;

	/**
	 * Constructeur.
	 * 
	 * @param uRLtoParse
	 */
	public ParserListeRandoHTML(String pUrltoParse) {
		super();
		url = pUrltoParse;
	}

	/**
	 * Permet de parser une page HTML de liste de randos.s
	 * 
	 * @param randos
	 *            Liste des randos
	 * @param url
	 *            URL à parser
	 * @return rando
	 */
	public List<String> parserListeRando() throws SecurityException,
			InvocationTargetException, NoSuchMethodException,
			UnsupportedEncodingException {

		List<String> results = new ArrayList<String>();
		try {


			htmlParser.setURL(url);

			// On filtre pour récupérer uniquement le <BODY></BODY>
			TagNameFilter filterBody = new TagNameFilter("body");
			NodeList list = htmlParser.parse(filterBody);
			// sans filtre sur le body
			//NodeList list = htmlParser.parse(null);

			// On extrait toutes les données textes du <BODY>
			TextExtractingVisitor visitor = new TextExtractingVisitor();
			list.visitAllNodesWith(visitor);
			String text = visitor.getExtractedText();

			logger.debug("==========");
			logger.debug(text);
			logger.debug("==========");

		} catch (ParserException e) {
			logger.error("Erreur lors de la récupération du détail de la rando : "
					+ url);
		}

		return results;
	}

}
