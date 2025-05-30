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

    public void sacar (double valor) {
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

    public void depositar (double valor) {
        if (valor <= 0) {
            System.out.println("Valor de deposito deve ser positivo");
            return;
        }
        this.saldo += valor;
        System.out.printf(String.format("Deposito de %.2f realizado com sucesso!\n", valor));
    }

    public void transferir (double valor, IConta contaDestino) {
        if (valor <= 0) {
            System.out.println("Valor de transferencia deve ser positivo");
            return;
        }
        if (this.saldo >= valor) {
            this.sacar(valor);
            contaDestino.depositar(valor);
            System.out.printf(String.format("Transferencia de %.2f realizada com sucesso!\n", valor));
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    public void imprimirDados() {
        System.out.println(String.format("Agencia: %d\nNumero: %d\nSaldo: %.2f\nCliente: %s", this.agencia, this.numero, this.saldo, this.cliente));
    }

}
