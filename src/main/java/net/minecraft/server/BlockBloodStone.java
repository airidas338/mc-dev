package net.minecraft.server;

public class BlockBloodStone extends Block {

   public BlockBloodStone() {
      super(Material.STONE);
      this.a(CreativeModeTab.b);
   }

   public MaterialMapColor g(IBlock var1) {
      return MaterialMapColor.K;
   }
}
