package com.bastey.randofr.entity;

import java.lang.reflect.Method;

import org.unitils.util.ReflectionUtils;

/**
 * @author BASTEY
 */
public enum EnumRandoDetailValeur
{
    /**
     * Champ contact
     */
    CONTACT
    {
        @Override
        public String getBalise()
        {
            return "Contact..";
        }

        @Override
        public Method getMethode()
            throws SecurityException, NoSuchMethodException
        {
			return ReflectionUtils.getSetter(Rando.class, "contact", false);
        }
    },
    /**
     * Champ Lieu de R-d-V
     */
    LIEU_RDV
    {
        @Override
        public String getBalise()
        {
            return "Lieu de R-d-V..";
        }

        @Override
        public Method getMethode()
            throws SecurityException, NoSuchMethodException
        {
			return ReflectionUtils.getSetter(Rando.class, "lieuRDV", false);
        }
    },
    /**
     * Champ Prix club
     */
    PRIX_CLUB
    {
        @Override
        public String getBalise()
        {
            return "Prix club..";
        }

        @Override
        public Method getMethode()
            throws SecurityException, NoSuchMethodException
        {
			return ReflectionUtils.getSetter(Rando.class, "prixClub", false);
        }
    },
    /**
     * Champ Prix public
     */
    PRIX_PUBLIC
    {
        @Override
        public String getBalise()
        {
            return "Prix public..";
        }

        @Override
        public Method getMethode()
            throws SecurityException, NoSuchMethodException
        {
			return ReflectionUtils.getSetter(Rando.class, "prixPublic", false);
        }
    },
    /**
     * Champ Horaires
     */
    HORAIRES
    {
        @Override
        public String getBalise()
        {
            return "Horaires..";
        }

        @Override
        public Method getMethode()
            throws SecurityException, NoSuchMethodException
        {
			return ReflectionUtils.getSetter(Rando.class, "horaires", false);
        }
    },
    /**
     * Champ Organisateur
     */
    ORGANISATEUR
    {
        @Override
        public String getBalise()
        {
            return "Organisateur..";
        }

        @Override
        public Method getMethode()
            throws SecurityException, NoSuchMethodException
        {
			return ReflectionUtils.getSetter(Rando.class, "organisateur", false);
        }
    },
    /**
     * Champ Date
     */
    DATE
    {
        @Override
        public String getBalise()
        {
            return "Date..";
        }

        @Override
        public Method getMethode()
            throws SecurityException, NoSuchMethodException
        {
			return ReflectionUtils.getSetter(Rando.class, "date", false);
        }
    };

    /**
     * Constructeur prive
     */
    private EnumRandoDetailValeur()
    {
    }

    public abstract String getBalise();

    public abstract Method getMethode()
        throws SecurityException, NoSuchMethodException;

}
