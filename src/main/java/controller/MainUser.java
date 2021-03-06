package controller;

import domain.AutoService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import service.Service;

import java.io.IOException;

public class MainUser {
    @FXML
    private TableView<AutoService> tablemainuser;

    @FXML
    private TableColumn<AutoService, String> servicenamemainuser;
    private String userusername;
    public void UserUsername(String username)
    {
       this.userusername=username;
    }
    private Service service;
    private ObservableList<AutoService> model= FXCollections.observableArrayList();
    public void setService(Service service) {

        this.service = service;
        inittable();
    }
    private void inittable(){
        this.servicenamemainuser.setCellValueFactory(new PropertyValueFactory<>("Name"));
        loadmodel();
        this.tablemainuser.setItems(model);
    }
    private void loadmodel(){
        this.model.setAll(this.service.getAllAutoService());
    }

    public void mouseclickedtable(MouseEvent mouseEvent) throws IOException {
        AutoService autoService=this.tablemainuser.getSelectionModel().getSelectedItem();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/viewservicedescription.fxml"));
        Parent root = loader.load();
        Servicedescriptionforuser controllerLogIn = loader.getController();
        controllerLogIn.getAutoS(autoService);
        controllerLogIn.UserUsername1(userusername,autoService.getUsername());
        controllerLogIn.setService(this.service);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Service");
        stage.show();
    }

    public void hisorycliked(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/viewuserhistory.fxml"));
        Parent root = loader.load();
        UserHistory controllerLogIn = loader.getController();
        controllerLogIn.Useruser(userusername);
        controllerLogIn.setService(this.service);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("History");
        stage.show();
    }

    public void pendingmousecliked(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/viewpendinguser.fxml"));
        Parent root = loader.load();
        UserPending controllerLogIn = loader.getController();
        controllerLogIn.Useruser(userusername);
        controllerLogIn.setService(this.service);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Pending history");
        stage.show();

    }

    public void approvedclicked(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/viewuseraccepted.fxml"));
        Parent root = loader.load();
        UserAccepted controllerLogIn = loader.getController();
        controllerLogIn.Useruser(userusername);
        controllerLogIn.setService(this.service);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Approved history");
        stage.show();
    }
}
