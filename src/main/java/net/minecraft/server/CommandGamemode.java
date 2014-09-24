package net.minecraft.server;
import java.io.IOException;
import java.util.List;

public class CommandGamemode extends CommandAbstract {

   public String getCommand() {
      return "gamemode";
   }

   public int a() {
      return 2;
   }

   public String c(ICommandListener var1) {
      return "commands.gamemode.usage";
   }

   public void execute(ICommandListener var1, String[] var2) throws CommandException {
      if(var2.length <= 0) {
         throw new ExceptionUsage("commands.gamemode.usage", new Object[0]);
      } else {
         EnumGamemode var3 = this.h(var1, var2[0]);
         EntityPlayer var4 = var2.length >= 2?a(var1, var2[1]):b(var1);
         var4.a(var3);
         var4.O = 0.0F;
         if(var1.getWorld().getGameRules().getBoolean("sendCommandFeedback")) {
            var4.sendMessage((IChatBaseComponent)(new ChatMessage("gameMode.changed", new Object[0])));
         }

         ChatMessage var5 = new ChatMessage("gameMode." + var3.b(), new Object[0]);
         if(var4 != var1) {
            a(var1, this, 1, "commands.gamemode.success.other", new Object[]{var4.getName(), var5});
         } else {
            a(var1, this, 1, "commands.gamemode.success.self", new Object[]{var5});
         }

      }
   }

   protected EnumGamemode h(ICommandListener var1, String var2) throws ExceptionInvalidNumber {
      return !var2.equalsIgnoreCase(EnumGamemode.SURVIVAL.b()) && !var2.equalsIgnoreCase("s")?(!var2.equalsIgnoreCase(EnumGamemode.CREATIVE.b()) && !var2.equalsIgnoreCase("c")?(!var2.equalsIgnoreCase(EnumGamemode.ADVENTURE.b()) && !var2.equalsIgnoreCase("a")?(!var2.equalsIgnoreCase(EnumGamemode.SPECTATOR.b()) && !var2.equalsIgnoreCase("sp")?WorldSettings.a(a(var2, 0, EnumGamemode.values().length - 2)):EnumGamemode.SPECTATOR):EnumGamemode.ADVENTURE):EnumGamemode.CREATIVE):EnumGamemode.SURVIVAL;
   }

   public List tabComplete(ICommandListener var1, String[] var2, Location var3) {
      return var2.length == 1?a(var2, new String[]{"survival", "creative", "adventure", "spectator"}):(var2.length == 2?a(var2, this.d()):null);
   }

   protected String[] d() {
      return MinecraftServer.M().I();
   }

   public boolean isListStart(String[] var1, int var2) {
      return var2 == 1;
   }
}
