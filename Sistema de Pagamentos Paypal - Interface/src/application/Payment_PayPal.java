package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Parcelas;
import service.ContractService;
//import service.Online_Payment_Service;
import service.Paypal_Service;

public class Payment_PayPal{

  public static void main(String[] args) throws ParseException {
    /*
            Uma empresa deseja automatizar o processamento de seus contratos. 
        O processamento de um contrato consiste em gerar as parcelas a serem pagas para aquele contrato, com base no número
         de meses desejado.
        
            A empresa utiliza um serviço de pagamento online para realizar o pagamento das parcelas.
        Os serviços de pagamento online tipicamente cobram um juro mensal, bem como uma taxa por pagamento.
        Por enquanto, o serviço contratado pela empresa é o do Paypal, que aplica
        juros simples de 1% a cada parcela, mais uma taxa de pagamento de 2%.
        
            Fazer um programa para ler os dados de um contrato (número do contrato, data do contrato,
        e valor total do contrato). Em seguida, o programa deve ler o número de meses para
        parcelamento do contrato, e daí gerar os registros de parcelas a serem pagas (data e valor),
        sendo a primeira parcela a ser paga um mês após a data do contrato, a segunda parcela dois
        meses após o contrato e assim por diante. Mostrar os dados das parcelas na tela
        
        Cálculos (1% de juros simples mensais + 2% de taxa de pagamento):
        
            Quota #1:                           Quota #2:                                 Quota #3:  
        200 + 1% * 1 = 202                  200 + 1% * 2 = 204                      200 + 1% * 3 = 206
        202 + 2% = 206.04                   204 + 2% = 208.08                       206 + 2% = 210.12
    
         */

    Locale.setDefault(Locale.US);
    Scanner scan = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // formato da data que será lida

    System.out.println(
      " ---------- >>>>>     Sistema de Pagamentos    <<<<< ---------- "
    );
    System.out.println(); //quebra de linha

    //%%---------->>> Número do Contrato
    System.out.println(
      "Entre com os dados do contrato: || Enter Contract Data: "
    );
    System.out.print("Número do contrato: || Contract Number: ");
    int numberContract = scan.nextInt();
    System.out.println(); //quebra de linha

    //%%---------->>> Data do Contrato
    System.out.print("Data do contrato: || Contract Date: ");
    Date contractDate = sdf.parse(scan.next());
    System.out.println(); //quebra de linha

    //%%---------->>> Valor do contrato
    System.out.print(
      "Valor total do contrato: || Total value of the contract: "
    );
    double totalValueContract = scan.nextDouble();
    System.out.println(); //quebra de linha

    //%%---------->>> Número de parcelas
    System.out.print(
      "Entre com o número de parcelas: || Enter the number of installments: "
    );
    int numberParcelas = scan.nextInt();
    System.out.println(); //quebra de linha

    Contract contract = new Contract (
      numberContract,
      contractDate,
      totalValueContract
    );

    //%%---------->>> Instanciando o objeto
      ContractService contractService = new ContractService(
        new Paypal_Service()
      );

      contractService.processContract(contract, numberParcelas);

System.out.println("Parcelas: || Installments: ");
      for(Parcelas parcelasExibir : contract.getParcelas()) {
        System.out.println(parcelasExibir);
      }

    scan.close();
  }
}
