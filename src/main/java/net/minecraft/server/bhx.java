package net.minecraft.server;
import java.util.Random;

public class bhx extends WorldGenerator {

   public boolean generate(World var1, Random var2, Location var3) {
      while(var1.isEmpty(var3) && var3.o() > 2) {
         var3 = var3.b();
      }

      if(var1.getData(var3).c() != Blocks.SNOW_BLOCK) {
         return false;
      } else {
         var3 = var3.b(var2.nextInt(4));
         int var4 = var2.nextInt(4) + 7;
         int var5 = var4 / 4 + var2.nextInt(2);
         if(var5 > 1 && var2.nextInt(60) == 0) {
            var3 = var3.b(10 + var2.nextInt(30));
         }

         int var6;
         int var8;
         for(var6 = 0; var6 < var4; ++var6) {
            float var7 = (1.0F - (float)var6 / (float)var4) * (float)var5;
            var8 = MathHelper.f(var7);

            for(int var9 = -var8; var9 <= var8; ++var9) {
               float var10 = (float)MathHelper.a(var9) - 0.25F;

               for(int var11 = -var8; var11 <= var8; ++var11) {
                  float var12 = (float)MathHelper.a(var11) - 0.25F;
                  if((var9 == 0 && var11 == 0 || var10 * var10 + var12 * var12 <= var7 * var7) && (var9 != -var8 && var9 != var8 && var11 != -var8 && var11 != var8 || var2.nextFloat() <= 0.75F)) {
                     Block var13 = var1.getData(var3.a(var9, var6, var11)).c();
                     if(var13.r() == Material.AIR || var13 == Blocks.DIRT || var13 == Blocks.SNOW_BLOCK || var13 == Blocks.ICE) {
                        this.a(var1, var3.a(var9, var6, var11), Blocks.PACKET_ICE);
                     }

                     if(var6 != 0 && var8 > 1) {
                        var13 = var1.getData(var3.a(var9, -var6, var11)).c();
                        if(var13.r() == Material.AIR || var13 == Blocks.DIRT || var13 == Blocks.SNOW_BLOCK || var13 == Blocks.ICE) {
                           this.a(var1, var3.a(var9, -var6, var11), Blocks.PACKET_ICE);
                        }
                     }
                  }
               }
            }
         }

         var6 = var5 - 1;
         if(var6 < 0) {
            var6 = 0;
         } else if(var6 > 1) {
            var6 = 1;
         }

         for(int var14 = -var6; var14 <= var6; ++var14) {
            var8 = -var6;

            while(var8 <= var6) {
               Location var15 = var3.a(var14, -1, var8);
               int var16 = 50;
               if(Math.abs(var14) == 1 && Math.abs(var8) == 1) {
                  var16 = var2.nextInt(5);
               }

               while(true) {
                  if(var15.o() > 50) {
                     Block var17 = var1.getData(var15).c();
                     if(var17.r() == Material.AIR || var17 == Blocks.DIRT || var17 == Blocks.SNOW_BLOCK || var17 == Blocks.ICE || var17 == Blocks.PACKET_ICE) {
                        this.a(var1, var15, Blocks.PACKET_ICE);
                        var15 = var15.b();
                        --var16;
                        if(var16 <= 0) {
                           var15 = var15.c(var2.nextInt(5) + 1);
                           var16 = var2.nextInt(5);
                        }
                        continue;
                     }
                  }

                  ++var8;
                  break;
               }
            }
         }

         return true;
      }
   }
}
