import java.io.IOException;
import java.util.Scanner;

public class Principal {

    // Classe Para representar o endereço
    public static void main(String[] args) {
        //Solicitação para o usuário inserir o CEP
        Scanner leitor = new Scanner(System.in);

        ConsultaCep consultaCep = new ConsultaCep();
        System.out.println("Digite o CEP para ser consultado o endereço: ");

        //Ler em uma variavel
        var cep = leitor.nextLine();


        // Se apresentar RuntimeException, retorna a mensgem de erro e finaliza a aplicaçao
        try {
            Endereco novoEndereco = consultaCep.buscaEndereco(cep);
            System.out.println(novoEndereco);
            GeradorDeArquivo gerador = new GeradorDeArquivo();
            gerador.salvaJson(novoEndereco);
        }catch (RuntimeException | IOException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando aplicação");
        }

    }
}
