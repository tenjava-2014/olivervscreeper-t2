package com.tenjava.entries.olivervscreeper.t2.curses;

import com.tenjava.entries.olivervscreeper.t2.utils.ChatUtils;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Created on 12/07/2014.
 *
 * @author OliverVsCreeper
 */
public class BlindnessCurse extends Curse{

    @Override
    public void performCurse(Player toCurse) {
        ChatUtils.sendMSG(toCurse, "Fate covers you in darkness!");
        toCurse.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,600,1));
    }

    @Override
    public int getChance() {return 24;}
}
