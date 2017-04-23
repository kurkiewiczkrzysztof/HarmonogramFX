/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harmonogramfx.Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author USER
 */
public class Sale {

    private final IntegerProperty idSale;
    private final IntegerProperty iloscStudentow;

    public Sale(int idSale, int iloscStudentow) {
        this.idSale = new SimpleIntegerProperty(idSale);
        this.iloscStudentow = new SimpleIntegerProperty(iloscStudentow);
    }

    public int getIdSale() {
        return idSale.get();
    }

    public void setIdSale(int value) {
        idSale.set(value);
    }

    public int getIloscStudentow() {
        return iloscStudentow.get();
    }

    public void setIloscStudentow(int value) {
        iloscStudentow.set(value);
    }

    public IntegerProperty idSaleProperty() {
        return idSale;
    }

    public IntegerProperty iloscStudentowProperty() {
        return iloscStudentow;
    }
}
