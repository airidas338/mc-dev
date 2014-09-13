package net.minecraft.server;
import java.util.List;

public class bo extends CommandAbstract {

   public String c() {
      return "difficulty";
   }

   public int a() {
      return 2;
   }

   public String c(ICommandSender var1) {
      return "commands.difficulty.usage";
   }

   public void a(ICommandSender var1, String[] var2) throws di {
      if(var2.length <= 0) {
         throw new dp("commands.difficulty.usage", new Object[0]);
      } else {
         EnumDifficulty var3 = this.e(var2[0]);
         MinecraftServer.M().a(var3);
         a(var1, this, "commands.difficulty.success", new Object[]{new ChatMessage(var3.b(), new Object[0])});
      }
   }

   protected EnumDifficulty e(String var1) throws dk {
      return !var1.equalsIgnoreCase("peaceful") && !var1.equalsIgnoreCase("p")?(!var1.equalsIgnoreCase("easy") && !var1.equalsIgnoreCase("e")?(!var1.equalsIgnoreCase("normal") && !var1.equalsIgnoreCase("n")?(!var1.equalsIgnoreCase("hard") && !var1.equalsIgnoreCase("h")?EnumDifficulty.a(a(var1, 0, 3)):EnumDifficulty.HARD):EnumDifficulty.NORMAL):EnumDifficulty.EASY):EnumDifficulty.PEACEFUL;
   }

   public List a(ICommandSender var1, String[] var2, Location var3) {
      return var2.length == 1?a(var2, new String[]{"peaceful", "easy", "normal", "hard"}):null;
   }
}
