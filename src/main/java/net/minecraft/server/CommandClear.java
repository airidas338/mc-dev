package net.minecraft.server;
import java.util.List;

public class CommandClear extends CommandAbstract {

   public String c() {
      return "clear";
   }

   public String c(ICommandSender var1) {
      return "commands.clear.usage";
   }

   public int a() {
      return 2;
   }

   public void a(ICommandSender var1, String[] var2) throws CommandException {
      EntityPlayer var3 = var2.length == 0?b(var1):a(var1, var2[0]);
      Item var4 = var2.length >= 2?f(var1, var2[1]):null;
      int var5 = var2.length >= 3?a(var2[2], -1):-1;
      int var6 = var2.length >= 4?a(var2[3], -1):-1;
      NBTTagCompound var7 = null;
      if(var2.length >= 5) {
         try {
            var7 = gg.a(a(var2, 4));
         } catch (gf var9) {
            throw new CommandException("commands.clear.tagError", new Object[]{var9.getMessage()});
         }
      }

      if(var2.length >= 2 && var4 == null) {
         throw new CommandException("commands.clear.failure", new Object[]{var3.d_()});
      } else {
         int var8 = var3.bg.a(var4, var5, var6, var7);
         var3.bh.b();
         if(!var3.by.d) {
            var3.o();
         }

         var1.a(ag.d, var8);
         if(var8 == 0) {
            throw new CommandException("commands.clear.failure", new Object[]{var3.d_()});
         } else {
            if(var6 == 0) {
               var1.a(new ChatMessage("commands.clear.testing", new Object[]{var3.d_(), Integer.valueOf(var8)}));
            } else {
               a(var1, this, "commands.clear.success", new Object[]{var3.d_(), Integer.valueOf(var8)});
            }

         }
      }
   }

   public List a(ICommandSender var1, String[] var2, Location var3) {
      return var2.length == 1?a(var2, this.d()):(var2.length == 2?a(var2, Item.e.c()):null);
   }

   protected String[] d() {
      return MinecraftServer.M().I();
   }

   public boolean b(String[] var1, int var2) {
      return var2 == 0;
   }
}
