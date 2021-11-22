package com.example.appliedfmysql.Modele;

public class Releve {

    protected String hp;
    protected String hc;
    protected String raison;
    protected Integer idcli;

    public Releve(String hp, String hc, String raison, Integer idcli) {

        this.hp = hp;
        this.hc = hc;
        this.raison = raison;
        this.idcli = idcli;
    }


    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getHc() {
        return hc;
    }

    public void setHc(String hc) {
        this.hc = hc;
    }

    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }

    public Integer getIdcli() {
        return idcli;
    }

    public void setIdcli(Integer idcli) {
        this.idcli = idcli;
    }
}
