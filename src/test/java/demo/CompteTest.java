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
    void debiterCompte() {
        Personne JM = new Personne("Bigard","JM");
        Compte c1 = new Compte(1010, JM,3000F);

        Compte expected = new Compte(1010,JM,1000F);

        c1.debiterCompte(2000F);

        assertEquals(expected,c1);
    }

    @Test
    void retraitCompte() {
    }

    @Test
    void virementCompte() {
        Personne JM = new Personne("Bigard","JM");
        Personne JL = new Personne("Melanchon","JL");
        Compte c1 = new Compte(1010, JM,2000F);
        Compte c2 = new Compte(1011, JL,1000F);

        Compte expected = new Compte(1010,JM,1000F);
        Compte expected2 = new Compte(1011,JL,2000F);

        c1.virementCompte(c2,1000F);

        assertEquals(expected,c1);
        assertEquals(expected2,c2);
    }
}