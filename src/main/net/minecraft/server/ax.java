package net.minecraft.server;
import com.mojang.authlib.GameProfile;

import java.util.Date;
import java.util.List;

public class ax extends CommandAbstract {

   public String c() {
      return "ban";
   }

   public int a() {
      return 3;
   }

   public String c(ae var1) {
      return "commands.ban.usage";
   }

   public boolean a(ae var1) {
      return MinecraftServer.M().an().i().b() && super.a(var1);
   }

   public void a(ae var1, String[] var2) throws di {
      if(var2.length >= 1 && var2[0].length() > 0) {
         MinecraftServer var3 = MinecraftServer.M();
         GameProfile var4 = var3.aD().a(var2[0]);
         if(var4 == null) {
            throw new di("commands.ban.failed", new Object[]{var2[0]});
         } else {
            String var5 = null;
            if(var2.length >= 2) {
               var5 = a(var1, var2, 1).c();
            }

            sw var6 = new sw(var4, (Date)null, var1.d_(), (Date)null, var5);
            var3.an().i().a((sr)var6);
            EntityPlayer var7 = var3.an().a(var2[0]);
            if(var7 != null) {
               var7.a.c("You are banned from this server.");
            }

            a(var1, this, "commands.ban.success", new Object[]{var2[0]});
         }
      } else {
         throw new dp("commands.ban.usage", new Object[0]);
      }
   }

   public List a(ae var1, String[] var2, Location var3) {
      return var2.length >= 1?a(var2, MinecraftServer.M().I()):null;
   }
}
