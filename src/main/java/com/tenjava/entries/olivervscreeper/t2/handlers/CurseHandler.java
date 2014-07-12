package com.tenjava.entries.olivervscreeper.t2.handlers;

import com.tenjava.entries.olivervscreeper.t2.curses.*;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created on 12/07/2014.
 *
 * @author OliverVsCreeper
 */
public class CurseHandler {

    public static List<Curse> Curses = new ArrayList<Curse>();

    public static void loadCurses(){
        Curses.add(new BlindnessCurse());
        Curses.add(new LightningCurse());
        Curses.add(new MobCurse());
        Curses.add(new BlastCurse());
        Curses.add(new BatCurse());
    }

    public static void attemptCurse(Player toCurse){
        for(Curse currentCurse : Curses){
            if(!shouldPerform(currentCurse.getChance())) continue;
            currentCurse.performCurse(toCurse);
            return;
        }
    }

    public static Boolean shouldPerform(int chance){
        Random rand = new Random();
        int result = rand.nextInt(chance);
        if(result == 1){ return true;}
        return false;
    }


}
