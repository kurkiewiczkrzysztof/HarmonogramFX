/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harmonogramfx.Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author USER
 */
public class Pracownicy {
    
    private final IntegerProperty idPracownicy;
    private final StringProperty Plec;
    private final LongProperty Pesel;
    private final StringProperty Nazwisko;
    private final StringProperty Imie;
    
    public Pracownicy(int idPracownicy, String Plec, long Pesel, String Nazwisko, String Imie) {
        this.idPracownicy = new SimpleIntegerProperty(idPracownicy);
        this.Plec = new SimpleStringProperty(Plec);
        this.Pesel = new SimpleLongProperty(Pesel);
        this.Nazwisko = new SimpleStringProperty(Nazwisko);
        this.Imie = new SimpleStringProperty(Imie);
    }
    
    public int getIdPracownicy() {
        return idPracownicy.get();
    }

    public void setIdPracownicy(int value) {
        idPracownicy.set(value);
    }
    
    public String getPlec() {
        return Plec.get();
    }

    public void setPlec(String value) {
        Plec.set(value);
    }
    
    public long getPesel() {
        return Pesel.get();
    }

    public void setPesel(long value) {
        Pesel.set(value);
    }
    
    public String getNazwisko() {
        return Nazwisko.get();
    }

    public void setNazwisko(String value) {
        Nazwisko.set(value);
    }

    public String getImie() {
        return Imie.get();
    }

    public void setImie(String value) {
        Imie.set(value);
    }
    public IntegerProperty idPracownicyProperty()
    {
        return idPracownicy;
    }
    public StringProperty Plec()
    {
        return Plec;
    }
    public LongProperty Pesel()
    {
        return Pesel;
    }
    public StringProperty Imie()
    {
        return Imie;
    }
    public StringProperty Nazwisko()
    {
        return Nazwisko;
    }
}

