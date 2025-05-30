public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirDados() {
        System.out.println("Extrato Conta Poupanca");
        super.imprimirDados();
    }
}
