package net.minecraft.server;

public abstract class BlockMinecartTrackAbstract extends Block {

   protected final boolean a;


   public static boolean d(World var0, Location var1) {
      return d(var0.getData(var1));
   }

   public static boolean d(IBlockData var0) {
      Block var1 = var0.c();
      return var1 == Blocks.RAILS || var1 == Blocks.GOLDEN_RAIL || var1 == Blocks.DETECTOR_RAIL || var1 == Blocks.ACTIVATOR_RAIL;
   }

   protected BlockMinecartTrackAbstract(boolean var1) {
      super(Material.ORIENTABLE);
      this.a = var1;
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
      this.a(CreativeModeTab.e);
   }

   public AxisAlignedBB a(World var1, Location var2, IBlockData var3) {
      return null;
   }

   public boolean c() {
      return false;
   }

   public MovingObjectPosition a(World var1, Location var2, Vec3D var3, Vec3D var4) {
      this.a(var1, var2);
      return super.a(var1, var2, var3, var4);
   }

   public void a(IBlockAccess var1, Location var2) {
      IBlockData var3 = var1.getData(var2);
      atl var4 = var3.c() == this?(atl)var3.b(this.l()):null;
      if(var4 != null && var4.c()) {
         this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.625F, 1.0F);
      } else {
         this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
      }

   }

   public boolean d() {
      return false;
   }

   public boolean canPlace(World var1, Location var2) {
      return World.a((IBlockAccess)var1, var2.b());
   }

   public void c(World var1, Location var2, IBlockData var3) {
      if(!var1.isStatic) {
         var3 = this.a(var1, var2, var3, true);
         if(this.a) {
            this.a(var1, var2, var3, (Block)this);
         }
      }

   }

   public void a(World var1, Location var2, IBlockData var3, Block var4) {
      if(!var1.isStatic) {
         atl var5 = (atl)var3.b(this.l());
         boolean var6 = false;
         if(!World.a((IBlockAccess)var1, var2.b())) {
            var6 = true;
         }

         if(var5 == atl.c && !World.a((IBlockAccess)var1, var2.f())) {
            var6 = true;
         } else if(var5 == atl.d && !World.a((IBlockAccess)var1, var2.e())) {
            var6 = true;
         } else if(var5 == atl.e && !World.a((IBlockAccess)var1, var2.c())) {
            var6 = true;
         } else if(var5 == atl.f && !World.a((IBlockAccess)var1, var2.d())) {
            var6 = true;
         }

         if(var6) {
            this.b(var1, var2, var3, 0);
            var1.g(var2);
         } else {
            this.b(var1, var2, var3, var4);
         }

      }
   }

   protected void b(World var1, Location var2, IBlockData var3, Block var4) {}

   protected IBlockData a(World var1, Location var2, IBlockData var3, boolean var4) {
      return var1.isStatic?var3:(new atk(this, var1, var2, var3)).a(var1.z(var2), var4).b();
   }

   public int i() {
      return 0;
   }

   public void remove(World var1, Location var2, IBlockData var3) {
      super.remove(var1, var2, var3);
      if(((atl)var3.b(this.l())).c()) {
         var1.c(var2.a(), (Block)this);
      }

      if(this.a) {
         var1.c(var2, (Block)this);
         var1.c(var2.b(), (Block)this);
      }

   }

   public abstract bex l();
}
