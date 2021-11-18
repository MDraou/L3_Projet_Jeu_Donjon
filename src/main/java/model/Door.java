package model;

public class Door implements Side{
    @Override
    public String description() {
        String text = "Un porte se trouve devant vous, voulez vous l'ouvrir ?";
        return text;
    }

    @Override
    public boolean canThisGo() {
        return true;
    }
}
