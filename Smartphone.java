/*
 * PBO Sesi 6
 * Package-Abstract-Interface
 */

package PBO;
import java.util.Scanner;

public class Smartphone {
    static boolean isClosed = false;
  static String answer;
  static Phone phoneOfChoice;

  public static void main(String[] args) {
    Phone IP13M = new Iphone();
    Phone Mi10Pro = new Xiaomi();

    Scanner input = new Scanner(System.in);

    System.out.println("--------- Pilih HP ---------");
    System.out.println("1. Xiaomi Mi 10 pro" );
    System.out.println("2. Iphone 13 Mini");
    System.out.println("-----------------------------");

    System.out.print("Pilih menu : ");
    answer = input.next();

    switch(answer) {
      case "1":
        phoneOfChoice = Mi10Pro;
        break;
      case "2":
        phoneOfChoice = IP13M;
        break;
      default:
        System.out.println("Wrong input number");
    }

    PhoneUser sam = new PhoneUser(phoneOfChoice);

    while(!isClosed) {
      System.out.println("--------- Main Menu ---------");
      System.out.println("1. Nyalakan Handphone");
      System.out.println("2. Matikan Handphone");
      System.out.println("3. Perbesar Volume");
      System.out.println("4. Perkecil Volume");
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


interface Phone {
  int MAX_VOLUME = 100;
  int MIN_VOLUME = 0;

void powerOn();
  void powerOff();
  void volumeUp();
  void volumeDown();
}

class PhoneUser {
  Phone phone;

  public PhoneUser(Phone phone) {
    this.phone = phone;
  }

  void turnOn() {
    phone.powerOn();
  }

  void turnOff() {
    phone.powerOff();
  }

  void makeFullVolume() {
    phone.volumeUp();
  }

  void makeSilentVolume() {
    phone.volumeDown();
  }
}

class Iphone implements Phone {
  int volume;
  boolean isPower;

  public Iphone() {
    volume = 50;
  }

  public String getString() {
    return "Iphone";
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
    System.out.println("HP Mati");
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


class Xiaomi implements Phone {
  int volume;
  boolean isPower;

  public Xiaomi() {
    volume = 50;
  }

  public String getString() {
    return "Xiaomi";
  }

  @Override
  public void powerOn() {
    isPower = true;
    System.out.println("Booting");
    System.out.println("xiaomi-panangan-nuju-salaman.gif");
  }

  @Override
  public void powerOff() {
    isPower = false;
    System.out.println("HP Mati");
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
