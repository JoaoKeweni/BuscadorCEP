package br.com.joao.buscadorcep.models;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Requisicao {

    public String requisicaoApi(String cep) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://viacep.com.br/ws/" + cep + "/json/"))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
    public void salvarJson (String enderecoJson, String cep) throws IOException {
        FileWriter escrever = new FileWriter("Endereco " + cep + ".json");
        escrever.write(enderecoJson);
        escrever.close();
    }
}
