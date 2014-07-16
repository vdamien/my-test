package org.test.genericite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a203696 on 08/07/2014.
 */
public class MainGenericite {
    public static void main (String ... argv) {
        List<Voiture> listVoiture = new ArrayList<>();
        listVoiture.add(new Voiture("toto"));

        List<VoitureSansPermis> listVoiture2 = new ArrayList<>();
        listVoiture.add(new VoitureSansPermis("titi"));

        afficherVoiture(listVoiture);
        afficherVoiture(listVoiture2);
    }

    public static void afficherVoiture(List<? extends Vehicule> voitures) {
        for (Vehicule v : voitures) {
            System.out.println(v);
        }
    }
}
