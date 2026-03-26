package br.com.joao.buscadorcep.main;

import java.io.IOException;
import java.util.Scanner;
import br.com.joao.buscadorcep.models.Requisicao;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Seja bem vindo ao BuscaCEP");
        Scanner leitura = new Scanner(System.in);
        String opcao = "";
        String cep = "";
        String enderecoJson = "";
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
                    Requisicao consulta = new Requisicao();
                    enderecoJson = consulta.requisicaoApi(cep);
                    System.out.println(enderecoJson);
                    break;
                case "2":
                    if (enderecoJson.isEmpty()){
                        System.out.println("Digite um CEP antes de tentar baixar");
                    }else {
                        Requisicao salvar = new Requisicao();
                        salvar.salvarJson(enderecoJson, cep);
                        System.out.println("Arquivo salvo com sucesso...");
                    }
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