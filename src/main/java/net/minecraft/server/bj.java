package net.minecraft.server;
import java.util.List;

public class bj extends CommandAbstract {

   public String c() {
      return "entitydata";
   }

   public int a() {
      return 2;
   }

   public String c(ICommandSender var1) {
      return "commands.entitydata.usage";
   }

   public void a(ICommandSender var1, String[] var2) throws di {
      if(var2.length < 2) {
         throw new dp("commands.entitydata.usage", new Object[0]);
      } else {
         Entity var3 = b(var1, var2[0]);
         if(var3 instanceof EntityHuman) {
            throw new di("commands.entitydata.noPlayers", new Object[]{var3.e_()});
         } else {
            NBTTagCompound var4 = new NBTTagCompound();
            var3.e(var4);
            NBTTagCompound var5 = (NBTTagCompound)var4.b();

            NBTTagCompound var6;
            try {
               var6 = gg.a(a(var1, var2, 1).c());
            } catch (gf var8) {
               throw new di("commands.entitydata.tagError", new Object[]{var8.getMessage()});
            }

            var6.o("UUIDMost");
            var6.o("UUIDLeast");
            var4.a(var6);
            if(var4.equals(var5)) {
               throw new di("commands.entitydata.failed", new Object[]{var4.toString()});
            } else {
               var3.f(var4);
               a(var1, this, "commands.entitydata.success", new Object[]{var4.toString()});
            }
         }
      }
   }

   public List a(ICommandSender var1, String[] var2, Location var3) {
      return var2.length == 1?a(var2, MinecraftServer.M().I()):null;
   }

   public boolean b(String[] var1, int var2) {
      return var2 == 0;
   }
}
