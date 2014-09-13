package net.minecraft.server;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class BlockRedstoneWire extends Block {

   public static final bev a = bev.a("north", azu.class);
   public static final bev b = bev.a("east", azu.class);
   public static final bev M = bev.a("south", azu.class);
   public static final bev N = bev.a("west", azu.class);
   public static final bew O = bew.a("power", 0, 15);
   private boolean P = true;
   private final Set Q = Sets.newHashSet();


   public BlockRedstoneWire() {
      super(Material.ORIENTABLE);
      this.j(this.L.b().a(a, azu.c).a(b, azu.c).a(M, azu.c).a(N, azu.c).a(O, Integer.valueOf(0)));
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
   }

   public IBlock a(IBlock var1, IBlockAccess var2, Location var3) {
      var1 = var1.a(N, this.c(var2, var3, EnumFacing.WEST));
      var1 = var1.a(b, this.c(var2, var3, EnumFacing.EAST));
      var1 = var1.a(a, this.c(var2, var3, EnumFacing.NORTH));
      var1 = var1.a(M, this.c(var2, var3, EnumFacing.SOUTH));
      return var1;
   }

   private azu c(IBlockAccess var1, Location var2, EnumFacing var3) {
      Location var4 = var2.a(var3);
      Block var5 = var1.getData(var2.a(var3)).c();
      if(!a(var1.getData(var4), var3) && (var5.s() || !d(var1.getData(var4.b())))) {
         Block var6 = var1.getData(var2.a()).c();
         return !var6.s() && var5.s() && d(var1.getData(var4.a()))?azu.a:azu.c;
      } else {
         return azu.b;
      }
   }

   public AxisAlignedBB a(World var1, Location var2, IBlock var3) {
      return null;
   }

   public boolean c() {
      return false;
   }

   public boolean d() {
      return false;
   }

   public boolean c(World var1, Location var2) {
      return World.a((IBlockAccess)var1, var2.b()) || var1.getData(var2.b()).c() == Blocks.GLOWSTONE;
   }

   private IBlock e(World var1, Location var2, IBlock var3) {
      var3 = this.a(var1, var2, var2, var3);
      ArrayList var4 = Lists.newArrayList(this.Q);
      this.Q.clear();
      Iterator var5 = var4.iterator();

      while(var5.hasNext()) {
         Location var6 = (Location)var5.next();
         var1.c(var6, (Block)this);
      }

      return var3;
   }

   private IBlock a(World var1, Location var2, Location var3, IBlock var4) {
      IBlock var5 = var4;
      int var6 = ((Integer)var4.b(O)).intValue();
      byte var7 = 0;
      int var14 = this.a(var1, var3, var7);
      this.P = false;
      int var8 = var1.A(var2);
      this.P = true;
      if(var8 > 0 && var8 > var14 - 1) {
         var14 = var8;
      }

      int var9 = 0;
      Iterator var10 = en.a.iterator();

      while(var10.hasNext()) {
         EnumFacing var11 = (EnumFacing)var10.next();
         Location var12 = var2.a(var11);
         boolean var13 = var12.n() != var3.n() || var12.p() != var3.p();
         if(var13) {
            var9 = this.a(var1, var12, var9);
         }

         if(var1.getData(var12).c().t() && !var1.getData(var2.a()).c().t()) {
            if(var13 && var2.o() >= var3.o()) {
               var9 = this.a(var1, var12.a(), var9);
            }
         } else if(!var1.getData(var12).c().t() && var13 && var2.o() <= var3.o()) {
            var9 = this.a(var1, var12.b(), var9);
         }
      }

      if(var9 > var14) {
         var14 = var9 - 1;
      } else if(var14 > 0) {
         --var14;
      } else {
         var14 = 0;
      }

      if(var8 > var14 - 1) {
         var14 = var8;
      }

      if(var6 != var14) {
         var4 = var4.a(O, Integer.valueOf(var14));
         if(var1.getData(var2) == var5) {
            var1.a(var2, var4, 2);
         }

         this.Q.add(var2);
         EnumFacing[] var16 = EnumFacing.values();
         int var15 = var16.length;

         for(int var17 = 0; var17 < var15; ++var17) {
            EnumFacing var18 = var16[var17];
            this.Q.add(var2.a(var18));
         }
      }

      return var4;
   }

   private void d(World var1, Location var2) {
      if(var1.getData(var2).c() == this) {
         var1.c(var2, (Block)this);
         EnumFacing[] var3 = EnumFacing.values();
         int var4 = var3.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            EnumFacing var6 = var3[var5];
            var1.c(var2.a(var6), (Block)this);
         }

      }
   }

   public void c(World var1, Location var2, IBlock var3) {
      if(!var1.D) {
         this.e(var1, var2, var3);
         Iterator var4 = en.b.iterator();

         EnumFacing var5;
         while(var4.hasNext()) {
            var5 = (EnumFacing)var4.next();
            var1.c(var2.a(var5), (Block)this);
         }

         var4 = en.a.iterator();

         while(var4.hasNext()) {
            var5 = (EnumFacing)var4.next();
            this.d(var1, var2.a(var5));
         }

         var4 = en.a.iterator();

         while(var4.hasNext()) {
            var5 = (EnumFacing)var4.next();
            Location var6 = var2.a(var5);
            if(var1.getData(var6).c().t()) {
               this.d(var1, var6.a());
            } else {
               this.d(var1, var6.b());
            }
         }

      }
   }

   public void b(World var1, Location var2, IBlock var3) {
      super.b(var1, var2, var3);
      if(!var1.D) {
         EnumFacing[] var4 = EnumFacing.values();
         int var5 = var4.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            EnumFacing var7 = var4[var6];
            var1.c(var2.a(var7), (Block)this);
         }

         this.e(var1, var2, var3);
         Iterator var8 = en.a.iterator();

         EnumFacing var9;
         while(var8.hasNext()) {
            var9 = (EnumFacing)var8.next();
            this.d(var1, var2.a(var9));
         }

         var8 = en.a.iterator();

         while(var8.hasNext()) {
            var9 = (EnumFacing)var8.next();
            Location var10 = var2.a(var9);
            if(var1.getData(var10).c().t()) {
               this.d(var1, var10.a());
            } else {
               this.d(var1, var10.b());
            }
         }

      }
   }

   private int a(World var1, Location var2, int var3) {
      if(var1.getData(var2).c() != this) {
         return var3;
      } else {
         int var4 = ((Integer)var1.getData(var2).b(O)).intValue();
         return var4 > var3?var4:var3;
      }
   }

   public void a(World var1, Location var2, IBlock var3, Block var4) {
      if(!var1.D) {
         if(this.c(var1, var2)) {
            this.e(var1, var2, var3);
         } else {
            this.b(var1, var2, var3, 0);
            var1.g(var2);
         }

      }
   }

   public Item a(IBlock var1, Random var2, int var3) {
      return Items.aC;
   }

   public int b(IBlockAccess var1, Location var2, IBlock var3, EnumFacing var4) {
      return !this.P?0:this.a(var1, var2, var3, var4);
   }

   public int a(IBlockAccess var1, Location var2, IBlock var3, EnumFacing var4) {
      if(!this.P) {
         return 0;
      } else {
         int var5 = ((Integer)var3.b(O)).intValue();
         if(var5 == 0) {
            return 0;
         } else if(var4 == EnumFacing.UP) {
            return var5;
         } else {
            EnumSet var6 = EnumSet.noneOf(EnumFacing.class);
            Iterator var7 = en.a.iterator();

            while(var7.hasNext()) {
               EnumFacing var8 = (EnumFacing)var7.next();
               if(this.d(var1, var2, var8)) {
                  var6.add(var8);
               }
            }

            if(var4.k().c() && var6.isEmpty()) {
               return var5;
            } else if(var6.contains(var4) && !var6.contains(var4.f()) && !var6.contains(var4.e())) {
               return var5;
            } else {
               return 0;
            }
         }
      }
   }

   private boolean d(IBlockAccess var1, Location var2, EnumFacing var3) {
      Location var4 = var2.a(var3);
      IBlock var5 = var1.getData(var4);
      Block var6 = var5.c();
      boolean var7 = var6.t();
      boolean var8 = var1.getData(var2.a()).c().t();
      return !var8 && var7 && e(var1, var4.a())?true:(a(var5, var3)?true:(var6 == Blocks.DIODE_ON && var5.b(ava.N) == var3?true:!var7 && e(var1, var4.b())));
   }

   protected static boolean e(IBlockAccess var0, Location var1) {
      return d(var0.getData(var1));
   }

   protected static boolean d(IBlock var0) {
      return a(var0, (EnumFacing)null);
   }

   protected static boolean a(IBlock var0, EnumFacing var1) {
      Block var2 = var0.c();
      if(var2 == Blocks.REDSTONE_WIRE) {
         return true;
      } else if(Blocks.DIODE_OFF.e(var2)) {
         EnumFacing var3 = (EnumFacing)var0.b(BlockRepeater.N);
         return var3 == var1 || var3.d() == var1;
      } else {
         return var2.g() && var1 != null;
      }
   }

   public boolean g() {
      return this.P;
   }

   public IBlock a(int var1) {
      return this.P().a(O, Integer.valueOf(var1));
   }

   public int c(IBlock var1) {
      return ((Integer)var1.b(O)).intValue();
   }

   protected bed e() {
      return new bed(this, new bex[]{a, b, M, N, O});
   }

}
