package net.minecraft.server;
import java.util.Random;

public class BlockIce extends BlockHalfTransparent {

   public BlockIce() {
      super(Material.ICE, false);
      this.K = 0.98F;
      this.a(true);
      this.a(CreativeModeTab.b);
   }

   public void a(World var1, EntityHuman var2, Location var3, IBlockData var4, TileEntity var5) {
      var2.b(StatisticList.H[Block.getId((Block)this)]);
      var2.a(0.025F);
      if(this.G() && EnchantmentManager.e(var2)) {
         ItemStack var8 = this.i(var4);
         if(var8 != null) {
            a(var1, var3, var8);
         }
      } else {
         if(var1.worldProvider.n()) {
            var1.g(var3);
            return;
         }

         int var6 = EnchantmentManager.f(var2);
         this.b(var1, var3, var4, var6);
         Material var7 = var1.getData(var3.b()).c().getMaterial();
         if(var7.isSolid() || var7.isLiquid()) {
            var1.a(var3, Blocks.WATER.P());
         }
      }

   }

   public int a(Random var1) {
      return 0;
   }

   public void b(World var1, Location var2, IBlockData var3, Random var4) {
      if(var1.b(EnumSkyBlock.BLOCK, var2) > 11 - this.n()) {
         if(var1.worldProvider.n()) {
            var1.g(var2);
         } else {
            this.b(var1, var2, var1.getData(var2), 0);
            var1.a(var2, Blocks.STATIONARY_WATER.P());
         }
      }
   }

   public int i() {
      return 0;
   }
}
