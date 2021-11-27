package model;

public class Door implements Side{
    @Override
    public String description() {
        String message = "Un porte se trouve devant vous. Vous traversez cette porte.";
        return message;
    }

    @Override
    public boolean canThisGo() {
        return true;
    }
}
