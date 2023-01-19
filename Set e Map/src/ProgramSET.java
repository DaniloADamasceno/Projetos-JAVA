package exerciciosPropostos;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ProgramSET {

    public static void main(String[] args) {

        /*
        Em um portal de cursos ‘online’, cada usuario possui um código unico, representado por um número inteiro.

        Cada instrutor do portal pode ter varios cursos, sendo que um mesmo aluno pode se matricular em quantos cursos quiser.
Assim, o número total de alunos de um instrutor não é simplesmente a soma dos alunos de todos os cursos que ele possui,
pois, pode haver alunos repetidos em mais de um curso.
O instrutor Alex possui três cursos A, B e C, e deseja saber seu número total de alunos.
Seu programa deve ler os alunos dos cursos A, B e C do instrutor Alex, depois mostrar a quantidade total e alunos dele, conforme exemplo.

Curso A:    (3 Alunos)       |         Curso B:   (2 Alunos)        |          Curso C:   (3 Alunos)
         Snow  Nº- 21        |                Snow  Nº- 21          |                 Snoopy  Nº- 42                   |
         Nina  Nº- 35        |                Malu  Nº- 50          |                 Nina  Nº- 35                     |
         Frederico  Nº- 22   |                                      |                 Maggie  Nº- 13                   |
|----------------------------|--------------------------------------|--------------------------------------------------|
         */

        Scanner scan = new Scanner(System.in);

        Set<Integer> cursoA = new HashSet<>();
        Set<Integer> cursoB = new HashSet<>();
        Set<Integer> cursoC = new HashSet<>();

        System.out.print("How many students for course A? / Quantos alunos para o curso A? ");
        int nStudent = scan.nextInt();
        for (int i = 0; i < nStudent; i++) {
            int student = scan.nextInt();
            cursoA.add(student);
        }

        System.out.print("How many students for course B? / Quantos alunos para o curso B? ");
        nStudent = scan.nextInt();
        for (int i = 0; i < nStudent; i++) {
            int student = scan.nextInt();
            cursoB.add(student);
        }

        System.out.print("How many students for course C? / Quantos alunos para o curso C? ");
        nStudent = scan.nextInt();
        for (int i = 0; i < nStudent; i++) {
            int student = scan.nextInt();
            cursoC.add(student);
        }

        Set<Integer> total = new HashSet<>(cursoA);
        total.addAll(cursoB);
        total.addAll(cursoC);

        System.out.println("Total students: " + total.size());
        System.out.println();
        scan.close();




    }
}
