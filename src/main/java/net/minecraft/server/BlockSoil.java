package net.minecraft.server;
import java.util.Iterator;
import java.util.Random;

public class BlockSoil extends Block {

   public static final bew a = bew.a("moisture", 0, 7);


   protected BlockSoil() {
      super(Material.EARTH);
      this.j(this.L.b().a(a, Integer.valueOf(0)));
      this.a(true);
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);
      this.e(255);
   }

   public AxisAlignedBB a(World var1, Location var2, IBlockData var3) {
      return new AxisAlignedBB((double)var2.n(), (double)var2.o(), (double)var2.p(), (double)(var2.n() + 1), (double)(var2.o() + 1), (double)(var2.p() + 1));
   }

   public boolean c() {
      return false;
   }

   public boolean d() {
      return false;
   }

   public void b(World var1, Location var2, IBlockData var3, Random var4) {
      int var5 = ((Integer)var3.b(a)).intValue();
      if(!this.e(var1, var2) && !var1.C(var2.a())) {
         if(var5 > 0) {
            var1.a(var2, var3.a(a, Integer.valueOf(var5 - 1)), 2);
         } else if(!this.d(var1, var2)) {
            var1.a(var2, Blocks.DIRT.P());
         }
      } else if(var5 < 7) {
         var1.a(var2, var3.a(a, Integer.valueOf(7)), 2);
      }

   }

   public void a(World var1, Location var2, Entity var3, float var4) {
      if(var3 instanceof EntityLiving) {
         if(!var1.isStatic && var1.random.nextFloat() < var4 - 0.5F) {
            if(!(var3 instanceof EntityHuman) && !var1.Q().b("mobGriefing")) {
               return;
            }

            var1.a(var2, Blocks.DIRT.P());
         }

         super.a(var1, var2, var3, var4);
      }
   }

   private boolean d(World var1, Location var2) {
      Block var3 = var1.getData(var2.a()).c();
      return var3 instanceof BlockCrops || var3 instanceof BlockStem;
   }

   private boolean e(World var1, Location var2) {
      Iterator var3 = Location.b(var2.a(-4, 0, -4), var2.a(4, 1, 4)).iterator();

      dy var4;
      do {
         if(!var3.hasNext()) {
            return false;
         }

         var4 = (dy)var3.next();
      } while(var1.getData(var4).c().r() != Material.WATER);

      return true;
   }

   public void a(World var1, Location var2, IBlockData var3, Block var4) {
      super.a(var1, var2, var3, var4);
      if(var1.getData(var2.a()).c().r().a()) {
         var1.a(var2, Blocks.DIRT.P());
      }

   }

   public Item a(IBlockData var1, Random var2, int var3) {
      return Blocks.DIRT.a(Blocks.DIRT.P().a(BlockDirt.a, avd.a), var2, var3);
   }

   public IBlockData a(int var1) {
      return this.P().a(a, Integer.valueOf(var1 & 7));
   }

   public int c(IBlockData var1) {
      return ((Integer)var1.b(a)).intValue();
   }

   protected bed e() {
      return new bed(this, new bex[]{a});
   }

}
