package net.minecraft.server;
import java.util.List;
import java.util.Random;

abstract class bnn extends bms {

   protected int h = -1;
   private int a;
   private boolean b;


   public bnn() {}

   protected bnn(bnk var1, int var2) {
      super(var2);
      if(var1 != null) {
         this.b = var1.b;
      }

   }

   protected void a(NBTTagCompound var1) {
      var1.setInt("HPos", this.h);
      var1.setInt("VCount", this.a);
      var1.setBoolean("Desert", this.b);
   }

   protected void b(NBTTagCompound var1) {
      this.h = var1.getInt("HPos");
      this.a = var1.getInt("VCount");
      this.b = var1.n("Desert");
   }

   protected bms a(bnk var1, List var2, Random var3, int var4, int var5) {
      if(this.m != null) {
         switch(bmz.a[this.m.ordinal()]) {
         case 1:
            return bmy.a(var1, var2, var3, this.l.a - 1, this.l.b + var4, this.l.c + var5, EnumFacing.WEST, this.d());
         case 2:
            return bmy.a(var1, var2, var3, this.l.a - 1, this.l.b + var4, this.l.c + var5, EnumFacing.WEST, this.d());
         case 3:
            return bmy.a(var1, var2, var3, this.l.a + var5, this.l.b + var4, this.l.c - 1, EnumFacing.NORTH, this.d());
         case 4:
            return bmy.a(var1, var2, var3, this.l.a + var5, this.l.b + var4, this.l.c - 1, EnumFacing.NORTH, this.d());
         }
      }

      return null;
   }

   protected bms b(bnk var1, List var2, Random var3, int var4, int var5) {
      if(this.m != null) {
         switch(bmz.a[this.m.ordinal()]) {
         case 1:
            return bmy.a(var1, var2, var3, this.l.d + 1, this.l.b + var4, this.l.c + var5, EnumFacing.EAST, this.d());
         case 2:
            return bmy.a(var1, var2, var3, this.l.d + 1, this.l.b + var4, this.l.c + var5, EnumFacing.EAST, this.d());
         case 3:
            return bmy.a(var1, var2, var3, this.l.a + var5, this.l.b + var4, this.l.f + 1, EnumFacing.SOUTH, this.d());
         case 4:
            return bmy.a(var1, var2, var3, this.l.a + var5, this.l.b + var4, this.l.f + 1, EnumFacing.SOUTH, this.d());
         }
      }

      return null;
   }

   protected int b(World var1, bjb var2) {
      int var3 = 0;
      int var4 = 0;

      for(int var5 = this.l.c; var5 <= this.l.f; ++var5) {
         for(int var6 = this.l.a; var6 <= this.l.d; ++var6) {
            Location var7 = new Location(var6, 64, var5);
            if(var2.b((fd)var7)) {
               var3 += Math.max(var1.r(var7).o(), var1.t.i());
               ++var4;
            }
         }
      }

      if(var4 == 0) {
         return -1;
      } else {
         return var3 / var4;
      }
   }

   protected static boolean a(bjb var0) {
      return var0 != null && var0.b > 10;
   }

   protected void a(World var1, bjb var2, int var3, int var4, int var5, int var6) {
      if(this.a < var6) {
         for(int var7 = this.a; var7 < var6; ++var7) {
            int var8 = this.a(var3 + var7, var5);
            int var9 = this.d(var4);
            int var10 = this.b(var3 + var7, var5);
            if(!var2.b((fd)(new Location(var8, var9, var10)))) {
               break;
            }

            ++this.a;
            EntityVillager var11 = new EntityVillager(var1);
            var11.setPositionRotation((double)var8 + 0.5D, (double)var9, (double)var10 + 0.5D, 0.0F, 0.0F);
            var11.a(var1.E(new Location(var11)), (xq)null);
            var11.r(this.c(var7, var11.cj()));
            var1.d((Entity)var11);
         }

      }
   }

   protected int c(int var1, int var2) {
      return var2;
   }

   protected IBlock a(IBlock var1) {
      if(this.b) {
         if(var1.c() == Blocks.r || var1.c() == Blocks.s) {
            return Blocks.A.P();
         }

         if(var1.c() == Blocks.e) {
            return Blocks.A.a(bae.a.a());
         }

         if(var1.c() == Blocks.f) {
            return Blocks.A.a(bae.c.a());
         }

         if(var1.c() == Blocks.ad) {
            return Blocks.bO.P().a(BlockStairs.a, var1.b(BlockStairs.a));
         }

         if(var1.c() == Blocks.aw) {
            return Blocks.bO.P().a(BlockStairs.a, var1.b(BlockStairs.a));
         }

         if(var1.c() == Blocks.n) {
            return Blocks.A.P();
         }
      }

      return var1;
   }

   protected void a(World var1, IBlock var2, int var3, int var4, int var5, bjb var6) {
      IBlock var7 = this.a(var2);
      super.a(var1, var7, var3, var4, var5, var6);
   }

   protected void a(World var1, bjb var2, int var3, int var4, int var5, int var6, int var7, int var8, IBlock var9, IBlock var10, boolean var11) {
      IBlock var12 = this.a(var9);
      IBlock var13 = this.a(var10);
      super.a(var1, var2, var3, var4, var5, var6, var7, var8, var12, var13, var11);
   }

   protected void b(World var1, IBlock var2, int var3, int var4, int var5, bjb var6) {
      IBlock var7 = this.a(var2);
      super.b(var1, var7, var3, var4, var5, var6);
   }

   protected void a(boolean var1) {
      this.b = var1;
   }
}
