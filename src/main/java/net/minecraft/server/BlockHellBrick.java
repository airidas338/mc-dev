package net.minecraft.server;

public class BlockHellBrick extends Block {

   public BlockHellBrick() {
      super(Material.STONE);
      this.a(CreativeModeTab.b);
   }

   public MaterialMapColor g(IBlock var1) {
      return MaterialMapColor.K;
   }
}
