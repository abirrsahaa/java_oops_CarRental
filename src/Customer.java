import java.util.*;
public class Customer {
    private String customerId;
    private String name;
    private List<Car>rentedCars;

    Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        this.rentedCars = new ArrayList<Car>();
    }
    // setters
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setRentedCars(List<Car> rentedCars) {
        this.rentedCars = rentedCars;
    }

    //getters
    public String getCustomerId() {
        return customerId;
    }
    public String getName() {
        return name;
    }
    public List<Car> getRentedCars() {
        return rentedCars;
    }
    public Car rentCar(Car car){
        if(car.getAvailable()){
            rentedCars.add(car);
            car.setAvailable(false);
            return car;
        }else{
            System.out.println("Car Not Available");
        }
        return null;
    }

    public Car returnCar(Car car){
//        return rentCar(car);
        if(rentCar(car)==null){
            System.out.println("Car Not Available");
            return null;
        }
        else return car;
    }//having doubt in this problem statement
    @Override
    public String toString(){
        return "Customer ID: "+this.customerId+" Name: "+this.name;
    }

}
