package net.minecraft.server;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class dd extends CommandAbstract {

   public String c() {
      return "trigger";
   }

   public int a() {
      return 0;
   }

   public String c(ae var1) {
      return "commands.trigger.usage";
   }

   public void a(ae var1, String[] var2) throws di {
      if(var2.length < 3) {
         throw new dp("commands.trigger.usage", new Object[0]);
      } else {
         EntityPlayer var3;
         if(var1 instanceof EntityPlayer) {
            var3 = (EntityPlayer)var1;
         } else {
            Entity var4 = var1.f();
            if(!(var4 instanceof EntityPlayer)) {
               throw new di("commands.trigger.invalidPlayer", new Object[0]);
            }

            var3 = (EntityPlayer)var4;
         }

         Scoreboard var8 = MinecraftServer.M().a(0).Z();
         bry var5 = var8.b(var2[0]);
         if(var5 != null && var5.c() == bsk.c) {
            int var6 = a(var2[2]);
            if(!var8.b(var3.d_(), var5)) {
               throw new di("commands.trigger.invalidObjective", new Object[]{var2[0]});
            } else {
               bsa var7 = var8.c(var3.d_(), var5);
               if(var7.g()) {
                  throw new di("commands.trigger.disabled", new Object[]{var2[0]});
               } else {
                  if("set".equals(var2[1])) {
                     var7.c(var6);
                  } else {
                     if(!"add".equals(var2[1])) {
                        throw new di("commands.trigger.invalidMode", new Object[]{var2[1]});
                     }

                     var7.a(var6);
                  }

                  var7.a(true);
                  if(var3.c.d()) {
                     a(var1, this, "commands.trigger.success", new Object[]{var2[0], var2[1], var2[2]});
                  }

               }
            }
         } else {
            throw new di("commands.trigger.invalidObjective", new Object[]{var2[0]});
         }
      }
   }

   public List a(ae var1, String[] var2, Location var3) {
      if(var2.length == 1) {
         Scoreboard var4 = MinecraftServer.M().a(0).Z();
         ArrayList var5 = Lists.newArrayList();
         Iterator var6 = var4.c().iterator();

         while(var6.hasNext()) {
            bry var7 = (bry)var6.next();
            if(var7.c() == bsk.c) {
               var5.add(var7.b());
            }
         }

         return a(var2, (String[])var5.toArray(new String[var5.size()]));
      } else {
         return var2.length == 2?a(var2, new String[]{"add", "set"}):null;
      }
   }
}
