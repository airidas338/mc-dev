package net.minecraft.server;
import java.util.List;

public class CommandSetBlock extends CommandAbstract {

   public String getCommand() {
      return "setblock";
   }

   public int a() {
      return 2;
   }

   public String c(ICommandListener var1) {
      return "commands.setblock.usage";
   }

   public void execute(ICommandListener var1, String[] var2) throws CommandException {
      if(var2.length < 4) {
         throw new ExceptionUsage("commands.setblock.usage", new Object[0]);
      } else {
         var1.a(ag.b, 0);
         Location var3 = a(var1, var2, 0, false);
         Block var4 = CommandAbstract.g(var1, var2[3]);
         int var5 = 0;
         if(var2.length >= 5) {
            var5 = a(var2[4], 0, 15);
         }

         World var6 = var1.getWorld();
         if(!var6.isLoaded(var3)) {
            throw new CommandException("commands.setblock.outOfWorld", new Object[0]);
         } else {
            NBTTagCompound var7 = new NBTTagCompound();
            boolean var8 = false;
            if(var2.length >= 7 && var4.isTileEntity()) {
               String var9 = a(var1, var2, 6).c();

               try {
                  var7 = gg.a(var9);
                  var8 = true;
               } catch (gf var12) {
                  throw new CommandException("commands.setblock.tagError", new Object[]{var12.getMessage()});
               }
            }

            if(var2.length >= 6) {
               if(var2[5].equals("destroy")) {
                  var6.setAir(var3, true);
                  if(var4 == Blocks.AIR) {
                     a(var1, this, "commands.setblock.success", new Object[0]);
                     return;
                  }
               } else if(var2[5].equals("keep") && !var6.isEmpty(var3)) {
                  throw new CommandException("commands.setblock.noChange", new Object[0]);
               }
            }

            TileEntity var13 = var6.getTileEntity(var3);
            if(var13 != null) {
               if(var13 instanceof IInventory) {
                  ((IInventory)var13).l();
               }

               var6.setTypeAndData(var3, Blocks.AIR.P(), var4 == Blocks.AIR?2:4);
            }

            IBlockData var10 = var4.a(var5);
            if(!var6.setTypeAndData(var3, var10, 2)) {
               throw new CommandException("commands.setblock.noChange", new Object[0]);
            } else {
               if(var8) {
                  TileEntity var11 = var6.getTileEntity(var3);
                  if(var11 != null) {
                     var7.setInt("x", var3.n());
                     var7.setInt("y", var3.o());
                     var7.setInt("z", var3.p());
                     var11.a(var7);
                  }
               }

               var6.update(var3, var10.c());
               var1.a(ag.b, 1);
               a(var1, this, "commands.setblock.success", new Object[0]);
            }
         }
      }
   }

   public List tabComplete(ICommandListener var1, String[] var2, Location var3) {
      return var2.length > 0 && var2.length <= 3?a(var2, 0, var3):(var2.length == 4?a(var2, Block.REGISTRY.c()):(var2.length == 6?a(var2, new String[]{"replace", "destroy", "keep"}):null));
   }
}
