package sdf;

import java.io.Console;

public class Main {

    public static void main(String args[]) {

        double lastResult = 0;
        System.out.println("Welcome. Input <quit> to exit program");
        System.out.println("Input Operand <space> Operator <space> Operand. Eg: 1 / 1\n");

        Console con = System.console();
        String input = con.readLine("> ");

        while (!input.equals("quit")) {
            if (input.toString() == "quit") {
                System.out.println("Exiting Program");
                break;
            } else {
                String[] data = input.split(" ");
                double result = 0;
                double num1 = 0.0;
                double num2 = 0.0;
                if((data.length<3)||(data.length>3)){
                    System.out.println("Input proper command");
                    System.out.println("Input Operand <space> Operator <space> Operand. Eg: 1 / 1\n");
                    input = con.readLine("> ");
                    continue;

                }
                String operator = data[1];

                if((data[0].equalsIgnoreCase("$last"))&&(data[2].equalsIgnoreCase("$last"))){
                    num1 = lastResult;
                    num2 = lastResult;

                }
                else if ((data[0].equalsIgnoreCase("$last"))) {
                    num1 = lastResult;
                    num2 = Double.parseDouble(data[2]);
                }
                else if ((data[2].equalsIgnoreCase("$last"))) {
                    num2 = lastResult;
                    num1 = Double.parseDouble(data[0]);
                }
                 else {
                    num1 = Double.parseDouble(data[0]);
                    num2 = Double.parseDouble(data[2]);
                }

                if (operator.equals("+")) {
                    result = num1 + num2;
                } else if (operator.equals("-")) {
                    result = num1 - num2;
                } else if (operator.equals("/")) {
                    result = num1 / num2;
                } else if (operator.equals("*")) {
                    result = num1 * num2;
                } else
                    System.err.println("Operator error!");
                lastResult = result;
                System.out.println(result);
                input = con.readLine("> ");

            }
        }
    }
}