package net.minecraft.server;
import java.util.List;

public class CommandSetWorldSpawn extends CommandAbstract {

   public String getCommand() {
      return "setworldspawn";
   }

   public int a() {
      return 2;
   }

   public String c(ICommandListener var1) {
      return "commands.setworldspawn.usage";
   }

   public void execute(ICommandListener var1, String[] var2) throws CommandException {
      Location var3;
      if(var2.length == 0) {
         var3 = b(var1).getLocation();
      } else {
         if(var2.length != 3 || var1.getWorld() == null) {
            throw new ExceptionUsage("commands.setworldspawn.usage", new Object[0]);
         }

         var3 = a(var1, var2, 0, true);
      }

      var1.getWorld().B(var3);
      MinecraftServer.M().an().a((Packet)(new PacketPlayOutSpawnPosition(var3)));
      a(var1, this, "commands.setworldspawn.success", new Object[]{Integer.valueOf(var3.n()), Integer.valueOf(var3.o()), Integer.valueOf(var3.p())});
   }

   public List tabComplete(ICommandListener var1, String[] var2, Location var3) {
      return var2.length > 0 && var2.length <= 3?a(var2, 0, var3):null;
   }
}
