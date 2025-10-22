import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CadastroProdutos cadastro = new CadastroProdutos();

        int escolha = 0;

        do {
            System.out.println("1 - Cadastrar produtos");
            System.out.println("2 - Mostrar produtos cadastrados");
            System.out.println("3 - Saída de produtos");
            System.out.println("4 - DESISTIR");

            escolha = sc.nextInt();

            switch (escolha){
                case 1:
                    cadastro.cadastrar();
                    break;
                case 2:
                    cadastro.mostrar();
                    break;
                case 3:
                    cadastro.mostrar();
                    cadastro.saida();
                    break;
                case 4:
                    escolha = 0;
                    System.out.println("Você optou por sair.");
                default:
                    System.out.printf("Você escolheu errado.");
            }
        } while (escolha != 0);
    }
}