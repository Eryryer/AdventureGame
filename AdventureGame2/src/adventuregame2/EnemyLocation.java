package adventuregame2;

public abstract class EnemyLocation extends Location {

    public Obstacle obstacle;
    public String award;

    EnemyLocation(Player player, String name, Obstacle obstacle, String award) {
        super(player);
        this.name = name;
        this.obstacle = obstacle;
        this.award = award;

    }

    @Override
    public boolean getLocation() {
        int obsCount = obstacle.count();
        System.out.println("Şu An Buradasınız : " + getName());
        System.out.println("Burada " + obsCount + " Tane " + obstacle.getName() + " Yaşıyor.");
        System.out.println("|S|avaş Veya |K|aç");
        String input = sc.nextLine();
        input = input.toUpperCase();
        if (input.equals("S")) {
            if (combat(obsCount)) {
                System.out.println(this.getName()
                        + " Bölgesindeki Tüm Canavarları Temizlediniz.");
                if (this.award.equals("Food") && player.getInv().isFood() == false) {
                    System.out.println(this.award + " Kazandınız!");
                    player.getInv().setFood(true);
                } else if (this.award.equals("Water") && player.getInv().isWater() == false) {
                    System.out.println(this.award + " Kazandınız!");
                    player.getInv().setWater(true);
                } else if (this.award.equals("FireLighter") && player.getInv().isFireLighter() == false) {
                    System.out.println(this.award + " Kazandınız!");
                    player.getInv().setFireLighter(true);
                }
                return true;
            }
            if (player.getHealth() <= 0) {
                System.out.println("Öldünüz !");
                return false;
            }
        } 
        if (input.equals("K")) {
            System.out.println("Başarıyla Geri Çekildiniz.");
            return true;
        }
        System.out.println("İstenen Aralıkta Seçim Yapmadınız."
                + "Menüye Yönlendiriliyorsunuz.");
        return true;       
    }

    public boolean combat(int obsCount) {
        for (int i = 0; i < obsCount; i++) {
            int refreshObsHealth = obstacle.getHealth(); //canavarın canını ara bir değerde tuttuk.
            playerStats();
            enemyStats();
            while (player.getHealth() > 0 && obstacle.getHealth() > 0) {
                System.out.println("|V|ur Veya |K|aç");
                String input = sc.nextLine();
                input = input.toUpperCase();
                if (input.equals("V")) {
                    System.out.println("Düşmana Başarılı Bir Vuruş Gerçekleştirdin!");
                    obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
                    System.out.println("Düşmana Vurduğunuz Hasar : " + player.getTotalDamage());
                    afterHit();

                    if (obstacle.getHealth() > 0) {
                        System.out.println();
                        System.out.println("Canavar Size Vurdu!");
                        player.setHealth(player.getHealth() - (obstacle.getDamage() - player.getInv().getArmor()));
                        afterHit();
                    }

                } else {
                    break;
                }
            }
            if (obstacle.getHealth() <= 0 && player.getHealth() > 0) {
                System.out.println("Düşmanı Yendiniz!");
                player.setMoney(player.getMoney() + obstacle.getAward());
                System.out.println("Güncel Paranız : " + player.getMoney());
                obstacle.setHealth(refreshObsHealth);//canavar öldükten sonra başka canavar varsa canını yenilemek için bunu kullanıyoruz.yoksa diğer canavarın canı da 0 olur.
            } else {
                return false;
            }
            System.out.println("-------------------------------------");
        }
        return true;
    }

    public void playerStats() {
        System.out.println("\n" + player.getName() + " Adlı Oyuncunun Sınıfı "
                + player.getcName()
                + " Olan Karakterinin Değerleri\n-----------------");
        System.out.println("Can :" + player.getHealth());
        System.out.println("Hasar : " + player.getTotalDamage());
        System.out.println("Para : " + player.getMoney());
        if (player.getInv().getDamage() > 0) {
            System.out.println("Kullandığınız Silah : " + player.getInv().getwName());
        }
        if (player.getInv().getArmor() > 0) {
            System.out.println("Kuşandığınız Zırh : " + player.getInv().getaName());
        }
    }

    public void enemyStats() {
        System.out.println("\n" + obstacle.getName()
                + " Değerleri\n------------------");
        System.out.println("Can : " + obstacle.getHealth());
        System.out.println("Hasar : " + obstacle.getDamage());
        System.out.println("Kazandırdığı Para : " + obstacle.getAward());
    }

    public void afterHit() {
        System.out.println("Oyuncunun Canı : " + player.getHealth());
        System.out.println(obstacle.getName() + "'nın Canı : "
                + obstacle.getHealth());
        System.out.println();
    }
}
