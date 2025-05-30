import java.util.ArrayList;
import java.util.List;

public class Banco {

    private String nome;
    private List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();

    }

    public String getNome() {
        return nome;
    }

    public void adicionarConta(Conta conta) {
        this.contas.add(conta);
        System.out.println(String.format("Conta %d de %s adicionada ao banco %s.",
                conta.getNumero(), conta.getCliente().getNome(), this.nome));
    }

    public void listarContas() {
        if (this.contas.isEmpty()) {
            System.out.println("O banco " + this.nome + " não possui contas cadastradas.");
            return;
        }
        System.out.println("\n=== Contas do Banco " + this.nome + " ===");
        for (Conta conta : this.contas) {
            String tipoConta = (conta instanceof ContaCorrente) ? "Corrente" : "Poupança";
            System.out.println(
                    String.format("Titular: %s - Agência: %d - Número: %d - Tipo: %s - Saldo: R$ %.2f",
                            conta.getCliente().getNome(),
                            conta.getAgencia(),
                            conta.getNumero(),
                            tipoConta,
                            conta.getSaldo()
                    )
            );
        }
        System.out.println("===================================");
    }

}
