package com.company;

public class Coal extends BattleLoc {
    public Coal(Player player, int damage, int award) {
        super(player,"Maden", new Snake(damage, award),"Para, Silah veya Zırh",5);
    }
}
