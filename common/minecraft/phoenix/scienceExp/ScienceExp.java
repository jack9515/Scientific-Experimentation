package minecraft.phoenix.scienceExp;

import java.io.File;
import minecraft.phoenix.scienceExp.blocks.Blocks;
import minecraft.phoenix.scienceExp.handler.ConfigurationHandler;
import minecraft.phoenix.scienceExp.handler.LocalizationHandler;
import minecraft.phoenix.scienceExp.items.Items;
import minecraft.phoenix.scienceExp.lib.Reference;
import minecraft.phoenix.scienceExp.proxy.CommonProxy;
import minecraft.phoenix.scienceExp.util.WorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Scientific Experimentation Mod
 * 
 * @author jack9515
 *
 **/

@Mod(modid=Reference.modid, name=Reference.name, version=Reference.version)
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class ScienceExp
{
	// The instance of your mod that Forge uses.
    @Instance(Reference.modid)
    public static ScienceExp instance;
    
    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide=Reference.ClientProxy, serverSide=Reference.CommonProxy)
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	//Registering the ore generator - This has to go inside here, I don't know why
		GameRegistry.registerWorldGenerator(new WorldGenerator());
    	
    	//Loading language files
		LocalizationHandler.loadLanguages();
		
		//Loading the configuration Hanlder
		ConfigurationHandler.init(new File(event.getModConfigurationDirectory().getAbsolutePath() + File.separator + Reference.modid + File.separator + Reference.modid + ".cfg"));
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	//Registering things
    	CommonProxy.registerThings();
    	
    	//Initialising the Core Items
	    Items.init();   
	    
	    //Initialising the Core Blocks
	    Blocks.init();
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}
