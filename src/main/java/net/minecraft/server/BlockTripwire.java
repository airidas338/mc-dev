package net.minecraft.server;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class BlockTripwire extends Block {

   public static final bet a = bet.a("powered");
   public static final bet b = bet.a("suspended");
   public static final bet M = bet.a("attached");
   public static final bet N = bet.a("disarmed");
   public static final bet O = bet.a("north");
   public static final bet P = bet.a("east");
   public static final bet Q = bet.a("south");
   public static final bet R = bet.a("west");


   public BlockTripwire() {
      super(Material.ORIENTABLE);
      this.j(this.L.b().a(a, Boolean.valueOf(false)).a(b, Boolean.valueOf(false)).a(M, Boolean.valueOf(false)).a(N, Boolean.valueOf(false)).a(O, Boolean.valueOf(false)).a(P, Boolean.valueOf(false)).a(Q, Boolean.valueOf(false)).a(R, Boolean.valueOf(false)));
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.15625F, 1.0F);
      this.a(true);
   }

   public IBlockData a(IBlockData var1, IBlockAccess var2, Location var3) {
      return var1.a(O, Boolean.valueOf(c(var2, var3, var1, EnumFacing.NORTH))).a(P, Boolean.valueOf(c(var2, var3, var1, EnumFacing.EAST))).a(Q, Boolean.valueOf(c(var2, var3, var1, EnumFacing.SOUTH))).a(R, Boolean.valueOf(c(var2, var3, var1, EnumFacing.WEST)));
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

   public Item a(IBlockData var1, Random var2, int var3) {
      return Items.STRING;
   }

   public void doPhysics(World var1, Location var2, IBlockData var3, Block var4) {
      boolean var5 = ((Boolean)var3.b(b)).booleanValue();
      boolean var6 = !World.a((IBlockAccess)var1, var2.b());
      if(var5 != var6) {
         this.b(var1, var2, var3, 0);
         var1.setAir(var2);
      }

   }

   public void updateShape(IBlockAccess var1, Location var2) {
      IBlockData var3 = var1.getData(var2);
      boolean var4 = ((Boolean)var3.b(M)).booleanValue();
      boolean var5 = ((Boolean)var3.b(b)).booleanValue();
      if(!var5) {
         this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.09375F, 1.0F);
      } else if(!var4) {
         this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
      } else {
         this.a(0.0F, 0.0625F, 0.0F, 1.0F, 0.15625F, 1.0F);
      }

   }

   public void onPlace(World var1, Location var2, IBlockData var3) {
      var3 = var3.a(b, Boolean.valueOf(!World.a((IBlockAccess)var1, var2.b())));
      var1.setTypeAndData(var2, var3, 3);
      this.e(var1, var2, var3);
   }

   public void remove(World var1, Location var2, IBlockData var3) {
      this.e(var1, var2, var3.a(a, Boolean.valueOf(true)));
   }

   public void a(World var1, Location var2, IBlockData var3, EntityHuman var4) {
      if(!var1.isStatic) {
         if(var4.bY() != null && var4.bY().getItem() == Items.be) {
            var1.setTypeAndData(var2, var3.a(N, Boolean.valueOf(true)), 4);
         }

      }
   }

   private void e(World var1, Location var2, IBlockData var3) {
      EnumFacing[] var4 = new EnumFacing[]{EnumFacing.SOUTH, EnumFacing.WEST};
      int var5 = var4.length;
      int var6 = 0;

      while(var6 < var5) {
         EnumFacing var7 = var4[var6];
         int var8 = 1;

         while(true) {
            if(var8 < 42) {
               Location var9 = var2.a(var7, var8);
               IBlockData var10 = var1.getData(var9);
               if(var10.c() == Blocks.TRIPWIRE_HOOK) {
                  if(var10.b(BlockTripwireHook.a) == var7.d()) {
                     Blocks.TRIPWIRE_HOOK.a(var1, var9, var10, false, true, var8, var3);
                  }
               } else if(var10.c() == Blocks.TRIPWIRE) {
                  ++var8;
                  continue;
               }
            }

            ++var6;
            break;
         }
      }

   }

   public void a(World var1, Location var2, IBlockData var3, Entity var4) {
      if(!var1.isStatic) {
         if(!((Boolean)var3.b(a)).booleanValue()) {
            this.d(var1, var2);
         }
      }
   }

   public void a(World var1, Location var2, IBlockData var3, Random var4) {}

   public void b(World var1, Location var2, IBlockData var3, Random var4) {
      if(!var1.isStatic) {
         if(((Boolean)var1.getData(var2).b(a)).booleanValue()) {
            this.d(var1, var2);
         }
      }
   }

   private void d(World var1, Location var2) {
      IBlockData var3 = var1.getData(var2);
      boolean var4 = ((Boolean)var3.b(a)).booleanValue();
      boolean var5 = false;
      List var6 = var1.b((Entity)null, new AxisAlignedBB((double)var2.n() + this.B, (double)var2.o() + this.C, (double)var2.p() + this.D, (double)var2.n() + this.E, (double)var2.o() + this.F, (double)var2.p() + this.G));
      if(!var6.isEmpty()) {
         Iterator var7 = var6.iterator();

         while(var7.hasNext()) {
            Entity var8 = (Entity)var7.next();
            if(!var8.aH()) {
               var5 = true;
               break;
            }
         }
      }

      if(var5 != var4) {
         var3 = var3.a(a, Boolean.valueOf(var5));
         var1.setTypeAndData(var2, var3, 3);
         this.e(var1, var2, var3);
      }

      if(var5) {
         var1.a(var2, (Block)this, this.a(var1));
      }

   }

   public static boolean c(IBlockAccess var0, Location var1, IBlockData var2, EnumFacing var3) {
      Location var4 = var1.a(var3);
      IBlockData var5 = var0.getData(var4);
      Block var6 = var5.c();
      if(var6 == Blocks.TRIPWIRE_HOOK) {
         EnumFacing var9 = var3.d();
         return var5.b(BlockTripwireHook.a) == var9;
      } else if(var6 == Blocks.TRIPWIRE) {
         boolean var7 = ((Boolean)var2.b(b)).booleanValue();
         boolean var8 = ((Boolean)var5.b(b)).booleanValue();
         return var7 == var8;
      } else {
         return false;
      }
   }

   public IBlockData a(int var1) {
      return this.P().a(a, Boolean.valueOf((var1 & 1) > 0)).a(b, Boolean.valueOf((var1 & 2) > 0)).a(M, Boolean.valueOf((var1 & 4) > 0)).a(N, Boolean.valueOf((var1 & 8) > 0));
   }

   public int c(IBlockData var1) {
      int var2 = 0;
      if(((Boolean)var1.b(a)).booleanValue()) {
         var2 |= 1;
      }

      if(((Boolean)var1.b(b)).booleanValue()) {
         var2 |= 2;
      }

      if(((Boolean)var1.b(M)).booleanValue()) {
         var2 |= 4;
      }

      if(((Boolean)var1.b(N)).booleanValue()) {
         var2 |= 8;
      }

      return var2;
   }

   protected bed e() {
      return new bed(this, new bex[]{a, b, M, N, O, P, R, Q});
   }

}
