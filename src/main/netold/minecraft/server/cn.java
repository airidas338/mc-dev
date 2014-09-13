package net.minecraft.server;
import java.util.List;

public class cn extends z {

   public String c() {
      return "setworldspawn";
   }

   public int a() {
      return 2;
   }

   public String c(ae var1) {
      return "commands.setworldspawn.usage";
   }

   public void a(ae var1, String[] var2) throws di {
      dt var3;
      if(var2.length == 0) {
         var3 = b(var1).c();
      } else {
         if(var2.length != 3 || var1.e() == null) {
            throw new dp("commands.setworldspawn.usage", new Object[0]);
         }

         var3 = a(var1, var2, 0, true);
      }

      var1.e().B(var3);
      MinecraftServer.M().an().a((id)(new lh(var3)));
      a(var1, this, "commands.setworldspawn.success", new Object[]{Integer.valueOf(var3.n()), Integer.valueOf(var3.o()), Integer.valueOf(var3.p())});
   }

   public List a(ae var1, String[] var2, dt var3) {
      return var2.length > 0 && var2.length <= 3?a(var2, 0, var3):null;
   }
}
