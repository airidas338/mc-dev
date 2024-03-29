package net.minecraft.server;
import java.util.Iterator;
import java.util.List;

public class CommandTestForBlock extends CommandAbstract {

   public String getCommand() {
      return "testforblock";
   }

   public int a() {
      return 2;
   }

   public String c(ICommandListener var1) {
      return "commands.testforblock.usage";
   }

   public void execute(ICommandListener var1, String[] var2) throws CommandException {
      if(var2.length < 4) {
         throw new ExceptionUsage("commands.testforblock.usage", new Object[0]);
      } else {
         var1.a(ag.b, 0);
         Location var3 = a(var1, var2, 0, false);
         Block var4 = Block.b(var2[3]);
         if(var4 == null) {
            throw new ExceptionInvalidNumber("commands.setblock.notFound", new Object[]{var2[3]});
         } else {
            int var5 = -1;
            if(var2.length >= 5) {
               var5 = a(var2[4], -1, 15);
            }

            World var6 = var1.getWorld();
            if(!var6.isLoaded(var3)) {
               throw new CommandException("commands.testforblock.outOfWorld", new Object[0]);
            } else {
               NBTTagCompound var7 = new NBTTagCompound();
               boolean var8 = false;
               if(var2.length >= 6 && var4.isTileEntity()) {
                  String var9 = a(var1, var2, 5).c();

                  try {
                     var7 = gg.a(var9);
                     var8 = true;
                  } catch (gf var13) {
                     throw new CommandException("commands.setblock.tagError", new Object[]{var13.getMessage()});
                  }
               }

               IBlockData var14 = var6.getData(var3);
               Block var10 = var14.c();
               if(var10 != var4) {
                  throw new CommandException("commands.testforblock.failed.tile", new Object[]{Integer.valueOf(var3.n()), Integer.valueOf(var3.o()), Integer.valueOf(var3.p()), var10.getName(), var4.getName()});
               } else {
                  if(var5 > -1) {
                     int var11 = var14.c().c(var14);
                     if(var11 != var5) {
                        throw new CommandException("commands.testforblock.failed.data", new Object[]{Integer.valueOf(var3.n()), Integer.valueOf(var3.o()), Integer.valueOf(var3.p()), Integer.valueOf(var11), Integer.valueOf(var5)});
                     }
                  }

                  if(var8) {
                     TileEntity var15 = var6.getTileEntity(var3);
                     if(var15 == null) {
                        throw new CommandException("commands.testforblock.failed.tileEntity", new Object[]{Integer.valueOf(var3.n()), Integer.valueOf(var3.o()), Integer.valueOf(var3.p())});
                     }

                     NBTTagCompound var12 = new NBTTagCompound();
                     var15.b(var12);
                     if(!a(var7, var12, true)) {
                        throw new CommandException("commands.testforblock.failed.nbt", new Object[]{Integer.valueOf(var3.n()), Integer.valueOf(var3.o()), Integer.valueOf(var3.p())});
                     }
                  }

                  var1.a(ag.b, 1);
                  a(var1, this, "commands.testforblock.success", new Object[]{Integer.valueOf(var3.n()), Integer.valueOf(var3.o()), Integer.valueOf(var3.p())});
               }
            }
         }
      }
   }

   public static boolean a(NBTBase var0, NBTBase var1, boolean var2) {
      if(var0 == var1) {
         return true;
      } else if(var0 == null) {
         return true;
      } else if(var1 == null) {
         return false;
      } else if(!var0.getClass().equals(var1.getClass())) {
         return false;
      } else if(var0 instanceof NBTTagCompound) {
         NBTTagCompound var9 = (NBTTagCompound)var0;
         NBTTagCompound var10 = (NBTTagCompound)var1;
         Iterator var11 = var9.c().iterator();

         String var12;
         NBTBase var13;
         do {
            if(!var11.hasNext()) {
               return true;
            }

            var12 = (String)var11.next();
            var13 = var9.get(var12);
         } while(a(var13, var10.get(var12), var2));

         return false;
      } else if(var0 instanceof NBTTagList && var2) {
         NBTTagList var3 = (NBTTagList)var0;
         NBTTagList var4 = (NBTTagList)var1;
         if(var3.size() == 0) {
            return var4.size() == 0;
         } else {
            int var5 = 0;

            while(var5 < var3.size()) {
               NBTBase var6 = var3.g(var5);
               boolean var7 = false;
               int var8 = 0;

               while(true) {
                  if(var8 < var4.size()) {
                     if(!a(var6, var4.g(var8), var2)) {
                        ++var8;
                        continue;
                     }

                     var7 = true;
                  }

                  if(!var7) {
                     return false;
                  }

                  ++var5;
                  break;
               }
            }

            return true;
         }
      } else {
         return var0.equals(var1);
      }
   }

   public List tabComplete(ICommandListener var1, String[] var2, Location var3) {
      return var2.length > 0 && var2.length <= 3?a(var2, 0, var3):(var2.length == 4?a(var2, Block.REGISTRY.c()):null);
   }
}
