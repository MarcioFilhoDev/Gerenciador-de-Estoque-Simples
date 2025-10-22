import java.util.Random;

public class Produtos {
    Random random = new Random();

    private int id;
    private String nome;
    private int quantidade;
    private double valorUnitario;
    private double total;

    public Produtos() {
        this.id = random.nextInt(10000);
        this.nome = nome;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.total = total;
    }

    //  Resgatar o ID do produto
    public int getId() {
        return id;
    }

    //  Resgatar o NOME do produto
    public String getNome() {
        return nome;
    }

    //  Atribuir o NOME ao produto
    public void setNome(String nome){
        this.nome = nome;
    }

    //  Resgatar a QUANTIDADE do produto
    public int getQuantidade(){
        return quantidade;
    }

    //  Atribuir a QUANTIDADE do produto
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

    //  Resgatar o VALOR UNITÁRIO do produto
    public double getValorUnitario(){
        return valorUnitario;
    }

    //  Atribuir o VALOR UNITÁRIO ao produto
    public void setValorUnitario(double valorUnitario){
        this.valorUnitario = valorUnitario;
    }

    //  Resgatar o TOTAL do produto
    public double getValorTotalProduto(){
        return valorUnitario * quantidade;
    }
}
