package com.proiectpad2.domain;

public class User {

    private String subiect;
    private String emailAddress;
    private String text;

    public User(){}

    public String getSubiect() {
        return subiect;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public void setHtmlText(Comanda cc) {

        if (cc.getState().equals("Sent")) {
            subiect="Confirmare Comanda";
            text = "<html> <body>";
            text += "<h2>Comanda dumneavoastra Nr. " + cc.getOid() + " din data " + cc.getData() + "</h2>";
            text+="<table style=\"width:100%\">";
            for (Product p : cc.getOrderItems()) {
                text+="<tr><td>"+p.getProductName() + "</td><td>";
                if (p.getIngredients() != null){
                    text += "Ingrediente: " + p.getIngredients() ;
                }
                text+="</td><td> Pret: " + p.getPrice() + " </td><td><img src=";
                text+=p.getPic()+" width=\"100\" height=\"100\">";
                text+="</td></tr>";
            }

            text+="<h2><tr><td>Numar produse: </td><td>"+ cc.getNrItems();
            text+="</td><td>  Pret total: " + cc.getTotalPrice() + " </td><td></td></tr></h2>";
            text += "</table></body></html> ";
        }
        else if (cc.getState().equals("Done")) {
                subiect="Livrare comanda";
                text = "<html> <body>";
                text += "<h2.>Bon Comanda Nr. " + cc.getOid() + " din data " + cc.getData() + "\n\n";
                text+="<table style=\"width:100%\">";
            for (Product p : cc.getOrderItems()) {
                text+="<tr><td>"+p.getProductName() + "</td>";
                text+="<td> Pret: " + p.getPrice() + " </td></tr>";
            }
            text+="<tr><td><hr> Numar produse: "+ cc.getNrItems()+"</td><td><hr> Pret total: "+cc.getTotalPrice();
            text += "</td></tr></table></body></html> ";
        }
    }

    public void setText(Comanda cc) {
        if(cc.getState().equals("Sent")) {

            text="Comanda dumneavoastra Nr. " +cc.getOid() + " din data "+cc.getData() +"\n\n";
            for (Product p : cc.getOrderItems()) {
                text += p.getProductName() + "\t Pret: " + p.getPrice() + " \n";
                if (p.getIngredients() != null) text += "Ingrediente: " + p.getIngredients() + "\n";
                text += "Cantitate " + p.getQuantity() + " grame\n";
            }
            text+="\nNumar produse: "+ cc.getNrItems()+"\nPret total: " + cc.getTotalPrice() + " \n";
        }else if(cc.getState().equals("Done"))
        {
            text="Bon Comanda Nr. "+cc.getOid() + " din data "+cc.getData() +"\n\n";;
            for (Product p : cc.getOrderItems()) {
                text += p.getProductName() + "........................................."  + p.getPrice()+" \n";
            }
            text+="\nNumar produse: "+ cc.getNrItems()+"\nPret total: " + cc.getTotalPrice() + " \n";
        }
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
