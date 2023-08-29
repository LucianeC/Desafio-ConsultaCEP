import com.google.gson.Gson;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCep {
    //Método para retorna um endereço
    public Endereco buscaEndereco(String cep) {

        //Contatenado - Criar a String
        URI endereco = URI.create("https://viacep.com.br/ws/" + cep + "/json");

        //Requisição
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        //Resposta
        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            //Biblioteca Gson para transformar/retornar em um objeto
            return new Gson().fromJson(response.body(), Endereco.class);
            //Lançar uma nova exceção
        } catch (Exception e) {
            throw new RuntimeException("Não foi possivél obter o endereço a partir desse CEP");
        }


    }
}



