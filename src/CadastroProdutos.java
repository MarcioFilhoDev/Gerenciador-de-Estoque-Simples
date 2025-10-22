import java.util.ArrayList;
import java.util.Scanner;

public class CadastroProdutos {
    private ArrayList<Produtos> produtos = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    //  Função responsável por verificar se um produto já está cadastrado
    public int verificarProdutos(String nomeProduto) {
        //  Verifica se a lista está vazia, se não estiver segue com o cadastro do produto
        if (produtos.size() == 0) {
            return -1;
        }
        //  Se a lista possuir algum produto, então é preciso verificar
        //  Se não será cadastrado o mesmo item
        else {
            for (int i = 0; i < produtos.size(); i++) {
                //  Pega o primeiro produto cadastro
                Produtos produtosX = produtos.get(i);
                if (produtosX.getNome().equalsIgnoreCase(nomeProduto)) {
                    return i;
                }

            }

            return -1;
        }
    }

    //  Função responsável por cadastrar um produto no estoque
    public void cadastrar() {
        //  Solicita a entrada do nome do produto
        System.out.print("Digite o nome do produto: ");
        String nome = sc.nextLine();

        //  Verificar pelo nome, se esse produto já está cadastrado
        if (verificarProdutos(nome) != -1) {
            System.out.println("Produto já está cadastrado");
        }
        //  Caso não for encontrado o produto no estoque, segue com o cadastro
        else {
            //  Solicita a entrada da quantidade do produto
            System.out.print("Digite a quantidade de " + nome + ": ");
            int quantidade = sc.nextInt();

            //  Verificando se a quantidade é um valor válido
            if (quantidade < 0) {
                while (quantidade < 0) {
                    System.out.println("Quantidade inválida!");

                    //  Solicita novamente a entrada da quantidade para o produto
                    System.out.print("Digite a quantidade de " + nome + ": ");
                    quantidade = sc.nextInt();
                }
            }
            //  Solicita a entrada para o valor unitário do produto
            System.out.printf("Digite o valor unitário de " + nome + ": ");
            String valorUnitario = sc.next();

            //  Converte . para ,
            valorUnitario = valorUnitario.replace(',', '.');

            //  Converte a String para double
            double valorUnitarioReal = Double.parseDouble(valorUnitario);

            //  Limpa o buffer
            sc.nextLine();

            //  Instância um novo produto
            Produtos novoProduto = new Produtos();

            //  Inserindo através de set, o nome e a quantidade
            novoProduto.setNome(nome);
            novoProduto.setQuantidade(quantidade);

            //  Inserindo o valor unitário do produto
            novoProduto.setValorUnitario(valorUnitarioReal);

            //  Chamando a função responsável por adicionar o produto
            produtos.add(novoProduto);

            System.out.println("Produto cadastrado com sucesso!");

        }
    }

    //  Função responsável por mostrar os produtos no estoque
    public void mostrar() {
        // Verificar se a lista de produtos esta vazia
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            System.out.println("Produtos cadastrados:");
            //  Declarando uma variável para obter o valor total do estoque
            double valorTotalEstoque = 0;
            //  Passa produto por produto, resgatando suas informações
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.printf("%-5s | %-20s | %-10s | %-15s | %-10s%n", "ID", "Descrição", "Qtd", "Valor Unit", "Total");
            System.out.println("--------------------------------------------------------------------------------------");

            for (Produtos item : produtos) {
                System.out.printf("%-5d | %-20s | %-10d | R$ %-15.2f | R$ %-10.2f%n",
                        item.getId(),
                        item.getNome(),
                        item.getQuantidade(),
                        item.getValorUnitario(),
                        item.getValorTotalProduto());
                valorTotalEstoque += item.getValorTotalProduto();
                System.out.println("--------------------------------------------------------------------------------------");
            }

            //  Ao terminar de passar por todos os produtos, mostra o valor total do estoque
            System.out.printf("Valor total do estoque: R$ %.2f%n", valorTotalEstoque);
        }
    }

    //  Função responsável por retirar uma quantidade de um produto do estoque
    public void saida() {
        // Verificar se a lista de produtos esta vazia
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            System.out.printf("Digite o id do produto: ");
            int id_escolhido = sc.nextInt();

            boolean existe;

            //  Verificar se o ID escolhido existe
            for (int i = 0; i < produtos.size(); i++) {
                Produtos produto_escolhido = produtos.get(i);

                int retirados = 0;

                //  Se existe, então deleta ele
                if (produto_escolhido.getId() == id_escolhido) {
                    //  Solicita a quantidade de itens a ser retirado
                    System.out.printf("Quantidade de " + produto_escolhido.getNome() + " a ser retirado: ");
                    retirados = sc.nextInt();

                    //  Verificar se a quantidade no estoque é maior que a quantidade que deseja retirar
                    if (produto_escolhido.getQuantidade() >= retirados) {
                        System.out.printf("Foram retirados " + retirados + " unidades de " + produto_escolhido.getNome() + "\n");
                        produto_escolhido.setQuantidade(produto_escolhido.getQuantidade() - retirados);
                        return;
                    } else {
                        System.out.println("Não existe essa quantidade de produto para ser retirado do estoque!");
                        return;
                    }
                } else {
                    System.out.println("Não existe esse produto");
                    return;
                }
            }
        }
    }
}