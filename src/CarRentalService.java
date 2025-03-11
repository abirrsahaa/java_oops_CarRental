import java.util.ArrayList;
import java.util.List;

public class CarRentalService {
    private List<Car> cars;
    private List<Customer> customers;

//    hardcode data

    CarRentalService() {
        this.cars = new ArrayList<Car>();
        this.customers = new ArrayList<Customer>();
    }


    public List<Car> allCars(){
        return  this.cars;
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
            System.out.println(car.getAvailable());
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
            if(car.getMakeId().equals(make) && car.getModel().equals(model))return car;
        }
        System.out.println("Car Not Available");
        return null;
    }

    public Customer findCustomerByID(String customerID){

        for(Customer customer:customers){
            if(customer.getCustomerId().equals(customerID))return customer;
        }
        System.out.println("Customer Not Available");
        return null;
    }
    public void printCarsByModel(String model) {
        boolean found = false;
        for (Car car : cars) {
            if (car.getModel().equals(model)) {
                System.out.println(car);  // Print car details
                found = true;
            }
        }
        if (!found) {
            System.out.println("No cars found with the model: " + model);
        }
    }
    public void printCarsByModelAndYear(String model, int year) {
        boolean found = false;
        for (Car car : cars) {
            if (car.getModel().equals(model) && car.getYear() == year) {
                System.out.println(car);  // Print car details
                found = true;
            }
        }
        if (!found) {
            System.out.println("No cars found with the model: " + model + " and year: " + year);
        }
    }

}