import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to car rental system");
        System.out.println("Enter Customer details");
        System.out.println("Enter Customer ID");
        String customerId = sc.next();
        System.out.println("Enter Customer Name");
        String customerName = sc.nextLine();
        CarRentalService carRentalService = new CarRentalService();

        Customer customer = new Customer(customerId, customerName);
        carRentalService.addCustomer(customer);
        System.out.println("Choose below options to add or rent a car");
        System.out.println("1. Add a car");
        System.out.println("2. Rent a car");
        System.out.println("3. View all cars");
        System.out.println("4. Filter cars by model or year");

        Car car1 = new Car("1", "hyundai", "verna", 2024, true);
        Car car2 = new Car("2", "mercedes", "benz", 2000, true);
        Car car3 = new Car("3", "honda", "ciaz", 1990, true);
        Car car4 = new Car("4", "bmw", "classic", 1998, false);
        Car car5 = new Car("5", "hyun", "verna", 2024, false);
        Car car6 = new Car("6", "bmw", "classic", 1998, true);

        carRentalService.addCar(car1);
        carRentalService.addCar(car2);
        carRentalService.addCar(car3);
        carRentalService.addCar(car4);
        carRentalService.addCar(car5);
        carRentalService.addCar(car6);

        Customer customer1 = new Customer("wcs174", "Abir");
        Customer customer2 = new Customer("wcs171", "aakshi");
        Customer customer3 = new Customer("wcs173", "om");


        carRentalService.addCustomer(customer1);
        carRentalService.addCustomer(customer2);
        carRentalService.addCustomer(customer3);


        int choice = sc.nextInt();

        switch (choice){
            case 1:
                System.out.println("Enter Car ID");
                String carId = sc.next();
                System.out.println("Enter Make ID");
                String makeId = sc.next();
                System.out.println("Enter Model");
                String model = sc.next();
                System.out.println("Enter Year");
                int year = sc.nextInt();
                System.out.println("Enter car is available or not");
                boolean isAvailable=sc.nextBoolean();
                Car car = new Car(carId,makeId,model,year,isAvailable);
                carRentalService.addCar(car);
                System.out.println("Car added");
                break;
            case 2:

                System.out.println("The available cars for rent are ");
                List<Car> available=carRentalService.getAvailableCars();
                System.out.println("the available cars are");
                System.out.println(available);
                for(int i=0;i<available.size();i++){
                    System.out.println((i+1)+". "+available.get(i).getModel()+" "+available.get(i).getYear()+" "+available.get(i).getMakeId());
                }
                System.out.println("enter the index of the car you want to rent");
                int index=sc.nextInt();
                Car carToRent=available.get(index-1);
                //customer.rentCar(carToRent);
                System.out.println("The car " + carToRent.getModel()+ " " + carToRent.getMakeId() + " "+ carToRent.getYear()+ " has been rented successfully");
                break;

            case 3:
                System.out.println("All the cars that are being listed here are ");
                List<Car> getAllCars = carRentalService.allCars();
                for (Car cars : getAllCars) {
                    System.out.println(cars);
                }
                break;

            case 4:
                System.out.println("Do you want to get cars by model or by model and year?");
                System.out.println("If only by model type 1 , and if both by model and year type 2" );
                System.out.println("Type 1 or 2");
                int n = sc.nextInt();
                if(n==1){
                    System.out.println("Enter the car Model");
                    String carModel = sc.next();
                    carRentalService.printCarsByModel(carModel);
                }
                if(n==2){
                    System.out.println("Enter the car Model");
                    String carModel = sc.next();
                    System.out.println("Enter the year");
                    int carYear = sc.nextInt();
                    carRentalService.printCarsByModelAndYear(carModel, carYear);
                }
                break;
        }
    }
}