package net.minecraft.server;
import java.util.List;

public class cz extends z {

   public String c() {
      return "testfor";
   }

   public int a() {
      return 2;
   }

   public String c(ae var1) {
      return "commands.testfor.usage";
   }

   public void a(ae var1, String[] var2) throws di {
      if(var2.length < 1) {
         throw new dp("commands.testfor.usage", new Object[0]);
      } else {
         wv var3 = b(var1, var2[0]);
         fn var4 = null;
         if(var2.length >= 2) {
            try {
               var4 = gg.a(a(var2, 1));
            } catch (gf var6) {
               throw new di("commands.testfor.tagError", new Object[]{var6.getMessage()});
            }
         }

         if(var4 != null) {
            fn var5 = new fn();
            var3.e(var5);
            if(!cy.a(var4, var5, true)) {
               throw new di("commands.testfor.failure", new Object[]{var3.d_()});
            }
         }

         a(var1, this, "commands.testfor.success", new Object[]{var3.d_()});
      }
   }

   public boolean b(String[] var1, int var2) {
      return var2 == 0;
   }

   public List a(ae var1, String[] var2, dt var3) {
      return var2.length == 1?a(var2, MinecraftServer.M().I()):null;
   }
}
