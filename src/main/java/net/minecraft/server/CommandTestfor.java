package net.minecraft.server;
import java.util.List;

public class CommandTestfor extends CommandAbstract {

   public String c() {
      return "testfor";
   }

   public int a() {
      return 2;
   }

   public String c(ICommandSender var1) {
      return "commands.testfor.usage";
   }

   public void a(ICommandSender var1, String[] var2) throws CommandException {
      if(var2.length < 1) {
         throw new ExceptionUsage("commands.testfor.usage", new Object[0]);
      } else {
         Entity var3 = b(var1, var2[0]);
         NBTTagCompound var4 = null;
         if(var2.length >= 2) {
            try {
               var4 = gg.a(a(var2, 1));
            } catch (gf var6) {
               throw new CommandException("commands.testfor.tagError", new Object[]{var6.getMessage()});
            }
         }

         if(var4 != null) {
            NBTTagCompound var5 = new NBTTagCompound();
            var3.e(var5);
            if(!CommandTestforBlock.a(var4, var5, true)) {
               throw new CommandException("commands.testfor.failure", new Object[]{var3.d_()});
            }
         }

         a(var1, this, "commands.testfor.success", new Object[]{var3.d_()});
      }
   }

   public boolean b(String[] var1, int var2) {
      return var2 == 0;
   }

   public List a(ICommandSender var1, String[] var2, Location var3) {
      return var2.length == 1?a(var2, MinecraftServer.M().I()):null;
   }
}
