package net.minecraft.server;
import java.util.Iterator;
import java.util.List;

public class cy extends z {

   public String c() {
      return "testforblock";
   }

   public int a() {
      return 2;
   }

   public String c(ae var1) {
      return "commands.testforblock.usage";
   }

   public void a(ae var1, String[] var2) throws di {
      if(var2.length < 4) {
         throw new dp("commands.testforblock.usage", new Object[0]);
      } else {
         var1.a(ag.b, 0);
         dt var3 = a(var1, var2, 0, false);
         atr var4 = atr.b(var2[3]);
         if(var4 == null) {
            throw new dk("commands.setblock.notFound", new Object[]{var2[3]});
         } else {
            int var5 = -1;
            if(var2.length >= 5) {
               var5 = a(var2[4], -1, 15);
            }

            aqu var6 = var1.e();
            if(!var6.e(var3)) {
               throw new di("commands.testforblock.outOfWorld", new Object[0]);
            } else {
               fn var7 = new fn();
               boolean var8 = false;
               if(var2.length >= 6 && var4.x()) {
                  String var9 = a(var1, var2, 5).c();

                  try {
                     var7 = gg.a(var9);
                     var8 = true;
                  } catch (gf var13) {
                     throw new di("commands.setblock.tagError", new Object[]{var13.getMessage()});
                  }
               }

               bec var14 = var6.p(var3);
               atr var10 = var14.c();
               if(var10 != var4) {
                  throw new di("commands.testforblock.failed.tile", new Object[]{Integer.valueOf(var3.n()), Integer.valueOf(var3.o()), Integer.valueOf(var3.p()), var10.H(), var4.H()});
               } else {
                  if(var5 > -1) {
                     int var11 = var14.c().c(var14);
                     if(var11 != var5) {
                        throw new di("commands.testforblock.failed.data", new Object[]{Integer.valueOf(var3.n()), Integer.valueOf(var3.o()), Integer.valueOf(var3.p()), Integer.valueOf(var11), Integer.valueOf(var5)});
                     }
                  }

                  if(var8) {
                     bcm var15 = var6.s(var3);
                     if(var15 == null) {
                        throw new di("commands.testforblock.failed.tileEntity", new Object[]{Integer.valueOf(var3.n()), Integer.valueOf(var3.o()), Integer.valueOf(var3.p())});
                     }

                     fn var12 = new fn();
                     var15.b(var12);
                     if(!a(var7, var12, true)) {
                        throw new di("commands.testforblock.failed.nbt", new Object[]{Integer.valueOf(var3.n()), Integer.valueOf(var3.o()), Integer.valueOf(var3.p())});
                     }
                  }

                  var1.a(ag.b, 1);
                  a(var1, this, "commands.testforblock.success", new Object[]{Integer.valueOf(var3.n()), Integer.valueOf(var3.o()), Integer.valueOf(var3.p())});
               }
            }
         }
      }
   }

   public static boolean a(gd var0, gd var1, boolean var2) {
      if(var0 == var1) {
         return true;
      } else if(var0 == null) {
         return true;
      } else if(var1 == null) {
         return false;
      } else if(!var0.getClass().equals(var1.getClass())) {
         return false;
      } else if(var0 instanceof fn) {
         fn var9 = (fn)var0;
         fn var10 = (fn)var1;
         Iterator var11 = var9.c().iterator();

         String var12;
         gd var13;
         do {
            if(!var11.hasNext()) {
               return true;
            }

            var12 = (String)var11.next();
            var13 = var9.a(var12);
         } while(a(var13, var10.a(var12), var2));

         return false;
      } else if(var0 instanceof fv && var2) {
         fv var3 = (fv)var0;
         fv var4 = (fv)var1;
         if(var3.c() == 0) {
            return var4.c() == 0;
         } else {
            int var5 = 0;

            while(var5 < var3.c()) {
               gd var6 = var3.g(var5);
               boolean var7 = false;
               int var8 = 0;

               while(true) {
                  if(var8 < var4.c()) {
                     if(!a(var6, var4.g(var8), var2)) {
                        ++var8;
                        continue;
                     }

                     var7 = true;
                  }

                  if(!var7) {
                     return false;
                  }

                  ++var5;
                  break;
               }
            }

            return true;
         }
      } else {
         return var0.equals(var1);
      }
   }

   public List a(ae var1, String[] var2, dt var3) {
      return var2.length > 0 && var2.length <= 3?a(var2, 0, var3):(var2.length == 4?a(var2, atr.c.c()):null);
   }
}
