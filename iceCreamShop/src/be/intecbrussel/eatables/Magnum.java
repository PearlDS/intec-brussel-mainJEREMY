package be.intecbrussel.eatables;

public class Magnum implements Eatable {

    private MagnumType type;

    public Magnum(){}

    public Magnum(MagnumType type){
        this.type = type;
    }

    @Override
    public void eat() {
        System.out.println("Eating " + type + " magnum");
    }

    public MagnumType getType() {
        return type;
    }
}
