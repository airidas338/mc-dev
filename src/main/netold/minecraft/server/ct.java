package net.minecraft.server;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ct extends z {

   public String c() {
      return "stats";
   }

   public int a() {
      return 2;
   }

   public String c(ae var1) {
      return "commands.stats.usage";
   }

   public void a(ae var1, String[] var2) throws di {
      if(var2.length < 1) {
         throw new dp("commands.stats.usage", new Object[0]);
      } else {
         boolean var3;
         if(var2[0].equals("entity")) {
            var3 = false;
         } else {
            if(!var2[0].equals("block")) {
               throw new dp("commands.stats.usage", new Object[0]);
            }

            var3 = true;
         }

         byte var4;
         if(var3) {
            if(var2.length < 5) {
               throw new dp("commands.stats.block.usage", new Object[0]);
            }

            var4 = 4;
         } else {
            if(var2.length < 3) {
               throw new dp("commands.stats.entity.usage", new Object[0]);
            }

            var4 = 2;
         }

         int var12 = var4 + 1;
         String var5 = var2[var4];
         if("set".equals(var5)) {
            if(var2.length < var12 + 3) {
               if(var12 == 5) {
                  throw new dp("commands.stats.block.set.usage", new Object[0]);
               }

               throw new dp("commands.stats.entity.set.usage", new Object[0]);
            }
         } else {
            if(!"clear".equals(var5)) {
               throw new dp("commands.stats.usage", new Object[0]);
            }

            if(var2.length < var12 + 1) {
               if(var12 == 5) {
                  throw new dp("commands.stats.block.clear.usage", new Object[0]);
               }

               throw new dp("commands.stats.entity.clear.usage", new Object[0]);
            }
         }

         ag var6 = ag.a(var2[var12++]);
         if(var6 == null) {
            throw new di("commands.stats.failed", new Object[0]);
         } else {
            aqu var7 = var1.e();
            af var8;
            dt var9;
            bcm var10;
            if(var3) {
               var9 = a(var1, var2, 1, false);
               var10 = var7.s(var9);
               if(var10 == null) {
                  throw new di("commands.stats.noCompatibleBlock", new Object[]{Integer.valueOf(var9.n()), Integer.valueOf(var9.o()), Integer.valueOf(var9.p())});
               }

               if(var10 instanceof bct) {
                  var8 = ((bct)var10).c();
               } else {
                  if(!(var10 instanceof bdj)) {
                     throw new di("commands.stats.noCompatibleBlock", new Object[]{Integer.valueOf(var9.n()), Integer.valueOf(var9.o()), Integer.valueOf(var9.p())});
                  }

                  var8 = ((bdj)var10).d();
               }
            } else {
               wv var13 = b(var1, var2[1]);
               var8 = var13.aT();
            }

            if("set".equals(var5)) {
               String var14 = var2[var12++];
               String var15 = var2[var12];
               if(var14.length() == 0 || var15.length() == 0) {
                  throw new di("commands.stats.failed", new Object[0]);
               }

               af.a(var8, var6, var14, var15);
               a(var1, this, "commands.stats.success", new Object[]{var6.b(), var15, var14});
            } else if("clear".equals(var5)) {
               af.a(var8, var6, (String)null, (String)null);
               a(var1, this, "commands.stats.cleared", new Object[]{var6.b()});
            }

            if(var3) {
               var9 = a(var1, var2, 1, false);
               var10 = var7.s(var9);
               var10.o_();
            }

         }
      }
   }

   public List a(ae var1, String[] var2, dt var3) {
      return var2.length == 1?a(var2, new String[]{"entity", "block"}):(var2.length == 2 && var2[0].equals("entity")?a(var2, this.d()):((var2.length != 3 || !var2[0].equals("entity")) && (var2.length != 5 || !var2[0].equals("block"))?((var2.length != 4 || !var2[0].equals("entity")) && (var2.length != 6 || !var2[0].equals("block"))?((var2.length != 6 || !var2[0].equals("entity")) && (var2.length != 8 || !var2[0].equals("block"))?null:a(var2, this.e())):a(var2, ag.c())):a(var2, new String[]{"set", "clear"})));
   }

   protected String[] d() {
      return MinecraftServer.M().I();
   }

   protected List e() {
      Collection var1 = MinecraftServer.M().a(0).Z().c();
      ArrayList var2 = Lists.newArrayList();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         bry var4 = (bry)var3.next();
         if(!var4.c().b()) {
            var2.add(var4.b());
         }
      }

      return var2;
   }

   public boolean b(String[] var1, int var2) {
      return var1.length > 0 && var1[0].equals("entity") && var2 == 1;
   }
}
