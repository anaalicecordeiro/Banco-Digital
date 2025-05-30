public abstract class Conta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1; // usado para gerar numeros de contas unicos

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.saldo = 0.0;
    }

    public int getAgencia() {
        return agencia;
    }
    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de saque deve ser positivo");
            return;
        }
        if (this.saldo >= valor) {
            this.saldo -= valor;
            System.out.printf(String.format("Saque de %.2f realizado com sucesso!\n", valor));
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

}
