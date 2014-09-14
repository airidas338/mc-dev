package net.minecraft.server;

public class CommandToggleDownfall extends CommandAbstract {

   public String c() {
      return "toggledownfall";
   }

   public int a() {
      return 2;
   }

   public String c(ICommandSender var1) {
      return "commands.downfall.usage";
   }

   public void a(ICommandSender var1, String[] var2) throws CommandException {
      this.d();
      a(var1, this, "commands.downfall.success", new Object[0]);
   }

   protected void d() {
      WorldData var1 = MinecraftServer.M().c[0].P();
      var1.b(!var1.p());
   }
}
