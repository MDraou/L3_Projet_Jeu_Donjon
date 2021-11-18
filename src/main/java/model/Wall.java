package model;

public class Wall implements Side{
    @Override
    public String description() {
        String text = "Un mur qui semble solide vous bloque la route";
        return text;
    }

    @Override
    public boolean canThisGo() {
        return false;
    }
}
