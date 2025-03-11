public class Car {
    private String carId;
    private String makeId;
    private String model;
    private int year;
    private boolean isAvailable;

    Car(String carId, String makeId, String model, int year, boolean isAvailable) {
//        this.carId = carId;
//        this.makeId = makeId;
//        this.model = model;
//        this.year = year;
//        this.isAvailable = true;
        setCarId(carId);
        setMakeId(makeId);
        setModel(model);
        setYear(year);
        setAvailable(isAvailable);
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }
    public void setMakeId(String makeId) {
        this.makeId = makeId;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    public String getCarId() {
        return this.carId;
    }
    public String getMakeId() {
        return this.makeId;
    }
    public String getModel() {
        return this.model;
    }
    public int getYear() {
        return this.year;
    }
    public boolean getAvailable() {
        return this.isAvailable;
    }
    @Override
    public String toString() {
        return "CarId:"+this.carId+ " was manufactured in "+this.makeId+ " model: "+this.model +"in year: "+this.year +" and its availability is : "+this.isAvailable;
    }
}
