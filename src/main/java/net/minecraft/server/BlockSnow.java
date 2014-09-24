package net.minecraft.server;
import java.util.Random;

public class BlockSnow extends Block {

   public static final bew a = bew.a("layers", 1, 8);


   protected BlockSnow() {
      super(Material.PACKED_ICE);
      this.j(this.L.b().a(a, Integer.valueOf(1)));
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
      this.a(true);
      this.a(CreativeModeTab.c);
      this.h();
   }

   public boolean b(IBlockAccess var1, Location var2) {
      return ((Integer)var1.getData(var2).b(a)).intValue() < 5;
   }

   public AxisAlignedBB a(World var1, Location var2, IBlockData var3) {
      int var4 = ((Integer)var3.b(a)).intValue() - 1;
      float var5 = 0.125F;
      return new AxisAlignedBB((double)var2.n() + this.B, (double)var2.o() + this.C, (double)var2.p() + this.D, (double)var2.n() + this.E, (double)((float)var2.o() + (float)var4 * var5), (double)var2.p() + this.G);
   }

   public boolean c() {
      return false;
   }

   public boolean d() {
      return false;
   }

   public void h() {
      this.b(0);
   }

   public void a(IBlockAccess var1, Location var2) {
      IBlockData var3 = var1.getData(var2);
      this.b(((Integer)var3.b(a)).intValue());
   }

   protected void b(int var1) {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, (float)var1 / 8.0F, 1.0F);
   }

   public boolean canPlace(World var1, Location var2) {
      IBlockData var3 = var1.getData(var2.b());
      Block var4 = var3.c();
      return var4 != Blocks.ICE && var4 != Blocks.PACKET_ICE?(var4.getMaterial() == Material.LEAVES?true:(var4 == this && ((Integer)var3.b(a)).intValue() == 7?true:var4.c() && var4.J.isSolid())):false;
   }

   public void doPhysics(World var1, Location var2, IBlockData var3, Block var4) {
      this.e(var1, var2, var3);
   }

   private boolean e(World var1, Location var2, IBlockData var3) {
      if(!this.canPlace(var1, var2)) {
         this.b(var1, var2, var3, 0);
         var1.setAir(var2);
         return false;
      } else {
         return true;
      }
   }

   public void a(World var1, EntityHuman var2, Location var3, IBlockData var4, TileEntity var5) {
      a(var1, var3, new ItemStack(Items.aD, ((Integer)var4.b(a)).intValue() + 1, 0));
      var1.setAir(var3);
      var2.b(StatisticList.H[Block.getId((Block)this)]);
   }

   public Item a(IBlockData var1, Random var2, int var3) {
      return Items.aD;
   }

   public int a(Random var1) {
      return 0;
   }

   public void b(World var1, Location var2, IBlockData var3, Random var4) {
      if(var1.b(EnumSkyBlock.BLOCK, var2) > 11) {
         this.b(var1, var2, var1.getData(var2), 0);
         var1.setAir(var2);
      }

   }

   public IBlockData a(int var1) {
      return this.P().a(a, Integer.valueOf((var1 & 7) + 1));
   }

   public boolean f(World var1, Location var2) {
      return ((Integer)var1.getData(var2).b(a)).intValue() == 1;
   }

   public int c(IBlockData var1) {
      return ((Integer)var1.b(a)).intValue() - 1;
   }

   protected bed e() {
      return new bed(this, new bex[]{a});
   }

}
