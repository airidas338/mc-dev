package net.minecraft.server;
import com.google.common.base.Predicate;

public abstract class BlockFlowers extends BlockPlant {

   protected bev a;


   protected BlockFlowers() {
      super(Material.PLANT);
      this.j(this.L.b().a(this.l(), this.j() == awc.b?EnumFlowerType.b:EnumFlowerType.a));
   }

   public int a(IBlock var1) {
      return ((EnumFlowerType)var1.b(this.l())).b();
   }

   public IBlock a(int var1) {
      return this.P().a(this.l(), EnumFlowerType.a(this.j(), var1));
   }

   public abstract awc j();

   public bex l() {
      if(this.a == null) {
         this.a = bev.a("type", EnumFlowerType.class, (Predicate)(new avz(this)));
      }

      return this.a;
   }

   public int c(IBlock var1) {
      return ((EnumFlowerType)var1.b(this.l())).b();
   }

   protected bed e() {
      return new bed(this, new bex[]{this.l()});
   }
}
