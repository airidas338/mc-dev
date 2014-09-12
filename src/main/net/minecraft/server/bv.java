package net.minecraft.server;
import java.util.List;

public class bv extends CommandAbstract {

   public String c() {
      return "banlist";
   }

   public int a() {
      return 3;
   }

   public boolean a(ae var1) {
      return (MinecraftServer.M().an().j().b() || MinecraftServer.M().an().i().b()) && super.a(var1);
   }

   public String c(ae var1) {
      return "commands.banlist.usage";
   }

   public void a(ae var1, String[] var2) throws di {
      if(var2.length >= 1 && var2[0].equalsIgnoreCase("ips")) {
         var1.a(new hz("commands.banlist.ips", new Object[]{Integer.valueOf(MinecraftServer.M().an().j().a().length)}));
         var1.a(new ChatComponentText(a(MinecraftServer.M().an().j().a())));
      } else {
         var1.a(new hz("commands.banlist.players", new Object[]{Integer.valueOf(MinecraftServer.M().an().i().a().length)}));
         var1.a(new ChatComponentText(a(MinecraftServer.M().an().i().a())));
      }

   }

   public List a(ae var1, String[] var2, Location var3) {
      return var2.length == 1?a(var2, new String[]{"players", "ips"}):null;
   }
}
