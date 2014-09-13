package net.minecraft.server;
import java.util.List;
import java.util.regex.Matcher;

public class ca extends z {

   public String c() {
      return "pardon-ip";
   }

   public int a() {
      return 3;
   }

   public boolean a(ae var1) {
      return MinecraftServer.M().an().j().b() && super.a(var1);
   }

   public String c(ae var1) {
      return "commands.unbanip.usage";
   }

   public void a(ae var1, String[] var2) throws di {
      if(var2.length == 1 && var2[0].length() > 1) {
         Matcher var3 = aw.a.matcher(var2[0]);
         if(var3.matches()) {
            MinecraftServer.M().an().j().c(var2[0]);
            a(var1, this, "commands.unbanip.success", new Object[]{var2[0]});
         } else {
            throw new dl("commands.unbanip.invalid", new Object[0]);
         }
      } else {
         throw new dp("commands.unbanip.usage", new Object[0]);
      }
   }

   public List a(ae var1, String[] var2, dt var3) {
      return var2.length == 1?a(var2, MinecraftServer.M().an().j().a()):null;
   }
}
