package net.minecraft.server;

public class CommandSaveOn extends CommandAbstract {

   public String getCommand() {
      return "save-on";
   }

   public String c(ICommandListener var1) {
      return "commands.save-on.usage";
   }

   public void execute(ICommandListener var1, String[] var2) throws CommandException {
      MinecraftServer var3 = MinecraftServer.M();
      boolean var4 = false;

      for(int var5 = 0; var5 < var3.c.length; ++var5) {
         if(var3.c[var5] != null) {
            WorldServer var6 = var3.c[var5];
            if(var6.c) {
               var6.c = false;
               var4 = true;
            }
         }
      }

      if(var4) {
         a(var1, this, "commands.save.enabled", new Object[0]);
      } else {
         throw new CommandException("commands.save-on.alreadyOn", new Object[0]);
      }
   }
}
