package net.minecraft.server;

public class CommandList extends CommandAbstract {

   public String getCommand() {
      return "list";
   }

   public int a() {
      return 0;
   }

   public String c(ICommandListener var1) {
      return "commands.players.usage";
   }

   public void execute(ICommandListener var1, String[] var2) throws CommandException {
      int var3 = MinecraftServer.M().G();
      var1.sendMessage(new ChatMessage("commands.players.list", new Object[]{Integer.valueOf(var3), Integer.valueOf(MinecraftServer.M().H())}));
      var1.sendMessage(new ChatComponentText(MinecraftServer.M().an().f()));
      var1.a(ag.e, var3);
   }
}
