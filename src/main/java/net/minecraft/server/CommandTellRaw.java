package net.minecraft.server;
import com.google.gson.JsonParseException;

import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;

public class CommandTellRaw extends CommandAbstract {

   public String getCommand() {
      return "tellraw";
   }

   public int a() {
      return 2;
   }

   public String c(ICommandListener var1) {
      return "commands.tellraw.usage";
   }

   public void execute(ICommandListener var1, String[] var2) throws CommandException {
      if(var2.length < 2) {
         throw new ExceptionUsage("commands.tellraw.usage", new Object[0]);
      } else {
         EntityPlayer var3 = a(var1, var2[0]);
         String var4 = a(var2, 1);

         try {
            IChatBaseComponent var5 = hp.a(var4);
            var3.sendMessage(hq.a(var1, var5, var3));
         } catch (JsonParseException var7) {
            Throwable var6 = ExceptionUtils.getRootCause(var7);
            throw new dl("commands.tellraw.jsonException", new Object[]{var6 == null?"":var6.getMessage()});
         }
      }
   }

   public List tabComplete(ICommandListener var1, String[] var2, Location var3) {
      return var2.length == 1?a(var2, MinecraftServer.M().I()):null;
   }

   public boolean isListStart(String[] var1, int var2) {
      return var2 == 0;
   }
}
