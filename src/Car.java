public class Car {
    private String carId;
    private String make;
    private String model;
    private int year;
    private boolean isAvailable;

    Car(String carId, String make,String model,int year,boolean isAvailable){
        setCarId(carId);
        setMake(make);
        setModel(model);
        setYear(year);
        setAvailable(isAvailable);
    }


    public void setCarId(String carId){
        this.carId = carId;
    }
    public String getCarId(){
        return this.carId;
    }
    public void setMake(String make){
        this.make = make;
    }
    public String getMake(){
        return this.make;
    }
    public void setModel(String model){
        this.model = model;
    }
    public String getModel(){
        return this.model;
    }
    public void setYear(int year){
        this.year = year;
    }
    public int getYear(){
        return this.year;
    }
    public void setAvailable(boolean available){
        this.isAvailable = available;
    }
    public boolean getAvailable(){
        return this.isAvailable;
    }
    public void rentCar(){
        this.isAvailable = false;
    }
    public void returnCar(){
        this.isAvailable = true;
    }
    public String toString(){
        return "carID: "+this.carId+" "+"manufactured: "+this.make+" "+"model: "+this.model+" year: "+this.year;

    }


}
