package agh.ics.oop;

import javafx.application.Application;

import java.util.ArrayList;

public class SimulationEngine implements IEngine, Runnable {
    private Vector2d[] positions;
    private ArrayList<Animal> animals = new ArrayList<Animal>();
    private MoveDirection[] movements;
    private final IWorldMap map;

    private final int movedelay;

    public SimulationEngine(MoveDirection[] movements, IWorldMap map, Vector2d[] positions, int movedelay) {
        this.positions = positions;
        this.movements = movements;
        this.map = map;
        this.movedelay = movedelay;
        for (Vector2d position : positions) {
            Animal animal = new Animal(map, position);
            if (map.place(animal)) {
                animals.add(animal);
            }
        }
    }

    public void subscribeToAll(Application application) {
        for (Animal animal : animals) {
            animal.subscribe((IPositionChangeObserver) application);
        }
    }

    @Override
    public void run() {
        int length = animals.size();
        for (int i = 0; i < movements.length; i++) {
            try {
                Thread.sleep(movedelay);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
            animals.get(i % length).move(movements[i]);
        }
    }
}

