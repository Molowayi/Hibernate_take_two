/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.intecbrussel.dakplusplus.controllers;

import be.intecbrussel.dakplusplus.datalayer.EntityManagerCreator;
import be.intecbrussel.dakplusplus.datalayer.GenericEntityRepository;
import be.intecbrussel.dakplusplus.model.Adress;
import be.intecbrussel.dakplusplus.model.ContactData;
import be.intecbrussel.dakplusplus.model.company.Company;
import be.intecbrussel.dakplusplus.model.company.Employee;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 * FXML Controller class
 *
 * @author JLVH
 */
public class CompanyController implements Initializable {

    @FXML
    private Label companyid;
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


    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void save(ActionEvent event) {
        Company company = makeCompany();
        List<Company> companies = getListCompanies();
        if (companies.size() == 0) {
            company = persistCompany(company);
        }
        companyid.setText("Company ID : " + company.getId());
    }

    private List<Company> getListCompanies() {
        EntityManager em = EntityManagerCreator.getEntityManager();
        TypedQuery<Company> query = em.createQuery("select c from Company  as c", Company.class);
        List<Company> companies = query.getResultList();
        return companies;
    }

    private Company makeCompany() {
        getData();
        Adress address = new Adress(street.getText(), number.getText(), zipcode.getText(), city.getText(), country.getText());
        ContactData contact = new ContactData(email.getText(), phone.getText());
        contact.addAdress(address);
        Company company = new Company(companyName.getText(), contact);
        company.addContactData(contact);
        return company;
    }

    private Company persistCompany(Company company) {
        EntityManager em = EntityManagerCreator.getEntityManager();
        em.getTransaction().begin();
        em.persist(company);
        em.getTransaction().commit();
        return company;
    }

    private void getData() {
        if (companyName.getText() == "" || companyName.getText() == null) {
            companyName.setText("Dakplusplus");
        }
        if (phone.getText() == "" || phone.getText() == null) {
            phone.setText("+32444444444");
        }
        if (email.getText() == "" || email.getText() == null) {
            email.setText("Dakplusplus@dpp.be");
        }
        if (street.getText() == "" || street.getText() == null) {
            street.setText("Alsace Lorraine");
        }
        if (number.getText() == "" || number.getText() == null) {
            number.setText("33");
        }
        if (zipcode.getText() == "" || zipcode.getText() == null) {
            zipcode.setText("1050");
        }
        if (city.getText() == "" || city.getText() == null) {
            city.setText("Brussels");
        }
        if (country.getText() == "" || country.getText() == null) {
            country.setText("Belgium");
        }

    }

}
