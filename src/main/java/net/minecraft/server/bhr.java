package net.minecraft.server;
import java.util.Random;

public class bhr extends WorldGenTrees {

   private int a;
   private int b;


   public bhr(int var1, int var2) {
      super(false);
      this.b = var1;
      this.a = var2;
   }

   public boolean generate(World var1, Random var2, Location var3) {
      Block var4;
      while(((var4 = var1.getData(var3).c()).r() == Material.AIR || var4.r() == Material.LEAVES) && var3.o() > 0) {
         var3 = var3.b();
      }

      Block var5 = var1.getData(var3).c();
      if(var5 == Blocks.d || var5 == Blocks.c) {
         var3 = var3.a();
         this.a(var1, var3, Blocks.r, this.b);

         for(int var6 = var3.o(); var6 <= var3.o() + 2; ++var6) {
            int var7 = var6 - var3.o();
            int var8 = 2 - var7;

            for(int var9 = var3.n() - var8; var9 <= var3.n() + var8; ++var9) {
               int var10 = var9 - var3.n();

               for(int var11 = var3.p() - var8; var11 <= var3.p() + var8; ++var11) {
                  int var12 = var11 - var3.p();
                  if(Math.abs(var10) != var8 || Math.abs(var12) != var8 || var2.nextInt(2) != 0) {
                     Location var13 = new Location(var9, var6, var11);
                     if(!var1.getData(var13).c().m()) {
                        this.a(var1, var13, Blocks.t, this.a);
                     }
                  }
               }
            }
         }
      }

      return true;
   }
}
