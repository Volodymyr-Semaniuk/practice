import java.util.Date;

public class NewClient extends Client{


    public NewClient(String fullName, Date dateOfBirth, String phoneNumber) {
        super(fullName, dateOfBirth, phoneNumber);
    }

    @Override
    public void incrementOrdersCount(){
        ordersCount = 0;
    }
}
