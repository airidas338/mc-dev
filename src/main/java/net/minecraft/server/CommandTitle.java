package net.minecraft.server;
import com.google.gson.JsonParseException;

import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommandTitle extends CommandAbstract {

   private static final Logger a = LogManager.getLogger();


   public String getCommand() {
      return "title";
   }

   public int a() {
      return 2;
   }

   public String c(ICommandListener var1) {
      return "commands.title.usage";
   }

   public void execute(ICommandListener var1, String[] var2) throws CommandException {
      if(var2.length < 2) {
         throw new ExceptionUsage("commands.title.usage", new Object[0]);
      } else {
         if(var2.length < 3) {
            if("title".equals(var2[1]) || "subtitle".equals(var2[1])) {
               throw new ExceptionUsage("commands.title.usage.title", new Object[0]);
            }

            if("times".equals(var2[1])) {
               throw new ExceptionUsage("commands.title.usage.times", new Object[0]);
            }
         }

         EntityPlayer var3 = a(var1, var2[0]);
         lk var4 = lk.a(var2[1]);
         if(var4 != lk.d && var4 != lk.e) {
            if(var4 == lk.c) {
               if(var2.length != 5) {
                  throw new ExceptionUsage("commands.title.usage", new Object[0]);
               } else {
                  int var11 = a(var2[2]);
                  int var12 = a(var2[3]);
                  int var13 = a(var2[4]);
                  lj var14 = new lj(var11, var12, var13);
                  var3.a.sendPacket((Packet)var14);
                  a(var1, this, "commands.title.success", new Object[0]);
               }
            } else if(var2.length < 3) {
               throw new ExceptionUsage("commands.title.usage", new Object[0]);
            } else {
               String var10 = a(var2, 2);

               IChatBaseComponent var6;
               try {
                  var6 = hp.a(var10);
               } catch (JsonParseException var9) {
                  Throwable var8 = ExceptionUtils.getRootCause(var9);
                  throw new dl("commands.tellraw.jsonException", new Object[]{var8 == null?"":var8.getMessage()});
               }

               lj var7 = new lj(var4, hq.a(var1, var6, var3));
               var3.a.sendPacket((Packet)var7);
               a(var1, this, "commands.title.success", new Object[0]);
            }
         } else if(var2.length != 2) {
            throw new ExceptionUsage("commands.title.usage", new Object[0]);
         } else {
            lj var5 = new lj(var4, (IChatBaseComponent)null);
            var3.a.sendPacket((Packet)var5);
            a(var1, this, "commands.title.success", new Object[0]);
         }
      }
   }

   public List tabComplete(ICommandListener var1, String[] var2, Location var3) {
      return var2.length == 1?a(var2, MinecraftServer.M().I()):(var2.length == 2?a(var2, lk.a()):null);
   }

   public boolean isListStart(String[] var1, int var2) {
      return var2 == 0;
   }

}
