/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harmonogramfx;

import harmonogramfx.Models.Pracownicy;
import harmonogramfx.Models.Przedmioty;
import harmonogramfx.Models.Rozklady;
import harmonogramfx.Models.Sale;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.StringConverter;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private Button button;

    @FXML
    private TableView<Przedmioty> tablePrzedmioty;

    @FXML
    private TableColumn<Przedmioty, Integer> columnidPrzedmioty;

    @FXML
    private TableColumn<Przedmioty, String> columnNazwaPrzedmioty;

    @FXML
    private TextField txtUsunPrzedmioty;

    @FXML
    private ComboBox comboNazwaPrzedmiotu;

    @FXML
    private ComboBox comboNazwaPracownik;

    @FXML
    private ComboBox comboNumerSali;

    @FXML
    private Button btnUsunPrzedmioty;

    @FXML
    private TextField txtDodajIdPrzedmioty;

    @FXML
    private TextField txtDodajNazwaPrzedmioty;

    @FXML
    private Button btnEdytujPrzedmioty;

    @FXML
    private Button btnDodajPrzedmiot;

    @FXML
    private TableView<Pracownicy> tablePracownicy;

    @FXML
    private TableColumn<Pracownicy, Integer> columnidPracownicy;

    @FXML
    private TableColumn<Pracownicy, String> columnPlec;

    @FXML
    private TableColumn<Pracownicy, Long> columnPesel;

    @FXML
    private TableColumn<Pracownicy, String> columnImie;

    @FXML
    private TableColumn<Pracownicy, String> columnNazwisko;

    @FXML
    private TextField txtDodajidPracownicy;

    @FXML
    private TextField txtDodajPlec;

    @FXML
    private TextField txtDodajPesel;

    @FXML
    private TextField txtDodajImie;

    @FXML
    private TextField txtDodajNazwisko;

    @FXML
    private Button btnDodajPracownika;

    @FXML
    private Button btnEdytujPracownika;

    @FXML
    private Button btnUsunPracownika;

    @FXML
    private TextField txtEdytujIdPracownika;

    @FXML
    private TableView<Sale> tableSale;

    @FXML
    private TableColumn<Sale, Integer> columnidSale;

    @FXML
    private TableColumn<Sale, Integer> columniloscStudentow;

    @FXML
    private TextField txtDodajIdSali;

    @FXML
    private TextField txtDodajIloscStudentow;

    @FXML
    private TextField txtEdytujIdSali;

    @FXML
    private Button btnDodajSale;

    @FXML
    private Button btnUsunSale;

    @FXML
    private Button btnEdytujSale;

    @FXML
    private TableView<Rozklady> tableRozklady;

    @FXML
    private TableColumn<Rozklady, Integer> columnRozkladSale;

    @FXML
    private TableColumn<Rozklady, Timestamp> columnRozkladDzien;

    @FXML
    private TableColumn<Rozklady, Integer> columnRozkladPracownik;

    @FXML
    private TableColumn<Rozklady, Integer> columnRozkladyPrzedmiot;
    @FXML
    private DatePicker datepicker;
    @FXML
    private TextField txtdocombotest;
    @FXML
    private ComboBox comboRozkladyIdSale;

    @FXML
    private DatePicker DataPickerRozklady;

    @FXML
    private TextField txtRozkladyGodzina;

    @FXML
    private TextField txtRozkladyMinuty;

    @FXML
    private TextField txtRozkladySekundy;

    @FXML
    private ComboBox ComboRozkladyPracownicy;

    @FXML
    private ComboBox comboRozkladyPrzedmioty;

    @FXML
    private TextField txtRozkladyNumerSali;

    @FXML
    private TextField txtRozkladyPracownicy;
    @FXML
    private TextField textRozkladyData;
    @FXML
    private Button btnZajmijSale;
    @FXML
    private TextField txtRozkladyPrzedmioty;
    private ObservableList<Przedmioty> danePrzedmioty;
    private ObservableList<Pracownicy> daniPracownicy;
    private ObservableList<Sale> daneSale;
    private ObservableList<Rozklady> daneRozklady;

    //private ObservableList opcjePrzedmioty = FXCollections.observableArrayList();
    //private ObservableList opcjePracownicy = FXCollections.observableArrayList();
    private DbConnection dbC;
    Statement pst;

    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException {
        DbConnection dbC = new DbConnection();
        if (dbC.getConnection() == null) {
            label.setText("Nie udalo sie!");
        } else {
            label.setText("Polaczono!");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dbC = new DbConnection();
        WyswietlanieListyPrzedmiotow();
        WyswietlanieListyPracownikow();
        WyswietlanieListySal();
        WyswietlanieListyRozkladow();
        UzupelnijComboBoxPrzedmioty();
        UzupelnijComboBoxPracownicy();
        UzupelnijComboBoxSale();
        UzupelnijComboBoxyRozklady();
        DataPickerRozklady.setConverter(new StringConverter<LocalDate>() {
            private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

            @Override
            public String toString(LocalDate localDate) {
                if (localDate == null) {
                    return "";
                }
                textRozkladyData.setText(String.valueOf(DataPickerRozklady.getValue()));
                return dateTimeFormatter.format(localDate);
            }

            @Override
            public LocalDate fromString(String dateString) {
                if (dateString == null || dateString.trim().isEmpty()) {
                    return null;
                }
                return LocalDate.parse(dateString, dateTimeFormatter);
            }
        });
    }

    @FXML
    void onClickUsunPrzedmioty(ActionEvent event) {
        try {
            Connection conn = dbC.getConnection();
            String query = "delete from Przedmioty where idPrzedmioty = " + txtUsunPrzedmioty.getText();
            pst = conn.prepareStatement(query);
            pst.executeUpdate(query);
            pst.close();
            WyswietlanieListyPrzedmiotow();
        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }

    }

    @FXML
    void onClickDodajPrzedmioty(ActionEvent event) {
        try {
            Connection conn = dbC.getConnection();
            String query = "INSERT INTO Przedmioty(idPrzedmioty,Nazwa) VALUES('" + txtDodajIdPrzedmioty.getText() + "',\"" + txtDodajNazwaPrzedmioty.getText() + "\")";
            pst = conn.prepareStatement(query);

            pst.execute(query);
            pst.close();
            WyswietlanieListyPrzedmiotow();
        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }
    }

    @FXML
    void onClickEdytujPrzedmioty(ActionEvent event) {
        try {
            Connection conn = dbC.getConnection();
            String query = "UPDATE Przedmioty SET idPrzedmioty=" + txtDodajIdPrzedmioty.getText() + ",Nazwa=\"" + txtDodajNazwaPrzedmioty.getText() + "\" Where idPrzedmioty=" + txtUsunPrzedmioty.getText();
            pst = conn.prepareStatement(query);

            pst.execute(query);
            pst.close();
            WyswietlanieListyPrzedmiotow();
        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }
    }

    @FXML
    void onClickDodajPracownika(ActionEvent event) {
        try {
            Connection conn = dbC.getConnection();
            String query = "INSERT INTO Pracownicy(idPracownicy,Plec,Pesel,Imie,Nazwisko) VALUES('" + txtDodajidPracownicy.getText() + "',\"" + txtDodajPlec.getText() + "\",'" + txtDodajPesel.getText() + "',\"" + txtDodajImie.getText() + "\",\"" + txtDodajNazwisko.getText() + "\")";
            pst = conn.prepareStatement(query);

            pst.execute(query);
            pst.close();
            WyswietlanieListyPracownikow();
        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }
    }

    @FXML
    void onClickEdytujPracownika(ActionEvent event) {
        try {
            Connection conn = dbC.getConnection();
            String query = "UPDATE Pracownicy SET idPracownicy=" + txtDodajidPracownicy.getText() + ",Plec=\"" + txtDodajPlec.getText() + "\",Pesel=" + txtDodajPesel.getText() + ",Imie=\"" + txtDodajImie.getText() + "\",Nazwisko=\"" + txtDodajNazwisko.getText() + "\" Where idPracownicy=" + txtEdytujIdPracownika.getText();
            pst = conn.prepareStatement(query);

            pst.execute(query);
            pst.close();
            WyswietlanieListyPracownikow();
        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }
    }

    @FXML
    void onClickUsunPracownika(ActionEvent event) {
        try {
            Connection conn = dbC.getConnection();
            String query = "delete from Pracownicy where idPracownicy = " + txtEdytujIdPracownika.getText();
            pst = conn.prepareStatement(query);
            pst.executeUpdate(query);
            pst.close();
            WyswietlanieListyPracownikow();
        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }
    }

    @FXML
    void onClickDodajSale(ActionEvent event) {
        try {
            Connection conn = dbC.getConnection();
            String query = "INSERT INTO Sale(idSale,iloscStudentow) VALUES('" + txtDodajIdSali.getText() + "','" + txtDodajIloscStudentow.getText() + "')";
            pst = conn.prepareStatement(query);

            pst.execute(query);
            pst.close();
            WyswietlanieListySal();
        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }
    }

    @FXML
    void onClickEdytujSale(ActionEvent event) {
        try {
            Connection conn = dbC.getConnection();
            String query = "UPDATE Sale SET idSale=" + txtDodajIdSali.getText() + ",iloscStudentow=" + txtDodajIloscStudentow.getText() + " Where idSale=" + txtEdytujIdSali.getText();
            pst = conn.prepareStatement(query);

            pst.execute(query);
            pst.close();
            WyswietlanieListySal();
        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }
    }

    @FXML
    void onClickUsunSale(ActionEvent event) {
        try {
            Connection conn = dbC.getConnection();
            String query = "delete from Sale where idSale = " + txtEdytujIdSali.getText();
            pst = conn.prepareStatement(query);
            pst.executeUpdate(query);
            pst.close();
            WyswietlanieListySal();
        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }
    }

    @FXML
    void onClickZajmijSale(ActionEvent event) {
        try{
        String idSali = txtRozkladyNumerSali.getText();
        String data = textRozkladyData.getText();
        String godzina = txtRozkladyGodzina.getText()+":"+txtRozkladyMinuty.getText()+
                ":"+txtRozkladyMinuty.getText();
        String pelnadata = data+" "+godzina+".0";
        String idPracownika = txtRozkladyPracownicy.getText();
        String idPrzedmioty = txtRozkladyPrzedmioty.getText();
        textRozkladyData.setText(pelnadata);
//textRozkladyData.setText(daneRozklady.get(0).getDzien().toString());
        if(daneRozklady.get(0).getDzien().toString().equalsIgnoreCase(textRozkladyData.getText()))
            System.out.println("Sa rowne");
        else
            System.out.println("pierdol sie");
        int i=0;
        for(Rozklady r : daneRozklady)
        {
            if(r.getIdSale()==Integer.parseInt(idSali)&&r.getDzien().toString().equalsIgnoreCase(textRozkladyData.getText()))
            {
                System.out.println("ZAREZERWOWANE!" + i);
                i++;
            }
            else
            {
                System.out.println("ok" + i);
            }
                
        }
       if(i==0){
            System.out.println("Oke");
            
        try {
            Connection conn = dbC.getConnection();
            String query = 
                    "INSERT INTO rozklady(idSale,Dzien,idPracownicy,idPrzedmioty)"
                    + " VALUES('" + idSali + "','" 
                    + pelnadata + "','"+idPracownika+"','"+idPrzedmioty+"')";
            pst = conn.prepareStatement(query);

            pst.execute(query);
            pst.close();
            WyswietlanieListySal();
        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }
        WyswietlanieListyRozkladow();
        }else
        {
            JOptionPane.showMessageDialog(null, "Jest juz taka rezerwacja");
        }
        }catch(Exception e)
        {
            e.getCause();
        }
    }

    public void WyswietlanieListyPrzedmiotow() {
        try {
            Connection conn = dbC.getConnection();
            danePrzedmioty = FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM Przedmioty");
            while (rs.next()) {
                danePrzedmioty.add(new Przedmioty(rs.getInt(1), rs.getString(2)));

            }
        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }
        columnidPrzedmioty.setCellValueFactory(new PropertyValueFactory<>("idPrzedmioty"));
        columnNazwaPrzedmioty.setCellValueFactory(new PropertyValueFactory<>("Nazwa"));
        //comboNazwa.setItems(danePrzedmioty);
        tablePrzedmioty.setItems(null);
        tablePrzedmioty.setItems(danePrzedmioty);
    }

    public void WyswietlanieListyPracownikow() {
        try {
            Connection conn = dbC.getConnection();
            daniPracownicy = FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM Pracownicy");
            while (rs.next()) {
                daniPracownicy.add(new Pracownicy(rs.getInt(1), rs.getString(2), rs.getLong(3), rs.getString(4), rs.getString(5)));
            }
        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }
        columnidPracownicy.setCellValueFactory(new PropertyValueFactory<>("idPracownicy"));
        columnPlec.setCellValueFactory(new PropertyValueFactory<>("Plec"));
        columnPesel.setCellValueFactory(new PropertyValueFactory<>("Pesel"));
        columnImie.setCellValueFactory(new PropertyValueFactory<>("Imie"));
        columnNazwisko.setCellValueFactory(new PropertyValueFactory<>("Nazwisko"));
        tablePracownicy.setItems(null);
        tablePracownicy.setItems(daniPracownicy);
    }

    public void WyswietlanieListySal() {
        try {
            Connection conn = dbC.getConnection();
            daneSale = FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM Sale");
            while (rs.next()) {
                daneSale.add(new Sale(rs.getInt(1), rs.getInt(2)));
            }
        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }
        columnidSale.setCellValueFactory(new PropertyValueFactory<>("idSale"));
        columniloscStudentow.setCellValueFactory(new PropertyValueFactory<>("iloscStudentow"));
        tableSale.setItems(null);
        tableSale.setItems(daneSale);
    }

    public void WyswietlanieListyRozkladow() {
        try {
            Connection conn = dbC.getConnection();
            daneRozklady = FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM Rozklady");
            while (rs.next()) {
                daneRozklady.add(new Rozklady(rs.getInt(1), rs.getTimestamp(2), rs.getInt(3), rs.getInt(4)));
            }
        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }

        columnRozkladSale.setCellValueFactory(new PropertyValueFactory<>("idSale"));
        columnRozkladDzien.setCellValueFactory(new PropertyValueFactory<>("Dzien"));
        columnRozkladPracownik.setCellValueFactory(new PropertyValueFactory<>("idPracownicy"));
        columnRozkladyPrzedmiot.setCellValueFactory(new PropertyValueFactory<>("idPrzedmioty"));
        tableRozklady.setItems(null);
        tableRozklady.setItems(daneRozklady);
    }

    public void UzupelnijComboBoxPrzedmioty() {
        comboNazwaPrzedmiotu.setItems(danePrzedmioty);
        comboNazwaPrzedmiotu.setConverter(new StringConverter<Przedmioty>() {

            @Override
            public String toString(Przedmioty object) {
                txtUsunPrzedmioty.setText(String.valueOf(object.getidPrzedmioty()));
                return object.getNazwa();
            }

            @Override
            public Przedmioty fromString(String string) {
                return null;
            }
        });
    }

    public void UzupelnijComboBoxPracownicy() {

        comboNazwaPracownik.setItems(daniPracownicy);
        comboNazwaPracownik.setConverter(new StringConverter<Pracownicy>() {

            @Override
            public String toString(Pracownicy object) {
                txtEdytujIdPracownika.setText(String.valueOf(object.getIdPracownicy()));

                return object.getImie() + " " + object.getNazwisko();
            }

            @Override
            public Pracownicy fromString(String string) {
                return null;
            }
        });
    }

    public void UzupelnijComboBoxSale() {
        comboNumerSali.setItems(daneSale);
        comboNumerSali.setConverter(new StringConverter<Sale>() {

            @Override
            public String toString(Sale object) {
                txtEdytujIdSali.setText(String.valueOf(object.getIdSale()));

                return String.valueOf(object.getIdSale());
            }

            @Override
            public Sale fromString(String string) {
                return null;
            }
        });
    }

    public void UzupelnijComboBoxyRozklady() {
        comboRozkladyIdSale.setItems(daneSale);
        comboRozkladyIdSale.setConverter(new StringConverter<Sale>() {

            @Override
            public String toString(Sale object) {
                txtRozkladyNumerSali.setText(String.valueOf(object.getIdSale()));

                return String.valueOf(object.getIdSale());
            }

            @Override
            public Sale fromString(String string) {
                return null;
            }
        });

        ComboRozkladyPracownicy.setItems(daniPracownicy);
        ComboRozkladyPracownicy.setConverter(new StringConverter<Pracownicy>() {

            @Override
            public String toString(Pracownicy object) {
                txtRozkladyPracownicy.setText(String.valueOf(object.getIdPracownicy()));

                return object.getImie() + " " + object.getNazwisko();
            }

            @Override
            public Pracownicy fromString(String string) {
                return null;
            }
        });

        comboRozkladyPrzedmioty.setItems(danePrzedmioty);
        comboRozkladyPrzedmioty.setConverter(new StringConverter<Przedmioty>() {

            @Override
            public String toString(Przedmioty object) {
                txtRozkladyPrzedmioty.setText(String.valueOf(object.getidPrzedmioty()));
                return object.getNazwa();
            }

            @Override
            public Przedmioty fromString(String string) {
                return null;
            }
        });
    }

}
