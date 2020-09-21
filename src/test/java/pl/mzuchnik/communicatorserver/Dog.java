package pl.mzuchnik.communicatorserver;

public class Dog extends Animal{

    public enum Size {SMALL, MEDIUM, LARGE};

    private final Size size;

    private Dog(Builder builder) {
        super(builder);
        size = builder.size;
    }

    public static class Builder extends Animal.Builder<Builder>{

        private final Size size;

        public Builder(String name, AnimalType type, Size size) {
            super(name, type);
            this.size = size;
        }

        @Override
        Animal build() {
            return new Dog(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
}
