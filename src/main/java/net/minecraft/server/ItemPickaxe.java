package net.minecraft.server;
import com.google.common.collect.Sets;
import java.util.Set;

public class ItemPickaxe extends aks {

   private static final Set c = Sets.newHashSet(new Block[]{Blocks.ACTIVATOR_RAIL, Blocks.COAL_ORE, Blocks.COBBLESTONE, Blocks.DETECTOR_RAIL, Blocks.DIAMOND_BLOCK, Blocks.DIAMOND_ORE, Blocks.DOUBLE_STEP1, Blocks.GOLDEN_RAIL, Blocks.GOLD_BLOCK, Blocks.GOLD_ORE, Blocks.ICE, Blocks.IRON_BLOCK, Blocks.IRON_ORE, Blocks.LAPIS_BLOCK, Blocks.LAPIS_ORE, Blocks.GLOWING_REDSTONE_ORE, Blocks.MOSSY_COBBLESTONE, Blocks.NETHERRACK, Blocks.PACKET_ICE, Blocks.RAILS, Blocks.REDSTONE_ORE, Blocks.SANDSTONE, Blocks.RED_SANDSTONE, Blocks.STONE, Blocks.STEP1});


   protected ItemPickaxe(ami var1) {
      super(2.0F, var1, c);
   }

   public boolean b(Block var1) {
      return var1 == Blocks.OBSIDIAN?this.b.d() == 3:(var1 != Blocks.DIAMOND_BLOCK && var1 != Blocks.DIAMOND_ORE?(var1 != Blocks.EMERALD_ORE && var1 != Blocks.EMERALD_BLOCK?(var1 != Blocks.GOLD_BLOCK && var1 != Blocks.GOLD_ORE?(var1 != Blocks.IRON_BLOCK && var1 != Blocks.IRON_ORE?(var1 != Blocks.LAPIS_BLOCK && var1 != Blocks.LAPIS_ORE?(var1 != Blocks.REDSTONE_ORE && var1 != Blocks.GLOWING_REDSTONE_ORE?(var1.r() == Material.STONE?true:(var1.r() == Material.ORE?true:var1.r() == Material.HEAVY)):this.b.d() >= 2):this.b.d() >= 1):this.b.d() >= 1):this.b.d() >= 2):this.b.d() >= 2):this.b.d() >= 2);
   }

   public float a(ItemStack var1, Block var2) {
      return var2.r() != Material.ORE && var2.r() != Material.HEAVY && var2.r() != Material.STONE?super.a(var1, var2):this.a;
   }

}
