package net.minecraft.server;
import com.mojang.authlib.GameProfile;

import java.util.List;

public class CommandDeop extends CommandAbstract {

   public String c() {
      return "deop";
   }

   public int a() {
      return 3;
   }

   public String c(ICommandSender var1) {
      return "commands.deop.usage";
   }

   public void a(ICommandSender var1, String[] var2) throws CommandException {
      if(var2.length == 1 && var2[0].length() > 0) {
         MinecraftServer var3 = MinecraftServer.M();
         GameProfile var4 = var3.an().n().a(var2[0]);
         if(var4 == null) {
            throw new CommandException("commands.deop.failed", new Object[]{var2[0]});
         } else {
            var3.an().b(var4);
            a(var1, this, "commands.deop.success", new Object[]{var2[0]});
         }
      } else {
         throw new ExceptionUsage("commands.deop.usage", new Object[0]);
      }
   }

   public List a(ICommandSender var1, String[] var2, Location var3) {
      return var2.length == 1?a(var2, MinecraftServer.M().an().o()):null;
   }
}
