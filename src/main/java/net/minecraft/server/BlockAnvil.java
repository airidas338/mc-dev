package net.minecraft.server;
import com.google.common.base.Predicate;

public class BlockAnvil extends avt {

   public static final beu a = beu.a("facing", (Predicate)en.a);
   public static final bew b = bew.a("damage", 0, 2);


   protected BlockAnvil() {
      super(Material.HEAVY);
      this.j(this.L.b().a(a, EnumFacing.NORTH).a(b, Integer.valueOf(0)));
      this.e(0);
      this.a(CreativeModeTab.c);
   }

   public boolean d() {
      return false;
   }

   public boolean c() {
      return false;
   }

   public IBlockData a(World var1, Location var2, EnumFacing var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
      EnumFacing var9 = var8.aO().e();
      return super.a(var1, var2, var3, var4, var5, var6, var7, var8).a(a, var9).a(b, Integer.valueOf(var7 >> 2));
   }

   public boolean a(World var1, Location var2, IBlockData var3, EntityHuman var4, EnumFacing var5, float var6, float var7, float var8) {
      if(!var1.isStatic) {
         var4.a((vv)(new ata(var1, var2)));
      }

      return true;
   }

   public int a(IBlockData var1) {
      return ((Integer)var1.b(b)).intValue();
   }

   public void a(IBlockAccess var1, Location var2) {
      EnumFacing var3 = (EnumFacing)var1.getData(var2).b(a);
      if(var3.k() == el.a) {
         this.a(0.0F, 0.0F, 0.125F, 1.0F, 1.0F, 0.875F);
      } else {
         this.a(0.125F, 0.0F, 0.0F, 0.875F, 1.0F, 1.0F);
      }

   }

   protected void a(EntityFallingBlock var1) {
      var1.a(true);
   }

   public void a_(World var1, Location var2) {
      var1.b(1022, var2, 0);
   }

   public IBlockData a(int var1) {
      return this.P().a(a, EnumFacing.b(var1 & 3)).a(b, Integer.valueOf((var1 & 15) >> 2));
   }

   public int c(IBlockData var1) {
      byte var2 = 0;
      int var3 = var2 | ((EnumFacing)var1.b(a)).b();
      var3 |= ((Integer)var1.b(b)).intValue() << 2;
      return var3;
   }

   protected bed e() {
      return new bed(this, new bex[]{a, b});
   }

}
