using System;

namespace CalculatorApp
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Welcome to the Calculator!");
            Console.WriteLine("Available operations: +, -, *, /");
            
            while (true)
            {
                Console.Write("Enter an expression (e.g., 2 + 2): ");
                string input = Console.ReadLine();
                
                if (input.ToLower() == "exit")
                {
                    break;
                }
                
                try
                {
                    double result = EvaluateExpression(input);
                    Console.WriteLine($"Result: {result}");
                }
                catch (Exception ex)
                {
                    Console.WriteLine($"Error: {ex.Message}");
                }
            }
            
            Console.WriteLine("Calculator closed.");
        }

        static double EvaluateExpression(string input)
        {
            string[] tokens = input.Split(' ');

            if (tokens.Length != 3)
            {
                throw new InvalidOperationException("Invalid expression format.");
            }

            double num1 = double.Parse(tokens[0]);
            double num2 = double.Parse(tokens[2]);

            switch (tokens[1])
            {
                case "+":
                    return num1 + num2;
                case "-":
                    return num1 - num2;
                case "*":
                    return num1 * num2;
                case "/":
                    if (num2 != 0)
                    {
                        return num1 / num2;
                    }
                    else
                    {
                        throw new DivideByZeroException("Division by zero is not allowed.");
                    }
                default:
                    throw new InvalidOperationException("Invalid operator.");
            }
        }
    }
}
