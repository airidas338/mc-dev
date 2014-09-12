package net.minecraft.server;

public class avc extends Block {

   public static final bev a = bev.a("variant", avd.class);
   public static final bet b = bet.a("snowy");


   protected avc() {
      super(Material.c);
      this.j(this.L.b().a(a, avd.a).a(b, Boolean.valueOf(false)));
      this.a(akf.b);
   }

   public IBlock a(IBlock var1, ard var2, Location var3) {
      if(var1.b(a) == avd.c) {
         Block var4 = var2.p(var3.a()).c();
         var1 = var1.a(b, Boolean.valueOf(var4 == aty.aJ || var4 == aty.aH));
      }

      return var1;
   }

   public int j(World var1, Location var2) {
      IBlock var3 = var1.p(var2);
      return var3.c() != this?0:((avd)var3.b(a)).a();
   }

   public IBlock a(int var1) {
      return this.P().a(a, avd.a(var1));
   }

   public int c(IBlock var1) {
      return ((avd)var1.b(a)).a();
   }

   protected bed e() {
      return new bed(this, new bex[]{a, b});
   }

   public int a(IBlock var1) {
      avd var2 = (avd)var1.b(a);
      if(var2 == avd.c) {
         var2 = avd.a;
      }

      return var2.a();
   }

}
