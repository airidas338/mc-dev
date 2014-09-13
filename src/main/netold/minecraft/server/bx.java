package net.minecraft.server;
import java.util.Arrays;
import java.util.List;

public class bx extends z {

   public List b() {
      return Arrays.asList(new String[]{"w", "msg"});
   }

   public String c() {
      return "tell";
   }

   public int a() {
      return 0;
   }

   public String c(ae var1) {
      return "commands.message.usage";
   }

   public void a(ae var1, String[] var2) throws di {
      if(var2.length < 2) {
         throw new dp("commands.message.usage", new Object[0]);
      } else {
         qw var3 = a(var1, var2[0]);
         if(var3 == var1) {
            throw new dm("commands.message.sameTarget", new Object[0]);
         } else {
            ho var4 = b(var1, var2, 1, !(var1 instanceof ahd));
            hz var5 = new hz("commands.message.display.incoming", new Object[]{var1.e_(), var4.f()});
            hz var6 = new hz("commands.message.display.outgoing", new Object[]{var3.e_(), var4.f()});
            var5.b().a(aRenamed.h).b(Boolean.valueOf(true));
            var6.b().a(aRenamed.h).b(Boolean.valueOf(true));
            var3.a((ho)var5);
            var1.a(var6);
         }
      }
   }

   public List a(ae var1, String[] var2, dt var3) {
      return a(var2, MinecraftServer.M().I());
   }

   public boolean b(String[] var1, int var2) {
      return var2 == 0;
   }
}
