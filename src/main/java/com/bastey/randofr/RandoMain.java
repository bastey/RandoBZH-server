package com.bastey.randofr;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bastey.randofr.entity.EnumUrlRando;
import com.bastey.randofr.entity.Rando;
import com.bastey.randofr.entity.Randos;
import com.bastey.randofr.reader.ArretBatchException;
import com.bastey.randofr.reader.ParserDetailRando;
import com.bastey.randofr.reader.ParserListeRandos;

/**
 * @author bastey
 */
public class RandoMain {
    private static Logger logger = LoggerFactory.getLogger(RandoMain.class);

	public static void main(String[] args) throws SecurityException,
			InvocationTargetException, NoSuchMethodException,
			JsonParseException, IOException {
        try {

            EnumUrlRando url = EnumUrlRando.VTT_A_VENIR;
            Randos randos = new Randos();

            // 1- Recuperation de la liste des randos VTT (ParserXML)
            ParserListeRandos parserLR = new ParserListeRandos(url);
            List<String> listeUrlRandos = parserLR.recupererListRandos();

			logger.debug("Nb de randos : {}", listeUrlRandos.size());

            // 2- Recuperation du detail des randos (ParserHTML)
			ParserDetailRando parserDR = new ParserDetailRando(url);
			for (String urlRando : listeUrlRandos) {
				parserDR.parserDetailRando(randos, urlRando);
			}

            // 3- Ecriture du fichier de sortie
            // ecrireFichierSortie(randos);

			File fileRandos = new File("src/main/resources/rando.json");
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(fileRandos, randos.getListeRandos());

			logger.debug("Traitement terminé");

        } catch (ArretBatchException e) {
            logger.error("Arret du batch, une erreur a ete detectee !");
        }
    }

    /**
     * Ecriture du fichier de sortie
     * 
     * @param randos
     */
	private static void ecrireFichierSortie(Randos randos) {
        try {
            File out = new File("randoVTT.txt");
            out.createNewFile();
            FileOutputStream fos = new FileOutputStream(out);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");

			for (Rando r : randos.getListeRandos()) {
				osw.write(r.toString());
                osw.write("\n===============================================\n");
            }
            osw.close();
            fos.close();
        } catch (IOException e) {
            logger.error("Impossible de creer le fichier de sortie");
        }
    }
}
