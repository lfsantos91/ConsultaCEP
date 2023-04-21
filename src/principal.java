import java.io.IOException;
import java.util.Scanner;

public class principal {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        BuscaCEP buscaCEP = new BuscaCEP();

        System.out.println("Digite o número do CEP: ");
        var cep = leitura.nextLine();

        try {
            Endereco novoEndereco = buscaCEP.buscaEndereco(cep);
            System.out.println(novoEndereco);
            GerarArquivo gerarArquivo = new GerarArquivo();
            gerarArquivo.salvaCEPJson(novoEndereco);
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando busca.");
        }
    }
}