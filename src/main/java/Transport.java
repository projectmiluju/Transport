public class Transport {
    String name;
    int number;
    int fuelVolume = 100;
    int speed;
    int speedChange;
    int passengerMax;
    int currentPassenger = 0;

    public Transport(String name, int number, int fuelVolume, int speed, int speedChange, int passengerMax) {
        this.name = name;
        this.number = number;
        this.fuelVolume = fuelVolume;
        this.speed = speed;
        this.speedChange = speedChange;
        this.passengerMax = passengerMax;
    }

    String goal = "";
    int distance = 0;

    String state = "";



    public void State(String state){
        this.state = state;
    }


    public void setGoal(String goal, int distance){
        this.goal = goal;
        this.distance = distance;


    }
    public void pay(){
        currentPassenger = 0;
        setGoal("", 0);
    }

    public void calPay(){

    }
}
