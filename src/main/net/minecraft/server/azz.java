package net.minecraft.server;
import java.util.Random;

public class azz extends ava {

   public static final bet a = bet.a("locked");
   public static final bew b = bew.a("delay", 1, 4);


   protected azz(boolean var1) {
      super(var1);
      this.j(this.L.b().a(N, ej.c).a(b, Integer.valueOf(1)).a(a, Boolean.valueOf(false)));
   }

   public IBlock a(IBlock var1, ard var2, Location var3) {
      return var1.a(a, Boolean.valueOf(this.b(var2, var3, var1)));
   }

   public boolean a(World var1, Location var2, IBlock var3, EntityHuman var4, ej var5, float var6, float var7, float var8) {
      if(!var4.by.e) {
         return false;
      } else {
         var1.a(var2, var3.a(b), 3);
         return true;
      }
   }

   protected int d(IBlock var1) {
      return ((Integer)var1.b(b)).intValue() * 2;
   }

   protected IBlock e(IBlock var1) {
      Integer var2 = (Integer)var1.b(b);
      Boolean var3 = (Boolean)var1.b(a);
      ej var4 = (ej)var1.b(N);
      return aty.bc.P().a(N, var4).a(b, var2).a(a, var3);
   }

   protected IBlock k(IBlock var1) {
      Integer var2 = (Integer)var1.b(b);
      Boolean var3 = (Boolean)var1.b(a);
      ej var4 = (ej)var1.b(N);
      return aty.bb.P().a(N, var4).a(b, var2).a(a, var3);
   }

   public alq a(IBlock var1, Random var2, int var3) {
      return Items.bb;
   }

   public boolean b(ard var1, Location var2, IBlock var3) {
      return this.c(var1, var2, var3) > 0;
   }

   protected boolean c(Block var1) {
      return d(var1);
   }

   public void b(World var1, Location var2, IBlock var3) {
      super.b(var1, var2, var3);
      this.h(var1, var2, var3);
   }

   public IBlock a(int var1) {
      return this.P().a(N, ej.b(var1)).a(a, Boolean.valueOf(false)).a(b, Integer.valueOf(1 + (var1 >> 2)));
   }

   public int c(IBlock var1) {
      byte var2 = 0;
      int var3 = var2 | ((ej)var1.b(N)).b();
      var3 |= ((Integer)var1.b(b)).intValue() - 1 << 2;
      return var3;
   }

   protected bed e() {
      return new bed(this, new bex[]{N, b, a});
   }

}
