package net.minecraft.server;
import java.util.List;
import java.util.Random;

public class WorldGenBonusChest extends bhp {

   private final List a;
   private final int b;


   public WorldGenBonusChest(List var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   public boolean generate(World var1, Random var2, Location var3) {
      Block var4;
      while(((var4 = var1.p(var3).c()).r() == Material.a || var4.r() == Material.j) && var3.o() > 1) {
         var3 = var3.b();
      }

      if(var3.o() < 1) {
         return false;
      } else {
         var3 = var3.a();

         for(int var5 = 0; var5 < 4; ++var5) {
            Location var6 = var3.a(var2.nextInt(4) - var2.nextInt(4), var2.nextInt(3) - var2.nextInt(3), var2.nextInt(4) - var2.nextInt(4));
            if(var1.d(var6) && World.a((ard)var1, var6.b())) {
               var1.a(var6, aty.ae.P(), 2);
               bcm var7 = var1.s(var6);
               if(var7 instanceof bcr) {
                  StructurePieceTreaasure.a(var2, this.a, (vq)((bcr)var7), this.b);
               }

               Location var8 = var6.f();
               Location var9 = var6.e();
               Location var10 = var6.c();
               Location var11 = var6.d();
               if(var1.d(var9) && World.a((ard)var1, var9.b())) {
                  var1.a(var9, aty.aa.P(), 2);
               }

               if(var1.d(var8) && World.a((ard)var1, var8.b())) {
                  var1.a(var8, aty.aa.P(), 2);
               }

               if(var1.d(var10) && World.a((ard)var1, var10.b())) {
                  var1.a(var10, aty.aa.P(), 2);
               }

               if(var1.d(var11) && World.a((ard)var1, var11.b())) {
                  var1.a(var11, aty.aa.P(), 2);
               }

               return true;
            }
         }

         return false;
      }
   }
}