package net.minecraft.server;
import java.util.Random;

public class ayy extends awt {

   public static final bev a = bev.a("axis", el.class, (Enum[])(new el[]{el.a, el.c}));


   public ayy() {
      super(Material.E, false);
      this.j(this.L.b().a(a, el.a));
      this.a(true);
   }

   public void b(World var1, Location var2, IBlock var3, Random var4) {
      super.b(var1, var2, var3, var4);
      if(var1.t.d() && var1.Q().b("doMobSpawning") && var4.nextInt(2000) < var1.aa().a()) {
         int var5 = var2.o();

         Location var6;
         for(var6 = var2; !World.a((ard)var1, var6) && var6.o() > 0; var6 = var6.b()) {
            ;
         }

         if(var5 > 0 && !var1.p(var6.a()).c().t()) {
            Entity var7 = anl.a(var1, 57, (double)var6.n() + 0.5D, (double)var6.o() + 1.1D, (double)var6.p() + 0.5D);
            if(var7 != null) {
               var7.aj = var7.ar();
            }
         }
      }

   }

   public AxisAlignedBB a(World var1, Location var2, IBlock var3) {
      return null;
   }

   public void a(ard var1, Location var2) {
      el var3 = (el)var1.p(var2).b(a);
      float var4 = 0.125F;
      float var5 = 0.125F;
      if(var3 == el.a) {
         var4 = 0.5F;
      }

      if(var3 == el.c) {
         var5 = 0.5F;
      }

      this.a(0.5F - var4, 0.0F, 0.5F - var5, 0.5F + var4, 1.0F, 0.5F + var5);
   }

   public static int a(el var0) {
      return var0 == el.a?1:(var0 == el.c?2:0);
   }

   public boolean d() {
      return false;
   }

   public boolean d(World var1, Location var2) {
      ayz var3 = new ayz(var1, var2, el.a);
      if(var3.b() && ayz.a(var3) == 0) {
         var3.c();
         return true;
      } else {
         ayz var4 = new ayz(var1, var2, el.c);
         if(var4.b() && ayz.a(var4) == 0) {
            var4.c();
            return true;
         } else {
            return false;
         }
      }
   }

   public void a(World var1, Location var2, IBlock var3, Block var4) {
      el var5 = (el)var3.b(a);
      ayz var6;
      if(var5 == el.a) {
         var6 = new ayz(var1, var2, el.a);
         if(!var6.b() || ayz.a(var6) < ayz.b(var6) * ayz.c(var6)) {
            var1.a(var2, aty.a.P());
         }
      } else if(var5 == el.c) {
         var6 = new ayz(var1, var2, el.c);
         if(!var6.b() || ayz.a(var6) < ayz.b(var6) * ayz.c(var6)) {
            var1.a(var2, aty.a.P());
         }
      }

   }

   public int a(Random var1) {
      return 0;
   }

   public void a(World var1, Location var2, IBlock var3, Entity var4) {
      if(var4.m == null && var4.l == null) {
         var4.aq();
      }

   }

   public IBlock a(int var1) {
      return this.P().a(a, (var1 & 3) == 2?el.c:el.a);
   }

   public int c(IBlock var1) {
      return a((el)var1.b(a));
   }

   protected bed e() {
      return new bed(this, new bex[]{a});
   }

}
