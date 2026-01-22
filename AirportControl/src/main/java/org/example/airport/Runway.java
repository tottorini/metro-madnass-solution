package org.example.airport;

public class Runway {
    private int id;
    private static int count = 0;
    // 'volatile' ensures visibility across different CPU cores
    private volatile boolean isOccupied;

    public Runway() {
        synchronized(Runway.class) {
            count += 1;
            id = count;
            
        }
        isOccupied = false;
    }
    
    public void reserve() {
        throw new UnsupportedOperationException();
    }

    public int getId() {
        return id;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied() {
        isOccupied = true;
    }

    public void setUnoccupied() {
        isOccupied = false;
    }
}
