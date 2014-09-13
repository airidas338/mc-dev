package net.minecraft.server;
import java.util.List;

public class bh extends z {

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
         ho var3 = b(var1, var2, 0, !(var1 instanceof ahd));
         MinecraftServer.M().an().a((ho)(new hz("chat.type.emote", new Object[]{var1.e_(), var3})));
      }
   }

   public List a(ae var1, String[] var2, dt var3) {
      return a(var2, MinecraftServer.M().I());
   }
}
