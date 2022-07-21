public class Taxi extends Transport implements FuelChange,BoardPassenger,Now{

    public Taxi(String name, int number, int fuelVolume, int speed, int speedChange) {
        super(name, number, fuelVolume, speed, speedChange, 4);

    }

    String state = "일반";

    int totalNum = 0;
    int defaultCost = 3000;
    int addCost = 1000;
    int defaultDistance = 1;
    int accumCost = 0;

    int calpay = 0;


    public void setGoal(String goal, int distance){
        this.goal = goal;
        this.distance = distance;
    }

    public void State(String state){
        this.state = state;
    }

    @Override
    public void fuelChange(int grad){
        fuelVolume += grad;
        if (fuelVolume<10){
            System.out.println("--------주유필요--------");
            System.out.println("----------------------");
        }
    }
    @Override
    public void boardPassenger(int count){
        int passengers = currentPassenger + count;
        if( passengers > passengerMax){
            System.out.println("----최대 승객 수 초과----");
            System.out.println("----------------------");
        }else{
            currentPassenger = passengers;
        }
    }

    public void pay(){
        currentPassenger = 0;
        setGoal("", 0);
        accumCost += calpay;
        calpay = 0;
    }
    public void calPay(){
        if(distance>1){
            calpay = defaultCost + (distance - defaultDistance)*addCost;
        }else{
            calpay = defaultCost;
        }

    }


    @Override
    public void now(){
        System.out.println("- 번호 = " + name);
        System.out.println("- 주유량 = " + fuelVolume  );
        if(goal != ""){
            state = "운행중";
            System.out.println("- 상태 = " + state);
        }
        else if( currentPassenger > passengerMax){
            state = "탑승불가";
            System.out.println("- 상태 = " + state);
        }else{
            state = "일반";
            System.out.println("- 상태 = " + state);
        }
        System.out.println("- 탑승 승객 수 = " + currentPassenger);
        System.out.println("- 잔여 승객 수 = " + (passengerMax-currentPassenger));
        System.out.println("- 목적지 = " + goal);
        System.out.println("- 목적기까지 거리 = " + distance);
        System.out.println("- 기본 요금 확인 = " + defaultCost);
        System.out.println("- 지불할 요금 = " + calpay);
        System.out.println("- 누적 요금 = " + accumCost);
        System.out.println("----------------------");
    }

}




