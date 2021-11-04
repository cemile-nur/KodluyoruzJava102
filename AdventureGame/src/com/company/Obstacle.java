package com.company;

import java.util.Random;

public class Obstacle {
    private int id;
    private int damage;
    private int health;
    private String name;
    private int award;
    private  int orijinalHealth;


    public  Obstacle(int id, String name, int damage,int health, int award){
        this.id=id;
        this.damage=damage;
        this.health=health;
        this.name= name;
        this.award=award;
        orijinalHealth= health;
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
        if (health < 0){
            health=0;
        }
        this.health = health;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAward() {
        if (getId()==4){
            rand();
        }
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getOrijinalHealth() {
        return orijinalHealth;
    }

    public void setOrijinalHealth(int orjinalHealth) {
        this.orijinalHealth = orjinalHealth;
    }
    public int snakeAward(){
        Random randomSnakeAward = new Random();
        return randomSnakeAward.nextInt(100);
    }
    public int snakePresent(){
        Random randomSnakePresent = new Random();
        return randomSnakePresent.nextInt(100);
    }

    public void rand(){
        int randomSnakeAward = snakeAward();
        int randomSnakePresent = snakePresent();
        if (randomSnakeAward>=0 && randomSnakeAward<16){
            if (randomSnakePresent>=0 && randomSnakePresent<21){
                System.out.println("Tüfek Kazandın");
            }else if (randomSnakePresent>=21 && randomSnakePresent<51){
                System.out.println("Kılıç Kazandın");
            }else if (randomSnakePresent>=51){
                System.out.println("Tabanca Kazandın");
            }
        }
        if (randomSnakeAward>=16 && randomSnakeAward<31){
            if (randomSnakePresent>=0 && randomSnakePresent<21){
                System.out.println("Ağır Zırh Kazandın");
            }else if (randomSnakePresent>=21 && randomSnakePresent<51){
                System.out.println("Orta Zırh Kazandın");
            }else if (randomSnakePresent>=51){
                System.out.println("Hafif Zırh Kazandın");
            }
        }
        if (randomSnakeAward>=31 && randomSnakeAward<56){
            if (randomSnakePresent>=0 && randomSnakePresent<21){
                System.out.println("\n10 Para Kazandın !!! ");
            }else if (randomSnakePresent>=21 && randomSnakePresent<51){
                System.out.println("\n5 Para Kazandın !!! ");
            }else if (randomSnakePresent>=51){
                System.out.println("\n1 Para Kazandın !!! ");
            }
        }
        if (randomSnakeAward>=56 ){
            System.out.println("\nHiçbir şey kazanamadın!!!! :( ");
        }
    }
}
