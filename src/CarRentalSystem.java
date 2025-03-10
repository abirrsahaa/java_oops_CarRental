import java.util.List;
import java.util.Scanner;

public class CarRentalSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("welcome to our CarRentalSystem");
        System.out.println("Enter customer details below");
        System.out.println("Enter customerID");
        String customerID=input.nextLine();
        System.out.println("Enter customer name");
        String customerName=input.nextLine();
        Customer customer=new  Customer(customerID,customerName);
        CarRentalService carRentalService = new CarRentalService();
        carRentalService.addCustomer(customer);
        System.out.println("choose your action from the below list");
        System.out.println("1. Create a new car");
        System.out.println("2. Rent a car");
        System.out.println("3. View all cars");
//        System.out.println("4. view list of specific user ka class");


        Car car1=new Car("1","hyundai","verna",2024,true);
        Car car2=new Car("2","mercedes","benz",2000,true);
        Car car3=new Car("3","honda","ciaz",1990,true);

        Car car4=new Car("4","bmw","classic",1998,false);


        Customer customer1=new Customer("wcs174","Abir");
        Customer customer2=new Customer("wcs171","aakshi");
        Customer customer3=new Customer("wcs173","om");



        carRentalService.addCustomer(customer1);
        carRentalService.addCustomer(customer2);
        carRentalService.addCustomer(customer3);
        carRentalService.addCar(car1);
        carRentalService.addCar(car2);
        carRentalService.addCar(car3);
        carRentalService.addCar(car4);

//        Scanner input = new Scanner(System.in);
        int choice=input.nextInt();



        switch(choice){
            case 1:
                System.out.println("enter the car details below");
                System.out.println("Enter carId");
                String carID=input.next();
                System.out.println("Enter car make");
                String make=input.next();
                System.out.println("Enter car model");
                String model=input.next();
                System.out.println("Enter car year");

                int year=input.nextInt();
                System.out.println("Enter car is available or not");
                boolean isAvailable=input.nextBoolean();
                Car car=new  Car(carID,make,model,year,isAvailable);
                carRentalService.addCar(car);
                System.out.println("The car has been addded successfully");
                break;
            case 2:

                System.out.println("The available cars for rent are ");
                List<Car> available=carRentalService.getAvailableCars();
                System.out.println("the available cars are");
                System.out.println(available);
                for(int i=0;i<available.size();i++){
                    System.out.println((i+1)+". "+available.get(i).getModel()+" "+available.get(i).getYear()+" "+available.get(i).getMake());
                }
                System.out.println("enter the index of the car you want to rent");
                int index=input.nextInt();
                Car carToRent=available.get(index-1);
                customer.rentCar(carToRent);
                System.out.println("The car " + carToRent.getModel()+ " " + carToRent.getMake() + " "+ carToRent.getYear()+ " has been rented successfully");
                break;
            case 3:
                System.out.println("All the cars that are being listed here are ");
                List<Car> allCars=carRentalService.allCars();
                for(int i=0;i<allCars.size();i++){
                    System.out.println((i+1)+". "+allCars.get(i).getModel()+" "+allCars.get(i).getYear()+" "+allCars.get(i).getMake());
                }

                break;


        }
    }
}