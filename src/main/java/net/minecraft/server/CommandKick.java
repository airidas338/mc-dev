package net.minecraft.server;
import java.util.List;

public class CommandKick extends CommandAbstract {

   public String c() {
      return "kick";
   }

   public int a() {
      return 3;
   }

   public String c(ICommandSender var1) {
      return "commands.kick.usage";
   }

   public void a(ICommandSender var1, String[] var2) throws CommandException {
      if(var2.length > 0 && var2[0].length() > 1) {
         EntityPlayer var3 = MinecraftServer.M().an().a(var2[0]);
         String var4 = "Kicked by an operator.";
         boolean var5 = false;
         if(var3 == null) {
            throw new ExceptionPlayerNotFound();
         } else {
            if(var2.length >= 2) {
               var4 = a(var1, var2, 1).c();
               var5 = true;
            }

            var3.a.c(var4);
            if(var5) {
               a(var1, this, "commands.kick.success.reason", new Object[]{var3.d_(), var4});
            } else {
               a(var1, this, "commands.kick.success", new Object[]{var3.d_()});
            }

         }
      } else {
         throw new ExceptionUsage("commands.kick.usage", new Object[0]);
      }
   }

   public List a(ICommandSender var1, String[] var2, Location var3) {
      return var2.length >= 1?a(var2, MinecraftServer.M().I()):null;
   }
}
