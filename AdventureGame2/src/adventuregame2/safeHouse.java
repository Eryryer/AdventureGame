
package adventuregame2;

public class safeHouse extends SafeLocation{
    safeHouse(Player player){
    super(player,"Güvenli Ev");
    
    }
    @Override
    public boolean getLocation(){
        player.setHealth(player.getrHealth());
        System.out.println("Şu an Güvenli Evdesiniz.Canınız Yenileniyor.");
        System.out.println("İyileştiniz !!");       
        if(player.getInv().isFood() == true && 
                player.getInv().isWater() == true && 
                player.getInv().isFireLighter() == true){
            System.out.println("Tebrikler "+player.getName()+" "+player.getcName()+
                    " Sınıfı Karakterinle Hayatta Kalmak İçin Gereken"
                    + " Tüm Malzemeleri Topladın!");
        }
         return true;
    }
}
