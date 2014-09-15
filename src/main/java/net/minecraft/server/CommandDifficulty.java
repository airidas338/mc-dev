package net.minecraft.server;
import java.util.List;

public class CommandDifficulty extends CommandAbstract {

   public String getCommand() {
      return "difficulty";
   }

   public int a() {
      return 2;
   }

   public String c(ICommandListener var1) {
      return "commands.difficulty.usage";
   }

   public void execute(ICommandListener var1, String[] var2) throws CommandException {
      if(var2.length <= 0) {
         throw new ExceptionUsage("commands.difficulty.usage", new Object[0]);
      } else {
         EnumDifficulty var3 = this.e(var2[0]);
         MinecraftServer.M().a(var3);
         a(var1, this, "commands.difficulty.success", new Object[]{new ChatMessage(var3.b(), new Object[0])});
      }
   }

   protected EnumDifficulty e(String var1) throws ExceptionInvalidNumber {
      return !var1.equalsIgnoreCase("peaceful") && !var1.equalsIgnoreCase("p")?(!var1.equalsIgnoreCase("easy") && !var1.equalsIgnoreCase("e")?(!var1.equalsIgnoreCase("normal") && !var1.equalsIgnoreCase("n")?(!var1.equalsIgnoreCase("hard") && !var1.equalsIgnoreCase("h")?EnumDifficulty.getById(a(var1, 0, 3)):EnumDifficulty.HARD):EnumDifficulty.NORMAL):EnumDifficulty.EASY):EnumDifficulty.PEACEFUL;
   }

   public List tabComplete(ICommandListener var1, String[] var2, Location var3) {
      return var2.length == 1?a(var2, new String[]{"peaceful", "easy", "normal", "hard"}):null;
   }
}
