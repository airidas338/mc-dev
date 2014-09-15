package net.minecraft.server;
import com.mojang.authlib.GameProfile;

import java.util.Date;
import java.util.List;

public class CommandBan extends CommandAbstract {

   public String getCommand() {
      return "ban";
   }

   public int a() {
      return 3;
   }

   public String c(ICommandListener var1) {
      return "commands.ban.usage";
   }

   public boolean canUse(ICommandListener var1) {
      return MinecraftServer.M().an().i().b() && super.canUse(var1);
   }

   public void execute(ICommandListener var1, String[] var2) throws CommandException {
      if(var2.length >= 1 && var2[0].length() > 0) {
         MinecraftServer var3 = MinecraftServer.M();
         GameProfile var4 = var3.aD().getProfile(var2[0]);
         if(var4 == null) {
            throw new CommandException("commands.ban.failed", new Object[]{var2[0]});
         } else {
            String var5 = null;
            if(var2.length >= 2) {
               var5 = a(var1, var2, 1).c();
            }

            GameProfileBanEntry var6 = new GameProfileBanEntry(var4, (Date)null, var1.getName(), (Date)null, var5);
            var3.an().i().a((JsonListEntry)var6);
            EntityPlayer var7 = var3.an().a(var2[0]);
            if(var7 != null) {
               var7.a.c("You are banned from this server.");
            }

            a(var1, this, "commands.ban.success", new Object[]{var2[0]});
         }
      } else {
         throw new ExceptionUsage("commands.ban.usage", new Object[0]);
      }
   }

   public List tabComplete(ICommandListener var1, String[] var2, Location var3) {
      return var2.length >= 1?a(var2, MinecraftServer.M().I()):null;
   }
}
