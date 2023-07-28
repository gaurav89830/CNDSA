class Car extends Vehicle{
    String carName = "bmw";
    int gears;
    Car()
    {
        carName = "volkswagon";
        System.out.println("car constructor");
    }
    void print(){
        System.out.println(carName);
    }

    void fuckoff(){
        System.out.println("how tf can you access me");
    }

    public static void main(String[] args) {
        Vehicle v = new Car();


    }
}