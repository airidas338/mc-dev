package net.minecraft.server;
import java.util.Random;

public class bhs extends WorldGenerator {

   public boolean generate(World var1, Random var2, Location var3) {
      for(int var4 = 0; var4 < 64; ++var4) {
         Location var5 = var3.a(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
         if(var1.isEmpty(var5) && var1.getData(var5.b()).c() == Blocks.NETHERRACK) {
            var1.setTypeAndData(var5, Blocks.FIRE.P(), 2);
         }
      }

      return true;
   }
}
