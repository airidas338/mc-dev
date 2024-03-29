package net.minecraft.server;
import com.google.common.base.Predicate;

public class BlockLeaves11 extends BlockLeaves {

   public static final bev P = bev.a("variant", ayx.class, (Predicate)(new ayq()));


   public BlockLeaves11() {
      this.j(this.L.b().a(P, ayx.a).a(b, Boolean.valueOf(true)).a(a, Boolean.valueOf(true)));
   }

   protected void a(World var1, Location var2, IBlockData var3, int var4) {
      if(var3.b(P) == ayx.a && var1.random.nextInt(var4) == 0) {
         a(var1, var2, new ItemStack(Items.APPLE, 1, 0));
      }

   }

   protected int d(IBlockData var1) {
      return var1.b(P) == ayx.d?40:super.d(var1);
   }

   protected ItemStack i(IBlockData var1) {
      return new ItemStack(Item.getItemOf((Block)this), 1, ((ayx)var1.b(P)).a());
   }

   public IBlockData a(int var1) {
      return this.P().a(P, this.b(var1)).a(a, Boolean.valueOf((var1 & 4) == 0)).a(b, Boolean.valueOf((var1 & 8) > 0));
   }

   public int c(IBlockData var1) {
      byte var2 = 0;
      int var3 = var2 | ((ayx)var1.b(P)).a();
      if(!((Boolean)var1.b(a)).booleanValue()) {
         var3 |= 4;
      }

      if(((Boolean)var1.b(b)).booleanValue()) {
         var3 |= 8;
      }

      return var3;
   }

   public ayx b(int var1) {
      return ayx.a((var1 & 3) % 4);
   }

   protected bed e() {
      return new bed(this, new bex[]{P, b, a});
   }

   public int getDropData(IBlockData var1) {
      return ((ayx)var1.b(P)).a();
   }

   public void a(World var1, EntityHuman var2, Location var3, IBlockData var4, TileEntity var5) {
      if(!var1.isStatic && var2.bY() != null && var2.bY().getItem() == Items.be) {
         var2.b(StatisticList.MINE_BLOCK_COUNT[Block.getId((Block)this)]);
         a(var1, var3, new ItemStack(Item.getItemOf((Block)this), 1, ((ayx)var4.b(P)).a()));
      } else {
         super.a(var1, var2, var3, var4, var5);
      }
   }

}
