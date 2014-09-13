package net.minecraft.server;
import java.util.Random;

public class bin extends WorldGenerator {

   private Block a;


   public bin(Block var1) {
      this.a = var1;
   }

   public boolean generate(World var1, Random var2, Location var3) {
      if(var1.getData(var3.a()).c() != aty.b) {
         return false;
      } else if(var1.getData(var3.b()).c() != aty.b) {
         return false;
      } else if(var1.getData(var3).c().r() != Material.AIR && var1.getData(var3).c() != aty.b) {
         return false;
      } else {
         int var4 = 0;
         if(var1.getData(var3.e()).c() == aty.b) {
            ++var4;
         }

         if(var1.getData(var3.f()).c() == aty.b) {
            ++var4;
         }

         if(var1.getData(var3.c()).c() == aty.b) {
            ++var4;
         }

         if(var1.getData(var3.d()).c() == aty.b) {
            ++var4;
         }

         int var5 = 0;
         if(var1.d(var3.e())) {
            ++var5;
         }

         if(var1.d(var3.f())) {
            ++var5;
         }

         if(var1.d(var3.c())) {
            ++var5;
         }

         if(var1.d(var3.d())) {
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
