package net.minecraft.server;
import com.google.common.base.Predicate;

import java.util.List;
import java.util.Random;

public class BlockRedstoneComparator extends ava implements avs {

   public static final bet a = bet.a("powered");
   public static final bev b = bev.a("mode", aur.class);


   public BlockRedstoneComparator(boolean var1) {
      super(var1);
      this.j(this.L.b().a(N, EnumFacing.NORTH).a(a, Boolean.valueOf(false)).a(b, aur.a));
      this.A = true;
   }

   public Item a(IBlock var1, Random var2, int var3) {
      return Items.ce;
   }

   protected int d(IBlock var1) {
      return 2;
   }

   protected IBlock e(IBlock var1) {
      Boolean var2 = (Boolean)var1.b(a);
      aur var3 = (aur)var1.b(b);
      EnumFacing var4 = (EnumFacing)var1.b(N);
      return Blocks.ck.P().a(N, var4).a(a, var2).a(b, var3);
   }

   protected IBlock k(IBlock var1) {
      Boolean var2 = (Boolean)var1.b(a);
      aur var3 = (aur)var1.b(b);
      EnumFacing var4 = (EnumFacing)var1.b(N);
      return Blocks.cj.P().a(N, var4).a(a, var2).a(b, var3);
   }

   protected boolean l(IBlock var1) {
      return this.M || ((Boolean)var1.b(a)).booleanValue();
   }

   protected int a(IBlockAccess var1, Location var2, IBlock var3) {
      TileEntity var4 = var1.s(var2);
      return var4 instanceof bcv?((bcv)var4).b():0;
   }

   private int j(World var1, Location var2, IBlock var3) {
      return var3.b(b) == aur.b?Math.max(this.f(var1, var2, var3) - this.c((IBlockAccess)var1, var2, var3), 0):this.f(var1, var2, var3);
   }

   protected boolean e(World var1, Location var2, IBlock var3) {
      int var4 = this.f(var1, var2, var3);
      if(var4 >= 15) {
         return true;
      } else if(var4 == 0) {
         return false;
      } else {
         int var5 = this.c((IBlockAccess)var1, var2, var3);
         return var5 == 0?true:var4 >= var5;
      }
   }

   protected int f(World var1, Location var2, IBlock var3) {
      int var4 = super.f(var1, var2, var3);
      EnumFacing var5 = (EnumFacing)var3.b(N);
      Location var6 = var2.a(var5);
      Block var7 = var1.getData(var6).c();
      if(var7.N()) {
         var4 = var7.l(var1, var6);
      } else if(var4 < 15 && var7.t()) {
         var6 = var6.a(var5);
         var7 = var1.getData(var6).c();
         if(var7.N()) {
            var4 = var7.l(var1, var6);
         } else if(var7.r() == Material.AIR) {
            EntityItemFrame var8 = this.a(var1, var5, var6);
            if(var8 != null) {
               var4 = var8.q();
            }
         }
      }

      return var4;
   }

   private EntityItemFrame a(World var1, EnumFacing var2, Location var3) {
      List var4 = var1.a(EntityItemFrame.class, new AxisAlignedBB((double)var3.n(), (double)var3.o(), (double)var3.p(), (double)(var3.n() + 1), (double)(var3.o() + 1), (double)(var3.p() + 1)), (Predicate)(new auq(this, var2)));
      return var4.size() == 1?(EntityItemFrame)var4.get(0):null;
   }

   public boolean a(World var1, Location var2, IBlock var3, EntityHuman var4, EnumFacing var5, float var6, float var7, float var8) {
      if(!var4.by.e) {
         return false;
      } else {
         var3 = var3.a(b);
         var1.a((double)var2.n() + 0.5D, (double)var2.o() + 0.5D, (double)var2.p() + 0.5D, "random.click", 0.3F, var3.b(b) == aur.b?0.55F:0.5F);
         var1.a(var2, var3, 2);
         this.k(var1, var2, var3);
         return true;
      }
   }

   protected void g(World var1, Location var2, IBlock var3) {
      if(!var1.a(var2, (Block)this)) {
         int var4 = this.j(var1, var2, var3);
         TileEntity var5 = var1.s(var2);
         int var6 = var5 instanceof bcv?((bcv)var5).b():0;
         if(var4 != var6 || this.l(var3) != this.e(var1, var2, var3)) {
            if(this.i(var1, var2, var3)) {
               var1.a(var2, this, 2, -1);
            } else {
               var1.a(var2, this, 2, 0);
            }
         }

      }
   }

   private void k(World var1, Location var2, IBlock var3) {
      int var4 = this.j(var1, var2, var3);
      TileEntity var5 = var1.s(var2);
      int var6 = 0;
      if(var5 instanceof bcv) {
         bcv var7 = (bcv)var5;
         var6 = var7.b();
         var7.a(var4);
      }

      if(var6 != var4 || var3.b(b) == aur.a) {
         boolean var9 = this.e(var1, var2, var3);
         boolean var8 = this.l(var3);
         if(var8 && !var9) {
            var1.a(var2, var3.a(a, Boolean.valueOf(false)), 2);
         } else if(!var8 && var9) {
            var1.a(var2, var3.a(a, Boolean.valueOf(true)), 2);
         }

         this.h(var1, var2, var3);
      }

   }

   public void b(World var1, Location var2, IBlock var3, Random var4) {
      if(this.M) {
         var1.a(var2, this.k(var3).a(a, Boolean.valueOf(true)), 4);
      }

      this.k(var1, var2, var3);
   }

   public void c(World var1, Location var2, IBlock var3) {
      super.c(var1, var2, var3);
      var1.a(var2, this.a(var1, 0));
   }

   public void b(World var1, Location var2, IBlock var3) {
      super.b(var1, var2, var3);
      var1.t(var2);
      this.h(var1, var2, var3);
   }

   public boolean a(World var1, Location var2, IBlock var3, int var4, int var5) {
      super.a(var1, var2, var3, var4, var5);
      TileEntity var6 = var1.s(var2);
      return var6 == null?false:var6.c(var4, var5);
   }

   public TileEntity a(World var1, int var2) {
      return new bcv();
   }

   public IBlock a(int var1) {
      return this.P().a(N, EnumFacing.b(var1)).a(a, Boolean.valueOf((var1 & 8) > 0)).a(b, (var1 & 4) > 0?aur.b:aur.a);
   }

   public int c(IBlock var1) {
      byte var2 = 0;
      int var3 = var2 | ((EnumFacing)var1.b(N)).b();
      if(((Boolean)var1.b(a)).booleanValue()) {
         var3 |= 8;
      }

      if(var1.b(b) == aur.b) {
         var3 |= 4;
      }

      return var3;
   }

   protected bed e() {
      return new bed(this, new bex[]{N, b, a});
   }

   public IBlock a(World var1, Location var2, EnumFacing var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
      return this.P().a(N, var8.aO().d()).a(a, Boolean.valueOf(false)).a(b, aur.a);
   }

}
