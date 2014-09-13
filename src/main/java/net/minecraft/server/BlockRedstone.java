package net.minecraft.server;

public class BlockRedstone extends BlockOreBlock {

   public BlockRedstone(MaterialMapColor var1) {
      super(var1);
      this.a(CreativeModeTab.d);
   }

   public boolean g() {
      return true;
   }

   public int a(IBlockAccess var1, Location var2, IBlock var3, EnumFacing var4) {
      return 15;
   }
}
