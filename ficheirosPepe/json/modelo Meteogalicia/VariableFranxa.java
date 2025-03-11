package com.pepinho.ad.gson.meteogalicia.model;

public class VariableFranxa {

    public static final int NO_DATA = -9999;

    private VariableMeteo variable;
    private int manha;
    private int noite;
    private int tarde;

    public VariableFranxa() {
    }

    public VariableFranxa(String variable) {
        this.variable = VariableMeteo.getVariableMeteo(variable);
    }

    public VariableFranxa(VariableMeteo variable) {
        this.variable = variable;
    }

    public VariableFranxa(VariableMeteo variable, int manha, int noite, int tarde) {
        this.variable = variable;
        this.manha = manha;
        this.noite = noite;
        this.tarde = tarde;
    }

    public VariableMeteo getVariable() {
        return variable;
    }

    public void setVariable(VariableMeteo variable) {
        this.variable = variable;
    }

    public int getManha() {
        return manha;
    }

    public void setManha(int manha) {
        this.manha = manha;
    }

    public int getNoite() {
        return noite;
    }

    public void setNoite(int noite) {
        this.noite = noite;
    }

    public int getTarde() {
        return tarde;
    }

    public void setTarde(int tarde) {
        this.tarde = tarde;
    }

    @Override
    public String toString() {
        return  variable + ": (" + (manha!=NO_DATA ? manha : "-" ) + ", " + (tarde!=NO_DATA ? tarde : "-" ) + ", "
                + (noite!=NO_DATA ? noite : "-" )  + ')';
    }
}
