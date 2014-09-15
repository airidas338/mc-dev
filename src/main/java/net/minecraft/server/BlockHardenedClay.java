package net.minecraft.server;

public class BlockHardenedClay extends Block {

   public BlockHardenedClay() {
      super(Material.STONE);
      this.a(CreativeModeTab.b);
   }

   public MaterialMapColor g(IBlockData var1) {
      return MaterialMapColor.q;
   }
}
