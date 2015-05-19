package com.example.boli.aplicacion_ganado.modelos;

/**
 * Created by BOLI on 23/04/2015.
 */
public class modelo_vacas {
    private String n_arete;
    private String f_nacimiento;
    private String nombre;
    private String sexo;
    private String f_gestacion;
    private String f_parto;

    public modelo_vacas(String n_arete, String f_nacimiento, String nombre, String sexo, String f_gestacion, String f_parto) {
        this.n_arete = n_arete;
        this.f_nacimiento = f_nacimiento;
        this.nombre = nombre;
        this.sexo = sexo;
        this.f_gestacion = f_gestacion;
        this.f_parto = f_parto;
    }

    public String getN_arete() {
        return n_arete;
    }

    public String getF_nacimiento() {
        return f_nacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public String getF_gestacion() {
        return f_gestacion;
    }

    public String getF_parto() {
        return f_parto;
    }
}

