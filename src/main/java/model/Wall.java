package model;

public class Wall implements Side{
    @Override
    public String description() {
        String message = "Un mur qui semble solide vous bloque la route";
        return message;
    }

    @Override
    public boolean canThisGo() {
        return false;
    }
}
