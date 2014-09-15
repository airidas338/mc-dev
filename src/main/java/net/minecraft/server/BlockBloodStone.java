package net.minecraft.server;

public class BlockBloodStone extends Block {

   public BlockBloodStone() {
      super(Material.STONE);
      this.a(CreativeModeTab.b);
   }

   public MaterialMapColor g(IBlockData var1) {
      return MaterialMapColor.K;
   }
}
