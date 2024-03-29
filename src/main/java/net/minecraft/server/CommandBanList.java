package net.minecraft.server;
import java.util.List;

public class CommandBanList extends CommandAbstract {

   public String getCommand() {
      return "banlist";
   }

   public int a() {
      return 3;
   }

   public boolean canUse(ICommandListener var1) {
      return (MinecraftServer.M().an().j().b() || MinecraftServer.M().an().i().b()) && super.canUse(var1);
   }

   public String c(ICommandListener var1) {
      return "commands.banlist.usage";
   }

   public void execute(ICommandListener var1, String[] var2) throws CommandException {
      if(var2.length >= 1 && var2[0].equalsIgnoreCase("ips")) {
         var1.sendMessage(new ChatMessage("commands.banlist.ips", new Object[]{Integer.valueOf(MinecraftServer.M().an().j().a().length)}));
         var1.sendMessage(new ChatComponentText(a(MinecraftServer.M().an().j().a())));
      } else {
         var1.sendMessage(new ChatMessage("commands.banlist.players", new Object[]{Integer.valueOf(MinecraftServer.M().an().i().a().length)}));
         var1.sendMessage(new ChatComponentText(a(MinecraftServer.M().an().i().a())));
      }

   }

   public List tabComplete(ICommandListener var1, String[] var2, Location var3) {
      return var2.length == 1?a(var2, new String[]{"players", "ips"}):null;
   }
}
