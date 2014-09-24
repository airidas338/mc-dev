package net.minecraft.server;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class BlockSponge extends Block {

   public static final bet a = bet.a("wet");


   protected BlockSponge() {
      super(Material.SPONGE);
      this.j(this.L.b().a(a, Boolean.valueOf(false)));
      this.a(CreativeModeTab.b);
   }

   public int a(IBlockData var1) {
      return ((Boolean)var1.b(a)).booleanValue()?1:0;
   }

   public void c(World var1, Location var2, IBlockData var3) {
      this.e(var1, var2, var3);
   }

   public void doPhysics(World var1, Location var2, IBlockData var3, Block var4) {
      this.e(var1, var2, var3);
      super.doPhysics(var1, var2, var3, var4);
   }

   protected void e(World var1, Location var2, IBlockData var3) {
      if(!((Boolean)var3.b(a)).booleanValue() && this.d(var1, var2)) {
         var1.setTypeAndData(var2, var3.a(a, Boolean.valueOf(true)), 2);
         var1.triggerEffect(2001, var2, Block.getId((Block)Blocks.STATIONARY_WATER));
      }

   }

   private boolean d(World var1, Location var2) {
      LinkedList var3 = Lists.newLinkedList();
      ArrayList var4 = Lists.newArrayList();
      var3.add(new vi(var2, Integer.valueOf(0)));
      int var5 = 0;

      Location var7;
      while(!var3.isEmpty()) {
         vi var6 = (vi)var3.poll();
         var7 = (Location)var6.a();
         int var8 = ((Integer)var6.b()).intValue();
         EnumFacing[] var9 = EnumFacing.values();
         int var10 = var9.length;

         for(int var11 = 0; var11 < var10; ++var11) {
            EnumFacing var12 = var9[var11];
            Location var13 = var7.a(var12);
            if(var1.getData(var13).c().getMaterial() == Material.WATER) {
               var1.setTypeAndData(var13, Blocks.AIR.P(), 2);
               var4.add(var13);
               ++var5;
               if(var8 < 6) {
                  var3.add(new vi(var13, Integer.valueOf(var8 + 1)));
               }
            }
         }

         if(var5 > 64) {
            break;
         }
      }

      Iterator var14 = var4.iterator();

      while(var14.hasNext()) {
         var7 = (Location)var14.next();
         var1.applyPhysics(var7, Blocks.AIR);
      }

      return var5 > 0;
   }

   public IBlockData a(int var1) {
      return this.P().a(a, Boolean.valueOf((var1 & 1) == 1));
   }

   public int c(IBlockData var1) {
      return ((Boolean)var1.b(a)).booleanValue()?1:0;
   }

   protected bed e() {
      return new bed(this, new bex[]{a});
   }

}
