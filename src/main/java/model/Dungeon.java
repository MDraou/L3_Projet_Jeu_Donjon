package model;

import model.room.RoomCreator;
import model.room.Room;
import model.room.RoomFinish;
import model.room.RoomStart;

import java.util.Random;

public class Dungeon {
    private Room[][] map;
    private int sizeOfMatrix;

    public Dungeon(int n){
        this.sizeOfMatrix = n;
        map = new Room[n][n];
        //Random rand = new Random();
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
                    map[raw][column] = new RoomStart();
                    continue;
                }
                if(raw == sizeOfMatrix-1 && column == sizeOfMatrix-1) map[raw][column] = new RoomFinish();
                else { map[raw][column] = new RoomCreator().createRandomRoom();}
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

    public int getSizeOfMatrix() { return sizeOfMatrix;}
}
