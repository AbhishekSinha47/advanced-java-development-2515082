package _02_06;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * This is Exercise to see generic method flattenList
 * and wildcard usage in function getTotalPrice
 */
public class TicketMachine {

    public static void main(String[] args) {

        List<List<String>> destinationLists = asList(
                asList("New York", "Boston"),
                asList("Los Angeles", "San Francisco"));


        List<List<Ticket>> ticketLists = asList(
                asList(new AdultTicket(), new AdultTicket()),
                asList(new ChildTicket(), new ChildTicket())
        );

        List<String> destinations = flattenList(destinationLists);
        System.out.println(destinations);

        List<Ticket> tickets = flattenList(ticketLists);
        System.out.println(tickets);

        System.out.println("Total price: " + getTotalPrice(tickets));

        List<AdultTicket> adultTickets = asList(new AdultTicket(), new AdultTicket());
        System.out.println("Total price: " + getTotalPrice(adultTickets));

    }


    //This should work with lists containing any type of object => see next function, made this generic
    /*static List<String> flattenList(List<List<String>> nestedList) {

        List<String> flattenedList = new ArrayList<>();
        nestedList.forEach(flattenedList::addAll);
        return flattenedList;

    }*/

    static <T> List<T> flattenList(List<List<T>> nestedList) {

        List<T> flattenedList = new ArrayList<>();
        nestedList.forEach(flattenedList::addAll);
        return flattenedList;

    }

    // This wont work with lists containing Ticket objects or any subclass of Ticket.
    // For that see next function, implemented using wildcard of type ticket.
    /*static int getTotalPrice(List<Ticket> tickets) {
        int totalPrice = 0;
        for (Ticket ticket : tickets) {
            totalPrice += ticket.getPrice();
        }
        return totalPrice;
    }*/

    static int getTotalPrice(List<? extends Ticket> tickets) {
        int totalPrice = 0;
        for (Ticket ticket : tickets) {
            totalPrice += ticket.getPrice();
        }
        return totalPrice;
    }


}
