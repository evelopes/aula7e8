/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author eveli
 */
public class Funcionario {
    int numat;
    String nome;
    float salario;
    String sexo;
    int ndepto;
    int nsuper;

    public Funcionario(int numat, String nome, float salario, String sexo, int ndepto, int nsuper) {
        this.numat = numat;
        this.nome = nome;
        this.salario = salario;
        this.sexo = sexo;
        this.ndepto = ndepto;
        this.nsuper = nsuper;
    }
    
    public int getNumat() {
        return numat;
    }

    public void setNumat(int numat) {
        this.numat = numat;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getNdepto() {
        return ndepto;
    }

    public void setNdepto(int ndepto) {
        this.ndepto = ndepto;
    }

    public int getNsuper() {
        return nsuper;
    }

    public void setNsuper(int nsuper) {
        this.nsuper = nsuper;
    }
    
}