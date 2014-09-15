package net.minecraft.server;
import java.util.Random;

public class bin extends WorldGenerator {

   private Block a;


   public bin(Block var1) {
      this.a = var1;
   }

   public boolean generate(World var1, Random var2, Location var3) {
      if(var1.getData(var3.a()).c() != Blocks.STONE) {
         return false;
      } else if(var1.getData(var3.b()).c() != Blocks.STONE) {
         return false;
      } else if(var1.getData(var3).c().getMaterial() != Material.AIR && var1.getData(var3).c() != Blocks.STONE) {
         return false;
      } else {
         int var4 = 0;
         if(var1.getData(var3.e()).c() == Blocks.STONE) {
            ++var4;
         }

         if(var1.getData(var3.f()).c() == Blocks.STONE) {
            ++var4;
         }

         if(var1.getData(var3.c()).c() == Blocks.STONE) {
            ++var4;
         }

         if(var1.getData(var3.d()).c() == Blocks.STONE) {
            ++var4;
         }

         int var5 = 0;
         if(var1.isEmpty(var3.e())) {
            ++var5;
         }

         if(var1.isEmpty(var3.f())) {
            ++var5;
         }

         if(var1.isEmpty(var3.c())) {
            ++var5;
         }

         if(var1.isEmpty(var3.d())) {
            ++var5;
         }

         if(var4 == 3 && var5 == 1) {
            var1.a(var3, this.a.P(), 2);
            var1.a(this.a, var3, var2);
         }

         return true;
      }
   }
}
