package adventuregame2;

import java.util.Scanner;

public class Game {

    public Player player;
    public Location location;
    Scanner sc = new Scanner(System.in);

    public void login() {
        System.out.println("Lütfen İsminizi Giriniz.");
        String playerName = sc.nextLine();
        player = new Player(playerName);
        player.selectChar();
        start();
    }

    public void start() {
        System.out.println("Amacınız Hayatta Kalmak İçin Belli Lokasyonlardaki"
                + " Temel Malzemeleri"
                + " Elde Etmek. Başarılar!");
        while (true) {
            System.out.println("----------------------------------------");
            System.out.println();
            System.out.println("Yapmak İstediğiniz Eylemi Seçiniz.");
            System.out.println("1-Güvenli Ev");
            System.out.println("2-Mağaza");
            System.out.println("3-Fabrika --> Zombi Çıkabilir.");
            System.out.println("4-Göl --> Kurtadam Çıkabilir.");
            System.out.println("5-Zindan --> Vampir Çıkabilir.");
            int choice = sc.nextInt();
            while (choice < 1 || choice > 5) {
                System.out.println("Lütfen Doğru Aralıkta Seçim Yapınız.");
                choice = sc.nextInt();
            }
            switch (choice) {
                case 1:
                    location = new safeHouse(player);
                    break;
                case 2:
                    location = new Store(player);
                    break;
                case 3:
                    location = new Factory(player);
                    break;
                case 4:
                    location = new Lake(player);
                    break;
                case 5:
                    location = new Dungeon(player);
                    break;
                default:
                    location = new safeHouse(player);
                    break;
            }
        if(location.getClass().getName().equals("safeHouse")){
        if(player.getInv().isFood() == true &&
        player.getInv().isWater() == true &&
        player.getInv().isFireLighter() == true){
            System.out.println("Tebrikler Oyunu Bitirdiniz!"); 
            break;
        }
        }
         if(!location.getLocation()){
          System.out.println("Oyun Bitti !");
       break;
      }
        }
        }        
    }

