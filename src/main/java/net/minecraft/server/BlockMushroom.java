package net.minecraft.server;
import java.util.Iterator;
import java.util.Random;

public class BlockMushroom extends BlockPlant implements atz {

   protected BlockMushroom() {
      float var1 = 0.2F;
      this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, var1 * 2.0F, 0.5F + var1);
      this.a(true);
   }

   public void b(World var1, Location var2, IBlockData var3, Random var4) {
      if(var4.nextInt(25) == 0) {
         int var5 = 5;
         boolean var6 = true;
         Iterator var7 = Location.b(var2.a(-4, -1, -4), var2.a(4, 1, 4)).iterator();

         while(var7.hasNext()) {
            Location var8 = (Location)var7.next();
            if(var1.getData(var8).c() == this) {
               --var5;
               if(var5 <= 0) {
                  return;
               }
            }
         }

         Location var9 = var2.a(var4.nextInt(3) - 1, var4.nextInt(2) - var4.nextInt(2), var4.nextInt(3) - 1);

         for(int var10 = 0; var10 < 4; ++var10) {
            if(var1.isEmpty(var9) && this.f(var1, var9, this.P())) {
               var2 = var9;
            }

            var9 = var2.a(var4.nextInt(3) - 1, var4.nextInt(2) - var4.nextInt(2), var4.nextInt(3) - 1);
         }

         if(var1.isEmpty(var9) && this.f(var1, var9, this.P())) {
            var1.a(var9, this.P(), 2);
         }
      }

   }

   public boolean canPlace(World var1, Location var2) {
      return super.canPlace(var1, var2) && this.f(var1, var2, this.P());
   }

   protected boolean c(Block var1) {
      return var1.m();
   }

   public boolean f(World var1, Location var2, IBlockData var3) {
      if(var2.o() >= 0 && var2.o() < 256) {
         IBlockData var4 = var1.getData(var2.b());
         return var4.c() == Blocks.MYCEL?true:(var4.c() == Blocks.DIRT && var4.b(BlockDirt.a) == avd.c?true:var1.k(var2) < 13 && this.c(var4.c()));
      } else {
         return false;
      }
   }

   public boolean d(World var1, Location var2, IBlockData var3, Random var4) {
      var1.g(var2);
      bhv var5 = null;
      if(this == Blocks.BROWN_MUSHROOM) {
         var5 = new bhv(0);
      } else if(this == Blocks.RED_MUSHROOM) {
         var5 = new bhv(1);
      }

      if(var5 != null && var5.generate(var1, var4, var2)) {
         return true;
      } else {
         var1.a(var2, var3, 3);
         return false;
      }
   }

   public boolean a(World var1, Location var2, IBlockData var3, boolean var4) {
      return true;
   }

   public boolean a(World var1, Random var2, Location var3, IBlockData var4) {
      return (double)var2.nextFloat() < 0.4D;
   }

   public void b(World var1, Random var2, Location var3, IBlockData var4) {
      this.d(var1, var3, var4, var2);
   }
}
