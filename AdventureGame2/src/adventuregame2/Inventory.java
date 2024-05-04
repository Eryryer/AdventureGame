package adventuregame2;

public class Inventory {

    private boolean Food, Water, FireLighter;
    private String wName, aName;
    private int damage, armor;

    Inventory() {
        this.Food = false;
        this.Water = false;
        this.FireLighter = false;
        this.damage = 0;
        this.armor = 0;
        this.wName = null;
        this.aName = null;
    }

    public boolean isFood() {
        return Food;
    }

    public void setFood(boolean Food) {
        this.Food = Food;
    }

    public boolean isWater() {
        return Water;
    }

    public void setWater(boolean Water) {
        this.Water = Water;
    }

    public boolean isFireLighter() {
        return FireLighter;
    }

    public void setFireLighter(boolean FireLighter) {
        this.FireLighter = FireLighter;
    }

    public String getwName() {
        return wName;
    }

    public void setwName(String wName) {
        this.wName = wName;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }
}
