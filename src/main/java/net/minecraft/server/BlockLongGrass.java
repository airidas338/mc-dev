package net.minecraft.server;
import java.util.Random;

public class BlockLongGrass extends BlockPlant implements atz {

   public static final bev a = bev.a("type", EnumFoliage.class);


   protected BlockLongGrass() {
      super(Material.REPLACAEBLE_PLAN);
      this.j(this.L.b().a(a, EnumFoliage.a));
      float var1 = 0.4F;
      this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 0.8F, 0.5F + var1);
   }

   public boolean f(World var1, Location var2, IBlockData var3) {
      return this.c(var1.getData(var2.b()).c());
   }

   public boolean f(World var1, Location var2) {
      return true;
   }

   public Item a(IBlockData var1, Random var2, int var3) {
      return var2.nextInt(8) == 0?Items.N:null;
   }

   public int a(int var1, Random var2) {
      return 1 + var2.nextInt(var1 * 2 + 1);
   }

   public void a(World var1, EntityHuman var2, Location var3, IBlockData var4, TileEntity var5) {
      if(!var1.isStatic && var2.bY() != null && var2.bY().b() == Items.be) {
         var2.b(ty.H[Block.a((Block)this)]);
         a(var1, var3, new ItemStack(Blocks.LONG_GRASS, 1, ((EnumFoliage)var4.b(a)).a()));
      } else {
         super.a(var1, var2, var3, var4, var5);
      }

   }

   public int j(World var1, Location var2) {
      IBlockData var3 = var1.getData(var2);
      return var3.c().c(var3);
   }

   public boolean a(World var1, Location var2, IBlockData var3, boolean var4) {
      return var3.b(a) != EnumFoliage.a;
   }

   public boolean a(World var1, Random var2, Location var3, IBlockData var4) {
      return true;
   }

   public void b(World var1, Random var2, Location var3, IBlockData var4) {
      avk var5 = avk.c;
      if(var4.b(a) == EnumFoliage.c) {
         var5 = avk.d;
      }

      if(Blocks.DOUBLE_PLANT.c(var1, var3)) {
         Blocks.DOUBLE_PLANT.a(var1, var3, var5, 2);
      }

   }

   public IBlockData a(int var1) {
      return this.P().a(a, EnumFoliage.a(var1));
   }

   public int c(IBlockData var1) {
      return ((EnumFoliage)var1.b(a)).a();
   }

   protected bed e() {
      return new bed(this, new bex[]{a});
   }

}
