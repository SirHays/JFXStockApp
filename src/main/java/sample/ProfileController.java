package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class ProfileController {
    @FXML
    public Label companyName;
    @FXML
    public Label marketOpen;
    @FXML
    public Label previousClose;
    @FXML
    public Label volume;
    @FXML
    public Label sharePrice;
    @FXML
    public Label marketCap;
    @FXML
    public Label marketChange;
    @FXML
    public Label errorLabel;
    String name;
    Label loading;

    Stage secondStage = new Stage();


    private StatSupplier statSupplier;

    private StockService service = new StockService();

    public ProfileController(StatSupplier supplier) { statSupplier = supplier;}

    public void transferMessage(String text, Stage secondStage, Label loading) {
        this.secondStage = secondStage;
        this.loading = loading;
        name =text;
        onSearch();
    }


    public void onSearch(){

        service.company = name;
        service.restart();
    }



    private class StockService extends Service<Profile> {
        private String company;

        @Override
        protected Task<Profile> createTask() {
            return new Task<>() {
                @Override
                protected Profile call() throws Exception {
                    return statSupplier.get(company);
                }

                @Override
                protected void succeeded(){
                    Profile profile = getValue();

                    companyName.setText(profile.getCompanyName());
                    marketOpen.setText(profile.getMarketOpen());
                    previousClose.setText(profile.getPreviousClose());
                    volume.setText(profile.getVolume());
                    sharePrice.setText(profile.getSharePrice());
                    marketCap.setText(profile.getMarketCap());

                    double pc = Double.parseDouble(profile.getPreviousClose().replace(",",""));
                    double sp = Double.parseDouble(profile.getSharePrice().replace(",",""));
                    double percent = ((sp/pc)-1)*100.0;
                    marketChange.setText(profile.getMarketChange()+" • "+(Math.round(percent*100.0)/100.0)+"%");
                    secondStage.show();
                    loading.setText("");

                }
                protected void failed(){
                    Throwable error = getException();
                    errorLabel.setText("Error: "+error);
                }
            };
        }
    }
}

