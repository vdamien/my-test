package org.test.genericite;

/**
 * Created by a203696 on 08/07/2014.
 */
public class Voiture implements Vehicule {
    private String typeVoiture;

    public Voiture (String typeVoiture) {
        this.typeVoiture = typeVoiture;
    }

    public String getTypeVoiture () {
        return this.typeVoiture;
    }

    @Override
    public String toString() {
        return "Voiture{" +
                "typeVoiture='" + typeVoiture + '\'' +
                '}';
    }
}
