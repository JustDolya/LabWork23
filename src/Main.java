public class Main {

    public static void main(String[] args) {
        WaterHeater waterHeater = new WaterHeater();
        waterHeater.connectDevice();
        waterHeater.disconnectDevice();
        PhoneChargeAdapter phone = new PhoneChargeAdapter(new Phone());
        phone.connectDevice();
        phone.disconnectDevice();
    }
}

interface ElectricitySource380{
    public void connectDevice();
    public void disconnectDevice();
}

class WaterHeater implements ElectricitySource380{
    public int volume;
    public void turnOn(){
        System.out.println("Нагреватель включён");
    }

    @Override
    public void connectDevice() {
        System.out.println("Питание подключено");
    }

    @Override
    public void disconnectDevice() {
        System.out.println("Питание отключено");
    }
}

interface Charger220{
    public void chargeOn();
    public void chargeOff();
}

class Phone implements Charger220{
    public String model;

    @Override
    public void chargeOn() {
        System.out.println("Зарядное устройство подключено");
    }

    @Override
    public void chargeOff() {
        System.out.println("Зарядное устройство отключено");
    }
}

class PhoneChargeAdapter implements  ElectricitySource380{
    Phone phone;
    public  PhoneChargeAdapter(Phone phone){
        this.phone = phone;
    }

    @Override
    public void connectDevice() {
        phone.chargeOn();
    }

    @Override
    public void disconnectDevice() {
        phone.chargeOff();
    }
}