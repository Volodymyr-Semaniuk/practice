import java.util.Date;

public class RegularClient extends Client{
    private double discount;

    
    public double getDiscount() {
        return discount;
    }
    public RegularClient(String fullName, Date dateOfBirth, String phoneNumber, double discount) {
        super(fullName, dateOfBirth, phoneNumber);
        this.discount = discount;
    }

    @Override
    public void incrementOrdersCount(){
        ordersCount += 2;
    }
}
