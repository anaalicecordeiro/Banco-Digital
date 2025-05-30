

public class Main {

    public static void main(String[] args) {
        // 1. Criar o Banco
        Banco meuBanco = new Banco("Banco Digital Inovador");
        System.out.println("Bem-vindo ao " + meuBanco.getNome() + "!");

        // 2. Criar Clientes
        Cliente clienteJoao = new Cliente("João Silva");
        Cliente clienteMaria = new Cliente("Maria Souza");

        System.out.println("\nClientes criados:");
        System.out.println(clienteJoao);
        System.out.println(clienteMaria);

        // 3. Criar Contas para os Clientes
        System.out.println("\nCriando contas...");
        // Para João: uma conta corrente e uma poupança
        Conta ccJoao = new ContaCorrente(clienteJoao);
        Conta cpJoao = new ContaPoupanca(clienteJoao);

        // Para Maria: uma conta corrente
        Conta ccMaria = new ContaCorrente(clienteMaria);

        // 4. Adicionar contas ao banco
        meuBanco.adicionarConta(ccJoao);
        meuBanco.adicionarConta(cpJoao);
        meuBanco.adicionarConta(ccMaria);

        // Listar contas do banco
        meuBanco.listarContas();

        // 5. Realizar Operações
        System.out.println("\nRealizando operações...");

        // Depósitos
        System.out.println("\n--- Depósitos ---");
        ccJoao.depositar(1000.50);
        cpJoao.depositar(5000.75);
        ccMaria.depositar(2500.00);

        // Saques
        System.out.println("\n--- Saques ---");
        ccJoao.sacar(200.00);
        cpJoao.sacar(10000.00); // Tentativa de saque maior que o saldo
        ccMaria.sacar(150.00);

        // Transferências
        System.out.println("\n--- Transferências ---");
        // João transfere da sua CC para sua CP
        ccJoao.transferir(300.00, (IConta) cpJoao);
        // Maria transfere da sua CC para a CC de João
        ccMaria.transferir(500.00, (IConta) ccJoao);
        // João tenta transferir da sua CC para Maria valor maior que saldo
        ccJoao.transferir(5000.00, (IConta) ccMaria);


        // 6. Imprimir Extratos
        System.out.println("\n--- Extratos Finais ---");
        ccJoao.imprimirDados();
        cpJoao.imprimirDados();
        ccMaria.imprimirDados();

        // Listar contas do banco novamente para ver saldos atualizados
        meuBanco.listarContas();

        System.out.println("\nObrigado por usar o " + meuBanco.getNome() + "!");
    }
}