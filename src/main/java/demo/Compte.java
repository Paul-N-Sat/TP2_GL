package demo;

import java.util.Objects;
import java.util.Random;

import static java.lang.Math.abs;

public class Compte {

    int numeroCompte;
    Personne titulaire;

    float soldeCompte;

    float decouvert;
    float decouvertMax;

    float retrait;
    float debitMax;
    String devise;

    Random rand = new Random();
    public Compte(Personne titulaire){
        this.titulaire=titulaire;
        this.numeroCompte= rand.nextInt();
        this.soldeCompte=0;
        this.decouvert=0;
        this.decouvertMax=800;
        this.debitMax=1000;
        this.devise="Euros";
        this.retrait=0;
    }

    public Compte(Personne titulaire, float depotInitial){
        this.titulaire=titulaire;
        this.numeroCompte= rand.nextInt();
        this.soldeCompte=depotInitial;
        this.decouvert=0;
        this.decouvertMax=800;
        this.debitMax=1000;
        this.devise="Euros";
        this.retrait = 0;
    }
    public Compte(int numeroCompte, Personne titulaire, float depotInitial){
        this.titulaire=titulaire;
        this.numeroCompte= numeroCompte;
        this.soldeCompte=depotInitial;
        this.decouvert=0;
        this.decouvertMax=800;
        this.debitMax=1000;
        this.devise="Euros";
        this.retrait = 0;
    }

    public void setDebitMax(float debitMax) {
        this.debitMax = debitMax;
    }

    public void setDecouvertMax(float decouvertMax) {
        this.decouvertMax = decouvertMax;
    }

    public float getDebitMax() {
        return debitMax;
    }

    public int getNumeroCompte() {
        return numeroCompte;
    }

    public float getDecouvert() {
        return decouvert;
    }

    public float getDecouvertMax() {
        return decouvertMax;
    }

    public float getSoldeCompte() {
        return soldeCompte;
    }

    public Personne getTitulaire() {
        return titulaire;
    }

    public void setRetrait(float retrait) {
        this.retrait = retrait;
    }

    public float getRetrait() {
        return retrait;
    }

    public String getDevise() {
        return devise;
    }

    public void crediterCompte(float sommeACrediter){
        if(sommeACrediter < 0) throw new IllegalArgumentException();
        this.soldeCompte += sommeACrediter;
    }

    boolean estADecouvert(float somme){
        float testSolde = this.soldeCompte - somme;
        return abs(testSolde) > decouvertMax && testSolde < 0;
    }
    public void debiterCompte(float sommeADebiter){
        if(sommeADebiter < 0) throw new IllegalArgumentException();
        if (estADecouvert(sommeADebiter)){
            this.soldeCompte -= sommeADebiter;
        }else{
            System.out.println("T'es pauvre mon reuf!");
        }
    }

    public void retraitCompte(float retrait){
        float testDebit = this.retrait + retrait;
        if(testDebit<debitMax && estADecouvert(retrait)){
            this.retrait = testDebit;
            this.soldeCompte -= retrait;
        }else{
            System.out.println("Solde insuffisant!");
        }
    }

    public void virementCompte(Compte compte,float somme) throws IllegalArgumentException{
        if(somme < 0) throw new IllegalArgumentException();
        if(estADecouvert(somme))
        {
            debiterCompte(somme);
            crediterCompte(somme);
        } else {
            System.out.println("Solde insuffisant!");
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compte compte = (Compte) o;
        return numeroCompte == compte.numeroCompte && Float.compare(compte.soldeCompte, soldeCompte) == 0 && Float.compare(compte.decouvert, decouvert) == 0 && Float.compare(compte.decouvertMax, decouvertMax) == 0 && Float.compare(compte.retrait, retrait) == 0 && Float.compare(compte.debitMax, debitMax) == 0 && Objects.equals(titulaire, compte.titulaire) && Objects.equals(devise, compte.devise) && Objects.equals(rand, compte.rand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroCompte, titulaire, soldeCompte, decouvert, decouvertMax, retrait, debitMax, devise, rand);
    }
}
