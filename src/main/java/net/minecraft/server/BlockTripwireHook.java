package net.minecraft.server;
import com.google.common.base.Objects;
import com.google.common.base.Predicate;

import java.util.Iterator;
import java.util.Random;

public class BlockTripwireHook extends Block {

   public static final beu a = beu.a("facing", (Predicate)en.a);
   public static final bet b = bet.a("powered");
   public static final bet M = bet.a("attached");
   public static final bet N = bet.a("suspended");


   public BlockTripwireHook() {
      super(Material.ORIENTABLE);
      this.j(this.L.b().a(a, EnumFacing.NORTH).a(b, Boolean.valueOf(false)).a(M, Boolean.valueOf(false)).a(N, Boolean.valueOf(false)));
      this.a(CreativeModeTab.d);
      this.a(true);
   }

   public IBlockData a(IBlockData var1, IBlockAccess var2, Location var3) {
      return var1.a(N, Boolean.valueOf(!World.a(var2, var3.b())));
   }

   public AxisAlignedBB a(World var1, Location var2, IBlockData var3) {
      return null;
   }

   public boolean c() {
      return false;
   }

   public boolean d() {
      return false;
   }

   public boolean a(World var1, Location var2, EnumFacing var3) {
      return var3.k().c() && var1.getData(var2.a(var3.d())).c().t();
   }

   public boolean c(World var1, Location var2) {
      Iterator var3 = en.a.iterator();

      EnumFacing var4;
      do {
         if(!var3.hasNext()) {
            return false;
         }

         var4 = (EnumFacing)var3.next();
      } while(!var1.getData(var2.a(var4)).c().t());

      return true;
   }

   public IBlockData a(World var1, Location var2, EnumFacing var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
      IBlockData var9 = this.P().a(b, Boolean.valueOf(false)).a(M, Boolean.valueOf(false)).a(N, Boolean.valueOf(false));
      if(var3.k().c()) {
         var9 = var9.a(a, var3);
      }

      return var9;
   }

   public void a(World var1, Location var2, IBlockData var3, EntityLiving var4, ItemStack var5) {
      this.a(var1, var2, var3, false, false, -1, (IBlockData)null);
   }

   public void a(World var1, Location var2, IBlockData var3, Block var4) {
      if(var4 != this) {
         if(this.e(var1, var2, var3)) {
            EnumFacing var5 = (EnumFacing)var3.b(a);
            if(!var1.getData(var2.a(var5.d())).c().t()) {
               this.b(var1, var2, var3, 0);
               var1.g(var2);
            }
         }

      }
   }

   public void a(World var1, Location var2, IBlockData var3, boolean var4, boolean var5, int var6, IBlockData var7) {
      EnumFacing var8 = (EnumFacing)var3.b(a);
      boolean var9 = ((Boolean)var3.b(M)).booleanValue();
      boolean var10 = ((Boolean)var3.b(b)).booleanValue();
      boolean var11 = !World.a((IBlockAccess)var1, var2.b());
      boolean var12 = !var4;
      boolean var13 = false;
      int var14 = 0;
      IBlockData[] var15 = new IBlockData[42];

      Location var17;
      for(int var16 = 1; var16 < 42; ++var16) {
         var17 = var2.a(var8, var16);
         IBlockData var18 = var1.getData(var17);
         if(var18.c() == Blocks.TRIPWIRE_HOOK) {
            if(var18.b(a) == var8.d()) {
               var14 = var16;
            }
            break;
         }

         if(var18.c() != Blocks.TRIPWIRE && var16 != var6) {
            var15[var16] = null;
            var12 = false;
         } else {
            if(var16 == var6) {
               var18 = (IBlockData)Objects.firstNonNull(var7, var18);
            }

            boolean var19 = !((Boolean)var18.b(BlockTripwire.N)).booleanValue();
            boolean var20 = ((Boolean)var18.b(BlockTripwire.a)).booleanValue();
            boolean var21 = ((Boolean)var18.b(BlockTripwire.b)).booleanValue();
            var12 &= var21 == var11;
            var13 |= var19 && var20;
            var15[var16] = var18;
            if(var16 == var6) {
               var1.a(var2, (Block)this, this.a(var1));
               var12 &= var19;
            }
         }
      }

      var12 &= var14 > 1;
      var13 &= var12;
      IBlockData var22 = this.P().a(M, Boolean.valueOf(var12)).a(b, Boolean.valueOf(var13));
      if(var14 > 0) {
         var17 = var2.a(var8, var14);
         EnumFacing var26 = var8.d();
         var1.a(var17, var22.a(a, var26), 3);
         this.b(var1, var17, var26);
         this.a(var1, var17, var12, var13, var9, var10);
      }

      this.a(var1, var2, var12, var13, var9, var10);
      if(!var4) {
         var1.a(var2, var22.a(a, var8), 3);
         if(var5) {
            this.b(var1, var2, var8);
         }
      }

      if(var9 != var12) {
         for(int var23 = 1; var23 < var14; ++var23) {
            Location var24 = var2.a(var8, var23);
            IBlockData var25 = var15[var23];
            if(var25 != null && var1.getData(var24).c() != Blocks.AIR) {
               var1.a(var24, var25.a(M, Boolean.valueOf(var12)), 3);
            }
         }
      }

   }

   public void a(World var1, Location var2, IBlockData var3, Random var4) {}

   public void b(World var1, Location var2, IBlockData var3, Random var4) {
      this.a(var1, var2, var3, false, true, -1, (IBlockData)null);
   }

   private void a(World var1, Location var2, boolean var3, boolean var4, boolean var5, boolean var6) {
      if(var4 && !var6) {
         var1.a((double)var2.n() + 0.5D, (double)var2.o() + 0.1D, (double)var2.p() + 0.5D, "random.click", 0.4F, 0.6F);
      } else if(!var4 && var6) {
         var1.a((double)var2.n() + 0.5D, (double)var2.o() + 0.1D, (double)var2.p() + 0.5D, "random.click", 0.4F, 0.5F);
      } else if(var3 && !var5) {
         var1.a((double)var2.n() + 0.5D, (double)var2.o() + 0.1D, (double)var2.p() + 0.5D, "random.click", 0.4F, 0.7F);
      } else if(!var3 && var5) {
         var1.a((double)var2.n() + 0.5D, (double)var2.o() + 0.1D, (double)var2.p() + 0.5D, "random.bowhit", 0.4F, 1.2F / (var1.random.nextFloat() * 0.2F + 0.9F));
      }

   }

   private void b(World var1, Location var2, EnumFacing var3) {
      var1.c(var2, (Block)this);
      var1.c(var2.a(var3.d()), (Block)this);
   }

   private boolean e(World var1, Location var2, IBlockData var3) {
      if(!this.c(var1, var2)) {
         this.b(var1, var2, var3, 0);
         var1.g(var2);
         return false;
      } else {
         return true;
      }
   }

   public void a(IBlockAccess var1, Location var2) {
      float var3 = 0.1875F;
      switch(bbu.a[((EnumFacing)var1.getData(var2).b(a)).ordinal()]) {
      case 1:
         this.a(0.0F, 0.2F, 0.5F - var3, var3 * 2.0F, 0.8F, 0.5F + var3);
         break;
      case 2:
         this.a(1.0F - var3 * 2.0F, 0.2F, 0.5F - var3, 1.0F, 0.8F, 0.5F + var3);
         break;
      case 3:
         this.a(0.5F - var3, 0.2F, 0.0F, 0.5F + var3, 0.8F, var3 * 2.0F);
         break;
      case 4:
         this.a(0.5F - var3, 0.2F, 1.0F - var3 * 2.0F, 0.5F + var3, 0.8F, 1.0F);
      }

   }

   public void b(World var1, Location var2, IBlockData var3) {
      boolean var4 = ((Boolean)var3.b(M)).booleanValue();
      boolean var5 = ((Boolean)var3.b(b)).booleanValue();
      if(var4 || var5) {
         this.a(var1, var2, var3, true, false, -1, (IBlockData)null);
      }

      if(var5) {
         var1.c(var2, (Block)this);
         var1.c(var2.a(((EnumFacing)var3.b(a)).d()), (Block)this);
      }

      super.b(var1, var2, var3);
   }

   public int a(IBlockAccess var1, Location var2, IBlockData var3, EnumFacing var4) {
      return ((Boolean)var3.b(b)).booleanValue()?15:0;
   }

   public int b(IBlockAccess var1, Location var2, IBlockData var3, EnumFacing var4) {
      return !((Boolean)var3.b(b)).booleanValue()?0:(var3.b(a) == var4?15:0);
   }

   public boolean g() {
      return true;
   }

   public IBlockData a(int var1) {
      return this.P().a(a, EnumFacing.b(var1 & 3)).a(b, Boolean.valueOf((var1 & 8) > 0)).a(M, Boolean.valueOf((var1 & 4) > 0));
   }

   public int c(IBlockData var1) {
      byte var2 = 0;
      int var3 = var2 | ((EnumFacing)var1.b(a)).b();
      if(((Boolean)var1.b(b)).booleanValue()) {
         var3 |= 8;
      }

      if(((Boolean)var1.b(M)).booleanValue()) {
         var3 |= 4;
      }

      return var3;
   }

   protected bed e() {
      return new bed(this, new bex[]{a, b, M, N});
   }

}
