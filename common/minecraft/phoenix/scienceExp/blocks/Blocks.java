package minecraft.phoenix.scienceExp.blocks;

import java.util.Random;
import minecraft.phoenix.scienceExp.lib.BlockIds;
import minecraft.phoenix.scienceExp.lib.Strings;
import minecraft.phoenix.scienceExp.util.CustomOre;
import minecraft.phoenix.scienceExp.util.WorldGenerator;
import net.minecraft.block.Block;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Scientific Experimentation Mod
 * 
 * @author jack9515
 * 
 */
public class Blocks
{
	private static Random rand = new Random();
	
	//Initialising Blocks
	public static final Block copperOre	= new CustomOre(Strings.COPPER_ORE, BlockIds.BlockID_CopperOre).setHardness(3.0F).setResistance(5.0F);
	public static final Block leadOre = new CustomOre(Strings.LEAD_ORE, BlockIds.BlockID_LeadOre).setHardness(3.0F).setResistance(5.0F);
	public static final Block tungstenOre = new CustomOre(Strings.TUNGSTEN_ORE, BlockIds.BlockID_TungstenOre).setHardness(3.0F).setResistance(5.0F);
	public static final Block siliconOre = new CustomOre(Strings.SILICON_ORE, BlockIds.BlockID_SiliconOre).setHardness(3.0F).setResistance(5.0F);
	public static final Block iridiumOre = new CustomOre(Strings.IRIDIUM_ORE, BlockIds.BlockID_IridiumOre).setHardness(3.0F).setResistance(5.0F);
	public static final Block magnetiteOre = new CustomOre(Strings.MAGNETITE_ORE, BlockIds.BlockID_MagnetiteOre).setHardness(3.0F).setResistance(5.0F);
	public static final Block aluminiumOre = new CustomOre(Strings.ALUMINIUM_ORE, BlockIds.BlockID_AluminiumOre).setHardness(3.0F).setResistance(5.0F);
	public static final Block tinOre = new CustomOre(Strings.TIN_ORE, BlockIds.BlockID_TinOre).setHardness(3.0F).setResistance(5.0F);
	public static final Block titaniumOre = new CustomOre(Strings.TITANIUM_ORE, BlockIds.BlockID_TitaniumOre).setHardness(3.0F).setResistance(5.0F);
	
	
    /**
     * Adding all blocks to the game
     */
	public static void init()
	{
		//Registering Ores
		registerOre(copperOre, Strings.COPPER_ORE, 10, 20 + rand.nextInt(2), 1, 64);
		registerOre(leadOre, Strings.LEAD_ORE, 10, 20 + rand.nextInt(2), 1, 64);
		registerOre(tungstenOre, Strings.TUNGSTEN_ORE, 10, 20 + rand.nextInt(2), 1, 64);
		registerOre(siliconOre, Strings.SILICON_ORE, 10, 30 + rand.nextInt(5), 1, 64);
		registerOre(iridiumOre, Strings.IRIDIUM_ORE, 10, 1 + rand.nextInt(2), 1, 20);
		registerOre(magnetiteOre, Strings.MAGNETITE_ORE, 10, 30 + rand.nextInt(5), 1, 64);
		registerOre(aluminiumOre, Strings.ALUMINIUM_ORE, 10, 20 + rand.nextInt(2), 1, 64);
		registerOre(tinOre, Strings.TIN_ORE, 10, 20 + rand.nextInt(2), 1, 64);
		registerOre(titaniumOre, Strings.TITANIUM_ORE, 10, 20 + rand.nextInt(2), 1, 64);
	}
	
	/**
	 * 
	 * @param ore The ore to register
	 * @param name The ores name
	 * @param dictionaryName The name for the ore dictionary
	 * @param maxVeinSize
	 * @param chancesToSpawn
	 * @param minY The minimum Y-value that this ore will spawn at
	 * @param maxY The maximum Y-value that this ore will spawn at
	 */
	public static void registerOre(Block ore, String name, int maxVeinSize, int chancesToSpawn, int minY, int maxY)
	{
		GameRegistry.registerBlock(ore, name);
		OreDictionary.registerOre(name, ore);
		WorldGenerator.ores.add(new int[]{ore.blockID, maxVeinSize, chancesToSpawn, minY, maxY});
	}
}
