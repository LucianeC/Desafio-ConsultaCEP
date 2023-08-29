import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeradorDeArquivo {

    // Metedo Void ( gera o arquivo sem retorno)

    public void salvaJson(Endereco endereco) throws IOException {
        //Imprime com a formatação mais organizada
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        //A cada novo CEP gera um novo arquivo
        FileWriter escrita = new FileWriter(endereco.cep() + ".json");
        escrita.write(gson.toJson(endereco));
        escrita.close();
    }
}
