package net.minecraft.server;
import java.util.List;
import java.util.regex.Matcher;

public class CommandPardonIP extends CommandAbstract {

   public String c() {
      return "pardon-ip";
   }

   public int a() {
      return 3;
   }

   public boolean a(ICommandListener var1) {
      return MinecraftServer.M().an().j().b() && super.a(var1);
   }

   public String c(ICommandListener var1) {
      return "commands.unbanip.usage";
   }

   public void a(ICommandListener var1, String[] var2) throws CommandException {
      if(var2.length == 1 && var2[0].length() > 1) {
         Matcher var3 = CommandBanIp.a.matcher(var2[0]);
         if(var3.matches()) {
            MinecraftServer.M().an().j().c(var2[0]);
            a(var1, this, "commands.unbanip.success", new Object[]{var2[0]});
         } else {
            throw new dl("commands.unbanip.invalid", new Object[0]);
         }
      } else {
         throw new ExceptionUsage("commands.unbanip.usage", new Object[0]);
      }
   }

   public List a(ICommandListener var1, String[] var2, Location var3) {
      return var2.length == 1?a(var2, MinecraftServer.M().an().j().a()):null;
   }
}
