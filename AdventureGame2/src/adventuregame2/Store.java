package adventuregame2;

public class Store extends SafeLocation {

    Store(Player player) {
        super(player, "Mağaza");
       
    }

    @Override
    public boolean getLocation() {
        System.out.println("Para : " + player.getMoney());
        System.out.println("1-Silahlar");
        System.out.println("2-Zırhlar");
        System.out.println("3-Çıkış");
        System.out.println("Seçiminiz:");
        int choice = sc.nextInt();
        int selItemID;
        while (choice < 1 || choice > 3) {
            System.out.println("Lütfen Doğru Seçeneği Seçiniz.");
            choice = sc.nextInt();
        }
        switch (choice) {
            case 1:
                selItemID = weaponMenu();
                buyWeapon(selItemID);
                break;
            case 2:
                selItemID = armorMenu();
                buyArmor(selItemID);
                break;
            case 3:
                return true;
            default:
                break;
        }
      
        return true;
    }


    public void buyWeapon(int itemID) {
        int damage = 0, price = 0;
        String wName = null;
        switch (itemID) {
            case 1:
                damage = 3;
                wName = "Demir Boru";
                price = 25;
                break;
            case 2:
                damage = 6;
                wName = "Kılıç";
                price = 35;
                break;
            case 3:
                damage = 8;
                wName = "Tabanca";
                price = 45;
                break;
            case 4:
                System.out.println("Çıkış Yapılıyor");
                break;
            default:
                System.out.println("Geçersiz İşlem !");
                break;
        }
        if(price > 0){
        if(player.getMoney() >= price){
        player.getInv().setDamage(damage);
        player.getInv().setwName(wName);
        player.setMoney(player.getMoney()-price);
            System.out.println(player.getInv().getwName()+" Satın Aldınız."
                    + "Yeni Hasarınız : "+player.getTotalDamage());
            System.out.println("Kalan Para : "+player.getMoney());
        }else {
            System.out.println("Yetersiz Bakiye!");
            System.out.println("Menüye Yönlendiriliyorsunuz.");
        }
        }
    }

    public void buyArmor(int itemID) {
        int armor = 0, price = 0;
        String aName = null;
        switch (itemID) {
            case 1:
                armor = 1;
                aName = "Hafif Zırh";
                price = 25;
                break;
            case 2:
                armor = 2;
                aName = "Orta Zırh";
                price = 35;
                break;
            case 3:
                armor = 3;
                aName = "Ağır Zırh";
                price = 45;
                break;
            case 4:
                System.out.println("Çıkış Yapılıyor.");
                break;
            default:
                System.out.println("Geçersiz İşlem !");
                break;
        }
        if (price > 0) {
            if (player.getMoney() >= price) {
player.getInv().setArmor(armor);
player.getInv().setaName(aName);
player.setMoney(player.getMoney()-price);
                System.out.println(player.getInv().getaName()+
                        " Satın Aldınız. Engellenen Hasar :"+
                        player.getInv().getArmor());
                System.out.println("Kalan Para : "+player.getMoney());
            }else{
                System.out.println("Yetersiz Bakiye!");
                System.out.println("Menüye Yönlendiriliyorsunuz.");
               
            }
        }
    }

    public int armorMenu() {
        System.out.println("1-Hafif Zırh \t Blok : 1 \t Para : 25");
        System.out.println("2-Orta Zırh \t Blok : 2 \t Para : 35");
        System.out.println("3-Ağır Zırh \t Blok : 3 \t Para : 45");
        System.out.println("4-Çıkış");
        int choice = sc.nextInt();
        while (choice < 1 || choice > 4) {
            System.out.println("Lütfen Doğru Aralıkta Seçiniz.");
            choice = sc.nextInt();
        }
        return choice;
    }

    public int weaponMenu() {
        System.out.println("1-Demir Boru \t Hasar : 3 \t Para : 25");
        System.out.println("2-Kılıç \t Hasar : 6 \t Para : 35");
        System.out.println("3-Tabanca \t Hasar : 8 \t Para : 45");
        System.out.println("4-Çıkış");
        int choice = sc.nextInt();
        while (choice < 1 || choice > 4) {
            System.out.println("Lütfen Doğru Aralıkta Seçiniz.");
            choice = sc.nextInt();
        }
        return choice;
    }
}
