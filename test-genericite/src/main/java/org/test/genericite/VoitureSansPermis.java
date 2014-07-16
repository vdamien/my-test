package org.test.genericite;

/**
 * Created by a203696 on 08/07/2014.
 */
public class VoitureSansPermis extends Voiture {
    private Boolean withPermis;

    public VoitureSansPermis(String typeVoiture) {
        super(typeVoiture);
        withPermis = true;
    }

    public Boolean getWithPermis() {
        return withPermis;
    }

    @Override
    public String toString() {
        return "org.test.genericite.VoitureSansPermis{" +
                "withPermis=" + withPermis +
                '}';
    }
}
