package pl.mzuchnik.communicatorserver;

public abstract class Animal {

    private String name;
    private int age;
    private double positionX;
    private AnimalType type;
    private AnimalMovement movement;

    public Animal(Builder<?> builder){
        name = builder.name;
        age = builder.age;
        positionX = builder.positionX;
        type = builder.type;
        movement = builder.movement;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getPositionX() {
        return positionX;
    }

    public AnimalType getType() {
        return type;
    }

    public AnimalMovement getMovement() {
        return movement;
    }

    public void setMovement(AnimalMovement movement) {
        this.movement = movement;
    }

    public void move(){
        movement.moveHorizontal();
    }

    abstract static class Builder<T extends Builder<T>>{
        private String name;
        private int age;
        private double positionX;
        private AnimalType type;
        private AnimalMovement movement;

        Builder(String name, AnimalType type){
            this.name = name;
            this.type = type;
        }

        public Builder addName(String name){
            this.name = name;
            return self();
        }

        public Builder addAge(int age){
            this.age = age;
            return self();
        }

        public Builder addPositionX(double positionX){
            this.positionX = positionX;
            return self();
        }

        public Builder addAnimalType(AnimalType type){
            this.type = type;
            return self();
        }

        public Builder addAnimalMovement(AnimalMovement movement){
            this.movement = movement;
            return self();
        }

        abstract Animal build();

        protected abstract T self();
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", positionX=" + positionX +
                ", type=" + type +
                ", movement=" + movement +
                '}';
    }
}
