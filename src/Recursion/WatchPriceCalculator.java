package Recursion;

public class WatchPriceCalculator {
    String brand;
    int age;
    String gender;
    Watch titan = new Watch("Titan", 7999, 12.5, 7.5, 0);
    Watch rolex = new Watch("Rolex", 10999, 13.5, 12.5, 0);
    Watch[] arr = {titan, rolex};

    double getWatchPrice(String brand, int age, String gender) {
        if (brand == "Titan" && gender == "female" && age<60) {
            arr[0].discount = 2;
            return arr[0].price();
        } else if (brand == "Titan" && age >= 60) {
            arr[0].discount = 3;
            return arr[0].price();
        } else if (brand == "Rolex" && gender.equals("female") && age<60) {
            arr[1].discount = 2;
            return arr[1].price();
        } else if (brand == "Titan" && age >= 60) {
            arr[1].discount = 3;
            return arr[1].price();
        } else if (brand == "Rolex" && age >= 60) {
            arr[1].discount = 3;
            return arr[1].price();
        } else if (brand == "Titan") {
            return arr[0].price();
        } else {
            return arr[1].price();
        }
    }

    public static void main(String[] args) {
        WatchPriceCalculator w1 = new WatchPriceCalculator();
        double ans = w1.getWatchPrice("Rolex", 65, "male");
        System.out.println(ans);
    }
}

class Watch {
    String brand;
    double costPrice;
    double profitPercentage;
    double gst;
    double discount;

    public Watch(String brand, double costPrice, double profitPercentage, double gst, double discount) {
        super();
        this.brand = brand;
        this.costPrice = costPrice;
        this.profitPercentage = profitPercentage;
        this.gst = gst;
        this.discount = discount;
    }

    public double price() {
        double sellingPrice = this.costPrice * (100 + this.profitPercentage) / 100;
        sellingPrice = sellingPrice * (100 - this.discount) / 100;
        double totalPrice = sellingPrice * (100 + this.gst) / 100;
        return totalPrice;
    }
}
