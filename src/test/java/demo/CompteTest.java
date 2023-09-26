package demo;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class CompteTest {

    @Test
    void crediterCompte() {
        Personne JM = new Personne("Bigard","JM");
        Compte c1 = new Compte(1010, JM,1000F);

        Compte expected = new Compte(1010,JM,3000F);

        c1.crediterCompte(2000F);


        assertEquals(expected,c1);
    }

    @Test
    void debiterCompteFail() {
        Personne JM = new Personne("Bigard","JM");
        Compte c1 = new Compte(1010, JM,1000F);

        assertThrows(IllegalArgumentException.class, ()-> c1.debiterCompte(1100F));
    }

    @Test
    void debiterCompteFail2() {
        Personne JM = new Personne("Bigard","JM");
        Compte c1 = new Compte(1010, JM,0F);

        assertThrows(IllegalArgumentException.class, ()-> c1.debiterCompte(900F));
    }
    @Test
    void debiterCompte() {
        Personne JM = new Personne("Bigard","JM");
        Compte c1 = new Compte(1010, JM,3000F);

        Compte expected = new Compte(1010,JM,2500F);

        c1.debiterCompte(500F);


        assertEquals(expected,c1);
    }

    @Test
    void virementCompte() {
        Personne JM = new Personne("Bigard","JM");
        Personne JL = new Personne("Melanchon","JL");
        Compte c1 = new Compte( JM,2000F);
        Compte c2 = new Compte(JL,1000F);

        Compte expected = new Compte(JM,1500F);
        Compte expected2 = new Compte(JL,1500F);

        c1.virementCompte(c2,500F);


        assertEquals(expected,c1);
        assertEquals(expected2,c2);
    }

    @Test
    void virementCompteFail() {
        Personne JM = new Personne("Bigard","JM");
        Personne JL = new Personne("Melanchon","JL");
        Compte c1 = new Compte( JM,1000F);
        Compte c2 = new Compte(JL,2000F);

        assertThrows(IllegalArgumentException.class, ()-> c1.virementCompte(c2,2000F));
    }

    @Test
    void virementCompteFail2() {
        Personne JM = new Personne("Bigard","JM");
        Personne JL = new Personne("Melanchon","JL");
        Compte c1 = new Compte( JM,0F);
        Compte c2 = new Compte(JL,2000F);

        assertThrows(IllegalArgumentException.class, ()-> c1.virementCompte(c2,900F));
    }

    @Test
    void creationCompte() {
        assertThrows(IllegalArgumentException.class, ()-> new Compte(new Personne("Bigard","JM"),-10F));
    }
}