package com.company;

import java.util.Scanner;

public class Player {

    private int damage;
    private int health;
    private int money;
    private int orjinalHealth;
    private  String charName;
    private String name;
    private Scanner input = new Scanner(System.in);
    private Inventory inventory;

    public  Player(String name){

        this.name=name;
        this.inventory= new Inventory();
   }

   public void selectChar(){
       GameChar[] charList= {new Samurai(), new Archer(), new Knight()};
       System.out.println("Karakterler");
       System.out.println("*****************");

       for (GameChar gameChar:charList) {
           System.out.println("Id: " + gameChar.getId() +
                   "\t Karakter: " + gameChar.getName() +
                   "\t Hasar: " + gameChar.getDamage() +
                   "\t Sağlık: " + gameChar.getHealth() +
                   "\t Para: " + gameChar.getMoney());
       }
       System.out.println("*****************");
       System.out.println("Karakter Seçiniz: ");
       int selectChar = input.nextInt();
       switch(selectChar){
           case 1:
               initPlayer(new Samurai());
               break;
           case 2:
               initPlayer(new Archer());
               break;
           case 3:
               initPlayer(new Knight());
               break;
           default:
               initPlayer(new Samurai());
       }
       System.out.println("Karakteriniz : " + this.getName() );
   }

   public void initPlayer(GameChar gameChar){
        this.setName(gameChar.getName());
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setOrjinalHealth(gameChar.getHealth());
   }

   public void  printInfo(){
        System.out.println(
                "Silahınız : " + this.getInventory().getWeapon().getName() +
                ", Zırhınız : " + this.getInventory().getArmor().getName() +
                ", Bloklama : " + this.getInventory().getArmor().getBlock() +
                ", Hasarınız : " + this.getTotalDamage() +
                ", Sağlık : " + this.getHealth() +
                ", Para : " + this.getMoney() +
                ", Ödüllerin : " + this.getInventory().isFullAwards());
   }

   public  int getTotalDamage(){
       return damage + this.getInventory().getWeapon().getDamage();
   }

   public int getDamage() {

   return damage;
    }

    public void setDamage(int damage){
        this.damage=damage;
    }
    public int getHealth() {

        return health;
    }

    public void setHealth(int health){
        if(health < 0){
            health=0;
        }
        this.health=health;
    }
    public int getMoney() {

        return money;
    }

    public void setMoney(int money){
        this.money=money;
    }

    public String getName() {

        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Weapon getWeapon(){
        return this.getInventory().getWeapon();
    }

    public int getOrjinalHealth() {
        return orjinalHealth;
    }

    public void setOrjinalHealth(int orjinalHealth) {
        this.orjinalHealth = orjinalHealth;
    }
}

