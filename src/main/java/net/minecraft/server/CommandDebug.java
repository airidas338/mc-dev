package net.minecraft.server;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommandDebug extends CommandAbstract {

   private static final Logger a = LogManager.getLogger();
   private long b;
   private int c;


   public String getCommand() {
      return "debug";
   }

   public int a() {
      return 3;
   }

   public String c(ICommandListener var1) {
      return "commands.debug.usage";
   }

   public void execute(ICommandListener var1, String[] var2) throws CommandException {
      if(var2.length < 1) {
         throw new ExceptionUsage("commands.debug.usage", new Object[0]);
      } else {
         if(var2[0].equals("start")) {
            if(var2.length != 1) {
               throw new ExceptionUsage("commands.debug.usage", new Object[0]);
            }

            a(var1, this, "commands.debug.start", new Object[0]);
            MinecraftServer.M().as();
            this.b = MinecraftServer.ax();
            this.c = MinecraftServer.M().ar();
         } else if(var2[0].equals("stop")) {
            if(var2.length != 1) {
               throw new ExceptionUsage("commands.debug.usage", new Object[0]);
            }

            if(!MinecraftServer.M().b.a) {
               throw new CommandException("commands.debug.notStarted", new Object[0]);
            }

            long var3 = MinecraftServer.ax();
            int var5 = MinecraftServer.M().ar();
            long var6 = var3 - this.b;
            int var8 = var5 - this.c;
            this.a(var6, var8);
            MinecraftServer.M().b.a = false;
            a(var1, this, "commands.debug.stop", new Object[]{Float.valueOf((float)var6 / 1000.0F), Integer.valueOf(var8)});
         } else if(var2[0].equals("chunk")) {
            if(var2.length != 4) {
               throw new ExceptionUsage("commands.debug.usage", new Object[0]);
            }

            a(var1, var2, 1, true);
         }

      }
   }

   private void a(long var1, int var3) {
      File var4 = new File(MinecraftServer.M().d("debug"), "profile-results-" + (new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss")).format(new Date()) + ".txt");
      var4.getParentFile().mkdirs();

      try {
         FileWriter var5 = new FileWriter(var4);
         var5.write(this.b(var1, var3));
         var5.close();
      } catch (Throwable var6) {
         a.error("Could not save profiler results to " + var4, var6);
      }

   }

   private String b(long var1, int var3) {
      StringBuilder var4 = new StringBuilder();
      var4.append("---- Minecraft Profiler Results ----\n");
      var4.append("// ");
      var4.append(d());
      var4.append("\n\n");
      var4.append("Time span: ").append(var1).append(" ms\n");
      var4.append("Tick span: ").append(var3).append(" ticks\n");
      var4.append("// This is approximately ").append(String.format("%.2f", new Object[]{Float.valueOf((float)var3 / ((float)var1 / 1000.0F))})).append(" ticks per second. It should be ").append(20).append(" ticks per second\n\n");
      var4.append("--- BEGIN PROFILE DUMP ---\n\n");
      this.a(0, "root", var4);
      var4.append("--- END PROFILE DUMP ---\n\n");
      return var4.toString();
   }

   private void a(int var1, String var2, StringBuilder var3) {
      List var4 = MinecraftServer.M().b.b(var2);
      if(var4 != null && var4.size() >= 3) {
         for(int var5 = 1; var5 < var4.size(); ++var5) {
            ux var6 = (ux)var4.get(var5);
            var3.append(String.format("[%02d] ", new Object[]{Integer.valueOf(var1)}));

            for(int var7 = 0; var7 < var1; ++var7) {
               var3.append(" ");
            }

            var3.append(var6.c).append(" - ").append(String.format("%.2f", new Object[]{Double.valueOf(var6.a)})).append("%/").append(String.format("%.2f", new Object[]{Double.valueOf(var6.b)})).append("%\n");
            if(!var6.c.equals("unspecified")) {
               try {
                  this.a(var1 + 1, var2 + "." + var6.c, var3);
               } catch (Exception var8) {
                  var3.append("[[ EXCEPTION ").append(var8).append(" ]]");
               }
            }
         }

      }
   }

   private static String d() {
      String[] var0 = new String[]{"Shiny numbers!", "Am I not running fast enough? :(", "I\'m working as hard as I can!", "Will I ever be good enough for you? :(", "Speedy. Zoooooom!", "Hello world", "40% better than a crash report.", "Now with extra numbers", "Now with less numbers", "Now with the same numbers", "You should add flames to things, it makes them go faster!", "Do you feel the need for... optimization?", "*cracks redstone whip*", "Maybe if you treated it better then it\'ll have more motivation to work faster! Poor server."};

      try {
         return var0[(int)(System.nanoTime() % (long)var0.length)];
      } catch (Throwable var2) {
         return "Witty comment unavailable :(";
      }
   }

   public List tabComplete(ICommandListener var1, String[] var2, Location var3) {
      return var2.length == 1?a(var2, new String[]{"start", "stop"}):null;
   }

}
