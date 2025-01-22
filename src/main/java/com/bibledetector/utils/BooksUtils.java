package com.bibledetector.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BooksUtils {

    public static String extractBibleBookFromText(String text) {
        if (text == null) return null;

        text = text.toLowerCase();

        List<String> books = bibleBooks();
        Collections.reverse(books);
        for (String book : books) {
            if (text.contains(book)) {
                return book;
            }
        }
        return "";
    }

    public static List<Integer> extractNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        StringBuilder currentNumber = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                currentNumber.append(c);
            } else if (!currentNumber.isEmpty()) {
                numbers.add(Integer.parseInt(currentNumber.toString()));
                currentNumber.setLength(0);
            }
        }

        // Add the last number if there is one
        if (!currentNumber.isEmpty()) {
            numbers.add(Integer.parseInt(currentNumber.toString()));
        }

        return numbers;
    }

    public static List<String> bibleBooks() {
        List<String> bibleBooks = new ArrayList<>();

        // Antiguo Testamento
        bibleBooks.add("génesis");
        bibleBooks.add("éxodo");
        bibleBooks.add("levítico");
        bibleBooks.add("números");
        bibleBooks.add("deuteronomio");
        bibleBooks.add("josué");
        bibleBooks.add("jueces");
        bibleBooks.add("rut");
        bibleBooks.add("1 samuel");
        bibleBooks.add("2 samuel");
        bibleBooks.add("1 reyes");
        bibleBooks.add("2 reyes");
        bibleBooks.add("1 crónicas");
        bibleBooks.add("2 crónicas");
        bibleBooks.add("esdras");
        bibleBooks.add("nehemías");
        bibleBooks.add("ester");
        bibleBooks.add("job");
        bibleBooks.add("salmos");
        bibleBooks.add("proverbios");
        bibleBooks.add("eclesiastés");
        bibleBooks.add("cantares");
        bibleBooks.add("isaías");
        bibleBooks.add("jeremías");
        bibleBooks.add("lamentaciones");
        bibleBooks.add("ezequiel");
        bibleBooks.add("daniel");
        bibleBooks.add("oseas");
        bibleBooks.add("joel");
        bibleBooks.add("amos");
        bibleBooks.add("abdías");
        bibleBooks.add("jonás");
        bibleBooks.add("miqueas");
        bibleBooks.add("nahúm");
        bibleBooks.add("habacuc");
        bibleBooks.add("sofonías");
        bibleBooks.add("hageo");
        bibleBooks.add("zacarías");
        bibleBooks.add("malaquías");

        // Nuevo Testamento
        bibleBooks.add("mateo");
        bibleBooks.add("marcos");
        bibleBooks.add("lucas");
        bibleBooks.add("juan");
        bibleBooks.add("hechos");
        bibleBooks.add("romanos");
        bibleBooks.add("1 corintios");
        bibleBooks.add("2 corintios");
        bibleBooks.add("gálatas");
        bibleBooks.add("efesios");
        bibleBooks.add("filipenses");
        bibleBooks.add("colosenses");
        bibleBooks.add("1 tesalonicenses");
        bibleBooks.add("2 tesalonicenses");
        bibleBooks.add("1 timoteo");
        bibleBooks.add("2 timoteo");
        bibleBooks.add("tito");
        bibleBooks.add("filemón");
        bibleBooks.add("hebreos");
        bibleBooks.add("santiago");
        bibleBooks.add("1 pedro");
        bibleBooks.add("2 pedro");
        bibleBooks.add("1 juan");
        bibleBooks.add("2 juan");
        bibleBooks.add("3 juan");
        bibleBooks.add("judas");
        bibleBooks.add("apocalipsis");

        return bibleBooks;
    }

    public static String extractChapter(String text) {
        text = StringUtils.remove(text, extractBibleBookFromText(text));

        List<Integer> numbersInText = extractNumbers(text);
        if (numbersInText.isEmpty()) return "";

        return numbersInText.get(0).toString();
    }

    public static String extractVerse(String text) {
        text = StringUtils.remove(text, extractBibleBookFromText(text));
        List<Integer> numbersInText = extractNumbers(text);

        if (numbersInText.isEmpty()) return "";
        if (numbersInText.size() == 1) return "";
        if (numbersInText.size() == 2) return numbersInText.get(1).toString();
        return numbersInText.get(1).toString() + "-" + numbersInText.get(2).toString();
    }
}
