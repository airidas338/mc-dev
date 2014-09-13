package net.minecraft.server;

public class BlockCobbleWall extends Block {

   public static final bet a = bet.a("up");
   public static final bet b = bet.a("north");
   public static final bet M = bet.a("east");
   public static final bet N = bet.a("south");
   public static final bet O = bet.a("west");
   public static final bev P = bev.a("variant", bby.class);


   public BlockCobbleWall(Block var1) {
      super(var1.J);
      this.j(this.L.b().a(a, Boolean.valueOf(false)).a(b, Boolean.valueOf(false)).a(M, Boolean.valueOf(false)).a(N, Boolean.valueOf(false)).a(O, Boolean.valueOf(false)).a(P, bby.a));
      this.c(var1.w);
      this.b(var1.x / 3.0F);
      this.a(var1.H);
      this.a(CreativeModeTab.b);
   }

   public boolean d() {
      return false;
   }

   public boolean b(IBlockAccess var1, Location var2) {
      return false;
   }

   public boolean c() {
      return false;
   }

   public void a(IBlockAccess var1, Location var2) {
      boolean var3 = this.e(var1, var2.c());
      boolean var4 = this.e(var1, var2.d());
      boolean var5 = this.e(var1, var2.e());
      boolean var6 = this.e(var1, var2.f());
      float var7 = 0.25F;
      float var8 = 0.75F;
      float var9 = 0.25F;
      float var10 = 0.75F;
      float var11 = 1.0F;
      if(var3) {
         var9 = 0.0F;
      }

      if(var4) {
         var10 = 1.0F;
      }

      if(var5) {
         var7 = 0.0F;
      }

      if(var6) {
         var8 = 1.0F;
      }

      if(var3 && var4 && !var5 && !var6) {
         var11 = 0.8125F;
         var7 = 0.3125F;
         var8 = 0.6875F;
      } else if(!var3 && !var4 && var5 && var6) {
         var11 = 0.8125F;
         var9 = 0.3125F;
         var10 = 0.6875F;
      }

      this.a(var7, 0.0F, var9, var8, var11, var10);
   }

   public AxisAlignedBB a(World var1, Location var2, IBlock var3) {
      this.a(var1, var2);
      this.F = 1.5D;
      return super.a(var1, var2, var3);
   }

   public boolean e(IBlockAccess var1, Location var2) {
      Block var3 = var1.getData(var2).c();
      return var3 == Blocks.cv?false:(var3 != this && !(var3 instanceof BlockFenceGate)?(var3.J.k() && var3.d()?var3.J != Material.PUMPKIN:false):true);
   }

   public int a(IBlock var1) {
      return ((bby)var1.b(P)).a();
   }

   public IBlock a(int var1) {
      return this.P().a(P, bby.a(var1));
   }

   public int c(IBlock var1) {
      return ((bby)var1.b(P)).a();
   }

   public IBlock a(IBlock var1, IBlockAccess var2, Location var3) {
      return var1.a(a, Boolean.valueOf(!var2.d(var3.a()))).a(b, Boolean.valueOf(this.e(var2, var3.c()))).a(M, Boolean.valueOf(this.e(var2, var3.f()))).a(N, Boolean.valueOf(this.e(var2, var3.d()))).a(O, Boolean.valueOf(this.e(var2, var3.e())));
   }

   protected bed e() {
      return new bed(this, new bex[]{a, b, M, O, N, P});
   }

}
