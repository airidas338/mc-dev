package net.minecraft.server;
import java.util.Random;

public abstract class BlockDiodeAbstract extends BlockDirectional {

   protected final boolean M;


   protected BlockDiodeAbstract(boolean var1) {
      super(Material.ORIENTABLE);
      this.M = var1;
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
   }

   public boolean d() {
      return false;
   }

   public boolean c(World var1, Location var2) {
      return World.a((IBlockAccess)var1, var2.b())?super.c(var1, var2):false;
   }

   public boolean d(World var1, Location var2) {
      return World.a((IBlockAccess)var1, var2.b());
   }

   public void a(World var1, Location var2, IBlock var3, Random var4) {}

   public void b(World var1, Location var2, IBlock var3, Random var4) {
      if(!this.b((IBlockAccess)var1, var2, var3)) {
         boolean var5 = this.e(var1, var2, var3);
         if(this.M && !var5) {
            var1.a(var2, this.k(var3), 2);
         } else if(!this.M) {
            var1.a(var2, this.e(var3), 2);
            if(!var5) {
               var1.a(var2, this.e(var3).c(), this.m(var3), -1);
            }
         }

      }
   }

   protected boolean l(IBlock var1) {
      return this.M;
   }

   public int b(IBlockAccess var1, Location var2, IBlock var3, EnumFacing var4) {
      return this.a(var1, var2, var3, var4);
   }

   public int a(IBlockAccess var1, Location var2, IBlock var3, EnumFacing var4) {
      return !this.l(var3)?0:(var3.b(N) == var4?this.a(var1, var2, var3):0);
   }

   public void a(World var1, Location var2, IBlock var3, Block var4) {
      if(this.d(var1, var2)) {
         this.g(var1, var2, var3);
      } else {
         this.b(var1, var2, var3, 0);
         var1.g(var2);
         EnumFacing[] var5 = EnumFacing.values();
         int var6 = var5.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            EnumFacing var8 = var5[var7];
            var1.c(var2.a(var8), (Block)this);
         }

      }
   }

   protected void g(World var1, Location var2, IBlock var3) {
      if(!this.b((IBlockAccess)var1, var2, var3)) {
         boolean var4 = this.e(var1, var2, var3);
         if((this.M && !var4 || !this.M && var4) && !var1.a(var2, (Block)this)) {
            byte var5 = -1;
            if(this.i(var1, var2, var3)) {
               var5 = -3;
            } else if(this.M) {
               var5 = -2;
            }

            var1.a(var2, this, this.d(var3), var5);
         }

      }
   }

   public boolean b(IBlockAccess var1, Location var2, IBlock var3) {
      return false;
   }

   protected boolean e(World var1, Location var2, IBlock var3) {
      return this.f(var1, var2, var3) > 0;
   }

   protected int f(World var1, Location var2, IBlock var3) {
      EnumFacing var4 = (EnumFacing)var3.b(N);
      Location var5 = var2.a(var4);
      int var6 = var1.c(var5, var4);
      if(var6 >= 15) {
         return var6;
      } else {
         IBlock var7 = var1.getData(var5);
         return Math.max(var6, var7.c() == Blocks.REDSTONE_WIRE?((Integer)var7.b(BlockRedstoneWire.O)).intValue():0);
      }
   }

   protected int c(IBlockAccess var1, Location var2, IBlock var3) {
      EnumFacing var4 = (EnumFacing)var3.b(N);
      EnumFacing var5 = var4.e();
      EnumFacing var6 = var4.f();
      return Math.max(this.c(var1, var2.a(var5), var5), this.c(var1, var2.a(var6), var6));
   }

   protected int c(IBlockAccess var1, Location var2, EnumFacing var3) {
      IBlock var4 = var1.getData(var2);
      Block var5 = var4.c();
      return this.c(var5)?(var5 == Blocks.REDSTONE_WIRE?((Integer)var4.b(BlockRedstoneWire.O)).intValue():var1.a(var2, var3)):0;
   }

   public boolean g() {
      return true;
   }

   public IBlock a(World var1, Location var2, EnumFacing var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
      return this.P().a(N, var8.aO().d());
   }

   public void a(World var1, Location var2, IBlock var3, EntityLiving var4, ItemStack var5) {
      if(this.e(var1, var2, var3)) {
         var1.a(var2, (Block)this, 1);
      }

   }

   public void c(World var1, Location var2, IBlock var3) {
      this.h(var1, var2, var3);
   }

   protected void h(World var1, Location var2, IBlock var3) {
      EnumFacing var4 = (EnumFacing)var3.b(N);
      Location var5 = var2.a(var4.d());
      var1.d(var5, this);
      var1.a(var5, (Block)this, var4);
   }

   public void d(World var1, Location var2, IBlock var3) {
      if(this.M) {
         EnumFacing[] var4 = EnumFacing.values();
         int var5 = var4.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            EnumFacing var7 = var4[var6];
            var1.c(var2.a(var7), (Block)this);
         }
      }

      super.d(var1, var2, var3);
   }

   public boolean c() {
      return false;
   }

   protected boolean c(Block var1) {
      return var1.g();
   }

   protected int a(IBlockAccess var1, Location var2, IBlock var3) {
      return 15;
   }

   public static boolean d(Block var0) {
      return Blocks.DIODE_OFF.e(var0) || Blocks.REDSTONE_COMPARATOR_OFF.e(var0);
   }

   public boolean e(Block var1) {
      return var1 == this.e(this.P()).c() || var1 == this.k(this.P()).c();
   }

   public boolean i(World var1, Location var2, IBlock var3) {
      EnumFacing var4 = ((EnumFacing)var3.b(N)).d();
      Location var5 = var2.a(var4);
      return d(var1.getData(var5).c())?var1.getData(var5).b(N) != var4:false;
   }

   protected int m(IBlock var1) {
      return this.d(var1);
   }

   protected abstract int d(IBlock var1);

   protected abstract IBlock e(IBlock var1);

   protected abstract IBlock k(IBlock var1);

   public boolean b(Block var1) {
      return this.e(var1);
   }
}
