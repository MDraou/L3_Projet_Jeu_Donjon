package model;

public abstract class Room {
    private Side northSide;
    private Side eastSide;
    private Side southSide;
    private Side westSide;
    private Boolean isFirstRoom;
    private Boolean isLastRoom;

    public Room() {
        this.northSide = new Wall();
        this.eastSide = new Wall();
        this.southSide = new Wall();
        this.westSide = new Wall();
        this.isFirstRoom = false;
        this.isLastRoom = false;
    }

    public boolean canGoToNorth(){
        return northSide.canThisGo();
    }

    public boolean canGoToEast(){
        return eastSide.canThisGo();
    }

    public boolean canGoToSouth(){
        return southSide.canThisGo();
    }

    public boolean canGoToWest(){
        return westSide.canThisGo();
    }

    public void addDoorToNorth(){
        this.northSide = new Door();
    }

    public void addDoorToEast(){
        this.eastSide = new Door();
    }

    public void addDoorToSouth(){
        this.southSide = new Door();
    }

    public void addDoorToWest(){
        this.westSide = new Door();
    }

    public void setLastRoom(){
        isLastRoom = true;
    }

    public void setFirstRoom() {isFirstRoom = true;}

    public boolean isLastRoom() { return isLastRoom;}

    public boolean isFirstRoom() { return isFirstRoom;}
}
