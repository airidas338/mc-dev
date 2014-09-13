package net.minecraft.server;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Random;

public class bje {

   private static final List a = Lists.newArrayList(new StructurePieceTreaasure[]{new StructurePieceTreaasure(Items.j, 0, 1, 5, 10), new StructurePieceTreaasure(Items.k, 0, 1, 3, 5), new StructurePieceTreaasure(Items.aC, 0, 4, 9, 5), new StructurePieceTreaasure(Items.aW, akv.l.b(), 4, 9, 5), new StructurePieceTreaasure(Items.i, 0, 1, 2, 3), new StructurePieceTreaasure(Items.h, 0, 3, 8, 10), new StructurePieceTreaasure(Items.P, 0, 1, 3, 15), new StructurePieceTreaasure(Items.b, 0, 1, 1, 1), new StructurePieceTreaasure(Item.a(Blocks.av), 0, 4, 8, 1), new StructurePieceTreaasure(Items.bh, 0, 2, 4, 10), new StructurePieceTreaasure(Items.bg, 0, 2, 4, 10), new StructurePieceTreaasure(Items.aA, 0, 1, 1, 3), new StructurePieceTreaasure(Items.ck, 0, 1, 1, 1)});


   public static void a() {
      bmq.a(bjg.class, "MSCorridor");
      bmq.a(bjh.class, "MSCrossing");
      bmq.a(bji.class, "MSRoom");
      bmq.a(bjj.class, "MSStairs");
   }

   private static bms a(List var0, Random var1, int var2, int var3, int var4, ej var5, int var6) {
      int var7 = var1.nextInt(100);
      bjb var8;
      if(var7 >= 80) {
         var8 = bjh.a(var0, var1, var2, var3, var4, var5);
         if(var8 != null) {
            return new bjh(var6, var1, var8, var5);
         }
      } else if(var7 >= 70) {
         var8 = bjj.a(var0, var1, var2, var3, var4, var5);
         if(var8 != null) {
            return new bjj(var6, var1, var8, var5);
         }
      } else {
         var8 = bjg.a(var0, var1, var2, var3, var4, var5);
         if(var8 != null) {
            return new bjg(var6, var1, var8, var5);
         }
      }

      return null;
   }

   private static bms b(bms var0, List var1, Random var2, int var3, int var4, int var5, ej var6, int var7) {
      if(var7 > 8) {
         return null;
      } else if(Math.abs(var3 - var0.c().a) <= 80 && Math.abs(var5 - var0.c().c) <= 80) {
         bms var8 = a(var1, var2, var3, var4, var5, var6, var7 + 1);
         if(var8 != null) {
            var1.add(var8);
            var8.a(var0, var1, var2);
         }

         return var8;
      } else {
         return null;
      }
   }

   // $FF: synthetic method
   static bms a(bms var0, List var1, Random var2, int var3, int var4, int var5, ej var6, int var7) {
      return b(var0, var1, var2, var3, var4, var5, var6, var7);
   }

   // $FF: synthetic method
   static List b() {
      return a;
   }

}
