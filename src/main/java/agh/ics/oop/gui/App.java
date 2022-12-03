package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class App extends Application {
    private MoveDirection[] directions;
    private AbstractWorldMap map;
    private Vector2d[] positions;
    private IEngine engine;

    @Override
    public void init() throws Exception {
        try {
            this.directions = new OptionsParser().parse(getParameters().getRaw().toArray(new String[0]));
            this.map = new GrassField(10);
            this.positions = new Vector2d[]{new Vector2d(2, 2), new Vector2d(3, 4)};
            this.engine = new SimulationEngine(directions, map, positions);
            engine.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gridpane = new GridPane();
        gridpane.setGridLinesVisible(true);
        gridpane.setPadding(new Insets(10, 10, 10, 10));
        gridpane.add(new Text("y/x"),0,0);
        for (int i = map.lowestLeft().x(), pos=1; i<=map.uppestRight().x();i++,pos++)
        {
            Text toAdd=new Text(Integer.toString(i));
            gridpane.add(toAdd,pos,0);
            gridpane.setHalignment(toAdd,HPos.CENTER);
        }
        for (int i = map.lowestLeft().y(), pos=1; i<=map.uppestRight().y();i++,pos++)
        {
            Text toAdd=new Text(Integer.toString(i));
            gridpane.add(toAdd,0,pos);
            gridpane.setHalignment(toAdd,HPos.CENTER);
        }
        for (int i = map.lowestLeft().x(), pos=1;i<=map.uppestRight().x();i++,pos++){
            for (int j=map.lowestLeft().y(),pos2=1;j<=map.uppestRight().y();j++,pos2++){
                Text toAdd= new Text("\n   ");
                if(map.objectAt(new Vector2d(i,j))!=null){
                    toAdd.setText(map.objectAt(new Vector2d(i,j)).toString());
                }
                gridpane.add(toAdd,pos,pos2);
                GridPane.setHalignment(toAdd,HPos.CENTER);
            }
        }

        Scene scene = new Scene(gridpane, 700, 700);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
