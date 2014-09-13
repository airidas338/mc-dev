package net.minecraft.server;
import java.io.IOException;
import java.util.Iterator;

public class bf extends bp {

   public String c() {
      return "defaultgamemode";
   }

   public String c(ae var1) {
      return "commands.defaultgamemode.usage";
   }

   public void a(ae var1, String[] var2) throws di, IOException {
      if(var2.length <= 0) {
         throw new dp("commands.defaultgamemode.usage", new Object[0]);
      } else {
         EnumGamemode var3 = this.h(var1, var2[0]);
         this.a(var3);
         a(var1, this, "commands.defaultgamemode.success", new Object[]{new ChatMessage("gameMode." + var3.b(), new Object[0])});
      }
   }

   protected void a(EnumGamemode var1) throws IOException {
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
