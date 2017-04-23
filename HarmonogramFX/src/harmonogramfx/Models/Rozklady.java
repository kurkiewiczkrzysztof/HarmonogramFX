/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harmonogramfx.Models;

import java.text.SimpleDateFormat;
import javafx.beans.property.IntegerProperty;
import java.sql.Date;
import java.sql.Time;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.sql.Timestamp;

/**
 *
 * @author USER
 */
public class Rozklady {

    private final IntegerProperty idSale;
    private final Timestamp Dzien;
    private final IntegerProperty idPracownicy;
    private final IntegerProperty idPrzedmioty;
    
    public IntegerProperty IdSale() {
        return idSale;
    }

    public Timestamp Dzien() {
        return Dzien;
    }

    public IntegerProperty IdPracownicy() {
        return idPracownicy;
    }

    public IntegerProperty IdPrzedmioty() {
        return idPrzedmioty;
    }

    public int getIdSale() {
        return idSale.get();
    }

    public void setIdSale(int value) {
        idSale.set(value);
    }

    public Timestamp getDzien() {
        return Dzien;
    }

    public void setDzien(long value) {
        Dzien.setTime(value);
    }

    public int getIdPracownicy() {
        return idPracownicy.get();
    }
    public void setIdPracownicy(int value){
        idPracownicy.set(value);
    }
    public int getIdPrzedmioty() {
        return idPrzedmioty.get();
    }
    public void setIdPrzedmioty(int value){
        idPrzedmioty.set(value);
    }


    public Rozklady(int idSale, Timestamp Dzien, int idPracownicy, int idPrzedmioty) {
        this.idSale = new SimpleIntegerProperty(idSale);
        this.Dzien = Dzien;
        this.idPracownicy = new SimpleIntegerProperty(idPracownicy);
        this.idPrzedmioty = new SimpleIntegerProperty(idPrzedmioty);
    }
}
