//define o contrato basico para todas as contas

public interface IConta {

    void sacar(double valor);
    void depositar(double valor);
    void transferir(double valor, IConta contaDestino);
    void imprimirExtrato();

}
