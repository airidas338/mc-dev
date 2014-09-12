package net.minecraft.server;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ba extends CommandAbstract {

   public String c() {
      return "clone";
   }

   public int a() {
      return 2;
   }

   public String c(ae var1) {
      return "commands.clone.usage";
   }

   public void a(ae var1, String[] var2) throws di {
      if(var2.length < 9) {
         throw new dp("commands.clone.usage", new Object[0]);
      } else {
         var1.a(ag.b, 0);
         dt var3 = a(var1, var2, 0, false);
         dt var4 = a(var1, var2, 3, false);
         dt var5 = a(var1, var2, 6, false);
         bjb var6 = new bjb(var3, var4);
         bjb var7 = new bjb(var5, var5.a(var6.b()));
         int var8 = var6.c() * var6.d() * var6.e();
         if(var8 > '\u8000') {
            throw new di("commands.clone.tooManyBlocks", new Object[]{Integer.valueOf(var8), Integer.valueOf('\u8000')});
         } else {
            boolean var9 = false;
            atr var10 = null;
            int var11 = -1;
            if((var2.length < 11 || !var2[10].equals("force") && !var2[10].equals("move")) && var6.a(var7)) {
               throw new di("commands.clone.noOverlap", new Object[0]);
            } else {
               if(var2.length >= 11 && var2[10].equals("move")) {
                  var9 = true;
               }

               if(var6.b >= 0 && var6.e < 256 && var7.b >= 0 && var7.e < 256) {
                  World var12 = var1.e();
                  if(var12.a(var6) && var12.a(var7)) {
                     boolean var13 = false;
                     if(var2.length >= 10) {
                        if(var2[9].equals("masked")) {
                           var13 = true;
                        } else if(var2[9].equals("filtered")) {
                           if(var2.length < 12) {
                              throw new dp("commands.clone.usage", new Object[0]);
                           }

                           var10 = g(var1, var2[11]);
                           if(var2.length >= 13) {
                              var11 = a(var2[12], 0, 15);
                           }
                        }
                     }

                     ArrayList var14 = Lists.newArrayList();
                     ArrayList var15 = Lists.newArrayList();
                     ArrayList var16 = Lists.newArrayList();
                     LinkedList var17 = Lists.newLinkedList();
                     dt var18 = new dt(var7.a - var6.a, var7.b - var6.b, var7.c - var6.c);

                     for(int var19 = var6.c; var19 <= var6.f; ++var19) {
                        for(int var20 = var6.b; var20 <= var6.e; ++var20) {
                           for(int var21 = var6.a; var21 <= var6.d; ++var21) {
                              dt var22 = new dt(var21, var20, var19);
                              dt var23 = var22.a((fd)var18);
                              bec var24 = var12.p(var22);
                              if((!var13 || var24.c() != aty.a) && (var10 == null || var24.c() == var10 && (var11 < 0 || var24.c().c(var24) == var11))) {
                                 bcm var25 = var12.s(var22);
                                 if(var25 != null) {
                                    fn var26 = new fn();
                                    var25.b(var26);
                                    var15.add(new bb(var23, var24, var26));
                                    var17.addLast(var22);
                                 } else if(!var24.c().m() && !var24.c().d()) {
                                    var16.add(new bb(var23, var24, (fn)null));
                                    var17.addFirst(var22);
                                 } else {
                                    var14.add(new bb(var23, var24, (fn)null));
                                    var17.addLast(var22);
                                 }
                              }
                           }
                        }
                     }

                     if(var9) {
                        dt var27;
                        Iterator var29;
                        for(var29 = var17.iterator(); var29.hasNext(); var12.a(var27, aty.cv.P(), 2)) {
                           var27 = (dt)var29.next();
                           bcm var34 = var12.s(var27);
                           if(var34 instanceof vq) {
                              ((vq)var34).l();
                           }
                        }

                        var29 = var17.iterator();

                        while(var29.hasNext()) {
                           var27 = (dt)var29.next();
                           var12.a(var27, aty.a.P(), 3);
                        }
                     }

                     ArrayList var28 = Lists.newArrayList();
                     var28.addAll(var14);
                     var28.addAll(var15);
                     var28.addAll(var16);
                     List var33 = Lists.reverse(var28);

                     bcm var31;
                     bb var30;
                     Iterator var35;
                     for(var35 = var33.iterator(); var35.hasNext(); var12.a(var30.a, aty.cv.P(), 2)) {
                        var30 = (bb)var35.next();
                        var31 = var12.s(var30.a);
                        if(var31 instanceof vq) {
                           ((vq)var31).l();
                        }
                     }

                     var8 = 0;
                     var35 = var28.iterator();

                     while(var35.hasNext()) {
                        var30 = (bb)var35.next();
                        if(var12.a(var30.a, var30.b, 2)) {
                           ++var8;
                        }
                     }

                     for(var35 = var15.iterator(); var35.hasNext(); var12.a(var30.a, var30.b, 2)) {
                        var30 = (bb)var35.next();
                        var31 = var12.s(var30.a);
                        if(var30.c != null && var31 != null) {
                           var30.c.a("x", var30.a.n());
                           var30.c.a("y", var30.a.o());
                           var30.c.a("z", var30.a.p());
                           var31.a(var30.c);
                           var31.o_();
                        }
                     }

                     var35 = var33.iterator();

                     while(var35.hasNext()) {
                        var30 = (bb)var35.next();
                        var12.b(var30.a, var30.b.c());
                     }

                     List var32 = var12.a(var6, false);
                     if(var32 != null) {
                        Iterator var36 = var32.iterator();

                        while(var36.hasNext()) {
                           ark var37 = (ark)var36.next();
                           if(var6.b((fd)var37.a)) {
                              dt var38 = var37.a.a((fd)var18);
                              var12.b(var38, var37.a(), (int)(var37.b - var12.P().f()), var37.c);
                           }
                        }
                     }

                     if(var8 <= 0) {
                        throw new di("commands.clone.failed", new Object[0]);
                     } else {
                        var1.a(ag.b, var8);
                        a(var1, this, "commands.clone.success", new Object[]{Integer.valueOf(var8)});
                     }
                  } else {
                     throw new di("commands.clone.outOfWorld", new Object[0]);
                  }
               } else {
                  throw new di("commands.clone.outOfWorld", new Object[0]);
               }
            }
         }
      }
   }

   public List a(ae var1, String[] var2, dt var3) {
      return var2.length > 0 && var2.length <= 3?a(var2, 0, var3):(var2.length > 3 && var2.length <= 6?a(var2, 3, var3):(var2.length > 6 && var2.length <= 9?a(var2, 6, var3):(var2.length == 10?a(var2, new String[]{"replace", "masked", "filtered"}):(var2.length == 11?a(var2, new String[]{"normal", "force", "move"}):(var2.length == 12 && "filtered".equals(var2[9])?a(var2, atr.c.c()):null)))));
   }
}