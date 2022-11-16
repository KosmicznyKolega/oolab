package agh.ics.oop;

import java.util.ArrayList;
import java.util.Collections;


public class GrassField extends AbstractWorldMap{
    private int grassCount;
    private Vector2d lowerLeft= new Vector2d(0,0);
    private Vector2d upperRight;
    private ArrayList<Grass> grasses = new ArrayList<>();

    public GrassField(int grassCount) {
        this.grassCount = grassCount;
        this.upperRight = new Vector2d((int) Math.sqrt(grassCount*10), (int) Math.sqrt(grassCount*10));
        ArrayList<Vector2d> allPossiblePlaces = new ArrayList<>();
        for (int iterator1=0;iterator1<(int)Math.sqrt(grassCount*10);iterator1++){
            for (int iterator2=0;iterator2<(int)Math.sqrt(grassCount*10);iterator2++){
                allPossiblePlaces.add(new Vector2d(iterator1,iterator2));
            }
        }
        Collections.shuffle(allPossiblePlaces);
        for (int iterator3=0;iterator3<grassCount;iterator3++){
            grasses.add(new Grass(allPossiblePlaces.get(iterator3)));
        }
    }
    private Vector2d animalCanMoveToLowerLeft(){
        Vector2d lowestLeft= lowerLeft;
        for (Animal animal:animals){
            lowestLeft=animal.getPosition().lowerLeft(lowestLeft);
        }
        return lowestLeft;
    }
    private Vector2d animalCanMoveToUpperRight(){
        Vector2d uppestRight= upperRight;
        for (Animal animal:animals){
            uppestRight=animal.getPosition().upperRight(uppestRight);
        }
        return uppestRight;
    }

    public String whatToReturn(MapVisualiser map){
        return map.draw(animalCanMoveToLowerLeft(),animalCanMoveToUpperRight());
    }

    public boolean checkForAnyOtherObjects(Vector2d position){
        for (Grass grass:grasses){
            if (grass.getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        for (Animal animal:animals){
            if(animal.isAt(position)){
                return false;
            }
        }
        return true;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal:animals){
            if (animal.isAt(position)){
                return animal;
            }
        }
        for (Grass grass:grasses){
            if (grass.getPosition().equals(position)){
                return grass;
            }
        }
        return null;

    }
}
