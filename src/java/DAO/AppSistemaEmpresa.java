/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author eveli
 */

import java.util.ArrayList;
import java.util.Scanner;
public class AppSistemaEmpresa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // adiciona um novo funcionário
        FuncionarioDao dao = new FuncionarioDao();
        ArrayList<Funcionario> listaFuncionarios = dao.getLista();

//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("Digite o número de matrícula do novo funcionário:");
//        int numat = sc.nextInt();
//        sc.nextLine(); // limpar o buffer do scanner
//
//        System.out.println("Digite o nome do novo funcionário:");
//        String nome = sc.nextLine();
//
//        System.out.println("Digite o salário do novo funcionário:");
//        float salario = sc.nextFloat();
//        sc.nextLine(); // limpar o buffer do scanner
//
//        System.out.println("Digite o sexo do novo funcionário (M ou F):");
//        String sexo = sc.nextLine();
//
//        System.out.println("Digite o número do departamento do novo funcionário:");
//        int ndepto = sc.nextInt();
//
//        System.out.println("Digite o número do supervisor do novo funcionário:");
//        int nsuper = sc.nextInt();
//
//        // criar um objeto Funcionario com os dados lidos
//        Funcionario novoFuncionario = new Funcionario(numat, nome, salario, sexo, ndepto, nsuper);
//        dao.adiciona(novoFuncionario);

        for (Funcionario funcionario : listaFuncionarios) {
            System.out.println(
                    funcionario.getNumat() + " - "
                    + funcionario.getNome() + " - "
                    + funcionario.getSalario() + " - "
                    + funcionario.getSexo() + " - "
                    + funcionario.getNdepto() + " - "
                    + funcionario.getNsuper());
        }
    }

}