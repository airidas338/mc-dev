package net.minecraft.server;
import java.io.IOException;
import java.util.Iterator;

public class CommandGamemodeDefault extends CommandGamemode {

   public String getCommand() {
      return "defaultgamemode";
   }

   public String c(ICommandListener var1) {
      return "commands.defaultgamemode.usage";
   }

   public void execute(ICommandListener var1, String[] var2) throws CommandException {
      if(var2.length <= 0) {
         throw new ExceptionUsage("commands.defaultgamemode.usage", new Object[0]);
      } else {
         EnumGamemode var3 = this.h(var1, var2[0]);
         this.a(var3);
         a(var1, this, "commands.defaultgamemode.success", new Object[]{new ChatMessage("gameMode." + var3.b(), new Object[0])});
      }
   }

   protected void a(EnumGamemode var1) {
      MinecraftServer var2 = MinecraftServer.M();
      var2.a(var1);
      EntityPlayer var4;
      if(var2.av()) {
         for(Iterator var3 = MinecraftServer.M().an().e.iterator(); var3.hasNext(); var4.O = 0.0F) {
            var4 = (EntityPlayer)var3.next();
            var4.a(var1);
         }
      }

   }
}
