package net.minecraft.server;
import java.util.List;

public class bh extends CommandAbstract {

   public String c() {
      return "me";
   }

   public int a() {
      return 0;
   }

   public String c(ae var1) {
      return "commands.me.usage";
   }

   public void a(ae var1, String[] var2) throws di {
      if(var2.length <= 0) {
         throw new dp("commands.me.usage", new Object[0]);
      } else {
         IChatBaseComponent var3 = b(var1, var2, 0, !(var1 instanceof EntityHuman));
         MinecraftServer.M().an().a((IChatBaseComponent)(new hz("chat.type.emote", new Object[]{var1.e_(), var3})));
      }
   }

   public List a(ae var1, String[] var2, Location var3) {
      return a(var2, MinecraftServer.M().I());
   }
}
