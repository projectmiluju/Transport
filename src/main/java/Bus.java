public class Bus extends Transport implements FuelChange,BoardPassenger,Now{


    public Bus(String name, int number, int fuelVolume, int speed, int speedChange) {
        super(name, number, fuelVolume, speed, speedChange, 30);
    }


    String state = "운행중";

    int totalNum = 0;
    int cost = 1000;
    int acccumCost = 0;


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
        if((count+currentPassenger)<=passengerMax){
            acccumCost = Math.max(acccumCost,acccumCost+(cost*count));
        }

    }


    public void State(String state){
        this.state = state;
        if(state=="차고지행"){
            currentPassenger= 0;
            acccumCost = 0;
        }
    }


    @Override
    public void now(){
        System.out.println("- 번호 = " + name);
        System.out.println("- 주유량 = " + fuelVolume);
        if (fuelVolume<10){
            state = "차고지행";
            currentPassenger= 0;
            acccumCost = 0;
            System.out.println("- 상태 = "+ state);
        }
        else{
            System.out.println("- 상태 = "+ state);
        }
        System.out.println("- 탑승 승객 수 = " + currentPassenger);
        System.out.println("- 잔여 승객 수 = " +  (passengerMax - currentPassenger));
        System.out.println("- 누적 요금 = "+ acccumCost);
        System.out.println("----------------------");

    }


}

