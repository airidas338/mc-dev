package net.minecraft.server;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

abstract class bkb extends bms {

   protected static final List a = Lists.newArrayList(new StructurePieceTreaasure[]{new StructurePieceTreaasure(Items.i, 0, 1, 3, 5), new StructurePieceTreaasure(Items.j, 0, 1, 5, 5), new StructurePieceTreaasure(Items.k, 0, 1, 3, 15), new StructurePieceTreaasure(Items.B, 0, 1, 1, 5), new StructurePieceTreaasure(Items.ah, 0, 1, 1, 5), new StructurePieceTreaasure(Items.d, 0, 1, 1, 5), new StructurePieceTreaasure(Items.by, 0, 3, 7, 5), new StructurePieceTreaasure(Items.aA, 0, 1, 1, 10), new StructurePieceTreaasure(Items.cl, 0, 1, 1, 8), new StructurePieceTreaasure(Items.ck, 0, 1, 1, 5), new StructurePieceTreaasure(Items.cm, 0, 1, 1, 3), new StructurePieceTreaasure(alq.a(aty.Z), 0, 2, 4, 2)});


   public bkb() {}

   protected bkb(int var1) {
      super(var1);
   }

   protected void b(fn var1) {}

   protected void a(fn var1) {}

   private int a(List var1) {
      boolean var2 = false;
      int var3 = 0;

      bkc var5;
      for(Iterator var4 = var1.iterator(); var4.hasNext(); var3 += var5.b) {
         var5 = (bkc)var4.next();
         if(var5.d > 0 && var5.c < var5.d) {
            var2 = true;
         }
      }

      return var2?var3:-1;
   }

   private bkb a(bkf var1, List var2, List var3, Random var4, int var5, int var6, int var7, ej var8, int var9) {
      int var10 = this.a(var2);
      boolean var11 = var10 > 0 && var9 <= 30;
      int var12 = 0;

      while(var12 < 5 && var11) {
         ++var12;
         int var13 = var4.nextInt(var10);
         Iterator var14 = var2.iterator();

         while(var14.hasNext()) {
            bkc var15 = (bkc)var14.next();
            var13 -= var15.b;
            if(var13 < 0) {
               if(!var15.a(var9) || var15 == var1.b && !var15.e) {
                  break;
               }

               bkb var16 = bjn.a(var15, var3, var4, var5, var6, var7, var8, var9);
               if(var16 != null) {
                  ++var15.c;
                  var1.b = var15;
                  if(!var15.a()) {
                     var2.remove(var15);
                  }

                  return var16;
               }
            }
         }
      }

      return bjq.a(var3, var4, var5, var6, var7, var8, var9);
   }

   private bms a(bkf var1, List var2, Random var3, int var4, int var5, int var6, ej var7, int var8, boolean var9) {
      if(Math.abs(var4 - var1.c().a) <= 112 && Math.abs(var6 - var1.c().c) <= 112) {
         List var10 = var1.c;
         if(var9) {
            var10 = var1.d;
         }

         bkb var11 = this.a(var1, var10, var2, var3, var4, var5, var6, var7, var8 + 1);
         if(var11 != null) {
            var2.add(var11);
            var1.e.add(var11);
         }

         return var11;
      } else {
         return bjq.a(var2, var3, var4, var5, var6, var7, var8);
      }
   }

   protected bms a(bkf var1, List var2, Random var3, int var4, int var5, boolean var6) {
      if(this.m != null) {
         switch(bjo.a[this.m.ordinal()]) {
         case 1:
            return this.a(var1, var2, var3, this.l.a + var4, this.l.b + var5, this.l.c - 1, this.m, this.d(), var6);
         case 2:
            return this.a(var1, var2, var3, this.l.a + var4, this.l.b + var5, this.l.f + 1, this.m, this.d(), var6);
         case 3:
            return this.a(var1, var2, var3, this.l.a - 1, this.l.b + var5, this.l.c + var4, this.m, this.d(), var6);
         case 4:
            return this.a(var1, var2, var3, this.l.d + 1, this.l.b + var5, this.l.c + var4, this.m, this.d(), var6);
         }
      }

      return null;
   }

   protected bms b(bkf var1, List var2, Random var3, int var4, int var5, boolean var6) {
      if(this.m != null) {
         switch(bjo.a[this.m.ordinal()]) {
         case 1:
            return this.a(var1, var2, var3, this.l.a - 1, this.l.b + var4, this.l.c + var5, ej.e, this.d(), var6);
         case 2:
            return this.a(var1, var2, var3, this.l.a - 1, this.l.b + var4, this.l.c + var5, ej.e, this.d(), var6);
         case 3:
            return this.a(var1, var2, var3, this.l.a + var5, this.l.b + var4, this.l.c - 1, ej.c, this.d(), var6);
         case 4:
            return this.a(var1, var2, var3, this.l.a + var5, this.l.b + var4, this.l.c - 1, ej.c, this.d(), var6);
         }
      }

      return null;
   }

   protected bms c(bkf var1, List var2, Random var3, int var4, int var5, boolean var6) {
      if(this.m != null) {
         switch(bjo.a[this.m.ordinal()]) {
         case 1:
            return this.a(var1, var2, var3, this.l.d + 1, this.l.b + var4, this.l.c + var5, ej.f, this.d(), var6);
         case 2:
            return this.a(var1, var2, var3, this.l.d + 1, this.l.b + var4, this.l.c + var5, ej.f, this.d(), var6);
         case 3:
            return this.a(var1, var2, var3, this.l.a + var5, this.l.b + var4, this.l.f + 1, ej.d, this.d(), var6);
         case 4:
            return this.a(var1, var2, var3, this.l.a + var5, this.l.b + var4, this.l.f + 1, ej.d, this.d(), var6);
         }
      }

      return null;
   }

   protected static boolean a(bjb var0) {
      return var0 != null && var0.b > 10;
   }

}
