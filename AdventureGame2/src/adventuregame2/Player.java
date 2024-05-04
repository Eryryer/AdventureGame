package adventuregame2;

import java.util.Scanner;

public class Player {

    private String name, cName; //oyuncu ve karakter adı.
    private int damage, health, money, rHealth;
    private Inventory inv;
    Scanner sc = new Scanner(System.in);

    Player(String name) {
        this.name = name;
        this.inv = new Inventory();
    }

    public void selectChar() {
        switch (charMenu()) {
            case 1:
                expChar("Savaşçı", 6, 21, 15, 21);
                break;
            case 2:
                expChar("Suikastçı", 10, 12, 20, 12);
                break;
            case 3:
                expChar("Tank", 4, 45, 5, 45);
                break;
            case 4:
                expChar("Okçu", 8, 15, 30, 15);
                break;
            default:
                expChar("Savaşçı", 6, 21, 15, 21);
                break;
        }
        System.out.println("Sınıfınız : " + getcName() + " Hasar : " + getDamage()
                + " Sağlık : " + getHealth() + " Para : " + getMoney());
    }

    public int charMenu() {
        System.out.println("Lütfen İstediğiniz Sınıfı Seçiniz.");
        System.out.println("1-Savaşçı \t Hasar : 6 \t Sağlık: 21 \t Para: 15 ");
        System.out.println("2-Suikastçı \t Hasar : 10 \t Sağlık : 12 \t Para: 20 ");
        System.out.println("3- Tank \t Hasar : 4 \t Sağlık : 45 \t Para: 5 ");
        System.out.println("4-Okçu  \t Hasar :8 \t Sağlık : 15 \t Para : 30 ");
        System.out.println("Sınıf Seçiminiz");
        int choice = sc.nextInt();
        while (choice < 1 || choice > 4) {
            System.out.println("Lütfen Geçerli Bir Sınıf Seçiniz.");
            choice = sc.nextInt();
        }
        return choice;
    }
//Sınıf Açıklaması

    public void expChar(String cName, int damage, int health, int money, int rHealth) {
        setcName(cName);
        setDamage(damage);
        setHealth(health);
        setMoney(money);
        setrHealth(rHealth);
    }

    public int getTotalDamage() {

        return this.getDamage() + this.getInv().getDamage();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getrHealth() {
        return rHealth;
    }

    public void setrHealth(int rHealth) {
        this.rHealth = rHealth;
    }

    public Inventory getInv() {
        return inv;
    }

    public void setInv(Inventory inv) {
        this.inv = inv;
    }

}
