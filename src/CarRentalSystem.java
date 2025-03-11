import java.io.*;
import java.util.List;
import java.util.Scanner;
class CustomerExistsException extends Exception {
    public CustomerExistsException(String message) {
        super(message);
    }
}
public class CarRentalSystem {


    public static void main(String[] args) {

        System.out.println("welcome to our CarRentalSystem");
        Scanner input = new Scanner(System.in);

        CarRentalService carRentalService = new CarRentalService();
//        carRentalService.addCustomer(customer);
        System.out.println("choose your action from the below list");
        System.out.println("1. Create a new car");
        System.out.println("2. Rent a car");
//        System.out.println("3. View all cars");
//        System.out.println("4. view list of specific user ka class");
        System.out.println("3.Register");



        Car car1=new Car("1","hyundai","verna",2024,true);
        Car car2=new Car("2","mercedes","benz",2000,true);
        Car car3=new Car("3","honda","ciaz",1990,true);




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
                File CarFile=new File("src/Cars.txt");
                if(CarFile.exists()){
                    try (FileWriter Carwriter = new FileWriter(CarFile,true)){

                        BufferedWriter carwriter=new BufferedWriter(Carwriter);

                        carwriter.write(car.getCarId()+","+make+","+model+","+year+","+isAvailable);
                        carwriter.newLine();
                        carwriter.flush();
                        carwriter.close();
                        System.out.println("Car has been added to the System successfully.");

                    }catch (IOException e){
                        System.out.println("An error occurred while writing to the Car file "
                                + " to the file: " + e.getMessage());
                    }
                }
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
//                idhar kuch karna padedga cstomer hardcoded hai
                customer1.rentCar(carToRent);
                System.out.println("The car " + carToRent.getModel()+ " " + carToRent.getMake() + " "+ carToRent.getYear()+ " has been rented successfully");
                break;
            case 3:

                System.out.println("Enter customer details below");
                System.out.println("Enter customerID");
                input.nextLine();
                String customerID=input.nextLine();
                System.out.println("the customer id is "+customerID);
                File CustomerIDFile=new File("src/CustomerID.txt");
                if(CustomerIDFile.exists()){
                    System.out.println("hey i am here ");
                    try(FileReader CustomerIDReader=new FileReader(CustomerIDFile)){
                        BufferedReader customerIDReader=new BufferedReader(CustomerIDReader);
                        String line;
                        while((line=customerIDReader.readLine())!=null){
                            if(line.equals(customerID)) {
                                System.out.println("The customer " + customerID + " already exists.");
                                throw new CustomerExistsException("The customer with this id already exists try another time with a diff id or if it is you login donot register dumbo!");
                            }

                        }
                        try(FileWriter CustomerIDWriter=new FileWriter(CustomerIDFile,true)){
                            BufferedWriter  customerIDWriter=new BufferedWriter(CustomerIDWriter);
                            customerIDWriter.flush();
                            customerIDWriter.write(customerID);
                            customerIDWriter.newLine();
                            customerIDWriter.flush();
                            customerIDWriter.close();
                            System.out.println("The customer " + customerID + " is new has been noted successfully");
                        }
                        System.out.println("Enter customer name");
                        String customerName=input.nextLine();
//                Customer customer=new  Customer(customerID,customerName)

                        File CustomerFile=new File("src/Customers.txt");
                        if(CustomerFile.exists()) {
                            try (FileWriter CustomerWriter = new FileWriter(CustomerFile, true)) {

                                BufferedWriter customerwriter = new BufferedWriter(CustomerWriter);
                                customerwriter.flush();
                                customerwriter.write(customerID + "," + customerName);
                                customerwriter.newLine();
                                customerwriter.flush();
                                customerwriter.close();
                                System.out.println("Customer has been registered successfully.");


                            } catch (IOException e) {
                                System.out.println("there was an error writing into the  Customer file " + e.getMessage());
                            }
                        }

                        }catch(IOException e){
                        System.out.println("An error occurred while Reading to the CustomerID file ");
                    }catch(CustomerExistsException e){
                        System.out.println("This error occured while signing up the customer "+ e.getMessage());
                    }

                }





                break;


        }
    }
}