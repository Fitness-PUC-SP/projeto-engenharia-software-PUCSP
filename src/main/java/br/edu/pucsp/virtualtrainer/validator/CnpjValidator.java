package br.edu.pucsp.virtualtrainer.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class CnpjValidator implements ConstraintValidator<Cnpj, Long> {

    private static final int[] weight = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (Objects.isNull(value)){
            return false;
        }

        return validateCnpj(value);

    }
    private static boolean validateCnpj(Long original) {
        String cnpj = original.toString();

        if ((cnpj.length()<14)){
            cnpj = addZeros(cnpj);
        }

        int digit1 = verifyDigit(cnpj.substring(0,12));
        int digit2 = verifyDigit(cnpj.substring(0,12) + digit1);
        return cnpj.equals(cnpj.substring(0,12) + digit1 + digit2);
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

    private static String addZeros(String cpf) {
        StringBuilder temp = new StringBuilder(cpf);
        temp.reverse();
        int increment = 14 - cpf.length();
        for (int i = 0; i < increment; i++) {
            temp.append("0");
        }
        return temp.reverse().toString();
    }
}
