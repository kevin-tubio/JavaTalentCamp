package com.github.sanchezih.calculadora.controller;

import com.github.sanchezih.calculadora.dto.response.CalculadoraResult;

import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.github.sanchezih.calculadora.dto.response.CalculadoraResult.*;

@RestController
@RequestMapping("/api/scientific")
public class CalculadoraCientificaController {

    @GetMapping("/cuadrado/{numero}")
    @ApiOperation(value = "Cuadrado", notes = "Calcula el cuadrado de un entero")
    public CalculadoraResult cuadrado(@PathVariable Integer numero) {
        return result(numero * numero);
    }

    @GetMapping("/factorial/{numero}")
    @ApiOperation(value = "Factorial", notes = "Calcula el factorial de un entero")
    public CalculadoraResult factorial(@PathVariable Integer numero) {

        if (numero < 0)
            return error("Factorial solo es posible para numeros positivos");

        int factorial = 1;
        for (int i = 1; i <= numero; i++) {
            factorial *= i;
        }

        return result(factorial);
    }

    @GetMapping("/primo/{numero}")
    @ApiOperation(value = "Es Primo", notes = "Verifica si un entero es numero primo")
    public CalculadoraResult primo(@PathVariable Integer numero) {

        if (numero % 2 == 0)
            return result(false);

        int i = 3;
        while (i * i <= Math.sqrt(numero)) {
            if (numero % i == 0)
                return result(false);
            i += 2;
        }

        return result(true);
    }

}
