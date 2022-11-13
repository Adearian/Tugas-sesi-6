/*
 * PBO Sesi 6
 * Package-Abstract-Interface
 */

package PBO;
import java.util.Scanner;

public class Laptops {
    static boolean isClosed = false;
  static String answer;
  static Laptop laptopOfChoice;

  public static void main(String[] args) {
    Laptop ToshibaC600 = new Toshiba();
    Laptop MacbookAirM1 = new Macbook();

    Scanner input = new Scanner(System.in);

    System.out.println("--------- Pilih Laptop ---------");
    System.out.println("1. Macbook Air M1" );
    System.out.println("2. Toshiba C600");
    System.out.println("-----------------------------");

    System.out.print("Pilih menu : ");
    answer = input.next();

    switch(answer) {
      case "1":
        laptopOfChoice = MacbookAirM1;
        break;
      case "2":
        laptopOfChoice = ToshibaC600;
        break;
      default:
        System.out.println("Wrong input number");
    }

    LaptopUser sam = new LaptopUser(laptopOfChoice);

    while(!isClosed) {
      System.out.println("--------- Main Menu ---------");
      System.out.println("On. Nyalakan Laptop");
      System.out.println("Of. Matikan Laptop");
      System.out.println("Up. Perbesar Volume");
      System.out.println("Down. Perkecil Volume");
      System.out.println("5. Keluar Program");
      System.out.println("-----------------------------");

      System.out.print("Pilih menu : ");
      answer = input.next();

      switch(answer) {
        case "1":
          sam.turnOn();
          break;
        case "2":
          sam.turnOff();
          break;
        case "3":
          sam.makeFullVolume();
          break;
        case "4":
          sam.makeSilentVolume();
          break;
        case "5":
          isClosed = true;
          break;
        default:
          System.out.println("Wrong input number");
      }
    }
  }
}

   

interface Laptop {
  int MAX_VOLUME = 100;
  int MIN_VOLUME = 0;

  void powerOn();
  void powerOff();
  void volumeUp();
  void volumeDown();
}

class LaptopUser {
  Laptop laptop;

  public LaptopUser(Laptop laptop) {
    this.laptop = laptop;
  }

  void turnOn() {
    laptop.powerOn();
  }

  void turnOff() {
    laptop.powerOff();
  }

  void makeFullVolume() {
    laptop.volumeUp();
  }

  void makeSilentVolume() {
    laptop.volumeDown();
  }
}

class Toshiba implements Laptop {
  int volume;
  boolean isPower;

  public Toshiba() {
    volume = 50;
  }

  public String getString() {
    return "Toshiba";
  }

  @Override
  public void powerOn() {
    isPower = true;
    System.out.println("Booting");
    System.out.println("Please wait");
  }

  @Override
  public void powerOff() {
    isPower = false;
    System.out.println("Laptop Mati");
  }

  @Override
  public void volumeUp() {
    if (isPower) {
      if (volume == MAX_VOLUME) {
        System.out.println("Volume is 100%");
      }

      else {
        volume += 5;
        System.out.println("Volume is now " + getVolume() + "%");
      }

    } else {
      System.out.println("Nyalakan terlebih dahulu");
    }
  }

  @Override
  public void volumeDown() {
    if (isPower) {
      if (volume == MIN_VOLUME) {
        System.out.println("Volume is 0%");
      }

      else {
        volume -= 5;
        System.out.println("Volume is now " + getVolume() + "%");
      }

    } else {
      System.out.println("Nyalakan terlebih dahulu");
    }
  }

  public int getVolume() {
    return volume;
  }
}


class Macbook implements Laptop {
  int volume;
  boolean isPower;

  public Macbook() {
    volume = 50;
  }

  public String getString() {
    return "Macbook";
  }

  @Override
  public void powerOn() {
    isPower = true;
    System.out.println("Booting");
  }

  @Override
  public void powerOff() {
    isPower = false;
    System.out.println("Laptop Mati");
  }

  @Override
  public void volumeUp() {
    if (isPower) {
      if (volume == MAX_VOLUME) {
        System.out.println("Volume is 100%");
      }

      else {
        volume += 5;
        System.out.println("Volume is now " + getVolume() + "%");
      }

    } else {
      System.out.println("Nyalakan terlebih dahulu");
    }
  }

  @Override
  public void volumeDown() {
    if (isPower) {
      if (volume == MIN_VOLUME) {
        System.out.println("Volume is 0%");
      }

      else {
        volume -= 5;
        System.out.println("Volume is now " + getVolume() + "%");
      }

    } else {
      System.out.println("Nyalakan terlebih dahulu");
    }
  }

  public int getVolume() {
    return volume;
  }
}
