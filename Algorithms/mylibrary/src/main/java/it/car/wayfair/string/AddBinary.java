package it.car.wayfair.string;

/**
 * Created by ciriti on 22/09/16.
 */

public class AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder build = new StringBuilder();

        int ia = a.length()-1;
        int ib = b.length()-1;
        char carry = '0';
        while(ia >= 0 || ib >= 0){

            char ca = ia>=0?a.charAt(ia):'0';
            char cb = ib>=0?b.charAt(ib):'0';

            build.append(sum(ca, cb, carry));
            carry = carry(ca, cb, carry);

            ia--;
            ib--;
        }
        if(carry != '0')
            build.append(carry);

        return build.reverse().toString();
    }

    public char sum(char a, char b, char carry){
        char res = '0';
        switch (Character.getNumericValue(a) + Character.getNumericValue(b) + Character.getNumericValue(carry)){
            case 0:
                res = '0';
                break;
            case 1:
                res = '1';
                break;
            case 2:
                res = '0';
                break;
            case 3:
                res = '1';
                break;
        }
        return res;
    }

    public char carry(char a, char b, char carry){
        char res = '0';
        switch (Character.getNumericValue(a) + Character.getNumericValue(b) + Character.getNumericValue(carry)){
            case 0:
                res = '0';
                break;
            case 1:
                res = '0';
                break;
            case 2:
                res = '1';
                break;
            case 3:
                res = '1';
                break;
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(new AddBinary().addBinary("11","1").equals("100")?"SUCCESS":"ERROR");
        System.out.println(new AddBinary().addBinary("1","11").equals("100")?"SUCCESS":"ERROR");
    }

}
