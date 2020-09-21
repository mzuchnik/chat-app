package pl.mzuchnik.communicatorserver;

public interface Factory {

    Animal create(AnimalType type);
}
