package net.minecraft.server;

public class BlockCarpet extends Block {

   public static final bev a = bev.a("color", akv.class);


   protected BlockCarpet() {
      super(Material.WOOL);
      this.j(this.L.b().a(a, akv.a));
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
      this.a(true);
      this.a(CreativeModeTab.c);
      this.b(0);
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
      this.b(0);
   }

   protected void b(int var1) {
      byte var2 = 0;
      float var3 = (float)(1 * (1 + var2)) / 16.0F;
      this.a(0.0F, 0.0F, 0.0F, 1.0F, var3, 1.0F);
   }

   public boolean canPlace(World var1, Location var2) {
      return super.canPlace(var1, var2) && this.d(var1, var2);
   }

   public void a(World var1, Location var2, IBlockData var3, Block var4) {
      this.e(var1, var2, var3);
   }

   private boolean e(World var1, Location var2, IBlockData var3) {
      if(!this.d(var1, var2)) {
         this.b(var1, var2, var3, 0);
         var1.g(var2);
         return false;
      } else {
         return true;
      }
   }

   private boolean d(World var1, Location var2) {
      return !var1.isEmpty(var2.b());
   }

   public int a(IBlockData var1) {
      return ((akv)var1.b(a)).a();
   }

   public IBlockData a(int var1) {
      return this.P().a(a, akv.b(var1));
   }

   public int c(IBlockData var1) {
      return ((akv)var1.b(a)).a();
   }

   protected bed e() {
      return new bed(this, new bex[]{a});
   }

}
