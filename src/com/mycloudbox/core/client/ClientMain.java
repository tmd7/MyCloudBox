package com.mycloudbox.core.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ClientMain extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("My Cloud Box - Client");

        initRootLayout();
        showAuthorizationLayout();
        showClientLayout();

//
//        primaryStage.setTitle("My Cloud Box");
//        primaryStage.setScene(new Scene(root, 1000, 800));
//        primaryStage.show();
    }

    //Init root layout
    public void initRootLayout() {
        try {
            //Download root layout
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ClientMain.class.getResource("RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            //Puts in primaryStage scene and puts in scene rootLayout
            //Stage --> Scene --> rootLayout
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showClientLayout() {
        //Download ClientLayout
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ClientMain.class.getResource("ClientLayout.fxml"));
            AnchorPane clientLayout = (AnchorPane) loader.load();

            //Puts ClientLayout in center of RootLayout
            rootLayout.setCenter(clientLayout);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAuthorizationLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ClientMain.class.getResource("AuthorizationLayout.fxml"));
            AnchorPane authorizationLayout = (AnchorPane) loader.load();
            rootLayout.setCenter(authorizationLayout);
            authorizationLayout.setVisible(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
