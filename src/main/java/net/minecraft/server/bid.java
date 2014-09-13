package net.minecraft.server;
import java.util.Random;

public class bid extends WorldGenerator {

   public boolean generate(World var1, Random var2, Location var3) {
      for(int var4 = 0; var4 < 64; ++var4) {
         Location var5 = var3.a(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
         if(Blocks.MELON.c(var1, var5) && var1.getData(var5.b()).c() == Blocks.GRASS) {
            var1.a(var5, Blocks.MELON.P(), 2);
         }
      }

      return true;
   }
}
