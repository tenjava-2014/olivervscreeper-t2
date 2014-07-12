package com.tenjava.entries.olivervscreeper.t2.curses;

import com.tenjava.entries.olivervscreeper.t2.utils.ChatUtils;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

/**
 * Created on 12/07/2014.
 *
 * @author OliverVsCreeper
 */
public class MobCurse extends Curse{

    @Override
    public void performCurse(Player toCurse) {
        toCurse.getWorld().spawnEntity(toCurse.getLocation(), EntityType.MAGMA_CUBE);
        ChatUtils.sendMSG(toCurse, "Uh oh! Your bad magic has summoned lava's finest weapon.");
    }

    @Override
    public int getChance() {
        return 48;
    }
}
