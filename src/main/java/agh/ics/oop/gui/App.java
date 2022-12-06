package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.FileNotFoundException;


public class App extends Application implements IPositionChangeObserver{
    private MoveDirection[] directions;
    private AbstractWorldMap map;
    private Vector2d[] positions;
    private SimulationEngine engine;
    private Thread engineThread;
    private Scene scene;
    private GridPane gridPane;
    //returns path to image of object given
    private String decipherObjectType(Object object){
        if (object.toString().equals("*")){
            return "src/main/resources/grass.png";
        } else if (object.toString().equals("N")){
            return "src/main/resources/up.png";
        } else if (object.toString().equals("E")) {
            return "src/main/resources/right.png";
        } else if (object.toString().equals("S")){
            return "src/main/resources/down.png";
        } else if(object.toString().equals("W")) {
            return "src/main/resources/left.png";
        }
        throw new IllegalArgumentException("unknown object");
    }
    @Override
    public void init() throws Exception {
        try {
            this.map = new GrassField(10);
            this.positions = new Vector2d[]{new Vector2d(2, 2), new Vector2d(3, 4)};
            this.gridPane = new GridPane();
            this.scene = new Scene(gridPane, 700, 700);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        super.init();
    }
    private void draw(GridPane gridpane)  {
        try {
            gridpane.getChildren().clear();
            gridpane.setGridLinesVisible(true);
            gridpane.setPadding(new Insets(10, 10, 10, 10));
            gridpane.add(new Text("y/x"), 0, 0);
            for (int i = map.lowestLeft().x(), pos = 1; i <= map.uppestRight().x(); i++, pos++) {
                Text toAdd = new Text(Integer.toString(i));
                gridpane.add(toAdd, pos, 0);
                gridpane.setHalignment(toAdd, HPos.CENTER);
            }
            for (int i = map.lowestLeft().y(), pos = 1; i <= map.uppestRight().y(); i++, pos++) {
                Text toAdd = new Text(Integer.toString(i));
                gridpane.add(toAdd, 0, pos);
                gridpane.setHalignment(toAdd, HPos.CENTER);
            }
            for (int i = map.lowestLeft().x(), pos = 1; i <= map.uppestRight().x(); i++, pos++) {
                for (int j = map.lowestLeft().y(), pos2 = 1; j <= map.uppestRight().y(); j++, pos2++) {
                    Text toAdd = new Text("\n   ");
                    gridpane.add(toAdd, pos, pos2);
                    GridPane.setHalignment(toAdd, HPos.CENTER);
                    if (map.objectAt(new Vector2d(i, j)) != null) {
                        GuiElementBox guiElementBox = new GuiElementBox(decipherObjectType(map.objectAt(new Vector2d(i, j))), new Vector2d(i, j));
                        VBox vBox = guiElementBox.getvBox();
                        gridpane.add(vBox, pos, pos2);
                    }
                }
            }
        }catch (FileNotFoundException ex){
            System.out.println(ex);
        }

    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        TextField textField = new TextField ();
        VBox vBox = new VBox(new Label("Direction:"), textField);
        Button button =new Button("Start");
        gridPane.add(button,1,1);
        gridPane.add(vBox,2,1);
        primaryStage.setScene(scene);
        primaryStage.show();
        button.setOnAction(actionEvent->{
            this.directions = new OptionsParser().parse(textField.getText().split(" "));
            this.engine = new SimulationEngine(directions, map, positions, 300);
            this.engine.subscribeToAll(this);
            this.engineThread = new Thread((Runnable) engine);
            engineThread.start();
        });


    }
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition,Object object) {

        Platform.runLater( ()->draw(gridPane) );
    }
}
