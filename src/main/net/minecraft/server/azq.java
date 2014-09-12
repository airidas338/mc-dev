package net.minecraft.server;

public class azq extends Block {

   public static final bev a = bev.a("type", azr.class);


   public azq() {
      super(Material.e);
      this.j(this.L.b().a(a, azr.a));
      this.a(akf.b);
   }

   public int a(IBlock var1) {
      return ((azr)var1.b(a)).a();
   }

   public IBlock a(int var1) {
      return this.P().a(a, azr.a(var1));
   }

   public int c(IBlock var1) {
      return ((azr)var1.b(a)).a();
   }

   protected bed e() {
      return new bed(this, new bex[]{a});
   }

}
