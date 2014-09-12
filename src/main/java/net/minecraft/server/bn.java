package net.minecraft.server;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bn extends CommandAbstract {

   public String c() {
      return "fill";
   }

   public int a() {
      return 2;
   }

   public String c(ae var1) {
      return "commands.fill.usage";
   }

   public void a(ae var1, String[] var2) throws di {
      if(var2.length < 7) {
         throw new dp("commands.fill.usage", new Object[0]);
      } else {
         var1.a(ag.b, 0);
         dt var3 = a(var1, var2, 0, false);
         dt var4 = a(var1, var2, 3, false);
         atr var5 = CommandAbstract.g(var1, var2[6]);
         int var6 = 0;
         if(var2.length >= 8) {
            var6 = a(var2[7], 0, 15);
         }

         dt var7 = new dt(Math.min(var3.n(), var4.n()), Math.min(var3.o(), var4.o()), Math.min(var3.p(), var4.p()));
         dt var8 = new dt(Math.max(var3.n(), var4.n()), Math.max(var3.o(), var4.o()), Math.max(var3.p(), var4.p()));
         int var9 = (var8.n() - var7.n() + 1) * (var8.o() - var7.o() + 1) * (var8.p() - var7.p() + 1);
         if(var9 > '\u8000') {
            throw new di("commands.fill.tooManyBlocks", new Object[]{Integer.valueOf(var9), Integer.valueOf('\u8000')});
         } else if(var7.o() >= 0 && var8.o() < 256) {
            World var10 = var1.e();

            for(int var11 = var7.p(); var11 < var8.p() + 16; var11 += 16) {
               for(int var12 = var7.n(); var12 < var8.n() + 16; var12 += 16) {
                  if(!var10.e(new dt(var12, var8.o() - var7.o(), var11))) {
                     throw new di("commands.fill.outOfWorld", new Object[0]);
                  }
               }
            }

            fn var23 = new fn();
            boolean var22 = false;
            if(var2.length >= 10 && var5.x()) {
               String var13 = a(var1, var2, 9).c();

               try {
                  var23 = gg.a(var13);
                  var22 = true;
               } catch (gf var21) {
                  throw new di("commands.fill.tagError", new Object[]{var21.getMessage()});
               }
            }

            ArrayList var24 = Lists.newArrayList();
            var9 = 0;

            for(int var14 = var7.p(); var14 <= var8.p(); ++var14) {
               for(int var15 = var7.o(); var15 <= var8.o(); ++var15) {
                  for(int var16 = var7.n(); var16 <= var8.n(); ++var16) {
                     dt var17 = new dt(var16, var15, var14);
                     bec var19;
                     if(var2.length >= 9) {
                        if(!var2[8].equals("outline") && !var2[8].equals("hollow")) {
                           if(var2[8].equals("destroy")) {
                              var10.b(var17, true);
                           } else if(var2[8].equals("keep")) {
                              if(!var10.d(var17)) {
                                 continue;
                              }
                           } else if(var2[8].equals("replace") && !var5.x()) {
                              if(var2.length > 9) {
                                 atr var18 = CommandAbstract.g(var1, var2[9]);
                                 if(var10.p(var17).c() != var18) {
                                    continue;
                                 }
                              }

                              if(var2.length > 10) {
                                 int var29 = CommandAbstract.a(var2[10]);
                                 var19 = var10.p(var17);
                                 if(var19.c().c(var19) != var29) {
                                    continue;
                                 }
                              }
                           }
                        } else if(var16 != var7.n() && var16 != var8.n() && var15 != var7.o() && var15 != var8.o() && var14 != var7.p() && var14 != var8.p()) {
                           if(var2[8].equals("hollow")) {
                              var10.a(var17, aty.a.P(), 2);
                              var24.add(var17);
                           }
                           continue;
                        }
                     }

                     bcm var28 = var10.s(var17);
                     if(var28 != null) {
                        if(var28 instanceof vq) {
                           ((vq)var28).l();
                        }

                        var10.a(var17, aty.cv.P(), var5 == aty.cv?2:4);
                     }

                     var19 = var5.a(var6);
                     if(var10.a(var17, var19, 2)) {
                        var24.add(var17);
                        ++var9;
                        if(var22) {
                           bcm var20 = var10.s(var17);
                           if(var20 != null) {
                              var23.a("x", var17.n());
                              var23.a("y", var17.o());
                              var23.a("z", var17.p());
                              var20.a(var23);
                           }
                        }
                     }
                  }
               }
            }

            Iterator var25 = var24.iterator();

            while(var25.hasNext()) {
               dt var27 = (dt)var25.next();
               atr var26 = var10.p(var27).c();
               var10.b(var27, var26);
            }

            if(var9 <= 0) {
               throw new di("commands.fill.failed", new Object[0]);
            } else {
               var1.a(ag.b, var9);
               a(var1, this, "commands.fill.success", new Object[]{Integer.valueOf(var9)});
            }
         } else {
            throw new di("commands.fill.outOfWorld", new Object[0]);
         }
      }
   }

   public List a(ae var1, String[] var2, dt var3) {
      return var2.length > 0 && var2.length <= 3?a(var2, 0, var3):(var2.length > 3 && var2.length <= 6?a(var2, 3, var3):(var2.length == 7?a(var2, atr.c.c()):(var2.length == 9?a(var2, new String[]{"replace", "destroy", "keep", "hollow", "outline"}):null)));
   }
}
