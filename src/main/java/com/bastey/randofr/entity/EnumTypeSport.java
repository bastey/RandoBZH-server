package com.bastey.randofr.entity;

/**
 * Enumération des type de sport.
 * 
 * @author bastey
 * 
 */
public enum EnumTypeSport {

    VTT("VTT"), CYCLO("CYCLO"), MARCHE("MARCHE");

    private final String label;

    private EnumTypeSport(String label) {
        this.label = label;
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    public static EnumTypeSport getTypeSport(String pLabel) {
        EnumTypeSport result = null;
        for (EnumTypeSport type : EnumTypeSport.values()) {
            if (type.getLabel().equals(pLabel)) {
                result = type;
                break;
            }
        }
        return result;
    }

}
