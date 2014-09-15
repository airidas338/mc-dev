package net.minecraft.server;
import java.util.Random;

public class BlockObsidian extends Block {

   public BlockObsidian() {
      super(Material.STONE);
      this.a(CreativeModeTab.b);
   }

   public Item a(IBlockData var1, Random var2, int var3) {
      return Item.a(Blocks.OBSIDIAN);
   }

   public MaterialMapColor g(IBlockData var1) {
      return MaterialMapColor.J;
   }
}
