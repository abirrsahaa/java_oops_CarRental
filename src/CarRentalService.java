import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarRentalService {
    private List<Car> cars;
    private List<Customer> customers;

//    hardcode data

    CarRentalService() {
        this.cars =getCars();
        this.customers = new ArrayList<Customer>();
    }


public List<Car> getCars() {
    File file=new File("src/Cars.txt");
    List<Car> ALlCars=new ArrayList<>();
    try(FileReader CarsReader=new FileReader(file)){

        BufferedReader br=new BufferedReader(CarsReader);
        String readingCars;
        String id,make,model;
        int year;
        boolean available;
        while((readingCars=br.readLine())!=null){
            String[] arr =readingCars.split(",");
            id=arr[0];
            make=arr[1];
            model=arr[2];
            year=Integer.parseInt(arr[3]);
            available=Boolean.parseBoolean(arr[4]);

            Car car=new Car(id,make,model,year,available);
            ALlCars.add(car);
//            System.out.println(car.getAvailable()+car.getMake()+car.getModel()+car.getYear());

        }


    }catch(IOException e){
        System.out.println(e.getMessage());
    }
    return  ALlCars;
}

    public List<Car> allCars(){
        return  cars;
    }



    public List<Customer> getCustomers(){
        return customers;
    }
    public void  addCar(Car car){
        cars.add(car);
    }
    public void addCustomer(Customer customer){
        customers.add(customer);
    }
    public List<Car> getAvailableCars(){
        List<Car> availableCars = new ArrayList<>();
        for (Car car:cars){
//            System.out.println(car.getAvailable());
            if(car.getAvailable())availableCars.add(car);
        }
        return availableCars;
    }
    public List<Car> getRentedCars(){

        List<Car> rentedCars = new ArrayList<>();
        for (Car car:cars){
            if(!car.getAvailable())rentedCars.add(car);
        }
        return rentedCars;
    }

    public Car findCarByMakeModel(String make,String model){
        for(Car car:cars){
            if(car.getMake().equals(make) && car.getModel().equals(model))return car;
        }
        System.out.println("Car Not Available");
        return null;
    }

    public Customer findCustomerByID(String customerID,Customer abir){
//        should i use include or any way to optimize it .?
        for(Customer customer:customers){
            if(customer.getCustomerID().equals(customerID))return customer;
        }
        System.out.println("Customer Not Available");
        return null;
    }


}
