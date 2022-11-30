package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;


public class App extends Application {
    MoveDirection[] directions;
    AbstractWorldMap map;
    Vector2d[] positions;
    IEngine engine;
    @Override
    public void init() throws Exception {
        try{
            this.directions = new OptionsParser().parse(getParameters().getRaw().toArray(new String[0]));
            this.map= new GrassField(10);
            this.positions= new Vector2d[]{new Vector2d(2, 2), new Vector2d(3, 4)};
            this.engine = new SimulationEngine(directions, map, positions);
            engine.run();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gridpane = new GridPane();
        gridpane.setGridLinesVisible(true);
        gridpane.getRowConstraints().add(new RowConstraints(40));
        gridpane.getColumnConstraints().add(new ColumnConstraints(40));
        Label label = new Label("Zwierzak");
        GridPane.setHalignment(label, HPos.CENTER);
        gridpane.add(label,3,3,1,1);
        Scene scene = new Scene(gridpane, 700, 700);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
