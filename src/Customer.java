import java.util.ArrayList;
import java.util.List;

public class Customer {
    private  String customerID;
    private  String name;
    private  List<Car> rentedCars; //need to know its use case

    Customer(String customerID, String name) {
        this.customerID = customerID;
        this.name = name;
        this.rentedCars = new ArrayList<Car>();
    };


//    getters and setters for each attribute

    public String getCustomerID(){
        return  this.customerID;
    }

    public void setCustomerID(String customerID){
        this.customerID=customerID;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name=name;
    }

    public Car rentCar(Car car){
        if(car.getAvailable()){
            car.setAvailable(false);
            rentedCars.add(car);  //updating the list
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
        return "Customer ID: "+this.customerID+" Name: "+this.name;
    }

}
