package pl.mzuchnik.communicatorserver;

public class NoAnimalMovement implements AnimalMovement{

    @Override
    public void moveHorizontal() {
        System.out.println("Nie potrafie się poruszać");
    }
}
