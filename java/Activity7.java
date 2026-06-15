package fst;


interface BicycleParts {
 int tyres = 2;
 int maxSpeed = 25;
}


interface BicycleOperations {
 void speedUp(int increment);
 void applyBrake(int decrement);
}


class Bicycle implements BicycleParts, BicycleOperations {

 int gears;
 int currentSpeed;

 Bicycle(int gears, int currentSpeed) {
     this.gears = gears;
     this.currentSpeed = currentSpeed;
 }

 public void speedUp(int increment) {
     currentSpeed += increment;
     System.out.println("Speed = " + currentSpeed);
 }

 public void applyBrake(int decrement) {
     currentSpeed -= decrement;
     System.out.println("Speed = " + currentSpeed);
 }

 public void display() {
     System.out.println("Gears = " + gears);
     System.out.println("Max Speed = " + maxSpeed);
 }
}


class MountainBike extends Bicycle {

 int seatHeight;

 MountainBike(int gears, int speed, int seatHeight) {
     super(gears, speed);
     this.seatHeight = seatHeight;
 }

 public void display() {
     super.display();
     System.out.println("Seat Height = " + seatHeight);
 }
}


public class Activity7 {
 public static void main(String[] args) {

     MountainBike bike = new MountainBike(3, 0, 25);

     bike.display();

     bike.speedUp(20);

     bike.applyBrake(5);
 }
}