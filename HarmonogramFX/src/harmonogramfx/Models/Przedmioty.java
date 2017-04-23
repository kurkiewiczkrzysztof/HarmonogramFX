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
public class Przedmioty {

    private final IntegerProperty idPrzedmioty;
    private final StringProperty Nazwa;

    public Przedmioty(int idPrzedmioty,String Nazwa) {
        this.idPrzedmioty = new SimpleIntegerProperty(idPrzedmioty);
        this.Nazwa = new SimpleStringProperty(Nazwa);
    }

    public int getidPrzedmioty() {
        return idPrzedmioty.get();
    }

    public String getNazwa() {
        return Nazwa.get();
    }

    public void setidPrzedmioty(int value) {
        idPrzedmioty.set(value);
    }

    public void setNazwa(String value) {
        Nazwa.set(value);
    }

    public IntegerProperty idPrzedmiotyProperty() {
        return idPrzedmioty;
    }

    public StringProperty Nazwa() {
        return Nazwa;
    }
    @Override
    public String toString(){
        return idPrzedmioty.toString()+" "+Nazwa;
    }
}
