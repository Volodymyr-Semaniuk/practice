import java.util.Comparator;

public class DistanceComparator implements Comparator<Car> {
    @Override
    public int compare(Car car1, Car car2) {
        if (car1.getTotalDistance() == car2.getTotalDistance()) {
            return 0;
        } else if (car1.getTotalDistance() > car2.getTotalDistance()) {
            return 1;
        } else {
            return -1;
        }
    }
}
