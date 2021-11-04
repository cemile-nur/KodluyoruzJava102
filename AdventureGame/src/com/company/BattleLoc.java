package com.company;

import java.util.Locale;
import java.util.Random;

public abstract class BattleLoc extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;


    public BattleLoc(Player player, String name, Obstacle obstacle,String award,int maxObstacle){
        super(player, name);
        this.obstacle=obstacle;
        this.award=award;
        this.maxObstacle=maxObstacle;
    }

    @Override
    public boolean onLocation() {
<<<<<<< HEAD:AdventureGame/src/com/company/BattleLoc.java
        int obsNumber = this.randomObstacleNumber();
        System.out.println("Şuan Buradasınız : " + this.getName());
        System.out.println("Dikkatli ol ! Burada " + obsNumber+ " tane "  + this.getObstacle().getName() + " yaşıyor !" );
        System.out.print("<S>avaş ya da <K>aç : ");
        String selectCase =input.nextLine().toUpperCase();

            if (selectCase.equals("S") && combat(obsNumber)) {
                System.out.println(this.getName() + " düşmanlarını yendiniz ! Bu Bölgeden kazandığın ödül: " + this.getAward() +
                        "\n----------------------------");
                return true;

            }
                if (this.getPlayer().getHealth() <= 0) {
                System.out.println("Öldünüz !");
                return false;
            }
=======
        int obsNumber =randomObstacleNumber();
        System.out.println("Şuan "+this.getName()+" bölgesindesin. "+
                "\nDikkatli ol! Burada "+obsNumber+" tane "+this.getObstacle().getName()+" yaşıyor!" +
                "\n[S] Savaş " + "\n[K] Kaç");

        String selectCase = input.nextLine().toUpperCase();
        if (selectCase.equals("S") && combat(obsNumber)){
            System.out.println(this.getName() + " bölgesindeki tüm "+this.getObstacle().getName()+" yendiniz \n");
>>>>>>> 46e7a26e3f5cb91589681f884f7d6d71bcfc7168:src/com/company/BattleLoc.java
            return true;
        }
        if (this.getPlayer().getHealth() <= 0){
            System.out.println("!!! ÖLDÜNÜZ !!!");
            return false;
        }
        return true;
    }

    public boolean combat(int obsNumber){
<<<<<<< HEAD:AdventureGame/src/com/company/BattleLoc.java
        for (int i=1 ; i <= obsNumber; i++){ //kaç canavarla savaşacağımızın döngüsü.
            this.getObstacle().setHealth(this.getObstacle().getOrijinalHealth());
=======
        for (int i=1 ; i <= obsNumber;i++){ //kaç canavarla savaşacağımızın döngüsü.
            this.getObstacle().setHealth(this.getObstacle().getOrjinalHealth());
>>>>>>> 46e7a26e3f5cb91589681f884f7d6d71bcfc7168:src/com/company/BattleLoc.java
            playerStats();
            obstacleStats(i);
            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0){
                System.out.print("[V] Vur & [K] Kaç    ");
                String selectCombat = input.nextLine().toUpperCase();
                if (selectCombat.equals("V")){
                    firstStrike();
                    System.out.println("Siz vurdunuz !");
                    this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                    afterHit();
                    if (this.getObstacle().getHealth()>0) {
                        System.out.println("\n" + this.getObstacle().getName() + " size vurdu!");
                        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if (obstacleDamage < 0) {
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                        afterHit();
                    }
                }else {
                    return false;
                }
            }
            if (this.getObstacle().getHealth() < this.getPlayer().getHealth()){
<<<<<<< HEAD:AdventureGame/src/com/company/BattleLoc.java
                System.out.println(this.getObstacle().getName()+" Yendin !\n" +
                        this.getObstacle().getAward() + " kazandın !");
                System.out.println("Güncel para miktarınız: "+this.getPlayer().getMoney());
=======
                System.out.println(this.getObstacle().getName()+" Yendin !\n");
                if (this.getObstacle().getId() != 4) {
                    System.out.println(this.getObstacle().getAward() + " para kazandın !");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                    System.out.println("Güncel para miktarınız: " + this.getPlayer().getMoney());
                }else {
                    obstacle.getAward();
                }
>>>>>>> 46e7a26e3f5cb91589681f884f7d6d71bcfc7168:src/com/company/BattleLoc.java
            }else{
                return false;
            }
        }
        switch (this.getAward().toLowerCase()) {
            case "su" -> this.getPlayer().getInventory().setWater(true);
            case "yemek" -> this.getPlayer().getInventory().setFood(true);
            case "odun" -> this.getPlayer().getInventory().setFirewood(true);
        }
        if (!this.getName().equals("Maden")) {
            System.out.println(this.getAward().toUpperCase() + " ödülü alındı.");
        }
        return true;
    }

    public void afterHit(){
        System.out.println("Canınız : " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " Canı : " + this.getObstacle().getHealth());
        System.out.println("----------------");
    }
    public void obstacleStats(int i) {
        System.out.println(i + ". " + this.getObstacle().getName() + " Değerleri");
        System.out.println("---------------------------------");
        System.out.println("Sağlık : " + this.getObstacle().getHealth());
        System.out.println("Hasar :" + this.getObstacle().getDamage());
    }

    public void playerStats(){
        System.out.println("Oyuncu Değerleri");
        System.out.println("------------------------- ");
        System.out.println("Sağlık : " + this.getPlayer().getHealth());
        System.out.println("Silah : " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Zırh : " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Hasar : " + this.getPlayer().getTotalDamage());
        System.out.println("Bloklama : " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Para : " + this.getPlayer().getMoney());
    }

   public int randomStrikeChange(){
        Random r =new Random();
        return r.nextInt(3) + 3 ;

   }
    public void firstStrike() {
        int randomStrike = randomStrikeChange();
        if (randomStrike == 1) {
            System.out.println("İlk Vuruş Size Ait");
            this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
            afterHit();
<<<<<<< HEAD:AdventureGame/src/com/company/BattleLoc.java
            System.out.println("\n" + this.getObstacle().getName() + " size vurdu!");
            int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
            if (obstacleDamage < 0) {
                obstacleDamage = 0;
=======
            if (this.getObstacle().getHealth() > 0) {
                System.out.println("\n" + this.getObstacle().getName() + " size vurdu!");
                int monsterDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                if (monsterDamage < 0) {
                    monsterDamage = 0;
                }
                this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
                afterHit();
            } else if (this.getObstacle().getHealth() < 0) {
                if (this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
                    System.out.println(this.getObstacle().getName() + " Yendin !\n" +
                            this.getObstacle().getAward() + " kazandın !");
                }
>>>>>>> 46e7a26e3f5cb91589681f884f7d6d71bcfc7168:src/com/company/BattleLoc.java
            }
            if (randomStrike == 2) {
                System.out.println("İlk Vuruş Düşmana Ait");
                int monsterDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                if (monsterDamage < 0) {
                    monsterDamage = 0;
                }
                this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
                afterHit();
            }
        }
    }
    public int randomObstacleNumber(){
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

}
