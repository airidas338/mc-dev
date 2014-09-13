package net.minecraft.server;
import java.io.IOException;


public class EntityMinecartMobSpawner extends EntityMinecartAbstract {

   private final aqi a = new aei(this);


   public EntityMinecartMobSpawner(World var1) {
      super(var1);
   }

   public EntityMinecartMobSpawner(World var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6);
   }

   public EnumMinecartType s() {
      return EnumMinecartType.SPAWNER;
   }

   public IBlock u() {
      return aty.ac.P();
   }

   protected void a(fn var1) {
      super.a(var1);
      this.a.a(var1);
   }

   protected void b(fn var1) {
      super.b(var1);
      this.a.b(var1);
   }

   public void s_() throws IOException {
      super.s_();
      this.a.c();
   }
}