
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ElectionProgram {

    /*
    Na contagem de votos de uma eleição, são gerados vários registros de votação contendo o nome do candidato e a quantidade de votos (formato .csv)
que ele obteve em uma urna de votação. Você deve fazer um programa para ler os registros de votação a partir de um arquivo,
 e daí gerar um relatório consolidado com os totais de cada candidato.
     */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file full path / Digite o nome do arquivo: ");
        String path = scanner.nextLine();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {

            Map<String, Integer> plateElection = new LinkedHashMap<>();

            String line = bufferedReader.readLine();                                                                    // Lê a primeira linha do arquivo
            while (line != null) {                                                                                      // Enquanto a linha não for nula
                String[] fields = line.split(",");                                                               // Separa os campos da linha com a vírgula
                String name = fields[0];                                                                                // Pega o primeiro campo (Nome do Candidato)
                int cont = Integer.parseInt(fields[1]);                                                             // Pega o segundo campo (Quantidade de Votos)

                if (plateElection.containsKey(name)) {                                                             // Se o nome do candidato já estiver no Map
                    int contVotos = plateElection.get(name);                                                            // Pega a quantidade de votos já registrados
                    plateElection.put(name, cont + contVotos);                                                          // Adiciona a quantidade de votos já registrados com a quantidade de votos do candidato
                } else {
                    plateElection.put(name, cont);                                                                      // Adiciona o candidato no Map
                }
                line = bufferedReader.readLine();                                                                       // Lê a próxima linha
            }

            for (String key : plateElection.keySet()) {                                                                 // Percorre o Map
                System.out.println(key + ": " + plateElection.get(key));                                                // Imprime o nome do candidato e a quantidade de votos
            }

            System.out.println();
        } catch (IOException err) {
            System.out.println("ERROR : " + err.getMessage());
        }

        scanner.close();

    }
    }

