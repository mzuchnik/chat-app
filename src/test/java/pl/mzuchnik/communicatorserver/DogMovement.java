package pl.mzuchnik.communicatorserver;

public class DogMovement implements AnimalMovement{

    @Override
    public void moveHorizontal() {
        System.out.println("Poruszam się do przodu :)");
    }
}
