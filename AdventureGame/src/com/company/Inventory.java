package com.company;

public class Inventory {

    private Weapon weapon;
    private Armor armor;
    private String awardWin;
    private boolean food;
    private boolean firewood;
    private boolean water;

    public Inventory( ){
        this.weapon= new Weapon("Yumruk",-1,0,0);
        this.armor= new Armor(-1,"Zırh Yok",0,0);
        this.awardWin=getAwardWin();
        food = false;
        firewood = false;
        water = false;
    }

    public boolean isFullAwards(){
        return (isFood() && isFirewood() && isWater());
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public String getAwardWin() {

        return awardWin;
    }

    public void setAwardWin(String awardWin) {

        this.awardWin = awardWin;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isFirewood() {
        return firewood;
    }

    public void setFirewood(boolean firewood) {
        this.firewood = firewood;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }
}
