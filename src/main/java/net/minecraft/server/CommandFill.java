package net.minecraft.server;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CommandFill extends CommandAbstract {

   public String getCommand() {
      return "fill";
   }

   public int a() {
      return 2;
   }

   public String c(ICommandListener var1) {
      return "commands.fill.usage";
   }

   public void execute(ICommandListener var1, String[] var2) throws CommandException {
      if(var2.length < 7) {
         throw new ExceptionUsage("commands.fill.usage", new Object[0]);
      } else {
         var1.a(ag.b, 0);
         Location var3 = a(var1, var2, 0, false);
         Location var4 = a(var1, var2, 3, false);
         Block var5 = CommandAbstract.g(var1, var2[6]);
         int var6 = 0;
         if(var2.length >= 8) {
            var6 = a(var2[7], 0, 15);
         }

         Location var7 = new Location(Math.min(var3.n(), var4.n()), Math.min(var3.o(), var4.o()), Math.min(var3.p(), var4.p()));
         Location var8 = new Location(Math.max(var3.n(), var4.n()), Math.max(var3.o(), var4.o()), Math.max(var3.p(), var4.p()));
         int var9 = (var8.n() - var7.n() + 1) * (var8.o() - var7.o() + 1) * (var8.p() - var7.p() + 1);
         if(var9 > '\u8000') {
            throw new CommandException("commands.fill.tooManyBlocks", new Object[]{Integer.valueOf(var9), Integer.valueOf('\u8000')});
         } else if(var7.o() >= 0 && var8.o() < 256) {
            World var10 = var1.getWorld();

            for(int var11 = var7.p(); var11 < var8.p() + 16; var11 += 16) {
               for(int var12 = var7.n(); var12 < var8.n() + 16; var12 += 16) {
                  if(!var10.isLoaded(new Location(var12, var8.o() - var7.o(), var11))) {
                     throw new CommandException("commands.fill.outOfWorld", new Object[0]);
                  }
               }
            }

            NBTTagCompound var23 = new NBTTagCompound();
            boolean var22 = false;
            if(var2.length >= 10 && var5.x()) {
               String var13 = a(var1, var2, 9).c();

               try {
                  var23 = gg.a(var13);
                  var22 = true;
               } catch (gf var21) {
                  throw new CommandException("commands.fill.tagError", new Object[]{var21.getMessage()});
               }
            }

            ArrayList var24 = Lists.newArrayList();
            var9 = 0;

            for(int var14 = var7.p(); var14 <= var8.p(); ++var14) {
               for(int var15 = var7.o(); var15 <= var8.o(); ++var15) {
                  for(int var16 = var7.n(); var16 <= var8.n(); ++var16) {
                     Location var17 = new Location(var16, var15, var14);
                     IBlockData var19;
                     if(var2.length >= 9) {
                        if(!var2[8].equals("outline") && !var2[8].equals("hollow")) {
                           if(var2[8].equals("destroy")) {
                              var10.setAir(var17, true);
                           } else if(var2[8].equals("keep")) {
                              if(!var10.isEmpty(var17)) {
                                 continue;
                              }
                           } else if(var2[8].equals("replace") && !var5.x()) {
                              if(var2.length > 9) {
                                 Block var18 = CommandAbstract.g(var1, var2[9]);
                                 if(var10.getData(var17).c() != var18) {
                                    continue;
                                 }
                              }

                              if(var2.length > 10) {
                                 int var29 = CommandAbstract.a(var2[10]);
                                 var19 = var10.getData(var17);
                                 if(var19.c().c(var19) != var29) {
                                    continue;
                                 }
                              }
                           }
                        } else if(var16 != var7.n() && var16 != var8.n() && var15 != var7.o() && var15 != var8.o() && var14 != var7.p() && var14 != var8.p()) {
                           if(var2[8].equals("hollow")) {
                              var10.setTypeAndData(var17, Blocks.AIR.P(), 2);
                              var24.add(var17);
                           }
                           continue;
                        }
                     }

                     TileEntity var28 = var10.getTileEntity(var17);
                     if(var28 != null) {
                        if(var28 instanceof IInventory) {
                           ((IInventory)var28).l();
                        }

                        var10.setTypeAndData(var17, Blocks.BARRIER.P(), var5 == Blocks.BARRIER?2:4);
                     }

                     var19 = var5.a(var6);
                     if(var10.setTypeAndData(var17, var19, 2)) {
                        var24.add(var17);
                        ++var9;
                        if(var22) {
                           TileEntity var20 = var10.getTileEntity(var17);
                           if(var20 != null) {
                              var23.setInt("x", var17.n());
                              var23.setInt("y", var17.o());
                              var23.setInt("z", var17.p());
                              var20.a(var23);
                           }
                        }
                     }
                  }
               }
            }

            Iterator var25 = var24.iterator();

            while(var25.hasNext()) {
               Location var27 = (Location)var25.next();
               Block var26 = var10.getData(var27).c();
               var10.update(var27, var26);
            }

            if(var9 <= 0) {
               throw new CommandException("commands.fill.failed", new Object[0]);
            } else {
               var1.a(ag.b, var9);
               a(var1, this, "commands.fill.success", new Object[]{Integer.valueOf(var9)});
            }
         } else {
            throw new CommandException("commands.fill.outOfWorld", new Object[0]);
         }
      }
   }

   public List tabComplete(ICommandListener var1, String[] var2, Location var3) {
      return var2.length > 0 && var2.length <= 3?a(var2, 0, var3):(var2.length > 3 && var2.length <= 6?a(var2, 3, var3):(var2.length == 7?a(var2, Block.REGISTRY.c()):(var2.length == 9?a(var2, new String[]{"replace", "destroy", "keep", "hollow", "outline"}):null)));
   }
}
