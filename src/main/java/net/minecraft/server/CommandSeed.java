package net.minecraft.server;

public class CommandSeed extends CommandAbstract {

   public boolean a(ICommandSender var1) {
      return MinecraftServer.M().S() || super.a(var1);
   }

   public String c() {
      return "seed";
   }

   public int a() {
      return 2;
   }

   public String c(ICommandSender var1) {
      return "commands.seed.usage";
   }

   public void a(ICommandSender var1, String[] var2) throws CommandException {
      Object var3 = var1 instanceof EntityHuman?((EntityHuman)var1).o:MinecraftServer.M().a(0);
      var1.a(new ChatMessage("commands.seed.success", new Object[]{Long.valueOf(((World)var3).J())}));
   }
}