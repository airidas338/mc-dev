package net.minecraft.server;

public class CommandSeed extends CommandAbstract {

   public boolean canUse(ICommandListener var1) {
      return MinecraftServer.M().S() || super.canUse(var1);
   }

   public String getCommand() {
      return "seed";
   }

   public int a() {
      return 2;
   }

   public String c(ICommandListener var1) {
      return "commands.seed.usage";
   }

   public void execute(ICommandListener var1, String[] var2) throws CommandException {
      Object var3 = var1 instanceof EntityHuman?((EntityHuman)var1).o:MinecraftServer.M().a(0);
      var1.sendMessage(new ChatMessage("commands.seed.success", new Object[]{Long.valueOf(((World)var3).J())}));
   }
}
