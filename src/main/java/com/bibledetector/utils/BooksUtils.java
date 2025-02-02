package com.bibledetector.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class BooksUtils {

    public static String extractBibleBookFromText(String text) {
        if (text == null) return null;

        text = text.toLowerCase();

        ArrayList<String> possibleKeys = possibleKeys();
        for (String bookKey : possibleKeys) {
            if (text.contains(bookKey)) {
                return booksMap().get(bookKey);
            }
        }
        return "";
    }

    public static String extractBookKeyFromText(String text) {
        if (text == null) return null;

        text = text.toLowerCase();

        ArrayList<String> possibleKeys = possibleKeys();
        for (String bookKey : possibleKeys) {
            if (text.contains(bookKey)) {
                return bookKey;
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
        bibleBooks.add("amós");
        bibleBooks.add("abdías");
        bibleBooks.add("jonás");
        bibleBooks.add("miqueas");
        bibleBooks.add("nahum");
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

    public static LinkedHashMap<String, String> booksMap() {
        LinkedHashMap<String, String> bibleBooks = new LinkedHashMap<>();

        // Libros del Antiguo Testamento
        bibleBooks.put("génesis", "Génesis");
        bibleBooks.put("éxodo", "Éxodo");
        bibleBooks.put("levítico", "Levítico");
        bibleBooks.put("números", "Números");
        bibleBooks.put("deuteronomio", "Deuteronomio");
        bibleBooks.put("josué", "Josué");
        bibleBooks.put("jueces", "Jueces");
        bibleBooks.put("rut", "Rut");
        bibleBooks.put("1 samuel", "1 Samuel");
        bibleBooks.put("2 samuel", "2 Samuel");
        bibleBooks.put("1 reyes", "1 Reyes");
        bibleBooks.put("1 redes", "1 Reyes");
        bibleBooks.put("1 reses", "1 Reyes");
        bibleBooks.put("2 reyes", "2 Reyes");
        bibleBooks.put("2 redes", "2 Reyes");
        bibleBooks.put("2 reses", "2 Reyes");
        bibleBooks.put("1 crónicas", "1 Crónicas");
        bibleBooks.put("2 crónicas", "2 Crónicas");
        bibleBooks.put("esdras", "Esdras");
        bibleBooks.put("nehemías", "Nehemías");
        bibleBooks.put("ester", "Ester");
        bibleBooks.put("job", "Job");
        bibleBooks.put("salmo", "Salmos");
        bibleBooks.put("salmos", "Salmos");
        bibleBooks.put("proverbios", "Proverbios");
        bibleBooks.put("eclesiastés", "Eclesiastés");
        bibleBooks.put("cantares", "Cantares");
        bibleBooks.put("isaías", "Isaías");
        bibleBooks.put("jeremías", "Jeremías");
        bibleBooks.put("lamentaciones", "Lamentaciones");
        bibleBooks.put("ezequiel", "Ezequiel");
        bibleBooks.put("daniel", "Daniel");
        bibleBooks.put("oseas", "Oseas");
        bibleBooks.put("óseas", "Oseas");
        bibleBooks.put("joel", "Joel");
        bibleBooks.put("amós", "Amós");
        bibleBooks.put("jonás", "Jonás");
        bibleBooks.put("jonas", "Jonás");
        bibleBooks.put("miqueas", "Miqueas");
        bibleBooks.put("mi que has", "Miqueas");
        bibleBooks.put("mi ikea", "Miqueas");
        bibleBooks.put("mi ikeas", "Miqueas");
        bibleBooks.put("mi quedas", "Miqueas");
        bibleBooks.put("nahum", "Nahum");
        bibleBooks.put("habacuc", "Habacuc");
        bibleBooks.put("sofonías", "Sofonías");
        bibleBooks.put("sofá niñas", "Sofonías");
        bibleBooks.put("sofá niños", "Sofonías");
        bibleBooks.put("suponías", "Sofonías");
        bibleBooks.put("suponía", "Sofonías");
        bibleBooks.put("age ó", "Hageo");
        bibleBooks.put("page ó", "Hageo");
        bibleBooks.put("age o", "Hageo");
        bibleBooks.put("page o", "Hageo");
        bibleBooks.put("hageo", "Hageo");
        bibleBooks.put("zacarías", "Zacarías");
        bibleBooks.put("malaquías", "Malaquías");

        // Libros del Nuevo Testamento
        bibleBooks.put("mateo", "Mateo");
        bibleBooks.put("marcos", "Marcos");
        bibleBooks.put("lucas", "Lucas");
        bibleBooks.put("juan", "Juan");
        bibleBooks.put("hechos", "Hechos");
        bibleBooks.put("romanos", "Romanos");
        bibleBooks.put("1 corintios", "1 Corintios");
        bibleBooks.put("2 corintios", "2 Corintios");
        bibleBooks.put("gálatas", "Gálatas");
        bibleBooks.put("efesios", "Efesios");
        bibleBooks.put("filipenses", "Filipenses");
        bibleBooks.put("colosenses", "Colosenses");
        bibleBooks.put("1 tesalonicenses", "1 Tesalonicenses");
        bibleBooks.put("2 tesalonicenses", "2 Tesalonicenses");
        bibleBooks.put("1 timoteo", "1 Timoteo");
        bibleBooks.put("2 timoteo", "2 Timoteo");
        bibleBooks.put("tito", "Tito");
        bibleBooks.put("filemón", "Filemón");
        bibleBooks.put("hebreos", "Hebreos");
        bibleBooks.put("santiago", "Santiago");
        bibleBooks.put("1 pedro", "1 Pedro");
        bibleBooks.put("2 pedro", "2 Pedro");
        bibleBooks.put("1 juan", "1 Juan");
        bibleBooks.put("2 juan", "2 Juan");
        bibleBooks.put("3 juan", "3 Juan");
        bibleBooks.put("judas", "Judas");
        bibleBooks.put("apocalipsis", "Apocalipsis");

        return bibleBooks;
    }

    public static String extractChapter(String text) {
        text = StringUtils.remove(text, extractBookKeyFromText(text));

        List<Integer> numbersInText = extractNumbers(text);
        if (numbersInText.isEmpty()) return "1";

        return numbersInText.get(0).toString();
    }

    public static String extractVerse(String text) {
        text = StringUtils.remove(text, extractBookKeyFromText(text));
        List<Integer> numbersInText = extractNumbers(text);

        if (numbersInText.isEmpty() || (numbersInText.size() == 1)) {
            return "1-";
        }
        if (numbersInText.size() == 2) {
            return numbersInText.get(1).toString() + "-";
        }
        return numbersInText.get(1).toString() + "-" + numbersInText.get(2).toString();
    }

    public static ArrayList<String> possibleKeys() {
        ArrayList<String> possibleKeys = new ArrayList<>();
        ArrayList<Map.Entry<String, String>> books = new ArrayList<>(booksMap().entrySet().stream().toList());
        Collections.reverse(books);
        for (Map.Entry<String, String> bookEntry : books) {
            possibleKeys.add(bookEntry.getKey());
        }
        return possibleKeys;
    }
}
