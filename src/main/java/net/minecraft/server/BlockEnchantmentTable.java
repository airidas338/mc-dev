package net.minecraft.server;


public class BlockEnchantmentTable extends BlockContainer {

   protected BlockEnchantmentTable() {
      super(Material.STONE);
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
      this.e(0);
      this.a(CreativeModeTab.c);
   }

   public boolean d() {
      return false;
   }

   public boolean c() {
      return false;
   }

   public int b() {
      return 3;
   }

   public TileEntity a(World var1, int var2) {
      return new TileEntityEnchantTable();
   }

   public boolean interact(World var1, Location var2, IBlockData var3, EntityHuman var4, EnumFacing var5, float var6, float var7, float var8) {
      if(var1.isStatic) {
         return true;
      } else {
         TileEntity var9 = var1.s(var2);
         if(var9 instanceof TileEntityEnchantTable) {
            var4.a((vv)((TileEntityEnchantTable)var9));
         }

         return true;
      }
   }

   public void a(World var1, Location var2, IBlockData var3, EntityLiving var4, ItemStack var5) {
      super.a(var1, var2, var3, var4, var5);
      if(var5.s()) {
         TileEntity var6 = var1.s(var2);
         if(var6 instanceof TileEntityEnchantTable) {
            ((TileEntityEnchantTable)var6).a(var5.q());
         }
      }

   }
}
