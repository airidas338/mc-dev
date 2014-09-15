package net.minecraft.server;

public class BlockHellBrick extends Block {

   public BlockHellBrick() {
      super(Material.STONE);
      this.a(CreativeModeTab.b);
   }

   public MaterialMapColor g(IBlockData var1) {
      return MaterialMapColor.K;
   }
}
