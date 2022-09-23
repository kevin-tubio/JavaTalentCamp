package com.github.sanchezih.calculadora.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.RoundingMode;
import java.text.DecimalFormat;

@Data
@AllArgsConstructor
public class CalculadoraResult {

    private String error;
    private String result;

    public static CalculadoraResult result(int result) {
        return new CalculadoraResult("", String.valueOf(result));
    }

    public static CalculadoraResult result(boolean result) {
        return new CalculadoraResult("", String.valueOf(result));
    }

    public static CalculadoraResult result(double result) {
        DecimalFormat formatter = new DecimalFormat("###,###.####");
        formatter.setRoundingMode(RoundingMode.CEILING);
        return new CalculadoraResult("", formatter.format(result));
    }

    public static CalculadoraResult error(String error) {
        return new CalculadoraResult(error, "");
    }

}
