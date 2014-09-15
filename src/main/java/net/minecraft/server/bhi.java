package net.minecraft.server;
import java.util.Random;

public class bhi extends WorldGenerator {

   private BlockPlant a;


   public bhi(BlockPlant var1) {
      this.a = var1;
   }

   public boolean generate(World var1, Random var2, Location var3) {
      for(int var4 = 0; var4 < 64; ++var4) {
         Location var5 = var3.a(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
         if(var1.isEmpty(var5) && (!var1.worldProvider.o() || var5.o() < 255) && this.a.f(var1, var5, this.a.P())) {
            var1.a(var5, this.a.P(), 2);
         }
      }

      return true;
   }
}
