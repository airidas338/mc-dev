package net.minecraft.server;

public class bw extends CommandAbstract {

   public String c() {
      return "list";
   }

   public int a() {
      return 0;
   }

   public String c(ICommandSender var1) {
      return "commands.players.usage";
   }

   public void a(ICommandSender var1, String[] var2) throws di {
      int var3 = MinecraftServer.M().G();
      var1.a(new ChatMessage("commands.players.list", new Object[]{Integer.valueOf(var3), Integer.valueOf(MinecraftServer.M().H())}));
      var1.a(new ChatComponentText(MinecraftServer.M().an().f()));
      var1.a(ag.e, var3);
   }
}
