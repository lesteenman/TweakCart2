/*
 * Copyright (c) 2012. 
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package net.tweakcraft.tweakcart.api;

import net.tweakcraft.tweakcart.TweakCart;
import net.tweakcraft.tweakcart.TweakPluginManager;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Edoxile
 */
public abstract class TweakCartPlugin extends JavaPlugin {
    TweakCart tweakCart;
    public TweakPluginManager pluginManager = TweakPluginManager.getInstance();

    public void onEnable() {
        Plugin p = getServer().getPluginManager().getPlugin("TweakCart");
        if (p != null && p instanceof TweakCart) {
            tweakCart = (TweakCart) p;
        }
        registerEvents(pluginManager);
        log(getPluginName() + " enabled!");
    }

    public void onDisable() {
        log(getPluginName() + " disabled!");
    }

    public abstract String getPluginName();

    public abstract void registerEvents(TweakPluginManager pluginManager);

    public void log(String message) {
        tweakCart.log(message);
    }

    public void log(String message, Level level) {
        tweakCart.log(message, level);
    }
}
