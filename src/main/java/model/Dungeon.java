package model;

import model.room.*;

public class Dungeon {
    private final Room[][] map;
    private final int sizeOfMatrix;
    private final Player player;
    private CreatorsRoom creatorRoom;

    public Dungeon(int size, Player player, CreatorsRoom creatorRoom){
        this.sizeOfMatrix = size;
        this.player = player;
        this.creatorRoom = creatorRoom;
        this.map = new Room[size][size];
        createMap();
        createRoad();
    }

    private void createRoad() {
        for (int raw=0; raw<sizeOfMatrix; raw++){
            for (int column=0; column<sizeOfMatrix; column++){
                if (column < sizeOfMatrix-1) {
                    createCorridorEast(map[raw][column],map[raw][column+1]);
                }
                if(raw < sizeOfMatrix-1) {
                    createCorridorSouth(map[raw][column],map[raw+1][column]);
                }
            }
        }
    }

    public void createMap() {
        for (int raw=0; raw<sizeOfMatrix; raw++){
            for (int column=0; column<sizeOfMatrix; column++){
                if (raw==0 && column==0) {
                    map[raw][column] = new StartRoom(player,raw,column);
                    player.setCurrentRoom(map[raw][column]);
                    continue;
                }
                if(raw == sizeOfMatrix-1 && column == sizeOfMatrix-1) map[raw][column] = new LastRoom(raw,column);
                else {
                    creatorRoom.setX(raw);
                    creatorRoom.setY(column);
                    map[raw][column] = creatorRoom.createRandomRoom();}
            }
        }
    }

    public void createCorridorEast(Room westRoom, Room eastRoom){
        westRoom.addDoorToEast();
        eastRoom.addDoorToWest();
    }

    public void createCorridorSouth(Room northRoom, Room southRoom){
        northRoom.addDoorToSouth();
        southRoom.addDoorToNorth();
    }

    public Room[][] getMap() { return map;}

    public Room getRoomInXAndInY(int x,int y) { return map[x][y];}

    public int getSizeOfMatrix() { return sizeOfMatrix;}
}
