package net.minecraft.server;
import com.mojang.authlib.GameProfile;

import java.util.List;

public class CommandPardon extends CommandAbstract {

   public String c() {
      return "pardon";
   }

   public int a() {
      return 3;
   }

   public String c(ICommandListener var1) {
      return "commands.unban.usage";
   }

   public boolean a(ICommandListener var1) {
      return MinecraftServer.M().an().i().b() && super.a(var1);
   }

   public void a(ICommandListener var1, String[] var2) throws CommandException {
      if(var2.length == 1 && var2[0].length() > 0) {
         MinecraftServer var3 = MinecraftServer.M();
         GameProfile var4 = var3.an().i().a(var2[0]);
         if(var4 == null) {
            throw new CommandException("commands.unban.failed", new Object[]{var2[0]});
         } else {
            var3.an().i().c(var4);
            a(var1, this, "commands.unban.success", new Object[]{var2[0]});
         }
      } else {
         throw new ExceptionUsage("commands.unban.usage", new Object[0]);
      }
   }

   public List a(ICommandListener var1, String[] var2, Location var3) {
      return var2.length == 1?a(var2, MinecraftServer.M().an().i().a()):null;
   }
}
