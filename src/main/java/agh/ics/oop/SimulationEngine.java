package agh.ics.oop;

import java.util.ArrayList;

public class SimulationEngine implements IEngine {
    private Vector2d[] positions;
    private ArrayList<Animal> animals = new ArrayList<Animal>();
    private MoveDirection[] movements;
    private IWorldMap map;

    public SimulationEngine(MoveDirection[] movements, IWorldMap map, Vector2d[] positions) {
        this.positions = positions;
        this.movements = movements;
        this.map = map;
    }

    @Override
    public void run() {
        for (Vector2d position : positions) {
            Animal animal = new Animal(map, position);
            if (map.place(animal)) {
                animals.add(animal);
            }
        }
        int length = animals.size();
        for (int i = 0; i < movements.length; i++) {
            animals.get(i % length).move(movements[i]);
        }
    }
}

