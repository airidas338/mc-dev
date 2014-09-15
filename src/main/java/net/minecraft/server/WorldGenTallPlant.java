package net.minecraft.server;
import java.util.Random;

public class WorldGenTallPlant extends WorldGenerator {

   private avk a;


   public void a(avk var1) {
      this.a = var1;
   }

   public boolean generate(World var1, Random var2, Location var3) {
      boolean var4 = false;

      for(int var5 = 0; var5 < 64; ++var5) {
         Location var6 = var3.a(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
         if(var1.isEmpty(var6) && (!var1.worldProvider.o() || var6.o() < 254) && Blocks.DOUBLE_PLANT.c(var1, var6)) {
            Blocks.DOUBLE_PLANT.a(var1, var6, this.a, 2);
            var4 = true;
         }
      }

      return var4;
   }
}
