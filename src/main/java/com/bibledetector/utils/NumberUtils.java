package com.bibledetector.utils;

import java.util.*;

public class NumberUtils {

    public static String convertAllNumbersToDigits(String text) {
        if (text == null) return "";
        text = text.toLowerCase();

        ArrayList<Map.Entry<String, String>> entryList = new java.util.ArrayList<>(numbersDictionary().entrySet().stream().toList());
        Collections.reverse(entryList);

        for (Map.Entry<String, String> number : entryList) {
            text = replaceForDigits(text, number);
        }
        return text;
    }

    private static String replaceForDigits(String text, Map.Entry<String, String> number) {
        return text.replace(number.getKey(), number.getValue());
    }

    public static String textNumberToDigits(String textNumber) {
        if (textNumber == null) return "";
        if (numbersDictionary().containsKey(textNumber.toLowerCase())) {
            return numbersDictionary().get(textNumber);
        }
        return "";
    }

    public static HashMap<String, String> numbersDictionary() {
        LinkedHashMap<String, String> numbersDictionary = new LinkedHashMap<>();

        // Agregar números al HashMap
        numbersDictionary.put("uno", "1");
        numbersDictionary.put("dos", "2");
        numbersDictionary.put("tres", "3");
        numbersDictionary.put("cuatro", "4");
        numbersDictionary.put("cinco", "5");
        numbersDictionary.put("seis", "6");
        numbersDictionary.put("siete", "7");
        numbersDictionary.put("ocho", "8");
        numbersDictionary.put("nueve", "9");
        numbersDictionary.put("diez", "10");
        numbersDictionary.put("once", "11");
        numbersDictionary.put("doce", "12");
        numbersDictionary.put("trece", "13");
        numbersDictionary.put("catorce", "14");
        numbersDictionary.put("quince", "15");
        numbersDictionary.put("dieciséis", "16");
        numbersDictionary.put("dieciseis", "16");
        numbersDictionary.put("diecisiete", "17");
        numbersDictionary.put("dieciocho", "18");
        numbersDictionary.put("diecinueve", "19");
        numbersDictionary.put("veinte", "20");
        numbersDictionary.put("veintiuno", "21");
        numbersDictionary.put("veintidós", "22");
        numbersDictionary.put("veintitrés", "23");
        numbersDictionary.put("veinticuatro", "24");
        numbersDictionary.put("veinticinco", "25");
        numbersDictionary.put("veintiseis", "26");
        numbersDictionary.put("veintiséis", "26");
        numbersDictionary.put("veintisiete", "27");
        numbersDictionary.put("veintiocho", "28");
        numbersDictionary.put("veintinueve", "29");
        numbersDictionary.put("treinta", "30");
        numbersDictionary.put("treinta y uno", "31");
        numbersDictionary.put("treinta y dos", "32");
        numbersDictionary.put("treinta y tres", "33");
        numbersDictionary.put("treinta y cuatro", "34");
        numbersDictionary.put("treinta y cinco", "35");
        numbersDictionary.put("treinta y seis", "36");
        numbersDictionary.put("treinta y siete", "37");
        numbersDictionary.put("treinta y ocho", "38");
        numbersDictionary.put("treinta y nueve", "39");
        numbersDictionary.put("cuarenta", "40");
        numbersDictionary.put("cuarenta y uno", "41");
        numbersDictionary.put("cuarenta y dos", "42");
        numbersDictionary.put("cuarenta y tres", "43");
        numbersDictionary.put("cuarenta y cuatro", "44");
        numbersDictionary.put("cuarenta y cinco", "45");
        numbersDictionary.put("cuarenta y seis", "46");
        numbersDictionary.put("cuarenta y siete", "47");
        numbersDictionary.put("cuarenta y ocho", "48");
        numbersDictionary.put("cuarenta y nueve", "49");
        numbersDictionary.put("cincuenta", "50");
        numbersDictionary.put("cincuenta y uno", "51");
        numbersDictionary.put("cincuenta y dos", "52");
        numbersDictionary.put("cincuenta y tres", "53");
        numbersDictionary.put("cincuenta y cuatro", "54");
        numbersDictionary.put("cincuenta y cinco", "55");
        numbersDictionary.put("cincuenta y seis", "56");
        numbersDictionary.put("cincuenta y siete", "57");
        numbersDictionary.put("cincuenta y ocho", "58");
        numbersDictionary.put("cincuenta y nueve", "59");
        numbersDictionary.put("sesenta", "60");
        numbersDictionary.put("sesenta y uno", "61");
        numbersDictionary.put("sesenta y dos", "62");
        numbersDictionary.put("sesenta y tres", "63");
        numbersDictionary.put("sesenta y cuatro", "64");
        numbersDictionary.put("sesenta y cinco", "65");
        numbersDictionary.put("sesenta y seis", "66");
        numbersDictionary.put("sesenta y siete", "67");
        numbersDictionary.put("sesenta y ocho", "68");
        numbersDictionary.put("sesenta y nueve", "69");
        numbersDictionary.put("setenta", "70");
        numbersDictionary.put("setenta y uno", "71");
        numbersDictionary.put("setenta y dos", "72");
        numbersDictionary.put("setenta y tres", "73");
        numbersDictionary.put("setenta y cuatro", "74");
        numbersDictionary.put("setenta y cinco", "75");
        numbersDictionary.put("setenta y seis", "76");
        numbersDictionary.put("setenta y siete", "77");
        numbersDictionary.put("setenta y ocho", "78");
        numbersDictionary.put("setenta y nueve", "79");
        numbersDictionary.put("ochenta", "80");
        numbersDictionary.put("ochenta y uno", "81");
        numbersDictionary.put("ochenta y dos", "82");
        numbersDictionary.put("ochenta y tres", "83");
        numbersDictionary.put("ochenta y cuatro", "84");
        numbersDictionary.put("ochenta y cinco", "85");
        numbersDictionary.put("ochenta y seis", "86");
        numbersDictionary.put("ochenta y siete", "87");
        numbersDictionary.put("ochenta y ocho", "88");
        numbersDictionary.put("ochenta y nueve", "89");
        numbersDictionary.put("noventa", "90");
        numbersDictionary.put("noventa y uno", "91");
        numbersDictionary.put("noventa y dos", "92");
        numbersDictionary.put("noventa y tres", "93");
        numbersDictionary.put("noventa y cuatro", "94");
        numbersDictionary.put("noventa y cinco", "95");
        numbersDictionary.put("noventa y seis", "96");
        numbersDictionary.put("noventa y siete", "97");
        numbersDictionary.put("noventa y ocho", "98");
        numbersDictionary.put("noventa y nueve", "99");
        numbersDictionary.put("cien", "100");
        numbersDictionary.put("ciento uno", "101");
        numbersDictionary.put("ciento dos", "102");
        numbersDictionary.put("ciento tres", "103");
        numbersDictionary.put("ciento cuatro", "104");
        numbersDictionary.put("ciento cinco", "105");
        numbersDictionary.put("ciento seis", "106");
        numbersDictionary.put("ciento siete", "107");
        numbersDictionary.put("ciento ocho", "108");
        numbersDictionary.put("ciento nueve", "109");
        numbersDictionary.put("ciento diez", "110");
        numbersDictionary.put("ciento once", "111");
        numbersDictionary.put("ciento doce", "112");
        numbersDictionary.put("ciento trece", "113");
        numbersDictionary.put("ciento catorce", "114");
        numbersDictionary.put("ciento quince", "115");
        numbersDictionary.put("ciento dieciséis", "116");
        numbersDictionary.put("ciento diecisiete", "117");
        numbersDictionary.put("ciento dieciocho", "118");
        numbersDictionary.put("ciento diecinueve", "119");
        numbersDictionary.put("ciento veinte", "120");
        numbersDictionary.put("ciento veintiuno", "121");
        numbersDictionary.put("ciento veintidós", "122");
        numbersDictionary.put("ciento veintitrés", "123");
        numbersDictionary.put("ciento veinticuatro", "124");
        numbersDictionary.put("ciento veinticinco", "125");
        numbersDictionary.put("ciento veintiséis", "126");
        numbersDictionary.put("ciento veintisiete", "127");
        numbersDictionary.put("ciento veintiocho", "128");
        numbersDictionary.put("ciento veintinueve", "129");
        numbersDictionary.put("ciento treinta", "130");
        numbersDictionary.put("ciento treinta y uno", "131");
        numbersDictionary.put("ciento treinta y dos", "132");
        numbersDictionary.put("ciento treinta y tres", "133");
        numbersDictionary.put("ciento treinta y cuatro", "134");
        numbersDictionary.put("ciento treinta y cinco", "135");
        numbersDictionary.put("ciento treinta y seis", "136");
        numbersDictionary.put("ciento treinta y siete", "137");
        numbersDictionary.put("ciento treinta y ocho", "138");
        numbersDictionary.put("ciento treinta y nueve", "139");
        numbersDictionary.put("ciento cuarenta", "140");
        numbersDictionary.put("ciento cuarenta y uno", "141");
        numbersDictionary.put("ciento cuarenta y dos", "142");
        numbersDictionary.put("ciento cuarenta y tres", "143");
        numbersDictionary.put("ciento cuarenta y cuatro", "144");
        numbersDictionary.put("ciento cuarenta y cinco", "145");
        numbersDictionary.put("ciento cuarenta y seis", "146");
        numbersDictionary.put("ciento cuarenta y siete", "147");
        numbersDictionary.put("ciento cuarenta y ocho", "148");
        numbersDictionary.put("ciento cuarenta y nueve", "149");
        numbersDictionary.put("ciento cincuenta", "150");
        numbersDictionary.put("primera de", "1");
        numbersDictionary.put("segunda de", "2");
        numbersDictionary.put("tercera de", "3");

        return numbersDictionary;
    }
}
