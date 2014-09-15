package net.minecraft.server;
import java.util.Random;

public class BlockRedstoneOre extends Block {

   private final boolean a;


   public BlockRedstoneOre(boolean var1) {
      super(Material.STONE);
      if(var1) {
         this.a(true);
      }

      this.a = var1;
   }

   public int a(World var1) {
      return 30;
   }

   public void a(World var1, Location var2, EntityHuman var3) {
      this.d(var1, var2);
      super.a(var1, var2, var3);
   }

   public void a(World var1, Location var2, Entity var3) {
      this.d(var1, var2);
      super.a(var1, var2, var3);
   }

   public boolean interact(World var1, Location var2, IBlockData var3, EntityHuman var4, EnumFacing var5, float var6, float var7, float var8) {
      this.d(var1, var2);
      return super.interact(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   private void d(World var1, Location var2) {
      this.e(var1, var2);
      if(this == Blocks.REDSTONE_ORE) {
         var1.a(var2, Blocks.GLOWING_REDSTONE_ORE.P());
      }

   }

   public void b(World var1, Location var2, IBlockData var3, Random var4) {
      if(this == Blocks.GLOWING_REDSTONE_ORE) {
         var1.a(var2, Blocks.REDSTONE_ORE.P());
      }

   }

   public Item a(IBlockData var1, Random var2, int var3) {
      return Items.aC;
   }

   public int getDropCount(int var1, Random var2) {
      return this.a(var2) + var2.nextInt(var1 + 1);
   }

   public int a(Random var1) {
      return 4 + var1.nextInt(2);
   }

   public void dropNaturally(World var1, Location var2, IBlockData var3, float var4, int var5) {
      super.dropNaturally(var1, var2, var3, var4, var5);
      if(this.a(var3, var1.random, var5) != Item.a((Block)this)) {
         int var6 = 1 + var1.random.nextInt(5);
         this.b(var1, var2, var6);
      }

   }

   private void e(World var1, Location var2) {
      Random var3 = var1.random;
      double var4 = 0.0625D;

      for(int var6 = 0; var6 < 6; ++var6) {
         double var7 = (double)((float)var2.n() + var3.nextFloat());
         double var9 = (double)((float)var2.o() + var3.nextFloat());
         double var11 = (double)((float)var2.p() + var3.nextFloat());
         if(var6 == 0 && !var1.getData(var2.a()).c().c()) {
            var9 = (double)var2.o() + var4 + 1.0D;
         }

         if(var6 == 1 && !var1.getData(var2.b()).c().c()) {
            var9 = (double)var2.o() - var4;
         }

         if(var6 == 2 && !var1.getData(var2.d()).c().c()) {
            var11 = (double)var2.p() + var4 + 1.0D;
         }

         if(var6 == 3 && !var1.getData(var2.c()).c().c()) {
            var11 = (double)var2.p() - var4;
         }

         if(var6 == 4 && !var1.getData(var2.f()).c().c()) {
            var7 = (double)var2.n() + var4 + 1.0D;
         }

         if(var6 == 5 && !var1.getData(var2.e()).c().c()) {
            var7 = (double)var2.n() - var4;
         }

         if(var7 < (double)var2.n() || var7 > (double)(var2.n() + 1) || var9 < 0.0D || var9 > (double)(var2.o() + 1) || var11 < (double)var2.p() || var11 > (double)(var2.p() + 1)) {
            var1.a(ew.E, var7, var9, var11, 0.0D, 0.0D, 0.0D, new int[0]);
         }
      }

   }

   protected ItemStack i(IBlockData var1) {
      return new ItemStack(Blocks.REDSTONE_ORE);
   }
}
