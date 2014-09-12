package net.minecraft.server;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class bie extends bhp {

   private static final Logger a = LogManager.getLogger();
   private static final String[] b = new String[]{"Skeleton", "Zombie", "Zombie", "Spider"};
   private static final List c = Lists.newArrayList(new StructurePieceTreaasure[]{new StructurePieceTreaasure(Items.aA, 0, 1, 1, 10), new StructurePieceTreaasure(Items.j, 0, 1, 4, 10), new StructurePieceTreaasure(Items.P, 0, 1, 1, 10), new StructurePieceTreaasure(Items.O, 0, 1, 4, 10), new StructurePieceTreaasure(Items.H, 0, 1, 4, 10), new StructurePieceTreaasure(Items.F, 0, 1, 4, 10), new StructurePieceTreaasure(Items.aw, 0, 1, 1, 10), new StructurePieceTreaasure(Items.ao, 0, 1, 1, 1), new StructurePieceTreaasure(Items.aC, 0, 1, 4, 10), new StructurePieceTreaasure(Items.cq, 0, 1, 1, 4), new StructurePieceTreaasure(Items.cr, 0, 1, 1, 4), new StructurePieceTreaasure(Items.co, 0, 1, 1, 10), new StructurePieceTreaasure(Items.cl, 0, 1, 1, 2), new StructurePieceTreaasure(Items.ck, 0, 1, 1, 5), new StructurePieceTreaasure(Items.cm, 0, 1, 1, 1)});


   public boolean generate(World var1, Random var2, Location var3) {
      boolean var4 = true;
      int var5 = var2.nextInt(2) + 2;
      int var6 = -var5 - 1;
      int var7 = var5 + 1;
      boolean var8 = true;
      boolean var9 = true;
      int var10 = var2.nextInt(2) + 2;
      int var11 = -var10 - 1;
      int var12 = var10 + 1;
      int var13 = 0;

      int var14;
      int var15;
      Location var17;
      int var16;
      for(var14 = var6; var14 <= var7; ++var14) {
         for(var15 = -1; var15 <= 4; ++var15) {
            for(var16 = var11; var16 <= var12; ++var16) {
               var17 = var3.a(var14, var15, var16);
               Material var18 = var1.p(var17).c().r();
               boolean var19 = var18.a();
               if(var15 == -1 && !var19) {
                  return false;
               }

               if(var15 == 4 && !var19) {
                  return false;
               }

               if((var14 == var6 || var14 == var7 || var16 == var11 || var16 == var12) && var15 == 0 && var1.d(var17) && var1.d(var17.a())) {
                  ++var13;
               }
            }
         }
      }

      if(var13 >= 1 && var13 <= 5) {
         for(var14 = var6; var14 <= var7; ++var14) {
            for(var15 = 3; var15 >= -1; --var15) {
               for(var16 = var11; var16 <= var12; ++var16) {
                  var17 = var3.a(var14, var15, var16);
                  if(var14 != var6 && var15 != -1 && var16 != var11 && var14 != var7 && var15 != 4 && var16 != var12) {
                     if(var1.p(var17).c() != aty.ae) {
                        var1.g(var17);
                     }
                  } else if(var17.o() >= 0 && !var1.p(var17.b()).c().r().a()) {
                     var1.g(var17);
                  } else if(var1.p(var17).c().r().a() && var1.p(var17).c() != aty.ae) {
                     if(var15 == -1 && var2.nextInt(4) != 0) {
                        var1.a(var17, aty.Y.P(), 2);
                     } else {
                        var1.a(var17, aty.e.P(), 2);
                     }
                  }
               }
            }
         }

         var14 = 0;

         while(var14 < 2) {
            var15 = 0;

            while(true) {
               if(var15 < 3) {
                  label100: {
                     var16 = var3.n() + var2.nextInt(var5 * 2 + 1) - var5;
                     int var24 = var3.o();
                     int var26 = var3.p() + var2.nextInt(var10 * 2 + 1) - var10;
                     Location var25 = new Location(var16, var24, var26);
                     if(var1.d(var25)) {
                        int var20 = 0;
                        Iterator var21 = en.a.iterator();

                        while(var21.hasNext()) {
                           ej var22 = (ej)var21.next();
                           if(var1.p(var25.a(var22)).c().r().a()) {
                              ++var20;
                           }
                        }

                        if(var20 == 1) {
                           var1.a(var25, aty.ae.f(var1, var25, aty.ae.P()), 2);
                           List var28 = StructurePieceTreaasure.a(c, new StructurePieceTreaasure[]{Items.cd.b(var2)});
                           bcm var27 = var1.s(var25);
                           if(var27 instanceof bcr) {
                              StructurePieceTreaasure.a(var2, var28, (vq)((bcr)var27), 8);
                           }
                           break label100;
                        }
                     }

                     ++var15;
                     continue;
                  }
               }

               ++var14;
               break;
            }
         }

         var1.a(var3, aty.ac.P(), 2);
         bcm var23 = var1.s(var3);
         if(var23 instanceof bdg) {
            ((bdg)var23).b().a(this.a(var2));
         } else {
            a.error("Failed to fetch mob spawner entity at (" + var3.n() + ", " + var3.o() + ", " + var3.p() + ")");
         }

         return true;
      } else {
         return false;
      }
   }

   private String a(Random var1) {
      return b[var1.nextInt(b.length)];
   }

}
