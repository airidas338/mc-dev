package net.minecraft.server;
import java.util.List;

public class cj extends CommandAbstract {

   public String c() {
      return "say";
   }

   public int a() {
      return 1;
   }

   public String c(ae var1) {
      return "commands.say.usage";
   }

   public void a(ae var1, String[] var2) throws di {
      if(var2.length > 0 && var2[0].length() > 0) {
         IChatBaseComponent var3 = b(var1, var2, 0, true);
         MinecraftServer.M().an().a((IChatBaseComponent)(new hz("chat.type.announcement", new Object[]{var1.e_(), var3})));
      } else {
         throw new dp("commands.say.usage", new Object[0]);
      }
   }

   public List a(ae var1, String[] var2, Location var3) {
      return var2.length >= 1?a(var2, MinecraftServer.M().I()):null;
   }
}
