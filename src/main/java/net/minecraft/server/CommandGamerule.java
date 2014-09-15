package net.minecraft.server;
import java.util.Iterator;
import java.util.List;

public class CommandGamerule extends CommandAbstract {

   public String getCommand() {
      return "gamerule";
   }

   public int a() {
      return 2;
   }

   public String c(ICommandListener var1) {
      return "commands.gamerule.usage";
   }

   public void execute(ICommandListener var1, String[] var2) throws CommandException {
      aqq var3 = this.d();
      String var4 = var2.length > 0?var2[0]:"";
      String var5 = var2.length > 1?a(var2, 1):"";
      switch(var2.length) {
      case 0:
         var1.sendMessage(new ChatComponentText(a(var3.b())));
         break;
      case 1:
         if(!var3.e(var4)) {
            throw new CommandException("commands.gamerule.norule", new Object[]{var4});
         }

         String var6 = var3.a(var4);
         var1.sendMessage((new ChatComponentText(var4)).a(" = ").a(var6));
         var1.a(ag.e, var3.c(var4));
         break;
      default:
         if(var3.a(var4, aqs.b) && !"true".equals(var5) && !"false".equals(var5)) {
            throw new CommandException("commands.generic.boolean.invalid", new Object[]{var5});
         }

         var3.a(var4, var5);
         a(var3, var4);
         a(var1, this, "commands.gamerule.success", new Object[0]);
      }

   }

   public static void a(aqq var0, String var1) {
      if("reducedDebugInfo".equals(var1)) {
         int var2 = var0.b(var1)?22:23;
         Iterator var3 = MinecraftServer.M().an().e.iterator();

         while(var3.hasNext()) {
            EntityPlayer var4 = (EntityPlayer)var3.next();
            var4.a.sendPacket((Packet)(new jk(var4, (byte)var2)));
         }
      }

   }

   public List tabComplete(ICommandListener var1, String[] var2, Location var3) {
      if(var2.length == 1) {
         return a(var2, this.d().b());
      } else {
         if(var2.length == 2) {
            aqq var4 = this.d();
            if(var4.a(var2[0], aqs.b)) {
               return a(var2, new String[]{"true", "false"});
            }
         }

         return null;
      }
   }

   private aqq d() {
      return MinecraftServer.M().a(0).Q();
   }
}
