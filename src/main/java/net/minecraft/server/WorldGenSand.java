package net.minecraft.server;
import java.util.Random;

public class WorldGenSand extends WorldGenerator {

   private Block a;
   private int b;


   public WorldGenSand(Block var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   public boolean generate(World var1, Random var2, Location var3) {
      if(var1.getData(var3).c().getMaterial() != Material.WATER) {
         return false;
      } else {
         int var4 = var2.nextInt(this.b - 2) + 2;
         byte var5 = 2;

         for(int var6 = var3.n() - var4; var6 <= var3.n() + var4; ++var6) {
            for(int var7 = var3.p() - var4; var7 <= var3.p() + var4; ++var7) {
               int var8 = var6 - var3.n();
               int var9 = var7 - var3.p();
               if(var8 * var8 + var9 * var9 <= var4 * var4) {
                  for(int var10 = var3.o() - var5; var10 <= var3.o() + var5; ++var10) {
                     Location var11 = new Location(var6, var10, var7);
                     Block var12 = var1.getData(var11).c();
                     if(var12 == Blocks.DIRT || var12 == Blocks.GRASS) {
                        var1.a(var11, this.a.P(), 2);
                     }
                  }
               }
            }
         }

         return true;
      }
   }
}
