package net.minecraft.server;
import java.util.Iterator;
import java.util.Random;

public class BlockCactus extends Block {

   public static final bew a = bew.a("age", 0, 15);


   protected BlockCactus() {
      super(Material.CACTUS);
      this.j(this.L.b().a(a, Integer.valueOf(0)));
      this.a(true);
      this.a(CreativeModeTab.c);
   }

   public void b(World var1, Location var2, IBlockData var3, Random var4) {
      Location var5 = var2.a();
      if(var1.isEmpty(var5)) {
         int var6;
         for(var6 = 1; var1.getData(var2.c(var6)).c() == this; ++var6) {
            ;
         }

         if(var6 < 3) {
            int var7 = ((Integer)var3.b(a)).intValue();
            if(var7 == 15) {
               var1.a(var5, this.P());
               IBlockData var8 = var3.a(a, Integer.valueOf(0));
               var1.a(var2, var8, 4);
               this.a(var1, var5, var8, (Block)this);
            } else {
               var1.a(var2, var3.a(a, Integer.valueOf(var7 + 1)), 4);
            }

         }
      }
   }

   public AxisAlignedBB a(World var1, Location var2, IBlockData var3) {
      float var4 = 0.0625F;
      return new AxisAlignedBB((double)((float)var2.n() + var4), (double)var2.o(), (double)((float)var2.p() + var4), (double)((float)(var2.n() + 1) - var4), (double)((float)(var2.o() + 1) - var4), (double)((float)(var2.p() + 1) - var4));
   }

   public boolean d() {
      return false;
   }

   public boolean c() {
      return false;
   }

   public boolean canPlace(World var1, Location var2) {
      return super.canPlace(var1, var2)?this.d(var1, var2):false;
   }

   public void a(World var1, Location var2, IBlockData var3, Block var4) {
      if(!this.d(var1, var2)) {
         var1.b(var2, true);
      }

   }

   public boolean d(World var1, Location var2) {
      Iterator var3 = en.a.iterator();

      while(var3.hasNext()) {
         EnumFacing var4 = (EnumFacing)var3.next();
         if(var1.getData(var2.a(var4)).c().getMaterial().isBuildable()) {
            return false;
         }
      }

      Block var5 = var1.getData(var2.b()).c();
      return var5 == Blocks.CACTUS || var5 == Blocks.SAND;
   }

   public void a(World var1, Location var2, IBlockData var3, Entity var4) {
      var4.a(DamageSource.CACTUS, 1.0F);
   }

   public IBlockData a(int var1) {
      return this.P().a(a, Integer.valueOf(var1));
   }

   public int c(IBlockData var1) {
      return ((Integer)var1.b(a)).intValue();
   }

   protected bed e() {
      return new bed(this, new bex[]{a});
   }

}
