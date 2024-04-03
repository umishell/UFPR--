package salarios;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalariosTest {

    @Test
    void calcularSalarioBrutoValido() {
        double valorHora = 10.50;
        int horasTrabalhadas = 180;
        double salarioBrutoEsperado = 1890.00;

        double salarioBrutoCalculado = Salarios.calcularSalarioBruto(valorHora, horasTrabalhadas);

        assertEquals(salarioBrutoEsperado, salarioBrutoCalculado, 0.01);
    }

    @Test
    void calcularSalarioLiquidoValido() {
        double valorHora = 12.00;
        int horasTrabalhadas = 200;
        double inss = 8.0;
        double salarioLiquidoEsperado = 2256.00;

        double salarioLiquidoCalculado = Salarios.calcularSalarioLiquido(valorHora, horasTrabalhadas, inss);

        assertEquals(salarioLiquidoEsperado, salarioLiquidoCalculado, 0.01);
    }

    @Test
    void calcularSalarioBrutoValorHoraInvalido() {
        assertThrows(IllegalArgumentException.class, () -> Salarios.calcularSalarioBruto(-1.0, 180));
    }

    @Test
    void calcularSalarioBrutoHorasTrabalhadasInvalidas() {
        assertThrows(IllegalArgumentException.class, () -> Salarios.calcularSalarioBruto(10.50, -5));
    }

    @Test
    void calcularSalarioLiquidoInssInvalido() {
        assertThrows(IllegalArgumentException.class, () -> Salarios.calcularSalarioLiquido(12.00, 200, -1.0));
    }
}