/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.intecbrussel.dakplusplus.App;

import be.intecbrussel.dakplusplus.model.Adress;
import be.intecbrussel.dakplusplus.model.ContactData;
import be.intecbrussel.dakplusplus.model.company.Company;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author JLVH
 */
public class CompanyController implements Initializable {

    @FXML
    private TextField companyName;
    @FXML
    private TextField street;
    @FXML
    private TextField number;
    @FXML
    private TextField zipcode;
    @FXML
    private TextField city;
    @FXML
    private TextField country;
    @FXML
    private TextField email;
    @FXML
    private TextField phone;
    @FXML
    private Button save;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
// Adress(String street, String number, String zipCode, String city, String country)
    @FXML
    private void save(ActionEvent event) {
        Adress adress = new Adress(street.getText(), number.getText(), zipcode.getText(), city.getText(), country.getText());
        ContactData contact = new ContactData(email.getText(), phone.getText());
        Company company = new Company(companyName.getText(), contact);
        company.addContactData(contact);
        
    }
    
}
