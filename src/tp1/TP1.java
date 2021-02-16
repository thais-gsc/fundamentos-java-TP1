package tp1;

import java.util.Scanner;

public class TP1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] nomes = new String[100];

        float[] notaAV1 = new float[100];

        float[] notaAV2 = new float[100];

        int opcao = 0;

        int i = 0;

        while (opcao != 4) {
            System.out.println("Escolha a opção desejada: \n[1] Registrar as notas de um novo aluno.\n"
                    + "[2] Consultar boletim de um aluno.\n"
                    + "[3] Consultar notas da turma.\n"
                    + "[4] Sair.");

            opcao = scan.nextInt();

            if (opcao == 1) {
                if (nomes.length <= 100) {
                    System.out.println("Informe o nome do aluno.");

                    nomes[i] = scan.next();

                    System.out.println("Informe a nota da AV1.");

                    notaAV1[i] = scan.nextFloat();

                    System.out.println("Informe a nota da AV2.");

                    notaAV2[i] = scan.nextFloat();

                    System.out.println("Registro de código " + i + " realizado com sucesso.\n");

                    i++;

                    // System.out.printf("Aluno %s. Nota 1: %.1f. Nota 2: %.1f", nomes[0], notaAV1[0], notaAV2[0]);
                } else {
                    System.out.println("Limite de alunos excedido. Impossível inserir novo registro.\n");
                }
            } else if (opcao == 2) {
                System.out.println("Informe o código de registro do aluno a ser consultado.");

                int codigo = scan.nextInt();

                float media = (notaAV1[codigo] + notaAV2[codigo]) / 2;

                String situacao;

                if (media < 4) {
                    situacao = "REPROVADO\n";
                } else if (media >= 4 && media < 7) {
                    situacao = "PROVA FINAL\n";
                } else {
                    situacao = "APROVADO\n";
                }

                if (nomes[codigo] == null) {
                    System.out.println("Não existe aluno com este código.\n");
                } else {
                    System.out.printf("Nome: %s\n Nota da AV1: %.1f\n Nota da AV2: %.1f\n Média final: %.1f\n Situação: %s\n",
                            nomes[codigo],
                            notaAV1[codigo],
                            notaAV2[codigo],
                            media,
                            situacao);
                }

            } else if (opcao == 3) {
                for (int j = 0; j < i; j++) {
                    System.out.println("Nome: " + nomes[j] + "\nNota da AV1: " + notaAV1[j] + "\nNota da AV2: " + notaAV2[j] + "\n");
                }
            } else if (opcao == 4) {
                System.out.println("Obrigada por utilizar nosso programa.");
            } else {
                System.out.println("Favor escolher uma opção válida.\n");
            }
        }

        scan.close();
    }

}
