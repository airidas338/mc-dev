package net.minecraft.server;

public class BlockHardenedClay extends Block {

   public BlockHardenedClay() {
      super(Material.STONE);
      this.a(CreativeModeTab.b);
   }

   public MaterialMapColor g(IBlock var1) {
      return MaterialMapColor.q;
   }
}
