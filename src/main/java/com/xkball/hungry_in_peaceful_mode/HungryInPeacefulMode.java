package com.xkball.hungry_in_peaceful_mode;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = HungryInPeacefulMode.MODID, name = HungryInPeacefulMode.NAME, version = HungryInPeacefulMode.VERSION)
public class HungryInPeacefulMode
{
    public static final String MODID = "hungry_in_peaceful_mode";
    public static final String NAME = "Hungry In Peaceful Mode";
    public static final String VERSION = "0.1";
    
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        Logger logger = event.getModLog();
        logger.info("The HungryInPeacefulMode Mod loading");
    }

    
}
