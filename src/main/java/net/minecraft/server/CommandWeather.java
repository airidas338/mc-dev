package net.minecraft.server;
import java.util.List;
import java.util.Random;

public class CommandWeather extends CommandAbstract {

   public String getCommand() {
      return "weather";
   }

   public int a() {
      return 2;
   }

   public String c(ICommandListener var1) {
      return "commands.weather.usage";
   }

   public void execute(ICommandListener var1, String[] var2) throws CommandException {
      if(var2.length >= 1 && var2.length <= 2) {
         int var3 = (300 + (new Random()).nextInt(600)) * 20;
         if(var2.length >= 2) {
            var3 = a(var2[1], 1, 1000000) * 20;
         }

         WorldServer var4 = MinecraftServer.M().c[0];
         WorldData var5 = var4.getWorldData();
         if("clear".equalsIgnoreCase(var2[0])) {
            var5.i(var3);
            var5.setWeatherDuration(0);
            var5.setThunderDuration(0);
            var5.setStorm(false);
            var5.setThundering(false);
            a(var1, this, "commands.weather.clear", new Object[0]);
         } else if("rain".equalsIgnoreCase(var2[0])) {
            var5.i(0);
            var5.setWeatherDuration(var3);
            var5.setThunderDuration(var3);
            var5.setStorm(true);
            var5.setThundering(false);
            a(var1, this, "commands.weather.rain", new Object[0]);
         } else {
            if(!"thunder".equalsIgnoreCase(var2[0])) {
               throw new ExceptionUsage("commands.weather.usage", new Object[0]);
            }

            var5.i(0);
            var5.setWeatherDuration(var3);
            var5.setThunderDuration(var3);
            var5.setStorm(true);
            var5.setThundering(true);
            a(var1, this, "commands.weather.thunder", new Object[0]);
         }

      } else {
         throw new ExceptionUsage("commands.weather.usage", new Object[0]);
      }
   }

   public List tabComplete(ICommandListener var1, String[] var2, Location var3) {
      return var2.length == 1?a(var2, new String[]{"clear", "rain", "thunder"}):null;
   }
}
