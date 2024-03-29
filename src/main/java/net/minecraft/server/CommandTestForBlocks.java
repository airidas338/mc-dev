package net.minecraft.server;
import java.util.List;

public class CommandTestForBlocks extends CommandAbstract {

   public String getCommand() {
      return "testforblocks";
   }

   public int a() {
      return 2;
   }

   public String c(ICommandListener var1) {
      return "commands.compare.usage";
   }

   public void execute(ICommandListener var1, String[] var2) throws CommandException {
      if(var2.length < 9) {
         throw new ExceptionUsage("commands.compare.usage", new Object[0]);
      } else {
         var1.a(ag.b, 0);
         Location var3 = a(var1, var2, 0, false);
         Location var4 = a(var1, var2, 3, false);
         Location var5 = a(var1, var2, 6, false);
         bjb var6 = new bjb(var3, var4);
         bjb var7 = new bjb(var5, var5.a(var6.b()));
         int var8 = var6.c() * var6.d() * var6.e();
         if(var8 > 524288) {
            throw new CommandException("commands.compare.tooManyBlocks", new Object[]{Integer.valueOf(var8), Integer.valueOf(524288)});
         } else if(var6.b >= 0 && var6.e < 256 && var7.b >= 0 && var7.e < 256) {
            World var9 = var1.getWorld();
            if(var9.a(var6) && var9.a(var7)) {
               boolean var10 = false;
               if(var2.length > 9 && var2[9].equals("masked")) {
                  var10 = true;
               }

               var8 = 0;
               Location var11 = new Location(var7.a - var6.a, var7.b - var6.b, var7.c - var6.c);

               for(int var12 = var6.c; var12 <= var6.f; ++var12) {
                  for(int var13 = var6.b; var13 <= var6.e; ++var13) {
                     for(int var14 = var6.a; var14 <= var6.d; ++var14) {
                        Location var15 = new Location(var14, var13, var12);
                        Location var16 = var15.a((ChunkCoordinates)var11);
                        boolean var17 = false;
                        IBlockData var18 = var9.getData(var15);
                        if(!var10 || var18.c() != Blocks.AIR) {
                           if(var18 == var9.getData(var16)) {
                              TileEntity var19 = var9.getTileEntity(var15);
                              TileEntity var20 = var9.getTileEntity(var16);
                              if(var19 != null && var20 != null) {
                                 NBTTagCompound var21 = new NBTTagCompound();
                                 var19.b(var21);
                                 var21.remove("x");
                                 var21.remove("y");
                                 var21.remove("z");
                                 NBTTagCompound var22 = new NBTTagCompound();
                                 var20.b(var22);
                                 var22.remove("x");
                                 var22.remove("y");
                                 var22.remove("z");
                                 if(!var21.equals(var22)) {
                                    var17 = true;
                                 }
                              } else if(var19 != null) {
                                 var17 = true;
                              }
                           } else {
                              var17 = true;
                           }

                           ++var8;
                           if(var17) {
                              throw new CommandException("commands.compare.failed", new Object[0]);
                           }
                        }
                     }
                  }
               }

               var1.a(ag.b, var8);
               a(var1, this, "commands.compare.success", new Object[]{Integer.valueOf(var8)});
            } else {
               throw new CommandException("commands.compare.outOfWorld", new Object[0]);
            }
         } else {
            throw new CommandException("commands.compare.outOfWorld", new Object[0]);
         }
      }
   }

   public List tabComplete(ICommandListener var1, String[] var2, Location var3) {
      return var2.length > 0 && var2.length <= 3?a(var2, 0, var3):(var2.length > 3 && var2.length <= 6?a(var2, 3, var3):(var2.length > 6 && var2.length <= 9?a(var2, 6, var3):(var2.length == 10?a(var2, new String[]{"masked", "all"}):null)));
   }
}
