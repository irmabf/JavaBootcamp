package bootcamp.app;

import bootcamp.data.Params;
import bootcamp.data.Result;
import bootcamp.process.calculator.Calculator;
import bootcamp.process.element.impl.ElementFactoryImpl;

import java.math.BigDecimal;
import java.util.Scanner;

public class CalculatorApp {

    public static void main (String[] args){
        System.out.println("Enter a calculation:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] splitInput = input.split(" ");

        BigDecimal x = new BigDecimal(splitInput[0]);
        BigDecimal y = new BigDecimal(splitInput[2]);
        Params params = new Params(x, y, splitInput[1]);

        Calculator calculator = new Calculator(new ElementFactoryImpl());
        Result result = calculator.calculate(params);
        if(result.getValue().isEmpty()){
            System.out.println(result.getMessage());
        } else {
            System.out.println(params.toString() + result.toString());
        }
    }

}