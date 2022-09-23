package com.github.sanchezih.calculadora.controller;

import com.github.sanchezih.calculadora.dto.response.CalculadoraResult;

import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.*;

import static com.github.sanchezih.calculadora.dto.response.CalculadoraResult.*;

@RestController
@RequestMapping("/api/basic")
public class CalculadoraAritmeticaController {

	@GetMapping("/sumar")
	@ApiOperation(value = "Suma", notes = "Suma 2 numeros enteros")
	public CalculadoraResult sumar(
			@RequestParam Integer operando1,
			@RequestParam Integer operando2) {

		return result(operando1 + operando2);
	}

	@GetMapping("/restar")
	@ApiOperation(value = "Resta", notes = "Resta 2 numeros enteros")
	public CalculadoraResult restar(
			@RequestParam Integer operando1,
			@RequestParam Integer operando2) {

		return result(operando1 - operando2);
	}

	@GetMapping("/multiplicar")
	@ApiOperation(value = "Multiplicacion", notes = "Multiplica 2 numeros enteros")
	public CalculadoraResult multiplicar(
			@RequestParam Integer operando1,
			@RequestParam Integer operando2) {

		return result(operando1 * operando2);
	}

	@GetMapping("/dividir")
	@ApiOperation(value = "Division", notes = "Divide 2 numeros enteros")
	public CalculadoraResult dividir(
			@RequestParam Integer dividendo,
			@RequestParam Integer divisor) {

		if (divisor == 0)
			return error("No es posible dividir por 0");

		return result((double) dividendo / divisor);
	}

}
