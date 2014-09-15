package net.minecraft.server;
import java.util.List;

public class CommandSpawnpoint extends CommandAbstract {

   public String getCommand() {
      return "spawnpoint";
   }

   public int a() {
      return 2;
   }

   public String c(ICommandListener var1) {
      return "commands.spawnpoint.usage";
   }

   public void execute(ICommandListener var1, String[] var2) throws CommandException {
      if(var2.length > 0 && var2.length < 4) {
         throw new ExceptionUsage("commands.spawnpoint.usage", new Object[0]);
      } else {
         EntityPlayer var3 = var2.length > 0?a(var1, var2[0]):b(var1);
         Location var4 = var2.length > 3?a(var1, var2, 1, true):var3.getLocation();
         if(var3.o != null) {
            var3.a(var4, true);
            a(var1, this, "commands.spawnpoint.success", new Object[]{var3.getName(), Integer.valueOf(var4.n()), Integer.valueOf(var4.o()), Integer.valueOf(var4.p())});
         }

      }
   }

   public List tabComplete(ICommandListener var1, String[] var2, Location var3) {
      return var2.length == 1?a(var2, MinecraftServer.M().I()):(var2.length > 1 && var2.length <= 4?a(var2, 1, var3):null);
   }

   public boolean isListStart(String[] var1, int var2) {
      return var2 == 0;
   }
}
