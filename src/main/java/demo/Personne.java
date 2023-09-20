package demo;

import java.util.Objects;

public class Personne {
    String nom;
    String prenom;
    String adresse;

    public Personne(String nom, String prenom){
        this.nom=nom;
        this.prenom=prenom;
    }

    @Override
    public String toString() {
        return prenom + nom ;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getAdresse() {
        return adresse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personne personne = (Personne) o;
        return Objects.equals(nom, personne.nom) && Objects.equals(prenom, personne.prenom) && Objects.equals(adresse, personne.adresse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom, adresse);
    }
}
