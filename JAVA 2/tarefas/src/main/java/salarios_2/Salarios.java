package salarios_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Salarios {

    public static double calcularSalarioBruto(double valorHora, int horasTrabalhadas) {
        if (valorHora <= 0) {
            throw new IllegalArgumentException("Valor da hora não pode ser negativo ou zero.");
        }
        if (horasTrabalhadas < 0) {
            throw new IllegalArgumentException("Número de horas trabalhadas não pode ser negativo.");
        }
        return valorHora * horasTrabalhadas;
    }

    public static double calcularSalarioLiquido(double valorHora, int horasTrabalhadas, double inss) {
        if (inss < 0 || inss > 100) {
            throw new IllegalArgumentException("Percentual do INSS deve estar entre 0 e 100.");
        }
        double salarioBruto = calcularSalarioBruto(valorHora, horasTrabalhadas);
        double descontoInss = salarioBruto * (inss / 100);
        return salarioBruto - descontoInss;
    }

    public static void imprimirExtrato(double valorHora, int horasTrabalhadas, double salarioBruto, double salarioLiquido) {
        System.out.println("Extrato de salário");
        System.out.printf("Valor Hora: R$ %.2f\n", valorHora);
        System.out.printf("Horas trabalhadas: %d horas\n", horasTrabalhadas);
        System.out.printf("Salário Bruto: R$ %.2f\n", salarioBruto);
        System.out.printf("Salário Líquido: R$ %.2f\n", salarioLiquido);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        try {
            System.out.print("Digite o valor da hora: R$ ");
            double valorHora = scan.nextDouble();

            System.out.print("Digite o número de horas trabalhadas: ");
            int horasTrabalhadas = scan.nextInt();

            System.out.print("Digite o percentual do INSS (entre 0 e 100): ");
            double inss = scan.nextDouble();

            double salarioBruto = calcularSalarioBruto(valorHora, horasTrabalhadas);
            double salarioLiquido = calcularSalarioLiquido(valorHora, horasTrabalhadas, inss);

            imprimirExtrato(valorHora, horasTrabalhadas, salarioBruto, salarioLiquido);

        } catch (InputMismatchException e) {
            System.err.println("Erro: Entrada inválida. Digite números decimais para valor da hora e percentual do INSS, e números inteiros para horas trabalhadas.");
        } finally {
            scan.close(); // Close the scanner to avoid resource leaks
        }
    }
}