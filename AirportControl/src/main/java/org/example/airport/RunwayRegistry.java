package org.example.airport;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class RunwayRegistry {
    // CopyOnWriteArrayList is safe for reading while other threads might be adding/removing
    private final List<Runway> runways = new CopyOnWriteArrayList<>();

    private boolean hasRunway(Runway runway) {
        return runways.stream().anyMatch(r -> r.getId() == runway.getId());
    }

    public void addRunway(Runway newRunway) {
        if(!hasRunway(newRunway)) {
            runways.add(newRunway);
        }
    }

    public void removeRunway(int id) {
        runways.removeIf(g -> g.getId() == id);
    }

    public synchronized Runway getAvailableRunway() {
        for(Runway currentRunway : runways) {
            if(!currentRunway.isOccupied()) {
                currentRunway.setOccupied();
                return currentRunway;
            }
        }
        return null;
    }
}
