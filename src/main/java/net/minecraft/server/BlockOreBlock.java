package net.minecraft.server;

public class BlockOreBlock extends Block {

   private final MaterialMapColor a;


   public BlockOreBlock(MaterialMapColor var1) {
      super(Material.ORE);
      this.a = var1;
      this.a(CreativeModeTab.b);
   }

   public MaterialMapColor g(IBlockData var1) {
      return this.a;
   }
}
