package demo;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class CompteTest {

    @Test
    void crediterCompte() {
        Compte c1 = new Compte(1010, new Personne("Bigard","JM"),1000);

        Compte expected = new Compte(1010,new Personne("Bigard","JM"),3000);

        c1.crediterCompte(2000);

        assertEquals(expected,c1);
    }

    @Test
    void debiterCompte() {
        Compte c1 = new Compte(1010, new Personne("Bigard","JM"),3000);

        Compte expected = new Compte(1010,new Personne("Bigard","JM"),1000);

        c1.debiterCompte(2000);

        assertEquals(expected,c1);
    }

    @Test
    void retraitCompte() {
    }

    @Test
    void virementCompte() {
        Compte c1 = new Compte(1010, new Personne("Bigard","JM"),2000);
        Compte c2 = new Compte(1011, new Personne("Melanchon","JL"),1000);

        Compte expected = new Compte(1010,new Personne("Bigard","JM"),1000);
        Compte expected2 = new Compte(1011,new Personne("Melanchon","JL"),2000);

        c1.virementCompte(c2,1000);

        assertEquals(expected,c1);
        assertEquals(expected2,c2);
    }
}