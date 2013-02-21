package com.bastey.randofr.reader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import com.bastey.randofr.entity.EnumUrlRando;

/**
 * @author bastey
 */
public class ParserListeRandos {

    private static Logger logger = LoggerFactory.getLogger(ParserListeRandos.class);

    /** URL permettant de récupérer la liste des randos. */
    private EnumUrlRando URLtoParse;

    /**
     * Constructeur.
     * 
     * @param uRLtoParse
     */
    public ParserListeRandos(EnumUrlRando pUrltoParse) {
        super();
        URLtoParse = pUrltoParse;
    }

    /**
     * Recuperation de la liste des URL des randos..<BR>
     * Utilisation d'un ParserXML.
     */
    public List<String> recupererListRandos() {
        List<String> listeUrlRandos = new ArrayList<String>();

        try {
            SAXParserFactory saxFactory = SAXParserFactory.newInstance();
            SAXParser parser = saxFactory.newSAXParser();
            XMLReader reader = parser.getXMLReader();
            // Create handler to handle XML Tags ( extends DefaultHandler )
            ParserListeRandosHandler myXMLHandler = new ParserListeRandosHandler();
            myXMLHandler.setListeUrlRandos(listeUrlRandos);
            reader.setContentHandler(myXMLHandler);
            URL sourceUrl = new URL(URLtoParse.getUrl());
            InputStream stream = sourceUrl.openStream();
            reader.parse(new InputSource(stream));
            stream.close();

            // Affichage du nombre de randos
            // logger.info("Nb de randos : " + randos.getRandosVtt().size());

        } catch (ParserConfigurationException e) {
            logger.error("Erreur de configuration du parser XML", e);
            throw new ArretBatchException();
        } catch (SAXException e) {
            logger.error("Erreur de parsing lors de la récupération de la liste des randos", e);
            throw new ArretBatchException();
        } catch (IOException e) {
            logger.error("Erreur URL lors de la récupération de la liste des randos", e);
            throw new ArretBatchException();
        }
        return listeUrlRandos;
    }

    /**
     * @param uRLtoParse
     */
    public void setURLtoParse(EnumUrlRando uRLtoParse) {
        URLtoParse = uRLtoParse;
    }

}
