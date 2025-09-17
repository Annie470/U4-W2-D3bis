package entities;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args){

        Faker faker = new Faker(Locale.ITALY);

        Customer c1= new Customer(faker.name().fullName(),2);
        Customer c2= new Customer(faker.name().fullName(),2);
        Customer c3= new Customer(faker.name().fullName(),1);

        Product romanzo = new Product("Mille e una Notte", Category.BOOK, 11.5);
        Product romanzo2 = new Product("Paure e deliri", Category.BOOK, 14);
        Product tShirt = new Product("T-shirt bambino", Category.BABY, 18);
        Product cappello = new Product("Cappellino bambino", Category.BABY, 8);
        Product deo = new Product("Deodorante maschile", Category.BOYS, 3);
        Product rasoio = new Product("Rasoio elettrico", Category.BOYS, 35);

        Order ordine1 = c1.creareOrdine(
                LocalDate.of(2024, 11, 12),
                LocalDate.of(2024, 11, 18),
                List.of(deo, rasoio, romanzo,tShirt)
        );

        Order ordine2 = c1.creareOrdine(
                LocalDate.of(2025, 9, 16),
                LocalDate.of(2025, 9, 20),
                List.of(romanzo2, cappello)
        );

        List<Product> tuttiIProdotti = new ArrayList<>();
        Collections.addAll(tuttiIProdotti, romanzo, romanzo2, tShirt, cappello, rasoio, deo);

        Order ordine3 = c3.creareOrdine(
                LocalDate.of(2025, 8, 1),
                LocalDate.of(2025, 8, 12),
                tuttiIProdotti
        );

        List<Order> tuttiOrdini = new ArrayList<>();
        Collections.addAll(tuttiOrdini, ordine1, ordine2, ordine3);

        //ESERCIZIO1
        List<Product> listaBook = tuttiIProdotti.stream().filter(prodotto -> prodotto.getCategory().equals(Category.BOOK) && prodotto.getPrice() >12).toList();
        System.out.println(listaBook);

        //ESERCIZIO2
        try{ List<Order> ordiniSoloBaby = tuttiOrdini.stream()
                .filter(ordine -> ordine.getProducts().stream()
                        .anyMatch(prodotto -> prodotto.getCategory() == Category.BABY))
                .toList();
            ordiniSoloBaby.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Errore da scrivere");
        }
        //ESERCIZIO3
        List<Product> prodottiBoys = tuttiIProdotti.stream().filter(product -> product.getCategory().equals(Category.BOYS)).map(product -> {double discount = (product.getPrice()*10)/100;
        product.setPrice(product.getPrice() - discount);
        return product;}).toList();
        System.out.println(prodottiBoys);
    }



}
