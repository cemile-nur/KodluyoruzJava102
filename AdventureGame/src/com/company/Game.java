package com.company;

<<<<<<< HEAD:AdventureGame/src/com/company/Game.java
=======
import java.util.InputMismatchException;
>>>>>>> 46e7a26e3f5cb91589681f884f7d6d71bcfc7168:src/com/company/Game.java
import java.util.Random;
import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);
    private int snakePresent ;

    public void start(){

        System.out.println("Macera oyununa hoşgeldiniz !");
        System.out.print("Lütfen bir isim giriniz : ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println("Sayın " + player.getName() + " bu sanal aleme hoşgeldiniz!  ");
        System.out.println("Lütfen bir karakter seçiniz ! ");
        player.selectChar();

        while (true){
            player.printInfo();
            System.out.println("---Bölgeler---");
            System.out.println("1 - Güvenli Ev\n2 - Dükkan\n3 - Mağara\n4 - Orman\n5 - Nehir\n6 - Maden\n0 - Çıkış Yap");
            int locationChoice = 0;
            boolean isChoiceValid  = false;
            boolean isAvailableLocation;

            Location location = null;
            do {
                isAvailableLocation = true;
                try {
                    System.out.print("Gitmek istediğiniz yeri seçiniz: ");
                    locationChoice = input.nextInt();

                    if (locationChoice == 3 && player.getInventory().isFood()){
                        isAvailableLocation = false;
                    }else if (locationChoice == 4 && player.getInventory().isFirewood()){
                        isAvailableLocation = false;
                    }else if (locationChoice == 5 && player.getInventory().isWater()) {
                        isAvailableLocation = false;
                    }

<<<<<<< HEAD:AdventureGame/src/com/company/Game.java
                case 5:
                    location=new Forest(player);
                    break;
                case 6:
                    location=new Coal(player,snake(), snakePresent);
                    break;
                default:
                    System.out.println("Lütfen geçerli bir bölge giriniz");
            }
=======
                    System.out.println();
                    if (isAvailableLocation) {
                        switch (locationChoice) {
                            case 0:
                                isChoiceValid = true;
                                break;
                            case 1:
                                location = new SafeHouse(player);
                                isChoiceValid = true;
                                break;
                            case 2:
                                location = new ToolStore(player);
                                isChoiceValid = true;
                                break;
                            case 3:
                                location = new Cave(player);
                                isChoiceValid = true;
                                break;
                            case 4:
                                location = new Forest(player);
                                isChoiceValid = true;
                                break;
                            case 5:
                                location = new River(player);
                                isChoiceValid = true;
                                break;
                            case 6:
                                location = new Coal(player);
                                isChoiceValid = true;
                                break;
                            default:
                                System.out.println("Geçerli bir bölge seçiniz!");
                        }
                    }else {
                        System.out.println("Bu bölgeyi temizlediniz.Buraya tekrar giremezsiniz.");
                    }
                } catch(InputMismatchException | NullPointerException e){
                    System.out.println("Bir rakam giriniz");
                }
                input.nextLine();
            }while(!isChoiceValid);
>>>>>>> 46e7a26e3f5cb91589681f884f7d6d71bcfc7168:src/com/company/Game.java

            if (location.getName().toLowerCase().equals("güvenli ev") && !location.onLocation()){
                return;
            }

            if (location == null || !location.onLocation()){
                System.out.println("Oyun bitti!");
                return;
            }
        }
    }
    public int snake(){
        Random randomSnakeDamage = new Random();
        return randomSnakeDamage.nextInt(3) + 3; // Random 3-6 arası sayı üret
    }

}