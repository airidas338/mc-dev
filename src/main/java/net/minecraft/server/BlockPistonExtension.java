package net.minecraft.server;
import java.util.List;
import java.util.Random;

public class BlockPistonExtension extends Block {

   public static final beu a = beu.a("facing");
   public static final bev b = bev.a("type", bdu.class);
   public static final bet M = bet.a("short");


   public BlockPistonExtension() {
      super(Material.PISTON);
      this.j(this.L.b().a(a, EnumFacing.NORTH).a(b, bdu.a).a(M, Boolean.valueOf(false)));
      this.a(i);
      this.c(0.5F);
   }

   public void a(World var1, Location var2, IBlockData var3, EntityHuman var4) {
      if(var4.abilities.canInstantlyBuild) {
         EnumFacing var5 = (EnumFacing)var3.b(a);
         if(var5 != null) {
            Location var6 = var2.a(var5.d());
            Block var7 = var1.getData(var6).c();
            if(var7 == Blocks.PISTON || var7 == Blocks.PISTON_STICKEY) {
               var1.setAir(var6);
            }
         }
      }

      super.a(var1, var2, var3, var4);
   }

   public void remove(World var1, Location var2, IBlockData var3) {
      super.remove(var1, var2, var3);
      EnumFacing var4 = ((EnumFacing)var3.b(a)).d();
      var2 = var2.a(var4);
      IBlockData var5 = var1.getData(var2);
      if((var5.c() == Blocks.PISTON || var5.c() == Blocks.PISTON_STICKEY) && ((Boolean)var5.b(BlockPiston.b)).booleanValue()) {
         var5.c().b(var1, var2, var5, 0);
         var1.setAir(var2);
      }

   }

   public boolean c() {
      return false;
   }

   public boolean d() {
      return false;
   }

   public boolean canPlace(World var1, Location var2) {
      return false;
   }

   public boolean canPlace(World var1, Location var2, EnumFacing var3) {
      return false;
   }

   public int a(Random var1) {
      return 0;
   }

   public void a(World var1, Location var2, IBlockData var3, AxisAlignedBB var4, List var5, Entity var6) {
      this.d(var3);
      super.a(var1, var2, var3, var4, var5, var6);
      this.e(var3);
      super.a(var1, var2, var3, var4, var5, var6);
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   private void e(IBlockData var1) {
      float var2 = 0.25F;
      float var3 = 0.375F;
      float var4 = 0.625F;
      float var5 = 0.25F;
      float var6 = 0.75F;
      switch(bdt.a[((EnumFacing)var1.b(a)).ordinal()]) {
      case 1:
         this.a(0.375F, 0.25F, 0.375F, 0.625F, 1.0F, 0.625F);
         break;
      case 2:
         this.a(0.375F, 0.0F, 0.375F, 0.625F, 0.75F, 0.625F);
         break;
      case 3:
         this.a(0.25F, 0.375F, 0.25F, 0.75F, 0.625F, 1.0F);
         break;
      case 4:
         this.a(0.25F, 0.375F, 0.0F, 0.75F, 0.625F, 0.75F);
         break;
      case 5:
         this.a(0.375F, 0.25F, 0.25F, 0.625F, 0.75F, 1.0F);
         break;
      case 6:
         this.a(0.0F, 0.375F, 0.25F, 0.75F, 0.625F, 0.75F);
      }

   }

   public void updateShape(IBlockAccess var1, Location var2) {
      this.d(var1.getData(var2));
   }

   public void d(IBlockData var1) {
      float var2 = 0.25F;
      EnumFacing var3 = (EnumFacing)var1.b(a);
      if(var3 != null) {
         switch(bdt.a[var3.ordinal()]) {
         case 1:
            this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
            break;
         case 2:
            this.a(0.0F, 0.75F, 0.0F, 1.0F, 1.0F, 1.0F);
            break;
         case 3:
            this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.25F);
            break;
         case 4:
            this.a(0.0F, 0.0F, 0.75F, 1.0F, 1.0F, 1.0F);
            break;
         case 5:
            this.a(0.0F, 0.0F, 0.0F, 0.25F, 1.0F, 1.0F);
            break;
         case 6:
            this.a(0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
         }

      }
   }

   public void doPhysics(World var1, Location var2, IBlockData var3, Block var4) {
      EnumFacing var5 = (EnumFacing)var3.b(a);
      Location var6 = var2.a(var5.d());
      IBlockData var7 = var1.getData(var6);
      if(var7.c() != Blocks.PISTON && var7.c() != Blocks.PISTON_STICKEY) {
         var1.setAir(var2);
      } else {
         var7.c().doPhysics(var1, var6, var7, var4);
      }

   }

   public static EnumFacing b(int var0) {
      int var1 = var0 & 7;
      return var1 > 5?null:EnumFacing.a(var1);
   }

   public IBlockData a(int var1) {
      return this.P().a(a, b(var1)).a(b, (var1 & 8) > 0?bdu.b:bdu.a);
   }

   public int c(IBlockData var1) {
      byte var2 = 0;
      int var3 = var2 | ((EnumFacing)var1.b(a)).a();
      if(var1.b(b) == bdu.b) {
         var3 |= 8;
      }

      return var3;
   }

   protected bed e() {
      return new bed(this, new bex[]{a, b, M});
   }

}
