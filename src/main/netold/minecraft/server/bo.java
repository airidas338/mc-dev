package net.minecraft.server;
import java.util.List;

public class bo extends z {

   public String c() {
      return "difficulty";
   }

   public int a() {
      return 2;
   }

   public String c(ae var1) {
      return "commands.difficulty.usage";
   }

   public void a(ae var1, String[] var2) throws di {
      if(var2.length <= 0) {
         throw new dp("commands.difficulty.usage", new Object[0]);
      } else {
         vt var3 = this.e(var2[0]);
         MinecraftServer.M().a(var3);
         a(var1, this, "commands.difficulty.success", new Object[]{new hz(var3.b(), new Object[0])});
      }
   }

   protected vt e(String var1) throws dk {
      return !var1.equalsIgnoreCase("peaceful") && !var1.equalsIgnoreCase("p")?(!var1.equalsIgnoreCase("easy") && !var1.equalsIgnoreCase("e")?(!var1.equalsIgnoreCase("normal") && !var1.equalsIgnoreCase("n")?(!var1.equalsIgnoreCase("hard") && !var1.equalsIgnoreCase("h")?vt.a(a(var1, 0, 3)):vt.d):vt.c):vt.b):vt.a;
   }

   public List a(ae var1, String[] var2, dt var3) {
      return var2.length == 1?a(var2, new String[]{"peaceful", "easy", "normal", "hard"}):null;
   }
}
