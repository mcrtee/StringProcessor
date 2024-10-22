package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class StringProcessor {
    // Method to check if the password is strong
    public boolean isStrongPassword(String password) {
        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isLowerCase(ch)) hasLower = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else if (!Character.isLetterOrDigit(ch)) hasSpecial = true;
        }
        return hasUpper && hasLower && hasDigit && hasSpecial;
    }

    // Method to count digits in a sentence
    public int calculateDigits(String sentence) {
        int count = 0;
        for (char ch : sentence.toCharArray()) {
            if (Character.isDigit(ch)) count++;
        }
        return count;
    }

    // Method to count words in a sentence
    public int calculateWords(String sentence) {
        if (sentence.trim().isEmpty()) return 0;
        String[] words = sentence.trim().split("\\s+");
        return words.length;
    }

    // Method to evaluate a mathematical expression in string form
    public double calculateExpression(String expression) {
        try {
            return (double) new javax.script.ScriptEngineManager().getEngineByName("JavaScript").eval(expression);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid expression");
        }
    }
}