/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author williamscott
 */
class Stack {

    double a[];
    int pointer = 0;

    Stack(int size) {
        a = new double[size];
    }

    void push(double var) {
        System.out.println("pushing " + var);
        a[pointer++] = var;
    }

    double pop() {
        double temp = a[pointer - 1];
        System.out.println("popping " + temp);
        pointer--;
        return temp;
    }

    double top() {
        return a[--pointer];
    }
}

public class EvaluatePostfix {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String input = in.nextLine();

        String inputArray[] = input.split(" ");

        double x, y;

        //Stack size depends on the size of the array, but not necessarily dymanic as the input is completely feeded to the program first
        Stack stack = new Stack(inputArray.length);
        try {
            for (String i : inputArray) {
                if (i.equals("/")) {
                    x = stack.pop();
                    y = stack.pop();
                    stack.push(y / x);
                } else if (i.equals("*")) {
                    x = stack.pop();
                    y = stack.pop();
                    stack.push(y * x);
                } else if (i.equals("+")) {
                    x = stack.pop();
                    y = stack.pop();
                    stack.push(y + x);
                } else if (i.equals("-")) {
                    x = stack.pop();
                    y = stack.pop();
                    stack.push(y - x);
                } else 
                    stack.push(Integer.parseInt(i));
            }
            System.out.println("Result of Postfix expression: " + stack.top());

        } catch (NumberFormatException e) {
            System.out.println("Input Error, Only Numericals and +-/* are allowed");
        }

    }

}
