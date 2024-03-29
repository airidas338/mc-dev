package net.minecraft.server;
import java.util.List;

public class BlockWaterLily extends BlockPlant {

   protected BlockWaterLily() {
      float var1 = 0.5F;
      float var2 = 0.015625F;
      this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, var2, 0.5F + var1);
      this.a(CreativeModeTab.c);
   }

   public void a(World var1, Location var2, IBlockData var3, AxisAlignedBB var4, List var5, Entity var6) {
      if(var6 == null || !(var6 instanceof EntityBoat)) {
         super.a(var1, var2, var3, var4, var5, var6);
      }

   }

   public AxisAlignedBB a(World var1, Location var2, IBlockData var3) {
      return new AxisAlignedBB((double)var2.n() + this.B, (double)var2.o() + this.C, (double)var2.p() + this.D, (double)var2.n() + this.E, (double)var2.o() + this.F, (double)var2.p() + this.G);
   }

   protected boolean c(Block var1) {
      return var1 == Blocks.STATIONARY_WATER;
   }

   public boolean f(World var1, Location var2, IBlockData var3) {
      if(var2.o() >= 0 && var2.o() < 256) {
         IBlockData var4 = var1.getData(var2.b());
         return var4.c().getMaterial() == Material.WATER && ((Integer)var4.b(BlockFluids.b)).intValue() == 0;
      } else {
         return false;
      }
   }

   public int c(IBlockData var1) {
      return 0;
   }
}
