package net.minecraft.server;
import java.util.Random;

public class BlockObsidian extends Block {

   public BlockObsidian() {
      super(Material.STONE);
      this.a(CreativeModeTab.b);
   }

   public Item a(IBlock var1, Random var2, int var3) {
      return Item.a(Blocks.Z);
   }

   public MaterialMapColor g(IBlock var1) {
      return MaterialMapColor.J;
   }
}
