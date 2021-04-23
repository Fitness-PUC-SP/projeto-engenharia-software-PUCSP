package br.edu.pucsp.virtualtrainer.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class CpfValidator implements ConstraintValidator<Cpf, Long> {

    private static final int[] weight = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (Objects.isNull(value)){
            return false;
        }

        return validateCpf(value);

    }
    private static boolean validateCpf(Long original) {
        String cpf = original.toString();

        if ((cpf.length()<11)){
            cpf = addZeros(cpf);
        }

        for (int i = 0; i < 10; i++)
            if (padLeft(Integer.toString(i), Character.forDigit(i, 10)).equals(cpf))
                return false;

        int digit1 = verifyDigit(cpf.substring(0,9));
        int digit2 = verifyDigit(cpf.substring(0,9) + digit1);
        return cpf.equals(cpf.substring(0,9) + digit1 + digit2);
    }

    private static String addZeros(String cpf) {
        StringBuilder temp = new StringBuilder(cpf);
        temp.reverse();
        int increment = 11 - cpf.length();
        for (int i = 0; i < increment; i++) {
            temp.append("0");
        }
        return temp.reverse().toString();
    }

    private static String padLeft(String text, char character) {
        return String.format("%11s", text).replace(' ', character);
    }

    private static int verifyDigit(String str) {
        int sum = 0;
        int digit;
        for (int index = str.length() - 1; index >= 0; index-- ) {
            digit = Integer.parseInt(str.substring(index,index+1));
            sum += digit*weight[weight.length-str.length()+index];
        }
        sum = 11 - sum % 11;
        return sum > 9 ? 0 : sum;
    }
}
