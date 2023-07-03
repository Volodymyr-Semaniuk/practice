import java.util.*;
public class Main {

    public static  void addClient(List<? super RegularClient> clients, RegularClient client){
        clients.add(client);
    }

    public static int getClientsByOrders(List<? extends Client> clients, int ordersCount){
        int clientsCount = 0;

        for (Object client: clients) {
            if (((Client) client).getOrdersCount() > ordersCount){
                clientsCount ++;
            }
        }
        return clientsCount;
    }


    public static void main(String[] args) {

        Driver driver1 = new Driver("David Tree", new Date(1993, Calendar.FEBRUARY, 1), 5, "066-368-93-94");
        Driver driver2 = new Driver("Alice Johnson", new Date(1975, Calendar.JUNE, 15), 10, "095-789-12-94");
        Driver driver3 = new Driver("Bob Brown", new Date(1990, Calendar.APRIL, 30), 2, "099-456-78-91");

        Car car1 = new Car("Toyota", "Corolla", 2010, "gasoline", "sedan", "white", "ABC-123", 4, 2);
        Car car2 = new Car("Honda", "Civic", 2015, "gasoline", "sedan", "black", "XYZ-789", 4, 2);
        Car car3 = new Car("Nissan", "Altima", 2018, "gasoline", "sedan", "silver", "DEF-456", 4, 2);

        driver1.setCar(car1);
        driver2.setCar(car2);
        driver3.setCar(car3);

        Client client1 = new Client("Mary Johnson", new Date(2005, Calendar.JULY, 20), "099-368-93-94");
        Client client2 = new Client("Tom Davis", new Date(1998, Calendar.OCTOBER, 10), "095-358-89-24");
        Client client3 = new Client("Amy Wilson", new Date(1995, Calendar.DECEMBER, 5), "099-368-93-36");
        Client client4 = new Client("David Tom", new Date(2000, Calendar.APRIL, 1), "099-789-41-78");
        Client client5 = new Client("Sara Trace", new Date(2003, Calendar.SEPTEMBER, 15), "099-522-74-52");

        Order order1 = new Order(5.3, driver1, client1);
        Order order2 = new Order(2.1, driver2, client2);
        Order order3 = new Order(8.5, driver3, client3);
        Order order4 = new Order(3.7, driver1, client4);
        Order order5 = new Order(6.2, driver2, client5);
        Order order6 = new Order(1.5, driver3, client2);

        Map<Driver, Car> carOwners = new HashMap<>();
        carOwners.put(driver1, car1);
        carOwners.put(driver2, car1);
        carOwners.put(driver3, car3);

        List<Order> orders = new ArrayList<>(Arrays.asList(order1, order2, order3, order4, order5, order6));
        List<Car> cars = new ArrayList<>(Arrays.asList(car1, car2, car3));
        List<Client> clients = new ArrayList<>(Arrays.asList(client1, client2, client3, client4, client5));


        System.out.println("\nSorting cars by total distance \n");

        DistanceComparator distanceComparator = new DistanceComparator();
        cars.sort(distanceComparator);

        for (Car car : cars){
            System.out.println(car);
            System.out.println();
        }

        System.out.println("\nSorting clients by the frequency of using the taxi service \n");


        OrdersCountComparator ordersCountComparator = new OrdersCountComparator();
        clients.sort(ordersCountComparator);

        for (Client client : clients){
            System.out.println(client);
            System.out.println();
        }

        RegularClient regClient1 = new RegularClient("Boris Johnson", new Date(1968, Calendar.APRIL, 10),
                                        "099-522-70-52", 0.1);
        regClient1.incrementOrdersCount();
        regClient1.incrementOrdersCount();
        RegularClient regClient2 = new RegularClient("Boris Green", new Date(1998, Calendar.OCTOBER, 10),
                                        "099-532-70-52", 0.08);

        List<RegularClient> regularClients = new ArrayList<>(Arrays.asList(regClient1, regClient2));

        System.out.println(getClientsByOrders(regularClients, 2));

        addClient(clients, regClient1);

        for (Client client : clients){
            System.out.println(client);
            System.out.println();
        }

    }
}