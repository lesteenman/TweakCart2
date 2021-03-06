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

package net.tweakcraft.tweakcart;

import net.tweakcraft.tweakcart.listeners.TweakCartBlockListener;
import net.tweakcraft.tweakcart.listeners.TweakCartPlayerListener;
import net.tweakcraft.tweakcart.listeners.TweakCartVehicleListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;
import java.util.logging.Logger;


public class TweakCart extends JavaPlugin {
    private static Logger logger = Logger.getLogger("Minecraft");
    private TweakCartVehicleListener vehicleListener;
    private TweakCartBlockListener blockListener;
    private TweakCartPlayerListener playerListener;

    @Override
    public void onDisable() {
        // TODO Auto-generated method stub

    }

    @Override
    public void onEnable() {
        log(String.format("Enabling! Version: %s", this.getDescription().getVersion()));
        // Initialising variables
        vehicleListener = new TweakCartVehicleListener();
        blockListener = new TweakCartBlockListener();
        playerListener = new TweakCartPlayerListener();
        // Load pluginManager and register events
        PluginManager pm = getServer().getPluginManager();        
        pm.registerEvents(vehicleListener, this);
        pm.registerEvents(blockListener, this);
        pm.registerEvents(playerListener, this);
        
        //pm.registerEvent(Event.Type.REDSTONE_CHANGE, blockListener, Event.Priority.Normal, this);
    }

    public void log(String info, Level level) {
        logger.log(level, "[TweakCart] " + info);
    }

    public void log(String info) {
        log(info, Level.INFO);
    }
    
    public TweakPluginManager getPluginManager(){
        return TweakPluginManager.getInstance();
    }
}
