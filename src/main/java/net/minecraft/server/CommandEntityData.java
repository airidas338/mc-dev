package net.minecraft.server;
import java.util.List;

public class CommandEntityData extends CommandAbstract {

   public String getCommand() {
      return "entitydata";
   }

   public int a() {
      return 2;
   }

   public String c(ICommandListener var1) {
      return "commands.entitydata.usage";
   }

   public void execute(ICommandListener var1, String[] var2) throws CommandException {
      if(var2.length < 2) {
         throw new ExceptionUsage("commands.entitydata.usage", new Object[0]);
      } else {
         Entity var3 = b(var1, var2[0]);
         if(var3 instanceof EntityHuman) {
            throw new CommandException("commands.entitydata.noPlayers", new Object[]{var3.getScoreboardDisplayName()});
         } else {
            NBTTagCompound var4 = new NBTTagCompound();
            var3.e(var4);
            NBTTagCompound var5 = (NBTTagCompound)var4.b();

            NBTTagCompound var6;
            try {
               var6 = gg.a(a(var1, var2, 1).c());
            } catch (gf var8) {
               throw new CommandException("commands.entitydata.tagError", new Object[]{var8.getMessage()});
            }

            var6.o("UUIDMost");
            var6.o("UUIDLeast");
            var4.a(var6);
            if(var4.equals(var5)) {
               throw new CommandException("commands.entitydata.failed", new Object[]{var4.toString()});
            } else {
               var3.f(var4);
               a(var1, this, "commands.entitydata.success", new Object[]{var4.toString()});
            }
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
