package net.minecraft.server;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CommandClone extends CommandAbstract {

   public String getCommand() {
      return "clone";
   }

   public int a() {
      return 2;
   }

   public String c(ICommandListener var1) {
      return "commands.clone.usage";
   }

   public void execute(ICommandListener var1, String[] var2) throws CommandException {
      if(var2.length < 9) {
         throw new ExceptionUsage("commands.clone.usage", new Object[0]);
      } else {
         var1.a(ag.b, 0);
         Location var3 = a(var1, var2, 0, false);
         Location var4 = a(var1, var2, 3, false);
         Location var5 = a(var1, var2, 6, false);
         bjb var6 = new bjb(var3, var4);
         bjb var7 = new bjb(var5, var5.a(var6.b()));
         int var8 = var6.c() * var6.d() * var6.e();
         if(var8 > '\u8000') {
            throw new CommandException("commands.clone.tooManyBlocks", new Object[]{Integer.valueOf(var8), Integer.valueOf('\u8000')});
         } else {
            boolean var9 = false;
            Block var10 = null;
            int var11 = -1;
            if((var2.length < 11 || !var2[10].equals("force") && !var2[10].equals("move")) && var6.a(var7)) {
               throw new CommandException("commands.clone.noOverlap", new Object[0]);
            } else {
               if(var2.length >= 11 && var2[10].equals("move")) {
                  var9 = true;
               }

               if(var6.b >= 0 && var6.e < 256 && var7.b >= 0 && var7.e < 256) {
                  World var12 = var1.getWorld();
                  if(var12.a(var6) && var12.a(var7)) {
                     boolean var13 = false;
                     if(var2.length >= 10) {
                        if(var2[9].equals("masked")) {
                           var13 = true;
                        } else if(var2[9].equals("filtered")) {
                           if(var2.length < 12) {
                              throw new ExceptionUsage("commands.clone.usage", new Object[0]);
                           }

                           var10 = g(var1, var2[11]);
                           if(var2.length >= 13) {
                              var11 = a(var2[12], 0, 15);
                           }
                        }
                     }

                     ArrayList var14 = Lists.newArrayList();
                     ArrayList var15 = Lists.newArrayList();
                     ArrayList var16 = Lists.newArrayList();
                     LinkedList var17 = Lists.newLinkedList();
                     Location var18 = new Location(var7.a - var6.a, var7.b - var6.b, var7.c - var6.c);

                     for(int var19 = var6.c; var19 <= var6.f; ++var19) {
                        for(int var20 = var6.b; var20 <= var6.e; ++var20) {
                           for(int var21 = var6.a; var21 <= var6.d; ++var21) {
                              Location var22 = new Location(var21, var20, var19);
                              Location var23 = var22.a((ChunkCoordinates)var18);
                              IBlockData var24 = var12.getData(var22);
                              if((!var13 || var24.c() != Blocks.AIR) && (var10 == null || var24.c() == var10 && (var11 < 0 || var24.c().c(var24) == var11))) {
                                 TileEntity var25 = var12.getTileEntity(var22);
                                 if(var25 != null) {
                                    NBTTagCompound var26 = new NBTTagCompound();
                                    var25.b(var26);
                                    var15.add(new bb(var23, var24, var26));
                                    var17.addLast(var22);
                                 } else if(!var24.c().m() && !var24.c().d()) {
                                    var16.add(new bb(var23, var24, (NBTTagCompound)null));
                                    var17.addFirst(var22);
                                 } else {
                                    var14.add(new bb(var23, var24, (NBTTagCompound)null));
                                    var17.addLast(var22);
                                 }
                              }
                           }
                        }
                     }

                     if(var9) {
                        Location var27;
                        Iterator var29;
                        for(var29 = var17.iterator(); var29.hasNext(); var12.setTypeAndData(var27, Blocks.BARRIER.P(), 2)) {
                           var27 = (Location)var29.next();
                           TileEntity var34 = var12.getTileEntity(var27);
                           if(var34 instanceof IInventory) {
                              ((IInventory)var34).l();
                           }
                        }

                        var29 = var17.iterator();

                        while(var29.hasNext()) {
                           var27 = (Location)var29.next();
                           var12.setTypeAndData(var27, Blocks.AIR.P(), 3);
                        }
                     }

                     ArrayList var28 = Lists.newArrayList();
                     var28.addAll(var14);
                     var28.addAll(var15);
                     var28.addAll(var16);
                     List var33 = Lists.reverse(var28);

                     TileEntity var31;
                     bb var30;
                     Iterator var35;
                     for(var35 = var33.iterator(); var35.hasNext(); var12.setTypeAndData(var30.a, Blocks.BARRIER.P(), 2)) {
                        var30 = (bb)var35.next();
                        var31 = var12.getTileEntity(var30.a);
                        if(var31 instanceof IInventory) {
                           ((IInventory)var31).l();
                        }
                     }

                     var8 = 0;
                     var35 = var28.iterator();

                     while(var35.hasNext()) {
                        var30 = (bb)var35.next();
                        if(var12.setTypeAndData(var30.a, var30.b, 2)) {
                           ++var8;
                        }
                     }

                     for(var35 = var15.iterator(); var35.hasNext(); var12.setTypeAndData(var30.a, var30.b, 2)) {
                        var30 = (bb)var35.next();
                        var31 = var12.getTileEntity(var30.a);
                        if(var30.c != null && var31 != null) {
                           var30.c.setInt("x", var30.a.n());
                           var30.c.setInt("y", var30.a.o());
                           var30.c.setInt("z", var30.a.p());
                           var31.a(var30.c);
                           var31.o_();
                        }
                     }

                     var35 = var33.iterator();

                     while(var35.hasNext()) {
                        var30 = (bb)var35.next();
                        var12.update(var30.a, var30.b.c());
                     }

                     List var32 = var12.a(var6, false);
                     if(var32 != null) {
                        Iterator var36 = var32.iterator();

                        while(var36.hasNext()) {
                           NextTickListEntry var37 = (NextTickListEntry)var36.next();
                           if(var6.b((ChunkCoordinates)var37.a)) {
                              Location var38 = var37.a.a((ChunkCoordinates)var18);
                              var12.b(var38, var37.a(), (int)(var37.b - var12.getWorldData().getTime()), var37.c);
                           }
                        }
                     }

                     if(var8 <= 0) {
                        throw new CommandException("commands.clone.failed", new Object[0]);
                     } else {
                        var1.a(ag.b, var8);
                        a(var1, this, "commands.clone.success", new Object[]{Integer.valueOf(var8)});
                     }
                  } else {
                     throw new CommandException("commands.clone.outOfWorld", new Object[0]);
                  }
               } else {
                  throw new CommandException("commands.clone.outOfWorld", new Object[0]);
               }
            }
         }
      }
   }

   public List tabComplete(ICommandListener var1, String[] var2, Location var3) {
      return var2.length > 0 && var2.length <= 3?a(var2, 0, var3):(var2.length > 3 && var2.length <= 6?a(var2, 3, var3):(var2.length > 6 && var2.length <= 9?a(var2, 6, var3):(var2.length == 10?a(var2, new String[]{"replace", "masked", "filtered"}):(var2.length == 11?a(var2, new String[]{"normal", "force", "move"}):(var2.length == 12 && "filtered".equals(var2[9])?a(var2, Block.REGISTRY.c()):null)))));
   }
}
