import java.util.Comparator;

public class OrdersCountComparator implements Comparator<Client> {
    @Override
    public int compare(Client client1, Client client2) {
        if (client1.getOrdersCount() == client2.getOrdersCount()){
            return 0;
        } else if (client1.getOrdersCount() > client2.getOrdersCount()) {
            return 1;
        } else {
            return -1;
        }

    }
}
