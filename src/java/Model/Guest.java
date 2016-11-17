/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Michael Sinner
 */
public class Guest {
    
    private int id;
    private String name;
    private String telephone;
    private String cedula;
    private String email;
    private int daysStay;
    private int numRoom;
    private int payment;
    private final int paymentPerDay = 100000;

    public Guest(){
        this.payment = paymentPerDay*daysStay;
    }
    public Guest(String name, String telephone, String cedula, String email, int daysStay, int numRoom, int payment) {
        this.name = name;
        this.telephone = telephone;
        this.cedula = cedula;
        this.email = email;
        this.daysStay = daysStay;
        this.numRoom = numRoom;
        this.payment = paymentPerDay*daysStay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDaysStay() {
        return daysStay;
    }

    public void setDaysStay(int daysStay) {
        this.daysStay = daysStay;
    }

    public int getNumRoom() {
        return numRoom;
    }

    public void setNumRoom(int numRoom) {
        this.numRoom = numRoom;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }
    
    
    
}
