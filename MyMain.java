package intern_java.intern_java;
//package intern_java;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {

    public static void main(String[] args) {
        System.out.println("main");
        launch(args);

    }

    @Override
    public void init() throws Exception {
        super.init();
        System.out.println("init");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("Start");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("applayout.fxml"));
        VBox rootNode = loader.load();

        MenuBar menuBar= createMenu();
        rootNode.getChildren().add(0,menuBar);
        Scene scene = new Scene(rootNode);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Temperature Convertor Packet");
        primaryStage.show();
    }
    //Creating menu
    public MenuBar createMenu(){
        //file menu
        Menu fileMenu= new Menu("File");
        MenuItem newMenuItem= new MenuItem("New");
        newMenuItem.setOnAction(event -> System.out.println("New Menu Item Clicked"));

        SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();
        MenuItem quitMenuItem= new MenuItem("Quit");
        quitMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
                System.exit(0);
            }
        });
        fileMenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);

        //help menu
        Menu helpMenu= new Menu("Help");
        MenuItem aboutApp=new MenuItem("About App");
        aboutApp.setOnAction(event ->  {aboutApp(); });
        MenuItem aboutMe = new MenuItem("About Me");
        aboutMe.setOnAction(event -> aboutMe());

        helpMenu.getItems().addAll(aboutApp,aboutMe);



        //Menu Bar
        MenuBar menuBar=new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);

        return menuBar;

    }
    private void aboutMe() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About The Developer");
        alert.setHeaderText("Ayush Patel");
        alert.setContentText("I am a beginner, it's my first project. I try to improve itself. " +
                "Iam a deep learner in java and try to create more project. " +
                "And i am also learn about android studio using XML & KOTLIN.");
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.show();
    }

    private void aboutApp() {
        Alert alert1=new Alert(Alert.AlertType.INFORMATION);
        alert1.setTitle("About App");
        alert1.setHeaderText("Temperature convert GUI application.");
        alert1.setContentText("This is a temperature convert GUI application. "+
                "It's convert fohrenheit to degree celsius and celsius to fohrenheit. "+
                "Here is a Temperature Converter I created as a Beginner.");

        ButtonType yesBtn=new ButtonType("YES");
        ButtonType noBtn=new ButtonType("NO");

        alert1.getButtonTypes().setAll(yesBtn,noBtn);

        Optional<ButtonType> clickBtn=alert1.showAndWait();

        if(clickBtn.isPresent() && clickBtn.get()==yesBtn){
            System.out.println("Yes Button Clicked");
        }
        if(clickBtn.isPresent() && clickBtn.get()==noBtn){
            System.out.println("No Button Clicked");
        }
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        System.out.println("Stop");
    }
}

