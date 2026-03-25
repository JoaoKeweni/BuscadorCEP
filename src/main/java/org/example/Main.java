package org.example;

import java.io.IOException;
import java.util.Scanner;
import models.Requisicao;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Seja bem vindo ao BuscaCEP");
        Scanner leitura = new Scanner(System.in);
        String opcao = "";
        String cep;
        do {
            System.out.println("1- Buscar pelo CEP");
            System.out.println("2- Baixar JSON");
            System.out.println("3- Sair");
            System.out.println("Escolhar uma das opções abaixo: ");
            opcao = leitura.nextLine();

            switch (opcao) {
                case "1":
                    System.out.println("Digite o CEP: ");
                    cep = leitura.nextLine();
                    // TODO: criar metodo de buscar o cep usando cep digitado
                    Requisicao consulta = new Requisicao();
                    consulta.requisicaoApi(cep);
                    break;
                case "2":
                    System.out.println("Digite o CEP: ");
                    cep = leitura.nextLine();
                    // TODO: Usar o metodo de buscar o cep
                    // TODO: Criar o metodo de criar o JSON com os dados retornados da minha API
                    break;
                case "3":
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;

            }
        } while (!opcao.equals("3"));

    }
}