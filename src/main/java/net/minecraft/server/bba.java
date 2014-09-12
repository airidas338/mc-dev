package net.minecraft.server;
import java.util.Random;

public class bba extends Block {

   public static final bev a = bev.a("variant", bbb.class);


   public bba() {
      super(Material.e);
      this.j(this.L.b().a(a, bbb.a));
      this.a(akf.b);
   }

   public alq a(IBlock var1, Random var2, int var3) {
      return var1.b(a) == bbb.a?alq.a(aty.e):alq.a(aty.b);
   }

   public int a(IBlock var1) {
      return ((bbb)var1.b(a)).a();
   }

   public IBlock a(int var1) {
      return this.P().a(a, bbb.a(var1));
   }

   public int c(IBlock var1) {
      return ((bbb)var1.b(a)).a();
   }

   protected bed e() {
      return new bed(this, new bex[]{a});
   }

}
