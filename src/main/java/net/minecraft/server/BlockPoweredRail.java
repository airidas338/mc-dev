package net.minecraft.server;
import com.google.common.base.Predicate;

public class BlockPoweredRail extends ati {

   public static final bev b = bev.a("shape", atl.class, (Predicate)(new azd()));
   public static final bet M = bet.a("powered");


   protected BlockPoweredRail() {
      super(true);
      this.j(this.L.b().a(b, atl.a).a(M, Boolean.valueOf(false)));
   }

   protected boolean a(World var1, Location var2, IBlock var3, boolean var4, int var5) {
      if(var5 >= 8) {
         return false;
      } else {
         int var6 = var2.n();
         int var7 = var2.o();
         int var8 = var2.p();
         boolean var9 = true;
         atl var10 = (atl)var3.b(b);
         switch(aze.a[var10.ordinal()]) {
         case 1:
            if(var4) {
               ++var8;
            } else {
               --var8;
            }
            break;
         case 2:
            if(var4) {
               --var6;
            } else {
               ++var6;
            }
            break;
         case 3:
            if(var4) {
               --var6;
            } else {
               ++var6;
               ++var7;
               var9 = false;
            }

            var10 = atl.b;
            break;
         case 4:
            if(var4) {
               --var6;
               ++var7;
               var9 = false;
            } else {
               ++var6;
            }

            var10 = atl.b;
            break;
         case 5:
            if(var4) {
               ++var8;
            } else {
               --var8;
               ++var7;
               var9 = false;
            }

            var10 = atl.a;
            break;
         case 6:
            if(var4) {
               ++var8;
               ++var7;
               var9 = false;
            } else {
               --var8;
            }

            var10 = atl.a;
         }

         return this.a(var1, new Location(var6, var7, var8), var4, var5, var10)?true:var9 && this.a(var1, new Location(var6, var7 - 1, var8), var4, var5, var10);
      }
   }

   protected boolean a(World var1, Location var2, boolean var3, int var4, atl var5) {
      IBlock var6 = var1.getData(var2);
      if(var6.c() != this) {
         return false;
      } else {
         atl var7 = (atl)var6.b(b);
         return var5 == atl.b && (var7 == atl.a || var7 == atl.e || var7 == atl.f)?false:(var5 == atl.a && (var7 == atl.b || var7 == atl.c || var7 == atl.d)?false:(((Boolean)var6.b(M)).booleanValue()?(var1.z(var2)?true:this.a(var1, var2, var6, var3, var4 + 1)):false));
      }
   }

   protected void b(World var1, Location var2, IBlock var3, Block var4) {
      boolean var5 = ((Boolean)var3.b(M)).booleanValue();
      boolean var6 = var1.z(var2) || this.a(var1, var2, var3, true, 0) || this.a(var1, var2, var3, false, 0);
      if(var6 != var5) {
         var1.a(var2, var3.a(M, Boolean.valueOf(var6)), 3);
         var1.c(var2.b(), (Block)this);
         if(((atl)var3.b(b)).c()) {
            var1.c(var2.a(), (Block)this);
         }
      }

   }

   public bex l() {
      return b;
   }

   public IBlock a(int var1) {
      return this.P().a(b, atl.a(var1 & 7)).a(M, Boolean.valueOf((var1 & 8) > 0));
   }

   public int c(IBlock var1) {
      byte var2 = 0;
      int var3 = var2 | ((atl)var1.b(b)).a();
      if(((Boolean)var1.b(M)).booleanValue()) {
         var3 |= 8;
      }

      return var3;
   }

   protected bed e() {
      return new bed(this, new bex[]{b, M});
   }

}
